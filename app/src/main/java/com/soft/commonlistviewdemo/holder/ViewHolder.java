package com.soft.commonlistviewdemo.holder;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 通用版viewHolder
 * Created by Administrator on 2016/4/26.
 */
public class ViewHolder {
    //使用Android自带的map集合来存储控件
    private final SparseArray<View> mViews;
    private View mConvertView;

    private ViewHolder(Context context, ViewGroup parent, int layoutId, int position) {
        this.mViews = new SparseArray<View>();
        mConvertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        //设置Tag
        mConvertView.setTag(this);
    }

    //拿到一个ViewHolder
    public static ViewHolder get(Context context, View convertView, ViewGroup parent, int layoutId, int position) {

        if (convertView == null) {
            return new ViewHolder(context, parent, layoutId, position);
        }
        return (ViewHolder) convertView.getTag();
    }

    //通过控件id拿到控件，如果没有则加入views
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    //获取convertView
    public View getConvertView() {
        return mConvertView;
    }

    //为TextView设置字符串
    public ViewHolder setText(int viewId,String text){
        TextView view=getView(viewId);
        view.setText(text);
        return this;
    }

    //为ImageView设置图片
    public ViewHolder setImageResource(int viewId,int drawableId){
        ImageView view=getView(viewId);
        view.setImageResource(drawableId);
        return this;
    }

    //为ImageView设置图片
    public ViewHolder setImageBitmap(int viewId,Bitmap bitmap){
        ImageView view=getView(viewId);
        view.setImageBitmap(bitmap);
        return this;
    }

    //为ImageView设置图片
    public ViewHolder setImageByUrl(int viewId,String url){
        ImageView view=getView(viewId);
        //使用xUtils3加载网络图片的时候使用下面代码
//        x.image().bind(view, url, options.normalOptions());
        return this;
    }
}
