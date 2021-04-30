package com.example.android.sqliteweather.data;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;

@Dao
public interface BookmarkedRepoDao {
    @Insert
    void insert(FiveDayForecast forecast);

    @Delete
    void delete(FiveDayForecast forecast);
}
