package com.narumasolutions.petapp.Activities.Login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.narumasolutions.petapp.Dagger.DaggerAppComponent;
import com.narumasolutions.petapp.Utils.PetAppAplication;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by rudielavilaperaza on 3/7/18.
 */

public class LoginActivity extends AppCompatActivity implements ILogin_View {

    @Inject
    ILogin_Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView();
        ((PetAppAplication) getApplication()).getAppComponent().inject(this);

        ButterKnife.bind(this);

        presenter.setView(this);

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
