package com.bridgelabz.employeewage.repository;

import com.bridgelabz.employeewage.model.CompanyEmpWage;
import java.util.ArrayList;
import java.util.List;

public class EmpWageRepositoryImpl implements IEmpWageRepository {

    private List<CompanyEmpWage> companyList = new ArrayList<>();

    @Override
    public void addCompany(CompanyEmpWage company) {
        companyList.add(company);
    }

    @Override
    public List<CompanyEmpWage> getAllCompanies() {
        return companyList;
    }

    @Override
    public CompanyEmpWage getCompanyByName(String name) {
        return companyList.stream()
                .filter(c -> c.getCompanyName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
}