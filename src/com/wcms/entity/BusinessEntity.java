package com.wcms.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/1/19.
 */
@Entity
@Table(name = "business", schema = "windowcurtainms", catalog = "")
public class BusinessEntity {
    private int id;
    private String no;
    private Date signTime;
    private String businessType;
    private Date appointmentTime;
    private String state;
    private Date acceptanceTime;
    private Double amount;
    private String comments;
    private CustomerEntity customer;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "no")
    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    @Basic
    @Column(name = "sign_time")
    public Date getSignTime() {
        return signTime;
    }

    public void setSignTime(Date signTime) {
        this.signTime = signTime;
    }

    @Basic
    @Column(name = "business_type")
    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    @Basic
    @Column(name = "appointment_time")
    public Date getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(Date appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    @Basic
    @Column(name = "state")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Basic
    @Column(name = "acceptance_time")
    public Date getAcceptanceTime() {
        return acceptanceTime;
    }

    public void setAcceptanceTime(Date acceptanceTime) {
        this.acceptanceTime = acceptanceTime;
    }

    @Basic
    @Column(name = "amount")
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "comments")
    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @ManyToOne
    @PrimaryKeyJoinColumn
    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BusinessEntity that = (BusinessEntity) o;

        if (id != that.id) return false;
        if (no != null ? !no.equals(that.no) : that.no != null) return false;
        if (signTime != null ? !signTime.equals(that.signTime) : that.signTime != null) return false;
        if (businessType != null ? !businessType.equals(that.businessType) : that.businessType != null) return false;
        if (appointmentTime != null ? !appointmentTime.equals(that.appointmentTime) : that.appointmentTime != null)
            return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (acceptanceTime != null ? !acceptanceTime.equals(that.acceptanceTime) : that.acceptanceTime != null)
            return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (comments != null ? !comments.equals(that.comments) : that.comments != null) return false;
        return !(customer != null ? !customer.equals(that.customer) : that.customer != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (no != null ? no.hashCode() : 0);
        result = 31 * result + (signTime != null ? signTime.hashCode() : 0);
        result = 31 * result + (businessType != null ? businessType.hashCode() : 0);
        result = 31 * result + (appointmentTime != null ? appointmentTime.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (acceptanceTime != null ? acceptanceTime.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BusinessEntity{" +
                "id=" + id +
                ", no='" + no + '\'' +
                ", signTime=" + signTime +
                ", businessType='" + businessType + '\'' +
                ", appointmentTime=" + appointmentTime +
                ", state='" + state + '\'' +
                ", acceptanceTime=" + acceptanceTime +
                ", amount=" + amount +
                ", comments='" + comments + '\'' +
                ", customer=" + customer +
                '}';
    }
}
