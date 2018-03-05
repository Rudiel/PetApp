package com.narumasolutions.petapp.Dagger;

import android.content.Context;

import com.narumasolutions.petapp.Fragments.Categories.ICategories_Presenter;
import com.narumasolutions.petapp.Fragments.Categories.Presenter_Categories;

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

}
