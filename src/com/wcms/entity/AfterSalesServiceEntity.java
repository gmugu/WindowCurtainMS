package com.wcms.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/1/19.
 */
@Entity
@Table(name = "after_sales_service", schema = "windowcurtainms", catalog = "")
public class AfterSalesServiceEntity {
    private int id;
    private String no;
    private Date time;
    private String comments;
    private CustomerEntity customer;
    private EmployeeEntity employee;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Column(name = "time")
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
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

    @ManyToOne
    @PrimaryKeyJoinColumn
    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AfterSalesServiceEntity that = (AfterSalesServiceEntity) o;

        if (id != that.id) return false;
        if (no != null ? !no.equals(that.no) : that.no != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (comments != null ? !comments.equals(that.comments) : that.comments != null) return false;
        if (customer != null ? !customer.equals(that.customer) : that.customer != null) return false;
        return !(employee != null ? !employee.equals(that.employee) : that.employee != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (no != null ? no.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        result = 31 * result + (employee != null ? employee.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AfterSalesServiceEntity{" +
                "id=" + id +
                ", no='" + no + '\'' +
                ", time=" + time +
                ", comments='" + comments + '\'' +
                ", customer=" + customer +
                ", employee=" + employee +
                '}';
    }
}
