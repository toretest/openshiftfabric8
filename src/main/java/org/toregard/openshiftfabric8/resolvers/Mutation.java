package org.toregard.openshiftfabric8.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.extern.slf4j.Slf4j;
import org.toregard.openshiftfabric8.models.Orientation;
import org.toregard.openshiftfabric8.models.SuperCharacter;
import org.toregard.openshiftfabric8.models.SuperGroup;
import org.toregard.openshiftfabric8.models.repos.SuperCharacterRepo;
import org.toregard.openshiftfabric8.models.repos.SuperGroupRepo;

@Slf4j
public class Mutation implements GraphQLMutationResolver {
    private SuperCharacterRepo characterRepo;
    private SuperGroupRepo groupRepo;

    public Mutation(SuperCharacterRepo repo, SuperGroupRepo grepo){
        this.characterRepo = repo;
        this.groupRepo = grepo;
    }

    public SuperCharacter addCharacter(String name, Integer age, String groupName){
        return characterRepo.addCharacter(name, age, groupName);
    }

    public SuperGroup addGroup(String name, Orientation orientation) {return groupRepo.addGroup(name, orientation);}

}
