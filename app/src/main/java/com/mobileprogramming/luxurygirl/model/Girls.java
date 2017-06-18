package com.mobileprogramming.luxurygirl.model;

import java.io.Serializable;

/**
 * Created by italo on 17/05/2017.
 */

public class Girls implements Serializable {

    private String mName;
    private String mAge;
    private String mInformation;
    private String mContact;
    private String mStatus;
    private String mEmail;
    private byte[] mImagem;

    public Girls() {

    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmAge() {
        return mAge;
    }

    public void setmAge(String mAge) {
        this.mAge = mAge;
    }

    public String getmInformation() {
        return mInformation;
    }

    public void setmInformation(String mInformation) {
        this.mInformation = mInformation;
    }

    public String getmContact() {
        return mContact;
    }

    public void setmContact(String mContact) {
        this.mContact = mContact;
    }

    public String getmStatus() {
        return mStatus;
    }

    public void setmStatus(String mStatus) {
        this.mStatus = mStatus;
    }

    public byte[] getmImagem() {
        return mImagem;
    }

    public void setmImagem(byte[] mImagem) {
        this.mImagem = mImagem;
    }

    @Override
    public String toString() {
        return "Girls{" +
                "mName='" + mName + '\'' +
                ", mAge='" + mAge + '\'' +
                ", mInformation='" + mInformation + '\'' +
                ", mContact='" + mContact + '\'' +
                ", mStatus='" + mStatus + '\'' +
                ", mEmail='" + mEmail + '\'' +
                '}';
    }
}
