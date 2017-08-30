
package com.bwie.news;

import android.os.Bundle;
import android.util.Log;

import com.bwie.news.adapter.MyAdapter;
import com.bwie.news.api.HttpApi;
import com.bwie.news.bean.News;
import com.bwie.news.fragment.LeftFragment;
import com.bwie.news.fragment.RigthFragment;
import com.google.gson.Gson;
import com.kson.slidingmenu.SlidingMenu;
import com.kson.slidingmenu.app.SlidingFragmentActivity;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

import view.xlistview.XListView;

@ContentView(R.layout.activity_main)
public class MainActivity extends SlidingFragmentActivity {
    @ViewInject(R.id.xlistview)
    XListView xlistview;
    private List<News.ResultBean.DataBean> list;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        RequestParams params=new RequestParams(HttpApi.POST_URL);
        params.addQueryStringParameter("key",HttpApi.KEY);
        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                //解析
                Gson gson=new Gson();
                News news = gson.fromJson(result, News.class);
                list = news.getResult().getData();
                for(News.ResultBean.DataBean da:list){
                    Log.i("解析成功的数据===",da.getTitle()+" "+da.getAuthor_name()+" "+da.getDate()+" "+da.getThumbnail_pic_s());
                }
                MyAdapter adapter=new MyAdapter(MainActivity.this,list);
                xlistview.setAdapter(adapter);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
        //slidingmenu
        initMenu();
    }
    private void initMenu() {
        //添加左菜单
        setBehindContentView(R.layout.left_item_replace);
        getSupportFragmentManager().beginTransaction().replace(R.id.left_item_replace,new LeftFragment()).commit();

        //setBehindContentView();
        SlidingMenu menu= getSlidingMenu();
        //左右滑
        menu.setMode(SlidingMenu.LEFT_RIGHT);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
        //主页面剩余的宽度
        menu.setBehindOffsetRes(R.dimen.BehindoffsetRes);

        //添加右菜单
        menu.setSecondaryMenu(R.layout.rigth_item_replace);
        getSupportFragmentManager().beginTransaction().replace(R.id.rigth_item_replace,new RigthFragment()).commit();
    }
}
