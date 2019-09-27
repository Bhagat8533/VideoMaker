package com.introvd.template.explorer.p300e;

import android.content.Context;
import android.os.Environment;
import android.os.Process;
import com.introvd.template.common.ExAsyncTask;
import com.introvd.template.explorer.model.GROUP_MEDIA_TYPE;
import com.introvd.template.explorer.p298c.C7149c;
import com.introvd.template.p203b.C4584e;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.app.IAppService;
import com.introvd.template.videoeditor.model.BROWSE_TYPE;
import com.introvd.template.videoeditor.model.MEDIA_TYPE;
import com.introvd.template.videoeditor.model.MediaGroupItem;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* renamed from: com.introvd.template.explorer.e.e */
public class C7212e extends ExAsyncTask<Object, Void, Integer> {
    private Context context;
    private C7149c dqZ = null;

    public C7212e(Context context2) {
        this.context = context2;
    }

    /* renamed from: b */
    private MediaGroupItem m21294b(C7149c cVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).toString());
        sb.append(File.separator);
        sb.append("Camera/");
        String sb2 = sb.toString();
        int groupCount = cVar.getGroupCount();
        MediaGroupItem mediaGroupItem = null;
        for (int i = 0; i < groupCount; i++) {
            mediaGroupItem = cVar.mo31620qE(i);
            if (mediaGroupItem != null && mediaGroupItem.strParentPath.equals(sb2)) {
                break;
            }
        }
        return mediaGroupItem;
    }

    /* renamed from: b */
    private Date m21295b(Date date, int i) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(6, i);
        return instance.getTime();
    }

    /* renamed from: c */
    private int m21296c(C7149c cVar) {
        Date c = C4584e.m11680c(new Date());
        ArrayList<Date> arrayList = new ArrayList<>();
        arrayList.add(c);
        arrayList.add(m21295b(c, -1));
        arrayList.add(m21295b(c, -2));
        int i = 0;
        for (Date d : arrayList) {
            String d2 = m21297d(d);
            int i2 = i;
            int i3 = 0;
            while (i3 < cVar.getGroupCount() && i3 < arrayList.size()) {
                MediaGroupItem qE = cVar.mo31620qE(i3);
                if (!(d2 == null || qE == null || !d2.equals(qE.strGroupDisplayName))) {
                    i2 += qE.mediaItemList.size();
                }
                i3++;
            }
            i = i2;
        }
        return i;
    }

    /* renamed from: d */
    private String m21297d(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(date);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public Integer doInBackground(Object... objArr) {
        Process.setThreadPriority(0);
        this.dqZ = new C7149c();
        this.dqZ.mo31610a(this.context, MEDIA_TYPE.MEDIA_TYPE_FROM_MEDIASTORE, BROWSE_TYPE.PHOTO);
        MediaGroupItem b = m21294b(this.dqZ);
        if (b == null) {
            return Integer.valueOf(0);
        }
        this.dqZ = new C7149c();
        this.dqZ.mo31609a(GROUP_MEDIA_TYPE.GROUP_MEDIA_TYPE_DATE);
        this.dqZ.mo31611a(this.context, b);
        return Integer.valueOf(m21296c(this.dqZ));
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public void onPostExecute(Integer num) {
        if (num.intValue() >= 10) {
            IAppService iAppService = (IAppService) BizServiceManager.getService(IAppService.class);
            if (iAppService != null) {
                iAppService.showNotification(this.context, 4098, "");
            }
        }
        if (this.dqZ != null) {
            this.dqZ.unInit();
            this.dqZ = null;
        }
        super.onPostExecute(num);
    }

    /* access modifiers changed from: protected */
    public void onCancelled() {
        if (this.dqZ != null) {
            this.dqZ.unInit();
            this.dqZ = null;
        }
        super.onCancelled();
    }
}
