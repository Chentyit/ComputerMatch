package com.bignerdranch.administrator.computermatch;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private NavigationView mNavigationView;
    private DrawerLayout mDrawerLayout;
    private FrameLayout mFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        replaceFragment(new Home());
    }

    private void initView() {
        mNavigationView = (NavigationView) findViewById(R.id.computer_match_nav_view);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.computer_match_drawer);
        mFrameLayout = (FrameLayout) findViewById(R.id.computer_match_frame);
        mNavigationView.setNavigationItemSelectedListener(this);
    }

    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                replaceFragment(new Home());
                mDrawerLayout.closeDrawers();
                break;
            case R.id.nav_myplan:
                replaceFragment(new MyPlan());
                mDrawerLayout.closeDrawers();
                break;
            case R.id.nav_will:
                replaceFragment(new Will());
                mDrawerLayout.closeDrawers();
                break;
            case R.id.nav_finish:
                replaceFragment(new Finish());
                mDrawerLayout.closeDrawers();
                break;
        }
        return true;
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.computer_match_frame, fragment);
        transaction.commit();
    }

}
