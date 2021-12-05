package com.example.contactlist;

import java.util.Enumeration;

public class User {

    int imageId;
    public String name, email, number;

    public User(String name, String email, String number, int imageId) {
        this.name = name;
        this.email = email;
        this.number = number;
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public String getNumber(){
            return number;
    }

    public String getEmail() {
        return email;
    }

    public int  getImageId() {
        return imageId;
    }

}
