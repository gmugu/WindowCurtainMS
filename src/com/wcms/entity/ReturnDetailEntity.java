package com.wcms.entity;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/1/19.
 */
@Entity
@Table(name = "return_detail", schema = "windowcurtainms", catalog = "")
public class ReturnDetailEntity {
    private int id;
    private int counts;
    private MaterialEntity material;
    private ReturnlEntity returnl;

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

    @ManyToOne
    @JoinColumn(name = "material_id",referencedColumnName = "id")
    public MaterialEntity getMaterial() {
        return material;
    }

    public void setMaterial(MaterialEntity material) {
        this.material = material;
    }

    @ManyToOne
    @JoinColumn(name = "return_id",referencedColumnName = "id")
    public ReturnlEntity getReturnl() {
        return returnl;
    }

    public void setReturnl(ReturnlEntity returnl) {
        this.returnl = returnl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReturnDetailEntity that = (ReturnDetailEntity) o;

        if (id != that.id) return false;
        if (counts != that.counts) return false;
        if (material != null ? !material.equals(that.material) : that.material != null) return false;
        return !(returnl != null ? returnl.getId()!=that.getId() : that.returnl != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + counts;
        result = 31 * result + (material != null ? material.hashCode() : 0);
        result = 31 * result + (returnl != null ? returnl.getId() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ReturnDetailEntity{" +
                "id=" + id +
                ", counts=" + counts +
                ", material=" + material +
                ", returnl=" + returnl.getId() +
                '}';
    }
}
