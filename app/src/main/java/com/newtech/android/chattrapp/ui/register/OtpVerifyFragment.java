package com.newtech.android.chattrapp.ui.register;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.newtech.android.chattrapp.MainActivity;
import com.newtech.android.chattrapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OtpVerifyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OtpVerifyFragment extends Fragment {

    @BindView(R.id.btnContinueOtp)
    Button btnContinueOtp;

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
        View view = inflater.inflate(R.layout.fragment_otp_verify, container, false);
        ButterKnife.bind(this, view);
        btnContinueOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(OtpVerifyFragment.this).navigate(R.id.action_otpVerifyFragment_to_infoFragment);
                ((MainActivity)getActivity()).getSupportActionBar().hide();
            }
        });
        return view;
    }
}