package com.example.resto.models;


import android.os.Parcel;
import android.os.Parcelable;

import kotlinx.android.parcel.Parcelize;

@Parcelize
public class NicePlace implements Parcelable {

    private String title;
    private Integer imageUrl;

    public NicePlace(Integer imageUrl, String title) {
        this.title = title;
        this.imageUrl = imageUrl;
    }
    public NicePlace(Integer imageUrl){
        this.imageUrl=imageUrl;
    }

    public NicePlace() {
    }

    protected NicePlace(Parcel in) {
        title = in.readString();
        if (in.readByte() == 0) {
            imageUrl = null;
        } else {
            imageUrl = in.readInt();
        }
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        if (imageUrl == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(imageUrl);
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<NicePlace> CREATOR = new Creator<NicePlace>() {
        @Override
        public NicePlace createFromParcel(Parcel in) {
            return new NicePlace(in);
        }

        @Override
        public NicePlace[] newArray(int size) {
            return new NicePlace[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }

}

