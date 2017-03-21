package com.example.liuyueyue.demo0321;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private Button btnOpen;
    private CoordinatorLayout mCoordinatorLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findviews();
    }

    private void findviews() {
        mDrawerLayout= (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView= (NavigationView) findViewById(R.id.navigation_view);
        btnOpen= (Button) findViewById(R.id.btnOpen);
        mCoordinatorLayout= (CoordinatorLayout) findViewById(R.id.main_content);

        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId()==R.id.navigation_item_home){
                    mCoordinatorLayout.setStatusBarBackgroundColor(Color.BLUE);
                    mDrawerLayout.closeDrawers();
                    return true;
                }else if (item.getItemId()==R.id.navigation_item_blog){
                    mCoordinatorLayout.setStatusBarBackgroundColor(Color.GRAY);
                    mDrawerLayout.closeDrawers();
                    return true;
                }
                return false;
            }
        });
    }
}
