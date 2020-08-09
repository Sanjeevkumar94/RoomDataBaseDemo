package com.example.roomdatabase;


import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface DAO {

    @Insert
    public void studentInsertion(Student student);

    @Query("Select * from Student")
    List<Student> getData();

    @Query("Update Student set stuFirstName =:stuName where stuId=:id")
    void  updateStu(String stuName, int id);

    @Query("Delete from Student where stuId =:id")
    void  deleteData(int id);


}
