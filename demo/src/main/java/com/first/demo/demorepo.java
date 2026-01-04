package com.first.demo;
import org.springframework.data.mongodb.repository.MongoRepository;
// import com.first.demo.enter;
import org.bson.types.ObjectId;
public interface demorepo extends MongoRepository<enter,ObjectId> {

}
