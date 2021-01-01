package com.infinity.co.service;

import com.infinity.co.entity.Company;
import com.infinity.co.entity.Owner;
import com.infinity.co.exception.CompanyException;
import com.infinity.co.exception.OwnerException;
import com.infinity.co.model.OwnerRequest;
import com.infinity.co.model.ResponseContext;
import com.infinity.co.repository.CompanyRepository;
import com.infinity.co.repository.OwnerRepository;
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
public class OwnerServiceTest {

    @InjectMocks
    OwnerServiceImpl ownerService;

    @Mock
    private CompanyRepository companyRepository;

    @Mock
    private OwnerRepository ownerRepository;

    @Before
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void addOwnersTest() {
        OwnerRequest request = new OwnerRequest();
        Owner owner = new Owner();
        owner.setOwnerName("Test");
        owner.setOwnerSsn("ssn321");
        Company company = new Company();
        company.setCompanyId(123);
        company.setCompanyName("XYZ");
        company.setCompanyCountry("country");
        company.setCompanyPhone("987654321");
        owner.setCompany(company);
        List<Owner> ownerList = new ArrayList<>();
        ownerList.add(owner);
        request.setOwnersList(ownerList);
        Mockito.when(companyRepository.findById(123)).thenReturn(Optional.of(company));
        Mockito.when(ownerRepository.save(Mockito.any(Owner.class))).thenReturn(null);
        ResponseContext response = ownerService.addOwners(request);
        Assert.assertNotNull(response);
        Assert.assertEquals("Success", response.getResponseMessage());
        Assert.assertEquals("0000", response.getResponseCode());
    }

    @Test
    public void addOwnerCompanyNotPresentTest() {
        OwnerRequest request = new OwnerRequest();
        Owner owner = new Owner();
        owner.setOwnerName("Test");
        owner.setOwnerSsn("ssn321");
        Company company = new Company();
        company.setCompanyId(123);
        company.setCompanyName("XYZ");
        company.setCompanyCountry("country");
        company.setCompanyPhone("987654321");
        owner.setCompany(company);
        List<Owner> ownerList = new ArrayList<>();
        ownerList.add(owner);
        request.setOwnersList(ownerList);
        Mockito.when(companyRepository.findById(123)).thenReturn(Optional.empty());
        try {
            ownerService.addOwners(request);
        } catch (CompanyException e) {
            Assert.assertEquals("Company doesn't exist", e.getMessage());
            Assert.assertEquals("NOT_FOUND", e.getHttpStatus().name());
        }
    }

    @Test
    public void getOwnersTest(){
        String ssn = "ssn123";
        Mockito.when(ownerRepository.findByOwnerSsn(ssn)).thenReturn(Optional.of(new Owner()));
        String response = ownerService.getOwners(ssn);
        Assert.assertNotNull(response);
        Assert.assertEquals("Valid", response);
    }

    @Test
    public void getOwnersInvalidTest(){
        String ssn = "ssn123";
        Mockito.when(ownerRepository.findByOwnerSsn(ssn)).thenReturn(Optional.empty());
        try {
            ownerService.getOwners(ssn);
        }catch (OwnerException ex){
            Assert.assertEquals("Invalid", ex.getMessage());
        }
    }

}
