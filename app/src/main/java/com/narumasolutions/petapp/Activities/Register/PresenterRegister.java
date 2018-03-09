package com.narumasolutions.petapp.Activities.Register;

import android.content.Context;

import com.narumasolutions.petapp.Services.Interfaces.IPetAppServices;
import com.narumasolutions.petapp.Utils.PetAppAplication;

import javax.inject.Inject;

/**
 * Created by rudielavilaperaza on 3/7/18.
 */

public class PresenterRegister implements IRegister_Presenter {

    @Inject
    IPetAppServices service;

    private IRegister_View view;

    public PresenterRegister(Context context) {

        ((PetAppAplication) context).getAppComponent().inject(this);

    }

    @Override
    public void setView(IRegister_View view) {
        this.view = view;
    }
}
