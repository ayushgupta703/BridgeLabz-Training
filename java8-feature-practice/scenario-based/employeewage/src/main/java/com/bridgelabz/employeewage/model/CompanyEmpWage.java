package com.bridgelabz.employeewage.model;

import java.util.ArrayList;
import java.util.List;

public class CompanyEmpWage {

    private String companyName;
    private int wagePerHour;
    private int workingDays;
    private int maxHoursPerMonth;
    private int totalWage;
    private List<Integer> dailyWageList;

    public CompanyEmpWage(String companyName, int wagePerHour,
                          int workingDays, int maxHoursPerMonth) {

        this.companyName = companyName;
        this.wagePerHour = wagePerHour;
        this.workingDays = workingDays;
        this.maxHoursPerMonth = maxHoursPerMonth;
        this.dailyWageList = new ArrayList<>();
    }

    public String getCompanyName() { return companyName; }
    public int getWagePerHour() { return wagePerHour; }
    public int getWorkingDays() { return workingDays; }
    public int getMaxHoursPerMonth() { return maxHoursPerMonth; }
    public int getTotalWage() { return totalWage; }
    public List<Integer> getDailyWageList() { return dailyWageList; }

    public void setTotalWage(int totalWage) {
        this.totalWage = totalWage;
    }

    public void addDailyWage(int wage) {
        dailyWageList.add(wage);
    }
}