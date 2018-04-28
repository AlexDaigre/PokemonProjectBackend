package com.Daigre.PokemonBackend.locations;

import com.Daigre.PokemonBackend.Pokemon.PokemonEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "locations")
public class LocationEntity {
    @Id
    private String name;

    private String description;

    @ManyToMany(mappedBy = "locations")
    @JsonBackReference
    private List<PokemonEntity> pokemonEntities;
}
