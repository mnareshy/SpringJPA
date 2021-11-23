package com.springjpa.jpa.dao;

import javax.persistence.*;


@Entity
public class Review {



    public Review(String reviewComment) {

        this.reviewComment = reviewComment;
    }

    public Review() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String reviewComment;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;


    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReviewComment() {
        return reviewComment;
    }

    public void setReviewComment(String reviewComment) {
        this.reviewComment = reviewComment;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", reviewComment='" + reviewComment + '\'' +
                ", vehicle=" + vehicle +
                '}';
    }
}