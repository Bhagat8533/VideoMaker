package com.introvd.template.app.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.support.p021v4.app.NotificationCompat.BigPictureStyle;
import android.support.p021v4.app.NotificationCompat.BigTextStyle;
import android.support.p021v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bumptech.glide.load.C2267a;
import com.bumptech.glide.load.C2508m;
import com.bumptech.glide.load.p118b.C2396p;
import com.bumptech.glide.p111e.C2202f;
import com.bumptech.glide.p111e.C2203g;
import com.bumptech.glide.p111e.p112a.C2185h;
import com.introvd.template.R;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.common.glide.CustomCropSquareTransformation;
import com.introvd.template.editor.p252e.C5878a;
import com.introvd.template.explorer.extract.C7234b;
import com.p131c.p132a.C2570b;
import java.util.ArrayList;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;
import p037b.p050b.C1834l;
import p037b.p050b.C1838m;
import p037b.p050b.C1839n;
import p037b.p050b.C1840o;
import p037b.p050b.C1842q;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.app.notification.c */
public class C4074c {
    private static SparseArray<C4081b> buW = new SparseArray<>();

    /* renamed from: com.introvd.template.app.notification.c$a */
    public static class C4080a {
        public String bvc;
        public String bvd;
        public int bve;
        public String bvf;
        public String bvg;
        public String bvh;
        public String bvi;
        public String content;
        public String title;
        public String videoUrl;
    }

    /* renamed from: com.introvd.template.app.notification.c$b */
    private static class C4081b {
        ArrayList<String> bvj;
        int mCount;

        private C4081b() {
            this.mCount = 0;
            this.bvj = new ArrayList<>();
        }
    }

    /* renamed from: J */
    public static void m10121J(Context context, int i) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        switch (i) {
            case 2001:
                buW.remove(2001);
                notificationManager.cancel(1001);
                return;
            case 2002:
            case 2003:
            case 2004:
            case 2005:
                buW.remove(2002);
                buW.remove(2003);
                buW.remove(2004);
                buW.remove(2005);
                notificationManager.cancel(1002);
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    public static Notification m10122a(Context context, C4073b bVar) {
        Builder defaults = new Builder(context, "com.introvd.template.notification.default").setContentTitle(bVar.title).setContentText(bVar.content).setStyle(new BigTextStyle().bigText(bVar.content)).setPriority(2).setTicker(bVar.content).setAutoCancel(true).setDefaults(bVar.defaults);
        if (bVar.buU > 0) {
            defaults.setSmallIcon(bVar.buU);
        }
        if (bVar.largeIcon != null && !bVar.largeIcon.isRecycled()) {
            defaults.setLargeIcon(bVar.largeIcon);
        }
        if (bVar.buV != null && !bVar.buV.isRecycled()) {
            BigPictureStyle bigPictureStyle = new BigPictureStyle();
            bigPictureStyle.setBigContentTitle(bVar.title);
            bigPictureStyle.bigPicture(bVar.buV);
            defaults.setStyle(bigPictureStyle);
        }
        if (bVar.buS != null) {
            defaults.setContentIntent(bVar.buS);
        }
        if (bVar.buT != null) {
            defaults.setDeleteIntent(bVar.buT);
        }
        return defaults.build();
    }

    /* renamed from: a */
    public static Intent m10123a(Context context, C4080a aVar, String str) {
        Intent intent = new Intent(context, NotificationReceiver.class);
        intent.setAction("xiaoying_notification_clicked");
        intent.putExtra("event", str);
        intent.putExtra("pushType", aVar.bvf);
        intent.putExtra("pushMessageId", aVar.bvg);
        if (!TextUtils.isEmpty(aVar.bvh)) {
            intent.putExtra("pushName", aVar.bvh);
        }
        if (!TextUtils.isEmpty(aVar.bvi)) {
            intent.putExtra("pushMsgID", aVar.bvi);
        }
        return intent;
    }

    /* renamed from: a */
    public static void m10124a(Context context, int i, String str, C4080a aVar) {
        boolean z = false;
        if (i != 10001) {
            switch (i) {
                case 2001:
                case 2002:
                case 2003:
                case 2004:
                case 2005:
                    break;
            }
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = jSONObject.getJSONArray(C5878a.TAG);
            int optInt = jSONObject.optInt(C7234b.TAG);
            C4081b bVar = (C4081b) buW.get(i);
            if (bVar == null) {
                bVar = new C4081b();
            }
            if (jSONArray != null) {
                for (int length = jSONArray.length() - 1; length >= 0; length--) {
                    String string = jSONArray.getString(length);
                    if (bVar.bvj.contains(string)) {
                        bVar.bvj.remove(string);
                    }
                    bVar.bvj.add(0, string);
                }
            }
            bVar.mCount += optInt;
            if (bVar.mCount > 0) {
                aVar.content = "";
                if (i == 2001) {
                    aVar.title = context.getResources().getString(R.string.xiaoying_str_community_notification_add_fan_title);
                    if (bVar.mCount == 1) {
                        aVar.content = context.getResources().getString(R.string.xiaoying_str_community_notification_add_one_fan, new Object[]{bVar.bvj.get(0)});
                    } else {
                        aVar.content = context.getResources().getString(R.string.xiaoying_str_community_notification_add_multiple_fans, new Object[]{Integer.valueOf(bVar.mCount)});
                        z = true;
                    }
                } else {
                    aVar.title = context.getResources().getString(R.string.xiaoying_str_community_notification_video_title);
                    if (i != 10001) {
                        switch (i) {
                            case 2002:
                                aVar.content = context.getResources().getString(R.string.xiaoying_str_community_notification_comment_new, new Object[]{bVar.bvj.get(0)});
                                break;
                            case 2003:
                                aVar.content = context.getResources().getString(R.string.xiaoying_str_community_notification_comment_reply, new Object[]{bVar.bvj.get(0)});
                                break;
                            case 2004:
                                aVar.content = context.getResources().getString(R.string.xiaoying_str_community_notification_comment_like, new Object[]{bVar.bvj.get(0)});
                                break;
                            case 2005:
                                aVar.content = context.getResources().getString(R.string.xiaoying_str_community_notification_video_like, new Object[]{bVar.bvj.get(0)});
                                break;
                        }
                    } else {
                        aVar.content = context.getResources().getString(R.string.xiaoying_str_community_notification_im_new_msg);
                    }
                }
                if (i == 10001) {
                    i = 1001;
                    str = null;
                }
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put(C5878a.TAG, i);
                    String str2 = C7234b.TAG;
                    if (str == null) {
                        str = "";
                    }
                    jSONObject2.put(str2, str);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                m10125a(context, jSONObject2.toString(), z, aVar);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    /* renamed from: a */
    public static void m10125a(final Context context, String str, boolean z, final C4080a aVar) {
        Intent a = m10123a(context, aVar, str);
        a.putExtra("PushService", "ChatService");
        aVar.bve = (int) (((double) UUID.randomUUID().toString().hashCode()) - (Math.random() * 100.0d));
        int i = aVar.bve;
        PendingIntent broadcast = PendingIntent.getBroadcast(context, i, a, 134217728);
        PendingIntent broadcast2 = PendingIntent.getBroadcast(context, i, m10126b(context, aVar, str), 1073741824);
        int i2 = z ? -8 : -1;
        int i3 = R.mipmap.ic_launcher;
        if (VERSION.SDK_INT >= 21) {
            i3 = R.drawable.push_icon_notice_logo;
        }
        final C4073b bVar = new C4073b();
        bVar.title = aVar.title;
        bVar.content = aVar.content;
        bVar.defaults = i2;
        bVar.buS = broadcast;
        bVar.buT = broadcast2;
        bVar.buU = i3;
        C1834l.m5257ah(Boolean.valueOf(true)).mo10157d(C1820a.aVi()).mo10152c(C1820a.aVi()).mo10162e((C1518f<? super T, ? extends C1840o<? extends R>>) new C1518f<Boolean, C1840o<Object>>() {
            /* renamed from: h */
            public C1840o<Object> apply(Boolean bool) {
                return C4074c.m10127dK(aVar.bvc);
            }
        }).mo10162e((C1518f<? super T, ? extends C1840o<? extends R>>) new C1518f<Object, C1840o<Object>>() {
            /* renamed from: M */
            public C1840o<Object> apply(Object obj) {
                if (obj instanceof Bitmap) {
                    bVar.largeIcon = (Bitmap) obj;
                }
                return C4074c.m10127dK(aVar.bvd);
            }
        }).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<Object>() {
            /* renamed from: K */
            public void mo9886K(Object obj) {
                if (obj instanceof Bitmap) {
                    Bitmap bitmap = (Bitmap) obj;
                    if (!bitmap.isRecycled()) {
                        bVar.buV = bitmap;
                    }
                }
                C4071a.m10118a(context, aVar.bve, C4074c.m10122a(context, bVar));
            }

            /* renamed from: a */
            public void mo9877a(C1495b bVar) {
            }

            public void onComplete() {
            }

            public void onError(Throwable th) {
                C4071a.m10118a(context, aVar.bve, C4074c.m10122a(context, bVar));
            }
        });
    }

    /* renamed from: b */
    public static Intent m10126b(Context context, C4080a aVar, String str) {
        Intent intent = new Intent(context, NotificationReceiver.class);
        intent.putExtra("event", str);
        intent.putExtra("pushType", aVar.bvf);
        intent.putExtra("pushMessageId", aVar.bvg);
        if (!TextUtils.isEmpty(aVar.bvh)) {
            intent.putExtra("pushName", aVar.bvh);
        }
        if (!TextUtils.isEmpty(aVar.bvi)) {
            intent.putExtra("pushMsgID", aVar.bvi);
        }
        intent.putExtra("PushService", "ChatService");
        intent.setAction("xiaoying_notification_deleted");
        return intent;
    }

    /* access modifiers changed from: private */
    /* renamed from: dK */
    public static C1834l<Object> m10127dK(final String str) {
        return C1834l.m5254a((C1839n<T>) new C1839n<Object>() {
            /* renamed from: a */
            public void mo10177a(final C1838m<Object> mVar) {
                if (TextUtils.isEmpty(str)) {
                    mVar.mo9791K(new Object());
                } else {
                    C2570b.m7336hy(VivaBaseApplication.m8749FZ()).mo12205tP().mo12179aO(str).mo12182b(C2203g.m6255a((C2508m<Bitmap>) new CustomCropSquareTransformation<Bitmap>())).mo12176a(new C2202f<Bitmap>() {
                        /* renamed from: a */
                        public boolean mo11957a(Bitmap bitmap, Object obj, C2185h<Bitmap> hVar, C2267a aVar, boolean z) {
                            mVar.mo9791K(bitmap);
                            return false;
                        }

                        /* renamed from: a */
                        public boolean mo11956a(C2396p pVar, Object obj, C2185h<Bitmap> hVar, boolean z) {
                            mVar.mo9791K(new Object());
                            return false;
                        }
                    }).mo12189tM();
                }
            }
        });
    }
}
