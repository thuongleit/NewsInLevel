package com.thuongleit.collectandupdate.view.main;

import com.thuongleit.collectandupdate.data.DataManager;
import com.thuongleit.collectandupdate.view.base.BasePresenter;

import javax.inject.Inject;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by thuongle on 2/25/16.
 */
public class CollectPresenter extends BasePresenter<CollectView> {

    private final DataManager mDataManager;

    @Inject
    public CollectPresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void detachView() {
        super.detachView();
    }

    public void collect(String catalog, String catalogCode, String page) {
        checkViewAttached();

        mView.showProgress(true);
        mDataManager
                .collectNews(catalog, catalogCode, page)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(items -> {
                        },
                        e -> {
                            mView.showGeneralError(e.getMessage());
                            mView.showProgress(false);
                        },
                        () -> mView.doNext());
    }
}
