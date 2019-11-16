package com.example.me.dao.general.schedule;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.me.R;
import com.example.me.dao.general.tutorMe.TutorItem;
import com.example.me.ui.activity.ScanBarcode;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class ScheduleUpcomingRecycleViewAdapter extends RecyclerView.Adapter<ScheduleUpcomingRecycleViewAdapter.ScheduleUpcomingViewHolder> {
    public ArrayList<TutorItem> tutorItems;
    private static Context context;
    public ScheduleUpcomingRecycleViewAdapter(ArrayList<TutorItem> tutorItems) {
        this.tutorItems = tutorItems;
    }
    public static class ScheduleUpcomingViewHolder extends RecyclerView.ViewHolder{
        public ImageView imgProfile;
        public TextView lblID;
        public TextView lblName;
        public TextView lblSubject;
        public TextView lblDealDate;
        public TextView lblTime;
        public TextView lblAddress;
        public MaterialButton btnReschedule;
        public MaterialButton btnAttendance;



        public ScheduleUpcomingViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            this.imgProfile = itemView.findViewById(R.id.imgProfile);
            this.lblID = itemView.findViewById(R.id.lblID);
            this.lblName = itemView.findViewById(R.id.lblName);
            this.lblSubject = itemView.findViewById(R.id.lblSubject);
            this.lblDealDate = itemView.findViewById(R.id.lblDate);
            this.lblTime = itemView.findViewById(R.id.lblTime);
            this.lblAddress = itemView.findViewById(R.id.lblLocation);
            this.btnReschedule = itemView.findViewById(R.id.btnReschedule);
            this.btnAttendance = itemView.findViewById(R.id.btnAttendance);
        }

    }

    @NonNull
    @Override
    public ScheduleUpcomingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.schedule_upcoming_item,parent,false);
        ScheduleUpcomingViewHolder ivh = new ScheduleUpcomingViewHolder(v);
        return ivh;
    }

    @Override
    public void onBindViewHolder(@NonNull ScheduleUpcomingViewHolder holder, int position) {
        TutorItem tutorItem = tutorItems.get(position);

        holder.imgProfile.setImageResource(tutorItem.getImgProfile());
        holder.lblID.setText(tutorItem.getStrId());
        holder.lblName.setText(tutorItem.getStrName());
        holder.lblSubject.setText(tutorItem.getLstSubject());
        holder.lblDealDate.setText(tutorItem.getStrDealDate());
        holder.lblTime.setText(tutorItem.getStrTime());
        holder.lblAddress.setText(tutorItem.getStrAddress());
        if(tutorItem.isReschedule()){
            holder.btnReschedule.setVisibility(View.VISIBLE);
        }
        else{
            holder.btnAttendance.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "Scan Absent Barcode", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(context, ScanBarcode.class);
                    context.startActivity(i);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return tutorItems.size();
    }





}
