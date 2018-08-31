package com.hengkai.itc.utils;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Harry on 2018/8/30.
 */
public class TitleBehavior extends CoordinatorLayout.Behavior<TextView> {

    public TitleBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, TextView child, View dependency) {
        return dependency instanceof AppBarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, TextView child, View dependency) {
        float scaleY = Math.abs(dependency.getY()) / dependency.getHeight();
        child.setTranslationY(child.getHeight() * scaleY - child.getHeight());
//        child.setAlpha(scaleY);
        return true;
    }
}
