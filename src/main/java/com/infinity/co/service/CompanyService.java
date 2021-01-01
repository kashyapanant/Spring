package com.infinity.co.service;

import com.infinity.co.entity.Company;
import com.infinity.co.model.CompanyRequest;
import com.infinity.co.model.ResponseContext;

import java.util.List;

public interface CompanyService {

    ResponseContext addCompanies(CompanyRequest request) throws Exception;

    List<Company> getCompanies();

    Company searchCompany(String companyName);

    Company updateCompany(String name, Company company);
}
