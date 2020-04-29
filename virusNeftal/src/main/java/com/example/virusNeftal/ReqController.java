package com.example.virusNeftal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ReqController {

    
    private List<Virus> viral = new ArrayList<Virus>();

    @Autowired
    private VirusRepo VirusService;

    @Autowired
    private VirusRepoSQL VirusRepoSQL;

    public ReqController(){}

    @RequestMapping(value="/viruses", method=RequestMethod.GET) 
	@ResponseStatus(HttpStatus.OK) 
	public Iterable<Virus> getListOfvirus(){
        return VirusService.findAll();
        
	}

    @RequestMapping(value="/viruses/{signature}", method = RequestMethod.GET)
    public Virus getVirusBySignature(@PathVariable("signature") String signature) {
        return VirusService.findById(signature).get();
    }
    

    @GetMapping(value = "/viruses/malware")
    public Iterable<Virus> getBad() {
        return VirusService.findByBad(true);
    }

    @PostMapping(value = "/viruses")
    public void addVirus(@RequestBody Virus v) throws Exception{
		viral.add(v);
		VirusService.save(v);
		VirusSQL carSQL = new VirusSQL(v.getsignature(), v.getname(), v.getBad());
		VirusRepoSQL.save(carSQL);
	}

    @DeleteMapping(value = "/viruses/{signature}")
    public void deleteVirus(@PathVariable String signature) {
        VirusService.deleteById(signature);
        
    }


}
    

