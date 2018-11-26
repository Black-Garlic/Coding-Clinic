package com.example.hn1226.myapplication.upload;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.hn1226.myapplication.R;
import com.example.hn1226.myapplication.db.FeedRoomDatabase;
import com.example.hn1226.myapplication.db.dao.FeedDao;
import com.example.hn1226.myapplication.model.Feed;

import java.io.InputStream;

import static android.app.Activity.RESULT_OK;

public class Upload_Fragment extends Fragment {

    ImageView uploadImage;
    Button upload_button;
    Button upload_image;
    String imagePath;
    EditText inputName;
    EditText inputText;

    public Upload_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.upload_fragment, container, false);

        inputText = (EditText) view.findViewById(R.id.edit_text);
        inputName = (EditText) view.findViewById(R.id.edit_title);
        uploadImage = (ImageView) view.findViewById(R.id.upload_imageView);
        upload_button = (Button) view.findViewById(R.id.upload_button);

        upload_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                upload();
                Log.d("upload fragment", "upload 실행 완료");
                Toast.makeText(getActivity(), "Upload", Toast.LENGTH_LONG).show();
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

    private void upload() {

        String name = inputName.getText().toString();
        String text = inputText.getText().toString();

        Log.d("upload fragment", "validate 전");
        if (!validate(name, text, imagePath)) { return; }
        Log.d("upload fragment", "validate 후");

        FeedRoomDatabase db = FeedRoomDatabase.getDatabase(getActivity());
        FeedDao dao = db.feedDao();

        Log.d("upload fragment", "feed 생성 전");
        Feed feed = new Feed(inputName.getText().toString(), inputText.getText().toString(), imagePath);
        Log.d("upload fragment", "feed 생성");
        dao.insert(feed);
    }

    private boolean validate(String name, String text, String imagePath) {
        if (TextUtils.isEmpty(name)) {
            Log.d("upload fragment", "name null");
            Toast.makeText(getActivity(), "Name is NULL", Toast.LENGTH_LONG).show();
            return false;
        }

        if (TextUtils.isEmpty(text)) {
            Log.d("upload fragment", "text null");
            Toast.makeText(getActivity(), "Text is NULL", Toast.LENGTH_LONG).show();
            return false;
        }
/*
        if (TextUtils.isEmpty(imagePath)) {
            Log.d("upload fragment", "image null");
            Toast.makeText(getActivity(), "Image is NULL" + name + text, Toast.LENGTH_LONG).show();
            return false;
        }
*/
        return true;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                try {
                    InputStream in = getActivity().getContentResolver().openInputStream(data.getData());
                    Bitmap img = BitmapFactory.decodeStream(in);
                    Drawable drawable = new BitmapDrawable(img);
                    upload_image.setBackground(drawable);
                    Log.d("upload fragment", "setting image" + data.getData());
                    imagePath = data.getData().toString();
                    Log.d("upload fragment", "setting image" + imagePath);
                    in.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}