package com.narumasolutions.petapp.Fragments.Taxis;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.narumasolutions.petapp.Adapters.Adpater_Taxis;
import com.narumasolutions.petapp.Fragments.Map.IMap_Presenter;
import com.narumasolutions.petapp.Models.Response.Taxi;
import com.narumasolutions.petapp.R;
import com.narumasolutions.petapp.Utils.PetAppAplication;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by rudielavilaperaza on 3/8/18.
 */

public class Fragment_Taxis extends Fragment implements ITaxis_View, ITaxiClickListener {

    @BindView(R.id.rvTaxis)
    RecyclerView rvTaxis;

    @BindView(R.id.pbTaxis)
    ProgressBar pbTaxis;

    private List<Taxi> taxisList;

    @Inject
    ITaxis_Presenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.layout_fragment_taxis, container, false);

        ((PetAppAplication) getActivity().getApplication()).getAppComponent().inject(this);

        presenter.setView(this);

        ButterKnife.bind(this, v);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        taxisList = new ArrayList<>();

        rvTaxis.setLayoutManager(new LinearLayoutManager(getActivity()));

        rvTaxis.setHasFixedSize(true);

        presenter.getTaxisList();

    }


    @Override
    public void showLoading() {
        pbTaxis.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        pbTaxis.setVisibility(View.GONE);
    }

    @Override
    public void showTaxis(List<Taxi> taxiList) {

        this.taxisList = taxiList;

        rvTaxis.setAdapter(new Adpater_Taxis(getActivity(), this.taxisList));

    }

    @Override
    public void onTaxiClicked(Taxi taxi) {
        //TODO: pass taxi to the other fragment

        Bundle bundle = new Bundle();

        bundle.putSerializable("Taxi", taxi);


    }
}
