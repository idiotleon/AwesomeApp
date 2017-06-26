package com.seawalker.awesomeapp.utilies;

import java.util.Calendar;

/**
 * Created by Leon on 6/26/2017.
 */

public class TimeUtils {

    public static String getCurrentDayOfWeek() {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);

        switch (day) {
            case Calendar.SUNDAY:
                return "SUNDAY";
            case Calendar.SATURDAY:
                return "SATURDAY";
            case Calendar.FRIDAY:
                return "FRIDAY";
            case Calendar.THURSDAY:
                return "THURSDAY";
            case Calendar.WEDNESDAY:
                return "WEDNESDAY";
            case Calendar.TUESDAY:
                return "TUESDAY";
            case Calendar.MONDAY:
                return "MONDAY";
        }

        return "";
    }

    public static String getCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH) + 1;
        String monthName = "";

        switch (month) {
            case 1:
                monthName = "JANUARY";
                break;
            case 2:
                monthName = "FEBRUARY";
                break;
            case 3:
                monthName = "MARCH";
                break;
            case 4:
                monthName = "APRIL";
                break;
            case 5:
                monthName = "MAY";
                break;
            case 6:
                monthName = "JUNE";
                break;
            case 7:
                monthName = "JULY";
                break;
            case 8:
                monthName = "AUGUST";
                break;
            case 9:
                monthName = "SEPTEMBER";
                break;
            case 10:
                monthName = "OCTOBER";
                break;
            case 11:
                monthName = "NOVEMBER";
                break;
            case 12:
                monthName = "DECEMBER";
                break;
        }

        String currentDate = monthName + " " + day;

        return currentDate;
    }

    public static long getCurrentTimeStamp() {
        return System.currentTimeMillis();
    }
}
