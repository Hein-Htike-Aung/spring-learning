package com.hha.dao;

import com.hha.entities.Employee;
import jakarta.persistence.EntityManager;

import java.util.List;

public class EmployeeDao {

    private EntityManager em;

    public EmployeeDao(EntityManager em) {
        this.em = em;
    }

    public void create(Employee employee) {

        em.getTransaction().begin();

        em.persist(employee);

        em.getTransaction().commit();

    }

    public Employee findById(int id) {
        return em.find(Employee.class, id);
    }

    public List<Employee> findAll() {

        return em.createQuery(
                "select e from Employee e", Employee.class
        ).getResultList();
    }

    public void delete(int id) {
        em.getTransaction().begin();
        em.remove(findById(id));
        em.getTransaction().commit();
    }

    public Employee update(Employee employee) {
        em.getTransaction().begin();
        Employee updatedEmployee =  em.merge(employee);
        em.getTransaction().commit();
        return updatedEmployee;
    }

}
