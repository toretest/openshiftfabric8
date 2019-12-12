package org.toregard.openshiftfabric8.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.toregard.openshiftfabric8.models.Agreement;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class AgreementService {
    private List<Agreement> agreements = new ArrayList<>();

    public AgreementService() {
        init();
    }

    public List<Agreement> getAgreements() {
        return agreements;
    }

    public Agreement getAgreementbyId(Integer agreementId) {
       return agreements.stream().filter(v -> v.getAgreementId().equals(agreementId)).findAny().orElse(null);
    }


    private void init() {
        for (int i = 1; i < 10; i++) {
            Integer agreementId = Integer.valueOf(i);
            agreements.add(createAgreement(agreementId, "agreement" + agreementId));
        }

    }

    private Agreement createAgreement(Integer agreementId, String name) {
        return Agreement.builder()
                .agreementId(agreementId)
                .name(name).build();
    }
}
