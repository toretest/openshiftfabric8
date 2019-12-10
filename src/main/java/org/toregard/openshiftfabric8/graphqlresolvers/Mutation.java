package org.toregard.openshiftfabric8.graphqlresolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.extern.slf4j.Slf4j;
import org.toregard.openshiftfabric8.models.Orientation;
import org.toregard.openshiftfabric8.models.SuperCharacter;
import org.toregard.openshiftfabric8.models.SuperGroup;
import org.toregard.openshiftfabric8.services.SuperCharacterService;
import org.toregard.openshiftfabric8.services.SuperGroupService;

@Slf4j
public class Mutation implements GraphQLMutationResolver {
    private SuperCharacterService characterRepo;
    private SuperGroupService groupRepo;

    public Mutation(SuperCharacterService repo, SuperGroupService grepo){
        this.characterRepo = repo;
        this.groupRepo = grepo;
    }

    public SuperCharacter addCharacter(String name, Integer age, String groupName){
        return characterRepo.addCharacter(name, age, groupName);
    }

    public SuperGroup addGroup(String name, Orientation orientation) {return groupRepo.addGroup(name, orientation);}

}
