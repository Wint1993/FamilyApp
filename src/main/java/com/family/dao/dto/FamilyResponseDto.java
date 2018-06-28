package com.family.dao.dto;

import com.child.dao.dto.ChildDto;
import com.father.dao.dto.FatherDto;

import java.util.ArrayList;
import java.util.List;

public class FamilyResponseDto {

    private FatherDto fatherDto;

    private List<ChildDto> childDtos = new ArrayList<>();

    public FamilyResponseDto() {
    }

    public FamilyResponseDto(FatherDto fatherDto, List<ChildDto> childDtos) {
        this.fatherDto = fatherDto;
        this.childDtos = childDtos;
    }

    public FatherDto getFatherDto() {
        return fatherDto;
    }

    public void setFatherDto(FatherDto fatherDto) {
        this.fatherDto = fatherDto;
    }

    public List<ChildDto> getChildDtos() {
        return childDtos;
    }

    public void setChildDtos(List<ChildDto> childDtos) {
        this.childDtos = childDtos;
    }

}
