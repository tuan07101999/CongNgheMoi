package com.newtech.android.chattrapp.ui.register;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.newtech.android.chattrapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OtpVerifyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OtpVerifyFragment extends Fragment {


    public OtpVerifyFragment() {
        // Required empty public constructor
    }

    public static OtpVerifyFragment newInstance(String param1, String param2) {
        OtpVerifyFragment fragment = new OtpVerifyFragment();
        Bundle args = new Bundle();
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
        return inflater.inflate(R.layout.fragment_otp_verify, container, false);
    }
}