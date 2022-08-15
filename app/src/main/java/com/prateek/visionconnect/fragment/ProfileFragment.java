package com.prateek.visionconnect.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prateek.visionconnect.R;
import com.prateek.visionconnect.adapter.FriendAdapter;
import com.prateek.visionconnect.databinding.FragmentProfileBinding;
import com.prateek.visionconnect.model.FriendModel;

import java.util.ArrayList;


public class ProfileFragment extends Fragment {

    ArrayList<FriendModel> list;
    FragmentProfileBinding binding;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(getLayoutInflater(),container,false);

        list = new ArrayList<>();
        list.add(new FriendModel(R.drawable.profile));
        list.add(new FriendModel(R.drawable.image1));
        list.add(new FriendModel(R.drawable.image2));
        list.add(new FriendModel(R.drawable.profile));
        list.add(new FriendModel(R.drawable.image2));
        list.add(new FriendModel(R.drawable.image1));
        list.add(new FriendModel(R.drawable.profile));
        list.add(new FriendModel(R.drawable.image1));
        list.add(new FriendModel(R.drawable.image2));

        FriendAdapter adapter = new FriendAdapter(list,getContext());
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        binding.friendsRV.setLayoutManager(layoutManager);
        binding.friendsRV.setAdapter(adapter);


        return binding.getRoot();
    }
}