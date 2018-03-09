package com.narumasolutions.petapp.Activities.Login;

import android.content.Context;

import com.narumasolutions.petapp.Services.Interfaces.IPetAppServices;
import com.narumasolutions.petapp.Utils.PetAppAplication;

import javax.inject.Inject;

/**
 * Created by rudielavilaperaza on 3/7/18.
 */

public class PresenterLogin implements ILogin_Presenter {

    @Inject
    IPetAppServices service;

    private ILogin_View view;

    public PresenterLogin(Context context) {

        ((PetAppAplication) context).getAppComponent().inject(this);

    }

    @Override
    public void setView(ILogin_View view) {
        this.view = view;
    }
}
