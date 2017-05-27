package com.feedme.feedme.splash.views.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.feedme.feedme.FeedmeBaseApplication;
import com.feedme.feedme.R;
import com.feedme.feedme.common.view.HockeyAppBaseActivity;
import com.feedme.feedme.splash.views.presenter.SplashPresenter;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Athmos on 26/05/2017.
 */

public class SplashActivity extends AppCompatActivity implements SplashPresenter.View {

    @Inject
    SplashPresenter slashPresenter;

    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        unbinder = ButterKnife.bind(this);

        ((FeedmeBaseApplication) getApplicationContext())
               .createSplashComponent(this).inject(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void onLaunchApp() {

    }
}
