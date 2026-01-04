package com.restcontrole.work.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.bson.types.ObjectId;
import com.restcontrole.work.entries.user;
public interface userrepository extends MongoRepository<user,ObjectId> {
 user findByusername(String username);
}
