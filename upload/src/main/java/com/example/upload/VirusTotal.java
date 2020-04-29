package com.example.upload;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import org.springframework.boot.json.JsonParserFactory;
import org.springframework.web.client.RestTemplate;

public class VirusTotal {
    private static final String URL_VIRUS_TOTAL = "https://www.virustotal.com/vtapi/v2/file/report?apikey=55db29089c42d6888ed5def250d8e6b2a021d50f960d640c9b247e0b2c32ee7b&resource=%s";

    public static String scan(String keyword) throws IOException, URISyntaxException {
        int positives = 500;
        String VT_URL = String.format(URL_VIRUS_TOTAL, keyword);

        RestTemplate restTemplate = new RestTemplate();

        URI uri = new URI(VT_URL);
        String result = restTemplate.getForObject(uri, String.class);

        org.springframework.boot.json.JsonParser springParser = JsonParserFactory.getJsonParser();
        Map<String, Object> map = springParser.parseMap(result);
        
        if(map.get("verbose_msg").equals("Scan finished, information embedded")){
            positives = (int) map.get("positives");
        }else{
            positives = 500;
        }
        
        if(positives == 0){ return "safe";}
        if(positives == 500){ return "Not Found On Virus Total!"; }//"Not Found On VT";}

		return "malware";
	}

}
