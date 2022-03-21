package retrofit;

import datamodel.NewsResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi {

    @GET("top-headlines")
    Call<NewsResponse> getNewsList(@Query("country") String country, @Query("category") String category,
                                   @Query("apiKey") String apiKey);
}
