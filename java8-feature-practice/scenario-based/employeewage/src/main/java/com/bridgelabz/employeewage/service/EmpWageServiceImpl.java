package com.bridgelabz.employeewage.service;

import com.bridgelabz.employeewage.model.CompanyEmpWage;
import com.bridgelabz.employeewage.repository.IEmpWageRepository;

public class EmpWageServiceImpl implements IEmpWageService {

    private IEmpWageRepository repository;

    public EmpWageServiceImpl(IEmpWageRepository repository) {
        this.repository = repository;
    }

    @Override
    public void computeWage(String companyName) {

        CompanyEmpWage company =
                repository.getCompanyByName(companyName);

        int totalHours = 0;
        int totalDays = 0;

        while (totalHours <= company.getMaxHoursPerMonth()
                && totalDays < company.getWorkingDays()) {

            totalDays++;

            int empCheck = (int)(Math.random() * 3);
            int empHrs;

            switch (empCheck) {
                case 1: empHrs = 4; break;   // Part Time
                case 2: empHrs = 8; break;   // Full Time
                default: empHrs = 0;         // Absent
            }

            int dailyWage = empHrs * company.getWagePerHour();
            company.addDailyWage(dailyWage);

            totalHours += empHrs;
        }

        company.setTotalWage(totalHours *
                company.getWagePerHour());
    }

    @Override
    public int getTotalWage(String companyName) {
        return repository.getCompanyByName(companyName)
                .getTotalWage();
    }
}