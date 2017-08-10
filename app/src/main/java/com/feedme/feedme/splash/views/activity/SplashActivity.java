package com.feedme.feedme.splash.views.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.feedme.feedme.FeedmeBaseApplication;
import com.feedme.feedme.R;
import com.feedme.feedme.common.domain.model.BaseView;
import com.feedme.feedme.connexion.views.activity.ConnexionActivity;
import com.feedme.feedme.main.views.activity.MainActivity;
import com.feedme.feedme.splash.injection.modules.SplashModule;
import com.feedme.feedme.splash.views.presenter.SplashPresenter;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public class SplashActivity extends AppCompatActivity implements BaseView, SplashPresenter.View {

    @Inject
    SplashPresenter splashPresenter;

    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        unbinder = ButterKnife.bind(this);

        ((FeedmeBaseApplication) getApplicationContext()).getApplicationComponent()
                .getSplashComponent(new SplashModule()).inject(this);
        splashPresenter.attachView(this);
        onInit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    // SplashPresenter.View methods

    @Override
    public void navigateToConnexion() {
        Intent intent = new Intent(this, ConnexionActivity.class);
        startActivity(intent);
    }

    @Override
    public void navigateToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    // BaseView methods

    @Override
    public void onInit() {
        splashPresenter.init();
    }

    @Override
    public void onBackPressed() {
        onDestroy();
    }
}
