package com.pb.sssp.repository;

import com.pb.sssp.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import javax.persistence.QueryHint;
import java.util.List;

/**
 * @author haohan
 * 01/08/2019 - 05:06 下午
 */
public interface DeptRepository extends JpaRepository<Department, Integer> {

    @QueryHints({@QueryHint(name = org.hibernate.jpa.QueryHints.HINT_CACHEABLE, value = "true")})
    @Query("FROM SSSP_DEPARTMENT d")
    List<Department> getAll();

}
