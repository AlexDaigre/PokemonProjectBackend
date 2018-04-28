package com.Daigre.PokemonBackend.Types;

import com.Daigre.PokemonBackend.Pokemon.PokemonEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "types")
public class TypeEntity {
    @Id
    private String name;

    @ManyToMany(mappedBy = "types")
    private List<PokemonEntity> pokemonEntities;
}
