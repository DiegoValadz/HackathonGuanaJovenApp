package com.diego.ovocacional.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.diego.ovocacional.R;
import com.diego.ovocacional.Utilities.Utilities;
import com.diego.ovocacional.fragments.MainFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = findViewById(R.id.nav_view);
        drawerLayout = findViewById(R.id.main_activitie);
        setToolBar();
        setDefaultFragment();
        //Se implementa listener del Drawer
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.main_activitie);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        boolean fragmentTransaction = false;
        int select;
        Intent intent;
        switch (item.getItemId()) {
            case R.id.menu_main:
                fragment = new MainFragment();
                fragmentTransaction = true;
                break;
            case R.id.descubre:

                fragmentTransaction = false;
                break;
            case R.id.acerca_de:

                fragmentTransaction = false;
                break;
        }
        if (fragmentTransaction) {
            selectFragment(fragment,item);

        }
        return true;
    }

    public void setToolBar() {
        Toolbar toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Menú principal");
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private void setDefaultFragment() {
        MenuItem item = navigationView.getMenu().getItem(Menu.FIRST);
        selectFragment(new MainFragment(),item);
        item.setChecked(true);
    }
    private void selectFragment(Fragment fragment, MenuItem item){
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.content_frame, fragment).commit();
        item.setChecked(true);
        getSupportActionBar().setTitle(item.getTitle());
        drawerLayout.closeDrawers();
    }

}

