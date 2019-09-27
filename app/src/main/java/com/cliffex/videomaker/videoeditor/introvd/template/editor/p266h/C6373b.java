package com.introvd.template.editor.p266h;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import com.introvd.template.common.ExAsyncTask;
import com.introvd.template.datacenter.SocialConstDef;

/* renamed from: com.introvd.template.editor.h.b */
public class C6373b {
    /* access modifiers changed from: private */
    /* renamed from: fA */
    public static void m18323fA(Context context) {
        context.getContentResolver().delete(SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_TEMPLATE_CARD), "updatetime < ? and updatetime<> 0 ", new String[]{String.valueOf(System.currentTimeMillis() - 172800000)});
    }

    /* access modifiers changed from: private */
    /* renamed from: fB */
    public static void m18324fB(Context context) {
        context.getContentResolver().delete(SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_VIDEO_CARD), "updatetime < ?", new String[]{String.valueOf(System.currentTimeMillis() - 172800000)});
    }

    /* access modifiers changed from: private */
    /* renamed from: fC */
    public static void m18325fC(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver.delete(SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_FOLLOW), "updatetime < ? AND flag = ?", new String[]{String.valueOf(currentTimeMillis - 86400000), String.valueOf(1)}) > 0) {
            contentResolver.delete(SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_KEYVALUEMAP), "key LIKE ?", new String[]{"FllowCount_%"});
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: fD */
    public static void m18326fD(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        ContentResolver contentResolver = context.getContentResolver();
        if (contentResolver.delete(SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_FOLLOW), "updatetime < ? AND flag = ?", new String[]{String.valueOf(currentTimeMillis - 86400000), String.valueOf(0)}) > 0) {
            contentResolver.delete(SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_KEYVALUEMAP), "key LIKE ?", new String[]{"FansCount_%"});
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: fE */
    public static void m18327fE(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        ContentResolver contentResolver = context.getContentResolver();
        Uri tableUri = SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_USERS_VIDEOS);
        if (contentResolver.delete(tableUri, "requestTime < ?", new String[]{String.valueOf(currentTimeMillis - 86400000)}) > 0) {
            contentResolver.delete(tableUri, null, null);
            contentResolver.delete(SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_KEYVALUEMAP), "key LIKE ?", new String[]{"UsersVideoCount_%"});
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: fF */
    public static void m18328fF(Context context) {
        context.getContentResolver().delete(SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_SEARCHED_VIDEOS), null, null);
    }

    /* renamed from: fz */
    public static void m18333fz(final Context context) {
        new ExAsyncTask<Void, Void, Void>() {
            /* access modifiers changed from: protected */
            public Void doInBackground(Void... voidArr) {
                C6373b.m18323fA(context);
                C6373b.m18324fB(context);
                C6373b.m18325fC(context);
                C6373b.m18326fD(context);
                C6373b.m18327fE(context);
                C6373b.m18328fF(context);
                return null;
            }
        }.execute((Params[]) new Void[0]);
    }
}
