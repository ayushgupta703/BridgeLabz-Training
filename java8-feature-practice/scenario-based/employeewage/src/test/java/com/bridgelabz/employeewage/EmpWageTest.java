package com.bridgelabz.employeewage;

import com.bridgelabz.employeewage.model.CompanyEmpWage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmpWageTest {

    @Test
    void testCompanyCreation() {

        CompanyEmpWage company =
                new CompanyEmpWage("TCS",20,20,100);

        assertEquals("TCS", company.getCompanyName());
        assertEquals(20, company.getWagePerHour());
    }
}