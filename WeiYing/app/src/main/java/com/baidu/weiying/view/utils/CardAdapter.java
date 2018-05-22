package com.baidu.weiying.view.utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baidu.weiying.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

/**
 * Created by zs on 2018/5/21.
 */

public class  CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewHolder> {

    private Context context;

    private List<User> list;

    public CardAdapter(Context context, List<User> list) {
        this.context = context;
        this.list = list;
    }

    @Override

    public CardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_card, parent, false);

        CardViewHolder holder = new CardViewHolder(view);

        return holder;

    }



    @Override

    public void onBindViewHolder(CardViewHolder holder, int position) {

        holder.title.setText(list.get(position).getName());

        holder.item.setText(list.get(position).getSign());

        //用Glide来加载图片

        Glide.with(context)

                .load(list.get(position).getPhotoResId())

                .apply(new RequestOptions().transform(new CenterCrop()))

                .into(holder.img);

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

