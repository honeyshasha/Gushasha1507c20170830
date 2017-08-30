package com.bwie.news.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.bwie.news.R;

/**
 * Created by 小傻瓜 on 2017/8/30.
 */

public class HorizontalTabhost extends LinearLayout {
    private int textSize;
    private LinearLayout line;
    private ViewPager viewpager;

    public HorizontalTabhost(Context context) {
        super(context);
        init(context,null);
    }
    public HorizontalTabhost(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public HorizontalTabhost(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }
    private void init(Context context,AttributeSet attrs) {
        TypedArray type=context.obtainStyledAttributes(attrs, R.styleable.HorizontalTabhost);
        //横滑的字体大小
        textSize=type.getDimensionPixelSize(R.styleable.HorizontalTabhost_textSize,23);
        type.recycle();
        //引入子view
        View view= LayoutInflater.from(context).inflate(R.layout.header_item,this,true);
        line=view.findViewById(R.id.line);
        viewpager=view.findViewById(R.id.viewpager);
    }
}
