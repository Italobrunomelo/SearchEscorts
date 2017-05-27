package com.mobileprogramming.searchcompanions.model;

/**
 * Created by italo on 27/05/2017.
 */

public class User {
    private String email;
    private String cpf;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
