package com.Daigre.PokemonBackend.locations;

import com.Daigre.PokemonBackend.Pokemon.PokemonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepo extends JpaRepository<LocationEntity, String> {
}
