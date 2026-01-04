package com.restcontrole.work.entries;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import io.micrometer.common.lang.NonNull;
import java.util.List;
import java.util.ArrayList;

import org.bson.types.ObjectId;import lombok.Data;
@Document(collection="user")
@Data
public class user {
    @Id
    private ObjectId id;
    @NonNull
    @Indexed(unique = true)
    private String username;
    @NonNull
    private String password;
    @DBRef
    private List<journalentries> entry= new ArrayList<>();
}
