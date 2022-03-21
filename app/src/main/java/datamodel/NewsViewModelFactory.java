package datamodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import retrofit.NewsApiRepository;

public class NewsViewModelFactory implements ViewModelProvider.Factory {

    private NewsApiRepository mNewsApiRepository;
    private Application mApplication;

    public NewsViewModelFactory(NewsApiRepository newsApiRepository) {
        this.mNewsApiRepository = newsApiRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new NewsViewModel(mNewsApiRepository);
    }
}
