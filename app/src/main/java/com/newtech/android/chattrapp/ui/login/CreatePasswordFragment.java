package com.newtech.android.chattrapp.ui.login;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.newtech.android.chattrapp.MainActivity;
import com.newtech.android.chattrapp.R;
import com.newtech.android.chattrapp.Validator;
import com.newtech.android.chattrapp.model.User;
import com.newtech.android.chattrapp.ui.main.profile.ProfileFragment;
import com.newtech.android.chattrapp.ui.register.RegisterFragment;


public class CreatePasswordFragment extends Fragment implements Validator {


    public CreatePasswordFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_password, container, false);
        ((MainActivity)getActivity()).setupActionBar(getString(R.string.text_create_new_password), true, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(CreatePasswordFragment.this).popBackStack();
            }
        });
        return view;
    }

    @Override
    public boolean isValidateInput() {
        return false;
    }


}