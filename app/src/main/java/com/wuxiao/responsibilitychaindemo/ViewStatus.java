package com.wuxiao.responsibilitychaindemo;

import android.support.annotation.NonNull;

/**
 * 责任链抽象类，其中包含下一个布局对象
 */
public abstract class ViewStatus<T> implements IStatus<T> {
    protected IStatus mViewStatus;
    protected T view;

    /**
     * @param mViewStatus 下一个布局的接受者
     * @param view   下一个布局
     */
    public ViewStatus(IStatus mViewStatus, T view) {
        this.mViewStatus = mViewStatus;
        this.view = view;
    }

    @Override
    public boolean onStatus(@NonNull T status) {
        boolean isStatus = onStatusImpl(status);
        if (!isStatus && mViewStatus != null)
            return mViewStatus.onStatus(view);
        return isStatus;
    }

    /**
     * @param status
     * @return 代表布局状态是否显示
     */
    protected abstract boolean onStatusImpl(@NonNull T status);
}