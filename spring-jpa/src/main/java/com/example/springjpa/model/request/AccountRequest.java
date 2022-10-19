package com.example.springjpa.model.request;

import lombok.Data;

@Data
public class AccountRequest {
    private String name;
    private String username;
    private String password;
    private Long profileId;

    public AccountRequest() {
    }

    public AccountRequest(String name, String username, String password, Long profileId) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.profileId = profileId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Long getProfileId() {
        return profileId;
    }

    public void setProfileId(Long profileId) {
        this.profileId = profileId;
    }
}
