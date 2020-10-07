package com.newtech.android.chattrapp.ui.main.updatepass;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.newtech.android.chattrapp.MainActivity;
import com.newtech.android.chattrapp.R;
import com.newtech.android.chattrapp.ui.register.InfoFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UpdatePasswordFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UpdatePasswordFragment extends Fragment {



    public UpdatePasswordFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_update_password, container, false);
        setupActionBar(view);
        return view;
    }
    private void setupActionBar(View view) {
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((MainActivity) getActivity()).setSupportActionBar(toolbar);
        ((MainActivity) getActivity()).getSupportActionBar().setTitle(R.string.button_update_password);
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(UpdatePasswordFragment.this).popBackStack();
            }
        });
    }
}