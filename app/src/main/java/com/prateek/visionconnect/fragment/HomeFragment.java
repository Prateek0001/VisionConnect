package com.prateek.visionconnect.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.prateek.visionconnect.R;
import com.prateek.visionconnect.adapter.DashboardAdapter;
import com.prateek.visionconnect.adapter.StoryAdapter;


import com.prateek.visionconnect.databinding.FragmentHomeBinding;
import com.prateek.visionconnect.model.DashboardModel;
import com.prateek.visionconnect.model.StoryModel;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;
    ArrayList<StoryModel> list;
    ArrayList<DashboardModel> dashboardList;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(getLayoutInflater(),container,false);
        View view = binding.getRoot();

        // Story Rv
        list = new ArrayList<>();
        list.add(new StoryModel(R.drawable.image1,R.drawable.ic_live,R.drawable.profile,"Prateek"));
        list.add(new StoryModel(R.drawable.image2,R.drawable.ic_live,R.drawable.profile,"Harry"));
        list.add(new StoryModel(R.drawable.image1,R.drawable.ic_live,R.drawable.profile,"Potter"));
        list.add(new StoryModel(R.drawable.image2,R.drawable.ic_live,R.drawable.profile,"Prateek"));

        StoryAdapter adapter = new StoryAdapter(list,getContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,true);
        binding.storyRV.setLayoutManager(layoutManager);
        binding.storyRV.setNestedScrollingEnabled(false);
        binding.storyRV.setAdapter(adapter);

        //Dashboard Rv
        dashboardList = new ArrayList<>();
        dashboardList.add(new DashboardModel(R.drawable.profile,R.drawable.image1,R.drawable.ic_bookmark,"Prateek","Android Developer",
                "457","134","897"));
        dashboardList.add(new DashboardModel(R.drawable.profile,R.drawable.image2,R.drawable.ic_bookmark,"Harry","Traveller",
                "788","273","797"));
        dashboardList.add(new DashboardModel(R.drawable.profile,R.drawable.image1,R.drawable.ic_bookmark,"Potter","Traveller",
                "9793","14","3792"));
        dashboardList.add(new DashboardModel(R.drawable.profile,R.drawable.image2,R.drawable.ic_bookmark,"Prateek","Traveller",
                "33","3223","3442"));
        dashboardList.add(new DashboardModel(R.drawable.profile,R.drawable.image1,R.drawable.ic_bookmark,"Prateek","Traveller",
                "3972","323","323"));

        DashboardAdapter dashboardAdapter = new DashboardAdapter(dashboardList,getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        binding.dashboardRv.setLayoutManager(linearLayoutManager);
        binding.dashboardRv.addItemDecoration(new DividerItemDecoration(binding.dashboardRv.getContext(), DividerItemDecoration.VERTICAL));
        binding.dashboardRv.setNestedScrollingEnabled(false);
        binding.dashboardRv.setAdapter(dashboardAdapter);

        return view;
    }
}