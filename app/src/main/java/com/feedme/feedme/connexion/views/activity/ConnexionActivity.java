package com.feedme.feedme.connexion.views.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.feedme.feedme.FeedmeBaseApplication;
import com.feedme.feedme.R;
import com.feedme.feedme.connexion.views.presenter.ConnexionPresenter;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Athmos on 26/05/2017.
 */

public class ConnexionActivity extends Activity implements ConnexionPresenter.View {

    private Unbinder unbinder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_connect);

        unbinder = ButterKnife.bind(this);

        ((FeedmeBaseApplication)getApplicationContext())
                .createConnexionComponent(this).inject(this);
        
        initViews();
    }

    private void initViews() {
    }

    @Override
    public Context getContext() {
        return this.getContext();
    }

    @Override
    public void onUserFound() {

    }

    @Override
    public void onUserNotFound() {

    }
}
