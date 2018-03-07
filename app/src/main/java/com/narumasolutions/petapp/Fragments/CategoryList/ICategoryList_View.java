package com.narumasolutions.petapp.Fragments.CategoryList;

import com.narumasolutions.petapp.Models.Response.Place;

import java.util.List;

/**
 * Created by rudielavilaperaza on 3/7/18.
 */

public interface ICategoryList_View {

    void hideLoading();

    void showLoading();

    void showPlaces(List<Place> placeList);

    void showError(String message);

}
