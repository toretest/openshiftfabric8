package org.toregard.openshiftfabric8.models.repos;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.toregard.openshiftfabric8.models.Orientation;
import org.toregard.openshiftfabric8.models.SuperGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class SuperGroupRepo {

    private List<SuperGroup> theGroups = new ArrayList<>();

    public SuperGroupRepo() {seedGroups();}

    public void seedGroups(){
        SuperGroup g1 = SuperGroup.builder()
                .name("Bad Dudes")
                .orientation(Orientation.VILLAIN)
                .build();
        this.theGroups.add(g1);
    }

    public List<SuperGroup> getGroups(){ return this.theGroups; }

    public SuperGroup getGroupByName(String name){
        List<SuperGroup> theGroupList =
                this.theGroups.stream()
                        .filter(g-> g.name.equalsIgnoreCase(name))
                        .collect(Collectors.toList());

        if(theGroupList.size() > 0){
            return theGroupList.get(0);
        }else{
            return null;
        }
    }

    public SuperGroup addGroup(String name, Orientation orientation){
        SuperGroup newGroup = SuperGroup.builder()
                .name(name)
                .orientation(orientation)
                .build();
        this.theGroups.add(newGroup);
        return newGroup;
    }

}
