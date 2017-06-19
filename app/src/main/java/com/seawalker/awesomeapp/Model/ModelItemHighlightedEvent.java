package com.seawalker.awesomeapp.Model;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.UUID;

/**
 * Created by LeonthePro7 on 6/18/2017.
 */

public class ModelItemHighlightedEvent {
    private static final String LOG_TAG = ModelItemHighlightedEvent.class.getSimpleName();

    enum AttendingStatus {
        ACCEPTED(1),
        NOT_SURE(2),
        DECLINED(0);

        private int attendingStatusCode;

        AttendingStatus(int statusCode) {
            attendingStatusCode = statusCode;
        }

        int getAttendingStatusCode(){
            return attendingStatusCode;
        }

        void setAttendingStatusCode(int attendingStatusCode){
            switch (attendingStatusCode){
                case 0:
                case 1:
                case 2:
                    this.attendingStatusCode = attendingStatusCode;
                    break;
                default:
                    Log.e(LOG_TAG, "One erroneous attending status code has been provided: " + attendingStatusCode);
                    this.attendingStatusCode = 2;
                    break;
            }
        }
    }

    private long id;
    private String UUID;
    private String title;
    private long startingTimeStamp;
    private long endingTimeStamp;
    private AttendingStatus attendingStatus;
    private String abstractContent;
    private String description;
    private String address;
    private String orgName;
    private String iconImageURL;
    private String backgroundImageURL;

    public ModelItemHighlightedEvent(String title,
                                     long startingTimeStamp,
                                     long endingTimeStamp,
                                     AttendingStatus attendingStatus,
                                     String abstractContent,
                                     String description,
                                     String address,
                                     String orgName,
                                     String iconImageURL,
                                     String backgroundImageURL) {
        this.UUID = java.util.UUID.randomUUID().toString();
        this.title = title;
        this.startingTimeStamp = startingTimeStamp;
        this.endingTimeStamp = endingTimeStamp;
        this.attendingStatus = attendingStatus;
        this.abstractContent = abstractContent;
        this.description = description;
        this.address = address;
        this.orgName = orgName;
        this.iconImageURL = iconImageURL;
        this.backgroundImageURL = backgroundImageURL;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    @Override
    public String toString() {
        return "ModelItemHighlightedEvent{" +
                "id=" + id +
                ", UUID='" + UUID + '\'' +
                ", title='" + title + '\'' +
                ", startingTimeStamp=" + startingTimeStamp +
                ", endingTimeStamp=" + endingTimeStamp +
                ", attendingStatus=" + attendingStatus +
                ", abstractContent='" + abstractContent + '\'' +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", iconImageURL='" + iconImageURL + '\'' +
                ", backgroundImageURL='" + backgroundImageURL + '\'' +
                '}';
    }

    public String getCountDown(){
        return "countDown";
    }

    public void toJson(JSONObject json) throws JSONException {
        json.put("hle_uuid", UUID);
        json.put("hle_title", title);
        json.put("hle_org_name", orgName);
        json.put("hle_starting_time_stamp", startingTimeStamp);
        json.put("hle_ending_time_stamp", endingTimeStamp);
        json.put("hle_attendingStatusCode", attendingStatus.getAttendingStatusCode());
        json.put("hle_abstract_content", abstractContent);
        json.put("hle_address", address);
        json.put("hle_description", description);
        json.put("hle_iconImageURL", iconImageURL);
        json.put("hle_backgroundImageURL", backgroundImageURL);
    }

    public long getId(){
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

    public long getEndingTimeStamp() {
        return endingTimeStamp;
    }

    public void setEndingTimeStamp(long endingTimeStamp) {
        this.endingTimeStamp = endingTimeStamp;
    }

    public AttendingStatus getAttendingStatus() {
        return attendingStatus;
    }

    public void setAttendingStatus(AttendingStatus attendingStatus) {
        this.attendingStatus = attendingStatus;
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
}
