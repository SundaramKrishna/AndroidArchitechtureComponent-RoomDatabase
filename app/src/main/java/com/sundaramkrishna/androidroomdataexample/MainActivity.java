package com.sundaramkrishna.androidroomdataexample;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sundaramkrishna.androidroomdataexample.room.AppDataBase;
import com.sundaramkrishna.androidroomdataexample.room.User;

public class MainActivity extends AppCompatActivity {

    private AppDataBase appDataBase;
    private static final String DATABASE_NAME = "sample_db";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFlow();
    }

    private void initFlow() {
        appDataBase = Room.databaseBuilder(getApplicationContext(),AppDataBase.class,DATABASE_NAME).fallbackToDestructiveMigration().allowMainThreadQueries().build();

        User user = new User();
        user.setId(1);
        user.setEmail("sundaram.k1992@gmail.com");
        user.setName("Sundaram");

        appDataBase.getUserDao().addUser(user);
    }
}
