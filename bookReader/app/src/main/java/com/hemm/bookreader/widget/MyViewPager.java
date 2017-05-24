package com.hemm.bookreader.widget;

import android.content.Context;
import android.graphics.Point;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.hemm.bookreader.utils.ScreenUtils;


/**
 * 描述：
 * 作者： poly
 * 创建时间：2017/5/21
 */

public class MyViewPager extends ViewPager {
    private int flag = 0;
    private OnTurnListener mOnTurnListener;
    Point point = new Point();
    public MyViewPager(Context context) {
        super(context);
    }

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                point.x = (int)ev.getX();
                point.y = (int)ev.getY();
                flag = 0;
                break;
            case MotionEvent.ACTION_MOVE:
                flag = 1;
                break;
            case MotionEvent.ACTION_UP:
                if(flag == 0 || Math.abs(ev.getX()-point.x) < 50) {
                    if(ev.getX()< ScreenUtils.getScreenWidth()/3){
                        if(getCurrentItem()==0){
                            if(mOnTurnListener!=null)
                                mOnTurnListener.prePager();
                        }else{
                            setCurrentItem(getCurrentItem()-1);
                        }
                    }else if(ev.getX()>ScreenUtils.getScreenWidth()*2/3){
                        if(getCurrentItem() == getAdapter().getCount()-1){
                            if(mOnTurnListener!=null)
                                mOnTurnListener.nextPager();
                        }else{
                            setCurrentItem(getCurrentItem()+1);
                        }
                    }

                }
                break;
        }
        return super.onTouchEvent(ev);
    }

    public void setOnTurnListener(OnTurnListener listener){
        mOnTurnListener = listener;
    }
    public interface OnTurnListener{
        void nextPager();
        void prePager();
    }
}
