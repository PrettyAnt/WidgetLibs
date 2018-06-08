package com.example.fangli.myslidelib.demo2;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.fangli.myslidelib.R;

/**
 * Created by chenyu on 2018/5/14.
 */
public class Detail2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail2);

        Toolbar toolbar = (Toolbar) this.findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//
        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle("测试测试");
    }

//    public void checkin(View view) {
//        Snackbar.make(view, "checkin success!", Snackbar.LENGTH_SHORT).show();
//    }
}
