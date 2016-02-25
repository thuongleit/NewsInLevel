package com.thuongleit.collectandupdate.di.component;

import android.app.Activity;
import android.content.Context;

import com.thuongleit.collectandupdate.di.ActivityScope;
import com.thuongleit.collectandupdate.di.PerActivity;
import com.thuongleit.collectandupdate.di.module.ActivityModule;
import com.thuongleit.collectandupdate.view.main.MainActivity;

import dagger.Component;

/**
 * Created by thuongle on 12/23/15.
 */
@PerActivity
@Component(modules = ActivityModule.class, dependencies = ApplicationComponent.class)
public interface ActivityComponent {

    @ActivityScope
    Context context();

    Activity activity();

    void inject(MainActivity activity);
}
