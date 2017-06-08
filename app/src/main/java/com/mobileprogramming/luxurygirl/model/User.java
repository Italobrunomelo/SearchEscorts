package com.mobileprogramming.luxurygirl.model;

/**
 * Created by italo on 27/05/2017.
 */

public class User {
    private String mEmail;
    private String mPassword;

    public User() {

    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
