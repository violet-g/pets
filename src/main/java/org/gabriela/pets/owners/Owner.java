package org.gabriela.pets.owners;

import com.fasterxml.jackson.annotation.*;
import org.gabriela.pets.pets.Pet;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "owners")
@JsonIgnoreProperties( { "hibernateLazyInitializer" } )
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Pet> pets;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Pet> getPets() {
        return pets;
    }
}
