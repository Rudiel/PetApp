package com.narumasolutions.petapp.Fragments.CategoryList;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.narumasolutions.petapp.Adapters.Adapter_CategoriesList;
import com.narumasolutions.petapp.Creators.Creator_ConfirmDialog;
import com.narumasolutions.petapp.Creators.IConfirmDialogListener;
import com.narumasolutions.petapp.Models.Response.Categoria;
import com.narumasolutions.petapp.Models.Response.Place;
import com.narumasolutions.petapp.R;
import com.narumasolutions.petapp.Utils.PetAppAplication;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by rudielavilaperaza on 3/6/18.
 */

public class Fragment_CategoryList extends Fragment implements ICategoryList_View, ICategoryListClickListener {

    @BindView(R.id.rvCategoriesList)
    RecyclerView rvCategoriesList;

    @BindView(R.id.pbCategoriesList)
    ProgressBar pbCategoriesList;

    private List<Place> placeList;

    @Inject
    ICategoryList_Presenter presenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.layout_fragment_categorieslist, container, false);

        ((PetAppAplication) getActivity().getApplication()).getAppComponent().inject(this);

        presenter.setView(this);

        ButterKnife.bind(this, v);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        placeList = new ArrayList<>();

        rvCategoriesList.setLayoutManager(new LinearLayoutManager(getActivity()));

        rvCategoriesList.setHasFixedSize(true);

        Categoria categoria = null;

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            categoria = (Categoria) bundle.getSerializable("Categoria");
        }

        presenter.getPlaces(categoria.getId());


    }

    @Override
    public void hideLoading() {
        pbCategoriesList.setVisibility(View.GONE);
    }

    @Override
    public void showLoading() {
        pbCategoriesList.setVisibility(View.VISIBLE);
    }

    @Override
    public void showPlaces(List<Place> placeList) {

        this.placeList = placeList;

        rvCategoriesList.setAdapter(new Adapter_CategoriesList(
                getActivity(),
                this.placeList,
                this));

    }

    @Override
    public void showError(String message) {

        new Creator_ConfirmDialog().showConfirmDialog(
                getActivity(),
                "",
                message, new IConfirmDialogListener() {
                    @Override
                    public void onConfirmClikListener(Dialog dialog) {
                        dialog.dismiss();
                    }
                }
        ).show();

    }

    @Override
    public void onPlaceClickListener(Place place) {
        Toast.makeText(getActivity(), place.getNombre(), Toast.LENGTH_SHORT).show();
    }
}
