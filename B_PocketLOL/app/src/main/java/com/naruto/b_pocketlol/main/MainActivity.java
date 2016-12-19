package com.naruto.b_pocketlol.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.naruto.b_pocketlol.R;
import com.naruto.b_pocketlol.base.BaseActivity;
import com.naruto.b_pocketlol.discovery.DiscoveryFragment;
import com.naruto.b_pocketlol.friend.FriendFragment;
import com.naruto.b_pocketlol.me.MeFragment;
import com.naruto.b_pocketlol.news.NewsFragment;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private RadioButton newsRbt,friendRbt,discoveryRbt,meRbt;

    @Override
    public int setLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        newsRbt = bindView(R.id.rbt_news_main);
        friendRbt = bindView(R.id.rbt_friend_main);
        discoveryRbt = bindView(R.id.rbt_discovery_main);
        meRbt = bindView(R.id.rbt_me_main);
    }

    @Override
    public void initData() {
        newsRbt.setOnClickListener(this);
        friendRbt.setOnClickListener(this);
        discoveryRbt.setOnClickListener(this);
        meRbt.setOnClickListener(this);
        replaceFragment(new NewsFragment());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rbt_news_main:
                replaceFragment(new NewsFragment());
                break;
            case R.id.rbt_friend_main:
                replaceFragment(new FriendFragment());
                break;
            case R.id.rbt_discovery_main:
                replaceFragment(new DiscoveryFragment());
                break;
            case R.id.rbt_me_main:
                replaceFragment(new MeFragment());
                break;
        }

    }
    // 替换占位布局
    private void replaceFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.main_replace,fragment);
        transaction.commit();
    }
}
