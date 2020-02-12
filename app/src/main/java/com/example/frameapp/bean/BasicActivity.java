package com.example.frameapp.bean;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 基础Activity
 * 2020-02-12
 *
 * @author
 */
public class BasicActivity extends AppCompatActivity {
    public Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
    }
}
