package com.narumasolutions.petapp.Activities;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.narumasolutions.petapp.Fragments.Categories.Fragment_Categories;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_container);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        setMenuActions();

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
}
