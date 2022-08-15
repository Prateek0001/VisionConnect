package com.prateek.visionconnect.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prateek.visionconnect.R;
import com.prateek.visionconnect.adapter.Notification1Adapter;
import com.prateek.visionconnect.databinding.FragmentNotification1Binding;
import com.prateek.visionconnect.model.Notification1Model;

import java.util.ArrayList;


public class Notification1Fragment extends Fragment {

    FragmentNotification1Binding binding;
    ArrayList<Notification1Model> list;


    public Notification1Fragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentNotification1Binding.inflate(getLayoutInflater(),container,false);

        list = new ArrayList<>();
        list.add(new Notification1Model(R.drawable.profile,"<b>Sundar Pichai</b> liked your photo","just now"));
        list.add(new Notification1Model(R.drawable.profile,"<b>Elon Musk</b> liked your photo","1 hour ago"));
        list.add(new Notification1Model(R.drawable.profile,"<b>Aambani</b> commented your photo : Nice pic","3 hour ago"));
        list.add(new Notification1Model(R.drawable.profile,"<b>Sundar Pichai</b> commented on your photo : Nice pic","5 hour ago"));
        list.add(new Notification1Model(R.drawable.profile,"<b>Sundar Pichai</b> mentioned you in a comment","3 day ago"));

        Notification1Adapter adapter = new Notification1Adapter(list,getContext());
        LinearLayoutManager layoutManager =  new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        binding.recyclerView.setLayoutManager(layoutManager);
        binding.recyclerView.setAdapter(adapter);

        return binding.getRoot();
    }
}