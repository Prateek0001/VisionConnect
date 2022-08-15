package com.prateek.visionconnect.adapter;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.prateek.visionconnect.R;
import com.prateek.visionconnect.model.Notification1Model;

import java.util.ArrayList;

public class Notification1Adapter extends RecyclerView.Adapter<Notification1Adapter.viewHolder>{

    ArrayList<Notification1Model> list;
    Context context;

    public Notification1Adapter(ArrayList<Notification1Model> list, Context context) {
        this.list = list;
        this.context = context;
    }



    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.notification1design,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Notification1Model model = list.get(position);
        holder.profile.setImageResource(model.getProfile());
        holder.notification.setText(Html.fromHtml(model.getNotification()));
        holder.time.setText(model.getTime());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView profile;
        TextView notification,time;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            profile = itemView.findViewById(R.id.profile_image);
            notification = itemView.findViewById(R.id.notification);
            time = itemView.findViewById(R.id.time);
        }
    }
}
