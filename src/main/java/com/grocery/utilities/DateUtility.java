package com.grocery.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Jason on 14/10/2017.
 */
public class DateUtility {
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String getCurrentDate () {
        Date currentdate = new Date();
        return simpleDateFormat.format(currentdate);
    }
}
