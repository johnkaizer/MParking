package com.project.digiparking.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.project.digiparking.Activities.CarParkDetailActivity;
import com.project.digiparking.Model.LocationModel;
import com.project.digiparking.R;
import com.project.digiparking.ui.home.HomeFragment;

import java.util.ArrayList;

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.ViewHolder> {
    Context context;
    ArrayList<LocationModel>list;

    public LocationAdapter(Context context, ArrayList<LocationModel> list, HomeFragment homeFragment) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public LocationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.parking_place_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull LocationAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.image.setImageResource(list.get(position).getImage());
        holder.amount.setText(list.get(position).getAmount());
        holder.name.setText(list.get(position).getName());
        holder.cardV.startAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(),R.anim.anim_one));
        holder.cardV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CarParkDetailActivity.class);
                intent.putExtra("title",list.get(position).getName());
                intent.putExtra("amount",list.get(position).getAmount());
                intent.putExtra("image",list.get(position).getImage());
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        TextView amount;
        CardView cardV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageView3);
            name = itemView.findViewById(R.id.textView8);
            amount = itemView.findViewById(R.id.amount);
            cardV = itemView.findViewById(R.id.cardView1);
        }
    }
}
