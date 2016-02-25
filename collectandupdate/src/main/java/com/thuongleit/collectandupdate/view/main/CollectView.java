package com.thuongleit.collectandupdate.view.main;

import com.thuongleit.collectandupdate.view.base.ErrorableView;

/**
 * Created by thuongle on 2/25/16.
 */
public interface CollectView extends ErrorableView {

    void showProgress(boolean show);

    void updateCollectLink(String url);

    void doNext();
}
