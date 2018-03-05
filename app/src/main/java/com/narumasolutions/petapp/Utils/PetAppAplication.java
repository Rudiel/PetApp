package com.narumasolutions.petapp.Utils;

import android.app.Application;

import com.narumasolutions.petapp.Dagger.AppComponent;
import com.narumasolutions.petapp.Dagger.DaggerAppComponent;

/**
 * Created by rudielavilaperaza on 3/5/18.
 */

public class PetAppAplication extends Application {


    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = initDagger(this);
    }

    protected AppComponent initDagger(PetAppAplication aplication) {
        return DaggerAppComponent.builder()
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }


}
