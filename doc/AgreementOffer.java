package org.toregard.openshiftfabric8.models;

import lombok.Data;

import java.util.List;

@Data
public class AgreementOffer {
    private String agreementId;
    private List<ProductOffer> productOffers;
}