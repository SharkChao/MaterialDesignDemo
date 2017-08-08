package com.lenovohit.administrator.materialdesigndemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lenovohit.administrator.materialdesigndemo.R;

/**
 * Created by SharkChao on 2017-08-08.
 * 水果详情页
 */

public class FruitActivity extends AppCompatActivity{
    public static final String FRUIT_NAME = "fruit_name";
    public static final String FRUIT_IMAGE_ID = "fruit_image_id";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit);
        Intent intent = getIntent();
        String name = intent.getStringExtra(FRUIT_NAME);
        int fruitId = intent.getIntExtra(FRUIT_IMAGE_ID,0);

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsLayout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        ImageView ivFruit = (ImageView) findViewById(R.id.fruit_image);
        TextView textView = (TextView) findViewById(R.id.tvFruit);

        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbarLayout.setTitle(name);
        Glide.with(this).load(fruitId).into(ivFruit);
        String names = generateFruitName(name);
        textView.setText(names);
    }
    private String generateFruitName(String name){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 500; i++){
            stringBuilder.append(name);
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}
