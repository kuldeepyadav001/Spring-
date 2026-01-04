package com.restcontrole.work.entries;

import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.Getter;
import lombok.Setter;


@Document(collection="journalentries")
@Getter
@Setter
public class journalentries {
    @Id
    private ObjectId id;

    private String name;

    private String collage;

    private LocalDateTime date;

}