package com.example.alex.moviesearch;


import com.example.alex.moviesearch.dagger.AppComponent;
import com.example.alex.moviesearch.dagger.AppModule;
import com.example.alex.moviesearch.dagger.DaggerAppComponent;

public class Application extends android.app.Application {

    private static AppComponent component;
    public static Application instance;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public static Application getInstance() {
        return instance;
    }

    public static AppComponent getComponent(){
        return component;
    }
}
