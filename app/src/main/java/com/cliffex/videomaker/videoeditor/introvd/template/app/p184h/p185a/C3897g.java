package com.introvd.template.app.p184h.p185a;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.introvd.template.R;
import com.introvd.template.app.p181e.C3871a;
import com.introvd.template.app.p181e.C3871a.C3872a;
import com.introvd.template.app.p181e.C3873b;
import com.introvd.template.app.p182f.C3875a;
import com.introvd.template.app.p182f.C3875a.C3877a;
import com.vivavideo.mobile.h5api.api.C9335a;
import com.vivavideo.mobile.h5api.api.C9345j;
import com.vivavideo.mobile.h5api.api.C9358q;
import com.vivavideo.mobile.h5api.p432a.C9334a;
import org.json.JSONException;
import org.json.JSONObject;

@C9334a(aPx = {"download"})
/* renamed from: com.introvd.template.app.h.a.g */
public class C3897g implements C3872a, C9358q {
    /* access modifiers changed from: private */
    public C3871a bsT;
    private C3875a bsU;
    /* access modifiers changed from: private */
    public C9345j bsV;

    /* access modifiers changed from: private */
    /* renamed from: Mb */
    public void m9585Mb() {
        if (this.bsT == null) {
            this.bsT = new C3871a(this.bsV.getActivity(), R.style.MyAlertDialogStyle);
            this.bsT.mo23402a(this);
        }
        this.bsT.show();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public JSONObject m9592d(boolean z, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", z);
            jSONObject.put("path", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    /* access modifiers changed from: private */
    /* renamed from: dy */
    public void m9593dy(String str) {
        if (this.bsV != null && !this.bsV.getActivity().isFinishing()) {
            StringBuilder sb = new StringBuilder();
            sb.append("file://");
            sb.append(str);
            Uri parse = Uri.parse(sb.toString());
            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData(parse);
            this.bsV.getActivity().sendBroadcast(intent);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m9594f(String str, boolean z) {
        String str2;
        if (this.bsV != null && this.bsV.getActivity() != null && !this.bsV.getActivity().isFinishing()) {
            if (z) {
                str2 = this.bsV.getActivity().getString(R.string.xiaoying_str_studio_video_downloaded);
            } else {
                String string = this.bsV.getActivity().getString(R.string.xiaoying_str_com_msg_download_success);
                StringBuilder sb = new StringBuilder();
                sb.append(string);
                sb.append(str);
                str2 = sb.toString();
            }
            C3873b.show(this.bsV.getActivity().getApplicationContext(), str2, 1);
        }
    }

    /* renamed from: KU */
    public void mo23405KU() {
        if (this.bsU != null) {
            this.bsU.mo23407KY();
        }
    }

    public void getFilter(C9335a aVar) {
    }

    public boolean handleEvent(C9345j jVar) throws JSONException {
        this.bsV = jVar;
        String action = jVar.getAction();
        JSONObject aPD = jVar.aPD();
        if (!"download".equalsIgnoreCase(action) || aPD == null || TextUtils.isEmpty(aPD.getString("url")) || this.bsV.getActivity().isFinishing()) {
            return true;
        }
        String string = aPD.getString("url");
        this.bsU = new C3875a();
        this.bsU.mo23408a(this.bsV.getActivity().getApplicationContext(), string, new C3877a() {
            /* renamed from: L */
            public void mo23410L(String str, String str2) {
                C3897g.this.m9585Mb();
            }

            /* renamed from: a */
            public void mo23411a(String str, String str2, int i, boolean z) {
                if (C3897g.this.bsT != null && C3897g.this.bsT.isShowing() && !z) {
                    C3897g.this.bsT.mo23403gD(i);
                }
            }

            /* renamed from: a */
            public void mo23412a(String str, String str2, boolean z, boolean z2) {
                if (C3897g.this.bsT != null) {
                    C3897g.this.bsT.dismiss();
                    C3897g.this.bsV.mo36588x(C3897g.this.m9592d(z2, str2));
                    if (z2) {
                        C3897g.this.m9593dy(str2);
                    }
                    if (z2) {
                        C3897g.this.m9594f(str2, z);
                    }
                }
            }
        });
        return true;
    }

    public boolean interceptEvent(C9345j jVar) throws JSONException {
        return false;
    }

    public void onRelease() {
    }
}
