package com.app.designdemo1;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        TabLayout tab = (TabLayout) findViewById(R.id.tab);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawer = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawer,toolbar,0,0);
        //drawer.addDrawerListener(toggle);
        toggle.syncState();

        List<String> list = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            list.add(String.format(Locale.CHINA, "第%02d页", i));
        }
        pager.setAdapter(new MyAdapter(getSupportFragmentManager(),list));
        tab.setupWithViewPager(pager);

        NavigationView navigation = (NavigationView) findViewById(R.id.navigation);
        navigation.setNavigationItemSelectedListener(this);

        Button btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_4:
                finish();
                break;
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        Snackbar.make(v,"Snackbar",Snackbar.LENGTH_LONG)
                .setAction("undo",new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(MainActivity.this,CoordinatorActivity.class));
                        //Toast.makeText(MainActivity.this,"undo",Toast.LENGTH_SHORT).show();
                    }
                }).show();
    }
}
