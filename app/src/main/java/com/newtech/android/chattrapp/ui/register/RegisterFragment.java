package com.newtech.android.chattrapp.ui.register;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.newtech.android.chattrapp.MainActivity;
import com.newtech.android.chattrapp.R;
import com.newtech.android.chattrapp.ui.login.LoginFragment;
import com.newtech.android.chattrapp.ui.welcome.WelcomeFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterFragment extends Fragment {
    private int fragmentId;

    public RegisterFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        //Thiết lập action bar cho màn hình
        ((MainActivity) getActivity()).setupActionBar(getString(R.string.text_register), true, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(RegisterFragment.this).popBackStack();
            }
        });
        return view;
    }

}