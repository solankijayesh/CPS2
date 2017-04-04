package com.example.damo.djg;

/**
 * Created by DamO on 24-03-2017.
 */

import android.os.Bundle;

/**
 * Created by admin on 13-12-2016.
 */
public final class RemoteNotification {
    public static final int TYPE_STACK = -1000;

    protected Bundle mExtrasBundle;
    protected int mUserNotificationId = -1;

    protected RemoteNotification() {}

    public RemoteNotification(Bundle bundle) {
        mExtrasBundle = bundle;
        mUserNotificationId = (int)(System.currentTimeMillis() / 1000);
    }

    public Bundle getBundle() {
        if (mExtrasBundle == null) {
            mExtrasBundle = new Bundle();
        }
        return mExtrasBundle;
    }

    public String getAppName() {
        return getBundle().getString("app_name");
    }

    public String getErrorName() {
        return getBundle().getString("title");
    }

    public String getActivityText() {
        return getBundle().getString("activity_text");
    }

    public String getUrl() {
        return getBundle().getString("url");
    }

    public String getUserNotificationGroup() {
        // error URLs are unique, and can be used to group
        // related activities in the notification drawer
        return getUrl();
    }

    public int getUserNotificationId() {

        return mUserNotificationId;
    }
}
