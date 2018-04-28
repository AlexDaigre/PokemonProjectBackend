package com.Daigre.PokemonBackend.Moves;

import com.Daigre.PokemonBackend.Pokemon.PokemonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoveRepo extends JpaRepository<MoveEntity, String> {
}
