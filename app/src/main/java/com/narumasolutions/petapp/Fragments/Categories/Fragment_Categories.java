package com.narumasolutions.petapp.Fragments.Categories;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.narumasolutions.petapp.Activities.ContainerActivity;
import com.narumasolutions.petapp.Adapters.Adapter_Categories;
import com.narumasolutions.petapp.Creators.Creator_ConfirmDialog;
import com.narumasolutions.petapp.Creators.Creator_OptionalDialog;
import com.narumasolutions.petapp.Creators.IConfirmDialogListener;
import com.narumasolutions.petapp.Creators.IOptionalDialogListener;
import com.narumasolutions.petapp.Fragments.CategoryList.Fragment_CategoryList;
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

public class Fragment_Categories extends Fragment implements ICategories_View, ICategoryClickListener {

    @Inject
    ICategories_Presenter presenter;

    @BindView(R.id.rvCategories)
    RecyclerView rvCategories;

    @BindView(R.id.pbCategories)
    ProgressBar pbCategories;

    private List<Categoria> categoriaList;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.layout_fragment_categories, container, false);

        ((PetAppAplication) getActivity().getApplication()).getAppComponent().inject(this);

        presenter.setView(this);

        ButterKnife.bind(this, v);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        categoriaList = new ArrayList<>();

        rvCategories.setLayoutManager(new LinearLayoutManager(getActivity()));

        rvCategories.setHasFixedSize(true);

        presenter.getCategories();

    }


    @Override
    public void showLoading() {
        pbCategories.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        pbCategories.setVisibility(View.GONE);
    }

    @Override
    public void onCategoriesResult(List<Categoria> categorias) {

        this.categoriaList = categorias;

        rvCategories.setAdapter(new Adapter_Categories(categoriaList, getActivity(), this));

    }

    @Override
    public void onCategoriesError(String message) {
        //TODO: show error message

        new Creator_ConfirmDialog().showConfirmDialog(getActivity(),
                "Categories",
                "This is an error",
                new IConfirmDialogListener() {
                    @Override
                    public void onConfirmClikListener(Dialog dialog) {
                        dialog.dismiss();
                    }
                }).show();

    }

    @Override
    public void onCategoryClicked(Categoria categoria) {
        //TODO: get category id and pass to the other fragment

        Fragment_CategoryList fragment = new Fragment_CategoryList();

        Bundle bundle = new Bundle();

        bundle.putSerializable("Categoria", categoria);

        fragment.setArguments(bundle);

        ((ContainerActivity) getActivity()).setFragment(fragment, true);

    }
}
