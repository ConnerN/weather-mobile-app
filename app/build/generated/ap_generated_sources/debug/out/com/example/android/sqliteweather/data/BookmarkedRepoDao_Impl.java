package com.example.android.sqliteweather.data;

import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

@SuppressWarnings({"unchecked", "deprecation"})
public final class BookmarkedRepoDao_Impl implements BookmarkedRepoDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<FiveDayForecast> __insertionAdapterOfFiveDayForecast;

  private final EntityDeletionOrUpdateAdapter<FiveDayForecast> __deletionAdapterOfFiveDayForecast;

  public BookmarkedRepoDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfFiveDayForecast = new EntityInsertionAdapter<FiveDayForecast>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `bookmarkedRepos` (`forecastDataList`,`forecastCity`) VALUES (?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, FiveDayForecast value) {
      }
    };
    this.__deletionAdapterOfFiveDayForecast = new EntityDeletionOrUpdateAdapter<FiveDayForecast>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `bookmarkedRepos` WHERE `forecastCity` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, FiveDayForecast value) {
      }
    };
  }

  @Override
  public void insert(final FiveDayForecast forecast) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfFiveDayForecast.insert(forecast);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final FiveDayForecast forecast) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfFiveDayForecast.handle(forecast);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }
}
