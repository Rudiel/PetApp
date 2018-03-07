package com.narumasolutions.petapp.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.narumasolutions.petapp.Fragments.CategoryList.ICategoryListClickListener;
import com.narumasolutions.petapp.Models.Response.Place;
import com.narumasolutions.petapp.R;

import java.util.List;

/**
 * Created by rudielavilaperaza on 3/7/18.
 */

public class Adapter_CategoriesList extends RecyclerView.Adapter<Adapter_CategoriesList.ViewHolder> {

    private Context context;
    private List<Place> placeList;
    private ICategoryListClickListener listener;

    public Adapter_CategoriesList(Context context, List<Place> placeList, ICategoryListClickListener listener) {
        this.context = context;
        this.placeList = placeList;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.layout_categorieslist_item, parent, false);
        return new Adapter_CategoriesList.ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.tvName.setText(placeList.get(position).getNombre());

        holder.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onPlaceClickListener(placeList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return placeList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName;
        private ImageView ivBack;

        public ViewHolder(View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvCateListItemTitle);
            ivBack = itemView.findViewById(R.id.ivCateListItemBackground);
        }
    }


}
