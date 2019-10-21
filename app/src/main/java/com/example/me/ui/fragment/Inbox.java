package com.example.me.ui.fragment;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.me.R;
import com.example.me.dao.general.inbox.InboxItem;
import com.example.me.dao.general.inbox.InboxRecycleViewAdapter;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class Inbox extends Fragment {

    private RecyclerView mRecyclerView;
    private InboxRecycleViewAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<InboxItem> inboxItems;
    private View root;

    public Inbox() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_inbox, container, false);

        //SEARCH VIEW
        SearchView searchView = root.findViewById(R.id.srcMain);
        searchView.setFocusable(false);

//        RecyclerView INBOX
        initRecycleView(root);
//
        return root;
    }


    private void initRecycleView(View root) {
        inboxItems = new ArrayList<>();
        inboxItems.add(new InboxItem(R.drawable.ic_account, "Schedule", "Your Schedule has been arrive"));
        inboxItems.add(new InboxItem(R.drawable.ic_favorite, "Schedule", "Your Schedule has been arrive"));
        inboxItems.add(new InboxItem(R.drawable.ic_home, "Schedule", "Your Schedule has been arrive"));
        inboxItems.add(new InboxItem(R.drawable.ic_account, "Schedule", "Your Schedule has been arrive"));
        inboxItems.add(new InboxItem(R.drawable.ic_favorite, "Schedule", "Your Schedule has been arrive"));
        inboxItems.add(new InboxItem(R.drawable.ic_home, "Schedule", "Your Schedule has been arrive"));
        inboxItems.add(new InboxItem(R.drawable.ic_account, "Schedule", "Your Schedule has been arrive"));
        inboxItems.add(new InboxItem(R.drawable.ic_favorite, "Schedule", "Your Schedule has been arrive"));
        inboxItems.add(new InboxItem(R.drawable.ic_home, "Schedule", "Your Schedule has been arrive"));
        inboxItems.add(new InboxItem(R.drawable.ic_account, "Schedule", "Your Schedule has been arrive"));
        inboxItems.add(new InboxItem(R.drawable.ic_favorite, "Schedule", "Your Schedule has been arrive"));
        inboxItems.add(new InboxItem(R.drawable.ic_home, "Schedule", "Your Schedule has been arrive"));

        mRecyclerView = root.findViewById(R.id.rcyInbox);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(root.getContext());
        mAdapter = new InboxRecycleViewAdapter(inboxItems);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

/*SWIPE CALLBACK (rumit)*/
//        swipeController = new SwipeControllerInbox(new SwipeControllerActions() {
//            @Override
//            public void onRightClicked(int position) {
//                mAdapter.removeItem(position);
//            }
//        });
//
//        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
//            @Override
//            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
//                swipeController.onDraw(c);
//            }
//        });
//
//        ItemTouchHelper itemTouchhelper = new ItemTouchHelper(swipeController);
//        itemTouchhelper.attachToRecyclerView(mRecyclerView);

        /*SWIPE SIMPLECALLBACK (gak rumit tapi gak lengkap)*/
        initSwipe();

    }

    private void initSwipe() {

        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();

                if (direction == ItemTouchHelper.LEFT) {
                    final InboxItem deletedModel = inboxItems.get(position);
                    final int deletedPosition = position;
                    mAdapter.removeItem(position);
                    Snackbar snackbar = Snackbar.make(root, "What the hell am i thinking?!", Snackbar.LENGTH_LONG);
                    snackbar.setAction("UNDO", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            // undo is selected, restore the deleted item
                            mAdapter.restoreItem(deletedModel, deletedPosition);
                        }
                    });

                    snackbar.setActionTextColor(Color.YELLOW);
                    snackbar.show();
                }
            }


            @Override
            public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, final float dX, float dY, int actionState, boolean isCurrentlyActive) {

                if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {

                    View itemView = viewHolder.itemView;
                    float height = (float) itemView.getBottom() - (float) itemView.getTop();
                    float width = height / 3;
                    float buttonWidthWithoutPadding = 300 - 20;
                    float corners = 16;

                    ColorDrawable background;
                    Drawable icons;
                    Paint p = new Paint();

                    if (dX < 0) {
                        icons = getResources().getDrawable(R.drawable.ic_delete);
                        background = new ColorDrawable(Color.RED);
                        background.setBounds(itemView.getRight() + ((int) dX) - 20, itemView.getTop(), itemView.getRight(), itemView.getBottom());
                        background.draw(c);

                        RectF rightButton = new RectF(itemView.getRight() - buttonWidthWithoutPadding, itemView.getTop(), itemView.getRight(), itemView.getBottom());
                        p.setColor(Color.RED);
                        c.drawRoundRect(rightButton, corners, corners, p);

                        int iconMargin = (itemView.getHeight() - icons.getIntrinsicHeight()) / 2;
                        int iconLeft = itemView.getRight() -30 - iconMargin - icons.getIntrinsicWidth();
                        int iconRight = itemView.getRight() - iconMargin - 30;
                        int iconTop = itemView.getTop() - 20 + (itemView.getHeight() - icons.getIntrinsicHeight()) / 2;
                        int iconBottom = iconTop + icons.getIntrinsicHeight() ;
                        icons.setBounds(iconLeft, iconTop, iconRight, iconBottom);
                        icons.draw(c);

                        drawText("Delete", c, rightButton, p);
                    } else if (dX > 0) {
                        icons = getResources().getDrawable(R.drawable.ic_home);
                        background = new ColorDrawable(Color.GREEN);
                        int iconMargin = (itemView.getHeight() - icons.getIntrinsicHeight()) / 2;
                        int iconLeft = itemView.getLeft() + iconMargin + icons.getIntrinsicWidth();
                        int iconRight = itemView.getLeft() + iconMargin;
                        int iconTop = itemView.getTop() + (itemView.getHeight() - icons.getIntrinsicHeight()) / 2;
                        int iconBottom = iconTop + icons.getIntrinsicHeight();
                        icons.setBounds(iconRight, iconTop, iconLeft, iconBottom);

                        background.setBounds(itemView.getLeft(), itemView.getTop(), itemView.getLeft() + ((int) dX) + 20, itemView.getBottom());
                        background.draw(c);
                        icons.draw(c);
                    }
                }
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);

            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(mRecyclerView);

    }

    private void drawText(String text, Canvas c, RectF button, Paint p) {
        float textSize = 50;
        p.setColor(Color.WHITE);
        p.setAntiAlias(true);
        p.setTextSize(textSize);

        float textWidth = p.measureText(text);
        c.drawText(text, button.centerX() - (textWidth / 2), button.centerY() + (textSize / 2) + 50, p);
    }


}
