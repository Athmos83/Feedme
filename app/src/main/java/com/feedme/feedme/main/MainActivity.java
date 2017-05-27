package com.feedme.feedme.main;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.feedme.feedme.FeedmeBaseApplication;
import com.feedme.feedme.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {

    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        unbinder = ButterKnife.bind(this);

        //((FeedmeBaseApplication) getApplicationContext())
        //        .createMainComponent(this).inject(this);
    }
}
