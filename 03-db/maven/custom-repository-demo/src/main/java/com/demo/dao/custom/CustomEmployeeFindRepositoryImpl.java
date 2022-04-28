package com.demo.dao.custom;

import com.demo.ds.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class CustomEmployeeFindRepositoryImpl implements CustomEmployeeFindRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Employee findByNameAndPhone(String name, String phone) {

//        return entityManager.createQuery("select e from Employee e where e.name = ?1 and e.phone = ?2", Employee.class)
//                .setParameter(1, name)
//                .setParameter(2, phone)
//                .getSingleResult();
//
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> employeeRoot = criteria.from(Employee.class);

        criteria.where(
                criteriaBuilder.and(
                        criteriaBuilder.equal(employeeRoot.get("name"), name),
                        criteriaBuilder.equal(employeeRoot.get("phone"), phone)
                )
        );


        return entityManager.createQuery(criteria).getSingleResult();
    }
}
