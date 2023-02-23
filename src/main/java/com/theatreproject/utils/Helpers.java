package com.theatreproject.utils;

import com.theatreproject.controllers.ShowControllerImpl;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Helpers {
    public Helpers () {}

    private static class LazyHolder {
        static final Helpers INSTANCE = new Helpers();
    }

    public static Helpers getInstance() {
        return Helpers.LazyHolder.INSTANCE;
    }

    public String getDateToString(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }
}
