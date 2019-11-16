package com.example.me.dao.general.schedule;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.me.R;
import com.example.me.dao.general.tutorMe.TutorItem;

import java.util.ArrayList;

public class SchedulePendingRecycleViewAdapter extends RecyclerView.Adapter<SchedulePendingRecycleViewAdapter.SchedulePendingViewHolder> {
    public ArrayList<TutorItem> tutorItems;
    public SchedulePendingRecycleViewAdapter(ArrayList<TutorItem> tutorItems) {
        this.tutorItems = tutorItems;
    }
    public static class SchedulePendingViewHolder extends RecyclerView.ViewHolder{
        public ImageView imgProfile;
        public TextView lblID;
        public TextView lblName;
        public TextView lblSubject;
        public TextView lblSession;



        public SchedulePendingViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imgProfile = itemView.findViewById(R.id.imgProfile);
            this.lblID = itemView.findViewById(R.id.lblID);
            this.lblName = itemView.findViewById(R.id.lblName);
            this.lblSubject = itemView.findViewById(R.id.lblSubject);
            this.lblSession = itemView.findViewById(R.id.lblSession);
        }

    }

    @NonNull
    @Override
    public SchedulePendingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.schedule_pending_item,parent,false);
        SchedulePendingViewHolder ivh = new SchedulePendingViewHolder(v);
        return ivh;
    }

    @Override
    public void onBindViewHolder(@NonNull SchedulePendingViewHolder holder, int position) {
        TutorItem tutorItem = tutorItems.get(position);

        holder.imgProfile.setImageResource(tutorItem.getImgProfile());
        holder.lblID.setText(tutorItem.getStrId());
        holder.lblName.setText(tutorItem.getStrName());
        holder.lblSubject.setText(tutorItem.getLstSubject());
        holder.lblSession.setText(tutorItem.getLstReviews());
    }

    @Override
    public int getItemCount() {
        return tutorItems.size();
    }





}
