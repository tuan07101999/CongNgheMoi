package com.newtech.android.chattrapp.ui.register;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.newtech.android.chattrapp.R;
import com.newtech.android.chattrapp.Validator;

public class FullNameFragment extends Fragment implements Validator {
    public FullNameFragment() {
    }
    public static FullNameFragment newInstance(String param1, String param2) {
        FullNameFragment fragment = new FullNameFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_full_name, container, false);
    }

    @Override
    public boolean isValidateInput() {
        return false;
    }
}