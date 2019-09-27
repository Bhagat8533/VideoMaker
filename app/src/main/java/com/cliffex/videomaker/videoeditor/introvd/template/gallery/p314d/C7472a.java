package com.introvd.template.gallery.p314d;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import com.introvd.template.common.Constants;
import com.introvd.template.common.DeviceInfo;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.explorer.p298c.C7149c;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.videoeditor.model.ExtMediaItem;
import com.introvd.template.xygallery.R;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/* renamed from: com.introvd.template.gallery.d.a */
public class C7472a {
    /* renamed from: a */
    public static void m22079a(final Context context, final C7149c cVar) {
        new Thread() {
            public void run() {
                if (cVar != null) {
                    int groupCount = cVar.getGroupCount();
                    for (int i = 0; i < groupCount; i++) {
                        int qD = cVar.mo31619qD(i);
                        for (int i2 = 0; i2 < qD; i2++) {
                            ExtMediaItem de = cVar.mo31616de(i, i2);
                            if (de != null) {
                                C7472a.m22080a(context, de);
                            }
                        }
                    }
                }
            }
        }.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static void m22080a(Context context, ExtMediaItem extMediaItem) {
        Uri tableUri = SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_MEDIA_ITEM);
        ContentValues contentValues = new ContentValues();
        contentValues.put("flag", Integer.valueOf(0));
        context.getApplicationContext().getContentResolver().update(tableUri, contentValues, "_data = ?", new String[]{extMediaItem.path});
    }

    /* renamed from: ag */
    public static String m22081ag(Context context, int i) {
        Resources resources = context.getResources();
        String str = "";
        switch (i) {
            case 1:
                return resources.getString(R.string.xiaoying_str_com_date_month_january);
            case 2:
                return resources.getString(R.string.xiaoying_str_com_date_month_february);
            case 3:
                return resources.getString(R.string.xiaoying_str_com_date_month_march);
            case 4:
                return resources.getString(R.string.xiaoying_str_com_date_month_april);
            case 5:
                return resources.getString(R.string.xiaoying_str_com_date_month_may);
            case 6:
                return resources.getString(R.string.xiaoying_str_com_date_month_june);
            case 7:
                return resources.getString(R.string.xiaoying_str_com_date_month_july);
            case 8:
                return resources.getString(R.string.xiaoying_str_com_date_month_august);
            case 9:
                return resources.getString(R.string.xiaoying_str_com_date_month_september);
            case 10:
                return resources.getString(R.string.xiaoying_str_com_date_month_october);
            case 11:
                return resources.getString(R.string.xiaoying_str_com_date_month_november);
            case 12:
                return resources.getString(R.string.xiaoying_str_com_date_month_december);
            default:
                return str;
        }
    }

    /* renamed from: bW */
    public static String m22083bW(Context context, String str) {
        String str2;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Resources resources = context.getResources();
        String str3 = "";
        Calendar instance = Calendar.getInstance();
        int i = instance.get(1);
        int i2 = instance.get(2);
        int i3 = instance.get(5);
        instance.add(5, -1);
        int i4 = instance.get(1);
        int i5 = instance.get(2);
        int i6 = instance.get(5);
        try {
            instance.setTime(simpleDateFormat.parse(str));
            int i7 = instance.get(1);
            int i8 = instance.get(2);
            int i9 = instance.get(5);
            if (i7 == i && i8 == i2 && i9 == i3) {
                str2 = resources.getString(R.string.xiaoying_str_com_time_today);
            } else if (i7 == i4 && i8 == i5 && i9 == i6) {
                str2 = resources.getString(R.string.xiaoying_str_com_time_yesterday);
            } else {
                int i10 = i8 + 1;
                StringBuilder sb = new StringBuilder();
                sb.append("");
                sb.append(m22081ag(context, i10));
                sb.append(" ");
                sb.append("");
                sb.append(i9);
                sb.append(", ");
                sb.append(i7);
                str2 = sb.toString();
            }
            return str2;
        } catch (ParseException e) {
            e.printStackTrace();
            return str3;
        }
    }

    /* renamed from: gc */
    public static int m22084gc(Context context) {
        int O = ((DeviceInfo.getScreenSize(context).width - C4583d.m11670O(context, 13)) / 4) / 2;
        int i = Constants.getDeviceDensity() <= 1.5f ? ((int) (((float) O) * 2.5f)) + context.getResources().getDimensionPixelSize(R.dimen.story_board_grid_verticalSpacing) : ((float) Constants.getScreenSize().width) / ((float) Constants.getScreenSize().height) > 0.648f ? (O * 2) + context.getResources().getDimensionPixelSize(R.dimen.story_board_grid_verticalSpacing) : (O * 3) + (context.getResources().getDimensionPixelSize(R.dimen.story_board_grid_verticalSpacing) * 2);
        return i + C4583d.m11670O(context, 50);
    }
}
