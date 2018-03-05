package com.narumasolutions.petapp.Services.Interfaces;

import com.narumasolutions.petapp.Models.Response.Categoria;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by rudielavilaperaza on 3/5/18.
 */

public interface IPetAppServices {

    @Headers({"Content-Type: application/json"})
    @GET("CategoriaLugares")
    Call<List<Categoria>> getCategorias();


}
