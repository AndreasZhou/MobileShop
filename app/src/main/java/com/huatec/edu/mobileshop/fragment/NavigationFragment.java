package com.huatec.edu.mobileshop.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.huatec.edu.mobileshop.R;

/**
 * Created by 小娘子 on 2018/10/26.
 */

public class NavigationFragment extends BaseFragment implements View.OnClickListener {
   private LinearLayout tabItemHome;
    private LinearLayout tabItemCategory;
    private LinearLayout tabItemCart;
    private LinearLayout tabItemPersonal;
    private ImageButton tabItemHomeBtn;
    private ImageButton tabItemCategoryBtn;
    private ImageButton tabItemCartBtn;
    private  ImageButton tabItemPersonalBtn;
    HomeFragment homeFragment;
    CategoryFragment categoryFragment;
    CartFragment cartFragment;
    PersonFragment personFragment;
    private int currentId;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_navigation, container, false);
        initViews(view);
        setTabSelection(R.id.tab_item_home);
        return view;
    }

    private void setTabSelection(int id) {

        tabItemHomeBtn.setImageResource(R.mipmap.tab_item_home_focus);
        tabItemCategoryBtn.setImageResource(R.mipmap.tab_item_category_focus);
        tabItemCartBtn.setImageResource(R.mipmap.tab_item_cart_focus);
        tabItemPersonalBtn.setImageResource(R.mipmap.tab_item_personal_focus);

        FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
        if(homeFragment!=null){
            fragmentTransaction.hide(homeFragment);

        }
        if(categoryFragment!=null){
            fragmentTransaction.hide(categoryFragment);

        }
        if(cartFragment!=null){
            fragmentTransaction.hide(cartFragment);

        }
        if(personFragment!=null){
            fragmentTransaction.hide(personFragment);

        }
        
        
        switch (id){
            case R.id.tab_item_home:
                tabItemHomeBtn.setImageResource(R.mipmap.tab_item_home_normal);
                if(homeFragment==null){
                    homeFragment=new HomeFragment();
                    fragmentTransaction.add(R.id.content,homeFragment);
                }else{
                    fragmentTransaction.show(homeFragment);
                }
                break;


            case R.id.tab_item_category:
                tabItemHomeBtn.setImageResource(R.mipmap.tab_item_category_normal);
                if(categoryFragment==null){
                    categoryFragment=new CategoryFragment();
                    fragmentTransaction.add(R.id.content,categoryFragment);
                }else{
                    fragmentTransaction.show(categoryFragment);
                }
                break;


            case R.id.tab_item_cart:
                tabItemHomeBtn.setImageResource(R.mipmap.tab_item_cart_normal);
                if(cartFragment==null){
                    cartFragment=new CartFragment();
                    fragmentTransaction.add(R.id.content,cartFragment);
                }else{
                    fragmentTransaction.show(cartFragment);
                }
                break;


            case R.id.tab_item_personal:
                tabItemHomeBtn.setImageResource(R.mipmap.tab_item_personal_normal);
                if(personFragment==null){
                    personFragment=new PersonFragment();
                    fragmentTransaction.add(R.id.content,personFragment);
                }else{
                    fragmentTransaction.show(personFragment);
                }
                break;
        }
        
        fragmentTransaction.commit();
        currentId=id;
        
    }


    private void initViews(View view) {
        tabItemHome= (LinearLayout) view.findViewById(R.id.tab_item_home);
        tabItemHome.setOnClickListener(this);

        tabItemCategory= (LinearLayout) view.findViewById(R.id.tab_item_category);
        tabItemHome.setOnClickListener(this);

        tabItemCart= (LinearLayout) view.findViewById(R.id.tab_item_cart);
        tabItemHome.setOnClickListener(this);

        tabItemPersonal= (LinearLayout) view.findViewById(R.id.tab_item_personal);
        tabItemHome.setOnClickListener(this);

        tabItemHomeBtn=(ImageButton) view.findViewById(R.id.teb_item_home_btn);
        tabItemCategoryBtn=(ImageButton) view.findViewById(R.id.teb_item_home_btn);
        tabItemCartBtn=(ImageButton) view.findViewById(R.id.teb_item_home_btn);
        tabItemPersonalBtn=(ImageButton) view.findViewById(R.id.teb_item_home_btn);


        FragmentManager manager = getFragmentManager();
    }


    @Override
    public void onClick(View v) {

    }
}
