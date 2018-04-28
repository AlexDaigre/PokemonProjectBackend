package com.Daigre.PokemonBackend.locations;

import com.Daigre.PokemonBackend.Pokemon.PokemonEntity;
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

    @ManyToMany(mappedBy = "locations")
    private List<PokemonEntity> pokemonEntities;
}
