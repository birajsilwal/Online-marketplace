package com.example.mylobo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.mylobo.fragmentsMarketplace.ComposeFragmentMarketplace;
import com.example.mylobo.fragmentsMarketplace.PostsFragmentMarketplace;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Marketplace extends AppCompatActivity {

    public static final String TAG = "Marketplace";
    private BottomNavigationView bottomNavigationViewMp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final FragmentManager fragmentManager = getSupportFragmentManager();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marketplace);


        bottomNavigationViewMp =findViewById(R.id.bottom_navigation_marketplace);
        bottomNavigationViewMp.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                switch (item.getItemId()) {
                    case R.id.action_home_mp:
                        fragment = new PostsFragmentMarketplace();
                        break;
                    case R.id.action_compose_mp:
                    default:
                        fragment = new ComposeFragmentMarketplace();
                        break;
                }
                fragmentManager.beginTransaction().replace(R.id.flContainerMarketplace, fragment).commit();
                return true;
            }
        });
        // Set default selection
        bottomNavigationViewMp.setSelectedItemId(R.id.action_home_mp);
    }
}
