package com.bridgelabz.employeewage.controller;

import com.bridgelabz.employeewage.model.CompanyEmpWage;
import com.bridgelabz.employeewage.repository.*;
import com.bridgelabz.employeewage.service.*;

public class EmpWageController {

    public static void main(String[] args) {

        IEmpWageRepository repo = new EmpWageRepositoryImpl();
        IEmpWageService service = new EmpWageServiceImpl(repo);

        repo.addCompany(new CompanyEmpWage("TCS", 20, 20, 100));
        repo.addCompany(new CompanyEmpWage("Infosys", 25, 22, 120));

        service.computeWage("TCS");
        service.computeWage("Infosys");

        System.out.println("TCS Total Wage: "
                + service.getTotalWage("TCS"));

        System.out.println("Infosys Total Wage: "
                + service.getTotalWage("Infosys"));
    }
}