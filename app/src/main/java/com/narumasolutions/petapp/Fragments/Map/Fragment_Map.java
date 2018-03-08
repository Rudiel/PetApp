package com.narumasolutions.petapp.Fragments.Map;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.narumasolutions.petapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by rudielavilaperaza on 3/8/18.
 */

public class Fragment_Map extends Fragment implements OnMapReadyCallback, IMap_View {

    @BindView(R.id.map)
    MapView mapView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.layout_fragment_map, container, false);

        ButterKnife.bind(this, v);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (mapView != null) {
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);
        }
    }
}
