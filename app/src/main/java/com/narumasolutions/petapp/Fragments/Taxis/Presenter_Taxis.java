package com.narumasolutions.petapp.Fragments.Taxis;

import android.content.Context;

import com.narumasolutions.petapp.Services.Interfaces.IPetAppServices;
import com.narumasolutions.petapp.Utils.PetAppAplication;

import javax.inject.Inject;

/**
 * Created by rudielavilaperaza on 3/8/18.
 */

public class Presenter_Taxis implements ITaxis_Presenter {

    @Inject
    IPetAppServices service;

    private ITaxis_View view;

    public Presenter_Taxis(Context context) {

        ((PetAppAplication) context).getAppComponent().inject(this);

    }

    @Override
    public void setView(ITaxis_View view) {
        this.view = view;
    }

    @Override
    public void getTaxisList() {
        view.showLoading();

        //TODO: get Taxis list

        view.hideLoading();
    }


}
