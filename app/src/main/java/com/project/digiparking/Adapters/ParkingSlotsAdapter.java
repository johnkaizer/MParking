package com.project.digiparking.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.project.digiparking.Activities.BookingActivity;
import com.project.digiparking.Model.ParkingSlotsModel;
import com.project.digiparking.R;

import java.util.ArrayList;

public class ParkingSlotsAdapter extends RecyclerView.Adapter<ParkingSlotsAdapter.ViewHolder> {

    public ParkingSlotsAdapter(Context context, ArrayList<ParkingSlotsModel> list, BookingActivity bookingActivity) {
        this.context = context;
        this.list = list;
    }
    Context context;
    ArrayList<ParkingSlotsModel>list;
    boolean check = true;
    boolean select  = true;
    int row_index = -1;


    @NonNull
    @Override
    public ParkingSlotsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.slots_items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ParkingSlotsAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.number.setText(list.get(position).getNumber());
        holder.card.setBackgroundResource(R.drawable.default_backgr);
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.card.setBackgroundResource(R.drawable.backgr);

            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView number;
        CardView card;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            number = itemView.findViewById(R.id.text_number);
            card = itemView.findViewById(R.id.cardView1);
        }
    }
}
