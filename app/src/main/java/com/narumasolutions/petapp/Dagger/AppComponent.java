package com.narumasolutions.petapp.Dagger;

import com.narumasolutions.petapp.Fragments.Categories.Fragment_Categories;
import com.narumasolutions.petapp.Fragments.Categories.Presenter_Categories;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by rudielavilaperaza on 3/5/18.
 */
@Singleton
@Component (modules = {AppModule.class, NetworkModule.class, PresenterModule.class})
public interface AppComponent {

    //inject activity & presenter

    void inject(Fragment_Categories fragment);

     void inject(Presenter_Categories taget);

}
