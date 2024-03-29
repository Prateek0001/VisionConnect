package com.prateek.visionconnect.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.prateek.visionconnect.R;
import com.prateek.visionconnect.model.PostModel;

import java.util.ArrayList;

public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.viewHolder>{

    ArrayList<PostModel> list;
    Context context;

    public DashboardAdapter(ArrayList<PostModel> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.dashboard_rv_sample,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        PostModel model = list.get(position);

//        holder.profile.setImageResource(model.getProfile());
//        holder.postImage.setImageResource(model.getPostImg());
//        holder.name.setText(model.getName());
//        holder.about.setText(model.getAbout());
//        holder.like.setText(model.getLike());
//        holder.comment.setText(model.getComment());
//        holder.share.setText(model.getShare());
//        holder.name.setText(model.getName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        ImageView profile,postImage,save;
        TextView name,about,like,comment,share;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            profile = itemView.findViewById(R.id.ivProfileImage);
            postImage = itemView.findViewById(R.id.postImg);
            save = itemView.findViewById(R.id.save);
            name = itemView.findViewById(R.id.userName);
            about = itemView.findViewById(R.id.about);
            like = itemView.findViewById(R.id.like);
            comment = itemView.findViewById(R.id.comment);
            share = itemView.findViewById(R.id.share);
        }
    }
}
