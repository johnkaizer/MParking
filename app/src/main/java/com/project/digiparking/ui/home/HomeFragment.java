package com.project.digiparking.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.project.digiparking.Adapters.LocationAdapter;
import com.project.digiparking.Model.LocationModel;
import com.project.digiparking.R;
import com.project.digiparking.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    LocationAdapter locationAdapter;
    ArrayList<LocationModel> locationModels;
    RecyclerView location;


    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        //Image slider
        ImageSlider  imageSlider = root.findViewById(R.id.imageView2);
        ArrayList<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.park4, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.park3, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.park5, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.park2, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.park1, ScaleTypes.FIT));
        imageSlider.setImageList(slideModels,ScaleTypes.FIT);

        location = root.findViewById(R.id.parkingRv);
        locationModels = new ArrayList<>();

        locationModels.add(new LocationModel(R.drawable.foodplus, "Holdern Mall Parking","300"));
        locationModels.add(new LocationModel(R.drawable.mmust, "MMUST Car Park","200"));
        locationModels.add(new LocationModel(R.drawable.kakamega, "Harmony Motors Garage","400"));
        locationModels.add(new LocationModel(R.drawable.kakamega, "Hard Rock Gardens Kakamega","200"));
        locationModels.add(new LocationModel(R.drawable.muliro, "Muliro Gardens","250"));
        locationModels.add(new LocationModel(R.drawable.tuskys, "Tuskys Parking Lot","200"));


        locationAdapter = new LocationAdapter(getActivity(), locationModels, this);
        location.setAdapter(locationAdapter);
        location.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false));
        location.setHasFixedSize(true);
        location.setNestedScrollingEnabled(false);


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}