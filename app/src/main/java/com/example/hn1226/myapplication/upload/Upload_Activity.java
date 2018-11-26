package com.example.hn1226.myapplication.upload;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.hn1226.myapplication.R;
import com.example.hn1226.myapplication.db.FeedRoomDatabase;
import com.example.hn1226.myapplication.db.dao.FeedDao;
import com.example.hn1226.myapplication.model.Feed;

import java.io.InputStream;

public class Upload_Activity extends AppCompatActivity {

    ImageView uploadImage;
    Button upload_button;
    Button upload_image;
    String imagePath;
    EditText inputName;
    EditText inputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upload_activity);

        inputText = (EditText)findViewById(R.id.edit_text);
        inputName = (EditText)findViewById(R.id.edit_title);
        uploadImage = (ImageView)findViewById(R.id.upload_imageView);
        upload_button = (Button)findViewById(R.id.upload_button);

        upload_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(getApplicationContext(), "Upload 버튼이 클릭됨", Toast.LENGTH_LONG).show();
                upload();
            }
        });
        upload_image = (Button)findViewById(R.id.upload_image);
        upload_image.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                loadImage();
            }
        });
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

        if (!validate(name, text, imagePath)) return;

        FeedRoomDatabase db = FeedRoomDatabase.getDatabase(getApplicationContext());
        FeedDao dao = db.feedDao();

        Feed feed = new Feed(inputName.getText().toString(), inputText.getText().toString(), imagePath);
        dao.insert(feed);
    }

    private boolean validate(String name, String text, String imagePath) {
        if (TextUtils.isEmpty(name)) {
            Toast.makeText(getApplicationContext(), "Name is NULL", Toast.LENGTH_LONG).show();
            return false;
        }

        if (TextUtils.isEmpty(text)) {
            Toast.makeText(getApplicationContext(), "Text is NULL", Toast.LENGTH_LONG).show();
            return false;
        }

        if (imagePath == null) {
            Toast.makeText(getApplicationContext(), "Image is NULL" + name + text, Toast.LENGTH_LONG).show();
            return false;
        }

        return true;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                try {
                    InputStream in = getContentResolver().openInputStream(data.getData());
                    Bitmap img = BitmapFactory.decodeStream(in);
                    Drawable drawable = new BitmapDrawable(img);
                    in.close();
                    upload_image.setBackground(drawable);

                    imagePath = getRealPathFromURI(data.getData());

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private String getRealPathFromURI(Uri contentURI) {
        String result;
        Cursor cursor = getContentResolver().query(contentURI, null, null, null, null);
        if (cursor == null) { // Source is Dropbox or other similar local file path
            result = contentURI.getPath();
        } else {
            cursor.moveToFirst();
            int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            result = cursor.getString(idx);
            cursor.close();
        }
        return result;
    }
}
