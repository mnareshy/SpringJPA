package com.springjpa.jpa.repository;


import com.springjpa.jpa.dao.Review;
import com.springjpa.jpa.dao.Vehicle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class ReviewRepo {

    Logger logger = LoggerFactory.getLogger(EmplloyeeRepo.class);

    @PersistenceContext
    EntityManager entityManager;

    public Review findById(int id){

        return entityManager.find(Review.class,id);

    }



    public void run(){

        Review review = findById(402);
        logger.info("review -> {}",review);
        logger.info("review - vehicle -> {}",review.getVehicle());
    }

}
