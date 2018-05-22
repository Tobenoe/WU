package com.baidu.weiying.view.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baidu.weiying.R;
import com.baidu.weiying.view.bean.PL_bean;
import com.bumptech.glide.Glide;

import java.util.List;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

/**
 * Created by work on 2018/5/22.
 */

public class VideoPladapter extends RecyclerView.Adapter<VideoPladapter.VideoPlviewHodler >{

 private Context context;
 private List<PL_bean.RetBean.ListBean> list;

    public VideoPladapter(Context context) {
        this.context = context;
    }

    public void setList(List<PL_bean.RetBean.ListBean> list) {
        this.list = list;
    }

    @Override
    public VideoPlviewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.pl_item_layout, parent, false);
        VideoPlviewHodler hodler = new VideoPlviewHodler(view);
        return hodler;
    }

    @Override
    public void onBindViewHolder(VideoPlviewHodler holder, int position) {

        String userPic = list.get(position).getUserPic();
        Glide.with(context)
                .load(userPic)
                .bitmapTransform(new RoundedCornersTransformation(context, 100, 5))
                .into( holder.pl_item_icon);
        holder.pl_item_name.setText(list.get(position).getPhoneNumber());
        holder.pl_item_time.setText(list.get(position).getTime());
        holder.pl_item_contxt.setText(list.get(position).getMsg());



    }

    @Override
    public int getItemCount() {
        return list!= null ? list.size() : 0;
    }

    class VideoPlviewHodler extends RecyclerView.ViewHolder{


        private final ImageView pl_item_icon;
        private final TextView pl_item_name;
        private final TextView pl_item_time;
        private final TextView pl_item_contxt;

        public VideoPlviewHodler(View itemView) {
             super(itemView);

            pl_item_icon = itemView.findViewById(R.id.pl_item_icon);
            pl_item_name = itemView.findViewById(R.id.pl_item_name);
            pl_item_time = itemView.findViewById(R.id.pl_item_time);
            pl_item_contxt = itemView.findViewById(R.id.pl_item_contxt);



         }
     }

}
