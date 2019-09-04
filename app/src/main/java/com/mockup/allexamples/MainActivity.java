package com.mockup.allexamples;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import com.google.android.material.navigation.NavigationView;
import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;

import com.mockup.allexamples.Firebase.FirebaseExamples;
import com.mockup.allexamples.JDBCImageSFTP.ImageFTP;
import com.mockup.allexamples.RX.RX_Java;
import com.mockup.allexamples.notificaciones.Notificaciones;
import com.mockup.allexamples.pokemonRetrofit.PokemonRetrofit;
import com.mockup.allexamples.retrofit.Retrofit;
import com.mockup.allexamples.sharedPreferencesP.SharedPreferences;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout_mainactivity);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);





    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout_firebase);
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
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
             intent= new Intent(this,PokemonRetrofit.class);

            startActivity(intent);

            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            intent= new Intent(this, SharedPreferences.class);

            startActivity(intent);


        } else if (id == R.id.nav_slideshow) {
            intent= new Intent(this, Notificaciones.class);

            startActivity(intent);

        } else if (id == R.id.nav_tools) {
            intent= new Intent(this, ImageFTP.class);

            startActivity(intent);


        }
        else if (id == R.id.firebaseexamples) {
            intent= new Intent(this, FirebaseExamples.class);

            startActivity(intent);


        }else if (id == R.id.nav_retrofit) {
            //Activity RBR
            Intent intent = new Intent(this, Retrofit.class);
            startActivity(intent);

        } else if (id == R.id.rx) {
            //Activity RBR
            Intent intent = new Intent(this, RX_Java.class);
            startActivity(intent);

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout_mainactivity);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
