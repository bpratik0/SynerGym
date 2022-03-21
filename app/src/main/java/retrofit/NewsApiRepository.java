package retrofit;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import datamodel.NewsResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsApiRepository {

    private static final String TAG = NewsApiRepository.class.getSimpleName();
    private static final String COUNTRY = "us";
    private static final String CATEGORY = "business";
    private static final String KEY = "aebdf900838d47958349af9f1046eabd";

    public MutableLiveData<NewsResponse> getNews() {
        MutableLiveData<NewsResponse> newsData = new MutableLiveData<>();
        RetrofitBuilder.getApiService().getNewsList(COUNTRY, CATEGORY, KEY).enqueue(new Callback<NewsResponse>() {
            @Override
            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
                Log.d(NewsApiRepository.class.getSimpleName(), "onResponse: " + response.body().getArticles().get(0).getTitle().toString());
                newsData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<NewsResponse> call, Throwable t) {
                Log.d(TAG, t.getMessage());
            }
        });
        return newsData;
    }
}
