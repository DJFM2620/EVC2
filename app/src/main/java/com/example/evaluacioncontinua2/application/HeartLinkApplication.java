package com.example.evaluacioncontinua2.application;

import android.app.Application;
import android.content.Context;

import androidx.appcompat.app.AppCompatDelegate;

public class HeartLinkApplication extends Application {

    private static HeartLinkApplication instance;
    private static Context appContext;

    public static HeartLinkApplication getInstance(){

        return instance;
    }

    public static Context getAppContext(){

        return appContext;
    }

    public void setAppContext(Context mAppContext){

        this.appContext = mAppContext;
    }

    @Override
    public void onCreate(){

        super.onCreate();

        instance = this;

        this.setAppContext(getApplicationContext());

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }
}