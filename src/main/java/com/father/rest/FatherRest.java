package com.father.rest;

import com.family.dao.entity.Family;
import com.father.dao.dto.FatherDto;
import com.father.service.FatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/father")
public class FatherRest {

    @Autowired
    private FatherService fatherService;

    @RequestMapping(path = "create", method = RequestMethod.PUT)
    public FatherDto create(@RequestBody FatherDto dto, Long familyId) {
        return fatherService.create(dto,familyId);
    }

}
