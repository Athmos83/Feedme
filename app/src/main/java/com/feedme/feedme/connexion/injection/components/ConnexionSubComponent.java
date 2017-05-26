package com.feedme.feedme.connexion.injection.components;

import com.feedme.feedme.common.injection.components.BaseActivityComponent;
import com.feedme.feedme.common.injection.scopes.PerActivity;
import com.feedme.feedme.connexion.injection.modules.ConnexionModule;
import com.feedme.feedme.connexion.views.activity.ConnexionActivity;

import dagger.Subcomponent;

/**
 * Created by Athmos on 26/05/2017.
 */

@PerActivity
@Subcomponent(modules = {ConnexionModule.class})
public interface ConnexionSubComponent extends BaseActivityComponent {

    void inject(ConnexionActivity connexionActivity);
}
