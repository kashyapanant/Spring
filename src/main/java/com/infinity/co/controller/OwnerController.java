package com.infinity.co.controller;

import com.infinity.co.exception.OwnerException;
import com.infinity.co.model.OwnerRequest;
import com.infinity.co.model.ResponseContext;
import com.infinity.co.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @PostMapping("/owner")
    public ResponseEntity<ResponseContext> addOwner(@RequestBody OwnerRequest request) throws OwnerException {
        ResponseContext response = ownerService.addOwners(request);
        response.setRequestId(request.getRequestContext().getRequestId());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/owner")
    public ResponseEntity<String> getOwner(@RequestBody String ssn) throws OwnerException {
        String response = ownerService.getOwners(ssn);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
