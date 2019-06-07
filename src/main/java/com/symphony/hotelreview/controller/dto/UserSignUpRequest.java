package com.symphony.hotelreview.controller.dto;

import java.util.Objects;

public class UserSignUpRequest {

    private final String email;
    private final String displayName;
    private final String password;

    public UserSignUpRequest(String email, String displayName, String password) {
        this.email = email;
        this.displayName = displayName;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserSignUpRequest that = (UserSignUpRequest) o;
        return Objects.equals(email, that.email) &&
                Objects.equals(displayName, that.displayName) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, displayName, password);
    }

    @Override
    public String toString() {
        return "UserSignUpRequest{" +
                "email='" + email + '\'' +
                ", displayName='" + displayName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
