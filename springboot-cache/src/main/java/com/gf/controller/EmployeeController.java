package com.gf.controller;


import com.gf.entity.Employee;
import com.gf.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gf
 * @since 2018-11-25
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {


    @Autowired
    EmployeeService employeeService;

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping(value = "/list")
    public List<Employee> getEmployees() {
        return employeeService.list( null );
    }

    @GetMapping(value = "/{id}")
    public Employee getEmployeeById(@PathVariable("id") int id) {
        return employeeService.getById( id );
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateEmployee(@PathVariable("id") int id, @RequestParam(value = "lastName", required = true) String lastName,
                                @RequestParam(value = "email", required = true) String email , @RequestParam(value = "gender", required = true) int gender , @RequestParam(value = "dId", required = true) int dId) {
        Employee employee = new Employee();
        employee.setId( id );
        employee.setLastName( lastName );
        employee.setEmail( email );
        employee.setGender( gender );
        employee.setDId( dId );

        Employee res = employeeService.updateEmployeeById( employee );

        if (res != null) {
            return "update success";
        } else {
            return "update fail";
        }

    }

    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable(value = "id")int id) {
        boolean b = employeeService.removeById( id );

        if(b) {
            return "delete success";
        }else {
            return "delete fail";
        }

    }

    @PostMapping(value = "")
    public String postEmployee(@RequestParam(value = "lastName", required = true) String lastName,
                               @RequestParam(value = "email", required = true) String email , @RequestParam(value = "gender", required = true) int gender , @RequestParam(value = "dId", required = true) int dId) {

        Employee employee = new Employee();
        employee.setLastName( lastName );
        employee.setEmail( email );
        employee.setGender( gender );
        employee.setDId( dId );
        boolean b = employeeService.save( employee );

        if(b) {
            return "sava success";
        }else {
            return "sava fail";
        }

    }


}