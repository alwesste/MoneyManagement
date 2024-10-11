package com.leopold.moneyManagemet.models;

import jakarta.persistence.*;

@Entity
@Table(name = "subscriberdata")
public class SubscriberData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name="email")
    private String email;

    @Transient // Pour indique a la jpa de ne pas persister ce champ
    private String passwordConfirm;

    public SubscriberData() {}

    public SubscriberData(String username, String password, String email, String passwordConfirm) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.passwordConfirm = passwordConfirm;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

