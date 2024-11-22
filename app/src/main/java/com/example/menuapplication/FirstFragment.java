package com.example.menuapplication;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FirstFragment extends Fragment {
    private Button menuButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        menuButton = view.findViewById(R.id.menuButton);

        registerForContextMenu(menuButton);

        return view;
    }

    @Override
    public void onCreateContextMenu(@NonNull ContextMenu menu, @NonNull View v, @Nullable ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 1, 0, "😇");
        menu.add(0, 2, 1, "🥰");
        menu.add(0, 3, 2, "🙁");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                Toast.makeText(getContext(), "😇 выбран", Toast.LENGTH_SHORT).show();
                menuButton.setText(item.getTitle().toString());
                return true;
            case 2:
                Toast.makeText(getContext(), "🥰 выбран", Toast.LENGTH_SHORT).show();
                menuButton.setText(item.getTitle().toString());
                return true;
            case 3:
                Toast.makeText(getContext(), "🙁 выбран", Toast.LENGTH_SHORT).show();
                menuButton.setText(item.getTitle().toString());
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}
