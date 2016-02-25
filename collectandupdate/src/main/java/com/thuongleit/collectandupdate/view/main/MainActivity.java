package com.thuongleit.collectandupdate.view.main;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.pnikosis.materialishprogress.ProgressWheel;
import com.thuongleit.collectandupdate.R;
import com.thuongleit.collectandupdate.config.Constant;
import com.thuongleit.collectandupdate.view.base.ToolbarActivity;

import javax.inject.Inject;

import butterknife.Bind;


public class MainActivity extends ToolbarActivity implements CollectView {

    @Bind(R.id.progress_wheel)
    ProgressWheel mProgressWheel;
    @Bind(R.id.text_collect_link)
    TextView mTextCollectLink;

    @Inject
    CollectPresenter mCollectPresenter;

    private int mCurrentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getComponent().inject(this);
        mCollectPresenter.attachView(this);

        doCollect();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mCollectPresenter.detachView();
    }

    @Override
    public void showNetworkError() {

    }

    @Override
    public void showGeneralError(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress(boolean show) {

    }

    @Override
    public void updateCollectLink(String url) {
    }

    @Override
    public void doNext() {
        mCurrentIndex++;
        doCollect();
    }

    private void doCollect() {
        if (mCurrentIndex == Constant.CATALOGS.size() - 1) {
            Toast.makeText(MainActivity.this, "Finished", Toast.LENGTH_SHORT).show();
            return;
        } else {
            String catalog = Constant.CATALOGS.get(mCurrentIndex);
            String catalogCode = Constant.CATALOG_CODE.get(mCurrentIndex);
            mCollectPresenter.collect(catalog, catalogCode, 10 + "");
        }
    }
}
