package org.toregard.openshiftfabric8.models.repos;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.toregard.openshiftfabric8.models.SuperCharacter;
import org.toregard.openshiftfabric8.models.SuperGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
public class SuperCharacterRepo {
    private SuperGroupRepo groupRepo;

    private List<SuperCharacter> theCharacters = new ArrayList<SuperCharacter>();

    public SuperCharacterRepo(SuperGroupRepo grepo){
        this.groupRepo = grepo;
        seedCharacters();
    }

    private void seedCharacters(){
        SuperCharacter c1 = SuperCharacter.builder()
                .id("Char1")
                .name("Super Character1")
                .age(33)
                .build();
        SuperCharacter c2 = SuperCharacter.builder()
                .id("Char2")
                .name("Two Is My Name")
                .age(147)
                .build();

        this.theCharacters.add(c1);
        this.theCharacters.add(c2);
    }

    public List<SuperCharacter> getCharacters(){
        return this.theCharacters;
    }

    public SuperCharacter getCharacterById(String id){
        List<SuperCharacter> matched = this.theCharacters.stream()
                .filter(c->c.getId().equalsIgnoreCase(id))
                .collect(Collectors.toList());

        if( matched.size() > 0){
            return matched.get(0);
        }else{
            return null;
        }
    }

    public SuperCharacter addCharacter(String name, Integer age, String groupName){
        SuperGroup sGroup = null;
        if(groupName!=null && groupName.length()>0){
            sGroup = groupRepo.getGroupByName(groupName);
        }
        SuperCharacter newChar = SuperCharacter.builder()
                .id("Char" + (this.theCharacters.size()+1))
                .name(name)
                .age(age)
                .group(sGroup)
                .build();
        log.info("> Mutation.addCharacter( "+ name + " )");
        this.theCharacters.add(newChar);

        if(sGroup!=null)sGroup.addCharacter(newChar);

        return newChar;
    }
}
