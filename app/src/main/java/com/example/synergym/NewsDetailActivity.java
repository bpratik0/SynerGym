package com.example.synergym;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.synergym.databinding.NewsDetailLayoutBinding;

import datamodel.Articles;
import datamodel.NewsDetailViewModel;
import datamodel.NewsDetailViewModelFactory;

public class NewsDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        Articles articles = (Articles) getIntent().getSerializableExtra("model");
        NewsDetailLayoutBinding newsDetailLayoutBinding =
                DataBindingUtil.setContentView(this, R.layout.news_detail_layout);
        NewsDetailViewModel detailViewModel =
                new ViewModelProvider(this, new NewsDetailViewModelFactory(articles)).get(NewsDetailViewModel.class);
        newsDetailLayoutBinding.setViewmodel(detailViewModel);

        detailViewModel.back.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                onBackPressed();
            }
        });


    }
}
