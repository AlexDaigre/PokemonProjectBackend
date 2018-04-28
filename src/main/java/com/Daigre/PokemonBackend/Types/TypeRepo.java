package com.Daigre.PokemonBackend.Types;

import com.Daigre.PokemonBackend.Pokemon.PokemonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepo extends JpaRepository<TypeEntity, String> {
}
