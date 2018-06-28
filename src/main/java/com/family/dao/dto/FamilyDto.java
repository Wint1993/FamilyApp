package com.family.dao.dto;

import com.child.dao.dto.ChildDto;
import com.family.dao.entity.Family;
import com.father.dao.dto.FatherDto;

import java.util.ArrayList;
import java.util.List;

public class FamilyDto {

    private Long id;

    public FamilyDto(Family family){
        this.id = family.getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
