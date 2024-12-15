package com.spring.henallux.firstSpringProject.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name="order_detail")
public class OrderDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    int id;
    @JoinColumn(name="order_mineral_id", referencedColumnName = "id")
    @ManyToOne
    private OrderMineralEntity orderMineralId;
    @JoinColumn(name="mineral_id", referencedColumnName = "id")
    @ManyToOne
    private MineralEntity mineralId;
    private int quantity;
    public OrderDetailEntity(OrderMineralEntity orderMineralEntity, MineralEntity mineralEntity, int quantity){
        this.orderMineralId = orderMineralEntity;
        this.mineralId = mineralEntity;
        this.quantity = quantity;
    }

    public OrderDetailEntity(){

    }

    public int getId() {
        return id;
    }

    public OrderMineralEntity getOrderMineralId() {
        return orderMineralId;
    }

    public MineralEntity getMineralId() {
        return mineralId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOrderMineralId(OrderMineralEntity orderMineralId) {
        this.orderMineralId = orderMineralId;
    }

    public void setMineralId(MineralEntity mineralId) {
        this.mineralId = mineralId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
