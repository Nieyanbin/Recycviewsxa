package com.bwie.test;

import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 作者  聂雁宾
 * 时间 2017年9月18日10:21:57
 * 思路 完成此类
 */
public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;
    private MyAdapter ad;
    private SwipeRefreshLayout sl;
    private Data data;
    private Handler handler=new Handler(){};
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化控件
        initView();
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(linearLayoutManager);

        jiexi();



    }

    private void jiexi() {
        OkHttpUtils .get().url("https://news-at.zhihu.com/api/4/news/latest").build().execute(new StringCallback() {



            @Override
            public void onError(Request request, Exception e) {

            }

            @Override
            public void onResponse(String response) {
                Log.e("数据","数据啊啊啊"+response.toString());
                Gson gson=new Gson();
                data = gson.fromJson(response, Data.class);
                ad=new MyAdapter(MainActivity.this,data.getStories());
                rv.setAdapter(ad);
              ad.setonlongdinaji(new MyAdapter.OnitemLongdianji() {
                  @Override
                  public void onLong(View view, int position) {
                      Toast.makeText(MainActivity.this,"刘浩傻逼",Toast.LENGTH_SHORT).show();
                  }

                  @Override
                  public void ondinaji(View view, int position) {
                      Toast.makeText(MainActivity.this,"刘浩傻逼啊啊啊啊",Toast.LENGTH_SHORT).show();
                  }
              });
                sl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                               MyAdapter1 adad=new MyAdapter1(MainActivity.this,data.getTop_stories());
                               rv.setAdapter(adad);
                                sl.setRefreshing(false);
                            }
                        },2000);

                    }
                });
                rv.setOnScrollListener(new RecyclerView.OnScrollListener() {
                    @Override
                    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                        super.onScrollStateChanged(recyclerView, newState);
                        if(newState==RecyclerView.SCROLL_STATE_IDLE){
                            if(linearLayoutManager.findLastVisibleItemPosition()==ad.getItemCount()-1){
                                MyAdapter1 adad=new MyAdapter1(MainActivity.this,data.getTop_stories());
                                rv.setAdapter(adad);
                                sl.setRefreshing(false);
                            }
                        }

                    }
                });
            }
        });



    }

    private void initView() {
        rv = (RecyclerView) findViewById(R.id.rv);
        sl = (SwipeRefreshLayout) findViewById(R.id.sl);
    }

}
