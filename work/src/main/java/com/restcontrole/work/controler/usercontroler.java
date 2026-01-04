package com.restcontrole.work.controler;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import com.restcontrole.work.entries.user;
import com.restcontrole.work.service.userservice;

@RestController
@RequestMapping("/user")
public class usercontroler {
    @Autowired
    private userservice serv;

    @GetMapping()
    public List<user> getall() {
        return serv.getalluser();
    }

    @PostMapping()
    public boolean createuser(@RequestBody user user) {
        serv.saveuser(user);
        return true;
    }

    @GetMapping("{id}")
    public user getuserbyid(@PathVariable ObjectId id) {
        return serv.getone(id).orElse(null);
    }

    @DeleteMapping("{id}")
    public boolean deletentrybyid(@PathVariable ObjectId id) {
        serv.deletebyid(id);
        return true;
    }

    @DeleteMapping()
    public void deleteuser() {
        serv.deleteall();
    }

    @PutMapping("{id},{pass}")
    public ResponseEntity<user> updateUser(@RequestBody user newUser,
            @PathVariable ObjectId id,
            @PathVariable String pass) {
        user oldUser = serv.getone(id).orElse(null);

        if (oldUser != null && oldUser.getPassword().equals(pass)) {
            oldUser.setUsername(newUser.getUsername());
            oldUser.setPassword(newUser.getPassword());
            serv.saveuser(oldUser);
            return ResponseEntity.ok(oldUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
