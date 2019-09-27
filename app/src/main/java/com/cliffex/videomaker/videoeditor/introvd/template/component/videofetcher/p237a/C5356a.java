package com.introvd.template.component.videofetcher.p237a;

import android.content.Context;
import com.introvd.template.component.videofetcher.R;
import java.util.Locale;

/* renamed from: com.introvd.template.component.videofetcher.a.a */
public class C5356a {
    /* renamed from: U */
    public static String m14584U(Context context, int i) {
        return i == 4 ? context.getString(R.string.video_fetcher_str_task_state_success) : i == 3 ? context.getString(R.string.video_fetcher_str_task_state_fail) : i == 1 ? context.getString(R.string.video_fetcher_str_download_state_pause) : context.getString(R.string.video_fetcher_str_task_state_running);
    }

    /* renamed from: af */
    public static String m14585af(float f) {
        int i = (int) f;
        if (i < 30 || i >= 70) {
            return String.format(Locale.ENGLISH, "%d", new Object[]{Integer.valueOf(i)});
        }
        return String.format(Locale.ENGLISH, "%.2f", new Object[]{Float.valueOf(f)});
    }
}
