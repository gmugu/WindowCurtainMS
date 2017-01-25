package com.wcms.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/1/19.
 */
@Entity
@Table(name = "orderl", schema = "windowcurtainms", catalog = "")
public class OrderlEntity {
    private int id;
    private String no;
    private Date orderTime;
    private Date deliveryTime;
    private Double downpayment;
    private String state;
    private Date acceptanceTime;
    private Double amountPaid;
    private String comments;
    private CustomerEntity customer;
//    private List<OrderDetailEntity> orderDetails;

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
    @Column(name = "order_time")
    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    @Basic
    @Column(name = "delivery_time")
    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    @Basic
    @Column(name = "downpayment")
    public Double getDownpayment() {
        return downpayment;
    }

    public void setDownpayment(Double downpayment) {
        this.downpayment = downpayment;
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
    @Column(name = "amount_paid")
    public Double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Double amountPaid) {
        this.amountPaid = amountPaid;
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
    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

//    @OneToMany(mappedBy = "order")
//    public List<OrderDetailEntity> getOrderDetails() {
//        return orderDetails;
//    }
//
//    public void setOrderDetails(List<OrderDetailEntity> orderDetails) {
//        this.orderDetails = orderDetails;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderlEntity that = (OrderlEntity) o;

        if (id != that.id) return false;
        if (no != null ? !no.equals(that.no) : that.no != null) return false;
        if (orderTime != null ? !orderTime.equals(that.orderTime) : that.orderTime != null) return false;
        if (deliveryTime != null ? !deliveryTime.equals(that.deliveryTime) : that.deliveryTime != null) return false;
        if (downpayment != null ? !downpayment.equals(that.downpayment) : that.downpayment != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (acceptanceTime != null ? !acceptanceTime.equals(that.acceptanceTime) : that.acceptanceTime != null)
            return false;
        if (amountPaid != null ? !amountPaid.equals(that.amountPaid) : that.amountPaid != null) return false;
        if (comments != null ? !comments.equals(that.comments) : that.comments != null) return false;
        if (customer != null ? !customer.equals(that.customer) : that.customer != null) return false;
//        return !(orderDetails != null ? !orderDetails.equals(that.orderDetails) : that.orderDetails != null);
return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (no != null ? no.hashCode() : 0);
        result = 31 * result + (orderTime != null ? orderTime.hashCode() : 0);
        result = 31 * result + (deliveryTime != null ? deliveryTime.hashCode() : 0);
        result = 31 * result + (downpayment != null ? downpayment.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (acceptanceTime != null ? acceptanceTime.hashCode() : 0);
        result = 31 * result + (amountPaid != null ? amountPaid.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
//        result = 31 * result + (orderDetails != null ? orderDetails.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OrderlEntity{" +
                "id=" + id +
                ", no='" + no + '\'' +
                ", orderTime=" + orderTime +
                ", deliveryTime=" + deliveryTime +
                ", downpayment=" + downpayment +
                ", state='" + state + '\'' +
                ", acceptanceTime=" + acceptanceTime +
                ", amountPaid=" + amountPaid +
                ", comments='" + comments + '\'' +
                ", customer=" + customer +
//                ", orderDetails=" + orderDetails +
                '}';
    }
}
