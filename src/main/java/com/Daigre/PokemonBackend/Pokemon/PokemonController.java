package com.Daigre.PokemonBackend.Pokemon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
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
        String[] typeNames = typeName.equals("null") ? new String[0] : typeName.split("-");
        String[] moveNames = moveName.equals("null") ? new String[0] : moveName.split("-");
        String[] locationNames = locationName.equals("null") ? new String[0] : locationName.split("-");

        System.out.println(Arrays.toString(typeNames) + Arrays.toString(moveNames) + Arrays.toString(locationNames));
        return pokemonService.findByQuery(typeNames, moveNames, locationNames);
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
