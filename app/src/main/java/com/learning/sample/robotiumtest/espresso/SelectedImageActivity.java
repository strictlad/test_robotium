package com.learning.sample.robotiumtest.espresso;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.learning.sample.robotiumtest.R;

import java.io.IOException;

public class SelectedImageActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int REQUEST_IMAGE_SELECT = 1001;

    ImageView imvSelected;
    Button btnOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_image);

        imvSelected = (ImageView) findViewById(R.id.imv_selected);
        btnOpen = (Button) findViewById(R.id.btn_open_photo);
        btnOpen.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_open_photo:
                selectImage();
                break;
            default:
                break;
        }
    }

    private void selectImage() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, REQUEST_IMAGE_SELECT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //Get the result from other app
        if (requestCode == REQUEST_IMAGE_SELECT && resultCode == Activity.RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImage);
                imvSelected.setImageBitmap(bitmap);
                imvSelected.setVisibility(View.VISIBLE);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
