package com.narumasolutions.petapp.Services.Interfaces;

import com.narumasolutions.petapp.Models.Response.Categoria;
import com.narumasolutions.petapp.Models.Response.Place;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/**
 * Created by rudielavilaperaza on 3/5/18.
 */

public interface IPetAppServices {

    @Headers({"Content-Type: application/json"})
    @GET("CategoriaLugares")
    Call<List<Categoria>> getCategorias();

    @Headers({"Content-Type: application/json"})
    @GET("Lugares/{Category_Id}")
    Call<List<Place>> getPlaces(@Path("Category_Id") String categoryID);

}