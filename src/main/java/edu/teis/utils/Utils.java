package edu.teis.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

public class Utils {
    public static Date stringToDate(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.parse(date);
    }

    public static LocalTime stringToTime(String time) throws ParseException {
        // LocalTime.parse() ?????
        return ;
    }
}
