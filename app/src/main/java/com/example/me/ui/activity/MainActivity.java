package com.example.me.ui.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.example.me.R;
import com.example.me.ui.fragment.Account;
import com.example.me.ui.fragment.Home;
import com.example.me.ui.fragment.Inbox;
import com.example.me.ui.fragment.ListTutor;
import com.example.me.ui.fragment.Schedule;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;


public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener, NavigationView.OnNavigationItemSelectedListener {


    private Toolbar toolbar;
    private BottomNavigationView bottomNavigationView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //TOOLBAR
//        toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
//        getSupportActionBar().setHomeButtonEnabled(true);
//        getSupportActionBar().setTitle("TWOH's Engineering");
//        getSupportActionBar().setSubtitle("Tutorial Material Design");
//        getSupportActionBar().setLogo(R.mipmap.ic_launcher);

        //NAVIGATION
        drawerLayout = findViewById(R.id.drawer_navigation);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        toggle = new ActionBarDrawerToggle(this, drawerLayout,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.setDrawerIndicatorEnabled(true);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //BOTTOM NAVIGAITON
        loadFragment(new Home());
        bottomNavigationView = findViewById(R.id.bn_main);
        bottomNavigationView.setOnNavigationItemSelectedListener((BottomNavigationView.OnNavigationItemSelectedListener) this);



//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });


    }

    //NAVIGATION
    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }

    }

    //TOOLBAR
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // autotoolbarmatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.

        //noinspection SimplifiableIfStatement
        switch (item.getItemId()){

            case R.id.action_settings:
                return true;
            case R.id.action_notifications:
                return true;
            default:
                return toggle.onOptionsItemSelected(item)||super.onOptionsItemSelected(item);

        }


    }

    //METHOD BOTTOM NAVIGATION
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            //BOTTOM NAVIGATION
            case R.id.home_menu:
                fragment = new Home();
                break;
            case R.id.schedule_menu:
                fragment = new Schedule();
                break;
//            case R.id.absent_menu:
//                fragment = new Absent();
//                break;
            case R.id.list_tutor_menu:
                fragment = new ListTutor();
                break;
            case R.id.inbox_menu:
                fragment = new Inbox();
                break;
            case R.id.profile_menu:
                fragment = new Account();
                break;
            //SIDEBAR NAVIGATION
            case R.id.nav_message:
                fragment = new Inbox();
                navigationView.setCheckedItem(R.id.nav_message);
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.nav_profile:
                fragment = new Account();
                navigationView.setCheckedItem(R.id.nav_profile);
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
        }
        return loadFragment(fragment);
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.flContainer, fragment)
                    .commit();
            return true;
        }
        return false;
    }



}
