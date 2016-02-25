package com.thuongleit.collectandupdate.view.base;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.thuongleit.App;
import com.thuongleit.collectandupdate.di.component.ActivityComponent;
import com.thuongleit.collectandupdate.di.component.DaggerActivityComponent;
import com.thuongleit.collectandupdate.di.module.ActivityModule;

/**
 * Created by thuongle on 12/23/15.
 */
public abstract class BaseActivity extends AppCompatActivity {
    private ActivityComponent mComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mComponent = DaggerActivityComponent
                .builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(getApp().getAppComponent()).build();
    }

    @TargetApi(Build.VERSION_CODES.M)
    public void requestPermissionsSafely(String[] permissions, int requestCode) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, requestCode);
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    public boolean hasPermission(String permission) {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M ||
                checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED;
    }

    public ActivityComponent getComponent() {
        return mComponent;
    }

    public App getApp() {
        return (App) getApplication();
    }

    public void reloadActivity() {
        overridePendingTransition(0, 0);
        Intent intent = getIntent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        finish();
        overridePendingTransition(0, 0);
        startActivity(intent);
    }
}
