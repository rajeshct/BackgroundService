package com.example.jeevantiwari.testthreads;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.v4.app.JobIntentService;
import android.widget.Toast;


public class CustomJob extends JobIntentService {

    /**
     * Unique job ID for this service.
     */
    static final int JOB_ID = 1000;
    private Handler handler;

    /**
     * Convenience method for enqueuing work in to this service.
     */
    static void enqueueWork(Context context, Intent work) {
        enqueueWork(context, CustomJob.class, JOB_ID, work);
    }


    @Override
    protected void onHandleWork(@NonNull Intent intent) {
        handler=new android.os.Handler(Looper.getMainLooper());
        handler.postDelayed(runnable, 1000);
    }



    Runnable runnable=new Runnable() {
        @Override
        public void run() {
            Toast.makeText(CustomJob.this, "working", Toast.LENGTH_SHORT).show();
            handler.postDelayed(runnable,1000);
        }
    };
}
