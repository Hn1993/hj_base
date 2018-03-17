package com.eiga.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;

import com.eiga.R;
import com.eiga.base.BaseActivity;
import com.eiga.ui.fragment.MainFragment;
import com.eiga.ui.fragment.MyCenterFragment;
import com.eiga.utils.AndroidWorkaround;
import com.eiga.view.NoScrollViewPager;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.albert.autosystembar.SystemBarHelper;

public class MainActivity extends BaseActivity {

    @BindView(R.id.main_vp)
    NoScrollViewPager mainVp;
    @BindView(R.id.main_tab)
    android.support.design.widget.TabLayout mainTab;

    private android.support.design.widget.TabLayout.Tab tabMain,tabMall,TabKeeper,tabMyCenter;

    private String[] mTitles=new String[]{"首页","商城","信用管家","个人中心"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        autoVirtualKeys();//华为等底部虚拟按键的手机
        ButterKnife.bind(this);

        findViews();
    }

    private void findViews() {
        mainVp.setScanScroll(false);
        mainVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                switch (position){
                    case 0:
                        return new MainFragment();
                    case 1:
                        return new MainFragment();
                    case 2:
                        return new MainFragment();
                    case 3:
                        return new MyCenterFragment();
                }
                return new MainFragment();
            }

            @Override
            public int getCount() {
                return mTitles.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return mTitles[position];
            }
        });

        mainTab.setupWithViewPager(mainVp);
        tabMain=mainTab.getTabAt(0);
        tabMyCenter=mainTab.getTabAt(1);
        tabMall=mainTab.getTabAt(2);
        TabKeeper=mainTab.getTabAt(3);

        tabMain.setIcon(R.mipmap.ic_launcher);
        tabMyCenter.setIcon(R.mipmap.ic_launcher);
        tabMall.setIcon(R.mipmap.ic_launcher);
        TabKeeper.setIcon(R.mipmap.ic_launcher);
    }
}
