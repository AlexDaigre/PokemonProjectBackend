package com.Daigre.PokemonBackend.Pokemon;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokemonRepo extends JpaRepository<PokemonEntity, String> {
    List<PokemonEntity> findByTypes_Name(String name);

    List<PokemonEntity> findByLocations_Name(String name);

    List<PokemonEntity> findByMoves_Name(String name);

//    List<PokemonEntity> findByMoves_NameAndTypes_Name(String Moves_Name, String Types_Name);
}
