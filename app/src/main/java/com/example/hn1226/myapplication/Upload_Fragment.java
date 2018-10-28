package com.example.hn1226.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Upload_Fragment extends Fragment {

    public Upload_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.upload_fragment, container, false);

        Button upload_button = (Button)view.findViewById(R.id.upload_button);
        upload_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(getActivity(), "Upload 버튼이 클릭됨", Toast.LENGTH_LONG).show();
            }
        });
        Button upload_image = (Button)view.findViewById(R.id.upload_image);
        upload_image.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(getActivity(), "Upload Image 버튼이 클릭됨", Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }


}