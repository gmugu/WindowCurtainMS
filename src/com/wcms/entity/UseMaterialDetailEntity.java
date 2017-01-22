package com.wcms.entity;

import javax.persistence.*;
import javax.persistence.criteria.Order;

/**
 * Created by Administrator on 2017/1/19.
 */
@Entity
@Table(name = "use_material_detail", schema = "windowcurtainms", catalog = "")
public class UseMaterialDetailEntity {
    private int id;
    private int counts;
    private String comments;
    private OrderlEntity order;
    private MaterialEntity material;

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
    @Column(name = "counts")
    public int getCounts() {
        return counts;
    }

    public void setCounts(int counts) {
        this.counts = counts;
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
    @JoinColumn(name = "order_id",referencedColumnName = "id")
    public OrderlEntity getOrder() {
        return order;
    }

    public void setOrder(OrderlEntity order) {
        this.order = order;
    }

    @ManyToOne
    @JoinColumn(name = "material_id",referencedColumnName = "id")
    public MaterialEntity getMaterial() {
        return material;
    }

    public void setMaterial(MaterialEntity material) {
        this.material = material;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UseMaterialDetailEntity that = (UseMaterialDetailEntity) o;

        if (id != that.id) return false;
        if (counts != that.counts) return false;
        if (comments != null ? !comments.equals(that.comments) : that.comments != null) return false;
        if (order != null ? !order.equals(that.order) : that.order != null) return false;
        return !(material != null ? !material.equals(that.material) : that.material != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + counts;
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        result = 31 * result + (order != null ? order.hashCode() : 0);
        result = 31 * result + (material != null ? material.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UseMaterialDetailEntity{" +
                "id=" + id +
                ", counts=" + counts +
                ", comments='" + comments + '\'' +
                ", order=" + order +
                ", material=" + material +
                '}';
    }
}
