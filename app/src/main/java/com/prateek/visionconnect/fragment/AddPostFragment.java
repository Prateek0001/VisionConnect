package com.prateek.visionconnect.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.prateek.visionconnect.databinding.FragmentAddPostBinding;

public class AddPostFragment extends Fragment {

    FragmentAddPostBinding binding;

    public AddPostFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentAddPostBinding.inflate(inflater, container, false);

        return binding.getRoot();
    }
}