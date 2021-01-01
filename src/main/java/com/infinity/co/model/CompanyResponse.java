package com.infinity.co.model;

import com.infinity.co.entity.Company;

import java.io.Serializable;
import java.util.List;

public class CompanyResponse implements Serializable {

    private static final long serialVersionUID = -2373513648560502034L;

    private List<Company> companyList;
    private ResponseContext responseContext;

    public List<Company> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<Company> companyList) {
        this.companyList = companyList;
    }

    public ResponseContext getResponseContext() {
        return responseContext;
    }

    public void setResponseContext(ResponseContext responseContext) {
        this.responseContext = responseContext;
    }

    @Override
    public String toString() {
        return "CompanyResponse{" +
                "companyList=" + companyList +
                ", responseContext=" + responseContext +
                '}';
    }
}
