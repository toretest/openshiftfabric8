package org.toregard.openshiftfabric8.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Agreement {
   private Integer agreementId;
   private String name;
}
