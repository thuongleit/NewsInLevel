package com.thuongleit.collectandupdate.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by thuongle on 1/29/16.
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityScope {
}
