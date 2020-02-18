package com.example.frameapp.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 环信好友对象类
 * 2020-02-17
 *
 * @author
 */
public class HxBuddyBean implements Parcelable {

    private String name;
    private String time;
    private String news;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.time);
        dest.writeString(this.news);
    }

    public HxBuddyBean() {
    }

    protected HxBuddyBean(Parcel in) {
        this.name = in.readString();
        this.time = in.readString();
        this.news = in.readString();
    }

    public static final Parcelable.Creator<HxBuddyBean> CREATOR = new Parcelable.Creator<HxBuddyBean>() {
        @Override
        public HxBuddyBean createFromParcel(Parcel source) {
            return new HxBuddyBean(source);
        }

        @Override
        public HxBuddyBean[] newArray(int size) {
            return new HxBuddyBean[size];
        }
    };
}
