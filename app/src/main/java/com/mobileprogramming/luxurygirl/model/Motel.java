package com.mobileprogramming.luxurygirl.model;

import java.io.Serializable;

/**
 * Created by italo on 08/06/2017.
 */

public class Motel implements Serializable{
    private String mName;
    private String mAddress;

    public Motel(String mName, String mAddress){
        this.mName = mName;
        this.mAddress = mAddress;
    }

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
