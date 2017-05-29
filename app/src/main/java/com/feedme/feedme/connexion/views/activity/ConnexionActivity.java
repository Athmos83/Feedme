package com.feedme.feedme.connexion.views.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.feedme.feedme.FeedmeBaseApplication;
import com.feedme.feedme.R;
import com.feedme.feedme.common.view.EditTextStyled;
import com.feedme.feedme.connexion.views.presenter.ConnexionPresenter;
import com.feedme.feedme.main.MainActivity;
import com.feedme.feedme.user.User;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Athmos on 26/05/2017.
 */

public class ConnexionActivity extends Activity implements ConnexionPresenter.View {

    private Unbinder unbinder;
    @BindView(R.id.email)
    public EditTextStyled email;

    @Inject
    ConnexionPresenter connexionPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_connect);

        unbinder = ButterKnife.bind(this);

        ((FeedmeBaseApplication) getApplicationContext())
                .createConnexionComponent(this).inject(this);
    }

    @Override
    public void onUserAdded() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    //  binded buttons

    @OnClick(R.id.button_send)
    public void onClickSend() {
        User user = new User();

        user.setIsConnected(true);
        user.setEmail(email.toString());
        user.setUserName("NoName");
        user.setTmpUser(false);
        connexionPresenter.addUser(user);
    }

    @OnClick(R.id.button_skip)
    public void onClickSkip() {
        User user = new User();

        user.setIsConnected(true);
        user.setEmail("NoEmail");
        user.setUserName("NoName");
        user.setTmpUser(true);
        connexionPresenter.addUser(user);
    }


}
