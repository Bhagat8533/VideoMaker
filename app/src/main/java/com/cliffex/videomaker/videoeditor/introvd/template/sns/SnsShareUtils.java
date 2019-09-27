package com.introvd.template.sns;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.biii.aiii.aiii.constants.ConstantsAPI.Token;
import com.bumptech.glide.C2176e;
import com.introvd.template.common.ExAsyncTask;
import com.introvd.template.p203b.C4586g;
import com.introvd.template.sns.biz.C8582R;
import com.ironsource.sdk.constants.Constants.RequestParameters;
import com.quvideo.sns.base.p228b.C4979b;
import java.util.concurrent.TimeUnit;
import p503cz.msebera.android.httpclient.HttpHost;

public class SnsShareUtils {

    interface ILoadImageCallback {
        void loadImageOver(String str);
    }

    public static String addToAppParams(int i, String str, String str2) {
        String str3;
        String str4;
        String str5 = "toApp=";
        switch (i) {
            case 1:
                StringBuilder sb = new StringBuilder();
                sb.append(str5);
                sb.append("weibo");
                str3 = sb.toString();
                break;
            case 4:
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str5);
                sb2.append("email");
                str3 = sb2.toString();
                break;
            case 6:
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str5);
                sb3.append("moments");
                str3 = sb3.toString();
                break;
            case 7:
                StringBuilder sb4 = new StringBuilder();
                sb4.append(str5);
                sb4.append(Token.WX_TOKEN_PLATFORMID_VALUE);
                str3 = sb4.toString();
                break;
            case 10:
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str5);
                sb5.append("qzone");
                str3 = sb5.toString();
                break;
            case 11:
                StringBuilder sb6 = new StringBuilder();
                sb6.append(str5);
                sb6.append("QQ");
                str3 = sb6.toString();
                break;
            case 26:
                StringBuilder sb7 = new StringBuilder();
                sb7.append(str5);
                sb7.append("Youtube");
                str3 = sb7.toString();
                break;
            case 28:
                StringBuilder sb8 = new StringBuilder();
                sb8.append(str5);
                sb8.append("Facebook");
                str3 = sb8.toString();
                break;
            case 29:
                StringBuilder sb9 = new StringBuilder();
                sb9.append(str5);
                sb9.append("Twitter");
                str3 = sb9.toString();
                break;
            case 31:
                StringBuilder sb10 = new StringBuilder();
                sb10.append(str5);
                sb10.append("Instagram");
                str3 = sb10.toString();
                break;
            case 32:
                StringBuilder sb11 = new StringBuilder();
                sb11.append(str5);
                sb11.append("WhatsApp");
                str3 = sb11.toString();
                break;
            case 33:
                StringBuilder sb12 = new StringBuilder();
                sb12.append(str5);
                sb12.append("FBMessenger");
                str3 = sb12.toString();
                break;
            case 38:
                StringBuilder sb13 = new StringBuilder();
                sb13.append(str5);
                sb13.append("Line");
                str3 = sb13.toString();
                break;
            case 44:
                StringBuilder sb14 = new StringBuilder();
                sb14.append(str5);
                sb14.append("Vine");
                str3 = sb14.toString();
                break;
            case 103:
                StringBuilder sb15 = new StringBuilder();
                sb15.append(str5);
                sb15.append("copylink");
                str3 = sb15.toString();
                break;
            default:
                str3 = "";
                break;
        }
        if (str.contains(str3)) {
            return str;
        }
        if (str.contains("?")) {
            StringBuilder sb16 = new StringBuilder();
            sb16.append(RequestParameters.AMPERSAND);
            sb16.append(str3);
            str4 = sb16.toString();
        } else {
            StringBuilder sb17 = new StringBuilder();
            sb17.append("?");
            sb17.append(str3);
            str4 = sb17.toString();
        }
        StringBuilder sb18 = new StringBuilder();
        sb18.append(str);
        sb18.append(str4);
        String sb19 = sb18.toString();
        StringBuilder sb20 = new StringBuilder();
        sb20.append(sb19);
        sb20.append("&af_channel=");
        sb20.append(formatFrom(str2));
        return sb20.toString();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0075 A[SYNTHETIC, Splitter:B:28:0x0075] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x007d A[SYNTHETIC, Splitter:B:35:0x007d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String drawableToFile(android.graphics.drawable.Drawable r5) {
        /*
            r0 = 0
            if (r5 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r1 = "share_img_temp"
            java.lang.String r2 = com.introvd.template.common.CommonConfigure.getAppCacheDir()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x006e, all -> 0x006c }
            r3.<init>()     // Catch:{ IOException -> 0x006e, all -> 0x006c }
            r3.append(r2)     // Catch:{ IOException -> 0x006e, all -> 0x006c }
            java.lang.String r2 = ".thumbnail"
            r3.append(r2)     // Catch:{ IOException -> 0x006e, all -> 0x006c }
            java.lang.String r2 = java.io.File.separator     // Catch:{ IOException -> 0x006e, all -> 0x006c }
            r3.append(r2)     // Catch:{ IOException -> 0x006e, all -> 0x006c }
            java.lang.String r2 = r3.toString()     // Catch:{ IOException -> 0x006e, all -> 0x006c }
            java.io.File r3 = new java.io.File     // Catch:{ IOException -> 0x006e, all -> 0x006c }
            r3.<init>(r2)     // Catch:{ IOException -> 0x006e, all -> 0x006c }
            boolean r4 = r3.exists()     // Catch:{ IOException -> 0x006e, all -> 0x006c }
            if (r4 != 0) goto L_0x002e
            r3.mkdirs()     // Catch:{ IOException -> 0x006e, all -> 0x006c }
        L_0x002e:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x006e, all -> 0x006c }
            r3.<init>()     // Catch:{ IOException -> 0x006e, all -> 0x006c }
            r3.append(r2)     // Catch:{ IOException -> 0x006e, all -> 0x006c }
            r3.append(r1)     // Catch:{ IOException -> 0x006e, all -> 0x006c }
            java.lang.String r1 = r3.toString()     // Catch:{ IOException -> 0x006e, all -> 0x006c }
            java.io.File r2 = new java.io.File     // Catch:{ IOException -> 0x006e, all -> 0x006c }
            r2.<init>(r1)     // Catch:{ IOException -> 0x006e, all -> 0x006c }
            boolean r3 = r2.exists()     // Catch:{ IOException -> 0x006e, all -> 0x006c }
            if (r3 == 0) goto L_0x004b
            r2.delete()     // Catch:{ IOException -> 0x006e, all -> 0x006c }
        L_0x004b:
            boolean r3 = r2.exists()     // Catch:{ IOException -> 0x006e, all -> 0x006c }
            if (r3 != 0) goto L_0x0054
            r2.createNewFile()     // Catch:{ IOException -> 0x006e, all -> 0x006c }
        L_0x0054:
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x006e, all -> 0x006c }
            r3.<init>(r2)     // Catch:{ IOException -> 0x006e, all -> 0x006c }
            android.graphics.drawable.BitmapDrawable r5 = (android.graphics.drawable.BitmapDrawable) r5     // Catch:{ IOException -> 0x006a }
            android.graphics.Bitmap r5 = r5.getBitmap()     // Catch:{ IOException -> 0x006a }
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ IOException -> 0x006a }
            r4 = 100
            r5.compress(r2, r4, r3)     // Catch:{ IOException -> 0x006a }
            r3.close()     // Catch:{ Exception -> 0x0069 }
        L_0x0069:
            return r1
        L_0x006a:
            r5 = move-exception
            goto L_0x0070
        L_0x006c:
            r5 = move-exception
            goto L_0x007b
        L_0x006e:
            r5 = move-exception
            r3 = r0
        L_0x0070:
            r5.printStackTrace()     // Catch:{ all -> 0x0079 }
            if (r3 == 0) goto L_0x0078
            r3.close()     // Catch:{ Exception -> 0x0078 }
        L_0x0078:
            return r0
        L_0x0079:
            r5 = move-exception
            r0 = r3
        L_0x007b:
            if (r0 == 0) goto L_0x0080
            r0.close()     // Catch:{ Exception -> 0x0080 }
        L_0x0080:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.sns.SnsShareUtils.drawableToFile(android.graphics.drawable.Drawable):java.lang.String");
    }

    private static String formatFrom(String str) {
        return str.replaceAll(" ", "_");
    }

    static void startLoadImage(Activity activity, int i, final C4979b bVar, final ILoadImageCallback iLoadImageCallback) {
        final Context applicationContext = activity.getApplicationContext();
        boolean z = true;
        if (!(i == 1 || i == 6 || i == 7 || i == 11 || i == 10 || i == 28) || TextUtils.isEmpty(bVar.strImgUrl) || !bVar.strImgUrl.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
            z = false;
        }
        if (!z) {
            if (iLoadImageCallback != null) {
                iLoadImageCallback.loadImageOver(bVar.strImgUrl);
            }
            return;
        }
        new ExAsyncTask<Object, Void, String>() {
            /* access modifiers changed from: protected */
            public String doInBackground(Object... objArr) {
                String str = bVar.strImgUrl;
                try {
                    Drawable drawable = (Drawable) C2176e.m6137am(applicationContext).mo12195aO(bVar.strImgUrl).mo12189tM().get(10, TimeUnit.SECONDS);
                    if (drawable == null) {
                        return str;
                    }
                    String access$000 = SnsShareUtils.drawableToFile(drawable);
                    return !TextUtils.isEmpty(access$000) ? access$000 : str;
                } catch (Exception unused) {
                    return str;
                }
            }

            /* access modifiers changed from: protected */
            public void onPostExecute(String str) {
                if (iLoadImageCallback != null) {
                    iLoadImageCallback.loadImageOver(str);
                }
                C4586g.m11696Sm();
            }
        }.execute((Params[]) new Object[0]);
        C4586g.m11704a((Context) activity, C8582R.string.xiaoying_str_com_loading, (OnCancelListener) null, false);
    }
}
