package com.pb.sssp.service;

import com.pb.sssp.entity.Employee;
import com.pb.sssp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author haohan
 * 01/08/2019 - 09:59 上午
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional(readOnly = true)
    public Page<Employee> getPage(Integer pageNo, Integer pageSize) {
        PageRequest pageable = PageRequest.of(pageNo, pageSize);
        Page<Employee> page = employeeRepository.findAll(pageable);
        return page;
    }

}
