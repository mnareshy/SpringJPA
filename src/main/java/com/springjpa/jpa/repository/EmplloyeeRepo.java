package com.springjpa.jpa.repository;

import com.springjpa.jpa.dao.Employee;
import com.springjpa.jpa.dao.Passport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional // Spring JPA will not allow data modifications unless its transaction
public class EmplloyeeRepo {

    Logger logger = LoggerFactory.getLogger(EmplloyeeRepo.class);

    @PersistenceContext
    EntityManager entityManager;

    public Employee findById(int id){

        return entityManager.find(Employee.class,id);

    }


    public Employee insertEmployee(Employee employee){

        return entityManager.merge(employee);

    }

    public Employee updateEmployee(Employee employee){

        return entityManager.merge(employee);

    }

    public void deleteEmployee(int empID ){

        Employee employee = findById(empID);

        entityManager.remove(employee);

    }

    public List<Employee> findAllEmployees(){

        TypedQuery<Employee> namedQueryFindALlEmployee =  entityManager.createNamedQuery("Find_All_Employees",Employee.class);

        return namedQueryFindALlEmployee.getResultList();

    }

    public boolean save(Employee employee){

        if(employee.getId() == null)
            entityManager.persist(employee);
        else
            entityManager.merge(employee);

        return true;
    }

    //    ************ One -One Relations ***********

    public boolean saveWithPassport(Employee employee,String passportNumber){

        Passport passport = new Passport(passportNumber);
        entityManager.persist(passport);

        employee.setPassport(passport);
        entityManager.merge(employee);

        return true;
    }

    public void fetchEmployeeWithPassport(){

        Employee employee = findById(12);

        logger.info("fetchEmployeeWithPassport Employee --> {}",employee);
        /*
         * Since it is Transactional Lazy loading of passport works too
         *
         * */
        logger.info("fetchEmployeeWithPassport  Passport --> {}",employee.getPassport());


    }

    public void relations(){

        saveWithPassport(new Employee("hero","datacience","sairam"),"AB12127");
        fetchEmployeeWithPassport();

    }

    //    ************ One -One Relations ***********

    public void flushClearDetach(){
        flushEntity();
        flushEntityDetach();
        flushDetachedEntiry();
        clearFlushEntity();
        refreshEntity();

        //   saveWithPassport(new Employee("hero","datacience","sairam"),"AB12127");

    }



    public void flushEntity(){

        Employee employee1 = new Employee("sairam","arts","baba");
        entityManager.persist(employee1);

        entityManager.flush();
        employee1.setDept("Data Science");


    }


    Employee employee2 = new Employee("sairam","arts","baba");
    Employee employee7 = new Employee("naresh","product","baba");
    public void flushEntityDetach(){


        entityManager.persist(employee2);

        //detach detaches the entity from Entitymanager , hence persistant context will not treack the entity updates.
        entityManager.detach(employee2);

        entityManager.flush();
        employee2.setDept("Data Science");


    }

    public void flushDetachedEntiry(){

        employee2.setDept("Data Science");

        //cannot persist detached entity
        //cannot persist detached entity
        // org.springframework.dao.InvalidDataAccessApiUsageException: detached entity passed to persist:
        // com.springjpa.jpa.dao.Employee; nested exception is org.hibernate.PersistentObjectException:
        // detached entity passed to persist: com.springjpa.jpa.dao.Employee

        // entityManager.persist(employee2);
    }


    public void clearFlushEntity(){
        entityManager.persist(employee7);
        entityManager.clear();

        Employee employee4 = new Employee("mahasiva","universe","self");
        entityManager.persist(employee4);

       /* Employee employee8 = new Employee("priayam","unknown","someone");
        entityManager.persist(employee8);
*/

        /*org.springframework.dao.InvalidDataAccessApiUsageException: detached entity passed to
        persist: com.springjpa.jpa.dao.Employee; nested exception is org.hibernate.PersistentObjectException:
        detached entity passed to persist: com.springjpa.jpa.dao.Employee*/
        //entityManager.persist(employee7);

    }


    public void refreshEntity(){

        Employee employee8 = new Employee("priayam","unknown","someone");
        entityManager.persist(employee8);
        entityManager.flush();

        employee8.setReports("some other one");

        //refresh refresh the entity with the data from DB, so inflict updates before flush losts.
        entityManager.refresh(employee8);

        logger.info(findById(11).getName());
    }


}
