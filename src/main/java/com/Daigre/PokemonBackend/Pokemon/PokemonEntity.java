package com.Daigre.PokemonBackend.Pokemon;

import com.Daigre.PokemonBackend.Moves.MoveEntity;
import com.Daigre.PokemonBackend.Types.TypeEntity;
import com.Daigre.PokemonBackend.locations.LocationEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import javax.persistence.Id;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "pokemon")
public class PokemonEntity {

    @Id
    private String name;

    private String image;

    @ManyToMany
    @JsonManagedReference
    private List<TypeEntity> types;

    @ManyToMany
    @JsonManagedReference
    private List<MoveEntity> moves;

    @ManyToMany
    @JsonManagedReference
    private List<LocationEntity> locations;

    public boolean equals(PokemonEntity pokemonEntity){
        if(this.getName().equals(pokemonEntity.getName())) {
            return true;
        } else {
            return false;
        }
    }
}
