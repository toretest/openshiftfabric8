package org.toregard.openshiftfabric8.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.toregard.openshiftfabric8.services.AgreementOfferService;
import org.toregard.openshiftfabric8.services.AgreementService;
import org.toregard.openshiftfabric8.services.ProductOfferService;

@Configuration
public class ServiceConfig {

    @Bean
    AgreementService getAgreementService() {
        return new AgreementService();
    }

    @Bean
    AgreementOfferService getAgreementOfferService(AgreementService agreementService, ProductOfferService productOfferService) {
        return new AgreementOfferService(agreementService,productOfferService);
    }

    @Bean
    ProductOfferService getProductOfferService() {
        return new ProductOfferService();
    }
}
