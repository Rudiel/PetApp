package com.narumasolutions.petapp.Fragments.Categories;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.narumasolutions.petapp.Models.Response.Categoria;
import com.narumasolutions.petapp.R;
import com.narumasolutions.petapp.Utils.PetAppAplication;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by rudielavilaperaza on 3/5/18.
 */

public class Fragment_Categories extends Fragment implements ICategories_View {

    @Inject
    ICategories_Presenter presenter;

    @BindView(R.id.rvCategories)
    RecyclerView rvCategories;

    private List<Categoria> categoriaList;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.layout_activity_container, container, false);

        ((PetAppAplication) getActivity().getApplication()).getAppComponent().inject(this);

        presenter.setView(this);

        ButterKnife.bind(this, v);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        categoriaList = new ArrayList<>();

        presenter.getCategories();

    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onCategoriesResult(List<Categoria> categorias) {

        // rvCategories.setAdapter(new );
    }

    @Override
    public void onCategoriesError(String message) {

    }
}
