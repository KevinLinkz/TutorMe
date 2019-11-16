package com.example.me.dao.general.tutorMe;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class TutorItem implements Parcelable {
    private String strId;
    private String strName;
    private int intPrize;
    private double fltRatings;
    private String strAddress;
    private String strCity;
    private String strDealDate;
    private String strTime;
    private int imgProfile;
    private String strDescription;
    private String lstSubject;
    private String lstReviews;
    private ArrayList<String> lstSchedule;


    private boolean isReschedule;
//    private ArrayList<String> lstReviews;
//    private ArrayList<String> lstSubject;

    public TutorItem(int imgProfile, String strId, String strName,
                     int intPrize, double fltRatings, String lstReviews,
                     String lstSubject, String strAddress, String strDescription) {
        this.imgProfile = imgProfile;
        this.strId = strId;
        this.strName = strName;
        this.intPrize = intPrize;
        this.fltRatings = fltRatings;
        this.lstSubject = lstSubject;
        this.lstReviews = lstReviews;
        this.strAddress = strAddress;
        this.strDescription = strDescription;
    }

    public TutorItem(int imgProfile, String strId, String strName,
                     int intPrize, double fltRatings,
                     String lstReviews, String lstSubject,
                     String strDealDate, String strTime, String strAddress,
                     boolean isReschedule
    ) {
        this.imgProfile = imgProfile;
        this.strId = strId;
        this.strName = strName;
        this.intPrize = intPrize;
        this.fltRatings = fltRatings;
        this.lstSubject = lstSubject;
        this.lstReviews = lstReviews;
        this.strDealDate = strDealDate;
        this.strTime = strTime;
        this.strAddress = strAddress;
        this.isReschedule = isReschedule;
    }

    public TutorItem(int imgProfile, String strId, String strName,
                     int intPrize, double fltRatings,
                     String lstReviews, String lstSubject,
                     String strDealDate, String strTime, String strAddress) {
        this.imgProfile = imgProfile;
        this.strId = strId;
        this.strName = strName;
        this.intPrize = intPrize;
        this.fltRatings = fltRatings;
        this.lstSubject = lstSubject;
        this.lstReviews = lstReviews;
        this.strDealDate = strDealDate;
        this.strTime = strTime;
        this.strAddress = strAddress;
    }

    public TutorItem() {
    }

    public boolean isReschedule() {
        return isReschedule;
    }

    public void setReschedule(boolean reschedule) {
        isReschedule = reschedule;
    }

    public String getStrDealDate() {
        return strDealDate;
    }

    public void setStrDealDate(String strDealDate) {
        this.strDealDate = strDealDate;
    }

    public String getStrTime() {
        return strTime;
    }

    public void setStrTime(String strTime) {
        this.strTime = strTime;
    }

    public String getStrId() {
        return strId;
    }

    public void setStrId(String strId) {
        this.strId = strId;
    }

    public String getStrName() {
        return strName;
    }

    public void setStrName(String strName) {
        this.strName = strName;
    }

    public String getLstSubject() {
        return lstSubject;
    }

    public void setLstSubject(String lstSubject) {
        this.lstSubject = lstSubject;
    }

    public int getIntPrize() {
        return intPrize;
    }

    public void setIntPrize(int intPrize) {
        this.intPrize = intPrize;
    }

    public double getFltRatings() {
        return fltRatings;
    }

    public void setFltRatings(double fltRatings) {
        this.fltRatings = fltRatings;
    }

    public String getLstReviews() {
        return lstReviews;
    }

    public void setLstReviews(String lstReviews) {
        this.lstReviews = lstReviews;
    }

    public String getStrAddress() {
        return strAddress;
    }

    public void setStrAddress(String strAddress) {
        this.strAddress = strAddress;
    }

    public String getStrCity() {
        return strCity;
    }

    public void setStrCity(String strCity) {
        this.strCity = strCity;
    }

    public int getImgProfile() {
        return imgProfile;
    }

    public void setImgProfile(int imgProfile) {
        this.imgProfile = imgProfile;
    }

    public String getStrDescription() {
        return strDescription;
    }

    public void setStrDescription(String strDescription) {
        this.strDescription = strDescription;
    }

    public ArrayList<String> getLstSchedule() {
        return lstSchedule;
    }

    public void setLstSchedule(ArrayList<String> lstSchedule) {
        this.lstSchedule = lstSchedule;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.strId);
        dest.writeString(this.strName);
        dest.writeInt(this.intPrize);
        dest.writeDouble(this.fltRatings);
        dest.writeString(this.strAddress);
        dest.writeString(this.strCity);
        dest.writeString(this.strDealDate);
        dest.writeString(this.strTime);
        dest.writeInt(this.imgProfile);
        dest.writeString(this.strDescription);
        dest.writeString(this.lstSubject);
        dest.writeString(this.lstReviews);
        dest.writeStringList(this.lstSchedule);
        dest.writeByte(this.isReschedule ? (byte) 1 : (byte) 0);
    }

    protected TutorItem(Parcel in) {
        this.strId = in.readString();
        this.strName = in.readString();
        this.intPrize = in.readInt();
        this.fltRatings = in.readDouble();
        this.strAddress = in.readString();
        this.strCity = in.readString();
        this.strDealDate = in.readString();
        this.strTime = in.readString();
        this.imgProfile = in.readInt();
        this.strDescription = in.readString();
        this.lstSubject = in.readString();
        this.lstReviews = in.readString();
        this.lstSchedule = in.createStringArrayList();
        this.isReschedule = in.readByte() != 0;
    }

    public static final Parcelable.Creator<TutorItem> CREATOR = new Parcelable.Creator<TutorItem>() {
        @Override
        public TutorItem createFromParcel(Parcel source) {
            return new TutorItem(source);
        }

        @Override
        public TutorItem[] newArray(int size) {
            return new TutorItem[size];
        }
    };
}
