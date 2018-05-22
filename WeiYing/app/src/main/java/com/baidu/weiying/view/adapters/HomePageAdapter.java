package com.baidu.weiying.view.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baidu.weiying.R;
import com.baidu.weiying.view.bean.HomePageSuperClass;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * 首页的适配器
 */

public class HomePageAdapter extends RecyclerView.Adapter<HomePageAdapter.choicenViewHodel> {
    private Context context;
    private List<HomePageSuperClass.RetBean.ListBean> list;
    private VideoChickLister videoChickLister;

    public void setVideoChickLister(VideoChickLister videoChickLister) {
        this.videoChickLister = videoChickLister;
    }

    public HomePageAdapter(Context context) {
        this.context = context;
    }

    public void setList(List<HomePageSuperClass.RetBean.ListBean> list) {
        this.list = list;
    }

    @Override
    public choicenViewHodel onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.chose_item_layout, parent, false);
        choicenViewHodel viewHodel = new choicenViewHodel(view);
        return viewHodel;
    }

    @Override
    public void onBindViewHolder(choicenViewHodel holder, final int position) {
        String title = list.get(position).getTitle();
        ViewGroup.LayoutParams params = holder.img_video.getLayoutParams();

        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        int width = dm.widthPixels / 2;//宽度为屏幕宽度一半
//        int height = data.getHeight()*width/data.getWidth();//计算View的高度

        params.height = (int) (width / 1.8);
        holder.img_video.setLayoutParams(params);
        if (title.equals("") && title == null) {

            list.remove(position);

            //Glide.with(context).load(list.get(position).get)
        } else {

            holder.tv_title.setText(list.get(position).getTitle());


        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                videoChickLister.Click(v,position);

            }
        });


    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    class choicenViewHodel extends RecyclerView.ViewHolder {

        private final ImageView img_video;
        private final TextView tv_title;

        public choicenViewHodel(View itemView) {
            super(itemView);

            img_video = itemView.findViewById(R.id.img_video);
            tv_title = itemView.findViewById(R.id.tv_title);
            img_video.setScaleType(ImageView.ScaleType.FIT_XY);


        }
    }

    public interface VideoChickLister {

        void Click(View view, int prostion);

    }

}
