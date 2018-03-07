package com.narumasolutions.petapp.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.narumasolutions.petapp.Fragments.Categories.ICategoryClickListener;
import com.narumasolutions.petapp.Models.Response.Categoria;
import com.narumasolutions.petapp.R;

import java.util.List;

/**
 * Created by rudielavilaperaza on 3/5/18.
 */

public class Adapter_Categories extends RecyclerView.Adapter<Adapter_Categories.ViewHolder> {

    private List<Categoria> categoriaList;
    private Context context;
    private ICategoryClickListener listener;

    public Adapter_Categories(List<Categoria> categoriaList, Context context, ICategoryClickListener listener) {
        this.categoriaList = categoriaList;
        this.context = context;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.layout_categories_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.tvCatItemTitle.setText(categoriaList.get(position).getNombre());

        holder.ivCatItemBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onCategoryClicked(categoriaList.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return categoriaList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        final TextView tvCatItemTitle;
        ImageView ivCatItemBackground;
        ImageView ivCatItemIcon;

        public ViewHolder(View itemView) {
            super(itemView);

            tvCatItemTitle = itemView.findViewById(R.id.tvCatItemTitle);
            ivCatItemBackground = itemView.findViewById(R.id.ivCateItemBackground);
            ivCatItemIcon = itemView.findViewById(R.id.ivCateItemIcon);
        }
    }
}
