package com.example.synergym;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.synergym.databinding.ActivityMainBinding;

import javax.inject.Inject;

import adapter.NewsAdapter;
import dagger.AppModule;
import dagger.DaggerNewsComponent;
import dagger.RoomModule;
import datamodel.NewsResponse;
import datamodel.NewsViewModel;
import datamodel.NewsViewModelFactory;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit.NewsApiRepository;
import room.NewsDatabase;
import room.Util;

public class NewsActivity extends AppCompatActivity {

    NewsViewModel headlinesViewModel;
    ActivityMainBinding activityMainBinding;

    @Inject
    NewsDatabase mNewsDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        DaggerNewsComponent.builder()
                .appModule(new AppModule(getApplication()))
                .roomModule(new RoomModule(getApplication()))
                .build()
                .inject(this);


        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        headlinesViewModel = new ViewModelProvider(this,
                new NewsViewModelFactory(new NewsApiRepository())).get(NewsViewModel.class);
        activityMainBinding.recyclerView.setLayoutManager(new LinearLayoutManager(NewsActivity.this));

        if (!Util.isConnected(getApplication())) {
            headlinesViewModel.getHeadlineData().observe(this, new Observer<NewsResponse>() {
                @Override
                public void onChanged(NewsResponse newsResponse) {
                    NewsAdapter newsAdapter = new NewsAdapter(NewsActivity.this, newsResponse.getArticles());
                    activityMainBinding.recyclerView.setAdapter(newsAdapter);
                    new Thread(() -> {
                        mNewsDatabase.newsDao().deleteAll();
                        mNewsDatabase.newsDao().insertList(newsResponse.getArticles());
                    }).start();

                }
            });
        } else {
            mNewsDatabase.newsDao().getAllCourse()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(articles -> {
                        NewsAdapter newsAdapter = new NewsAdapter(NewsActivity.this, articles);
                        activityMainBinding.recyclerView.setAdapter(newsAdapter);
                    });
        }

    }
}