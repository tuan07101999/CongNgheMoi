package com.newtech.android.chattrapp.ui.main.profile;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.newtech.android.chattrapp.MainActivity;
import com.newtech.android.chattrapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileFragment extends Fragment {
    @BindView(R.id.btnUpdateInfo)
    Button btnUpdateInfo;

    @BindView(R.id.btnUpdatePassword)
    Button btnUpdatePassword;

    @BindView(R.id.btnLogout)
    Button btnLogout;

    @BindView(R.id.appBarProfile)
    AppBarLayout mAppBarLayout;

    @BindView(R.id.imageUser)
    CircleImageView imageUser;

    @BindView(R.id.collapsingToolbarLayout)
    CollapsingToolbarLayout collapsingToolbarLayout;


    public ProfileFragment() {
    }

    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();
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
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        ButterKnife.bind(this, view);
        ((MainActivity)getActivity()).hideActionBar();
        collapsingToolbarLayout.setTitle("Tên người dùng");
        collapsingToolbarLayout.setExpandedTitleColor(ContextCompat.getColor(getActivity(),android.R.color.transparent));
        collapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.colorIcons));

        btnUpdateInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ProfileFragment.this)
                        .navigate(R.id.action_profileFragment_to_infoFragment);
            }
        });
        btnUpdatePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ProfileFragment.this)
                        .navigate(R.id.action_profileFragment_to_updatePasswordFragment);
            }
        });
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                        .setMessage(R.string.text_confirm_logout)
                        .setNegativeButton("KHÔNG", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        })
                        .setPositiveButton("CÓ", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                builder.show();
            }
        });

        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    isShow = true;
                    imageUser.setVisibility(View.GONE);


                } else if (isShow) {
                    isShow = false;
                    imageUser.setVisibility(View.VISIBLE);
                }
            }
        });
        return view;
    }


}