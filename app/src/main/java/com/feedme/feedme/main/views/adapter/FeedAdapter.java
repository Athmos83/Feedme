package com.feedme.feedme.main.views.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.feedme.feedme.R;
import com.feedme.feedme.feed.domain.model.Feed;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FeedAdapter
        extends RecyclerView.Adapter<FeedAdapter.FeedViewHolder> {

    private List<Feed> feeds = new ArrayList<>();
    private Context context;

    public FeedAdapter(Context context, List<Feed> feeds) {
        this.feeds = feeds;
        this.context = context;
    }

    @Override
    public FeedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_feed, parent, false);
        return new FeedViewHolder(v);    }

    @Override
    public void onBindViewHolder(FeedViewHolder holder, int position) {
        Feed feed = feeds.get(position);
        if (getItemCount() == 0) {
            holder.rootView.setVisibility(View.GONE);
        } else {
            holder.feedTitle.setText(feed.getTitle());
            holder.feedDescription.setText(feed.getDescription());
        }
    }

    @Override
    public int getItemCount() {
        return feeds.size();
    }

    public class FeedViewHolder extends RecyclerView.ViewHolder {

         @BindView(R.id.Feed_Title)
         protected TextView feedTitle;
         @BindView(R.id.Feed_Description)
         protected TextView feedDescription;
        @BindView(R.id.Root_Layout)
        protected View rootLayout;

        protected View rootView;

        public FeedViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
            this.rootView = itemView;
        }
    }
}
