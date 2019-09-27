package com.introvd.template.app.p182f;

import android.content.Context;
import android.text.TextUtils;
import com.introvd.template.R;
import com.introvd.template.common.CommonConfigure;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.MD5;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.datacenter.SocialService;
import com.introvd.template.p203b.C4600l;
import com.introvd.template.plugin.downloader.C8251a;
import com.introvd.template.plugin.downloader.entity.C8312a;
import com.introvd.template.plugin.downloader.entity.DownloadStatus;
import p037b.p050b.p057e.C1517e;

/* renamed from: com.introvd.template.app.f.a */
public class C3875a {
    private C8251a bqv;
    /* access modifiers changed from: private */
    public Context mContext;
    private String mUrl;

    /* renamed from: com.introvd.template.app.f.a$a */
    public interface C3877a {
        /* renamed from: L */
        void mo23410L(String str, String str2);

        /* renamed from: a */
        void mo23411a(String str, String str2, int i, boolean z);

        /* renamed from: a */
        void mo23412a(String str, String str2, boolean z, boolean z2);
    }

    /* renamed from: KZ */
    private String m9540KZ() {
        StringBuilder sb = new StringBuilder();
        sb.append(CommonConfigure.APP_DEFAULT_EXPORT_PATH);
        sb.append("HybridDownloads/");
        return sb.toString();
    }

    /* renamed from: a */
    private void m9542a(Context context, final String str, String str2, final String str3, String str4, final C3877a aVar) {
        this.mUrl = str;
        this.mContext = context;
        this.bqv = C8251a.m23820gI(context.getApplicationContext()).mo33410tl(1);
        this.bqv.mo33405mE(str).mo10168g((C1517e<? super T>) new C1517e<C8312a>() {
            /* renamed from: a */
            public void accept(C8312a aVar) {
                DownloadStatus aGe = aVar.aGe();
                int flag = aVar.getFlag();
                if (flag == 9992) {
                    if (aVar != null) {
                        aVar.mo23411a(str, str3, (int) aGe.aGl(), false);
                    }
                } else if (flag != 9990) {
                    if (flag == 9991) {
                        ToastUtils.show(C3875a.this.mContext, R.string.xiaoying_str_video_download_start, 0);
                        if (aVar != null) {
                            aVar.mo23410L(str, str3);
                        }
                    } else if (flag == 9994) {
                        if (aVar != null) {
                            aVar.mo23411a(str, str3, 100, true);
                        }
                        C3878b.m9550La().remove(str);
                        if (aVar != null) {
                            aVar.mo23412a(str, str3, false, true);
                        }
                    } else if (flag == 9995) {
                        if (aVar != null) {
                            aVar.mo23412a(str, str3, false, false);
                        }
                        C3878b.m9550La().remove(str);
                    }
                }
            }
        });
        this.bqv.mo33409t(str, str2, str4).aTR();
    }

    private String getFileType(String str) {
        if (TextUtils.isEmpty(str)) {
            return ".mp4";
        }
        String[] split = str.split(".");
        String str2 = null;
        if (split != null && split.length > 0) {
            str2 = split[split.length - 1];
        }
        if (TextUtils.isEmpty(str2)) {
            return ".mp4";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(".");
        sb.append(str2);
        return sb.toString();
    }

    /* renamed from: K */
    public String mo23406K(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (!str.startsWith(SocialService.CONST_URL_HTTP_PREFIX) && !str.startsWith("https://"))) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(CommonConfigure.APP_DEFAULT_EXPORT_PATH);
        sb.append("HybridDownloads/");
        sb.append(str2);
        return sb.toString();
    }

    /* renamed from: KY */
    public void mo23407KY() {
        if (this.bqv != null && !TextUtils.isEmpty(this.mUrl)) {
            this.bqv.mo33407mG(this.mUrl).aTR();
            C3878b.m9550La().remove(this.mUrl);
        }
    }

    /* renamed from: a */
    public void mo23408a(Context context, String str, C3877a aVar) {
        if (context != null && !TextUtils.isEmpty(str)) {
            if (!C4600l.m11739k(context, true)) {
                ToastUtils.show(context.getApplicationContext(), R.string.xiaoying_str_com_msg_network_inactive, 1);
            } else if (C4600l.m11740l(context, true) && !TextUtils.isEmpty(str)) {
                StringBuilder sb = new StringBuilder();
                sb.append(MD5.md5(str));
                sb.append(getFileType(str));
                String sb2 = sb.toString();
                String K = mo23406K(str, sb2);
                String KZ = m9540KZ();
                if (FileUtils.isFileExisted(K)) {
                    if (aVar != null) {
                        aVar.mo23412a(str, K, true, true);
                    }
                } else if (C3878b.m9550La().containsKey(str)) {
                    ToastUtils.show(context, R.string.xiaoying_str_com_msg_downloading_list, 0);
                } else {
                    C3878b.m9550La().put(str, str);
                    m9542a(context, str, sb2, K, KZ, aVar);
                }
            }
        }
    }
}
