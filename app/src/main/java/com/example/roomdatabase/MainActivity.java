package com.example.roomdatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText etFName,etLName,etClass,et_update_name,et_id;
    MyDataBase myDataBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etFName = findViewById(R.id.et_fname);
        etLName = findViewById(R.id.et_lname);
        etClass = findViewById(R.id.et_class);
        et_update_name = findViewById(R.id.et_update_name);
        et_id = findViewById(R.id.et_id);

        myDataBase = Room.databaseBuilder(
                MainActivity.this,MyDataBase.class,"studentDB"
        ).allowMainThreadQueries().build();


        findViewById(R.id.btn_insert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = new Student(etFName.getText().toString(),
                        etLName.getText().toString(),
                        etClass.getText().toString()
                        );

                myDataBase.dao().studentInsertion(student);
            }
        });

        findViewById(R.id.btn_all).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               List<Student> list =  myDataBase.dao().getData();

               for( Student item:list){
                   Log.d("firstName<<",item.getStuFirstName());
                   Log.d("firstName<<",""+item.getStuId());
               }
            }
        });

        findViewById(R.id.btn_update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myDataBase.dao().updateStu(et_update_name.getText().toString(),
                        Integer.parseInt(et_id.getText().toString())
                        );

            }
        });

        findViewById(R.id.btn_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myDataBase.dao().deleteData(
                        Integer.parseInt(et_id.getText().toString())
                        );
            }
        });

        findViewById(R.id.btn_get).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

             List<Student> student =  myDataBase.dao().getParticularData(
                        Integer.parseInt(et_id.getText().toString())
                        );

                for( Student item:student){
                    Log.d("firstName<<",item.getStuFirstName());
                    Log.d("firstName<<",""+item.getStuId());
                }

            }
        });
    }
}
