package com.bridgelabz.employeewage.repository;

import com.bridgelabz.employeewage.model.CompanyEmpWage;
import java.util.List;

public interface IEmpWageRepository {

    void addCompany(CompanyEmpWage company);
    List<CompanyEmpWage> getAllCompanies();
    CompanyEmpWage getCompanyByName(String name);
}