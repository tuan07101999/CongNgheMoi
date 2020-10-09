package com.newtech.android.chattrapp.ui.login;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.newtech.android.chattrapp.MainActivity;
import com.newtech.android.chattrapp.R;
import com.newtech.android.chattrapp.Validator;
import com.newtech.android.chattrapp.ui.register.RegisterFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
public class LoginFragment extends Fragment implements Validator {
    @BindView(R.id.btnLogin)
    Button btnLogin;

    @BindView(R.id.btnGetPassword)
    Button btnGetPassword;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);
        ((MainActivity) getActivity()).setupActionBar(getString(R.string.text_login), true, new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(LoginFragment.this)
                        .navigate(R.id.action_loginFragment_to_homeFragment);
            }
        });
        btnGetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(LoginFragment.this)
                        .navigate(R.id.action_loginFragment_to_otpVerifyFragment);
            }
        });


        return view;
    }

    @Override
    public boolean isValidateInput() {
        return false;
    }
}