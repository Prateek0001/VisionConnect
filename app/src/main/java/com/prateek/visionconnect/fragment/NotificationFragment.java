package com.prateek.visionconnect.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.prateek.visionconnect.adapter.ViewPagerAdapter;
import com.prateek.visionconnect.databinding.FragmentNotificationBinding;


public class NotificationFragment extends Fragment {

    FragmentNotificationBinding binding;

    public NotificationFragment() {
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
        binding = FragmentNotificationBinding.inflate(getLayoutInflater(),container,false);

        binding.viewPager.setAdapter(new ViewPagerAdapter(getChildFragmentManager()));
        binding.tabLayout.setupWithViewPager(binding.viewPager);


        return binding.getRoot();
    }
}