package com.restcontrole.work.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restcontrole.work.entries.user;
import com.restcontrole.work.repository.userrepository;

@Service
public class userservice {
  @Autowired
    private userrepository  repo;

    @SuppressWarnings("null")
    public void saveuser(user val){
        repo.save(val);

     }

    public List<user> getalluser(){
        return repo.findAll();

    }
    @SuppressWarnings("null")
    public Optional<user> getone(ObjectId id){
        return repo.findById(id);
    }
    @SuppressWarnings("null")
    public void deletebyid(ObjectId id){
        repo.deleteById(id);
    }
    public void deleteall(){
    repo.deleteAll();
    }
    public user findByUserName(String username){
        return repo.findByusername(username);
    }
}
