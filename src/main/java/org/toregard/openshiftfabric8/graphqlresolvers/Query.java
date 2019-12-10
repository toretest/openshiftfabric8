package org.toregard.openshiftfabric8.graphqlresolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.toregard.openshiftfabric8.models.SuperCharacter;
import org.toregard.openshiftfabric8.services.SuperCharacterService;
import org.toregard.openshiftfabric8.models.SuperGroup;
import org.toregard.openshiftfabric8.services.SuperGroupService;

import java.util.List;

@Slf4j
public class Query implements GraphQLQueryResolver {

    private SuperCharacterService superCharacterRepo;
    private SuperGroupService superGroupRepo;

    public Query(SuperCharacterService repo,
                 SuperGroupService grepo){
        this.superCharacterRepo = repo;
        this.superGroupRepo = grepo;
    }

    public List<SuperCharacter> characters(){ return superCharacterRepo.getCharacters(); }

    public SuperCharacter characterById(String id){
        return superCharacterRepo.getCharacterById(id);
    }

    public List<SuperGroup> groups(){ return superGroupRepo.getGroups();}
    public SuperGroup groupByName(String name){
        return superGroupRepo.getGroupByName(name);
    }

}
