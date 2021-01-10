package com.infinity.co.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="company")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","ownerList"})
public class Company implements Serializable {

    private static final long serialVersionUID = -7805062159899664617L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "company_name", unique = true)
    private String companyName;

    @Column(name = "company_country")
    private String companyCountry;

    @Column(name = "company_phone", unique = true)
    private String companyPhone;

    @OneToMany(mappedBy = "company",fetch = FetchType.LAZY)
    private List<Owner> ownerList;

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyCountry() {
        return companyCountry;
    }

    public void setCompanyCountry(String companyCountry) {
        this.companyCountry = companyCountry;
    }

    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public List<Owner> getOwner() {
        return ownerList;
    }

    public void setOwner(List<Owner> ownerList) {
        this.ownerList = ownerList;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", companyCountry='" + companyCountry + '\'' +
                ", companyPhone='" + companyPhone + '\'' +
                ", ownerList=" + ownerList +
                '}';
    }
}
