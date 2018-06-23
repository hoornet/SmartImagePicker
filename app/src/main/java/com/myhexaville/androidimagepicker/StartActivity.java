package com.myhexaville.androidimagepicker;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import androidx.databinding.DataBindingUtil;

import com.myhexaville.androidimagepicker.activity_example.ActivityExample;
import com.myhexaville.androidimagepicker.databinding.ActivityStartBinding;
import com.myhexaville.androidimagepicker.fragment_example.FragmentExample;


public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityStartBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_start);
        setSupportActionBar(binding.toolbar);
    }

    public void fragmentExample(View view) {
        startActivity(new Intent(this, FragmentExample.class));
    }

    public void activityExample(View view) {
        startActivity(new Intent(this, ActivityExample.class));
    }
}