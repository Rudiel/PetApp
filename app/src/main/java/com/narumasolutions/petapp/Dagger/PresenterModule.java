package com.narumasolutions.petapp.Dagger;

import android.content.Context;

import com.narumasolutions.petapp.Fragments.Categories.ICategories_Presenter;
import com.narumasolutions.petapp.Fragments.Categories.Presenter_Categories;
import com.narumasolutions.petapp.Fragments.CategoryList.ICategoryList_Presenter;
import com.narumasolutions.petapp.Fragments.CategoryList.Presenter_CategoryList;
import com.narumasolutions.petapp.Fragments.Map.IMap_Presenter;
import com.narumasolutions.petapp.Fragments.Map.Presenter_Map;
import com.narumasolutions.petapp.Fragments.Taxis.ITaxis_Presenter;
import com.narumasolutions.petapp.Fragments.Taxis.Presenter_Taxis;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by rudielavilaperaza on 3/5/18.
 */
@Module
public class PresenterModule {

    @Provides
    @Singleton
    ICategories_Presenter provideCategoriesPresenter(Context context) {
        return new Presenter_Categories(context);
    }

    @Provides
    @Singleton
    ICategoryList_Presenter provideCategoryListPresenter(Context context) {
        return new Presenter_CategoryList(context);
    }

    /*@Provides
    @Singleton
    IMap_Presenter provideMapPresenter(Context context) {
        return new Presenter_Map(context);
    }*/

    @Provides
    @Singleton
    ITaxis_Presenter provideTaxisPresenter(Context context) {
        return new Presenter_Taxis(context);
    }


}
