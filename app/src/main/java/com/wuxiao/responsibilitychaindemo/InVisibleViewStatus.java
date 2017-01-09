package com.wuxiao.responsibilitychaindemo;


import android.support.annotation.NonNull;
import android.view.View;

//隐藏布局
public class InVisibleViewStatus extends ViewStatus<View> {

    public InVisibleViewStatus(IStatus mViewStatus, View view) {
        super(mViewStatus, view);
    }

    @Override
    public boolean onStatusImpl(@NonNull View status) {
        View tempView = status;
        if (tempView.getVisibility() == View.VISIBLE) {
            tempView.setVisibility(View.INVISIBLE);
            return true;
        }
        return false;
    }
}