package com.narumasolutions.petapp.Activities;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.narumasolutions.petapp.Creators.Creator_OptionalDialog;
import com.narumasolutions.petapp.Creators.IOptionalDialogListener;
import com.narumasolutions.petapp.Fragments.Categories.Fragment_Categories;
import com.narumasolutions.petapp.Fragments.Map.Fragment_Map;
import com.narumasolutions.petapp.Fragments.Taxis.Fragment_Taxis;
import com.narumasolutions.petapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContainerActivity extends AppCompatActivity {

    @BindView(R.id.flContainer)
    FrameLayout flContainer;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.dlContainer)
    DrawerLayout dlContainer;

    @BindView(R.id.nvMain)
    NavigationView nvMain;

    private ActionBarDrawerToggle actionBarDrawerToggle;

    private TextView tvUserName;

    private ImageView ivUserImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_container);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        setMenuActions();

        tvUserName = nvMain.getHeaderView(0).findViewById(R.id.tvMenuUserName);

        ivUserImage = nvMain.getHeaderView(0).findViewById(R.id.ivMenuUserProfile);

        tvUserName.setText("Rudiel Avila");

        setFragment(new Fragment_Categories(), false);

    }


    public void setFragment(Fragment fragment, boolean isBackStack) {

        if (isBackStack) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flContainer, fragment)
                    //.addSharedElement()
                    .addToBackStack(null)
                    .commit();
        } else {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flContainer, fragment)
                    .commit();
        }


    }

    private void setMenuActions() {

        nvMain.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.mnList:
                        //TODO: set list places fragment
                        clearBackStack();
                        setFragment(new Fragment_Categories(), false);
                        dlContainer.closeDrawers();
                        break;
                    case R.id.mnMap:
                        //TODO: set map fragment
                        clearBackStack();
                        setFragment(new Fragment_Map(), false);
                        dlContainer.closeDrawers();
                        break;
                    case R.id.mnTaxi:
                        //TODO set taxi list fragment
                        clearBackStack();
                        setFragment(new Fragment_Taxis(), false);
                        dlContainer.closeDrawers();
                        break;
                    case R.id.mnLogout:
                        dlContainer.closeDrawers();
                        doLogout();
                        break;
                }
                return false;
            }
        });

        actionBarDrawerToggle = new ActionBarDrawerToggle(
                this,
                dlContainer,
                toolbar,
                R.string.app_name,
                R.string.app_name
        );

        dlContainer.addDrawerListener(actionBarDrawerToggle);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        actionBarDrawerToggle.syncState();

    }

    @SuppressLint("RestrictedApi")
    public void clearBackStack() {
       /* if (getSupportFragmentManager().getFragments() != null)
            for (Fragment fragment : getSupportFragmentManager().getFragments()) {
                try {
                    getSupportFragmentManager().beginTransaction().remove(fragment).commit();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }*/

        FragmentManager fm = getSupportFragmentManager();
        for (int i = 0; i < fm.getBackStackEntryCount(); ++i) {
            fm.popBackStack();
        }


    }


    private void doLogout() {
        new Creator_OptionalDialog().showOptionalDialog(
                this,
                "Logout",
                getString(R.string.logout_message),
                "SI",
                "NO",
                new IOptionalDialogListener() {
                    @Override
                    public void onPositiveClick(Dialog dialog) {
                        dialog.dismiss();
                    }

                    @Override
                    public void onNegativeClick(Dialog dialog) {
                        dialog.dismiss();
                    }
                }

        ).show();
    }
}
