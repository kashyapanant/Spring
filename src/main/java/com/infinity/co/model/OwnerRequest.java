package com.infinity.co.model;

import com.infinity.co.entity.Owner;

import java.io.Serializable;
import java.util.List;

public class OwnerRequest implements Serializable {

    private static final long serialVersionUID = 6986648082947332363L;

    private List<Owner> ownerList;
    private RequestContext requestContext;

    public List<Owner> getOwnersList() {
        return ownerList;
    }

    public void setOwnersList(List<Owner> ownerList) {
        this.ownerList = ownerList;
    }

    public RequestContext getRequestContext() {
        return requestContext;
    }

    public void setRequestContext(RequestContext requestContext) {
        this.requestContext = requestContext;
    }

    @Override
    public String toString() {
        return "OwnerRequest{" +
                "ownersList=" + ownerList +
                ", requestContext=" + requestContext +
                '}';
    }
}
