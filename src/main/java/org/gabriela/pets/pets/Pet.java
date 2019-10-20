package org.gabriela.pets.pets;

import com.fasterxml.jackson.annotation.*;
import org.gabriela.pets.owners.Owner;

import javax.persistence.*;

@Entity
@Table(name = "pets", indexes = {@Index(columnList = "name", name = "name_idx")})
@JsonIgnoreProperties( { "hibernateLazyInitializer" } )
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column
    private String name;

    @Column
    private String kind;

    @ManyToOne
    @JoinColumn(name="owner_id")
    @JsonBackReference
    private Owner owner;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getKind() {
        return kind;
    }

    public Owner getOwner() {
        return owner;
    }
}
