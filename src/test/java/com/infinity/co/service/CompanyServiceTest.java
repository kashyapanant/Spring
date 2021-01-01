package com.infinity.co.service;

import com.infinity.co.entity.Company;
import com.infinity.co.exception.CompanyException;
import com.infinity.co.model.CompanyRequest;
import com.infinity.co.model.ResponseContext;
import com.infinity.co.repository.CompanyRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class CompanyServiceTest {

    @InjectMocks
    CompanyServiceImpl companyService;

    @Mock
    private CompanyRepository companyRepository;

    @Before
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void addCompaniesTest() {
        CompanyRequest request = new CompanyRequest();
        Company company = new Company();
        company.setCompanyName("XYZ");
        List<Company> companyList = new ArrayList<>();
        companyList.add(company);
        request.setCompanyList(companyList);
        Mockito.when(companyRepository.findByCompanyName("XYZ")).thenReturn(Optional.empty());
        Mockito.when(companyRepository.save(Mockito.any(Company.class))).thenReturn(null);
        ResponseContext response = companyService.addCompanies(request);
        Assert.assertNotNull(response);
        Assert.assertEquals("Success", response.getResponseMessage());
        Assert.assertEquals("0000", response.getResponseCode());
    }

    @Test
    public void addCompaniesAlreadyPresentTest() {
        CompanyRequest request = new CompanyRequest();
        Company company = new Company();
        company.setCompanyName("ABC");
        List<Company> companyList = new ArrayList<>();
        companyList.add(company);
        request.setCompanyList(companyList);
        Mockito.when(companyRepository.findByCompanyName("ABC")).thenReturn(Optional.of(new Company()));
        Mockito.when(companyRepository.save(Mockito.any(Company.class))).thenReturn(new Company());
        try {
            companyService.addCompanies(request);
        } catch (CompanyException e) {
            Assert.assertEquals("Company with name ABC already present", e.getMessage());
            Assert.assertEquals("NOT_ACCEPTABLE", e.getHttpStatus().name());
        }
    }

    @Test
    public void updateCompanyTest() {
        Company newCompany = new Company();
        newCompany.setCompanyName("New Name");
        newCompany.setCompanyCountry("New Country");
        String oldName = "Old Name";
        Company oldCompany = new Company();
        oldCompany.setCompanyName("Old Name");
        oldCompany.setCompanyCountry("Old Country");
        Mockito.when(companyRepository.findByCompanyName(oldName)).thenReturn(Optional.of(oldCompany));
        Mockito.when(companyRepository.save(Mockito.any(Company.class))).thenReturn(null);
        Company response = companyService.updateCompany(oldName, newCompany);
        Assert.assertNotNull(response);
        Assert.assertEquals("New Name", response.getCompanyName());
        Assert.assertEquals("New Country", response.getCompanyCountry());
    }

    @Test
    public void updateCompanyNotPresentTest() {
        Company newCompany = new Company();
        newCompany.setCompanyName("New Name");
        newCompany.setCompanyCountry("New Country");
        String oldName = "Old";
        Mockito.when(companyRepository.findByCompanyName(oldName)).thenReturn(Optional.empty());
        try {
            companyService.updateCompany(oldName, newCompany);
        }catch (CompanyException ex){
            Assert.assertEquals("Company with name Old not present", ex.getMessage());
            Assert.assertEquals("NOT_FOUND", ex.getHttpStatus().name());
        }
    }

    @Test
    public void searchCompaniesTest() throws CompanyException {
        String companyName = "XYZ";
        Company company = new Company();
        company.setCompanyName(companyName);
        company.setCompanyCountry("country");
        company.setCompanyPhone("987654321");
        Mockito.when(companyRepository.findByCompanyName(companyName)).thenReturn(Optional.of(company));
        Company response = companyService.searchCompany(companyName);
        Assert.assertNotNull(response);
        Assert.assertEquals("XYZ", response.getCompanyName());
        Assert.assertEquals("country", response.getCompanyCountry());
        Assert.assertEquals("987654321", response.getCompanyPhone());
    }

    @Test
    public void searchCompaniesAlreadyPresentTest(){
        String companyName = "ABC";
        Mockito.when(companyRepository.findByCompanyName(companyName)).thenReturn(Optional.empty());
        try {
            companyService.searchCompany(companyName);
        } catch (CompanyException e) {
            Assert.assertEquals("Company with name ABC not present", e.getMessage());
            Assert.assertEquals("NOT_FOUND", e.getHttpStatus().name());
        }
    }

}
