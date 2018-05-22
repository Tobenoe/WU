package com.baidu.weiying.view.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baidu.weiying.R;
import com.baidu.weiying.view.bean.VideoLBean;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by work on 2018/5/22.
 */

public class VideoTjAdapter extends RecyclerView.Adapter<VideoTjAdapter.videoTJviewHodler> {
    private Context context;
    private List<VideoLBean.RetBean.ListBean.ChildListBean> childList;

    public VideoTjAdapter(Context context) {
        this.context = context;
    }

    public void setChildList(List<VideoLBean.RetBean.ListBean.ChildListBean> childList) {
        this.childList = childList;
    }

    @Override
    public videoTJviewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.videojj_layout, parent, false);
        videoTJviewHodler hodler = new videoTJviewHodler(inflate);

        return hodler;
    }

    @Override
    public void onBindViewHolder(videoTJviewHodler holder, int position) {
        String pic = childList.get(position).getPic();
        Glide.with(context).load(pic).into(holder.video_jj_item_img);
        holder.video_jj_item_text.setText(childList.get(position).getDescription());


    }

    @Override
    public int getItemCount() {
        return childList!= null ? childList.size() : 0;
    }

    class videoTJviewHodler extends RecyclerView.ViewHolder {

        private final ImageView video_jj_item_img;
        private final TextView video_jj_item_text;

        public videoTJviewHodler(View itemView) {
            super(itemView);

            video_jj_item_img = itemView.findViewById(R.id.video_jj_item_img);
            video_jj_item_text = itemView.findViewById(R.id.video_jj_item_text);



        }
    }


}
