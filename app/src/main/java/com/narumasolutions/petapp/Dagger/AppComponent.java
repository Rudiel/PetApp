package com.narumasolutions.petapp.Dagger;

import com.narumasolutions.petapp.Activities.Login.LoginActivity;
import com.narumasolutions.petapp.Activities.Login.PresenterLogin;
import com.narumasolutions.petapp.Activities.Register.PresenterRegister;
import com.narumasolutions.petapp.Activities.Register.RegisterActivity;
import com.narumasolutions.petapp.Fragments.Categories.Fragment_Categories;
import com.narumasolutions.petapp.Fragments.Categories.Presenter_Categories;
import com.narumasolutions.petapp.Fragments.CategoryList.Fragment_CategoryList;
import com.narumasolutions.petapp.Fragments.CategoryList.Presenter_CategoryList;
import com.narumasolutions.petapp.Fragments.Map.Fragment_Map;
import com.narumasolutions.petapp.Fragments.Map.Presenter_Map;
import com.narumasolutions.petapp.Fragments.TaxiDetail.Fragment_TaxiDetail;
import com.narumasolutions.petapp.Fragments.TaxiDetail.Presenter_TaxiDetail;
import com.narumasolutions.petapp.Fragments.Taxis.Fragment_Taxis;
import com.narumasolutions.petapp.Fragments.Taxis.Presenter_Taxis;

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

    //Map

    void inject(Fragment_Map fragment);

    void inject(Presenter_Map target);

    //Taxis

    void inject(Fragment_Taxis fragment);

    void inject(Presenter_Taxis target);

    //Taxi detail

    void inject(Fragment_TaxiDetail fragment);

    void inject(Presenter_TaxiDetail target);

    //Login

    void inject(LoginActivity activity);

    void inject(PresenterLogin target);

    //Register

    void inject(RegisterActivity activity);

    void inject(PresenterRegister target);

}
