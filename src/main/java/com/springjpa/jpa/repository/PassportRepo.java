package com.springjpa.jpa.repository;

import com.springjpa.jpa.dao.Employee;
import com.springjpa.jpa.dao.Passport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional // Spring JPA will not allow data modifications unless its transaction
public class PassportRepo {

    Logger logger = LoggerFactory.getLogger(PassportRepo.class);

    @PersistenceContext
    EntityManager entityManager;

    public Passport findById(int id){

        return entityManager.find(Passport.class,id);

    }


    public Passport insertPassport(Passport passport){

        return entityManager.merge(passport);

    }

    public Passport updatePassport(Passport passport){

        return entityManager.merge(passport);

    }

    public void deletePassport(int empID ){

        Passport passport = findById(empID);

        entityManager.remove(passport);

    }

    public List<Passport> findAllPassport(){

        TypedQuery<Passport> namedQueryFindALlEmployee =  entityManager.createNamedQuery("Find_All_Employees",Passport.class);

        return namedQueryFindALlEmployee.getResultList();

    }

    public boolean save(Passport passport){

        if(passport.getId() == 0)
            entityManager.persist(passport);
        else
            entityManager.merge(passport);

        return true;
    }

    //    ************ One -One Relations ***********


    public void fetchPassportWithEmployee(){

        Passport passport = findById(100);

        logger.info("fetchPassportWithEmployee Passport --> {}",passport);
        /*
         * Since it is Transactional Lazy loading of passport works too
         *
         * */
        logger.info("fetchPassportWithEmployee  Passport --> {}",passport.getEmployee());


    }

    public void relations(){

        fetchPassportWithEmployee();

    }

    //    ************ One -One Relations ***********





}
