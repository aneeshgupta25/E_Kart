package com.example.acmegradefinalassessment.presentation.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.acmegradefinalassessment.R;
import com.example.acmegradefinalassessment.presentation.activity.MainActivity;

public class AccountFragment extends Fragment {

    TextView profileNameTextView, profileEmailTextView;
    MainActivity activity;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_account, container, false);

        init(view);
        setValues();
        return view;
    }

    private void setValues() {
        profileEmailTextView.setText(activity.getRepository().getUserEmail());
        profileNameTextView.setText(activity.getRepository().getUserName());
    }

    private void init(View view) {
        activity = (MainActivity) getActivity();
        profileNameTextView = view.findViewById(R.id.profileNameTextView);
        profileEmailTextView = view.findViewById(R.id.profileEmailTextView);
    }
}