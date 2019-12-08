package org.toregard.openshiftfabric8.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.toregard.openshiftfabric8.models.repos.SuperCharacterRepo;
import org.toregard.openshiftfabric8.models.repos.SuperGroupRepo;
import org.toregard.openshiftfabric8.resolvers.Mutation;
import org.toregard.openshiftfabric8.resolvers.Query;

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
