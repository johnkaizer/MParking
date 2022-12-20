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

import com.project.digiparking.Adapters.AdvertAdapter;
import com.project.digiparking.Model.AdvertModel;
import com.project.digiparking.R;
import com.project.digiparking.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    RecyclerView advert;
    ArrayList<AdvertModel> advertModel;
    AdvertAdapter advertAdapter;

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        advert = root.findViewById(R.id.advertRv);
        advertModel = new ArrayList<>();

        advertModel.add(new AdvertModel(R.drawable.park1, "Find parking sport nearby"));
        advertModel.add(new AdvertModel(R.drawable.park2, "Conveniently pay from your phone"));
        advertModel.add(new AdvertModel(R.drawable.park3, "Book for space before arriving"));

        advertAdapter = new AdvertAdapter(getActivity(), advertModel, this);
        advert.setAdapter(advertAdapter);
        advert.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        advert.setHasFixedSize(true);
        advert.setNestedScrollingEnabled(false);



        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}