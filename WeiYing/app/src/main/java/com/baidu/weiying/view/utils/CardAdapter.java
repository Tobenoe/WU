package com.baidu.weiying.view.utils;

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
import com.bumptech.glide.load.resource.bitmap.CenterCrop;


import java.util.List;

/**
 * Created by zs on 2018/5/21.
 */

public class  CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {

    private Context context;

    private List<HomePageSuperClass.RetBean.ListBean.ChildListBean> list;

    public CardAdapter(Context context, List<HomePageSuperClass.RetBean.ListBean.ChildListBean> list) {
        this.context = context;
        this.list = list;
    }

    //条目点击监听
    private OnItemClickListener onItemClickListener;
    //条目点击事件
    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }

    //条目点击事件
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){

        this.onItemClickListener = onItemClickListener;

    }

    @Override

    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_card, parent, false);

        CardViewHolder holder = new CardViewHolder(view);

        return holder;

    }



    @Override

    public void onBindViewHolder(final CardViewHolder holder, int position) {

        holder.title.setText(list.get(position).getTitle());

        holder.item.setText(list.get(position).getDescription());

        //用Glide来加载图片

        Glide.with(context)

                .load(list.get(position).getPic())

              //  .apply(new RequestOptions().transform(new CenterCrop()))

                .into(holder.img);
        //点击
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //条目的点击事件
                int index = holder.getLayoutPosition();


                onItemClickListener.onItemClick(view,index);




            }
        });

    }



    @Override

    public int getItemCount() {

        return list!=null?list.size():0;

    }






    class CardViewHolder extends RecyclerView.ViewHolder {


        private  TextView title;
        private  ImageView img;
        private  TextView item;

        public CardViewHolder(View itemView) {

            super(itemView);

            title = itemView.findViewById(R.id.itemCar_title);
            img = itemView.findViewById(R.id.itemCar_image);
            item = itemView.findViewById(R.id.itemCar_content);

        }

    }

}

