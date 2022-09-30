package com.example.services;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import java.security.Provider;

public class ServicesExample extends IntentService {


    /**
     * @param name
     * @deprecated
     */
    public ServicesExample() {
        super("name");
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d("Service", "Service is created");

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d("Service", "Service is started");

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {

        Log.d("Service", "Service is stopped");
        super.onDestroy();
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d("Service", "onHandleIntent method worked");
    }


}
