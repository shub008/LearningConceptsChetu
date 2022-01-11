package com.example.myapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

public class UserDataParceble implements Parcelable {
    private String fName;
    private String lName;
    private String phoneNo;

    public UserDataParceble(String fName, String lName, String phoneNo) {
        this.fName = fName;
        this.lName = lName;
        this.phoneNo = phoneNo;
    }

    protected UserDataParceble(Parcel in) {
        fName = in.readString();
        lName = in.readString();
        phoneNo = in.readString();
    }

    public static final Creator<UserDataParceble> CREATOR = new Creator<UserDataParceble>() {
        @Override
        public UserDataParceble createFromParcel(Parcel in) {
            return new UserDataParceble(in);
        }

        @Override
        public UserDataParceble[] newArray(int size) {
            return new UserDataParceble[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(fName);
        parcel.writeString(lName);
        parcel.writeString(phoneNo);
    }


    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }
}
