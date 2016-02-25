package com.thuongleit.collectandupdate.vo;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;
import com.thuongleit.collectandupdate.data.local.CollectDatabase;

/**
 * Created by thuongle on 2/25/16.
 */
@Table(database = CollectDatabase.class)
public class News extends BaseModel implements Parcelable {

    @JsonProperty("text")
    @Column(name = "title")
    @PrimaryKey(autoincrement = false)
    String mTitle;

    @JsonProperty("href")
    @Column(name = "url")
    String mUrl;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mTitle);
        dest.writeString(this.mUrl);
    }

    public News() {
    }

    protected News(Parcel in) {
        this.mTitle = in.readString();
        this.mUrl = in.readString();
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        this.mUrl = url;
    }

    public static final Creator<News> CREATOR = new Creator<News>() {
        public News createFromParcel(Parcel source) {
            return new News(source);
        }

        public News[] newArray(int size) {
            return new News[size];
        }
    };
}
