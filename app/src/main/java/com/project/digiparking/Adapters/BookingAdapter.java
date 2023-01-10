package com.project.digiparking.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.digiparking.Model.BookingModel;
import com.project.digiparking.R;

import java.util.ArrayList;

public class BookingAdapter extends RecyclerView.Adapter<BookingAdapter.ViewHolder> {

    public BookingAdapter(Context context, ArrayList<BookingModel> list) {
        this.context = context;
        this.list = list;
    }
    Context context;
    ArrayList<BookingModel>list;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.booking_item,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.location.setText(list.get(position).getLocation());
        holder.pSpot.setText(list.get(position).getSpot());
        holder.startDate.setText(list.get(position).getDate());
        holder.endDate.setText(list.get(position).getDate());
        holder.startTime.setText(list.get(position).getStartTime());
        holder.endTime.setText(list.get(position).getEndTime());
        holder.cPlate.setText(list.get(position).getPlate());
        holder.cModel.setText(list.get(position).getModel());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView location, pSpot,startDate,endDate, startTime, endTime,cPlate,cModel;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            location = itemView.findViewById(R.id.location_txt);
            pSpot = itemView.findViewById(R.id.parking_spot);
            startDate = itemView.findViewById(R.id.date);
            endDate = itemView.findViewById(R.id.date1);
            startTime = itemView.findViewById(R.id.start_time);
            endTime = itemView.findViewById(R.id.end_time);
            cPlate = itemView.findViewById(R.id.car_plate);
            cModel = itemView.findViewById(R.id.car_name);

        }
    }
}
