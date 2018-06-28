package com.father.service;

import com.Application;
import com.family.dao.entity.Family;
import com.father.dao.dto.FatherDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.time.LocalDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class FatherServiceTest {

    private static final Family FAMILY = new Family();

    @InjectMocks
    @Autowired
    protected FatherService testedObject;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void createShouldCreateFather() {

        final String name = "Adam";
        final String lastName = "Smith";
        final String pesel = "12345678912";
        final LocalDate date = LocalDate.now();

        FatherDto result = testedObject.create(new FatherDto(name,lastName,pesel,date),FAMILY.getId());

        assertNotNull(result);
        assertEquals(name, result.getName());
        assertEquals(lastName, result.getLastName());
        assertEquals(pesel, result.getPesel());
        assertEquals(date, result.getBirthDate());

    }

}
