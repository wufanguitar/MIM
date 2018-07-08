package com.frank.common.app;

import com.frank.common.app.base.BaseActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @Author : Frank Wu
 * @Create : 2018-07-08 16:23
 * @Email ; wu.fanguitar@163.com
 * @Description :
 */

public abstract class ButterKnifeActivity extends BaseActivity {
    private Unbinder mUnbinder;

    @Override
    protected void initWidget() {
        super.initWidget();
        mUnbinder = ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
    }
}
