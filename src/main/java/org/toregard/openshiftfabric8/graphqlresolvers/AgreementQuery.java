package org.toregard.openshiftfabric8.graphqlresolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.toregard.openshiftfabric8.models.Agreement;
import org.toregard.openshiftfabric8.models.AgreementOffer;
import org.toregard.openshiftfabric8.services.AgreementOfferService;
import org.toregard.openshiftfabric8.services.AgreementService;

import java.util.List;

public class AgreementQuery implements GraphQLQueryResolver {
    private AgreementService agreementService;
    private AgreementOfferService agreementOfferService;

    public AgreementQuery(AgreementService agreementService, AgreementOfferService agreementOfferService) {
        this.agreementService = agreementService;
        this.agreementOfferService = agreementOfferService;
    }

    public List<Agreement> getAllAgreements() {
        return agreementService.getAgreements();
    }

    public Agreement getAgreement(String id) {
        return agreementService.getAgreementbyId(id);
    }

    public List<AgreementOffer> getAllAgreementOffers() {
        return agreementOfferService.getAgreementOffers();
    }
}
