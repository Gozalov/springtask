package com.demo.controller;

import com.demo.model.Department;
import com.demo.model.User;
import com.demo.service.DepartmentService;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView model = new ModelAndView("department_list");
        model.addObject("departmentList", departmentService.findAllDepartmentsAndUsers());
        return model;
    }

    @RequestMapping(value = "/addDepartment/", method = RequestMethod.GET)
    public ModelAndView addDepartment() {
        ModelAndView model = new ModelAndView();
        Department department = new Department();
        User user = new User();
        model.addObject("department", department);
        model.addObject("user", user);
        model.setViewName("department_form");
        return model;
    }

    @RequestMapping(value = "/updateDepartment/{departmentId}/{userId}", method = RequestMethod.GET)
    public ModelAndView editDepartment(@PathVariable("departmentId") int departmentId, @PathVariable("userId") int userId) {
        ModelAndView model = new ModelAndView("department_form");
        Department department = departmentService.findById(departmentId);
        User user = null;
        try {
            user = userService.findById(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        model.addObject("department", department);
        model.addObject("user", user);
        return model;
    }

    @RequestMapping(value = "/saveDepartment", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("department") Department department, @ModelAttribute("user") User user) throws Exception {
        if (department != null && department.getAccount().trim().length() == 0)
            throw new Exception("Bank or branch name cannot be blank");
        if (user != null && user.getName().trim().length() == 0)
            throw new Exception("Bank or branch name cannot be blank");

        User dbUser = null;
        Department dbDepartment = null;
        if (user.getId() != 0) {
            dbUser = userService.findById(user.getId());
            dbUser.setName(user.getName());
            dbDepartment = departmentService.findById(dbUser.getdepartment().getId());
            dbDepartment.setAccount(department.getAccount());
            dbDepartment.setParent_account(department.getParent_account());
        } else {
            dbUser = user;
            dbUser.setdepartment(department);
            dbDepartment = department;
        }

        departmentService.saveOrUpdate(dbDepartment);
        userService.saveOrUpdate(dbUser);
        return new ModelAndView("redirect:/department/list");
    }

    @RequestMapping(value = "/deleteDepartment/{departmentId}/{userId}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("departmentId") int departmentId, @PathVariable("userId") int userId) {
        try {
            userService.deleteById(userId);
            departmentService.deleteById(departmentId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ModelAndView("redirect:/department/list");
    }
}
