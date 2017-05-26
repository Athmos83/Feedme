package com.feedme.feedme.main.injection.modules;

import com.feedme.feedme.main.MainActivity;

import dagger.Module;

/**
 * Created by Athmos on 26/05/2017.
 */

@Module
public class MainModule {

    private MainActivity mainActivity;

    public MainModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        }

        }