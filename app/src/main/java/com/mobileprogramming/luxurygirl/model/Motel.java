package com.mobileprogramming.luxurygirl.model;

/**
 * Created by italo on 08/06/2017.
 */

public class Motel {
    private String mName;
    private String mAddress;

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmAddress() {
        return mAddress;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public String toString() {
        return this.mName;
    }
}
