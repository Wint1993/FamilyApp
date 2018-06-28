package com.family.rest;

import com.child.dao.dto.ChildDto;
import com.child.dao.entity.Child;
import com.family.dao.dto.FamilyDto;
import com.family.dao.dto.FamilyResponseDto;
import com.family.dao.entity.Family;
import com.family.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/family")
public class FamilyRest {

    @Autowired
    private FamilyService familyService;

    @RequestMapping(path = "create", method = RequestMethod.PUT)
    public FamilyDto create()  {
        return familyService.create();
    }

    @RequestMapping(path = "{query}", method = RequestMethod.GET)
    public List<FamilyResponseDto> findAll(@PathVariable("query") String query)  {
        return familyService.readFamily(query);

    }

}
