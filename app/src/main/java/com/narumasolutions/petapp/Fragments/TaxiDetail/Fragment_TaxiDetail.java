package com.narumasolutions.petapp.Fragments.TaxiDetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.narumasolutions.petapp.R;
import com.narumasolutions.petapp.Utils.PetAppAplication;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by rudielavilaperaza on 3/8/18.
 */

public class Fragment_TaxiDetail extends Fragment implements ITaxiDetail_View {

    @Inject
    ITaxiDetail_Presenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.layout_fragment_taxis, container, false);

        ((PetAppAplication) getActivity().getApplication()).getAppComponent().inject(this);

        ButterKnife.bind(this, v);

        presenter.setView(this);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
