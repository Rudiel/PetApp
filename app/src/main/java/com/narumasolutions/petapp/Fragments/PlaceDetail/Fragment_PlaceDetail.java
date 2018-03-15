package com.narumasolutions.petapp.Fragments.PlaceDetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.narumasolutions.petapp.Models.Response.Categoria;
import com.narumasolutions.petapp.Models.Response.Place;
import com.narumasolutions.petapp.R;

import butterknife.ButterKnife;

/**
 * Created by rudielavilaperaza on 3/7/18.
 */

public class Fragment_PlaceDetail extends Fragment {

    private Place place;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.layout_fragment_placedetail, container, false);

        ButterKnife.bind(this, v);

        return v;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        Bundle bundle = this.getArguments();
        if (bundle != null) {
            place = (Place) bundle.getSerializable("Place");
        }

        place.getCategoria();
    }

}
