package com.leopold.moneyManagemet.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "account")

public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "date")
    private Date date;

    @Column(name = "spendingType")
    private String SpendingType;

    @Column(name = "comment")
    private String Comment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSpendingType() {
        return SpendingType;
    }

    public void setSpendingType(String spendingType) {
        SpendingType = spendingType;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }
}
