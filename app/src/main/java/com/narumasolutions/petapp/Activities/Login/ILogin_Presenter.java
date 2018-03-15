package com.narumasolutions.petapp.Activities.Login;

import com.narumasolutions.petapp.Models.Response.User;

/**
 * Created by rudielavilaperaza on 3/7/18.
 */

public interface ILogin_Presenter {

    void setView(ILogin_View view);

    void doLogin(User user);
}
