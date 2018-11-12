package com.demo.service;

import com.demo.model.Department;
import com.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveOrUpdate(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public Department findById(int departmentId) {
        return departmentRepository.findById(departmentId).get();
    }

    @Override
    public void deleteById(int departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public List<Object[]> findAllDepartmentsAndUsers() {
        return entityManager.createQuery("select d.id,d.account,d.parent_account,u.name,u.id as uid from Department d left join User u on d.id = u.department").getResultList();
    }
}
