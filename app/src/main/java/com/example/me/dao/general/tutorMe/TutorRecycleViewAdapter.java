package com.example.me.dao.general.tutorMe;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.me.R;
import com.example.me.dao.calendar.BasicActivity;
import com.example.me.ui.activity.ProfileDetail;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class TutorRecycleViewAdapter extends RecyclerView.Adapter<TutorRecycleViewAdapter.TutorViewHolder> {
    public ArrayList<TutorItem> tutorItems;
    private static Context context;


    public static class TutorViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgProfile;
        public TextView lblId;
        public TextView lblName;
        public TextView lblSubject;
        public TextView lblPrice;
        public TextView lblRatings;
        public TextView lblReviews;
        public Button btnBook;
        public Button btnViewProfile;


        public TutorViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            this.imgProfile = itemView.findViewById(R.id.imgProfile);
            this.lblId = itemView.findViewById(R.id.lblID);
            this.lblName = itemView.findViewById(R.id.lblName);
            this.lblSubject = itemView.findViewById(R.id.lblSubject);
            this.lblPrice = itemView.findViewById(R.id.lblPrice);
            this.lblRatings = itemView.findViewById(R.id.lblRatings);
            this.lblReviews = itemView.findViewById(R.id.lblReviews);
            this.btnBook = itemView.findViewById(R.id.btnBook);
            this.btnViewProfile = itemView.findViewById(R.id.btnProfile);
        }

    }

    public TutorRecycleViewAdapter(ArrayList<TutorItem> tutorItems) {
        this.tutorItems = tutorItems;
    }

    @NonNull
    @Override
    public TutorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tutor_list, parent, false);
        TutorViewHolder ivh = new TutorViewHolder(v);
        return ivh;
    }

    @Override
    public void onBindViewHolder(@NonNull TutorViewHolder holder, int position) {
        final TutorItem tutorItem = tutorItems.get(position);

        holder.imgProfile.setImageResource(tutorItem.getImgProfile());
        holder.lblId.setText(tutorItem.getStrId());
        holder.lblName.setText(tutorItem.getStrName());
        holder.lblSubject.setText(tutorItem.getLstSubject());
        holder.lblPrice.setText(NumberFormatIndonesia(tutorItem.getIntPrize()) + " ++");
        holder.lblRatings.setText(String.valueOf(tutorItem.getFltRatings()));
        holder.lblReviews.setText(tutorItem.getLstReviews());
        holder.btnViewProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, ProfileDetail.class)
                        .putExtra("TutorItem", tutorItem);
                context.startActivity(i);
            }
        });

        holder.btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, BasicActivity.class);
                context.startActivity(i);
            }
        });


//        holder.lblReviews.setText(tutorItem.getLstReviews());
    }

    @Override
    public int getItemCount() {
        return tutorItems.size();
    }

    public void addItem(TutorItem tutorItem) {
        tutorItems.add(tutorItem);
        notifyItemInserted(tutorItems.size());
    }

    public void removeItem(int position) {

        tutorItems.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, tutorItems.size());
    }

    public void restoreItem(TutorItem tutorItem, int position) {
        tutorItems.add(position, tutorItem);
        notifyItemInserted(position);
    }

    public String NumberFormatIndonesia(double dblAmount){
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("in","ID"));

        return  nf.format(dblAmount) + ",00";
    }


}
