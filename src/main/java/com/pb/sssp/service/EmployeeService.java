package com.pb.sssp.service;

import com.pb.sssp.entity.Employee;
import com.pb.sssp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author haohan
 * 01/08/2019 - 03:25 下午
 */
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public Page<Employee> getEmp(Integer pageNo, Integer pageSize) {
        PageRequest pageable = PageRequest.of(pageNo -1, pageSize);
        return employeeRepository.findAll(pageable);
    }
}
