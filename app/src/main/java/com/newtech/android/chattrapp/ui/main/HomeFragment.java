package com.newtech.android.chattrapp.ui.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.newtech.android.chattrapp.MainActivity;
import com.newtech.android.chattrapp.QueryPreferences;
import com.newtech.android.chattrapp.R;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        NavHostFragment navHostFragment =
                (NavHostFragment) getChildFragmentManager().findFragmentById(R.id.nav_host_main);
        final NavController navController = navHostFragment.getNavController();
        final BottomNavigationView bottomNav = view.findViewById(R.id.bottomNavigationView);
        NavigationUI.setupWithNavController(bottomNav, navController);
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                bottomNav.setVisibility(View.VISIBLE);
                if(destination.getId()==R.id.profileFragment){
                    return;
                }
                if(destination.getId()==R.id.infoFragment){
                    bottomNav.setVisibility(View.GONE);
                    return;
                }
                setHasOptionsMenu(true);
                ((MainActivity) getActivity()).setupActionBar(QueryPreferences.getPrefUserId(getActivity()), false, null);
                Toast.makeText(getActivity(), HomeFragment.class.getSimpleName(), Toast.LENGTH_SHORT).show();

            }
        });
        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.main_toolbar_menu, menu);
    }
}