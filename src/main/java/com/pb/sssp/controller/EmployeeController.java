package com.pb.sssp.controller;

import com.pb.sssp.entity.Employee;
import com.pb.sssp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author haohan
 * 01/08/2019 - 02:18 下午
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/emps")
    public String getemps(@RequestParam(name = "pageNo", required = false, defaultValue = "1") String pageNoStr,
                          Map<String, Object> map) {
        int pageNo = 1;
        try {
            //对pageNo进行效验
            pageNo = Integer.parseInt(pageNoStr);
            if(pageNo < 1) {
                pageNo = 1;
            }
            Page<Employee> page = employeeService.getPage(pageNo, 5);
            map.put("page", page);
        } catch (Exception e) {
        }
        return "emp/list";
    }

}
