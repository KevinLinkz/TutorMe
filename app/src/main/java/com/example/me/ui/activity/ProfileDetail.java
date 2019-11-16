package com.example.me.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.me.R;
import com.example.me.dao.calendar.BasicActivity;
import com.example.me.dao.general.tutorMe.TutorItem;
import com.example.me.ui.fragment.ProfileDetailDescription;

public class ProfileDetail extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_detail);

        //GET OBJECT
        TutorItem tutorItem = getIntent().getParcelableExtra("TutorItem");
        //TEMPELIN
        ImageView imgProfile = findViewById(R.id.imgProfile);
        TextView lblName = findViewById(R.id.lblName);
        TextView lblID = findViewById(R.id.lblID);
        TextView lblSubject = findViewById(R.id.lblSubject);
        TextView lblLocation = findViewById(R.id.lblLocation);
        TextView lblRatings = findViewById(R.id.lblRatings);
        TextView lblSinceOpen = findViewById(R.id.lblSinceOpen);

        imgProfile.setImageResource(tutorItem.getImgProfile());
        lblName.setText(tutorItem.getStrName());
        lblID.setText(tutorItem.getStrName());
        lblSubject.setText(tutorItem.getLstSubject());
        lblLocation.setText(tutorItem.getStrAddress());
        lblRatings.setText(String.valueOf(tutorItem.getFltRatings()) + " (" + tutorItem.getLstReviews() + ")");
        lblSinceOpen.setText("Tutoring Since 2019");

        loadFragment(new ProfileDetailDescription(tutorItem.getStrDescription()));

        Button btnBook = findViewById(R.id.btnBook);
        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ProfileDetail.this, BasicActivity.class);
                startActivity(i);
            }
        });


//        TabLayout tabLayout = findViewById(R.id.tabProfile);
//        tabLayout.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                Fragment fragment = null;
//
//                switch (tab.getPosition()){
//                    case 0:
//                        fragment = new ProfileDetailDescription();
//                        break;
//                    case 1:
//                        fragment = new ProfileDetailSchedule();
//                        break;
//                    default:
//                        break;
//
//                }
//                loadFragment(fragment);
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
    }

    public boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.flContainer, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}
