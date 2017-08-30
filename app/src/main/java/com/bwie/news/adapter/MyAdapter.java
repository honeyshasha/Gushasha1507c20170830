
package com.bwie.news.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.news.R;
import com.bwie.news.bean.News;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by 小傻瓜 on 2017/8/30.
 */

public class MyAdapter extends BaseAdapter{
    private Context context;
    private List<News.ResultBean.DataBean> list;
    public static final int a=0;
    public static final int b=1;
    public MyAdapter(Context context, List<News.ResultBean.DataBean> list){
        this.context=context;
        this.list=list;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemViewType(int position) {
        if (position%2==0){
            return a;
        }else{
            return b;
        }
    }

    @Override
    public int getViewTypeCount() {
        return  2;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolderOne holderOne=null;
        ViewHolderTwo holderTwo=null;
        int type=getItemViewType(i);
        if(view==null){
            switch (type){
                case a:
                    holderOne=new ViewHolderOne();
                    view=View.inflate(context, R.layout.itemone,null);
                    holderOne.title_one=view.findViewById(R.id.title_one);
                    holderOne.date_one=view.findViewById(R.id.date_one);
                    holderOne.name_one=view.findViewById(R.id.name_one);
                    holderOne.img_one=view.findViewById(R.id.img_one);

                    holderOne.title_one.setText(list.get(i).getTitle());
                    holderOne.name_one.setText(list.get(i).getAuthor_name());
                    holderOne.date_one.setText(list.get(i).getDate());
                    ImageLoader.getInstance().displayImage(list.get(i).getThumbnail_pic_s(),holderOne.img_one);
                    view.setTag(holderOne);
                    break;
                case b:
                    holderTwo=new ViewHolderTwo();
                    view=View.inflate(context, R.layout.itemtwo,null);
                    holderTwo.title_two=view.findViewById(R.id.title_two);
                    holderTwo.date_two=view.findViewById(R.id.date_two);
                    holderTwo.name_two=view.findViewById(R.id.name_two);
                    holderTwo.img_two=view.findViewById(R.id.img_two);

                    holderTwo.title_two.setText(list.get(i).getTitle());
                    holderTwo.name_two.setText(list.get(i).getAuthor_name());
                    holderTwo.date_two.setText(list.get(i).getDate());
                    ImageLoader.getInstance().displayImage(list.get(i).getThumbnail_pic_s(),holderTwo.img_two);
                    view.setTag(holderTwo);
                    break;
            }
        }else{
            switch (type){
                case a:
                    holderOne= (ViewHolderOne) view.getTag();
                    holderOne.title_one.setText(list.get(i).getTitle());
                    holderOne.name_one.setText(list.get(i).getAuthor_name());
                    holderOne.date_one.setText(list.get(i).getDate());
                    ImageLoader.getInstance().displayImage(list.get(i).getThumbnail_pic_s(),holderOne.img_one);
                    break;
                case b:
                    holderTwo= (ViewHolderTwo) view.getTag();
                    holderTwo.title_two.setText(list.get(i).getTitle());
                    holderTwo.name_two.setText(list.get(i).getAuthor_name());
                    holderTwo.date_two.setText(list.get(i).getDate());
                    ImageLoader.getInstance().displayImage(list.get(i).getThumbnail_pic_s(),holderTwo.img_two);
                    break;
            }
        }
        return view;
    }
    class ViewHolderOne{
        public TextView title_one,name_one,date_one;
        public ImageView img_one;
    }class ViewHolderTwo{
        public TextView title_two,name_two,date_two;
        public ImageView img_two;
    }
}
