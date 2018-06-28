package com.father.dao.entity;

import com.family.dao.entity.Family;
import com.father.dao.dto.FatherDto;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Father {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String pesel;
    private LocalDate birthDate;

    @OneToOne(fetch = FetchType.LAZY)
    private Family family;

    public Father(){}

    public Father(String name, String lastName, String pesel, LocalDate birthDate) {
        this.name = name;
        this.lastName = lastName;
        this.pesel = pesel;
        this.birthDate = birthDate;

    }

    public Father(FatherDto fatherDto, Family family){
        this.name = fatherDto.getName();
        this.lastName = fatherDto.getLastName();
        this.pesel = fatherDto.getPesel();
        this.birthDate = fatherDto.getBirthDate();
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

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }
}
