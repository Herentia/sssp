package com.pb.sssp.controller;

import com.pb.sssp.entity.Employee;
import com.pb.sssp.service.DeptService;
import com.pb.sssp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author haohan
 * 01/08/2019 - 03:30 下午
 */
@Controller
public class EmpController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DeptService deptService;

    @RequestMapping(value = "/input/{id}", method = RequestMethod.DELETE)
    public String delEmp(@PathVariable("id") Integer id) {
        employeeService.delEmp(id);
        return "redirect:/emps";
    }

    @ModelAttribute
    public void getEmp(@RequestParam(value = "id", required = false) Integer id,
                       Map<String, Object> map) {
        if(id != null) {
            Employee employee = employeeService.getEmp(id);
            employee.setDepartment(null);
            System.out.println(employee);
            map.put("employee", employee);
        }
    }

    /**
     * 修改员工信息
     */
    @RequestMapping(value = "/input/{id}", method = RequestMethod.PUT)
    public String update(Employee employee) {
        employeeService.saveEmp(employee);
        return "redirect:/emps";
    }

    /**
     * 增加员工页面表单回显
     */
    @RequestMapping(value = "/input/{id}", method = RequestMethod.GET)
    public String editEmp(@PathVariable(value = "id") Integer id, Map<String, Object> map) {
        map.put("emp", employeeService.getEmp(id));
        map.put("dept", deptService.getAll());
        return "emps/input";
    }

    /**
     * 增加员工
     */
    @RequestMapping(value = "/input", method = RequestMethod.POST)
    public String saveEmp(Employee employee) {
        employeeService.saveEmp(employee);
        return "redirect:/emps";
    }

    /**
     * 跳转到增加员工页面
     * @return
     */
    @RequestMapping(value = "/input", method = RequestMethod.GET)
    public String input(Map<String, Object> map) {
        map.put("dept", deptService.getAll());
        map.put("emp", new Employee());
        return "emps/input";
    }

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
