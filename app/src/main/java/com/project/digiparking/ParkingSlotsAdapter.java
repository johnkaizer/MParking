package com.project.digiparking;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.digiparking.Activities.BookingActivity;
import com.project.digiparking.Adapters.LocationAdapter;

import java.util.ArrayList;

public class ParkingSlotsAdapter extends RecyclerView.Adapter<ParkingSlotsAdapter.ViewHolder> {

    public ParkingSlotsAdapter(Context context, ArrayList<ParkingSlotsModel> list, BookingActivity bookingActivity) {
        this.context = context;
        this.list = list;
    }
    Context context;
    ArrayList<ParkingSlotsModel>list;

    @NonNull
    @Override
    public ParkingSlotsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.slots_items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ParkingSlotsAdapter.ViewHolder holder, int position) {
        holder.number.setText(list.get(position).getNumber());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView number;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            number = itemView.findViewById(R.id.text_number);
        }
    }
}
