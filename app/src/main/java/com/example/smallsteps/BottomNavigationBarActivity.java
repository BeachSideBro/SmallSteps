package com.example.smallsteps;

import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class BottomNavigationBarActivity extends AppCompatActivity {

    private AppBarLayout appBarLayout;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation_bar);

        appBarLayout = findViewById(R.id.appbar);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_bar);
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);

        toolbar.setTitle("Sponsor");
        appBarLayout.setElevation(10);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_bottom_navigation_bar, new SponsorFragment()).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu_pieces,menu);
        return true;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

            Fragment selectedFragment = null;

            switch(menuItem.getItemId()){
                case R.id.nav_tasks:
                    toolbar.setTitle("Tasks");
                    appBarLayout.setElevation(0);
                    selectedFragment = new TaskFragment();
                    break;
                case R.id.nav_pieces:
                    toolbar.setTitle("Pieces");
                    appBarLayout.setElevation(10);
                    selectedFragment = new PiecesFragment();
                    break;
                case R.id.nav_sponsor:
                    toolbar.setTitle("Sponsor");
                    appBarLayout.setElevation(10);
                    selectedFragment = new SponsorFragment();
                    break;
                case R.id.nav_meetings:
                    toolbar.setTitle("Meetings");
                    appBarLayout.setElevation(10);
                    selectedFragment = new MeetingsFragment();
                    break;
                case R.id.nav_achievements:
                    toolbar.setTitle("Achievements");
                    appBarLayout.setElevation(10);
                    selectedFragment = new AchievementsFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_bottom_navigation_bar, selectedFragment).commit();
            return true;
        }
    };
}
