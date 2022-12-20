package com.project.digiparking.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.digiparking.Model.AdvertModel;
import com.project.digiparking.R;
import com.project.digiparking.ui.home.HomeFragment;

import java.util.ArrayList;

public class AdvertAdapter extends RecyclerView.Adapter<AdvertAdapter.ViewHolder> {

    public AdvertAdapter(Context context, ArrayList<AdvertModel> list, HomeFragment homeFragment) {
        this.context = context;
        this.list = list;
    }
    Context context;
    ArrayList<AdvertModel>list;

    @NonNull
    @Override
    public AdvertAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.advert_item,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull AdvertAdapter.ViewHolder holder, int position) {
        holder.image.setImageResource(list.get(position).getImage());
        holder.text.setText(list.get(position).getText());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView text;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageView2);
            text = itemView.findViewById(R.id.text1);

        }
    }
}
