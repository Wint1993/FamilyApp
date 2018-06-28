package com.child.dao.dto;

import com.child.dao.entity.Child;

import java.time.LocalDate;

public class ChildDto {

    private Long id;
    private String name;
    private String lastName;
    private String pesel;
    private LocalDate birthDate;
    private String sex;

    public ChildDto(String name, String lastName, String pesel, LocalDate birthDate, String sex) {
        this.name = name;
        this.lastName = lastName;
        this.pesel = pesel;
        this.birthDate = birthDate;
        this.sex = sex;
    }

    public ChildDto(){}

    public ChildDto(Child child){
        this.id = child.getId();
        this.name = child.getName();
        this.lastName = child.getLastName();
        this.pesel = child.getPesel();
        this.birthDate = child.getBirthDate();
        this.sex = child.getSex();
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
