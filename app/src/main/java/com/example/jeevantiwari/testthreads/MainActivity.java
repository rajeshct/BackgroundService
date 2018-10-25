package com.example.jeevantiwari.testthreads;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent  intent=new Intent(this,CustomJob.class);
        CustomJob.enqueueWork(this,CustomJob.class,CustomJob.JOB_ID,intent);
    }

}
