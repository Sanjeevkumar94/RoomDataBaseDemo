package com.example.roomdatabase;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Student {

    @PrimaryKey(autoGenerate = true)
    int stuId;

    String stuFirstName;
    String stuLasttName;
    String stuClass;

    public int getStuId() {
        return stuId;
    }

    public String getStuFirstName() {
        return stuFirstName;
    }

    public String getStuLasttName() {
        return stuLasttName;
    }

    public String getStuClass() {
        return stuClass;
    }




    public Student(String stuFirstName, String stuLasttName, String stuClass) {
        this.stuFirstName = stuFirstName;
        this.stuLasttName = stuLasttName;
        this.stuClass = stuClass;
    }


}
