package com.newtech.android.chattrapp.ui.register;

import android.os.Bundle;

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
import com.newtech.android.chattrapp.ui.main.profile.ProfileFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InfoFragment extends Fragment implements Validator {
    @BindView(R.id.btnUpdate)
    Button btnUpdate;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info, container, false);
        ButterKnife.bind(this,view);
        ((MainActivity) getActivity()).setupActionBar(getString(R.string.button_update_info), false, null);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(InfoFragment.this).popBackStack();
            }
        });
        return view;
    }


    @Override
    public boolean isValidateInput() {
        return false;
    }
}