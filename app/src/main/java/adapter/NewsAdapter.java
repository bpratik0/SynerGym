package adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.library.baseAdapters.BR;
import androidx.recyclerview.widget.RecyclerView;

import com.example.synergym.NewsDetailActivity;
import com.example.synergym.R;
import com.example.synergym.databinding.HeadingsItemLayoutBinding;

import java.util.List;

import datamodel.Articles;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.HeadLineViewHolder> implements
        CustomClickListener {

    private Context mContext;
    private List<Articles> mArticlesList;

    public NewsAdapter(Context context, List<Articles> articlesList) {
        this.mContext = context;
        this.mArticlesList = articlesList;
    }

    @NonNull
    @Override
    public HeadLineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        HeadingsItemLayoutBinding layoutBinding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.headings_item_layout,
                        parent, false);
        return new HeadLineViewHolder(layoutBinding);
    }

    @Override
    public void onBindViewHolder(HeadLineViewHolder viewHolder, int position) {
        viewHolder.bind(mArticlesList.get(position));
        viewHolder.headingsItemLayoutBinding.setItemClickListener(this);
    }

    @Override
    public int getItemCount() {
        return mArticlesList.size();
    }

    @Override
    public void cardClicked(Articles articles) {
        Intent intent = new Intent(mContext, NewsDetailActivity.class);
        intent.putExtra("model", articles);
        mContext.startActivity(intent);
    }


    public static class HeadLineViewHolder extends RecyclerView.ViewHolder {
        public HeadingsItemLayoutBinding headingsItemLayoutBinding;

        public HeadLineViewHolder(HeadingsItemLayoutBinding itemLayoutBinding) {
            super(itemLayoutBinding.getRoot());
            headingsItemLayoutBinding = itemLayoutBinding;
        }

        public void bind(Object obj) {
            headingsItemLayoutBinding.setVariable(BR.model, obj);
            headingsItemLayoutBinding.executePendingBindings();
        }
    }

}
