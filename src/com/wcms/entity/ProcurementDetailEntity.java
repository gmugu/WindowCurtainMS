package com.wcms.entity;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/1/19.
 */
@Entity
@Table(name = "procurement_detail", schema = "windowcurtainms", catalog = "")
public class ProcurementDetailEntity {
    private int id;
    private int counts;
    private ProcurementEntity procurement;
    private MaterialEntity material;

    @Id
    @Column(name = "id")
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
    @JoinColumn(name = "procurement_id", referencedColumnName = "id")
    public ProcurementEntity getProcurement() {
        return procurement;
    }


    public void setProcurement(ProcurementEntity procurement) {
        this.procurement = procurement;
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

        ProcurementDetailEntity that = (ProcurementDetailEntity) o;

        if (id != that.id) return false;
        if (counts != that.counts) return false;
        if (procurement != null ? procurement.getId()!=that.getId() : that.procurement != null) return false;
        return !(material != null ? !material.equals(that.material) : that.material != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + counts;
        result = 31 * result + (procurement != null ? procurement.getId() : 0);
        result = 31 * result + (material != null ? material.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ProcurementDetailEntity{" +
                "id=" + id +
                ", counts=" + counts +
                ", procurement=" + procurement.getId() +
                ", material=" + material +
                '}';
    }
}
