package com.example.fangli.myslidelib.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fangli.myslidelib.R;

/**
 * Created by chenyu.
 * Created on 上午10:10 2018/5/11.
 * Author'github https://github.com/PrettyAnt
 * descriable:可弹性的ScrollView测试
 */

public class SecondFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_second, null);
        return inflate;
    }
}
