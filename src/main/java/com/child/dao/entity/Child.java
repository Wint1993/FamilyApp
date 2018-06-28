package com.child.dao.entity;

import com.child.dao.dto.ChildDto;
import com.family.dao.entity.Family;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String pesel;
    private LocalDate birthDate;
    private String sex;

    @ManyToOne(fetch = FetchType.EAGER)
    private Family family;

    public Child(){}

    public Child(String name, String lastName, String pesel, LocalDate birthDate, String sex) {
        this.name = name;
        this.lastName = lastName;
        this.pesel = pesel;
        this.birthDate = birthDate;
        this.sex = sex;
    }

    public Child(ChildDto childDto, Family family){
        this.name = childDto.getName();
        this.lastName = childDto.getLastName();
        this.pesel = childDto.getPesel();
        this.birthDate = childDto.getBirthDate();
        this.sex = childDto.getSex();
        this.family = family;
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

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }
}
