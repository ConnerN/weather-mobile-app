package com.example.android.sqliteweather.data;

import android.app.Application;

public class BookmarkedReposRepository {
    private BookmarkedRepoDao dao;

    public BookmarkedReposRepository(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        this.dao = db.bookmarkedRepoDao();
    }

    public void insertBookmarkRepo(FiveDayForecast forecast) {
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                dao.insert(forecast);
            }
        });
    }

    public void deleteBookmarkRepo(FiveDayForecast forecast) {
        AppDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                dao.delete(forecast);
            }
        });
    }
}
