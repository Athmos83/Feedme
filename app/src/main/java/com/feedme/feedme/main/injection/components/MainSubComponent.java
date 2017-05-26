package com.feedme.feedme.main.injection.components;

import com.feedme.feedme.common.injection.components.BaseActivityComponent;
import com.feedme.feedme.common.injection.scopes.PerActivity;
import com.feedme.feedme.main.MainActivity;
import com.feedme.feedme.main.injection.modules.MainModule;

import dagger.Subcomponent;

/**
 * Created by Athmos on 26/05/2017.
 */

@PerActivity
@Subcomponent(modules = {MainModule.class})
public interface MainSubComponent extends BaseActivityComponent {

    void inject(MainActivity mainActivity);

}
