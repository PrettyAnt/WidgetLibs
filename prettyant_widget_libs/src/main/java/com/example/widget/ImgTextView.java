package com.example.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * Created by chenyu on 2018/5/14.
 * 自定义组合控件
 */

public class ImgTextView extends LinearLayout {

    private Context context;

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
        ImageView iv_icon = inflate.findViewById(R.id.iv_icon);
        TextView tv_content = inflate.findViewById(R.id.tv_content);
        // 加载自定义属性配置
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.SpdbImgText);
        if (typedArray != null) {
            // 为图片添加特性
            int picBackgroud = typedArray.getResourceId(R.styleable.SpdbImgText_cy_backgroud, 0);
            int picWidth = (int) typedArray.getDimension(R.styleable.SpdbImgText_cy_backgroud_width, 40);
            int picHeight = (int) typedArray.getDimension(R.styleable.SpdbImgText_cy_backgroud_height, 40);
//            iv_icon.setMinimumWidth(40);
//            iv_icon.setMinimumWidth(40);
            iv_icon.setMaxWidth(picWidth);
            iv_icon.setMaxHeight(picHeight);
            iv_icon.setImageResource(picBackgroud);
//test
            // 为内容设置属性
            String picText = typedArray.getString(R.styleable.SpdbImgText_cy_text);
            int picTextColor = typedArray.getColor(R.styleable.SpdbImgText_cy_text_color, 12);
            float picTextSize = typedArray.getDimension(R.styleable.SpdbImgText_cy_text_size, 12);
            tv_content.setText(picText);
            tv_content.setTextColor(picTextColor);
            tv_content.setTextSize(picTextSize);
            typedArray.recycle();
        }

    }
}
