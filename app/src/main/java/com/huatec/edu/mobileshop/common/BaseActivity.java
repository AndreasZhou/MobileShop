package com.huatec.edu.mobileshop.common;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.huatec.edu.mobileshop.R;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());

        initView();
        initData();
    }

    //加载数据的方法
    protected void initData() {
    }

    //加载布局的方法
    protected void initView() {
    }

    //BaseActivity是一个抽象类，类中有一个抽象方法，子类继承父类时，要实现父类的抽象方法。
// 通过抽象方法，我们可以加载对应得布局文件
    protected abstract int getContentViewId();

    //共用方法，提示信息
    public void toastShort(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void toastLong(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
