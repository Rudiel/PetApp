package com.narumasolutions.petapp.Fragments.Taxis;

import com.narumasolutions.petapp.Fragments.Map.IMap_View;

/**
 * Created by rudielavilaperaza on 3/8/18.
 */

public interface ITaxis_Presenter {

    void setView(ITaxis_View view);

    void getTaxisList();

}
