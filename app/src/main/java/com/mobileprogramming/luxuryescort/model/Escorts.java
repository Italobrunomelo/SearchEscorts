package com.mobileprogramming.luxuryescort.model;

import java.io.Serializable;

/**
 * Created by italo on 17/05/2017.
 */

public class Escorts implements Serializable {

    private String mName;
    private String mAge;
    private String mInformation;
    private String mContact;
    private String mLocation;
    private String mStatus;

    public Escorts() {

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

    public String getmLocation() {
        return mLocation;
    }

    public void setmLocation(String mLocation) {
        this.mLocation = mLocation;
    }

    public String getmStatus() {
        return mStatus;
    }

    public void setmStatus(String mStatus) {
        this.mStatus = mStatus;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
