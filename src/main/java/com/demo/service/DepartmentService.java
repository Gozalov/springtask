package com.demo.service;

import com.demo.model.Department;

import java.util.List;

public interface DepartmentService {

    List<Object[]> findAllDepartmentsAndUsers();

    void saveOrUpdate(Department department);

    Department findById(int departmentId);

    void deleteById(int departmentId);

}
