package com.example.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * Created by chenyu on 2018/5/14.
 * Author'github https://github.com/PrettyAnt
 * 自定义组合控件
 * 本实例主要展示的是自定义组合控件，新增了<文字阴影效果> 背景--->>mTv_background_content
 * 原理：在xml中添加两个TextView，一个TextView作为背景，并获取该TextView的TextPaint，
 * 然后设置画笔的setStrokeWidth和setStyle(Paint.Style.STROKE)即可
 *
 * Tip：本来类库中还有另一个阴影效果的控件，详见 -->>StrokeTextView
 */

public class ImgTextView extends LinearLayout {

    private Context context;
    private TextView tv_content;
    private String imgTextStr;
    private TextView mTv_background_content;

    public ImgTextView(Context context) {
        super(context);
        this.context = context;
        initView(context, null);
    }

    public ImgTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public ImgTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        View inflate = LayoutInflater
                .from(context)
                .inflate(R.layout.widget_imgtxt, this);
        ImageView iv_icon = (ImageView) inflate.findViewById(R.id.iv_icon);
        tv_content = (TextView) inflate.findViewById(R.id.tv_content);
        mTv_background_content = (TextView) inflate.findViewById(R.id.tv_background_content);
        // 加载自定义属性配置
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SpdbImgText);
        if (typedArray != null) {
            // 为图片添加特性
            int picBackgroud = typedArray.getResourceId(R.styleable.SpdbImgText_cy_backgroud, 0);
            int picWidth = (int) typedArray.getDimension(R.styleable.SpdbImgText_cy_backgroud_width, 40);
            int picHeight = (int) typedArray.getDimension(R.styleable.SpdbImgText_cy_backgroud_height, 40);
//            iv_icon.setMinimumWidth(40);
//            iv_icon.setMinimumHeight(40);
            iv_icon.setMaxWidth(picWidth);
            iv_icon.setMaxHeight(picHeight);
            iv_icon.setImageResource(picBackgroud);

            // 为内容设置属性
            String picText = typedArray.getString(R.styleable.SpdbImgText_cy_text);
            int picTextColor = typedArray.getColor(R.styleable.SpdbImgText_cy_text_color, 12);
            float picTextSize = typedArray.getDimension(R.styleable.SpdbImgText_cy_text_size, 12);
            //设置背景文字属性  阴影效果
            /************start*************/
            TextPaint paint = mTv_background_content.getPaint();
            paint.setStrokeWidth(6);
            paint.setStyle(Paint.Style.STROKE);
            mTv_background_content.setText(picText);
            mTv_background_content.setTextSize(picTextSize);
            mTv_background_content.setTextColor(Color.parseColor("#FF06EDA4"));
            mTv_background_content.setMinWidth(tv_content.getWidth()+6);
            /************end*************/
            tv_content.setText(picText);
            tv_content.setTextColor(picTextColor);
            tv_content.setTextSize(picTextSize);
            typedArray.recycle();
        }

    }

    /**
     * 通过java代码设置文字
     * @param imgTextStr
     */
    public void setImgText(String imgTextStr) {
        this.imgTextStr = imgTextStr;
        if (tv_content != null) {
            tv_content.setText(imgTextStr);
        }
    }
}
