package com.prateek.visionconnect.core;


import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.prateek.visionconnect.R;


public class CustomProgressDialog extends Dialog {

    public CustomProgressDialog(@NonNull Context context) {
        super(context);
        init(context);
    }

    public CustomProgressDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        init(context);
    }

    protected CustomProgressDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        init(context);
    }

    void init(Context context) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().getDecorView().getRootView().setBackgroundResource(android.R.color.transparent);
        getWindow().setDimAmount(0.1f);
        getWindow().getDecorView().setOnApplyWindowInsetsListener((v, insets) -> {
            insets.consumeSystemWindowInsets();
            return insets;
        });

        View view = LayoutInflater.from(context).inflate(
                R.layout.dialog_custom, null
        );
        setContentView(view);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
    }
}
