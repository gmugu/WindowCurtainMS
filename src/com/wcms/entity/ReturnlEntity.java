package com.wcms.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/1/19.
 */
@Entity
@Table(name = "returnl", schema = "windowcurtainms", catalog = "")
public class ReturnlEntity {
    private int id;
    private String no;
    private Date returnDate;
    private String comments;
    private EmployeeEntity operator;
    private WarehouseEntity warehouse;
    private SupplierEntity supplier;
    private List<ReturnDetailEntity> returnDetails;

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
    @Column(name = "return_date")
    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
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
    @JoinColumn(name = "operator_id",referencedColumnName = "id")
    public EmployeeEntity getOperator() {
        return operator;
    }

    public void setOperator(EmployeeEntity operator) {
        this.operator = operator;
    }

    @ManyToOne
    @JoinColumn(name = "warehouse_id",referencedColumnName = "id")
    public WarehouseEntity getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(WarehouseEntity warehouse) {
        this.warehouse = warehouse;
    }

    @ManyToOne
    @JoinColumn(name = "supplier_id",referencedColumnName = "id")
    public SupplierEntity getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierEntity supplier) {
        this.supplier = supplier;
    }

    @OneToMany(mappedBy = "returnl")
    public List<ReturnDetailEntity> getReturnDetails() {
        return returnDetails;
    }

    public void setReturnDetails(List<ReturnDetailEntity> returnDetails) {
        this.returnDetails = returnDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReturnlEntity that = (ReturnlEntity) o;

        if (id != that.id) return false;
        if (no != null ? !no.equals(that.no) : that.no != null) return false;
        if (returnDate != null ? !returnDate.equals(that.returnDate) : that.returnDate != null) return false;
        if (comments != null ? !comments.equals(that.comments) : that.comments != null) return false;
        if (operator != null ? !operator.equals(that.operator) : that.operator != null) return false;
        if (warehouse != null ? !warehouse.equals(that.warehouse) : that.warehouse != null) return false;
        if (supplier != null ? !supplier.equals(that.supplier) : that.supplier != null) return false;
        return !(returnDetails != null ? !returnDetails.equals(that.returnDetails) : that.returnDetails != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (no != null ? no.hashCode() : 0);
        result = 31 * result + (returnDate != null ? returnDate.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        result = 31 * result + (operator != null ? operator.hashCode() : 0);
        result = 31 * result + (warehouse != null ? warehouse.hashCode() : 0);
        result = 31 * result + (supplier != null ? supplier.hashCode() : 0);
        result = 31 * result + (returnDetails != null ? returnDetails.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ReturnlEntity{" +
                "id=" + id +
                ", no='" + no + '\'' +
                ", returnDate=" + returnDate +
                ", comments='" + comments + '\'' +
                ", operator=" + operator +
                ", warehouse=" + warehouse +
                ", supplier=" + supplier +
                ", returnDetails=" + returnDetails +
                '}';
    }
}
