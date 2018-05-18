package com.example.fangli.myslidelib;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.widget.SlidingLayout;

//import com.example.myslidinglayoutlib.SlidingLayout;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (enableSlideClose()) {
            SlidingLayout rootView = new SlidingLayout(this);
            rootView.bindActivity(this);
        }
        setContentView(provideContentViewId());
        initView();
    }

    protected abstract void initView();

    protected abstract int provideContentViewId();

    public boolean enableSlideClose() {
        return true;
    }
}
