package com.narumasolutions.petapp.Fragments.Map;

import android.content.Context;

import com.narumasolutions.petapp.Utils.PetAppAplication;

/**
 * Created by rudielavilaperaza on 3/8/18.
 */

public class Presenter_Map implements IMap_Presenter {

    private IMap_View view;


    public Presenter_Map(Context context) {
        ((PetAppAplication) context).getAppComponent().inject(this);
    }


    @Override
    public void setView(IMap_View view) {
        this.view = view;
    }
}
