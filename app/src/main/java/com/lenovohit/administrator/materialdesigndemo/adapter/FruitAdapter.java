package com.lenovohit.administrator.materialdesigndemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lenovohit.administrator.materialdesigndemo.R;
import com.lenovohit.administrator.materialdesigndemo.activity.FruitActivity;
import com.lenovohit.administrator.materialdesigndemo.entity.Fruit;

import java.util.List;

/**
 * Created by SharkChao on 2017-08-08.
 */

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder>{
    private Context mContext;
    private List<Fruit> mFruitList;

    public FruitAdapter(List<Fruit>fruitList){
        this.mFruitList = fruitList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null){
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.fruit_item, parent, false);
       final ViewHolder holder = new ViewHolder(view);
        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Intent intent = new Intent(mContext, FruitActivity.class);
                intent.putExtra(FruitActivity.FRUIT_NAME,fruit.getName());
                intent.putExtra(FruitActivity.FRUIT_IMAGE_ID,fruit.getImageId());
                mContext.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Fruit fruit = mFruitList.get(position);
        holder.tvFruitName.setText(fruit.getName());
        Glide.with(mContext).load(fruit.getImageId()).into(holder.ivFruit);
    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }

    static  class ViewHolder extends RecyclerView.ViewHolder{
        CardView mCardView;
        ImageView ivFruit;
        TextView tvFruitName;
        public ViewHolder(View itemView) {
            super(itemView);
            mCardView = (CardView) itemView;
            ivFruit = (ImageView) itemView.findViewById(R.id.fruit_image);
            tvFruitName = (TextView) itemView.findViewById(R.id.fruit_name);
        }
    }
}
