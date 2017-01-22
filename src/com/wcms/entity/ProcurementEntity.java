package com.wcms.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/1/19.
 */
@Entity
@Table(name = "procurement", schema = "windowcurtainms", catalog = "")
public class ProcurementEntity {
    private int id;
    private String no;
    private Date buyDate;
    private Double amountPaid;
    private EmployeeEntity operator;
    private WarehouseEntity warehouse;
    private SupplierEntity supplier;
    private List<ProcurementDetailEntity> procurementDetails;

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
    @Column(name = "buy_date")
    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    @Basic
    @Column(name = "amount_paid")
    public Double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Double amountPaid) {
        this.amountPaid = amountPaid;
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

    @OneToMany(mappedBy = "procurement")
    public List<ProcurementDetailEntity> getProcurementDetails() {
        return procurementDetails;
    }

    public void setProcurementDetails(List<ProcurementDetailEntity> procurementDetails) {
        this.procurementDetails = procurementDetails;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProcurementEntity that = (ProcurementEntity) o;

        if (id != that.id) return false;
        if (no != null ? !no.equals(that.no) : that.no != null) return false;
        if (buyDate != null ? !buyDate.equals(that.buyDate) : that.buyDate != null) return false;
        if (amountPaid != null ? !amountPaid.equals(that.amountPaid) : that.amountPaid != null) return false;
        if (operator != null ? !operator.equals(that.operator) : that.operator != null) return false;
        if (warehouse != null ? !warehouse.equals(that.warehouse) : that.warehouse != null) return false;
        if (supplier != null ? !supplier.equals(that.supplier) : that.supplier != null) return false;
        return !(procurementDetails != null ? !procurementDetails.equals(that.procurementDetails) : that.procurementDetails != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (no != null ? no.hashCode() : 0);
        result = 31 * result + (buyDate != null ? buyDate.hashCode() : 0);
        result = 31 * result + (amountPaid != null ? amountPaid.hashCode() : 0);
        result = 31 * result + (operator != null ? operator.hashCode() : 0);
        result = 31 * result + (warehouse != null ? warehouse.hashCode() : 0);
        result = 31 * result + (supplier != null ? supplier.hashCode() : 0);
        result = 31 * result + (procurementDetails != null ? procurementDetails.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ProcurementEntity{" +
                "id=" + id +
                ", no='" + no + '\'' +
                ", buyDate=" + buyDate +
                ", amountPaid=" + amountPaid +
                ", operator=" + operator +
                ", warehouse=" + warehouse +
                ", supplier=" + supplier +
                ", procurementDetails=" + procurementDetails +
                '}';
    }
}
