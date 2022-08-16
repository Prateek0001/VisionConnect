package com.prateek.visionconnect.fragment;



import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.prateek.visionconnect.core.CustomProgressDialog;
import com.prateek.visionconnect.core.PreferenceUtil;
import com.prateek.visionconnect.core.Util;


public class BaseFragment extends Fragment implements View.OnClickListener {
    protected Context mActivity;
    protected Util util;
    protected CustomProgressDialog mDialog;
    protected PreferenceUtil preferenceUtil;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = getActivity();
        util = new Util(mActivity);
        mDialog = new CustomProgressDialog(requireActivity());
        preferenceUtil = new PreferenceUtil();
    }

    public void setUpClicks(View... views) {
        for (View v : views) {
            v.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {

    }
}
