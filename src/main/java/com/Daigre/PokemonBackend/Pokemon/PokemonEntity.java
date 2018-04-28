package com.Daigre.PokemonBackend.Pokemon;

import com.Daigre.PokemonBackend.Moves.MoveEntity;
import com.Daigre.PokemonBackend.Types.TypeEntity;
import com.Daigre.PokemonBackend.locations.LocationEntity;
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

    @ManyToMany
    private List<TypeEntity> types;

    @ManyToMany
    private List<MoveEntity> moves;

    @ManyToMany
    private List<LocationEntity> locations;
}
