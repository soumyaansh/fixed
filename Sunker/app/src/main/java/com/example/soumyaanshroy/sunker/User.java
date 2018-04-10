package com.example.soumyaanshroy.sunker;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 * Created by Soumyaansh Roy on 20-03-2018.
 */


public class User {

    private String User_Age;
    private String User_Contact_Number;
    private String User_Email_ID;
    private String User_Location;
    private String User_Name;
    private String pwd;


    _id _id;
    Date date;


    // Getter Methods

    public String getUser_Age() {
        return User_Age;
    }

    public String getUser_Contact_Number() {
        return User_Contact_Number;
    }

    public String getUser_Email_ID() {
        return User_Email_ID;
    }

    public String getUser_Location() {
        return User_Location;
    }

    public String getUser_Name() {
        return User_Name;
    }

    public _id get_id() {
        return _id;
    }

    public Date getDate() {
        return date;
    }

    // Setter Methods

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setUser_Age( String User_Age ) {
        this.User_Age = User_Age;
    }

    public void setUser_Contact_Number( String User_Contact_Number ) {
        this.User_Contact_Number = User_Contact_Number;
    }

    public void setUser_Email_ID( String User_Email_ID ) {
        this.User_Email_ID = User_Email_ID;
    }

    public void setUser_Location( String User_Location ) {
        this.User_Location = User_Location;
    }

    public void setUser_Name( String User_Name ) {
        this.User_Name = User_Name;
    }

    public void set_id( _id _idObject ) {
        this._id = _idObject;
    }

    public void setDate( Date dateObject ) {
        this.date = dateObject;
    }

}
