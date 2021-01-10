package com.infinity.co.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "owner")
public class Owner implements Serializable {

    private static final long serialVersionUID = 377846748006283344L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "owner_id")
    private Integer ownerId;

    @Column(name = "owner_name")
    private String ownerName;

    @Column(name = "owner_ssn")
    private String ownerSsn;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "company")
    private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getOwnerSsn() {
        return ownerSsn;
    }

    public void setOwnerSsn(String ownerSsn) {
        this.ownerSsn = ownerSsn;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }


}
