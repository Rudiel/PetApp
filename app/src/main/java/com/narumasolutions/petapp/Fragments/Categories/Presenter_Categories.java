package com.narumasolutions.petapp.Fragments.Categories;

import android.content.Context;

import com.narumasolutions.petapp.Models.Response.Categoria;
import com.narumasolutions.petapp.Services.Interfaces.IPetAppServices;
import com.narumasolutions.petapp.Utils.PetAppAplication;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by rudielavilaperaza on 3/5/18.
 */

public class Presenter_Categories implements ICategories_Presenter {

    private ICategories_View view;

    @Inject
    IPetAppServices service;

    public Presenter_Categories(Context context) {

        ((PetAppAplication) context).getAppComponent().inject(this);

    }

    @Override
    public void getCategories() {

        service.getCategorias().enqueue(new Callback<List<Categoria>>() {
            @Override
            public void onResponse(Call<List<Categoria>> call, Response<List<Categoria>> response) {
                view.hideLoading();
                view.onCategoriesResult(response.body());
            }

            @Override
            public void onFailure(Call<List<Categoria>> call, Throwable t) {
                view.onCategoriesError(t.getMessage());
                view.hideLoading();
            }
        });
    }

    @Override
    public void setView(ICategories_View view) {
        this.view = view;
    }
}
