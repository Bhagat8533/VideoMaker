package com.introvd.template.starvlogs.logfirebase;

import android.app.Activity;
import android.os.Bundle;
import com.google.firebase.analytics.FirebaseAnalytics;

public class LogFirebase {
    public static void logEvent(Activity activity, String name, String key, String value) {
        FirebaseAnalytics mFirebaseAnalytics = FirebaseAnalytics.getInstance(activity);
        Bundle bundle = new Bundle();
        bundle.putString(key, value);
        mFirebaseAnalytics.logEvent(name, bundle);
    }

    public static void logEventOnResume(Activity activity, String name, String key) {
        FirebaseAnalytics mFirebaseAnalytics = FirebaseAnalytics.getInstance(activity);
        Bundle bundle = new Bundle();
        bundle.putString(key, "OnResume");
        mFirebaseAnalytics.logEvent(name, bundle);
    }

    public static void logEventOnCreate(Activity activity, String name, String key) {
        FirebaseAnalytics mFirebaseAnalytics = FirebaseAnalytics.getInstance(activity);
        Bundle bundle = new Bundle();
        bundle.putString(key, "OnCreate");
        mFirebaseAnalytics.logEvent(name, bundle);
    }

    public static void logEventOnPause(Activity activity, String name, String key) {
        FirebaseAnalytics mFirebaseAnalytics = FirebaseAnalytics.getInstance(activity);
        Bundle bundle = new Bundle();
        bundle.putString(key, "OnPause");
        mFirebaseAnalytics.logEvent(name, bundle);
    }
}
