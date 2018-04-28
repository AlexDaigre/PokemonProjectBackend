package com.Daigre.PokemonBackend.Pokemon;

import com.Daigre.PokemonBackend.Moves.MoveRepo;
import com.Daigre.PokemonBackend.Types.TypeRepo;
import com.Daigre.PokemonBackend.locations.LocationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PokemonService {

    private PokemonRepo pokemonRepo;

    private LocationRepo locationRepo;

    private MoveRepo moveRepo;

    private TypeRepo typeRepo;

    @Autowired
    public PokemonService(PokemonRepo pokemonRepo, LocationRepo locationRepo, MoveRepo moveRepo, TypeRepo typeRepo) {
        this.pokemonRepo = pokemonRepo;
        this.locationRepo = locationRepo;
        this.moveRepo = moveRepo;
        this.typeRepo = typeRepo;
    }

    public Iterable<PokemonEntity> findAll() {
        return pokemonRepo.findAll();
    }

    public Optional<PokemonEntity> findOne(String name) {
        return pokemonRepo.findById(name);
    }

//    public List<PokemonEntity> findByTypeName(String name) {
//        return String pokemonRepo.findByTypes_Name(moveName);
//    }
//
//    public List<PokemonEntity> findByMoveName(String name) {
//        return pokemonRepo.findByMoves_Name(name);
//    }
//
//    public List<PokemonEntity> findByLocationName(String name) {
//        return pokemonRepo.findByLocations_Name(name);
//    }
//
//    public List<PokemonEntity> findByMoveNameAndTypeName(String moveName, String typeName) {
//        return pokemonRepo.findByMoves_NameAndTypes_Name(moveName, typeName);
//    }

    public List<PokemonEntity> findByQuery (String typeName, String moveName, String locationName){
        List<PokemonEntity> pokemonWithType = pokemonRepo.findByTypes_Name(typeName);
        List<PokemonEntity> pokemonWithMove = pokemonRepo.findByMoves_Name(moveName);
        List<PokemonEntity> pokemonWithLocation = pokemonRepo.findByLocations_Name(locationName);

        if (!locationName.equals("null") && !moveName.equals("null") && !typeName.equals("null")){
            return pokemonArrayIntersection(pokemonArrayIntersection(pokemonWithType, pokemonWithMove),pokemonWithLocation);
        }else if (!locationName.equals("null") && !moveName.equals("null") && typeName.equals("null")){
            return pokemonArrayIntersection(pokemonWithMove, pokemonWithLocation);
        }else if (!locationName.equals("null") && moveName.equals("null") && !typeName.equals("null")){
            return pokemonArrayIntersection(pokemonWithType, pokemonWithLocation);
        }else if (locationName.equals("null") && !moveName.equals("null") && !typeName.equals("null")){
            return pokemonArrayIntersection(pokemonWithType, pokemonWithMove);
        }else if (locationName.equals("null") && moveName.equals("null") && !typeName.equals("null")){
            return pokemonWithType;
        }else if (!locationName.equals("null") && moveName.equals("null") && typeName.equals("null")){
            return pokemonWithLocation;
        }else if (locationName.equals("null") && !moveName.equals("null") && typeName.equals("null")){
            return pokemonWithMove;
        }
        return Lists.newArrayList(findAll());
    }

    private List<PokemonEntity> pokemonArrayIntersection(List<PokemonEntity> listOne, List<PokemonEntity> listTwo){
        ArrayList<PokemonEntity> resultingList = new ArrayList<>();

        for(PokemonEntity pokemonEntityListOne : listOne){
            for(PokemonEntity pokemonEntityListTwo : listTwo){
                if( pokemonEntityListOne.getName().equals(pokemonEntityListTwo.getName())){
                    resultingList.add(pokemonEntityListOne);
                }
            }
        }

        return resultingList;
    }
}
