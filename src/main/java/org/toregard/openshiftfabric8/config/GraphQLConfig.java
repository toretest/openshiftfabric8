package org.toregard.openshiftfabric8.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.toregard.openshiftfabric8.graphqlresolvers.AgreementQuery;
import org.toregard.openshiftfabric8.graphqlresolvers.Query;
import org.toregard.openshiftfabric8.services.*;
import org.toregard.openshiftfabric8.graphqlresolvers.Mutation;

@Configuration
public class GraphQLConfig {

    final AgreementService agreementService;
    final AgreementOfferService agreementOfferService;
    final ProductOfferService productOfferService;
    final SuperCharacterService superCharacterService;
    final SuperGroupService superGroupService;

    @Autowired
    public GraphQLConfig(AgreementService agreementService, AgreementOfferService agreementOfferService, ProductOfferService productOfferService, SuperCharacterService superCharacterService, SuperGroupService superGroupService) {
        this.agreementService = agreementService;
        this.agreementOfferService = agreementOfferService;
        this.productOfferService = productOfferService;
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
