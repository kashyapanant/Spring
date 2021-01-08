package com.infinity.co.controller;

import com.infinity.co.entity.Company;
import com.infinity.co.exception.CompanyException;
import com.infinity.co.model.CompanyRequest;
import com.infinity.co.model.ResponseContext;
import com.infinity.co.repository.CompanyRepository;
import com.infinity.co.repository.OwnerRepository;
import com.infinity.co.service.CompanyService;
import com.infinity.co.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @Autowired
    private OwnerService ownerService;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private OwnerRepository ownerRepository;


    @GetMapping("/companies")
    public @ResponseBody ResponseEntity<List<Company>> get() {
        List<Company>  response= companyService.getCompanies();
        return  new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/companies")
    public ResponseEntity<ResponseContext> addCompanies(@RequestBody CompanyRequest companyRequest) throws Exception {
        ResponseContext response = companyService.addCompanies(companyRequest);
        response.setRequestId(companyRequest.getRequestContext().getRequestId());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/company")
    public @ResponseBody ResponseEntity<Company> get(@RequestParam String name) throws CompanyException {
        Company company = companyService.searchCompany(name);
        return  new ResponseEntity<>(company, HttpStatus.OK);
    }

    @PutMapping("/companies/{name}")
    public @ResponseBody ResponseEntity<Company> updateCompany(
            @RequestBody Company company, @PathVariable(value = "name") String name){
        Company response = companyService.updateCompany(name, company);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
