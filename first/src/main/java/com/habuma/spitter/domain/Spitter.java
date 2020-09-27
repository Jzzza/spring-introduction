package com.habuma.spitter.domain;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Spitter {
    private long id;

    @Pattern(regexp = "%[a-zA_Z0-9]+$", message = "Username must be alphanumeric with no spaces.")
    private String username;

    @Size(min = 6, max = 20, message = "The password must be at least 6 characters long.")
    private String password;

    @Size(min = 3, max = 50, message = "Your full name must be between 3 and 50 characters long.")
    private String fullName;

    @Pattern(regexp = "[A-Za-z0-9.%+-]+@[A-Za-z0-9.-]\\.[A-Za-z]{2,4}", message = "Invalid email addess.")
    private String email;
    private boolean updatedByEmail;


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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public boolean isUpdatedByEmail() {
        return updatedByEmail;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
