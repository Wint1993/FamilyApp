package com.child.service;

import com.child.dao.ChildRepo;
import com.child.dao.dto.ChildDto;
import com.child.dao.entity.Child;
import com.family.dao.FamilyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class ChildService {

    @Autowired
    private ChildRepo childRepo;

    @Autowired
    private FamilyRepo familyRepo;

    public List<ChildDto> create(List<ChildDto> childDto,Long familyId){
        List<ChildDto> childDtos = new ArrayList<>();
        for (ChildDto child: childDto) {
            childDtos.add(child);
            childRepo.save(new Child(child,familyRepo.findOneById(familyId)));
        }
        return childDtos;
    }

}
