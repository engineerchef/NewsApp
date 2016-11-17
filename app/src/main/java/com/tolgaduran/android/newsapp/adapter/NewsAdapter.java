package com.tolgaduran.android.newsapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;
import com.tolgaduran.android.newsapp.R;
import com.tolgaduran.android.newsapp.model.NewsArticle;
import com.tolgaduran.android.newsapp.view.NewsViewHolder;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder> {
    private List<NewsArticle> mNewsArticles;
    private Context mContext;

    public NewsAdapter(Context context, List<NewsArticle> newsArticles) {
        this.mNewsArticles = newsArticles;
        this.mContext = context;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_card_list_item, null);
        NewsViewHolder rcv = new NewsViewHolder(layoutView, mContext);
        return rcv;
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        // Bind text with list item
        NewsArticle currentArticle = mNewsArticles.get(position);
        String articleTitle = currentArticle.getTitle();
        String articleSectionName = currentArticle.getSectionName();
        String articleThumbnail = currentArticle.getThumbnail();
        holder.articleTitle.setText(articleTitle);
        holder.articleSectionName.setText(articleSectionName);
        if (!articleThumbnail.equals("")) {
            Picasso.with(mContext).load(articleThumbnail).into(holder.articleThumbnail);
        } else {
            holder.articleThumbnail.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return this.mNewsArticles.size();
    }
}
