package com.prateek.visionconnect.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.prateek.visionconnect.R;
import com.prateek.visionconnect.databinding.UserDesignBinding;
import com.prateek.visionconnect.model.FollowModel;
import com.prateek.visionconnect.model.UserModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Date;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.viewHolder> {

    Context context;
    ArrayList<UserModel> list;

    public UserAdapter(Context context, ArrayList<UserModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_design, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        UserModel user = list.get(position);
        Picasso.get()
                .load(user.getProfilePhoto())
                .placeholder(R.drawable.placeholder)
                .into(holder.binding.ivProfileImage);
        holder.binding.tvName.setText(user.getName());
        holder.binding.tvProfession.setText(user.getProfession());

        holder.binding.btnFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FollowModel follow = new FollowModel();
                follow.setFollowedBy(FirebaseAuth.getInstance().getUid());
                follow.setFollowedAt(new Date().getTime());

                FirebaseDatabase.getInstance().getReference()
                        .child("Users")
                        .child(user.getUserID())
                        .child("followers")
                        .child(FirebaseAuth.getInstance().getUid())
                        .setValue(follow).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                FirebaseDatabase.getInstance().getReference()
                                        .child("Users")
                                        .child(user.getUserID())
                                        .child("followerCount")
                                        .setValue(user.getFollowerCount() + 1).addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void unused) {
                                                Toast.makeText(context, "You followed "+user.getName(), Toast.LENGTH_SHORT).show();
                                            }
                                        });
                            }
                        });
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        UserDesignBinding binding;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            binding = UserDesignBinding.bind(itemView);
        }
    }
}
