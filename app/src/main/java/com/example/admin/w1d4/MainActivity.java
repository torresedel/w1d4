package com.example.admin.w1d4;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;

import static android.R.attr.button;

public class MainActivity extends AppCompatActivity {

    ImageView ivCameraImg;
    static final int CAM_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivCameraImg = (ImageView) findViewById(R.id.ivCameraImg);

    }

    protected Bitmap img = null;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Bundle extras = data.getExtras();
        img = (Bitmap) extras.get("data");
        ivCameraImg.setImageBitmap(img);
    }

    public void captureImg(View view) {
        Intent intentCam = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intentCam, CAM_REQUEST);
    }

    public void calculatorActivity(View view) {
        Intent intentAct = new Intent(this, SecondActivity.class);
        startActivity(intentAct);
    }
}
