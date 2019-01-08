package com.pb.sssp.entity;

import org.springframework.cache.annotation.Cacheable;

import javax.persistence.*;

/**
 * @author haohan
 * 01/07/2019 - 03:27 下午
 */
@Cacheable
@Table(name = "sssp_department")
@Entity
public class Department {

    private Integer id;
    private String deptName;

    @SequenceGenerator(name = "dept_id", initialValue = 1, allocationSize = 1, sequenceName = "sssp_dept")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dept_id")
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
