package com.feedme.feedme.common.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;


import com.feedme.feedme.BuildConfig;

import net.hockeyapp.android.CrashManager;
import net.hockeyapp.android.CrashManagerListener;
import net.hockeyapp.android.UpdateManager;
import net.hockeyapp.android.utils.Util;

/**
 *
 * <b>Provides HockeyApp crash reporting setup
 * and distribution setup.</b>
 * <p>
 * Change {@link CustomHockeyAppCrashManagerListener#shouldAutoUploadCrashes()}
 * from return true to false if you want to show a dialog before send the crash to HockeyApp.
 * <p>
 * Extend this activity in order to get HockeyApp Crash Reports and Distribution setup
 */
public class HockeyAppBaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        checkHockeyAppForUpdates();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        checkHockeyAppForCrashes();
    }

    @Override
    protected void onPause() {
        super.onPause();
        uncheckHockeyAppManagers();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        uncheckHockeyAppManagers();
    }

    private void checkHockeyAppForCrashes() {
        CrashManager.register(this, Util.getAppIdentifier(this),
                new CustomHockeyAppCrashManagerListener());
    }


    private void checkHockeyAppForUpdates() {
    }

    private void uncheckHockeyAppManagers() {
    }

    private class CustomHockeyAppCrashManagerListener extends CrashManagerListener {
        @Override
        public boolean shouldAutoUploadCrashes() {
            // always send crash without prompt
            return true;
        }
    }
}