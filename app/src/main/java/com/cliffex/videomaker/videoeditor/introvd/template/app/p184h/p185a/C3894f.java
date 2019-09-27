package com.introvd.template.app.p184h.p185a;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Handler;
import com.google.android.exoplayer2.util.MimeTypes;
import com.introvd.template.R;
import com.introvd.template.common.LogUtilsV2;
import com.vivavideo.mobile.h5api.api.C9335a;
import com.vivavideo.mobile.h5api.api.C9345j;
import com.vivavideo.mobile.h5api.api.C9358q;
import com.vivavideo.mobile.h5api.p432a.C9334a;
import com.vivavideo.mobile.h5core.p446h.C9498d;
import org.json.JSONException;
import org.json.JSONObject;

@C9334a(aPx = {"showLoading", "hideLoading"})
/* renamed from: com.introvd.template.app.h.a.f */
public class C3894f implements C9358q {
    /* access modifiers changed from: private */
    public ProgressDialog bsQ;
    private Runnable bsR;
    private Handler mHandler = new Handler();

    /* renamed from: Ma */
    private void m9582Ma() {
        try {
            if (this.bsR != null) {
                this.mHandler.removeCallbacks(this.bsR);
                this.bsR = null;
            }
            if (this.bsQ != null) {
                this.bsQ.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    private void m9584b(final C9345j jVar) {
        if (jVar.getActivity() != null) {
            JSONObject aPD = jVar.aPD();
            String d = C9498d.m27333d(aPD, MimeTypes.BASE_TYPE_TEXT);
            int e = C9498d.m27334e(aPD, "delay");
            StringBuilder sb = new StringBuilder();
            sb.append("h5Event title = ");
            sb.append(d);
            sb.append(",delay = ");
            sb.append(e);
            LogUtilsV2.m14227d(sb.toString());
            try {
                if (this.bsQ == null || !this.bsQ.isShowing()) {
                    this.bsQ = new ProgressDialog(jVar.getActivity(), R.style.MyAlertDialogStyle);
                    this.bsQ.requestWindowFeature(1);
                    this.bsQ.show();
                    this.bsQ.setContentView(R.layout.xiaoying_com_simple_dialogue_content);
                    this.bsQ.setCanceledOnTouchOutside(false);
                    this.bsQ.setOnCancelListener(new OnCancelListener() {
                        public void onCancel(DialogInterface dialogInterface) {
                        }
                    });
                    this.bsQ.show();
                    this.bsR = new Runnable() {
                        public void run() {
                            if (jVar != null && jVar.getActivity() != null && !jVar.getActivity().isFinishing()) {
                                try {
                                    C3894f.this.bsQ.show();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    };
                    this.mHandler.postDelayed(this.bsR, (long) e);
                }
            } catch (Exception unused) {
            }
        }
    }

    public void getFilter(C9335a aVar) {
    }

    public boolean handleEvent(C9345j jVar) throws JSONException {
        String action = jVar.getAction();
        StringBuilder sb = new StringBuilder();
        sb.append("h5Event action = ");
        sb.append(action);
        LogUtilsV2.m14227d(sb.toString());
        if ("showLoading".equals(action)) {
            m9584b(jVar);
        } else if ("hideLoading".equals(action)) {
            m9582Ma();
        }
        return true;
    }

    public boolean interceptEvent(C9345j jVar) throws JSONException {
        return false;
    }

    public void onRelease() {
        if (this.bsQ != null) {
            if (this.bsQ.isShowing()) {
                this.bsQ.dismiss();
            }
            this.bsQ = null;
        }
    }
}
