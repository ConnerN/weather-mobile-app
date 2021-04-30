package com.example.android.sqliteweather;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;

import com.example.android.sqliteweather.data.BookmarkedReposRepository;
import com.example.android.sqliteweather.data.FiveDayForecast;

public class BookmarkedRepoViewModel extends AndroidViewModel {
    private BookmarkedReposRepository repository;

    public BookmarkedRepoViewModel(Application application) {
        super(application);
        this.repository = new BookmarkedReposRepository(application);
    }

    public void insertWeatherRepo(FiveDayForecast fiveDayForecast) {
        this.repository.insertBookmarkRepo(fiveDayForecast);
    }

    public void deleteWeatherRepo(FiveDayForecast fiveDayForecast) {
        this.repository.deleteBookmarkRepo(fiveDayForecast);
    }
}
