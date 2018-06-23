package com.myhexaville.androidimagepicker.activity_example;

import android.content.Intent;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.myhexaville.androidimagepicker.R;
import com.myhexaville.androidimagepicker.databinding.MainLayoutBinding;
import com.myhexaville.smartimagepicker.ImagePicker;


public class ActivityExample extends AppCompatActivity {
    private static final String TAG = "ActivityExample";
    private ImagePicker imagePicker;
    private MainLayoutBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.main_layout);
        setSupportActionBar(binding.toolbar);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        imagePicker.handleActivityResult(resultCode,requestCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        imagePicker.handlePermission(requestCode, grantResults);
    }

    public void showAll(View view) {
        refreshImagePicker();
        imagePicker.choosePicture(true);
    }

    public void chooseFromGallery(View view) {
        refreshImagePicker();
        imagePicker.choosePicture(false);
    }

    public void openCamera(View view) {
        refreshImagePicker();
        imagePicker.openCamera();
    }

    private void refreshImagePicker() {
        imagePicker = new ImagePicker(this,
                null,
                imageUri -> {
                    Log.d(TAG, "refreshImagePicker: "+ imageUri);
                    Log.d(TAG, "refreshImagePicker: "+ imagePicker.getImageFile().getName());
                    binding.image.setImageURI(imageUri);
                });
        if (binding.withCrop.isChecked()) {
            imagePicker.setWithImageCrop(
                    Integer.parseInt(binding.aspectRatioX.getText().toString()),
                    Integer.parseInt(binding.aspectRatioY.getText().toString())
            );
        }
    }
}