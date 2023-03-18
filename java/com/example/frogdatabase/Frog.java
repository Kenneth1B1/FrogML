package com.example.frogdatabase;

import androidx.room.Entity;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;


public class Frog {
    private int mId;
    private String mName;
    private String mDescription;
    private double mLatitude;
    private double mLongitude;
    private String mAddress;


    public Frog() {}

    public Frog(int id, String name, double lat, double lon) {
        mId = id;
        mName = name;
        mLatitude = lat;
        mLongitude = lon;
    }

    public Frog(int id, String name, String description) {
        mId = id;
        mName = name;
        mDescription = description;

    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }

    public void setLatitude(double latitude) {
        this.mLatitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.mLongitude = longitude;
    }

    public double getLatitude() {
        return mLatitude;
    }

    public double getLongitude() {
        return mLongitude;
    }

    public String getmAddress() {
        return mAddress;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }
}
