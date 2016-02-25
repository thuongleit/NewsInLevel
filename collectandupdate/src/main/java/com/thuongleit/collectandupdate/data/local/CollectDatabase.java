package com.thuongleit.collectandupdate.data.local;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by thuongle on 1/30/16.
 */
@Database(name = CollectDatabase.DATABASE_NAME, version = CollectDatabase.DATABASE_VERSION)
public class CollectDatabase {

    public static final String DATABASE_NAME = "collectdb";

    public static final int DATABASE_VERSION = 1;
}
