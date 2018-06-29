package com.family.service;

import com.child.dao.ChildRepo;
import com.child.dao.dto.ChildDto;
import com.child.dao.entity.Child;
import com.family.dao.FamilyRepo;
import com.family.dao.dto.FamilyDto;
import com.family.dao.dto.FamilyResponseDto;
import com.family.dao.entity.Family;
import com.father.dao.dto.FatherDto;
import com.father.dao.entity.Father;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;
import static org.springframework.data.util.Pair.toMap;


@Service
public class FamilyService {

    @Autowired
    private FamilyRepo familyRepo;

    @Autowired
    private ChildRepo childRepo;

    public FamilyDto create() {
        return new FamilyDto(familyRepo.save(new Family()));
    }

    public List<FamilyResponseDto> readFamily(String query) {

        Map<Father, List<Child>> map = new HashMap<>();

        childRepo.findAll(query.toLowerCase()).forEach(child -> {
            if (!map.containsKey(child.getFamily().getFather())) {
                map.put(child.getFamily().getFather(), new ArrayList<>());
            }
            map.get(child.getFamily().getFather()).add(child);
        });

        List<FamilyResponseDto> familyResponseDtos = new ArrayList<>();
        for(Map.Entry<Father,List<Child>> entry: map.entrySet()){
            FamilyResponseDto familyResponseDto = new FamilyResponseDto(new FatherDto(entry.getKey()),entry.getValue().stream().map(ChildDto::new).collect(toList()));
            familyResponseDtos.add(familyResponseDto);
        }
        return familyResponseDtos;
    }

}
