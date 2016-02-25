package com.thuongleit.collectandupdate.di.module;

import android.app.Application;
import android.content.Context;

import com.thuongleit.collectandupdate.di.ApplicationScope;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by thuongle on 12/23/15.
 */
@Module
public class ApplicationModule {

    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return this.application;
    }

    @Provides
    @ApplicationScope
    Context provideContext() {
        return application;
    }

}
