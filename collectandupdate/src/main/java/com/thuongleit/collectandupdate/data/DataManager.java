package com.thuongleit.collectandupdate.data;

import android.app.Application;

import com.thuongleit.App;
import com.thuongleit.collectandupdate.data.local.NewsModel;
import com.thuongleit.collectandupdate.data.remote.ParseService;
import com.thuongleit.collectandupdate.data.remote.model.Link;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

/**
 * Created by thuongle on 1/30/16.
 */
@Singleton
public class DataManager {

    @Inject
    ParseService mParseService;

    @Inject
    NewsModel mNewsModel;

    @Inject
    public DataManager(Application app) {
        ((App) app).getAppComponent().inject(this);
    }

    public Observable<List<Link>> collectNews(String catalog, String catalogCode, String page) {
        String level = "level-1";
        return mParseService
                .collectUrl(level, catalog, catalogCode, page)
                .map(response -> response.getCollectItems())
                .doOnNext(collectItems -> {
                    mNewsModel.insertOrUpdateItems(collectItems);
                });
    }
}
