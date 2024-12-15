package com.spring.henallux.firstSpringProject.dataAccess.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Entity
@Table(name="order_mineral")
public class OrderMineralEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    @ManyToOne
    private UserEntity personId;
    @Column(name="order_date")
    private LocalDate orderDate;
    @Column(name="real_price")
    private double realPrice;
    @Column(name="is_paid")
    private boolean isPaid;

    public int getId() {
        return id;
    }

    public UserEntity getPersonId() {
        return personId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public double getRealPrice() {
        return realPrice;
    }
    public boolean getIsPaid(){
        return isPaid;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setPersonId(UserEntity personId) {
        this.personId = personId;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public void setRealPrice(double realPrice) {
        this.realPrice = realPrice;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }
}
