package com.Daigre.PokemonBackend.Moves;

import com.Daigre.PokemonBackend.Pokemon.PokemonEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "moves")
public class MoveEntity {
    @Id
    private String name;

    private String description;

    @ManyToMany(mappedBy = "moves")
    @JsonBackReference
    private List<PokemonEntity> pokemonEntities;
}
