package com.child.rest;


import com.child.dao.dto.ChildDto;
import com.child.service.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/rest/child")
public class ChildRest {

    @Autowired
    private ChildService childService;

    @RequestMapping(path = "create", method = RequestMethod.PUT)
    public List<ChildDto> create(@RequestBody List<ChildDto> dto, Long familyId) {
        return childService.create(dto,familyId);
    }

}
