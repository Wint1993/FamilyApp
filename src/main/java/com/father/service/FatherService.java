package com.father.service;

import com.family.dao.FamilyRepo;
import com.father.dao.FatherRepo;
import com.father.dao.dto.FatherDto;
import com.father.dao.entity.Father;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class FatherService {

    @Autowired
    private FatherRepo fatherRepo;

    @Autowired
    private FamilyRepo familyRepo;

    public FatherDto create(FatherDto fatherDto,Long familyId){
        return new FatherDto(fatherRepo.save(new Father(fatherDto,familyRepo.findOneById(familyId))));
    }



}
