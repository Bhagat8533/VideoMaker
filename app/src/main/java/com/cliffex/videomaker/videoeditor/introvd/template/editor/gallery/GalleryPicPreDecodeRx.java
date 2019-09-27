package com.introvd.template.editor.gallery;

import android.arch.lifecycle.C0061e.C0062a;
import android.arch.lifecycle.C0068f;
import android.arch.lifecycle.C0078n;
import android.support.p021v4.app.FragmentActivity;
import android.text.TextUtils;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.sdk.utils.C8545d;
import com.introvd.template.sdk.utils.C8572y;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import p037b.p050b.C1485a;
import p037b.p050b.C1834l;
import p037b.p050b.p057e.C1517e;
import p037b.p050b.p076j.C1820a;
import p037b.p050b.p077k.C1830a;
import p037b.p050b.p077k.C1833c;

class GalleryPicPreDecodeRx implements C0068f {
    private C1833c<String> cSJ = C1830a.aVl();
    /* access modifiers changed from: private */
    public Map<String, String> cSK = Collections.synchronizedMap(new HashMap());
    private String cSL;
    /* access modifiers changed from: private */
    public boolean cSM = false;

    private GalleryPicPreDecodeRx() {
        this.cSJ.aVm();
        create();
    }

    private void clear() {
        if (this.cSK != null && this.cSK.size() != 0) {
            C1834l.m5257ah(Boolean.valueOf(true)).mo10157d(C1820a.aVi()).mo10152c(C1820a.aVi()).mo10161e((C1517e<? super T>) new C1517e<Boolean>() {
                /* renamed from: d */
                public void accept(Boolean bool) throws Exception {
                    for (String str : GalleryPicPreDecodeRx.this.cSK.keySet()) {
                        String str2 = (String) GalleryPicPreDecodeRx.this.cSK.get(str);
                        if (!TextUtils.isEmpty(str2)) {
                            File file = new File(str2);
                            if (file.exists()) {
                                file.delete();
                                StringBuilder sb = new StringBuilder();
                                sb.append("Jamin PreDecoder  delete pre load file = ");
                                sb.append(str2);
                                LogUtilsV2.m14227d(sb.toString());
                            }
                        }
                    }
                    GalleryPicPreDecodeRx.this.cSK.clear();
                }
            }).aTR();
        }
    }

    private void create() {
        this.cSJ.mo10157d(C1820a.aVi()).mo10152c(C1820a.aVi()).mo10131a(C1485a.BUFFER).mo9826b((C1517e<? super T>) new C1517e<String>() {
            /* renamed from: dn */
            public void accept(String str) throws Exception {
                if (!GalleryPicPreDecodeRx.this.cSM) {
                    GalleryPicPreDecodeRx.this.m18114hS(str);
                }
            }
        }).aTR();
    }

    /* renamed from: h */
    static GalleryPicPreDecodeRx m18113h(FragmentActivity fragmentActivity) {
        if (fragmentActivity == null) {
            return null;
        }
        GalleryPicPreDecodeRx galleryPicPreDecodeRx = new GalleryPicPreDecodeRx();
        fragmentActivity.getLifecycle().mo152a(galleryPicPreDecodeRx);
        return galleryPicPreDecodeRx;
    }

    /* access modifiers changed from: private */
    /* renamed from: hS */
    public void m18114hS(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.cSL) && !str.endsWith(".gif")) {
            String e = C8545d.m24986e(str, C8572y.m25097ou(this.cSL), true);
            if (!TextUtils.isEmpty(e)) {
                this.cSK.put(str, e);
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                StringBuilder sb = new StringBuilder();
                sb.append("Jamin PreDecoder  cost = ");
                sb.append(currentTimeMillis2);
                sb.append("ms,decode filePath = ");
                sb.append(str);
                sb.append(",decodeFile = ");
                sb.append(e);
                LogUtilsV2.m14227d(sb.toString());
            }
        }
    }

    private void remove(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.cSK.remove(str);
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: hQ */
    public void mo29319hQ(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.cSL = str;
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: hR */
    public void mo29320hR(String str) {
        if (!TextUtils.isEmpty(this.cSL) && !TextUtils.isEmpty(str)) {
            if (this.cSK == null || !this.cSK.containsKey(str)) {
                if (this.cSJ != null) {
                    this.cSM = false;
                    this.cSJ.mo9886K(str);
                }
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Jamin PreDecoder has been decoded path = ");
            sb.append(str);
            LogUtilsV2.m14227d(sb.toString());
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: hT */
    public String mo29321hT(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = (String) this.cSK.get(str);
        remove(str);
        return str2;
    }

    /* access modifiers changed from: protected */
    @C0078n(mo161n = C0062a.ON_DESTROY)
    public void onActivityDestroy() {
        clear();
        this.cSJ = null;
        LogUtilsV2.m14230i(">>> onActivityDestroy...");
    }

    public void stop() {
        this.cSM = true;
    }
}
