package com.wuxiao.responsibilitychaindemo;

import android.support.annotation.NonNull;
import android.view.View;

/**
 * Created by masai on 2017/1/9.
 */

//显示布局
public class VisibleViewStatus extends ViewStatus<View> {


    public VisibleViewStatus(IStatus mViewStatus, View view) {
        super(mViewStatus, view);
    }

    @Override
    protected boolean onStatusImpl(@NonNull View obj) {
        if (obj.getVisibility() == View.GONE) {
            obj.setVisibility(View.VISIBLE);
            return true;
        }
        return true;
    }
}