package com.isoftstone.huidingc.testqmui.adpater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.isoftstone.huidingc.testqmui.R;
import java.util.List;

/**
 * @auther huidingc
 * @date 2018/2/5 14:14
 * @description ImgAdapter
 */

public class ImgAdapter extends RecyclerView.Adapter<ImgAdapter.ImgViewHolder> {
    private Context context;
    private List<String> list;
    private LayoutInflater inflater;

    public ImgAdapter(Context context,List<String> list){
        this.context = context;
        this.list = list;
        this.inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    /**
     * 刷新数据
     * @param list
     */
    public void updateList(List<String> list){
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public ImgViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ImgViewHolder(inflater.inflate(R.layout.img_grid_item,null));
    }

    @Override
    public void onBindViewHolder(ImgViewHolder holder, int position) {
        Glide.with(context)
                .load(list.get(position))
                .into(holder.ivImg);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ImgViewHolder extends RecyclerView.ViewHolder{
        ImageView ivImg;

        private ImgViewHolder(View itemView) {
            super(itemView);
            ivImg = itemView.findViewById(R.id.iv_img);
        }
    }
}
