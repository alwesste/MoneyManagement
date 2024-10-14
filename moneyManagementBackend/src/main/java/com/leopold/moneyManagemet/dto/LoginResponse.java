package com.leopold.moneyManagemet.dto;

public class LoginResponse {
    private int userId;
    private String message;

    public LoginResponse(int id, String message) {
        this.userId = id;
        this.message = message;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}