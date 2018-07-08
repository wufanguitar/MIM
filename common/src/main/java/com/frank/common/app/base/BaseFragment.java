package com.frank.common.app.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @Author : Frank Wu
 * @Create : 2018-07-08 10:23
 * @Email ; wu.fanguitar@163.com
 * @Description :
 */

public abstract class BaseFragment extends Fragment {
    protected View mRoot;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        initArgs(getArguments());
    }

    /**
     * 初始化相关参数
     *
     * @param bundle 参数 Bundle
     */
    protected void initArgs(Bundle bundle) {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRoot == null) {
            mRoot = inflater.inflate(getContentLayoutId(), container, false);
            initWidget(mRoot);
        } else {
            if (mRoot.getParent() != null) {
                ((ViewGroup) mRoot.getParent()).removeView(mRoot);
            }
        }
        return mRoot;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
    }

    /**
     * 得到当起 Fragment 的布局资源文件 Id
     *
     * @return 布局资源文件 Id
     */
    @LayoutRes
    protected abstract int getContentLayoutId();

    /**
     * 初始化控件
     */
    protected void initWidget(View root) {
    }

    /**
     * 初始化数据
     */
    protected void initData() {
    }

    /**
     * 返回键触发时调用
     * @return
     * true: 表示已处理返回逻辑，Activity 不用调用 finish
     * false: 表示未处理返回逻辑，Activity 处理自己的逻辑
     */
    public boolean onBackPressed() {
        return false;
    }
}
