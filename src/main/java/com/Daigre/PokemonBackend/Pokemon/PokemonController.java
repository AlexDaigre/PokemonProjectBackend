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

//    @GetMapping("type/{name}")
//    public List<PokemonEntity> getPokemonByType(@PathVariable(value = "name") String name){
//        return pokemonService.findByTypeName(name);
//    }
//
//    @GetMapping("move/{name}")
//    public List<PokemonEntity> getPokemonByMove(@PathVariable(value = "name") String name){
//        return pokemonService.findByMoveName(name);
//    }
//
//    @GetMapping("location/{name}")
//    public List<PokemonEntity> getPokemonByLocation(@PathVariable(value = "name") String name){
//        return pokemonService.findByLocationName(name);
//    }
//
//    @GetMapping("typemove/{typeName}_{moveName}")
//    public List<PokemonEntity> getPokemonByMoveAndType(@PathVariable(value = "moveName") String moveName, @PathVariable(value = "typeName") String typeName){
//        return pokemonService.findByMoveNameAndTypeName(moveName, typeName);
//    }

   @GetMapping("query/{typeName}+{moveName}+{locationName}")
    public List<PokemonEntity> getPokemonQuery(@PathVariable(value = "moveName") String moveName, @PathVariable(value = "typeName") String typeName, @PathVariable(value = "locationName") String locationName){
        System.out.println(moveName + typeName + locationName);
        return pokemonService.findByQuery(typeName, moveName, locationName);
    }

    @GetMapping("name/{name}")
    public PokemonEntity getPokemonByName(@PathVariable(value = "name") String name){
        return pokemonService.findOne(name).orElse(null);
    }

//    @PostMapping
//    public void addPokemon(PokemonEntity pokemonEntity){
//        return pokemonService.findOne(name).orElse(null);
//    }
}
