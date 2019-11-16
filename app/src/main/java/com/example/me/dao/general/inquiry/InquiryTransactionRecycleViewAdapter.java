package com.example.me.dao.general.inquiry;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.me.R;
import com.example.me.dao.api.inquiry.transaction.TransactionDetailsItem;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class InquiryTransactionRecycleViewAdapter extends RecyclerView.Adapter<InquiryTransactionRecycleViewAdapter.InquiryTransactionViewHolder> {
    public List<TransactionDetailsItem> transactionDetailsItems;
    private static Context context;


    public static class InquiryTransactionViewHolder extends RecyclerView.ViewHolder {
        public TextView lblDate;
        public TextView lblAmount;
        public TextView lblTransactionType;
        public TextView lblDescription;


        public InquiryTransactionViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            this.lblDate = itemView.findViewById(R.id.lblDate);
            this.lblAmount = itemView.findViewById(R.id.lblAmount);
            this.lblTransactionType = itemView.findViewById(R.id.lblTransactionType);
            this.lblDescription = itemView.findViewById(R.id.lblDescription);
        }

    }

    public InquiryTransactionRecycleViewAdapter(List<TransactionDetailsItem> transactionDetailsItems) {
        this.transactionDetailsItems = transactionDetailsItems;
    }

    @NonNull
    @Override
    public InquiryTransactionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.wallet_inquiry_transaction, parent, false);
        InquiryTransactionViewHolder ivh = new InquiryTransactionViewHolder(v);
        return ivh;
    }

    @Override
    public void onBindViewHolder(@NonNull InquiryTransactionViewHolder holder, int position) {
        final TransactionDetailsItem transactionDetailsItem = transactionDetailsItems.get(position);


        holder.lblDate.setText(ChangeFormatDate(transactionDetailsItem.getTransactionDate()));
        holder.lblAmount.setText(NumberFormatIndonesia(Double.parseDouble( transactionDetailsItem.getAmount().replace(".00",""))));
        holder.lblTransactionType.setText( transactionDetailsItem.getTransactionType());
        holder.lblDescription.setText(transactionDetailsItem.getDescription());

//        holder.lbl1.setText("Transaction ID              = " + transactionDetailsItem.getTransactionID());
//        holder.lbl2.setText("Account Statement ID = " + transactionDetailsItem.getAccountStatementID());
//        holder.lbl3.setText("Transaction Date = " +s ChangeFormatDate(transactionDetailsItem.getTransactionDate()));
//        holder.lbl4.setText("Transaction Type          = " + transactionDetailsItem.getTransactionType());
//        holder.lbl5.setText("Amount                          = " + transactionDetailsItem.getAmount());
//        holder.lbl6.setText("Description                    = " + transactionDetailsItem.getDescription());
//        holder.lbl7.setText("Current Balance            = " + transactionDetailsItem.getCurrentBalance());

    }

    @Override
    public int getItemCount() {
        return transactionDetailsItems.size();
    }

    public void addItem(TransactionDetailsItem transactionDetailsItem) {
        transactionDetailsItems.add(transactionDetailsItem);
        notifyItemInserted(transactionDetailsItems.size());
    }

    public void removeItem(int position) {

        transactionDetailsItems.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, transactionDetailsItems.size());
    }

    public void restoreItem(TransactionDetailsItem transactionDetailsItem, int position) {
        transactionDetailsItems.add(position, transactionDetailsItem);
        notifyItemInserted(position);
    }

    public String NumberFormatIndonesia(double dblAmount) {
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("in", "ID"));

        return nf.format(dblAmount) ;
    }

    public String ChangeFormatDate(String strDate){
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
//        return new SimpleDateFormat("dd-MM-yyyy HH:mm").format(date);
        return new SimpleDateFormat("dd-MM").format(date);
    }


}
