package com.child.service;

import com.Application;
import com.child.dao.dto.ChildDto;
import com.family.dao.entity.Family;
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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ChildServiceTest {

    private static final Family FAMILY = new Family();

    @InjectMocks
    @Autowired
    protected ChildService testedObject;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createShouldCreateChild() {

        final String name = "Adam";
        final String lastName = "Smith";
        final String pesel = "12345678912";
        final String sex = "man";
        final LocalDate date = LocalDate.now();

        List<ChildDto> childDtoList = new ArrayList<>();
        childDtoList.add(new ChildDto(name,lastName,pesel,date,sex));

        List<ChildDto> result = testedObject.create(childDtoList,FAMILY.getId());

        assertNotNull(result);
        assertEquals(name, result.get(0).getName());
        assertEquals(lastName, result.get(0).getLastName());
        assertEquals(pesel, result.get(0).getPesel());
        assertEquals(sex, result.get(0).getSex());
        assertEquals(date, result.get(0).getBirthDate());

    }

}
