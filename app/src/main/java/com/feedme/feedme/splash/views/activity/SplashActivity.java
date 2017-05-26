package com.feedme.feedme.splash.views.activity;

import android.app.Activity;
import android.os.Bundle;

import com.feedme.feedme.FeedmeBaseApplication;
import com.feedme.feedme.R;
import com.feedme.feedme.splash.views.presenter.SplashPresenter;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Athmos on 26/05/2017.
 */

public class SplashActivity extends Activity implements SplashPresenter.View {

    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        unbinder = ButterKnife.bind(this);

        ((FeedmeBaseApplication) getApplicationContext())
                .createSplashComponent(this).inject(this);
        }

    @Override
    public void onLaunchApp() {

    }
}
