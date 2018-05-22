package com.baidu.weiying.view.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
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
 * Created by work on 2018/5/21.
 */

public class VideoLbAdapter extends RecyclerView.Adapter<VideoLbAdapter.VideoLbViewHodler> {

    private Context context;
    private List<HomePageSuperClass.RetBean.ListBean.ChildListBean> childList;
    private VideoLbListenter videoLbListenter;

    public void setVideoLbListenter(VideoLbListenter videoLbListenter) {
        this.videoLbListenter = videoLbListenter;
    }

    public VideoLbAdapter(Context context) {
        this.context = context;
    }

    public void setChildList(List<HomePageSuperClass.RetBean.ListBean.ChildListBean> childList) {
        this.childList = childList;
    }

    @Override
    public VideoLbViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.videplb_item_layout, parent, false);
        VideoLbViewHodler hodler = new VideoLbViewHodler(view);
        return hodler;
    }

    @Override
    public void onBindViewHolder(VideoLbViewHodler holder, final int position) {

        String pic = childList.get(position).getPic();
        Glide.with(context).load(pic).into(holder.video_lb_item_img);
        holder.video_lb_item_text.setText(childList.get(position).getDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击事件传值
                videoLbListenter.Onclick(v, position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return childList != null ? childList.size() : 0;
    }

    class VideoLbViewHodler extends RecyclerView.ViewHolder {

        private final ImageView video_lb_item_img;
        private final TextView video_lb_item_text;

        public VideoLbViewHodler(View itemView) {
            super(itemView);

            video_lb_item_img = itemView.findViewById(R.id.video_lb_item_img);
            video_lb_item_text = itemView.findViewById(R.id.video_lb_item_text);

        }
    }


    public interface VideoLbListenter {

        void Onclick(View view, int prostion);

    }


}
