package dagger;


import android.app.Application;

import androidx.room.Room;

import javax.inject.Singleton;

import room.NewsDatabase;

@Module
public class RoomModule {
    private NewsDatabase newsDatabase;

    public RoomModule(Application mApplication) {
        newsDatabase = Room.databaseBuilder(mApplication, NewsDatabase.class, "news-db").build();
    }

    @Singleton
    @Provides
    NewsDatabase providesRoomDatabase() {
        return newsDatabase;
    }
}
