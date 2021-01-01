package com.infinity.co.service;

import com.infinity.co.model.OwnerRequest;
import com.infinity.co.model.ResponseContext;

public interface OwnerService {

    ResponseContext addOwners(OwnerRequest request);

    public String getOwners(String ssn);
}
