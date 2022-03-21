package datamodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import retrofit.NewsApiRepository;

public class NewsViewModel extends ViewModel {
    private MutableLiveData<NewsResponse> mutableLiveData = new MutableLiveData<>();

    public NewsViewModel(NewsApiRepository newsApiRepository) {
        mutableLiveData = newsApiRepository.getNews();
    }

    public LiveData<NewsResponse> getHeadlineData() {
        return mutableLiveData;
    }
}
