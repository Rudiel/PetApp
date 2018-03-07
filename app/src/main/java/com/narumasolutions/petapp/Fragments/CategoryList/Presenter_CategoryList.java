package com.narumasolutions.petapp.Fragments.CategoryList;

import android.content.Context;

import com.narumasolutions.petapp.Models.Response.Place;
import com.narumasolutions.petapp.Services.Interfaces.IPetAppServices;
import com.narumasolutions.petapp.Utils.PetAppAplication;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by rudielavilaperaza on 3/7/18.
 */

public class Presenter_CategoryList implements ICategoryList_Presenter {

    ICategoryList_View view;

    @Inject
    IPetAppServices service;

    public Presenter_CategoryList(Context context) {

        ((PetAppAplication) context).getAppComponent().inject(this);

    }

    @Override
    public void setView(ICategoryList_View view) {
        this.view = view;
    }

    @Override
    public void getPlaces(String categoryID) {
        view.showLoading();

        service.getPlaces(categoryID).enqueue(new Callback<List<Place>>() {
            @Override
            public void onResponse(Call<List<Place>> call, Response<List<Place>> response) {

                if (response.code() == 200)
                    view.showPlaces(response.body());
                else
                    view.showError(response.message());

                view.hideLoading();

            }

            @Override
            public void onFailure(Call<List<Place>> call, Throwable t) {
                view.showError(t.getMessage());
                view.hideLoading();
            }
        });

    }
}
