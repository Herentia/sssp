package com.pb.sssp.controller;

import com.pb.sssp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author haohan
 * 01/08/2019 - 03:30 下午
 */
@Controller
public class EmpController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/emps")
    public String getEmps(@RequestParam(value = "pageNo", required = false, defaultValue = "1") String pageNoStr,
                          Map<String, Object> map) {
        int pageNo = 1;
        try {
            //对页面进行效验
            pageNo = Integer.parseInt(pageNoStr);
            if(pageNo < 1) {
                pageNo = 1;
            }
            map.put("emps", employeeService.getEmp(pageNo, 5));
        } catch (Exception e) {}
        return "emps/list";
    }
}
