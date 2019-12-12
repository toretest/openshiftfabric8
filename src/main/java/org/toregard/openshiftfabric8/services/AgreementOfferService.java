package org.toregard.openshiftfabric8.services;

import lombok.extern.slf4j.Slf4j;
import org.toregard.openshiftfabric8.models.AgreementOffer;
import org.toregard.openshiftfabric8.models.ProductOffer;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class AgreementOfferService {
    private List<AgreementOffer> agreementOffers = new ArrayList<>();
    private ProductOfferService productOfferService;
    private AgreementService agreementService;

    @Inject
    public AgreementOfferService(AgreementService agreementService, ProductOfferService productOfferService) {
        this.agreementService = agreementService;
        this.productOfferService = productOfferService;
        init();
    }

    public ProductOfferService getProductOfferService() {
        return productOfferService;
    }

    public AgreementService getAgreementService() {
        return agreementService;
    }

    public void setAgreementService(AgreementService agreementService) {
        this.agreementService = agreementService;
    }

    public List<AgreementOffer> getAgreementOffers() {
        return agreementOffers;
    }

    public AgreementOffer getAgreementOfferbyId(Integer agreementOfferId) {
        return agreementOffers.stream().filter(v -> v.getAgreementOfferId().equals(agreementOfferId)).findAny().orElse(null);
    }


    private void init() {
        agreementOffers.add(createAgreementOffer(1,1, Arrays.asList(productOfferService.getProductOfferById(1), productOfferService.getProductOfferById(2))));
        agreementOffers.add(createAgreementOffer(2,2, Arrays.asList(productOfferService.getProductOfferById(2), productOfferService.getProductOfferById(3))));
        agreementOffers.add(createAgreementOffer(3,3, Arrays.asList(productOfferService.getProductOfferById(4), productOfferService.getProductOfferById(5))));
    }

    private AgreementOffer createAgreementOffer(Integer agreementOfferId,Integer agreemenId,List<ProductOffer> productOffers) {
        return AgreementOffer.builder()
                .agreementOfferId(agreementOfferId)
                .agreement(agreementService.getAgreementbyId(agreemenId))
                .productOffers(productOffers)
                .build();
    }


}
