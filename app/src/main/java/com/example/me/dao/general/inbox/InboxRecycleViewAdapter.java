package com.example.me.dao.general.inbox;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.me.R;

import java.util.ArrayList;

public class InboxRecycleViewAdapter extends RecyclerView.Adapter<InboxRecycleViewAdapter.InboxViewHolder> {
    public ArrayList<InboxItem> inboxItems;

    public static class InboxViewHolder extends RecyclerView.ViewHolder{
        public ImageView imgInbox;
        public TextView txtTitleInbox;
        public TextView txtDetailInbox;



        public InboxViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imgInbox = itemView.findViewById(R.id.imgInbox);
            this.txtTitleInbox = itemView.findViewById(R.id.txtTitleInbox);
            this.txtDetailInbox = itemView.findViewById(R.id.txtDetailInbox);
        }

    }
    public InboxRecycleViewAdapter(ArrayList<InboxItem> inboxItems) {
        this.inboxItems = inboxItems;
    }

    @NonNull
    @Override
    public InboxViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.inbox_item,parent,false);
        InboxViewHolder ivh = new InboxViewHolder(v);
        return ivh;
    }

    @Override
    public void onBindViewHolder(@NonNull InboxViewHolder holder, int position) {
        InboxItem inboxItem = inboxItems.get(position);

        holder.imgInbox.setImageResource(inboxItem.getmImageResource());
        holder.txtTitleInbox.setText(inboxItem.getStrTitleInbox());
        holder.txtDetailInbox.setText(inboxItem.getStrDetailInbox());
    }

    @Override
    public int getItemCount() {
       return  inboxItems.size();
    }

    public void addItem(InboxItem inboxItem) {
        inboxItems.add(inboxItem);
        notifyItemInserted(inboxItems.size());
    }

    public void removeItem(int position) {

        inboxItems.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, inboxItems.size());
    }

    public void restoreItem(InboxItem inboxItem,int position){
        inboxItems.add(position, inboxItem);
        notifyItemInserted(position);
    }


}
