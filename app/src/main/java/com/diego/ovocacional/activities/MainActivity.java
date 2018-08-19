package com.diego.ovocacional.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
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
import com.diego.ovocacional.models.Carrera;
import com.diego.ovocacional.models.Universidad;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Utilities.universidades = cargaDatos();
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


    public ArrayList<Universidad> cargaDatos() {
        ArrayList<Universidad> aux = new ArrayList<>();
        ArrayList<Carrera> auxCarr;
        InputStream is = getResources().openRawResource(R.raw.listado);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );

        String line = "";
        try {

            reader.readLine();

            while ((line = reader.readLine()) != null) {
                Log.d("MyActivity","Line" + line);
                String[] token = line.split(",");
                auxCarr = llenarCarreras(token[0]);
                Universidad sample = new Universidad(token[0],token[1],token[2],token[3],token[4],token[5],token[6],token[7],auxCarr);
                aux.add(sample);

            }
        }catch (IOException e) {
            Log.wtf("MyActivity","Error reading data file on line" + line,e);
            e.printStackTrace();
        }
        return aux;
    }

    private ArrayList<Carrera> llenarCarreras(String id) {
        int idNew = getResources().getIdentifier("u"+id, "raw", getPackageName());
        ArrayList<Carrera> auxC = new ArrayList<>();
        InputStream is = getResources().openRawResource(idNew);
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );

        String line = "";
        try {

            reader.readLine();

            while ((line = reader.readLine()) != null) {
                Log.d("MyActivity","Line" + line);
                String[] token = line.split(",");
                Carrera sample = new Carrera(token[0],token[1],token[2]);
                auxC.add(sample);

            }
        }catch (IOException e) {
            Log.wtf("MyActivity","Error reading data file on line" + line,e);
            e.printStackTrace();
        }
        return auxC;
    }


}

