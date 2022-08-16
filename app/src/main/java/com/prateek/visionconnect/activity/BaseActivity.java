package com.prateek.visionconnect.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.prateek.visionconnect.core.CustomProgressDialog;
import com.prateek.visionconnect.core.PreferenceUtil;
import com.prateek.visionconnect.core.Util;


public class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    protected Context mActivity;
    protected Util util;
    protected CustomProgressDialog mDialog;
    protected PreferenceUtil preferenceUtil;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        util = new Util(this);
        mDialog = new CustomProgressDialog(this);
        preferenceUtil = new PreferenceUtil();
    }

    void setUpClicks(View... views) {
        for (View v : views) {
            v.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {

    }
}

