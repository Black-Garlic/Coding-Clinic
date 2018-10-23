package com.example.hn1226.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Profile_Fragment extends Fragment {

    public Profile_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.profile_fragment, container, false);
        final TextView textView = (TextView) view.findViewById(R.id.fragView);

        textView.setText("User : " + getString(R.string.myName));
        textView.append("\nDepartment : " + getString(R.string.myDep));
        textView.append("\nStuNum : " + getString(R.string.myStuNum));
        textView.append("\nMail : " + getString(R.string.myMail));
        textView.append("\nPhone : " + getString(R.string.myPhone));
        return view;
    }
}