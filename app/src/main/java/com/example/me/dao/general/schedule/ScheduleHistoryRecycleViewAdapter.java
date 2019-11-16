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

public class ScheduleHistoryRecycleViewAdapter extends RecyclerView.Adapter<ScheduleHistoryRecycleViewAdapter.ScheduleHistoryViewHolder> {
    public ArrayList<TutorItem> tutorItems;
    public ScheduleHistoryRecycleViewAdapter(ArrayList<TutorItem> tutorItems) {
        this.tutorItems = tutorItems;
    }
    public static class ScheduleHistoryViewHolder extends RecyclerView.ViewHolder{
        public ImageView imgProfile;
        public TextView lblID;
        public TextView lblName;
        public TextView lblSubject;
        public TextView lblDealDate;
        public TextView lblTime;
        public TextView lblAddress;



        public ScheduleHistoryViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imgProfile = itemView.findViewById(R.id.imgProfile);
            this.lblID = itemView.findViewById(R.id.lblID);
            this.lblName = itemView.findViewById(R.id.lblName);
            this.lblSubject = itemView.findViewById(R.id.lblSubject);
            this.lblDealDate = itemView.findViewById(R.id.lblDate);
            this.lblTime = itemView.findViewById(R.id.lblTime);
            this.lblAddress = itemView.findViewById(R.id.lblLocation);
        }

    }

    @NonNull
    @Override
    public ScheduleHistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.schedule_history_item,parent,false);
        ScheduleHistoryViewHolder ivh = new ScheduleHistoryViewHolder(v);
        return ivh;
    }

    @Override
    public void onBindViewHolder(@NonNull ScheduleHistoryViewHolder holder, int position) {
        TutorItem tutorItem = tutorItems.get(position);

        holder.imgProfile.setImageResource(tutorItem.getImgProfile());
        holder.lblID.setText(tutorItem.getStrId());
        holder.lblName.setText(tutorItem.getStrName());
        holder.lblSubject.setText(tutorItem.getLstSubject());
        holder.lblDealDate.setText(tutorItem.getStrDealDate());
        holder.lblTime.setText(tutorItem.getStrTime());
        holder.lblAddress.setText(tutorItem.getStrAddress());
    }

    @Override
    public int getItemCount() {
        return tutorItems.size();
    }





}
