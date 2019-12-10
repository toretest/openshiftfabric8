package org.toregard.openshiftfabric8.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.toregard.openshiftfabric8.graphqlresolvers.AgreementQuery;
import org.toregard.openshiftfabric8.graphqlresolvers.Query;
import org.toregard.openshiftfabric8.services.AgreementOfferService;
import org.toregard.openshiftfabric8.services.AgreementService;
import org.toregard.openshiftfabric8.services.SuperCharacterService;
import org.toregard.openshiftfabric8.services.SuperGroupService;
import org.toregard.openshiftfabric8.graphqlresolvers.Mutation;

@Configuration
public class GraphQLConfig {

    final
    AgreementService agreementService;
    final
    AgreementOfferService agreementOfferService;

    final
    SuperCharacterService superCharacterService;
    final
    SuperGroupService superGroupService;

    @Autowired
    public GraphQLConfig(AgreementService agreementService, AgreementOfferService agreementOfferService, SuperCharacterService superCharacterService, SuperGroupService superGroupService) {
        this.agreementService = agreementService;
        this.agreementOfferService = agreementOfferService;
        this.superCharacterService = superCharacterService;
        this.superGroupService = superGroupService;
    }

    @Bean
    public AgreementQuery agreementQuery() {
        return new AgreementQuery(agreementService,agreementOfferService);
    }

    @Bean
    public Query query() {
        return new Query(superCharacterService, superGroupService);
    }

    @Bean
    public Mutation mutation() {
        return new Mutation(superCharacterService, superGroupService);
    }

}
