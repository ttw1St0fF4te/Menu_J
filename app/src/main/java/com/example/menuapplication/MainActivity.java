package com.example.menuapplication;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import com.example.menuapplication.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_nav);

        setFragment(new FirstFragment());
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();

                if (itemId == R.id.first_item) {
                    setFragment(new FirstFragment());
                    return true;
                } else if (itemId == R.id.second_item) {
                    setFragment(new SecondFragment());
                    return true;
                } else if (itemId == R.id.third_item) {
                    setFragment(new ThirdFragment());
                    return true;
                } else {
                    return false;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add("Lol");
        menu.add("Kek");
        menu.add(":D");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        FirstFragment firstFrag = new FirstFragment();

        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Toast.makeText(this, "Настройки выбраны", Toast.LENGTH_SHORT).show();
            return true;
        }
        else if (id == R.id.frag_first) {
            return true;
        }
        else if (id == R.id.frag_two) {
            return true;
        }
        else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void setFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_layout, fragment)
                .commit();
    }
}