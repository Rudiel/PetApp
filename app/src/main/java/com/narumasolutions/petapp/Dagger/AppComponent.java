package com.narumasolutions.petapp.Dagger;

import com.narumasolutions.petapp.Fragments.Categories.Fragment_Categories;
import com.narumasolutions.petapp.Fragments.Categories.Presenter_Categories;
import com.narumasolutions.petapp.Fragments.CategoryList.Fragment_CategoryList;
import com.narumasolutions.petapp.Fragments.CategoryList.Presenter_CategoryList;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by rudielavilaperaza on 3/5/18.
 */
@Singleton
@Component(modules = {AppModule.class, NetworkModule.class, PresenterModule.class})
public interface AppComponent {

    //Categories

    void inject(Fragment_Categories fragment);

    void inject(Presenter_Categories target);

    //CategoryList

    void inject(Fragment_CategoryList fragment);

    void inject(Presenter_CategoryList target);


}
