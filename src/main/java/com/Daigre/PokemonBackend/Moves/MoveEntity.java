package com.Daigre.PokemonBackend.Moves;

import com.Daigre.PokemonBackend.Pokemon.PokemonEntity;
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
    private String move;

    @ManyToMany(mappedBy = "moves")
    private List<PokemonEntity> pokemonEntities;
}
