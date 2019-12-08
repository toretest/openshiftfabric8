package org.toregard.openshiftfabric8.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.toregard.openshiftfabric8.models.SuperCharacter;
import org.toregard.openshiftfabric8.models.repos.SuperCharacterRepo;
import org.toregard.openshiftfabric8.models.SuperGroup;
import org.toregard.openshiftfabric8.models.repos.SuperGroupRepo;

import java.util.List;

@Slf4j
public class Query implements GraphQLQueryResolver {

    private SuperCharacterRepo superCharacterRepo;
    private SuperGroupRepo superGroupRepo;

    public Query(SuperCharacterRepo repo,
                 SuperGroupRepo grepo){
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
