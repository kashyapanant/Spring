package com.infinity.co.service;

import com.infinity.co.constants.Constants;
import com.infinity.co.entity.Company;
import com.infinity.co.exception.CompanyException;
import com.infinity.co.model.CompanyRequest;
import com.infinity.co.model.ResponseContext;
import com.infinity.co.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("companyService")
public class CompanyServiceImpl implements CompanyService{

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public ResponseContext addCompanies(CompanyRequest request) throws CompanyException {
        List<Company> companyList = request.getCompanyList();
        String companyName = "";
            for (Company c : companyList) {
                companyName = c.getCompanyName();
                Optional<Company> company = companyRepository.findByCompanyName(companyName);
                if(company.isEmpty())
                companyRepository.save(c);
                else {
                    String message = String.format("Company with name %s already present",companyName);
                    throw new CompanyException(message, HttpStatus.NOT_ACCEPTABLE);
                }
            }
        ResponseContext response = new ResponseContext();
        response.setResponseCode(Constants.SUCCESS_CODE);
        response.setResponseMessage(Constants.SUCCESS);
        return response;
    }

    public List<Company> getCompanies() {
        return companyRepository.findAll();
    }

    public Company searchCompany(String companyName)throws CompanyException {
        String message = String.format("Company with name %s not present",companyName);
        return companyRepository.findByCompanyName(companyName).
                orElseThrow(()-> new CompanyException(message, HttpStatus.NOT_FOUND));
    }

    @Override
    public Company updateCompany(String name, Company company) throws CompanyException{
        String message = String.format("Company with name %s not present",name);
       Company comp = companyRepository.findByCompanyName(name).
               orElseThrow(() -> new CompanyException(message, HttpStatus.NOT_FOUND));
        comp.setCompanyCountry(company.getCompanyCountry());
        comp.setCompanyPhone(company.getCompanyPhone());
        comp.setCompanyName(company.getCompanyName());
        comp.setOwner(company.getOwner());
        companyRepository.save(comp);
        return company;
    }

}
