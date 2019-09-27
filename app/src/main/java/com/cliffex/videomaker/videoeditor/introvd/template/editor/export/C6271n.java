package com.introvd.template.editor.export;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.editor.R;
import com.introvd.template.editor.export.ExportAnimationView.C6195a;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.p326ad.p328b.C7592b;
import com.introvd.template.module.p339c.C7689a;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.util.SpanUtils;
import java.util.Locale;

/* renamed from: com.introvd.template.editor.export.n */
public class C6271n extends Dialog {
    private static final String TAG = "n";
    public static boolean cRb;
    private ProgressBar bqi = null;
    /* access modifiers changed from: private */
    public ImageButton cQF;
    /* access modifiers changed from: private */
    public ImageButton cQG;
    /* access modifiers changed from: private */
    public Button cQH;
    private TextView cQI;
    private TextView cQJ;
    /* access modifiers changed from: private */
    public TextView cQK;
    private TextView cQL;
    /* access modifiers changed from: private */
    public TextView cQM;
    /* access modifiers changed from: private */
    public TextView cQN;
    private RelativeLayout cQO;
    private RelativeLayout cQP;
    private RelativeLayout cQQ;
    private RelativeLayout cQR;
    /* access modifiers changed from: private */
    public ViewGroup cQS;
    private View cQT;
    private View cQU;
    /* access modifiers changed from: private */
    public C6231b cQV;
    /* access modifiers changed from: private */
    public C6260l cQW;
    private long cQX = 0;
    private float cQY = 0.0f;
    private boolean cQZ = false;
    private boolean cRa = false;
    private boolean cRc = false;
    private int cRd = 0;
    private int cRe = 0;
    public String cRf = "0";
    /* access modifiers changed from: private */
    public C6244e cRg;
    /* access modifiers changed from: private */
    public C6195a cRh;
    /* access modifiers changed from: private */
    public boolean cRi = false;

    /* renamed from: po */
    private OnClickListener f3504po = new OnClickListener() {
        public void onClick(View view) {
            if (C6271n.this.cQF.equals(view)) {
                if (C6271n.this.cRh == null) {
                    return;
                }
                if (C6271n.this.cRi) {
                    C6271n.this.cancel();
                } else {
                    C6271n.this.cRh.alk();
                }
            } else if (view.equals(C6271n.this.cQH)) {
                if (C6271n.this.cRh != null) {
                    C6271n.this.cRh.alm();
                }
            } else if (view.equals(C6271n.this.cQK) || view.equals(C6271n.this.cQG) || view.equals(C6271n.this.cQN)) {
                if (C6271n.this.cRh != null) {
                    C6271n.this.cRh.mo29022fH(false);
                }
            } else if (view.equals(C6271n.this.cQM) && C6271n.this.cRh != null) {
                C6271n.this.cRh.mo29022fH(true);
            }
        }
    };

    public C6271n(Context context) {
        super(context, R.style.xiaoying_style_com_dialog);
        requestWindowFeature(1);
        setCancelable(false);
        setOnCancelListener(new OnCancelListener() {
            public void onCancel(DialogInterface dialogInterface) {
                if (C6271n.this.cRg != null) {
                    C6271n.this.cRg.alr();
                }
            }
        });
        setOnKeyListener(new OnKeyListener() {
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                boolean z = true;
                if (i == 4 && keyEvent.getAction() == 1 && C6271n.this.cRh != null) {
                    if (!C6271n.this.cRi) {
                        C6271n.this.cRh.alk();
                    } else {
                        C6271n.this.cancel();
                    }
                    return true;
                }
                if (i != 84) {
                    z = false;
                }
                return z;
            }
        });
        this.cQV = new C6231b(new C6234b() {
            public boolean isShowing() {
                return C6271n.this.isShowing();
            }
        });
        this.cQW = new C6260l(getContext());
        cRb = false;
    }

    private void amd() {
        if (C4580b.m11636Sj()) {
            try {
                SpannableStringBuilder hN = m17956hN(getContext().getResources().getString(R.string.viva_msg_exp_oppo_save_path_tip));
                if (hN != null) {
                    TextView textView = (TextView) findViewById(R.id.tv_tip_oppo_device);
                    textView.setText(hN);
                    textView.setVisibility(0);
                }
            } catch (Exception unused) {
            }
            LayoutParams layoutParams = (LayoutParams) this.cQL.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.topMargin = C7689a.m22599ii(100);
                this.cQL.setLayoutParams(layoutParams);
            }
        }
    }

    private void ame() {
        cRb = false;
        if (C8048e.aBe().mo23618Mi() && this.cQV != null) {
            setOnDismissListener(new OnDismissListener() {
                public void onDismiss(DialogInterface dialogInterface) {
                    if (C6271n.this.cQV != null) {
                        C6271n.this.cQV.ali();
                    }
                    if (C6271n.this.cQW != null) {
                        C6271n.this.cQW.onRelease();
                    }
                }
            });
            this.cQT = findViewById(R.id.tv_tip_when_video_show);
            this.cQU = findViewById(R.id.tv_tip_keep_foreground);
            this.cQS = (ViewGroup) findViewById(R.id.fl_ad_container);
            C6231b bVar = this.cQV;
            Activity ownerActivity = getOwnerActivity();
            final C62765 r2 = new C6233a() {
                public void alj() {
                    View adView = C6271n.this.cQW.getAdView();
                    if (adView == null) {
                        C6271n.this.m17953fP(C6271n.this.cQS.getChildCount() <= 0);
                        return;
                    }
                    mo29134cD(adView);
                    C6271n.this.cQW.mo29193cE(adView);
                }

                /* renamed from: cD */
                public void mo29134cD(View view) {
                    C6271n.this.cQS.removeAllViews();
                    C6271n.this.cQS.addView(view);
                    C6271n.this.m17953fP(false);
                    C7592b.aAh();
                    C6271n.cRb = true;
                    StringBuilder sb = new StringBuilder();
                    sb.append("onLoadSuccess  -------------- ");
                    sb.append(view);
                    LogUtilsV2.m14228e(sb.toString());
                }
            };
            bVar.mo29131a(ownerActivity, (C6233a) r2);
            this.cQW.mo29192a(new C6262a() {
                /* renamed from: cG */
                public void mo29196cG(View view) {
                    if (C6271n.this.isShowing()) {
                        r2.alj();
                        StringBuilder sb = new StringBuilder();
                        sb.append("onMediumLoadSuccess  -------------- ");
                        sb.append(view);
                        LogUtilsV2.m14228e(sb.toString());
                    }
                }
            });
        }
    }

    /* renamed from: c */
    static String m17948c(float f, long j) {
        String str;
        String str2 = "%02dH %2dm %02ds";
        String str3 = "%2dm %02ds";
        String str4 = "%02ds";
        String str5 = "%2d小时%2d分%02d秒";
        String str6 = "%2d分%02d秒";
        String str7 = "%02d秒";
        boolean Sg = C4580b.m11633Sg();
        int i = (int) (((long) ((((float) j) / f) * (100.0f - f))) / 1000);
        String str8 = "0s";
        if (i >= 3600) {
            try {
                int i2 = i / 3600;
                if (i2 > 2) {
                    i2 = 2;
                }
                int i3 = i % 3600;
                Locale locale = Locale.US;
                if (Sg) {
                    str2 = str5;
                }
                str = String.format(locale, str2, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3 / 60), Integer.valueOf(i % 60)});
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("ex:");
                sb.append(e.getMessage());
                LogUtilsV2.m14228e(sb.toString());
                return str8;
            }
        } else if (i >= 60) {
            Locale locale2 = Locale.US;
            if (Sg) {
                str3 = str6;
            }
            str = String.format(locale2, str3, new Object[]{Integer.valueOf((i % 3600) / 60), Integer.valueOf(i % 60)});
        } else {
            Locale locale3 = Locale.US;
            if (Sg) {
                str4 = str7;
            }
            str = String.format(locale3, str4, new Object[]{Integer.valueOf(i % 60)});
        }
        return str;
    }

    /* access modifiers changed from: private */
    /* renamed from: fP */
    public void m17953fP(boolean z) {
        int i = 4;
        this.cQH.setVisibility(z ? 0 : 4);
        this.cQH.setEnabled(z);
        int i2 = 8;
        this.cQT.setVisibility(z ? 8 : 0);
        View view = this.cQU;
        if (z) {
            i2 = 0;
        }
        view.setVisibility(i2);
        TextView textView = this.cQL;
        if (z) {
            i = 0;
        }
        textView.setVisibility(i);
    }

    /* renamed from: hN */
    private SpannableStringBuilder m17956hN(String str) {
        int indexOf = str.indexOf(34);
        int lastIndexOf = str.lastIndexOf(34);
        if (indexOf <= -1) {
            indexOf = str.indexOf(8220);
            lastIndexOf = str.indexOf(8221);
        }
        if (indexOf == lastIndexOf) {
            return null;
        }
        if (indexOf > lastIndexOf) {
            indexOf = lastIndexOf;
        }
        String substring = str.substring(0, indexOf);
        int i = lastIndexOf + 1;
        String substring2 = str.substring(i);
        String substring3 = str.substring(indexOf, i);
        SpanUtils spanUtils = new SpanUtils();
        spanUtils.mo35760B(substring).mo35766vG(33);
        spanUtils.mo35760B(substring3).aNk().mo35765aq(16, true).mo35766vG(33);
        spanUtils.mo35760B(substring2).mo35766vG(33);
        return spanUtils.aNl();
    }

    /* renamed from: a */
    public void mo29202a(C6244e eVar) {
        this.cRg = eVar;
    }

    public boolean amf() {
        return this.cQF.isEnabled();
    }

    public boolean amg() {
        return this.cRc;
    }

    public void cancel() {
        LogUtilsV2.m14228e("cancel in");
        if (this.cRg != null && !this.cRi) {
            this.cRg.alq();
        }
        super.cancel();
    }

    public void dismiss() {
        LogUtilsV2.m14228e("dismiss in");
        if (!this.cRc) {
            if (this.cRg != null) {
                this.cRg.alo();
            }
            super.dismiss();
            this.cRc = true;
        }
    }

    /* renamed from: fQ */
    public void mo29207fQ(boolean z) {
        this.cQF.setEnabled(z);
    }

    /* renamed from: fR */
    public void mo29208fR(boolean z) {
        if (z) {
            this.cRi = false;
            if (this.cRh != null) {
                this.cRh.all();
                return;
            }
            return;
        }
        this.cRi = true;
        this.cQP.setVisibility(8);
        this.cQO.setVisibility(0);
        if (this.cQZ) {
            this.cQQ.setVisibility(0);
            this.cQR.setVisibility(8);
        }
    }

    public void hide() {
        if (this.cRg != null) {
            this.cRg.alp();
        }
        super.hide();
    }

    public void onBackPressed() {
        if (amf()) {
            if (this.cRg != null && !this.cRi) {
                this.cRg.alr();
            }
            dismiss();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.editor_export_dialog_layout);
        if (getWindow() != null) {
            getWindow().setLayout(-1, -1);
        }
        this.bqi = (ProgressBar) findViewById(R.id.xiaoying_ve_basic_tool_progressbar);
        this.cQF = (ImageButton) findViewById(R.id.imgbtn_cancel);
        this.cQH = (Button) findViewById(R.id.btn_view_newbie_tuial);
        this.cQI = (TextView) findViewById(R.id.txtview_progressview);
        this.cQJ = (TextView) findViewById(R.id.txtview_remain_timeview);
        this.cQJ.setText(getContext().getString(R.string.xiaoying_str_com_export_time_consume_tip, new Object[]{"--:--"}));
        this.cQK = (TextView) findViewById(R.id.txtview_retry);
        this.cQL = (TextView) findViewById(R.id.tv_tip_4k_slow);
        this.cQG = (ImageButton) findViewById(R.id.imgbtn_retry);
        this.cQP = (RelativeLayout) findViewById(R.id.layout_exporting_view);
        this.cQO = (RelativeLayout) findViewById(R.id.layout_export_fail_view);
        this.cQQ = (RelativeLayout) findViewById(R.id.layout_4k_retry);
        this.cQR = (RelativeLayout) findViewById(R.id.layout_normal_retry);
        this.cQM = (TextView) findViewById(R.id.btn_4k_export_retry);
        this.cQN = (TextView) findViewById(R.id.btn_normail_export_retry);
        this.cQH.setOnClickListener(this.f3504po);
        this.cQF.setOnClickListener(this.f3504po);
        this.cQK.setOnClickListener(this.f3504po);
        this.cQG.setOnClickListener(this.f3504po);
        this.cQN.setOnClickListener(this.f3504po);
        this.cQM.setOnClickListener(this.f3504po);
        if (this.cRa) {
            this.cQL.setVisibility(0);
        }
        ame();
        amd();
    }

    public void setListener(C6195a aVar) {
        this.cRh = aVar;
    }

    public void setProgress(float f) {
        float f2;
        long currentTimeMillis = System.currentTimeMillis() - this.cQX;
        StringBuilder sb = new StringBuilder();
        sb.append("setProgress=");
        sb.append(f);
        sb.append(";timeconsume=");
        sb.append(currentTimeMillis);
        LogUtilsV2.m14230i(sb.toString());
        this.cRd++;
        if (currentTimeMillis < AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS) {
            if (this.cRd <= 3) {
                f2 = (float) this.cRd;
            } else {
                if (this.cRe <= 0) {
                    this.cRe = (int) (AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS / (currentTimeMillis / ((long) this.cRd)));
                }
                f2 = (15.0f / ((float) this.cRe)) * ((float) this.cRd);
            }
            if (f2 > 15.0f) {
                f2 = 15.0f;
            }
        } else {
            f2 = ((85.0f * f) / 100.0f) + 15.0f;
        }
        if (f > 90.0f) {
            f2 = f;
        }
        this.bqi.setProgress((int) f2);
        this.cQI.setText(String.format(Locale.US, "%.1f%%", new Object[]{Float.valueOf(f2)}));
        int i = (f > 1.0f ? 1 : (f == 1.0f ? 0 : -1));
        if (i < 0 || f - this.cQY >= 5.0f) {
            this.cQY = f;
            this.cRf = m17948c(f, currentTimeMillis);
            if (i < 0) {
                this.cRf = "--:--";
            }
            this.cQJ.setText(getContext().getString(R.string.xiaoying_str_com_export_time_consume_tip, new Object[]{this.cRf}));
        }
    }

    /* renamed from: v */
    public void mo29214v(boolean z, boolean z2) {
        this.cQZ = z;
        this.cRa = z2;
        super.show();
        this.cQX = System.currentTimeMillis();
    }
}
