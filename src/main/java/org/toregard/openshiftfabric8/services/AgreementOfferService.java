package org.toregard.openshiftfabric8.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.toregard.openshiftfabric8.models.AgreementOffer;
import org.toregard.openshiftfabric8.models.ProductOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AgreementOfferService {
    private List<AgreementOffer> agreementOffers = new ArrayList<>();
    private ProductOfferService productOfferService = new ProductOfferService();

    public AgreementOfferService() {
        init();
    }

    public List<AgreementOffer> getAgreementOffers() {
        return agreementOffers;
    }

    public AgreementOffer getAgreementbyId(String id) {
        Optional<AgreementOffer> agreementOptional = agreementOffers.stream().findFirst();
        return agreementOptional.isPresent() ? agreementOptional.get() : null;
    }


    private void init() {
        agreementOffers.add(createAgreementOffer("1", Arrays.asList(productOfferService.getProductOfferById("1"), productOfferService.getProductOfferById("2"))));
        agreementOffers.add(createAgreementOffer("2", Arrays.asList(productOfferService.getProductOfferById("2"), productOfferService.getProductOfferById("3"))));
    }

    private AgreementOffer createAgreementOffer(String agreementId, List<ProductOffer> productOffers) {
        return AgreementOffer.builder()
                .agreementId(agreementId)
                .productOffers(productOffers)
                .build();
    }


}
