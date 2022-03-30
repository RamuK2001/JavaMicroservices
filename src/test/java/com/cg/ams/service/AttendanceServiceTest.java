package com.cg.ams.service;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.ams.entity.Attendance;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
//@Disabled
class UserServiceTest {

    @Autowired
    IAttendanceService attServ;

    @Test
//    @Disabled
    void add() throws ParseException {  // Just Tested Once (don't want to add records to DB)
        Attendance att = new Attendance();
        att.setId(1);
        
        att.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("1988-01-29T11:04:54.511Z"));
        att.setStatus(1);
        att.setTotal(10);
        att.setPercentage("90");
        att.setTotalClass("full");

        long dbCount = attServ.count();
        attServ.add(att);

        assertEquals(dbCount,attServ.count());
    }

    @Test
    void updateTest() {
    	long testId = 3;  // Hard coded
        Attendance att = attServ.findByPk(testId);  

        // Updating value
        Long statusId = 2L;
        att.setStatus(statusId);
        attServ.update(att);

        Attendance updatedAtt = attServ.findByPk(testId);

        assertEquals(2, updatedAtt.getStatus());
    }

    @Test
    @Disabled
    void deleteTest() {
        long beforeDeleteCount = attServ.count();
        long testId = 10;
        Attendance dbAtt = attServ.findByPk(testId);

        attServ.delete(dbAtt);

        long afterDeleteCount = attServ.count();

        assertEquals(beforeDeleteCount, afterDeleteCount + 1);
    }

   

    @Test
    void findByPkTest() {
        long testId = 1; 
        Attendance att = attServ.findByPk(testId);

        assertEquals("90", att.getPercentage());
       
    }

    

   
}
