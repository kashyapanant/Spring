package com.infinity.co.service;

import com.infinity.co.constants.Constants;
import com.infinity.co.entity.Owner;
import com.infinity.co.exception.CompanyException;
import com.infinity.co.exception.OwnerException;
import com.infinity.co.model.OwnerRequest;
import com.infinity.co.model.ResponseContext;
import com.infinity.co.repository.CompanyRepository;
import com.infinity.co.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ownerService")
public class OwnerServiceImpl implements OwnerService{

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public ResponseContext addOwners(OwnerRequest request) {
        List<Owner> ownerList = request.getOwnersList();
        String ssn = "";
        try {
            for (Owner owner : ownerList) {
                companyRepository.findById(owner.getCompany().getCompanyId()).
                        orElseThrow(() -> new CompanyException(String.format("Company doesn't exist"), HttpStatus.NOT_FOUND));
                ssn=owner.getOwnerSsn();
                ownerRepository.save(owner);
            }
        }catch (CompanyException ce){
            throw new CompanyException(ce.getMessage(),ce.getHttpStatus());
        }
        catch (Exception ex){
            String message = String.format("Owner with SSN %s already present",ssn);
            throw new OwnerException(message, HttpStatus.NOT_ACCEPTABLE);
        }
        ResponseContext response = new ResponseContext();
        response.setResponseCode(Constants.SUCCESS_CODE);
        response.setResponseMessage(Constants.SUCCESS);
        return response;
    }

    @Override
    public String getOwners(String ssn){
        ownerRepository.findByOwnerSsn(ssn).orElseThrow(
                () -> new OwnerException("Invalid", HttpStatus.NOT_FOUND));
        return "Valid";
    }
}
