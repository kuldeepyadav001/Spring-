package com.restcontrole.work.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.transaction.annotation.Transactional;

import com.restcontrole.work.entries.journalentries;
import com.restcontrole.work.entries.user;
import org.springframework.stereotype.Service;
import com.restcontrole.work.repository.journalenteryrepository;

@Service
public class journalenteryservice {

    @Autowired
    private journalenteryrepository repo;
    @Autowired
    private userservice userv;

    @Transactional
    public void saveEntry(journalentries val, String name) {
       try{ user user = userv.findByUserName(name);
        val.setDate(LocalDateTime.now());
        journalentries entery = repo.save(val);
        user.getEntry().add(entery);
        userv.saveuser(user);
       }
       catch(Exception e){
        System.out.println(e);
       }
    }

    @SuppressWarnings("null")
    public void saveEntry(journalentries val) {
        repo.save(val);
    }

    public List<journalentries> getallentries() {
        return repo.findAll();

    }

    @SuppressWarnings("null")
    public Optional<journalentries> getone(ObjectId id) {
        return repo.findById(id);
    }

    @SuppressWarnings("null")
    public void deletebyid(ObjectId id, String name) {
        user user = userv.findByUserName(name);
        user.getEntry().removeIf(x -> x.getId().equals(id));
        userv.saveuser(user);
        repo.deleteById(id);
    }

    public void deleteall() {
        repo.deleteAll();
    }
}
