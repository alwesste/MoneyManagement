package com.leopold.moneyManagemet.dto;

public class LoginResponse {
    private Long userId;
    private String message;

    public LoginResponse(Long id, String message) {
        this.userId = id;
        this.message = message;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}