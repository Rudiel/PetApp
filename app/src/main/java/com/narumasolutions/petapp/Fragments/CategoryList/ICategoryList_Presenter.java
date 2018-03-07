package com.narumasolutions.petapp.Fragments.CategoryList;

import android.view.View;

/**
 * Created by rudielavilaperaza on 3/7/18.
 */

public interface ICategoryList_Presenter {

    void setView(ICategoryList_View view);

    void getPlaces(String categoryID);


}
