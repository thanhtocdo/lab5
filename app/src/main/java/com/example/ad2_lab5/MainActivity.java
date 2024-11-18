package com.example.ad2_lab5;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    Toolbar toolbar;
    NavigationView navView;
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerLayout = findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(MainActivity.this, drawerLayout, toolbar, R.string.open, R.string.close);

        drawerToggle.setDrawerIndicatorEnabled(true);
        drawerToggle.syncState();
        drawerLayout.addDrawerListener(drawerToggle);
        navView = findViewById(R.id.nav_view);

        navView.setNavigationItemSelectedListener(this);



    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment;
        if (item.getItemId() == R.id.menu_item) {
            Toast.makeText(getApplicationContext(), "Home", Toast.LENGTH_SHORT).show();
            toolbar.setTitle("Trang chu");
            fragment = FragmentHome.newInstance();

            getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, fragment).commit();
        } else if (item.getItemId() == R.id.item_bookmark) {
            Toast.makeText(getApplicationContext(), "Bookmark", Toast.LENGTH_SHORT).show();
            toolbar.setTitle("Bookmark");

            fragment = FragmentBookmark.newInstance();

            getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, fragment).commit();
        } else if (item.getItemId() == R.id.item_settings) {
            Toast.makeText(getApplicationContext(), "Settings", Toast.LENGTH_SHORT).show();
            toolbar.setTitle("Settings");

            fragment = FragmentSettings.newInstance();

            getSupportFragmentManager().beginTransaction().replace(R.id.frame_content, fragment).commit();
        } else if (item.getItemId() == R.id.item_logout) {
            Toast.makeText(getApplicationContext(), "Logout", Toast.LENGTH_SHORT).show();
            toolbar.setTitle("Logout");
        }


        drawerLayout.closeDrawers();
        return true;
    }
}