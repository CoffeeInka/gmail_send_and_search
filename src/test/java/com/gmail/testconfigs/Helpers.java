package com.gmail.testconfigs;

import java.util.Calendar;

/**
 * Created by inna on 26/06/2017.
 */
public class Helpers {

    public static String getUniqueString(String prefix) {
        Calendar cal = Calendar.getInstance();
        return String.format(prefix + " %tF %<tT.%<tL", cal, cal);
    }
}
