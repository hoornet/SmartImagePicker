package com.myhexaville.androidimagepicker.fragment_example;

import android.content.Intent;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;

import com.myhexaville.androidimagepicker.R;
import com.myhexaville.androidimagepicker.databinding.FragmentActivityBinding;

import java.util.List;


public class FragmentExample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FragmentActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.fragment_activity);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        if (fragments != null) {
            for (Fragment f : fragments) {
                if (f instanceof ImagePickerFragment) {
                    f.onActivityResult(requestCode, resultCode, data);
                }
            }
        }
    }
}