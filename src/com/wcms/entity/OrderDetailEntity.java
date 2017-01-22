package com.wcms.entity;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/1/19.
 */
@Entity
@Table(name = "order_detail", schema = "windowcurtainms", catalog = "")
public class OrderDetailEntity {
    private int id;
    private String location;
    private Double height;
    private Double width;
    private Integer count;
    private String comments;
    private CurtainEntity curtain;
    private OrderlEntity order;

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
    @Column(name = "location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Basic
    @Column(name = "height")
    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    @Basic
    @Column(name = "width")
    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    @Basic
    @Column(name = "count")
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
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
    @JoinColumn(name = "curtain_id", referencedColumnName = "id")
    public CurtainEntity getCurtain() {
        return curtain;
    }

    public void setCurtain(CurtainEntity curtain) {
        this.curtain = curtain;
    }

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    public OrderlEntity getOrder() {
        return order;
    }

    public void setOrder(OrderlEntity order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderDetailEntity that = (OrderDetailEntity) o;

        if (id != that.id) return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;
        if (height != null ? !height.equals(that.height) : that.height != null) return false;
        if (width != null ? !width.equals(that.width) : that.width != null) return false;
        if (count != null ? !count.equals(that.count) : that.count != null) return false;
        if (comments != null ? !comments.equals(that.comments) : that.comments != null) return false;
        if (curtain != null ? !curtain.equals(that.curtain) : that.curtain != null) return false;
        return !(order != null ? order.getId()!=that.getId() : that.order != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (height != null ? height.hashCode() : 0);
        result = 31 * result + (width != null ? width.hashCode() : 0);
        result = 31 * result + (count != null ? count.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        result = 31 * result + (curtain != null ? curtain.hashCode() : 0);
        result = 31 * result + (order != null ? order.getId() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OrderDetailEntity{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", height=" + height +
                ", width=" + width +
                ", count=" + count +
                ", comments='" + comments + '\'' +
                ", curtain=" + curtain +
                ", orderl_id=" + order.getId() +
                '}';
    }
}
