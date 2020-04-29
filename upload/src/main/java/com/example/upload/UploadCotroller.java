package com.example.upload;

import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UploadCotroller {

    String safety = "";
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public String index() {
        return safety;
    }

    @PostMapping("/")
    public void handleFileUpload(@RequestParam("file") MultipartFile file)
            throws IOException, URISyntaxException {
                safety = "";
                String url = "http://virusedb/viruses/";
                String shaHash = AvService.getFileHash(file);

                RestTemplate restTemp = new RestTemplate();
                try{
                    Virus v = restTemp.getForObject(url+shaHash, Virus.class);
                    if(!v.getBad()){ safety = "safe";}
                    else{ safety = "dangerous";}
                    //return ResponseEntity.status(HttpStatus.OK);
                }
                catch(Exception i){
                    String verdict = AvService.checkFile(shaHash);
                    HttpHeaders headers = new HttpHeaders();
                    headers.setContentType(MediaType.APPLICATION_JSON);

                    if(verdict.equals("safe")){
                        String requestJson = "{\"signature\":\""+shaHash+"\", \"name\":\"\", \"bad\":\"false\"}";
                        HttpEntity<String> entity = new HttpEntity<String>(requestJson,headers);
                        restTemp.postForObject(url, entity, String.class);
                        safety = "safe" ;
                    }
                    else if(verdict.equals("malware")){
                        String requestJson = "{\"signature\":\""+shaHash+"\", \"name\":\"\", \"bad\":\"true\"}";
                        HttpEntity<String> entity = new HttpEntity<String>(requestJson,headers);
                        restTemp.postForObject(url, entity, String.class);
                        safety = "dangerous";

                    }
                    else{
                        safety = "unkown";
                        
                    }
                    
                //return ResponseEntity.status(HttpStatus.OK);
                }
		
    }
    
    @GetMapping("/{shaHash}")
    public void handleSignature(@PathVariable String shaHash)
            throws IOException, URISyntaxException {
                safety = "";

                RestTemplate restTemp = new RestTemplate();
                try{
                    Virus v = restTemp.getForObject("http://localhost:8081/viruses/"+shaHash, Virus.class);
                    if(!v.getBad()){ safety = "safe";}
                    else{ safety = "dangerous";}
                    //return ResponseEntity.status(HttpStatus.OK);
                }
                catch(Exception i){
                    String verdict = AvService.checkFile(shaHash);
                    HttpHeaders headers = new HttpHeaders();
                    headers.setContentType(MediaType.APPLICATION_JSON);
                    String url = "http://localhost:8081/viruses/";

                    if(verdict.equals("safe")){
                        String requestJson = "{\"signature\":\""+shaHash+"\", \"name\":\"\", \"bad\":\"false\"}";
                        HttpEntity<String> entity = new HttpEntity<String>(requestJson,headers);
                        restTemp.postForObject(url, entity, String.class);
                        safety = "safe" ;
                    }
                    else if(verdict.equals("malware")){
                        String requestJson = "{\"signature\":\""+shaHash+"\", \"name\":\"\", \"bad\":\"true\"}";
                        HttpEntity<String> entity = new HttpEntity<String>(requestJson,headers);
                        restTemp.postForObject(url, entity, String.class);
                        safety = "dangerous";

                    }
                    else{
                        safety = "unkown";
                        
                    }
                    
                //return ResponseEntity.status(HttpStatus.OK);
                }
		
	}

}