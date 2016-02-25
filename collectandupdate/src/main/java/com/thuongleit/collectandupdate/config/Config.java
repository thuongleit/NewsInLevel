package com.thuongleit.collectandupdate.config;

import android.content.Context;
import android.content.SharedPreferences;

import com.thuongleit.collectandupdate.di.ApplicationScope;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by thuongle on 1/30/16.
 */
@Singleton
public class Config {

    private static final String PREF_FILE_NAME = "config_file";

    private final SharedPreferences mSharedPreferences;

    @Inject
    public Config(@ApplicationScope Context context) {
        mSharedPreferences = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
    }

}
