package com.prateek.visionconnect.core;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class Constant {
    public static final SimpleDateFormat serverDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S", Locale.getDefault());
    public static final SimpleDateFormat serverDateFormat1 = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss aa", Locale.getDefault());
    public static final SimpleDateFormat serverDateFormat2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault());
    public static final SimpleDateFormat onlyDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
    public static final SimpleDateFormat onlyTimeFormat = new SimpleDateFormat("hh:mm aa", Locale.getDefault());
    public static final SimpleDateFormat dateTimeFormat = new SimpleDateFormat("MMM dd, yyyy 'at' hh:mm aa", Locale.getDefault());

    public static final Integer REQUEST_APP_SETTING = 10001;
    public static final String APP_DIR_TEMP = "VisionConnect";
}
