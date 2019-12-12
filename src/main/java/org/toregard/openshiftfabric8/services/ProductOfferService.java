package org.toregard.openshiftfabric8.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.toregard.openshiftfabric8.models.ProductOffer;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ProductOfferService {
    private List<ProductOffer> productOffers = new ArrayList<>();

    public ProductOfferService() {
        init();
    }

    public List<ProductOffer> getGetProductOffers() {
        return productOffers;
    }

    public ProductOffer getProductOfferById(Integer productOfferId) {
        return productOffers.stream().filter(v -> v.getProductOfferId().equals(productOfferId)).findAny().orElse(null);
    }

    private void init() {
        for (int i = 1; i < 50; i++) {
            Integer productOfferId = Integer.valueOf(i);
            productOffers.add(createProductOffer(productOfferId, "productOffer" + productOfferId.toString(), i));
        }

    }

    private ProductOffer createProductOffer(Integer productOfferId, String name, Integer value) {
        return ProductOffer.builder()
                .productOfferId(productOfferId)
                .name(name)
                .someValue(value)
                .build();
    }
}
