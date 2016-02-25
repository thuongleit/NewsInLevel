package com.thuongleit;

import android.app.Application;

import com.raizlabs.android.dbflow.config.FlowManager;
import com.thuongleit.collectandupdate.BuildConfig;
import com.thuongleit.collectandupdate.di.component.ApplicationComponent;
import com.thuongleit.collectandupdate.di.component.DaggerApplicationComponent;
import com.thuongleit.collectandupdate.di.module.ApplicationModule;

import timber.log.Timber;

/**
 * Created by thuongle on 11/24/15.
 */
public class App extends Application {

    private ApplicationComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        FlowManager.init(this);

//        Parse.enableLocalDatastore(this);
//        Parse.initialize(this);

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

        mAppComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getAppComponent() {
        return mAppComponent;
    }

}
