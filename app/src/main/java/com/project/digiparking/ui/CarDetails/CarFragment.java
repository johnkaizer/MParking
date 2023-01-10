package com.project.digiparking.ui.CarDetails;

import static com.project.digiparking.DBmain.TABLENAME;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.digiparking.Adapters.CarDetailsAdapter;
import com.project.digiparking.Model.CarDetailsModel;
import com.project.digiparking.DBmain;
import com.project.digiparking.R;
import com.project.digiparking.databinding.FragmentCarBinding;

import java.util.ArrayList;


public class CarFragment extends Fragment {
    DBmain dBmain;
    SQLiteDatabase sqLiteDatabase;
    int id = 0;
    RecyclerView car;
    CarDetailsAdapter carDetailsAdapter;
    private FragmentCarBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCarBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        dBmain = new DBmain(getContext());
        car = root.findViewById(R.id.car_RV);
        car.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));

        displayData();

        return root;


    }

    private void displayData() {
        sqLiteDatabase = dBmain.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from "+TABLENAME+"",null);
        ArrayList<CarDetailsModel>carDetailsModels = new ArrayList<>();
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            byte[]avatar = cursor.getBlob(1);
            String name =cursor.getString(2);
            String plate=cursor.getString(3);
            String type =cursor.getString(4);
            String color=cursor.getString(5);
            carDetailsModels.add(new CarDetailsModel(id,avatar,name,plate,type,color));

        }
        cursor.close();
        carDetailsAdapter = new CarDetailsAdapter(getContext(),R.layout.car_item,carDetailsModels,sqLiteDatabase);
        car.setAdapter(carDetailsAdapter);
    }
}