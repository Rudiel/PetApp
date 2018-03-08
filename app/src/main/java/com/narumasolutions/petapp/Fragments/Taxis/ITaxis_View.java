package com.narumasolutions.petapp.Fragments.Taxis;

import com.narumasolutions.petapp.Models.Response.Taxi;

import java.util.List;

/**
 * Created by rudielavilaperaza on 3/8/18.
 */

public interface ITaxis_View {

    void showLoading();

    void hideLoading();

    void showTaxis(List<Taxi> taxiList);
}
