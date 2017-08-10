package com.feedme.feedme.main.injection.components;

import com.feedme.feedme.common.injection.components.BaseActivityComponent;
import com.feedme.feedme.common.injection.scopes.PerActivity;
import com.feedme.feedme.main.views.activity.MainActivity;
import com.feedme.feedme.main.injection.modules.MainModule;

import dagger.Subcomponent;

@PerActivity
@Subcomponent(modules = {MainModule.class})
public interface MainSubComponent {

    void inject(MainActivity mainActivity);

}
