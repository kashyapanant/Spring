package com.infinity.co.model;

import com.infinity.co.entity.Company;

import java.io.Serializable;
import java.util.List;

public class CompanyRequest implements Serializable {

    private static final long serialVersionUID = -891663011683068535L;

    private List<Company> companyList;
    private RequestContext requestContext;

    public List<Company> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<Company> companyList) {
        this.companyList = companyList;
    }

    public RequestContext getRequestContext() {
        return requestContext;
    }

    public void setRequestContext(RequestContext requestContext) {
        this.requestContext = requestContext;
    }

    @Override
    public String toString() {
        return "CompanyRequest{" +
                "companyList=" + companyList +
                ", requestContext=" + requestContext +
                '}';
    }
}
