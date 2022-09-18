package com.prateek.visionconnect.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prateek.visionconnect.R;
import com.prateek.visionconnect.databinding.FragmentAddBinding;


public class AddFragment extends Fragment {
    FragmentAddBinding binding;


    public AddFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAddBinding.inflate(getLayoutInflater(),container,false);
        return binding.getRoot();
    }
}