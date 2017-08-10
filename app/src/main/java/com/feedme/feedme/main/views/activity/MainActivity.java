package com.feedme.feedme.main.views.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.feedme.feedme.FeedmeBaseApplication;
import com.feedme.feedme.R;
import com.feedme.feedme.common.domain.model.BaseView;
import com.feedme.feedme.feed.domain.model.Feed;
import com.feedme.feedme.main.injection.modules.MainModule;
import com.feedme.feedme.main.views.adapter.FeedAdapter;
import com.feedme.feedme.main.views.presenter.MainPresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity
        extends AppCompatActivity
        implements BaseView, MainPresenter.View {

    @Inject
    MainPresenter mainPresenter;

    @BindView(R.id.Feed_Recycler)
    protected RecyclerView feedRecycler;
    @BindView(R.id.Main_App_Bar)
    protected LinearLayout appBar;

    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        unbinder = ButterKnife.bind(this);

        ((FeedmeBaseApplication) getApplicationContext()).getApplicationComponent()
                .getMainComponent(new MainModule()).inject(this);
        mainPresenter.attachView(this);
        onInit();
    }

    @Override
    public void onInit() {
        mainPresenter.onInit();
    }

    @Override
    public void onGetFeed(List<Feed> feeds) {
        if (feeds != null) {
            FeedAdapter feedAdapter = new FeedAdapter(this, feeds);
            feedRecycler.setAdapter(feedAdapter);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);

            feedRecycler.setLayoutManager(gridLayoutManager);
        }
    }
}
