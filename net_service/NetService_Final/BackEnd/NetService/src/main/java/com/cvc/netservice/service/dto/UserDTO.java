package com.cvc.netservice.service.dto;

import java.io.Serializable;

public class UserDTO implements Serializable {

    private Long id;

    private String username;

    private Long password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getPassword() {
        return password;
    }

    public void setPassword(Long password) {
        this.password = password;
    }


}
