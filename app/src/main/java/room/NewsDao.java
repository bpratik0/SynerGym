package room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import datamodel.Articles;
import io.reactivex.rxjava3.core.Maybe;

@Dao
public interface NewsDao {
    @Insert
    void insertList(List<Articles> articlesList);

    @Query("SELECT * FROM Articles")
    Maybe<List<Articles>> getAllCourse();

    @Query("DELETE FROM Articles")
    void deleteAll();
}
