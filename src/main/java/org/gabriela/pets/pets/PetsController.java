package org.gabriela.pets.pets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PetsController {

    private PetRepository repository;

    @Autowired
    public PetsController(PetRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/pets/{id}")
    public ResponseEntity<Pet> getPetById(@PathVariable("id") long id) {
        Pet pet = repository.getOne(id);
        return ResponseEntity.ok(pet);
    }

    @GetMapping("/pets")
    public ResponseEntity<Pet> getPetByName(@RequestParam String name) {
        Pet pet = repository.getPetByName(name);
        return ResponseEntity.ok(pet);
    }

    @PostMapping("/pets")
    public ResponseEntity<Pet> createPet(@RequestBody Pet pet) {
        Pet newPet = repository.save(pet);
        return ResponseEntity.ok(newPet);
    }
}
