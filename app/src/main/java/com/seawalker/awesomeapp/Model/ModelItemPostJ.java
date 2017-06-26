package com.seawalker.awesomeapp.Model;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by LeonthePro7 on 6/18/2017.
 */

public class ModelItemPostJ implements Parcelable {
    private static final String LOG_TAG = ModelItemPostJ.class.getSimpleName();

    private long id;
    private String UUID;
    private String title;
    private long startingTimeStamp;
    private long endingTimeStamp;
    private String countDown;
    private String abstractContent;
    private String description;
    private String address;
    private String orgName;
    private String iconImageURL;
    private String backgroundImageURL;

    public ModelItemPostJ(String title,
                          long startingTimeStamp,
                          long endingTimeStamp,
                          String abstractContent,
                          String description,
                          String address,
                          String orgName,
                          String iconImageURL,
                          String backgroundImageURL) {
        this.title = title;
        this.startingTimeStamp = startingTimeStamp;
        this.endingTimeStamp = endingTimeStamp;
        this.abstractContent = abstractContent;
        this.description = description;
        this.address = address;
        this.orgName = orgName;
        this.iconImageURL = iconImageURL;
        this.backgroundImageURL = backgroundImageURL;
        this.UUID = java.util.UUID.randomUUID().toString();
    }

    public static final ArrayList<ModelItemPostJ> dummyPostsCreator() {
        Log.v(LOG_TAG, "dummyPostsCreator() executed");

        ArrayList<ModelItemPostJ> dummyPosts = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            String title = "Title" + i;
            long startingTimeStamp = System.currentTimeMillis();
            long endingTimeStamp = System.currentTimeMillis();
            String abstractContent = "abstractContent" + i;
            String description = "description" + i;
            String address = "address" + i;
            String orgName = "orgName" + i;
            String iconImageUrl = "";
            String backgroundImageUrl = "";

            ModelItemPostJ dummyPost = new ModelItemPostJ(title,
                    startingTimeStamp,
                    endingTimeStamp,
                    abstractContent,
                    description,
                    address,
                    orgName,
                    iconImageUrl,
                    backgroundImageUrl);
            dummyPosts.add(dummyPost);
        }

        return dummyPosts;
    }

    protected ModelItemPostJ(Parcel in) {
        id = in.readLong();
        UUID = in.readString();
        title = in.readString();
        startingTimeStamp = in.readLong();
        endingTimeStamp = in.readLong();
        countDown = in.readString();
        abstractContent = in.readString();
        description = in.readString();
        address = in.readString();
        orgName = in.readString();
        iconImageURL = in.readString();
        backgroundImageURL = in.readString();
    }

    public static final Creator<ModelItemPostJ> CREATOR = new Creator<ModelItemPostJ>() {
        @Override
        public ModelItemPostJ createFromParcel(Parcel in) {
            return new ModelItemPostJ(in);
        }

        @Override
        public ModelItemPostJ[] newArray(int size) {
            return new ModelItemPostJ[size];
        }
    };

    public long getId() {
        return id;
    }

    public String getUUID() {
        return UUID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getStartingTimeStamp() {
        return startingTimeStamp;
    }

    public void setStartingTimeStamp(long startingTimeStamp) {
        this.startingTimeStamp = startingTimeStamp;
    }

    public String getCountDown() {
        return countDown;
    }

    public void setCountDown(String countDown) {
        this.countDown = countDown;
    }

    public long getEndingTimeStamp() {
        return endingTimeStamp;
    }

    public void setEndingTimeStamp(long endingTimeStamp) {
        this.endingTimeStamp = endingTimeStamp;
    }

    public String getAbstractContent() {
        return abstractContent;
    }

    public void setAbstractContent(String abstractContent) {
        this.abstractContent = abstractContent;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getIconImageURL() {
        return iconImageURL;
    }

    public void setIconImageURL(String iconImageURL) {
        this.iconImageURL = iconImageURL;
    }

    public String getBackgroundImageURL() {
        return backgroundImageURL;
    }

    public void setBackgroundImageURL(String backgroundImageURL) {
        this.backgroundImageURL = backgroundImageURL;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(UUID);
        dest.writeString(title);
        dest.writeLong(startingTimeStamp);
        dest.writeLong(endingTimeStamp);
        dest.writeString(countDown);
        dest.writeString(abstractContent);
        dest.writeString(description);
        dest.writeString(address);
        dest.writeString(orgName);
        dest.writeString(iconImageURL);
        dest.writeString(backgroundImageURL);
    }
}
