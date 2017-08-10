package com.feedme.feedme.connexion.views.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.feedme.feedme.FeedmeBaseApplication;
import com.feedme.feedme.R;
import com.feedme.feedme.common.domain.model.BaseView;
import com.feedme.feedme.common.view.EditTextStyled;
import com.feedme.feedme.connexion.injection.modules.ConnexionModule;
import com.feedme.feedme.connexion.views.presenter.ConnexionPresenter;
import com.feedme.feedme.main.views.activity.MainActivity;
import com.feedme.feedme.user.domain.model.User;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class ConnexionActivity extends Activity implements BaseView, ConnexionPresenter.View {

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

        ((FeedmeBaseApplication) getApplicationContext()).getApplicationComponent()
                .getConnexionComponent(new ConnexionModule()).inject(this);
        connexionPresenter.attachView(this);
    }

    // connexionPresenter.View methods

    @Override
    public void onUserAdded() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    // BaseView methods

    @Override
    public void onInit() {

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
