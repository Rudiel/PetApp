package com.narumasolutions.petapp.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.narumasolutions.petapp.Models.Response.Categoria;
import com.narumasolutions.petapp.R;

import java.util.List;

/**
 * Created by rudielavilaperaza on 3/5/18.
 */

public class Adapter_Categories extends RecyclerView.Adapter<Adapter_Categories.ViewHolder> {

    private List<Categoria> categoriaList;
    private Context context;

    public Adapter_Categories(List<Categoria> categoriaList, Context context) {
        this.categoriaList = categoriaList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.layout_categories_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return categoriaList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {


        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
