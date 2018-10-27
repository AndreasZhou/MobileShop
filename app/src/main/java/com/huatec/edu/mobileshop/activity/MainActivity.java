package com.huatec.edu.mobileshop.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.huatec.edu.mobileshop.R;
import com.huatec.edu.mobileshop.common.BaseActivity;
import com.huatec.edu.mobileshop.fragment.NavigationFragment;

public class MainActivity extends BaseActivity {


    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;

    }

    @Override
    protected void initView() {
        super.initView();

        //创建一个Fragment
        NavigationFragment navigationFragment=new NavigationFragment();
        //获取FragmentManager
        FragmentManager manager=getSupportFragmentManager();
        //开启事物
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.add(R.id.fl_main,navigationFragment);
        //提交事物
        transaction.commit();
    }

    @Override
    protected void initData() {
        super.initData();
    }





}
