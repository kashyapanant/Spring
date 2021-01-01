package com.infinity.co.model;

import java.io.Serializable;

public class RequestContext implements Serializable {

    private static final long serialVersionUID = -4541983726294277096L;

    private String requestId;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
