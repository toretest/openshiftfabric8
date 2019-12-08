package org.toregard.openshiftfabric8.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Agreement {
   private String id;
   private String name;
}
