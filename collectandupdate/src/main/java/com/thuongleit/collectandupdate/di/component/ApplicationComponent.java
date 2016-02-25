package com.thuongleit.collectandupdate.di.component;

import android.app.Application;
import android.content.Context;

import com.thuongleit.collectandupdate.config.Config;
import com.thuongleit.collectandupdate.data.DataManager;
import com.thuongleit.collectandupdate.data.remote.ApiModule;
import com.thuongleit.collectandupdate.data.remote.ParseService;
import com.thuongleit.collectandupdate.di.ApplicationScope;
import com.thuongleit.collectandupdate.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by thuongle on 12/23/15.
 */
@Singleton
@Component(modules = {ApplicationModule.class, ApiModule.class})
public interface ApplicationComponent {

    Application application();

    @ApplicationScope
    Context context();

    ParseService parseService();

    DataManager dataManager();

    Config config();

    void inject(DataManager manager);
}
