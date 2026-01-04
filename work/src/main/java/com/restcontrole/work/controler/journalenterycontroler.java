package com.restcontrole.work.controler;

import org.springframework.web.bind.annotation.RestController;

import com.restcontrole.work.entries.journalentries;
import com.restcontrole.work.entries.user;
import com.restcontrole.work.service.journalenteryservice;
import com.restcontrole.work.service.userservice;



import java.util.List; 


import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

// import org.springframework.web.bind.annotation.PutMapping;
@RestController
@RequestMapping("/journal")
public class journalenterycontroler {

@Autowired
private journalenteryservice serv;

@Autowired 
private userservice userv;
   
@GetMapping()    
public List<journalentries> getall(){
    return serv.getallentries();
}

@PostMapping("{name}")
public boolean createntry(@RequestBody journalentries myent,@PathVariable String name){
   serv.saveEntry(myent,name);
   return true;
}


@GetMapping("{name}")
public List<journalentries> getentrybyid(@PathVariable String name){
   user user=userv.findByUserName(name);
   return user.getEntry();
   
}

@DeleteMapping("{id}")
public boolean deletentrybyid(@PathVariable ObjectId id){
    serv.deletebyid(id);
    return true;
}
@DeleteMapping()
public void deletentries(){
    serv.deleteall();
}

// @PutMapping("{id}")
// public journalentries updatentrybyid(@PathVariable ObjectId id, @RequestBody journalentries newent) {
//    journalentries oldent= serv.getone(id).orElse(null);
//    if(oldent!=null){
//    oldent.setName(newent.getName() != null && newent.getName()!=("")? newent.getName(): oldent.getName()) ;
//    oldent.setCollage(newent.getCollage() != null && newent.getCollage()!=("")? newent.getCollage(): oldent.getCollage()) ;
//    }
//    serv.saveEntry(oldent);
//    return oldent;
// }
}

