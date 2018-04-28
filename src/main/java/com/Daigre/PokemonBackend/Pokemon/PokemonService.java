package com.Daigre.PokemonBackend.Pokemon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PokemonService {

    private PokemonRepo pokemonRepo;

    @Autowired
    public PokemonService (PokemonRepo pokemonRepo){
        this.pokemonRepo = pokemonRepo;
    }

    public Iterable<PokemonEntity> findAll() { return pokemonRepo.findAll();}

    public Optional<PokemonEntity> findOne(String name) { return pokemonRepo.findById(name);}
}
