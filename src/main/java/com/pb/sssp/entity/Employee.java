package com.pb.sssp.entity;

import com.pb.sssp.entity.Department;

import javax.persistence.*;
import java.util.Date;

/**
 * @author haohan
 * 01/07/2019 - 03:26 下午
 */
@Table(name = "sssp_employee")
@Entity
public class Employee {
    private Integer id;
    private String lastName;
    private String email;
    private Date birth;
    private Date createTime;

    private Department department;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_id")
    @SequenceGenerator(name = "employee_id", initialValue = 1, allocationSize = 1, sequenceName = "sssp_emp")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Temporal(TemporalType.DATE)
    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "create_time")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
