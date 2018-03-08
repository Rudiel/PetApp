package com.narumasolutions.petapp.Fragments.TaxiDetail;

import android.content.Context;

import com.narumasolutions.petapp.Utils.PetAppAplication;

import javax.inject.Inject;

/**
 * Created by rudielavilaperaza on 3/8/18.
 */

public class Presenter_TaxiDetail implements ITaxiDetail_Presenter {

    private ITaxiDetail_View view;

    public Presenter_TaxiDetail(Context context) {

        ((PetAppAplication) context).getAppComponent().inject(this);
    }

    @Override
    public void setView(ITaxiDetail_View view) {
        this.view = view;
    }
}
