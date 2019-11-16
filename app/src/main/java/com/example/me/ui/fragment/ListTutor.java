package com.example.me.ui.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.SearchView;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.me.R;
import com.example.me.dao.general.tutorMe.TutorItem;
import com.example.me.dao.general.tutorMe.TutorRecycleViewAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListTutor extends Fragment {

    private RecyclerView mRecycle;
    private TutorRecycleViewAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<TutorItem> tutorItems;
    private View root;

    public ListTutor() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_list_tutor, null);

        //SEARCH VIEW
        SearchView searchView = root.findViewById(R.id.srcMain);
        searchView.setFocusable(false);

        //FILTER
        Spinner spnSort = root.findViewById(R.id.spnSort);

        List<String> lstSort = new ArrayList<String>();
        lstSort.add("-No Sort-");
        lstSort.add("Price");
        lstSort.add("Ratings");
        ArrayAdapter<String> dataAdapterSort = new ArrayAdapter<String>(root.getContext(),
                android.R.layout.simple_spinner_dropdown_item, lstSort);
        dataAdapterSort.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnSort.setAdapter(dataAdapterSort);

        Spinner spnFilterBy = root.findViewById(R.id.spnFilterBy);
        List<String> lstFilterBy = new ArrayList<String>();
        lstFilterBy.add("-No Filter-");
        lstFilterBy.add("City");
        lstFilterBy.add("Rating");
        lstFilterBy.add("Subject");
        ArrayAdapter<String> dataAdapterFilterBy = new ArrayAdapter<String>(root.getContext(),
                android.R.layout.simple_spinner_dropdown_item, lstFilterBy);
        dataAdapterFilterBy.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnFilterBy.setAdapter(dataAdapterFilterBy);

        initRecycle();


        return root;
//        return inflater.inflate(R.layout.fragment_list_tutor, container, false);
    }

    private void initRecycle()  {
//        ExcelDatabase excelDatabase = new ExcelDatabase();
//        HashMap<String,String> myData = excelDatabase.getListDataTutor(root.getContext());
        tutorItems = new ArrayList<>();
        tutorItems.add(new TutorItem(R.raw.pp1,"1", "Kevin Hertanto", 75000, 4.2,"30 Reviews","English, Vocal, and 1 others","Taman Baca Senopati, Jakarta","Preferred student age\n" +
                "Primary school (6-12)\n" +
                "Secondary school (12-17)\n" +
                "Undergraduates (17-22)\n" +
                "Adults (23-40)\n" +
                "Adults (40+)\n" +
                "Preferred level of students\n" +
                "Beginner\n" +
                "Pre Intermediate\n\nCertified Indonesian/English Teacher with over 10 Years of Experience " +
                "Over 10 years of teaching experience, I am a certified Indonesian/English teacher and translator. After working as an Indonesian teacher for Australian Defense Force (ADF) as well as an English lecturer at a university in Indonesia, now I have my own language school in Bandung. \n" +
                "\nWhy choose Kevin Hertanto.\n" +
                "\"I am very happy that i found Mr.Kevin Hertanto here to learn Indonesian language. He is very professional and he gives me lesson sheets with important grammar tips & grammar exercises every lesson and they help me a lot. he is funny and friendly too. If you are looking for Indonesian teacher, he is the one!!\" :)"));
        tutorItems.add(new TutorItem(R.raw.pp2,"2", "Lucinta Luna", 80000, 2.2,"20 Reviews","Biology, Music, and 1 others","Taman Baca Senopati, Jakarta","Lulusan terbaik dari kampus ternama di Jakarta 2014. Mengikuti semua pelatihan dan mendapatkan sertifikan yang terbaik."));
        tutorItems.add(new TutorItem(R.raw.pp3,"3", "Dadang", 50000, 3.8,"1 Reviews","Dance, Music","Taman Baca Senopati, Jakarta","Lulusan terbaik dari kampus ternama di Jakarta 2017. Mengikuti semua pelatihan dan mendapatkan sertifikan yang terbaik."));
        tutorItems.add(new TutorItem(R.raw.pp4,"4", "Asep", 65000, 3.8,"5 Reviews","Singing, Coding, and 3 others","Taman Baca Senopati, Jakarta","Lulusan terbaik dari kampus ternama di Jakarta 2016. Mengikuti semua pelatihan dan mendapatkan sertifikan yang terbaik."));
        tutorItems.add(new TutorItem(R.raw.pp5,"5", "Ujang", 80000, 4.0,"15 Reviews","Guitar, Android, and 5 others","Taman Baca Senopati, Jakarta","Lulusan terbaik dari kampus ternama di Jakarta 2018. Mengikuti semua pelatihan dan mendapatkan sertifikan yang terbaik."));

        mRecycle = root.findViewById(R.id.rcyTutor);
        mRecycle.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(root.getContext());
        mAdapter = new TutorRecycleViewAdapter(tutorItems);
        mRecycle.setLayoutManager(mLayoutManager);
        mRecycle.setAdapter(mAdapter);
    }
}
