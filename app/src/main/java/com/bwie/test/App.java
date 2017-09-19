package com.bwie.test;

import android.app.Application;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by dell on 2017/9/18.
 */
public class App extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

   private void init() {
           DisplayImageOptions options=new DisplayImageOptions.Builder()
                   .cacheInMemory(true)
                   .cacheOnDisk(true)
                   .showImageOnLoading(R.mipmap.ic_launcher)
                   .build();

          ImageLoaderConfiguration con=new ImageLoaderConfiguration.Builder(this)
                  .defaultDisplayImageOptions(options)
                  .build();

           ImageLoader.getInstance().init(con);

       }
}
