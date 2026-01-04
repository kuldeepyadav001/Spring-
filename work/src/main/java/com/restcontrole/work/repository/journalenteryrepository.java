package com.restcontrole.work.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.restcontrole.work.entries.journalentries;

public interface journalenteryrepository extends MongoRepository<journalentries,ObjectId> {

    
}  


