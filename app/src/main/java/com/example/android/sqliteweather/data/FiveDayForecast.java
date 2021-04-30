package com.example.android.sqliteweather.data;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

@Entity(tableName = "bookmarkedRepos")
public class FiveDayForecast {
    @SerializedName("list")
    @NonNull
    private ArrayList<ForecastData> forecastDataList;

    @SerializedName("city")
    @PrimaryKey
    @NonNull
    private ForecastCity forecastCity;

    public FiveDayForecast() {
        this.forecastDataList = null;
        this.forecastCity = null;
    }

    public ArrayList<ForecastData> getForecastDataList() {
        return forecastDataList;
    }

    public ForecastCity getForecastCity() {
        return forecastCity;
    }
}
