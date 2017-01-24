package com.zhao.customscroll;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * Created by Amayazhao on 2017/1/21.
 */

public class CustomScrollView extends ScrollView {
    private ScrollView parent;
    private int mLastY;

    public CustomScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * use the internal intercept method
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        //CustomScrollView intercept the ACTION_DOWN event
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            mLastY = (int) ev.getY();
            activeParentSrocll(false);
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        //handler ACTION_MOVE
        if (ev.getAction() == MotionEvent.ACTION_MOVE) {
            int y = (int) ev.getY();
            //move down
            if (y > mLastY) {
                //is top?
                if (getScrollY() == 0) {
                    //active parent scroll
                    activeParentSrocll(true);
                }
            } else if (y < mLastY) {
                //is bomton?
                if (getScrollY() + getHeight() - getPaddingTop() - getPaddingBottom() == getChildAt(0).getHeight()) {
                    //active parent scroll
                    activeParentSrocll(true);
                }
            }
        }
        //next goto the super method
        return super.onTouchEvent(ev);
    }

    /**
     * if isActive=true: Actice the parent Intercept the event
     * if isActive=false: the parent isn't Intercept the event
     *
     * @param isAtive
     */
    public void activeParentSrocll(boolean isAtive) {
        parent.requestDisallowInterceptTouchEvent(!isAtive);
    }

    public void setParentView(ScrollView view) {
        parent = view;
    }
}
