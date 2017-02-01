package com.wcms.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/1/19.
 */
@Entity
@Table(name = "salary", schema = "windowcurtainms", catalog = "")
public class SalaryEntity {
    private int id;
    private String year;
    private String month;
    private Double basic;
    private Double performance;
    private Double bonus;
    private Double cut;
    private String comments;
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
    @Column(name = "year")
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Basic
    @Column(name = "month")
    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    @Basic
    @Column(name = "basic")
    public Double getBasic() {
        return basic;
    }

    public void setBasic(Double basic) {
        this.basic = basic;
    }

    @Basic
    @Column(name = "performance")
    public Double getPerformance() {
        return performance;
    }

    public void setPerformance(Double performance) {
        this.performance = performance;
    }

    @Basic
    @Column(name = "bonus")
    public Double getBonus() {
        return bonus;
    }

    public void setBonus(Double bonus) {
        this.bonus = bonus;
    }

    @Basic
    @Column(name = "cut")
    public Double getCut() {
        return cut;
    }

    public void setCut(Double cut) {
        this.cut = cut;
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
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
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

        SalaryEntity that = (SalaryEntity) o;

        if (id != that.id) return false;
        if (year != null ? !year.equals(that.year) : that.year != null) return false;
        if (month != null ? !month.equals(that.month) : that.month != null) return false;
        if (basic != null ? !basic.equals(that.basic) : that.basic != null) return false;
        if (performance != null ? !performance.equals(that.performance) : that.performance != null) return false;
        if (bonus != null ? !bonus.equals(that.bonus) : that.bonus != null) return false;
        if (cut != null ? !cut.equals(that.cut) : that.cut != null) return false;
        if (comments != null ? !comments.equals(that.comments) : that.comments != null) return false;
        return !(employee != null ? !employee.equals(that.employee) : that.employee != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (month != null ? month.hashCode() : 0);
        result = 31 * result + (basic != null ? basic.hashCode() : 0);
        result = 31 * result + (performance != null ? performance.hashCode() : 0);
        result = 31 * result + (bonus != null ? bonus.hashCode() : 0);
        result = 31 * result + (cut != null ? cut.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        result = 31 * result + (employee != null ? employee.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SalaryEntity{" +
                "id=" + id +
                ", year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", basic=" + basic +
                ", performance=" + performance +
                ", bonus=" + bonus +
                ", cut=" + cut +
                ", comments='" + comments + '\'' +
                ", employee=" + employee +
                '}';
    }
}
