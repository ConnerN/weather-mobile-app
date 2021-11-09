package com.example.android.sqliteweather.utils;

import android.content.Context;
import android.text.TextUtils;

import com.example.android.sqliteweather.R;

import java.util.Calendar;
import java.util.TimeZone;

public class OpenWeatherUtils {
    private final static String FIVE_DAY_FORECAST_DEFAULT_TIMEZONE = "UTC";
    private final static String TIMEZONE_OFFSET_FORMAT_STR = "GMT%0+3d:%02d";

    public static Calendar dateFromEpochAndTZOffset(int epoch, int tzOffsetSeconds) {
        Calendar date = Calendar.getInstance(TimeZone.getTimeZone(FIVE_DAY_FORECAST_DEFAULT_TIMEZONE));
        date.setTimeInMillis(epoch * 1000L);
        int tzOffsetHours = tzOffsetSeconds / 3600;
        int tzOffsetMin = (Math.abs(tzOffsetSeconds) % 3600) / 60;
        String localTimezoneId = String.format(TIMEZONE_OFFSET_FORMAT_STR, tzOffsetHours, tzOffsetMin);
        date.setTimeZone(TimeZone.getTimeZone(localTimezoneId));
        return date;
    }

    public static String getTemperatureDisplayForUnitsPref(String units, Context ctx) {
        if (TextUtils.equals(units, ctx.getString(R.string.pref_units_standard_value))) {
            return ctx.getString(R.string.pref_units_standard_temp_display);
        } else if (TextUtils.equals(units, ctx.getString(R.string.pref_units_metric_value))) {
            return ctx.getString(R.string.pref_units_metric_temp_display);
        } else {
            return ctx.getString(R.string.pref_units_imperial_temp_display);
        }
    }

    public static String getWindSpeedDisplayForUnitsPref(String units, Context ctx) {
        if (TextUtils.equals(units, ctx.getString(R.string.pref_units_standard_value))) {
            return ctx.getString(R.string.pref_units_standard_wind_display);
        } else if (TextUtils.equals(units, ctx.getString(R.string.pref_units_metric_value))) {
            return ctx.getString(R.string.pref_units_metric_wind_display);
        } else {
            return ctx.getString(R.string.pref_units_imperial_wind_display);
        }
    }
}
