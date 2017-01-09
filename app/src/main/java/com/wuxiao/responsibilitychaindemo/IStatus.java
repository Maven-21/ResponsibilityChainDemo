package com.wuxiao.responsibilitychaindemo;

import android.support.annotation.NonNull;

/**
 * Created by wuxiao on 2017/1/9.
 *
 */
public interface IStatus<T> {
    public boolean onStatus(@NonNull T status);
}
