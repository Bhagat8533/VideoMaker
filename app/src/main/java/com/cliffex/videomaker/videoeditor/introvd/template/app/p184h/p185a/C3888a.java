package com.introvd.template.app.p184h.p185a;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.text.TextUtils;
import android.util.Base64;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.router.editor.gallery.GalleryIntentInfo;
import com.introvd.template.router.editor.gallery.GalleryIntentInfo.Builder;
import com.introvd.template.router.editor.gallery.GalleryRouter;
import com.introvd.template.router.editor.gallery.MediaGalleryRouter;
import com.introvd.template.sdk.editor.cache.TrimedClipItemDataModel;
import com.vivavideo.mobile.h5api.api.C9335a;
import com.vivavideo.mobile.h5api.api.C9345j;
import com.vivavideo.mobile.h5api.api.C9358q;
import com.vivavideo.mobile.h5api.p432a.C9334a;
import com.vivavideo.mobile.h5core.p447ui.H5Activity;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p037b.p050b.C1848s;
import p037b.p050b.C1849t;
import p037b.p050b.C1850u;
import p037b.p050b.C1851v;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p076j.C1820a;
import xiaoying.engine.clip.QEffect;

@C9334a(aPx = {"batchImage"})
/* renamed from: com.introvd.template.app.h.a.a */
public class C3888a implements C9358q {
    /* access modifiers changed from: private */
    public C1495b bsK;

    /* renamed from: a */
    private Bitmap m9566a(Bitmap bitmap, float f, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.preScale(f, f);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, i, i2, matrix, false);
        if (createBitmap.equals(bitmap)) {
            return createBitmap;
        }
        bitmap.recycle();
        return createBitmap;
    }

    /* renamed from: a */
    private Bitmap m9567a(Bitmap bitmap, C9345j jVar) {
        if (bitmap == null) {
            return null;
        }
        int optInt = jVar.aPD().optInt("widthMin", 160);
        int optInt2 = jVar.aPD().optInt("heightMin", 160);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if ((width >= optInt && height >= optInt2) || width <= 0 || height <= 0) {
            return bitmap;
        }
        return m9566a(bitmap, Math.max(((float) optInt2) / ((float) height), ((float) optInt) / ((float) width)), width, height);
    }

    /* renamed from: a */
    private Bitmap m9568a(String str, C9345j jVar) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        options.inDither = true;
        options.inPreferredConfig = Config.ARGB_8888;
        BitmapFactory.decodeFile(str, options);
        int i = options.outWidth;
        int i2 = options.outHeight;
        if (i == -1 || i2 == -1) {
            return null;
        }
        int optInt = jVar.aPD().optInt("widthLimit", 1000);
        int optInt2 = jVar.aPD().optInt("heightLimit", 1000);
        StringBuilder sb = new StringBuilder();
        sb.append("缩放  ");
        sb.append(i);
        sb.append("...");
        sb.append(i2);
        LogUtilsV2.m14228e(sb.toString());
        int i3 = (i <= i2 || i <= optInt2) ? (i >= i2 || i2 <= optInt) ? (i != i2 || i <= optInt2) ? 1 : i / optInt2 : i2 / optInt : i / optInt2;
        if (i3 <= 0) {
            i3 = 1;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("scale   ");
        sb2.append(i3);
        sb2.append("");
        LogUtilsV2.m14228e(sb2.toString());
        Options options2 = new Options();
        options2.inSampleSize = i3;
        options2.inDither = true;
        options2.inPreferredConfig = Config.ARGB_8888;
        return BitmapFactory.decodeFile(str, options2);
    }

    /* renamed from: a */
    private JSONObject m9570a(C9345j jVar, int i, int i2, Intent intent) {
        if (i != 4146 || i2 != -1) {
            return new JSONObject();
        }
        if (intent == null || intent.getParcelableArrayListExtra(MediaGalleryRouter.INTENT_BACK_RANGE_LIST_KEY) == null) {
            return new JSONObject();
        }
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(MediaGalleryRouter.INTENT_BACK_RANGE_LIST_KEY);
        ArrayList arrayList = new ArrayList();
        Iterator it = parcelableArrayListExtra.iterator();
        while (it.hasNext()) {
            arrayList.add(((TrimedClipItemDataModel) it.next()).mRawFilePath);
        }
        JSONArray jSONArray = new JSONArray();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            String str = (String) arrayList.get(i3);
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("getBase64Imgs: ");
            sb.append(str);
            LogUtilsV2.m14228e(sb.toString());
            Bitmap a = m9567a(m9568a(str, jVar), jVar);
            if (a != null) {
                JSONObject jSONObject = new JSONObject();
                String dw = m9576dw(str);
                CompressFormat dx = m9577dx(dw);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                a.compress(dx, 100, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                try {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("data:image/");
                    sb2.append(dw);
                    sb2.append(";base64,");
                    String sb3 = sb2.toString();
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(sb3);
                    sb4.append(Base64.encodeToString(byteArray, 0));
                    jSONObject.put("base64", sb4.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                jSONArray.put(jSONObject);
            }
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (jSONArray.length() > 0) {
                jSONObject2.put("imgs", jSONArray);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject2;
    }

    /* renamed from: a */
    private void m9573a(C9345j jVar) {
        if (this.bsK != null && !this.bsK.aAy()) {
            this.bsK.dispose();
        }
        H5Activity h5Activity = (H5Activity) jVar.getActivity();
        h5Activity.setPageListener(new C3890b(this, jVar));
        GalleryIntentInfo build = new Builder().setSourceMode(2).setAction(5).setLimitRangeCount(jVar.aPD().optInt("imgNum", 0)).setNewPrj(false).build();
        GalleryRouter.getInstance().launchGalleryActivity(h5Activity, QEffect.PROP_EFFECT_POSITION_ALIGNMENT, build);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m9574a(C9345j jVar, int i, int i2, Intent intent, C1849t tVar) throws Exception {
        tVar.onSuccess(m9570a(jVar, i, i2, intent));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m9575b(final C9345j jVar, int i, int i2, Intent intent) {
        C3891c cVar = new C3891c(this, jVar, i, i2, intent);
        C1848s.m5324a((C1851v<T>) cVar).mo10196g(C1820a.aVi()).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1850u<JSONObject>() {
            /* renamed from: a */
            public void mo9883a(C1495b bVar) {
                C3888a.this.bsK = bVar;
            }

            public void onError(Throwable th) {
                th.printStackTrace();
            }

            public void onSuccess(JSONObject jSONObject) {
                if (jSONObject.length() != 0) {
                    LogUtilsV2.m14228e("sendBack  h5Event.sendBack(jsonObject);");
                    jVar.mo36588x(jSONObject);
                }
            }
        });
    }

    /* renamed from: dw */
    private String m9576dw(String str) {
        return str.lastIndexOf(".") == -1 ? "jpeg" : str.substring(str.lastIndexOf(".") + 1);
    }

    /* renamed from: dx */
    private CompressFormat m9577dx(String str) {
        if (str == null) {
            return CompressFormat.JPEG;
        }
        String lowerCase = str.toLowerCase();
        return (lowerCase.equals("jpg") || lowerCase.equals("jpeg")) ? CompressFormat.JPEG : lowerCase.equals("png") ? CompressFormat.PNG : CompressFormat.JPEG;
    }

    public void getFilter(C9335a aVar) {
    }

    @SuppressLint({"CheckResult"})
    public boolean handleEvent(C9345j jVar) throws JSONException {
        String action = jVar.getAction();
        if ("batchImage".equalsIgnoreCase(action)) {
            StringBuilder sb = new StringBuilder();
            sb.append("h5Event getAction = ");
            sb.append(action);
            LogUtilsV2.m14227d(sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("h5Event getParam = ");
            sb2.append(jVar.aPD());
            LogUtilsV2.m14227d(sb2.toString());
            m9573a(jVar);
        }
        return true;
    }

    public boolean interceptEvent(C9345j jVar) throws JSONException {
        return false;
    }

    public void onRelease() {
        if (this.bsK != null && !this.bsK.aAy()) {
            this.bsK.dispose();
        }
        LogUtilsV2.m14228e("onRelease   ");
    }
}
