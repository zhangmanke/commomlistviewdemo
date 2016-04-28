package com.soft.commonlistviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.soft.commonlistviewdemo.adapter.CommonAdapter;
import com.soft.commonlistviewdemo.holder.ViewHolder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends Activity {

    private ListView lv_main;
    private List<String> mDatas=new ArrayList<String>(Arrays.asList("Hello","World","Welcome"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //查看像素密度
//        DisplayMetrics metric=new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(metric);
//        float density=metric.density;
//        Log.e("TAG","#######"+density);

        lv_main = (ListView) findViewById(R.id.id_lv_main);
        lv_main.setAdapter(new CommonAdapter<String>(R.layout.item_single_str,MainActivity.this,mDatas) {
            @Override
            public void convert(ViewHolder viewHolder, String item) {
                viewHolder.setText(R.id.id_tv_title,item);
            }
        });
    }

}
