package com.mockup.allexamples.Firebase;

import android.os.Bundle;

import android.view.MenuItem;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;

import com.google.android.material.navigation.NavigationView;
import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.WindowManager;

import com.mockup.allexamples.Firebase.ui.login.LoginFragment;
import com.mockup.allexamples.Firebase.ui.send.SendFragment;
import com.mockup.allexamples.R;

public class FirebaseExamples extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_examples);
        Toolbar toolbar = findViewById(R.id.toolbar_firebase);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout_firebase);
        NavigationView navigationView = findViewById(R.id.nav_view_firebase);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();



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
        getMenuInflater().inflate(R.menu.firebase_examples, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings_firebase) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {

        switch (menuItem.getItemId()){
            case R.id.autenticacionfirebase:
                //requestWindowFeature(Window.FEATURE_NO_TITLE);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new LoginFragment()).commit();
                getSupportActionBar().hide();

                getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
                break;

            case R.id.databasefirebase:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SendFragment()).commit();
                break;

        }




        DrawerLayout drawer = findViewById(R.id.drawer_layout_firebase);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }




}
