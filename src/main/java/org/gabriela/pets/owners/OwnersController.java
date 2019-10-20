package org.gabriela.pets.owners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OwnersController {

    private OwnerRepository repository;

    @Autowired
    public OwnersController(OwnerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/owners/{id}")
    public ResponseEntity<Owner> getOwnerById(@PathVariable long id) {
        Owner owner = repository.getOne(id);
        if (owner == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(owner);
    }

    @PostMapping("/owners")
    public ResponseEntity<Owner> createOwner(@RequestBody Owner owner) {
        Owner newOwner = repository.save(owner);
        return ResponseEntity.ok(newOwner);
    }
}
