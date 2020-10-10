package com.newtech.android.chattrapp.ui.login;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.newtech.android.chattrapp.MainActivity;
import com.newtech.android.chattrapp.R;
import com.newtech.android.chattrapp.Utils;
import com.newtech.android.chattrapp.Validator;
import com.newtech.android.chattrapp.model.User;
import com.newtech.android.chattrapp.ui.register.RegisterFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginFragment extends Fragment implements Validator, ILoginView {
    @BindView(R.id.fieldPhone)
    TextInputLayout fieldPhoneNumber;

    @BindView(R.id.fieldPassword)
    TextInputLayout fieldPassword;

    @BindView(R.id.edtPhone)
    TextInputEditText edtPhoneNumber;

    @BindView(R.id.edtPassword)
    TextInputEditText edtPassword;

    @BindView(R.id.btnLogin)
    Button btnLogin;

    @BindView(R.id.btnGetPassword)
    Button btnGetPassword;

    LoginPresenter mLoginPresenter;
    private ProgressDialog mProgressDialog;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);
        mProgressDialog = new ProgressDialog(getActivity());
        ((MainActivity) getActivity()).setupActionBar(getString(R.string.text_login), true, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(LoginFragment.this).popBackStack();
            }
        });
        mLoginPresenter = new LoginPresenter(this);

        //Đăng nhập vào ứng dụng
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber = edtPhoneNumber.getText().toString();
                String password = edtPassword.getText().toString();
                if (Utils.isNetworkAvailable(getActivity()) && isValidateInput()) {
                    mLoginPresenter.login(phoneNumber, password);
                } else if (!Utils.isNetworkAvailable(getActivity())) {
                    Utils.showMessage(getActivity(), "Lỗi kết nối", "Mời kết nối internet để sử dụng ứng dụng").show();
                }

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
        return true;
    }

    @Override
    public void showLoading() {
        mProgressDialog.setTitle("Đang thực hiện đăng nhập");
        mProgressDialog.setMessage("Xin vui lòng đợi trong giây lát");
        mProgressDialog.show();

    }

    @Override
    public void hideLoading() {
        mProgressDialog.dismiss();
    }

    @Override
    public void navigateHome() {
        NavHostFragment.findNavController(LoginFragment.this).navigate(R.id.action_loginFragment_to_homeFragment);
    }

    @Override
    public void navigateGetPassword() {

    }

    @Override
    public void onErrorLoading(String message) {
        Utils.showMessage(getActivity(),"Lỗi",message).show();

    }
}