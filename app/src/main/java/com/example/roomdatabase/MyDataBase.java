package com.example.roomdatabase;


import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Student.class},version = 1,exportSchema = false)
public abstract class MyDataBase extends RoomDatabase {

    public abstract DAO dao();
}
