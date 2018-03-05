package com.narumasolutions.petapp.Fragments.Categories;

import com.narumasolutions.petapp.Models.Response.Categoria;

import java.util.List;

/**
 * Created by rudielavilaperaza on 3/5/18.
 */

public interface ICategories_View {

    void showLoading();

    void hideLoading();

    void onCategoriesResult(List<Categoria> categorias);

    void onCategoriesError(String message);

}
