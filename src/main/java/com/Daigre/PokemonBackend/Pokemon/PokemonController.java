package com.Daigre.PokemonBackend.Pokemon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/pokemon")
public class PokemonController {

    private PokemonService pokemonService;

    @Autowired
    public PokemonController( PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping
    public Iterable<PokemonEntity> getAllPokemon(){
        return pokemonService.findAll();
    }

    @GetMapping("{name}")
    public PokemonEntity getPokemon(@PathVariable(value = "name") String name){
        return pokemonService.findOne(name).orElse(null);
    }

//    @PostMapping
//    public void addPokemon(PokemonEntity pokemonEntity){
//        return pokemonService.findOne(name).orElse(null);
//    }
}
