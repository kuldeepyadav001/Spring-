package com.first.demo;

// import org.springframework.stereotype.Component;
// import org.springframework.stereotype.Indexed;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;


import org.bson.types.ObjectId;

@Document
@Getter
@Setter

public class enter {
 @Id
 private ObjectId id;
 private String employee;
 private String company;
	}

