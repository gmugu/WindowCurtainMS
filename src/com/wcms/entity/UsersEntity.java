package com.wcms.entity;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/2/1.
 */
@Entity
@Table(name = "users", schema = "windowcurtainms", catalog = "")
public class UsersEntity {
    private String username;
    private String password;
    private int auBasic;
    private int auStore;
    private int auOrder;
    private int auBusiness;
    private int auFinancial;

    @Id
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "au_basic")
    public int getAuBasic() {
        return auBasic;
    }

    public void setAuBasic(int auBasic) {
        this.auBasic = auBasic;
    }

    @Basic
    @Column(name = "au_store")
    public int getAuStore() {
        return auStore;
    }

    public void setAuStore(int auStore) {
        this.auStore = auStore;
    }

    @Basic
    @Column(name = "au_order")
    public int getAuOrder() {
        return auOrder;
    }

    public void setAuOrder(int auOrder) {
        this.auOrder = auOrder;
    }

    @Basic
    @Column(name = "au_business")
    public int getAuBusiness() {
        return auBusiness;
    }

    public void setAuBusiness(int auBusiness) {
        this.auBusiness = auBusiness;
    }

    @Basic
    @Column(name = "au_financial")
    public int getAuFinancial() {
        return auFinancial;
    }

    public void setAuFinancial(int auFinancial) {
        this.auFinancial = auFinancial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersEntity that = (UsersEntity) o;

        if (auBasic != that.auBasic) return false;
        if (auStore != that.auStore) return false;
        if (auOrder != that.auOrder) return false;
        if (auBusiness != that.auBusiness) return false;
        if (auFinancial != that.auFinancial) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        return !(password != null ? !password.equals(that.password) : that.password != null);

    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + auBasic;
        result = 31 * result + auStore;
        result = 31 * result + auOrder;
        result = 31 * result + auBusiness;
        result = 31 * result + auFinancial;
        return result;
    }

    @Override
    public String toString() {
        return "UsersEntity{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", auBasic=" + auBasic +
                ", auStore=" + auStore +
                ", auOrder=" + auOrder +
                ", auBusiness=" + auBusiness +
                ", auFinancial=" + auFinancial +
                '}';
    }
}
