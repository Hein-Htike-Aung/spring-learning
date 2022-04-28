package com.hha;

import com.hha.dao.EmployeeDao;
import com.hha.entities.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Main {


    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction etx = entityManager.getTransaction();

        Employee employee1 = new Employee("Xiaoting", LocalDate.of(2021, 3, 11), "Marketing", 2000);
        Employee employee2 = new Employee("Min Jeong", LocalDate.of(2021, 3, 11), "Marketing", 2000);
        Employee employee3 = new Employee("Karina", LocalDate.of(2021, 3, 11), "Marketing", 2000);

        EmployeeDao employeeDao = new EmployeeDao(entityManager);

        System.out.println("\nCreate Employee");
        employeeDao.create(employee1);
        employeeDao.create(employee2);
        employeeDao.create(employee3);

        System.out.println("\nFind By Id (employee 1)");
        System.out.println(employeeDao.findById(1));

        System.out.println("\nFind All Employees");
        employeeDao.findAll().forEach(System.out::println);

        System.out.println("\nUpdate Employee 1");
        employee1.setName("Yurina");
        System.out.println(employeeDao.update(employee1));

        System.out.println("\nDelete Employee 2");
        employeeDao.delete(employee2.getId());

        System.out.println("\nFind All Employees");
        employeeDao.findAll().forEach(System.out::println);

        entityManager.close();
        entityManagerFactory.close();
    }
}
