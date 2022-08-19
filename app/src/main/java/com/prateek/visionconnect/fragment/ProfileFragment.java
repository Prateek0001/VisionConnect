package com.prateek.visionconnect.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.prateek.visionconnect.R;
import com.prateek.visionconnect.adapter.FriendAdapter;
import com.prateek.visionconnect.databinding.FragmentProfileBinding;
import com.prateek.visionconnect.model.FriendModel;
import com.prateek.visionconnect.model.UserModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class ProfileFragment extends Fragment {

    ArrayList<FriendModel> list;
    FragmentProfileBinding binding;
    FirebaseAuth mAuth;
    FirebaseStorage storage;
    FirebaseDatabase database;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAuth = FirebaseAuth.getInstance();
        storage = FirebaseStorage.getInstance();
        database = FirebaseDatabase.getInstance();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(getLayoutInflater(),container,false);

        database.getReference().child("Users").child(mAuth.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    UserModel userModel = snapshot.getValue(UserModel.class);
                    Picasso.get()
                            .load(userModel.getProfilePhoto())
                            .placeholder(R.drawable.placeholder)
                            .into(binding.ivProfileImage);
                    Picasso.get()
                            .load(userModel.getCoverPhoto())
                            .placeholder(R.drawable.placeholder)
                            .into(binding.ivCoverPhoto);
                    binding.tvUserName.setText(userModel.getName());
                    binding.tvProfession.setText(userModel.getProfession());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

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


        binding.ivChangeCoverPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent,101);
            }
        });

        binding.icVerified.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent,102);
            }
        });




        return binding.getRoot();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 101){
            if(data.getData() != null){
                Uri uri = data.getData();
                binding.ivCoverPhoto.setImageURI(uri);

                final StorageReference reference = storage.getReference().child("cover_photo").child(FirebaseAuth.getInstance().getUid());
                reference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Toast.makeText(getContext(), "Cover photo saved", Toast.LENGTH_SHORT).show();
                        reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                database.getReference().child("Users").child(mAuth.getUid()).child("coverPhoto").setValue(uri.toString());
                            }
                        });
                    }
                });
            }

        }else if(requestCode == 102){
            if(data.getData() != null){
                Uri uri = data.getData();
                binding.ivProfileImage.setImageURI(uri);

                final StorageReference reference = storage.getReference().child("profile_photo").child(FirebaseAuth.getInstance().getUid());
                reference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Toast.makeText(getContext(), "Profile photo saved", Toast.LENGTH_SHORT).show();
                        reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                            @Override
                            public void onSuccess(Uri uri) {
                                database.getReference().child("Users").child(mAuth.getUid()).child("profilePhoto").setValue(uri.toString());
                            }
                        });
                    }
                });
            }
        }
    }
}