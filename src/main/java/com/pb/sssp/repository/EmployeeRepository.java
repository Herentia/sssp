package com.pb.sssp.repository;

import com.pb.sssp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author haohan
 * 01/08/2019 - 03:23 下午
 */
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
