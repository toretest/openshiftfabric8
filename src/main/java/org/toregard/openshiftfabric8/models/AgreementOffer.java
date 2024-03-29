package org.toregard.openshiftfabric8.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AgreementOffer {
    private Integer agreementOfferId;
    private Agreement agreement;
    private List<ProductOffer> productOffers;
}