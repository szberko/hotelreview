package com.szberko.hotelreview.controller.dto;

import java.util.Objects;

public class UserSignUpResponse {

    private final String email;
    private final String displayName;

    public UserSignUpResponse(String email, String displayName) {
        this.email = email;
        this.displayName = displayName;
    }

    public String getEmail() {
        return email;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserSignUpResponse that = (UserSignUpResponse) o;
        return Objects.equals(email, that.email) &&
                Objects.equals(displayName, that.displayName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, displayName);
    }

    @Override
    public String toString() {
        return "UserSignUpResponse{" +
                "email='" + email + '\'' +
                ", displayName='" + displayName + '\'' +
                '}';
    }
}
