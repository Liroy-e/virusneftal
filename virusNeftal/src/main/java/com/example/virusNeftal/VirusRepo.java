package com.example.virusNeftal;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface VirusRepo extends CrudRepository<Virus,String> {

  List<Virus> findByName(String name);
  List<Virus> findByBad(boolean bad);

}