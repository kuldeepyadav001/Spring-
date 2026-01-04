package com.restcontrole.work.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import com.restcontrole.work.entries.journalentries;
import com.restcontrole.work.entries.user;


import com.restcontrole.work.repository.journalenteryrepository;
@Component
public class journalenteryservice {

    @Autowired
    private journalenteryrepository  repo;
    @Autowired 
    private userservice userv;

    public void saveEntry(journalentries val, String name){
     try{user user=userv.findByUserName(name);
         val.setDate(LocalDateTime.now());   
       journalentries entery=repo.save(val);
       user.getEntry().add(entery);
       userv.saveuser(user);
     }
      catch (Exception e) {
            // Log the exception instead of printing ResponseEntity
            System.err.println("Error saving entry: " + e.getMessage());
            throw new RuntimeException("Failed to save entry", e);
        } 
    }

    public List<journalentries> getallentries(){
        return repo.findAll();

    }
    @SuppressWarnings("null")
    public Optional<journalentries> getone(ObjectId id){
        return repo.findById(id);
    }
    @SuppressWarnings("null")
    public void deletebyid(ObjectId id){
        repo.deleteById(id);
    }
    public void deleteall(){
    repo.deleteAll();
    }
}
