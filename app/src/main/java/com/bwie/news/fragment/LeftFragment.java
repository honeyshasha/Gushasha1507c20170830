
package com.bwie.news.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.news.R;

/**
 * Created by 小傻瓜 on 2017/8/30.
 */

public class LeftFragment extends Fragment{
    private View mview;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(mview==null){
                mview=inflater.inflate(R.layout.left_item,container,false);
        }
        return mview;
    }
}
