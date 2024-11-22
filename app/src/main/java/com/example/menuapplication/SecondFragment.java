package com.example.menuapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class SecondFragment extends Fragment {
    int counter = 0;
    Button menuButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        menuButton = view.findViewById(R.id.menu_item_counter);
        menuButton.setOnClickListener(v -> showPopupMenu(v));

        return view;
    }

    private void showPopupMenu(View view) {
        PopupMenu popupMenu = new PopupMenu(requireContext(), view);
        MenuInflater inflater = popupMenu.getMenuInflater();
        inflater.inflate(R.menu.popup_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.add_num) {
                    counter++;
                    menuButton.setText(String.valueOf(counter));
                    return true;
                }
                else if (itemId == R.id.decr_num) {
                    counter--;
                    menuButton.setText(String.valueOf(counter));
                    return true;
                }
                else {
                    return false;
                }
            }
        });

        popupMenu.show();
    }
}