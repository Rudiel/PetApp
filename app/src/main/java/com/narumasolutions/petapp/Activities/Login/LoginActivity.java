package com.narumasolutions.petapp.Activities.Login;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.narumasolutions.petapp.Activities.ContainerActivity;
import com.narumasolutions.petapp.Creators.Creator_ConfirmDialog;
import com.narumasolutions.petapp.Creators.IConfirmDialogListener;
import com.narumasolutions.petapp.Dagger.DaggerAppComponent;
import com.narumasolutions.petapp.Models.Response.User;
import com.narumasolutions.petapp.R;
import com.narumasolutions.petapp.Utils.PetAppAplication;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by rudielavilaperaza on 3/7/18.
 */

public class LoginActivity extends AppCompatActivity implements ILogin_View {

    @Inject
    ILogin_Presenter presenter;

    @BindView(R.id.btLogin)
    Button btLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout_activity_login);

        ((PetAppAplication) getApplication()).getAppComponent().inject(this);

        ButterKnife.bind(this);

        presenter.setView(this);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.doLogin(new User());
            }
        });


    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onLoginSuccess(String response) {
        Intent intent = new Intent(LoginActivity.this, ContainerActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }

    @Override
    public void onLoginError(String error) {

        new Creator_ConfirmDialog().showConfirmDialog(
                this,
                "Login",
                error,
                new IConfirmDialogListener() {
                    @Override
                    public void onConfirmClikListener(Dialog dialog) {
                        dialog.dismiss();
                    }
                }
        ).show();
    }
}
