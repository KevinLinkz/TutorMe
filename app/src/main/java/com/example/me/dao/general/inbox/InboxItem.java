package com.example.me.dao.general.inbox;

public class InboxItem {
    private int mImageResource;
    private String strTitleInbox;
    private String strDetailInbox;

    public InboxItem(int mImageResource, String strTitleInbox, String strDetailInbox) {
        this.mImageResource = mImageResource;
        this.strTitleInbox = strTitleInbox;
        this.strDetailInbox = strDetailInbox;
    }

    public int getmImageResource() {
        return mImageResource;
    }

    public void setmImageResource(int mImageResource) {
        this.mImageResource = mImageResource;
    }

    public String getStrTitleInbox() {
        return strTitleInbox;
    }

    public void setStrTitleInbox(String strTitleInbox) {
        this.strTitleInbox = strTitleInbox;
    }

    public String getStrDetailInbox() {
        return strDetailInbox;
    }

    public void setStrDetailInbox(String strDetailInbox) {
        this.strDetailInbox = strDetailInbox;
    }
}
