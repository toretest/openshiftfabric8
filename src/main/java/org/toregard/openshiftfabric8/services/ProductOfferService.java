package org.toregard.openshiftfabric8.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.toregard.openshiftfabric8.models.Agreement;
import org.toregard.openshiftfabric8.models.ProductOffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductOfferService {
    private List<ProductOffer> productOffers = new ArrayList<>();

    public ProductOfferService() {
        init();
    }

    public List<ProductOffer> getGetProductOffers() {
        return productOffers;
    }

    public ProductOffer getProductOfferById(String id) {
        Optional<ProductOffer> agreementOptional = productOffers.stream().findFirst();
        return agreementOptional.isPresent() ? agreementOptional.get() : null;
    }


    private void init() {
        for (int i = 1; i < 5; i++) {
            String productOfferId = String.valueOf(i);
            productOffers.add(createProductOffer(productOfferId, "productOffer" + productOfferId,Integer.valueOf(i)));
        }

    }

    private ProductOffer createProductOffer(String productOfferId, String name,Integer value) {
        return ProductOffer.builder()
                .productOfferId(productOfferId)
                .name(name)
                .someValue(value)
                .build();
    }
}
