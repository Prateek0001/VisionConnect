package com.prateek.visionconnect.core;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;



import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Environment;
import android.provider.Settings;

import com.prateek.visionconnect.BuildConfig;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.TimeZone;


public class Util {
    Context activity_context;

    public Util(Context activityContext) {
        activity_context = activityContext;
    }


    public boolean isAvailableResolver(Context ctx, Intent intent) {
        boolean result = false;
        //# Issue #: 1069 - Failure delivering result ResultInfo{who=null, request=4000, result=-1, data=Intent { act=com.musicplayer.playermusic.action_camera }} to activity {com.musicplayer.playermusic/com.musicplayer.playermusic.activities.NowPlayingActivity}: java.lang.NullPointerException: Attempt to read from field 'android.content.pm.ApplicationInfo android.content.pm.ComponentInfo.applicationInfo' on a null object reference
        try {
            final PackageManager mgr = ctx.getPackageManager();
            if (mgr != null) {
                List<ResolveInfo> list =
                        mgr.queryIntentActivities(intent,
                                PackageManager.MATCH_DEFAULT_ONLY);
                result = list != null && list.size() > 0;
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        return result;
    }

    public void openAppSettingScreen(Activity mActivity) {
        Intent intent = new Intent();
        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.setData(Uri.parse("package:" + BuildConfig.APPLICATION_ID));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        intent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
        mActivity.startActivityForResult(intent, Constant.REQUEST_APP_SETTING);
    }

    public String getTempDirFullPath(Context context) {
        return Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + Constant.APP_DIR_TEMP;
    }

    public String getExtension(String filePath) {
        return filePath == null ? "" : filePath.substring(filePath.lastIndexOf(".") + 1);
    }

    public boolean isImage(String filePath) {
        String extension = getExtension(filePath);
        return Objects.equals(extension, "jpg") || Objects.equals(extension, "jpeg") || Objects.equals(extension, "png") || Objects.equals(extension, "tiff");
    }

    public boolean isImageFromExt(String extension) {
        return Objects.equals(extension, "jpg") || Objects.equals(extension, "jpeg") || Objects.equals(extension, "png") || Objects.equals(extension, "tiff");
    }

    public String convertDate(String date, SimpleDateFormat from, SimpleDateFormat to) {
        if (date != null && !date.isEmpty()) {
            Date serverDate;
            try {
                serverDate = from.parse(date);
                if (serverDate != null) {
                    return to.format(serverDate);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public String convertDateFromUTC(String date, SimpleDateFormat from, SimpleDateFormat to) {
        if (date != null && !date.isEmpty()) {
            Date serverDate;
            try {
                from.setTimeZone(TimeZone.getTimeZone("UTC"));
                serverDate = from.parse(date);
                to.setTimeZone(TimeZone.getDefault());
                if (serverDate != null) {
                    return to.format(serverDate);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public  String localToUTC(String timeStamp, SimpleDateFormat to) {
        if (timeStamp != null && !timeStamp.isEmpty()) {
            try {
                Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
                calendar.setTimeInMillis(Long.parseLong(timeStamp));
                to.setTimeZone(TimeZone.getTimeZone("UTC"));
                return to.format(calendar.getTime());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "";
    }
}

