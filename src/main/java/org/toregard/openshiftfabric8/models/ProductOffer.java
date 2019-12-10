package org.toregard.openshiftfabric8.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductOffer {
    private String productOfferId;
    private String name;
    private Integer someValue;
}
