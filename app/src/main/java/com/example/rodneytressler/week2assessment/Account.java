package com.example.rodneytressler.week2assessment;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.jar.Attributes;

/**
 * Created by rodneytressler on 12/14/17.
 */

public class Account implements Parcelable{
    String name;
    String email;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    protected Account(Parcel in) {
    }

    public static final Creator<Account> CREATOR = new Creator<Account>() {
        @Override
        public Account createFromParcel(Parcel in) {
            return new Account(in);
        }

        @Override
        public Account[] newArray(int size) {
            return new Account[size];
        }
    };

    private void name() {
        String name;
        String email;


    }

    public Account() {
    }




    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
