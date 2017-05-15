package com.wcms.entity;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/1/19.
 */
@Entity
@Table(name = "curtain", schema = "windowcurtainms", catalog = "")
public class CurtainEntity {
    private int id;
    private String no;
    private String specifications;
    private String brand;
    private String size;
    private String color;
    private double price;

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
    @Column(name = "specifications")
    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    @Basic
    @Column(name = "brand")
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Basic
    @Column(name = "size")
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Basic
    @Column(name = "color")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Basic
    @Column(name = "price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CurtainEntity that = (CurtainEntity) o;

        if (id != that.id) return false;
        if (Double.compare(that.price, price) != 0) return false;
        if (no != null ? !no.equals(that.no) : that.no != null) return false;
        if (specifications != null ? !specifications.equals(that.specifications) : that.specifications != null)
            return false;
        if (brand != null ? !brand.equals(that.brand) : that.brand != null) return false;
        if (size != null ? !size.equals(that.size) : that.size != null) return false;
        return !(color != null ? !color.equals(that.color) : that.color != null);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (no != null ? no.hashCode() : 0);
        result = 31 * result + (specifications != null ? specifications.hashCode() : 0);
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "CurtainEntity{" +
                "id=" + id +
                ", no='" + no + '\'' +
                ", specifications='" + specifications + '\'' +
                ", brand='" + brand + '\'' +
                ", size='" + size + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}
