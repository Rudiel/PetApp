package com.narumasolutions.petapp.Activities.Register;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.narumasolutions.petapp.Utils.PetAppAplication;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by rudielavilaperaza on 3/7/18.
 */

public class RegisterActivity extends AppCompatActivity implements IRegister_View {

    @Inject
    IRegister_Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView

        ((PetAppAplication) getApplication()).getAppComponent().inject(this);

        ButterKnife.bind(this);


    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
