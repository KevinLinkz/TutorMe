package com.example.me.ui.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.me.R;
import com.example.me.dao.api.inquiry.transaction.MainTransaction;
import com.example.me.dao.general.inquiry.InquiryTransactionRecycleViewAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;

/**
 * A simple {@link Fragment} subclass.
 */
public class WalletHistory extends Fragment {
    private View root;
    private RecyclerView mRecycler;
    private RecyclerView.LayoutManager mLayoutManager;

    public WalletHistory() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root =  inflater.inflate(R.layout.fragment_wallet_history, container, false);
        TabLayout tabInquiry = root.findViewById(R.id.tabInquiry);
        mRecycler = root.findViewById(R.id.rcyInquiry);
        mRecycler.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(root.getContext());
        mRecycler.setLayoutManager(mLayoutManager);

        loadInquiryTransaction();
        tabInquiry.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        break;
                    case 1:
                        loadInquiryTransaction();
                        break;
                    case 2:
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return root;
    }

    public void loadInquiryTransaction()
    {
        String strResponse = "{\n" +
                "    \"CompanyCode\" : \"80173\",\n" +
                "    \"PrimaryID\" : \"081234567890\",\n" +
                "    \"TotalTransactions\": \"2\",\n" +
                "    \"LastAccountStatementID\" : \"123455\",\n" +
                "    \"TransactionDetails\":[{\n" +
                "        \"TransactionID\" : \"TR12345\",\n" +
                "        \"AccountStatementID\" : \"123457\",\n" +
                "        \"TransactionDate\" : \"2016-02-01T13:13:13.000+07:00\",\n" +
                "        \"TransactionType\" : \"Payment\",\n" +
                "        \"Amount\" : \"5000.50\",\n" +
                "        \"CurrencyCode\" : \"IDR\",\n" +
                "        \"Description\" : \"Berita 1\",\n" +
                "        \"CurrentBalance\" : \"1000000.00\"\n" +
                "        },\n" +
                "        {\n" +
                "        \"TransactionID\":\"TR12346\",\n" +
                "        \"AccountStatementID\" : \"123456\",\n" +
                "        \"TransactionDate\":\"2016-02-01T13:13:14.000+07:00\",\n" +
                "        \"TransactionType\":\"Payment\",\n" +
                "        \"Amount\":\"7000.50\",\n" +
                "        \"CurrencyCode\":\"IDR\",\n" +
                "        \"Description\":\"Berita 2\",\n" +
                "        \"CurrentBalance\":\"994999.50\" \n" +
                "        }\n" +
                "  ]\n" +
                "}\n";
        MainTransaction mainTransactions = new Gson().fromJson(strResponse,MainTransaction.class);

        InquiryTransactionRecycleViewAdapter mInquiryTransaction = new InquiryTransactionRecycleViewAdapter(mainTransactions.getTransactionDetails());
        mRecycler.setAdapter(mInquiryTransaction);
    }

}
