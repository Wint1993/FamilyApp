package com.father.dao.dto;

import com.family.dao.entity.Family;
import com.father.dao.entity.Father;

import java.time.LocalDate;

public class FatherDto {

    private Long id;
    private String name;
    private String lastName;
    private String pesel;
    private LocalDate birthDate;

    public FatherDto(){}

    public FatherDto(String name, String lastName, String pesel, LocalDate birthDate) {
        this.name = name;
        this.lastName = lastName;
        this.pesel = pesel;
        this.birthDate = birthDate;
    }

    public FatherDto(Father father){
        this.id = father.getId();
        this.name = father.getName();
        this.lastName = father.getLastName();
        this.pesel = father.getPesel();
        this.birthDate = father.getBirthDate();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
