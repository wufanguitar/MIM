package com.frank.common.app;

import android.view.View;

import com.frank.common.app.base.BaseFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @Author : Frank Wu
 * @Create : 2018-07-08 16:25
 * @Email ; wu.fanguitar@163.com
 * @Description :
 */

public abstract class ButterKnifeFragment extends BaseFragment {
    private Unbinder mUnbinder;

    @Override
    protected void initWidget(View root) {
        super.initWidget(root);
        mUnbinder = ButterKnife.bind(this, root);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
    }
}
