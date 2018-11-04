package com.example.hn1226.myapplication.Upload;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.hn1226.myapplication.R;

import java.io.InputStream;

import static android.app.Activity.RESULT_OK;

public class Upload_Fragment extends Fragment {

    ImageView uploadImage;
    Button upload_button;
    Button upload_image;

    public Upload_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.upload_fragment, container, false);

        uploadImage = (ImageView) view.findViewById(R.id.upload_imageView);
        upload_button = (Button)view.findViewById(R.id.upload_button);
        upload_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(getActivity(), "Upload 버튼이 클릭됨", Toast.LENGTH_LONG).show();
            }
        });
        upload_image = (Button)view.findViewById(R.id.upload_image);
        upload_image.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                loadImage();
            }
        });

        return view;
    }

    private void loadImage () {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, 1);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                try {
                    InputStream in = getActivity().getContentResolver().openInputStream(data.getData());
                    Bitmap img = BitmapFactory.decodeStream(in);
                    Drawable drawable = new BitmapDrawable(img);
                    in.close();
                    upload_image.setBackground(drawable);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}