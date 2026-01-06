package com.first.demo;

import org.springframework.web.bind.annotation.RestController;
// import com.first.demo.enter;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/work")
public class demoControler {

    @Autowired
    private demorepo repo;

    @PostMapping()
    public void saveEntry(@RequestBody enter ent) {
        if (ent != null) {
            repo.save(ent);
        }
    }

    @GetMapping()
    public ResponseEntity<List<enter>> getEntry() {
        return ResponseEntity.ok(repo.findAll());
    }

    @DeleteMapping()
    public void deleteEntry() {
        repo.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void deleteEntry(@PathVariable ObjectId id) {
        repo.deleteById(id);
    }

    @GetMapping("/download")
    public ResponseEntity<String> downloadFile() {
        return ResponseEntity.ok()
                .header("Custom-Header", "KuldeepDemo")
                .body("File content here");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<enter> update(@PathVariable ObjectId id, @RequestBody enter newEntry) {
       @SuppressWarnings("null")
        Optional<enter> old = repo.findById(id);
        if (old.isPresent()) {
            enter updatedEntry = old.get();
            updatedEntry.setEmployee(
                    newEntry.getEmployee() != null && !newEntry.getEmployee().isEmpty() ? newEntry.getEmployee()
                            : updatedEntry.getEmployee());
            updatedEntry.setCompany(
                    newEntry.getCompany() != null && !newEntry.getCompany().isEmpty() ? newEntry.getCompany()
                            : updatedEntry.getCompany());
            enter newEnt = repo.save(updatedEntry);
            return ResponseEntity.ok(newEnt);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
