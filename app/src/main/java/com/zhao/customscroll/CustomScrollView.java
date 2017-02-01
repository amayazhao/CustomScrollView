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
     * Use the internal intercept method, override the dispatchTouchEvent and handle the move
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        //ACTION_DOWN event can't active the parentView
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            mLastY = (int) ev.getY();
            activeParentSrocll(false);
        }
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
        return super.dispatchTouchEvent(ev);
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
