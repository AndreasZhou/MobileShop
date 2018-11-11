package com.huatec.edu.mobileshop.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageButton;
import com.huatec.edu.mobileshop.R;
import com.huatec.edu.mobileshop.common.BaseFragment;

/**
 * Created by 小娘子 on 2018/10/26.
 */

public class NavigationFragment extends BaseFragment implements View.OnClickListener {
    private ImageButton tabItemHomeBtn;
    private ImageButton tabItemCategoryBtn;
    private ImageButton tabItemCartBtn;
    private  ImageButton tabItemPersonalBtn;

    private HomeFragment homeFragment;
    private CategoryFragment categoryFragment;
    private CartFragment cartFragment;
    private PersonFragment personFragment;
    @Override
    public int getContentViewId() {
        return R.layout.fragment_navigation;
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        //初始化控件
        tabItemHomeBtn = view.findViewById(R.id.ib_home);
        tabItemCartBtn= view.findViewById(R.id.ib_cart);
        tabItemCategoryBtn= view.findViewById(R.id.ib_sort);
        tabItemPersonalBtn= view.findViewById(R.id.ib_person);
        //设置单击事件
        tabItemHomeBtn.setOnClickListener(this);
        tabItemCartBtn.setOnClickListener(this);
        tabItemCategoryBtn.setOnClickListener(this);
        tabItemPersonalBtn.setOnClickListener(this);
        //默认进去的第一个布局是home页
        select(tabItemHomeBtn);
    }

    private void select(View v) {
        tabItemHomeBtn.setImageResource(R.mipmap.tab_item_home_focus);
        tabItemCartBtn.setImageResource(R.mipmap.tab_item_cart_focus);
        tabItemCategoryBtn.setImageResource(R.mipmap.tab_item_category_focus);
        tabItemPersonalBtn.setImageResource(R.mipmap.tab_item_personal_focus);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (homeFragment != null) {
            transaction.hide(homeFragment);
        }
        if (categoryFragment != null) {
            transaction.hide(categoryFragment);
        }
        if (cartFragment != null) {
            transaction.hide(cartFragment);
        }
        if (personFragment != null) {
            transaction.hide(personFragment);
        }
        switch (v.getId()){
            case R.id.ib_home:
                tabItemHomeBtn.setImageResource(R.mipmap.tab_item_home_normal);
                if(homeFragment==null){
                    homeFragment =new HomeFragment();
                    transaction.add(R.id.fl_nav,homeFragment);
                }else{
                    transaction.show(homeFragment);
                }
                break;
            case R.id.ib_cart:
                tabItemCartBtn.setImageResource(R.mipmap.tab_item_cart_normal);
                if(cartFragment==null){
                    cartFragment= new CartFragment();
                    transaction.add(R.id.fl_nav,cartFragment);
                }else{
                    transaction.show(cartFragment);
                }
                break;
            case R.id.ib_sort:
                tabItemCategoryBtn.setImageResource(R.mipmap.tab_item_category_normal);
                if(categoryFragment==null){
                    categoryFragment =new CategoryFragment();
                    transaction.add(R.id.fl_nav,categoryFragment);
                }else{
                    transaction.show(categoryFragment);
                }
                break;
            case R.id.ib_person:
                tabItemPersonalBtn.setImageResource(R.mipmap.tab_item_personal_normal);
                if(personFragment==null){
                    personFragment =new PersonFragment();
                    transaction.add(R.id.fl_nav,personFragment);
                }else{
                    transaction.show(personFragment);
                }
                break;
        }
        transaction.commit();
    }
    @Override
    public void onClick(View v) {
        select(v);
    }


}
