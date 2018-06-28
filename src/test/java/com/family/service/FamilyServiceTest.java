package com.family.service;

import com.Application;
import com.child.dao.ChildRepo;
import com.child.dao.dto.ChildDto;
import com.child.dao.entity.Child;
import com.child.service.ChildService;
import com.family.dao.dto.FamilyDto;
import com.family.dao.dto.FamilyResponseDto;
import com.family.dao.entity.Family;
import com.father.dao.FatherRepo;
import com.father.dao.dto.FatherDto;
import com.father.dao.entity.Father;
import com.father.service.FatherService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class FamilyServiceTest {

    private static final String NAME = "Ben";
    private static final String LASTNAME = "Smith";
    private static final String PESEL = "12345678912";
    private static final String SEX = "man";
    private static final LocalDate BIRTHDATE = LocalDate.now();

    private static final String NAME1 = "Jennefer";
    private static final String LASTNAME1 = "Smith";
    private static final String PESEL1 = "12345678912";
    private static final String SEX1 = "man";
    private static final LocalDate BIRTHDATE1 = LocalDate.now();

    private static final String FATHER_NAME = "Adam";
    private static final String FATHER_LASTNAME = "Smith";
    private static final String FATHER_PESEL = "12345678912";
    private static final LocalDate FATHER_BIRTHDATE= LocalDate.now();

    private static final ChildDto CHILD_DTO1 = new ChildDto(NAME,LASTNAME,PESEL,BIRTHDATE,SEX);
    private static final ChildDto CHILD_DTO2 = new ChildDto(NAME1,LASTNAME1,PESEL1,BIRTHDATE1,SEX1);
    private static final List<ChildDto> childDtoList = new ArrayList<>();

    private static final FatherDto FATHER = new FatherDto(FATHER_NAME,FATHER_LASTNAME,FATHER_PESEL,FATHER_BIRTHDATE);

    private static final FamilyResponseDto FAMILY_RESPONSE_DTO = new FamilyResponseDto(FATHER,childDtoList);

    private static final Family FAMILY = new Family();

    @InjectMocks
    @Autowired
    protected FamilyService testedObject;

    @InjectMocks
    @Autowired
    protected ChildService childService;

    @Autowired
    protected ChildRepo childRepo;

    @Autowired
    protected FatherRepo fatherRepo;

    @InjectMocks
    @Autowired
    protected FatherService fatherService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
       // when(childRepo.save(new Child(CHILD_DTO1,FAMILY)));
       // childRepo.save(new Child(CHILD_DTO2,FAMILY));
      //  fatherRepo.save(new Father(FATHER,FAMILY));
      //  childDtoList.add(CHILD_DTO1);
       // childDtoList.add(CHILD_DTO2);

    }

    @Test
    public void createShouldCreateFamily() {

        FamilyDto result = testedObject.create();
        assertNotNull(result);
        assertNotNull(result.getId());
    }

    @Test
    public void findShouldReturnFamily() {

        List<FamilyResponseDto> result = testedObject.readFamily("Ben");
        assertNotNull(result);

    }

}
