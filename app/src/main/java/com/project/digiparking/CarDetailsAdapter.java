package com.project.digiparking;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.digiparking.Adapters.LocationAdapter;

import java.util.ArrayList;

public class CarDetailsAdapter extends RecyclerView.Adapter<CarDetailsAdapter.ViewHolder> {

    Context context;
    int car_item;
    ArrayList<CarDetailsModel>modelArrayList;
    SQLiteDatabase sqLiteDatabase;

    public CarDetailsAdapter(Context context, int car_item, ArrayList<CarDetailsModel> modelArrayList, SQLiteDatabase sqLiteDatabase) {
        this.context = context;
        this.car_item = car_item;
        this.modelArrayList = modelArrayList;
        this.sqLiteDatabase = sqLiteDatabase;
    }

    @NonNull
    @Override
    public CarDetailsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.car_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CarDetailsAdapter.ViewHolder holder, int position) {
        final CarDetailsModel carDetailsModel = modelArrayList.get(position);
        byte[]image=carDetailsModel.getAvatar();
        Bitmap bitmap= BitmapFactory.decodeByteArray(image,0,image.length);
        holder.image.setImageBitmap(bitmap);
        holder.name.setText(carDetailsModel.getName());
        holder.plate.setText(carDetailsModel.getPlate());
        holder.type.setText(carDetailsModel.getType());
        holder.color.setText(carDetailsModel.getColor());

    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name, plate,color,type;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.car_image);
            name = itemView.findViewById(R.id.car_name);
            plate = itemView.findViewById(R.id.car_plate);
            color = itemView.findViewById(R.id.car_color);
            type = itemView.findViewById(R.id.car_type);

        }
    }
}
