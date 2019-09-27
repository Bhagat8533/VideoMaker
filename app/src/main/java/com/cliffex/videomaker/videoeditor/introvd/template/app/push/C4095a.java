package com.introvd.template.app.push;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.introvd.template.R;
import com.introvd.template.app.C4027k;
import com.introvd.template.app.notification.C4071a;
import com.introvd.template.app.notification.C4073b;
import com.introvd.template.app.notification.C4074c;
import com.introvd.template.app.notification.C4074c.C4080a;
import java.util.List;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import p037b.p050b.C1834l;
import p037b.p050b.C1842q;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.app.push.a */
class C4095a {
    /* renamed from: b */
    static void m10167b(final Context context, String str, boolean z, final C4080a aVar) {
        try {
            String optString = new JSONObject(C4027k.m9995dj(str).mJsonParam).optString("uri", "");
            if (!TextUtils.isEmpty(optString)) {
                Intent o = m10168o(Uri.parse(optString));
                final PackageManager packageManager = context.getPackageManager();
                final List queryIntentActivities = packageManager.queryIntentActivities(o, 0);
                if (queryIntentActivities != null && !queryIntentActivities.isEmpty()) {
                    aVar.bve = (int) (((double) UUID.randomUUID().toString().hashCode()) - (Math.random() * 100.0d));
                    PendingIntent activity = PendingIntent.getActivity(context, aVar.bve, o, 134217728);
                    PendingIntent broadcast = PendingIntent.getBroadcast(context, aVar.bve, C4074c.m10126b(context, aVar, str), 1073741824);
                    int i = -1;
                    if (z) {
                        i = -8;
                    }
                    int i2 = R.mipmap.ic_launcher;
                    if (VERSION.SDK_INT >= 21) {
                        i2 = R.drawable.push_icon_notice_logo;
                    }
                    final C4073b bVar = new C4073b();
                    bVar.title = aVar.title;
                    bVar.content = aVar.content;
                    bVar.defaults = i;
                    bVar.buS = activity;
                    bVar.buT = broadcast;
                    bVar.buU = i2;
                    C1834l.m5257ah(Boolean.valueOf(true)).mo10157d(C1820a.aVi()).mo10152c(C1820a.aVi()).mo10167f((C1518f<? super T, ? extends R>) new C1518f<Boolean, Bitmap>() {
                        /* renamed from: j */
                        public Bitmap apply(Boolean bool) throws Exception {
                            return ((BitmapDrawable) ((ResolveInfo) queryIntentActivities.get(0)).loadIcon(packageManager)).getBitmap();
                        }
                    }).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<Bitmap>() {
                        /* renamed from: a */
                        public void mo9877a(C1495b bVar) {
                        }

                        public void onComplete() {
                        }

                        public void onError(Throwable th) {
                            C4071a.m10118a(context, aVar.bve, C4074c.m10122a(context, bVar));
                        }

                        /* renamed from: q */
                        public void mo9886K(Bitmap bitmap) {
                            if (bitmap != null && !bitmap.isRecycled()) {
                                bVar.buV = bitmap;
                            }
                            C4071a.m10118a(context, aVar.bve, C4074c.m10122a(context, bVar));
                        }
                    });
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: o */
    private static Intent m10168o(Uri uri) {
        if (uri == null) {
            return null;
        }
        Intent intent = new Intent();
        intent.setData(uri);
        return intent;
    }
}
