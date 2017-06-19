package com.seawalker.awesomeapp.Model;

/**
 * Created by LeonthePro7 on 6/18/2017.
 */

public class ModelItemHighlightEvent {

    enum AttendingStatus {
        ACCEPTED(1),
        NOT_SURE(2),
        DECLINED(0);

        private final int attendingStatusCode;

        AttendingStatus(int statusCode) {
            attendingStatusCode = statusCode;
        }
    }

    private String id;
    private String title;
    private long timeStamp;
    private AttendingStatus attendingStatus;


}
