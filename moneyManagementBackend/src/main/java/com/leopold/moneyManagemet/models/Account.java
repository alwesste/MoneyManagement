package com.leopold.moneyManagemet.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "date")
    private Date date;

    @Column(name = "spending_type")
    private String spendingType;

    @Column(name = "comment")
    private String comment;

    @Column(name = "amount")
    private double amount;

    @ManyToOne
    @JoinColumn(name = "subscriber_id")
    private SubscriberData subscriber ;


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSpendingType() {
        return spendingType;
    }

    public void setSpendingType(String spendingType) {
        this.spendingType = spendingType;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public SubscriberData getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(SubscriberData subscriber) {
        this.subscriber = subscriber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
