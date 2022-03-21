package datamodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class NewsDetailViewModelFactory implements ViewModelProvider.Factory {

    private Articles mArticles;

    public NewsDetailViewModelFactory(Articles articles) {
        mArticles = articles;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new NewsDetailViewModel(mArticles);
    }
}
