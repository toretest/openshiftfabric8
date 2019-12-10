package org.toregard.openshiftfabric8.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.toregard.openshiftfabric8.services.SuperCharacterService;
import org.toregard.openshiftfabric8.services.SuperGroupService;
import org.toregard.openshiftfabric8.graphqlresolvers.Mutation;
import org.toregard.openshiftfabric8.graphqlresolvers.Query;

import javax.inject.Inject;

//@Configuration
public class GraphQLConfig {

//    SuperCharacterRepo superCharacterRepo;
//    SuperGroupRepo superGroupRepo;
//
//    @Inject
//    public GraphQLConfig(SuperCharacterRepo superCharacterRepo,SuperGroupRepo superGroupRepo) {
//        this.superCharacterRepo=superCharacterRepo;
//        this.superGroupRepo=superGroupRepo;
//    }
//
//    @Bean
//    public Query query(){return new Query(superCharacterRepo,superGroupRepo);}
//
//    @Bean
//    public Mutation mutation(){return new Mutation(superCharacterRepo);}
}
