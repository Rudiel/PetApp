package com.narumasolutions.petapp.Activities.Login;

/**
 * Created by rudielavilaperaza on 3/7/18.
 */

public interface ILogin_View {

    void showLoading();

    void hideLoading();

    void onLoginSuccess(String response);

    void onLoginError(String error);


}
