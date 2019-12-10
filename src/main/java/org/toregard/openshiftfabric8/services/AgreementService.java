package org.toregard.openshiftfabric8.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.toregard.openshiftfabric8.models.Agreement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class AgreementService {
    private List<Agreement> agreements = new ArrayList<>();

    public AgreementService() {
        init();
    }

    public List<Agreement> getAgreements() {
        return agreements;
    }

    public Agreement getAgreementbyId(String id) {
        Optional<Agreement> agreementOptional = agreements.stream().findFirst();
        return agreementOptional.isPresent() ? agreementOptional.get() : null;
    }


    private void init() {
        for (int i = 1; i < 10; i++) {
            String id = String.valueOf(i);
            agreements.add(createAgreement(id, "agreement" + id));
        }

    }

    private Agreement createAgreement(String id, String name) {
        return Agreement.builder()
                .id(id)
                .name(name).build();
    }
}
