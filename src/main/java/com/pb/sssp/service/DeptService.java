package com.pb.sssp.service;

import com.pb.sssp.entity.Department;
import com.pb.sssp.repository.DeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author haohan
 * 01/08/2019 - 05:07 下午
 */
@Service
public class DeptService {

    @Autowired
    private DeptRepository deptRepository;

    /**
     * 获取所有Department信息
     * @return
     */
    @Transactional(readOnly = true)
    public List<Department> getAll() {
        return deptRepository.getAll();
    }

}
