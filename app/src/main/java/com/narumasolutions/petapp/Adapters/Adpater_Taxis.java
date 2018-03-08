package com.narumasolutions.petapp.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.narumasolutions.petapp.Fragments.Taxis.ITaxiClickListener;
import com.narumasolutions.petapp.Models.Response.Taxi;
import com.narumasolutions.petapp.R;

import java.util.List;

/**
 * Created by rudielavilaperaza on 3/8/18.
 */

public class Adpater_Taxis extends RecyclerView.Adapter<Adpater_Taxis.ViewHolder> {

    private List<Taxi> taxiList;
    private Context context;
    private ITaxiClickListener listener;

    public Adpater_Taxis(Context context, List<Taxi> taxiList, ITaxiClickListener listener) {
        this.context = context;
        this.taxiList = taxiList;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.layout_taxis_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        //TODO: set views datas
        holder.tvName.setText(taxiList.get(position).getNombre());

        holder.rlItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onTaxiClicked(taxiList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return taxiList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private RelativeLayout rlItem;
        private TextView tvName;

        public ViewHolder(View itemView) {
            super(itemView);

            rlItem = itemView.findViewById(R.id.rlItemTaxi);

            tvName = itemView.findViewById(R.id.tvItemTaxiName);
        }
    }

}
