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
    private Date yearMonth;
    private Integer attendanceDays;
    private Double basic;
    private Double percentage;
    private Double bonus;
    private Double cut;
    private Date time;
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
    @Column(name = "year_month")
    public Date getYearMonth() {
        return yearMonth;
    }

    public void setYearMonth(Date yearMonth) {
        this.yearMonth = yearMonth;
    }

    @Basic
    @Column(name = "attendance_days")
    public Integer getAttendanceDays() {
        return attendanceDays;
    }

    public void setAttendanceDays(Integer attendanceDays) {
        this.attendanceDays = attendanceDays;
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
    @Column(name = "percentage")
    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
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
    @Column(name = "time")
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
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
    @JoinColumn(name = "employee_id",referencedColumnName = "id")
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
        if (yearMonth != null ? !yearMonth.equals(that.yearMonth) : that.yearMonth != null) return false;
        if (attendanceDays != null ? !attendanceDays.equals(that.attendanceDays) : that.attendanceDays != null)
            return false;
        if (basic != null ? !basic.equals(that.basic) : that.basic != null) return false;
        if (percentage != null ? !percentage.equals(that.percentage) : that.percentage != null) return false;
        if (bonus != null ? !bonus.equals(that.bonus) : that.bonus != null) return false;
        if (cut != null ? !cut.equals(that.cut) : that.cut != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (comments != null ? !comments.equals(that.comments) : that.comments != null) return false;
        return !(employee != null ? !employee.equals(that.employee) : that.employee != null);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (yearMonth != null ? yearMonth.hashCode() : 0);
        result = 31 * result + (attendanceDays != null ? attendanceDays.hashCode() : 0);
        result = 31 * result + (basic != null ? basic.hashCode() : 0);
        result = 31 * result + (percentage != null ? percentage.hashCode() : 0);
        result = 31 * result + (bonus != null ? bonus.hashCode() : 0);
        result = 31 * result + (cut != null ? cut.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        result = 31 * result + (employee != null ? employee.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SalaryEntity{" +
                "id=" + id +
                ", yearMonth=" + yearMonth +
                ", attendanceDays=" + attendanceDays +
                ", basic=" + basic +
                ", percentage=" + percentage +
                ", bonus=" + bonus +
                ", cut=" + cut +
                ", time=" + time +
                ", comments='" + comments + '\'' +
                ", employee=" + employee +
                '}';
    }
}
