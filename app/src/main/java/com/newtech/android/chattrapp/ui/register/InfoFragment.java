package com.newtech.android.chattrapp.ui.register;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;
import com.newtech.android.chattrapp.MainActivity;
import com.newtech.android.chattrapp.R;
import com.newtech.android.chattrapp.Utils;
import com.newtech.android.chattrapp.Validator;
import com.newtech.android.chattrapp.model.User;
import com.newtech.android.chattrapp.ui.login.ILoginView;
import com.newtech.android.chattrapp.ui.main.profile.ProfileFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InfoFragment extends Fragment implements Validator, IInfoView {


    @BindView(R.id.btnUpdate)
    Button btnUpdate;

    ProgressDialog mProgressDialog;

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
        mProgressDialog = new ProgressDialog(getActivity());
        ButterKnife.bind(this,view);
        ((MainActivity) getActivity()).setupActionBar(getString(R.string.button_update_info), false, null);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateAferUpdateSuccess();
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
        mProgressDialog.setTitle("Đang tiến hành cập nhật thông tin");
        mProgressDialog.setMessage("Vui lòng đợi trong giây lát");
        mProgressDialog.show();
    }

    @Override
    public void hideLoading() {
        mProgressDialog.dismiss();
    }

    @Override
    public void setUser(User user) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void navigateAferUpdateSuccess() {
            NavHostFragment.findNavController(InfoFragment.this).navigate(R.id.action_infoFragment_to_homeFragment);
    }


    @Override
    public void onErrorMessage(String msg) {
        Utils.showMessage(getActivity(),"Lỗi",msg);
    }

}