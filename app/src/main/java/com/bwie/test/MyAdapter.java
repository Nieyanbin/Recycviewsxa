package com.bwie.test;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.sax.StartElementListener;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by dell on 2017/9/18.
 */
public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    Context context;
    List<Data.StoriesBean> list;
    private final DisplayImageOptions options;
    private OnitemLongdianji onitemLongdianji;
    public MyAdapter(Context context, List<Data.StoriesBean> list) {
        this.context = context;
        this.list = list;
        options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .showImageOnLoading(R.mipmap.ic_launcher)
                .build();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        TestViewHolder holder=new TestViewHolder(inflate);

        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final TestViewHolder tHolder = (TestViewHolder) holder;
        tHolder.tv.setText(list.get(position).getTitle());
        tHolder.ll.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
            public boolean onLongClick(View view) {
                onitemLongdianji.onLong(view,position);
                return true;
            }
        });
        tHolder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onitemLongdianji.ondinaji(view,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    private class TestViewHolder extends RecyclerView.ViewHolder{
        TextView tv;
        ImageView img;
        LinearLayout ll;
        public View rootView;

        public TestViewHolder(View itemView) {
            super(itemView);
      tv=itemView.findViewById(R.id.tv);
            img=itemView.findViewById(R.id.img);
            ll=itemView.findViewById(R.id.ll);
        }


    }
    public interface OnitemLongdianji{
        void onLong(View view,int position);
        void ondinaji(View view,int position);
    }
    public void setonlongdinaji(OnitemLongdianji onitemLongdianji){
        this.onitemLongdianji=onitemLongdianji;
    }


}
