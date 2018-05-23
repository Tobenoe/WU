package com.baidu.weiying.view.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baidu.weiying.R;
import com.baidu.weiying.view.activity.LbplayterActivity;
import com.baidu.weiying.view.bean.HomePageSuperClass;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * 首页的适配器
 */

public class ShouyeAdapter extends RecyclerView.Adapter<ShouyeAdapter.MyViewHolder>{
    private List<HomePageSuperClass.RetBean.ListBean.ChildListBean> list;
    private Context context;
    private static final String TAG = "HomePageAdapter---------";

    public ShouyeAdapter(List<HomePageSuperClass.RetBean.ListBean.ChildListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.choiceness_re_item, null);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.getRe_text().setText(list.get(position).getTitle());

        ImageLoader.getInstance().displayImage(list.get(position).getPic(),holder.getRe_icon());

        holder.re_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loadURL = list.get(position).getLoadURL();
                String description = list.get(position).getDescription();
                Intent intent=new Intent(context,LbplayterActivity.class);
                intent.putExtra("loadurl",loadURL+"");
                intent.putExtra("intro",description+"");
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder{

        private final ImageView re_icon;
        private final TextView re_text;

        public ImageView getRe_icon() {
            return re_icon;
        }

        public TextView getRe_text() {
            return re_text;
        }

        public MyViewHolder(View itemView) {
            super(itemView);
            re_icon = itemView.findViewById(R.id.re_icon);
            re_text = itemView.findViewById(R.id.re_text);


        }

    }
}
