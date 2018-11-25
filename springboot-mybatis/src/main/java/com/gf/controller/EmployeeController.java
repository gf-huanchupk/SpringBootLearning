package com.gf.controller;


import com.gf.entity.Employee;
import com.gf.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Employee> getEmployees() {
        return employeeService.list( null );
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Employee getEmployeeById(@PathVariable("id") int id) {
        return employeeService.getById( id );
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateEmployee(@PathVariable("id") int id, @RequestParam(value = "lastName", required = true) String lastName,
                                @RequestParam(value = "email", required = true) String email , @RequestParam(value = "gender", required = true) int gender , @RequestParam(value = "dId", required = true) int dId) {
        Employee employee = new Employee();
        employee.setId( id );
        employee.setLastName( "张" );
        employee.setEmail( "zhang@163.com" );
        employee.setGender( 1 );
        employee.setDId( 1 );

        boolean b = employeeService.updateById( employee );

        if (b) {
            return "update success";
        } else {
            return "update fail";
        }

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable(value = "id")int id) {
        boolean b = employeeService.removeById( id );

        if(b) {
            return "delete success";
        }else {
            return "delete fail";
        }

    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String postEmployee(@RequestParam(value = "lastName", required = true) String lastName,
                               @RequestParam(value = "email", required = true) String email , @RequestParam(value = "gender", required = true) int gender , @RequestParam(value = "dId", required = true) int dId) {

        Employee employee = new Employee();
        employee.setLastName( "王" );
        employee.setEmail( "wang@163.com" );
        employee.setGender( 2 );
        employee.setDId( 2 );
        boolean b = employeeService.save( employee );

        if(b) {
            return "sava success";
        }else {
            return "sava fail";
        }

    }


}