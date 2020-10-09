package com.newtech.android.chattrapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentContainerView;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.google.android.material.appbar.AppBarLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.appBarMain)
    AppBarLayout mAppBarLayout;

    @BindView(R.id.nav_host_fragment)
    FragmentContainerView mFragmentContainerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        NavHostFragment navHostFragment =
                (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        NavController navController = navHostFragment.getNavController();
    }

    public void setupActionBar(String title, boolean isDisplayHome, View.OnClickListener clickListener) {
        showActionBar();
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(isDisplayHome);
        mToolbar.setNavigationOnClickListener(clickListener);
    }

    private void showActionBar() {
        mAppBarLayout.setVisibility(View.VISIBLE);
    }

    public void hideActionBar(){
        mAppBarLayout.setVisibility(View.GONE);
    }


}