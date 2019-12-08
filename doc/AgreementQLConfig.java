package org.toregard.openshiftfabric8.config;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.context.annotation.Configuration;
import org.toregard.openshiftfabric8.models.Agreement;

import java.util.Arrays;
import java.util.List;

//@Configuration
public class AgreementQLConfig implements DataFetcher<List<Agreement>> {
    @Override
    public List<Agreement> get(DataFetchingEnvironment environment) {
        return findAgreements();
    }

    private List<Agreement> findAgreements(){
        return Arrays.asList(
                getAgreement("1","agreement1"),
                getAgreement("2","agreement2"),
                getAgreement("3","agreement3"),
                getAgreement("4","agreement4"),
                getAgreement("5","agreement5")
        );
    }

    private Agreement getAgreement(String id, String name){
        return Agreement.builder().id(id).name(name).build();
    }
}
