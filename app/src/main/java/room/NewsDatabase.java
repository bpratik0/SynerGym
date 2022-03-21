package room;


import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import converter.DataConverter;
import datamodel.Articles;

@androidx.room.Database(entities = Articles.class, version = 1)
@TypeConverters(DataConverter.class)
public abstract class NewsDatabase extends RoomDatabase {
    public abstract NewsDao newsDao();

}
