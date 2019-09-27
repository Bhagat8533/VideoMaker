package com.introvd.template.editor.preview.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.common.behavior.UserBehaviorUtils;
import com.introvd.template.editor.R;
import com.introvd.template.module.iap.C8035c;
import com.introvd.template.module.iap.C8035c.C8038a;
import com.introvd.template.module.iap.C8035c.C8039b;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.C8049f;
import com.introvd.template.module.p326ad.p328b.C7591a;
import com.introvd.template.p203b.C4586g;
import com.introvd.template.sdk.p391g.C8450a;
import com.introvd.template.template.p407e.C8739i;
import com.introvd.template.template.p407e.C8739i.C8740a;
import com.introvd.template.xyui.video.C9183a;
import com.introvd.template.xyui.video.VideoView;

/* renamed from: com.introvd.template.editor.preview.view.b */
public class C6687b extends Dialog implements OnDismissListener, C9183a {
    /* access modifiers changed from: private */
    public OnClickListener bDF;
    /* access modifiers changed from: private */
    public View cOt;
    /* access modifiers changed from: private */
    public ImageButton clC;
    private MediaPlayer clr;
    private RelativeLayout clu;
    private View dej;
    /* access modifiers changed from: private */
    public VideoView dek;
    private Button del;
    private Button dem;
    private ImageButton den;
    private TextView deo;
    private TextView dep;
    private RelativeLayout deq;
    private Long der = null;
    private boolean det = false;
    private boolean deu = false;
    /* access modifiers changed from: private */
    public String dev = "close";
    private boolean dew = false;
    private int dex = -1;
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public String previewUrl = null;

    public C6687b(Context context) {
        super(context, R.style.xiaoying_style_reward_dialog);
        Window window = getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        window.setAttributes(attributes);
        this.mContext = context;
        this.cOt = LayoutInflater.from(context).inflate(R.layout.xiaoying_template_preview, null);
        this.dej = this.cOt.findViewById(R.id.main_view);
        this.dej.setBackgroundResource(R.color.black_p40);
        this.dej.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (C6687b.this.isShowing()) {
                    C6687b.this.dismiss();
                }
            }
        });
        this.deq = (RelativeLayout) this.cOt.findViewById(R.id.layout_frame);
        this.deq.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
            }
        });
        this.clu = (RelativeLayout) this.cOt.findViewById(R.id.layout_preview);
        this.del = (Button) this.cOt.findViewById(R.id.btn_download);
        this.del.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (C6687b.this.bDF != null) {
                    C6687b.this.bDF.onClick(view);
                    C6687b.this.dev = "unlock";
                }
                C6687b.this.dismiss();
            }
        });
        try {
            this.dek = (VideoView) this.cOt.findViewById(R.id.videoView);
            this.dek.setVideoViewListener(this);
            this.dek.setOnCompletionListener(new OnCompletionListener() {
                public void onCompletion(MediaPlayer mediaPlayer) {
                    C6687b.this.clC.setVisibility(0);
                }
            });
            this.dem = (Button) this.cOt.findViewById(R.id.template_iap_price);
            this.den = (ImageButton) this.cOt.findViewById(R.id.imgbtn_close);
            this.den.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    C6687b.this.dev = "close";
                    if (C6687b.this.isShowing()) {
                        C6687b.this.dismiss();
                    }
                }
            });
            this.clC = (ImageButton) this.cOt.findViewById(R.id.btn_preview_play);
            this.clC.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    C6687b.this.clC.setVisibility(4);
                    C6687b.this.cOt.postDelayed(new Runnable() {
                        public void run() {
                            if (!TextUtils.isEmpty(C6687b.this.previewUrl)) {
                                C6687b.this.dek.start();
                            }
                            C6687b.this.dek.setBackgroundColor(0);
                        }
                    }, 500);
                }
            });
            this.dep = (TextView) this.cOt.findViewById(R.id.preview_text_intro);
            this.deo = (TextView) this.cOt.findViewById(R.id.preview_text_title);
            this.deo.setVisibility(0);
            setOnDismissListener(this);
            setContentView(this.cOt);
        } catch (ClassCastException e) {
            C8048e.aBe().logException(e);
        }
    }

    public boolean aqu() {
        return false;
    }

    public void aqv() {
    }

    public void aqw() {
    }

    public void aqx() {
    }

    /* renamed from: c */
    public void mo30100c(OnClickListener onClickListener) {
        this.bDF = onClickListener;
    }

    /* renamed from: c */
    public void mo30101c(String str, Long l) {
        this.previewUrl = str;
        this.der = l;
    }

    /* renamed from: oT */
    public void mo30102oT(int i) {
        this.dex = i;
        this.deu = false;
        this.dep.setVisibility(8);
        this.dem.setVisibility(8);
        this.del.setVisibility(0);
        this.del.setBackgroundResource(R.drawable.v5_xiaoying_com_template_btn_preview_download_selector);
        switch (i) {
            case 1:
                this.det = true;
                this.dew = true;
                this.del.setText(this.mContext.getString(R.string.xiaoying_str_reward_video_ad_to_watch));
                this.deo.setText(this.mContext.getString(R.string.xiaoying_str_reward_video_ad_to_unlock_material_title));
                return;
            case 2:
                this.dew = true;
                this.del.setText(this.mContext.getString(R.string.xiaoying_str_template_state_download));
                this.deo.setText(this.mContext.getString(R.string.xiaoying_str_reward_video_ad_to_luckily_download_title));
                return;
            case 3:
                this.dew = false;
                this.deu = true;
                this.del.setVisibility(0);
                this.dem.setVisibility(8);
                this.dep.setVisibility(0);
                C8740a x = C8739i.m25532x(this.der);
                String str = "";
                String str2 = "";
                if (x != null) {
                    str = x.etm;
                    str2 = x.mTitle;
                }
                this.dep.setText(str);
                this.deo.setText(str2);
                if (this.mContext instanceof Activity) {
                    boolean isInChina = C8048e.aBe().isInChina();
                    C8038a aVar = new C8038a();
                    aVar.mo33056rY(36).mo33054cY(this.dem).mo33053a(this.del).mo33060sc(isInChina ? R.string.xiaoying_str_vip_duration_limit_confirm : R.string.xiaoying_str_vip_subscribe).mo33061sd(R.string.xiaoying_str_reward_video_ad_to_watch).mo33058sa(this.mContext.getResources().getColor(R.color.color_f0f0f0)).mo33057rZ(R.drawable.v5_xiaoying_iap_template_purchase_diable_bg);
                    C8035c.m23245a((Activity) this.mContext, C8450a.m24469bn(this.der.longValue()).toLowerCase(), this.dem, aVar);
                    C8035c.m23246a((C8039b) new C8039b() {
                        /* renamed from: a */
                        public void mo30119a(Context context, String str, String str2, String str3, int i) {
                            C8049f.aBf().mo33097b(context, str, str2, str3, i);
                        }
                    });
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* renamed from: oU */
    public void mo30103oU(int i) {
    }

    public void onBuffering(boolean z) {
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (this.dek != null) {
            this.dek.mo36197aM(true);
        }
        if (this.dew) {
            C7591a.m22373d(String.valueOf(this.der), this.dev, this.det);
        }
        if (this.deu) {
            String lowerCase = C8450a.m24469bn(this.der.longValue()).toLowerCase();
            UserBehaviorUtils.recordIAPThemePreview(getContext(), this.dev, lowerCase, "edit_theme");
            if ("buy".equals(this.dev)) {
                UserBehaviorUtils.recordIAPTemplateClick(getContext(), "theme_dialog", lowerCase, "edit_theme");
            }
        }
        C8035c.m23246a((C8039b) null);
        C8035c.release();
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        return false;
    }

    public void onPause() {
        this.dek.pause();
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        this.dej.setVisibility(0);
        C4586g.m11696Sm();
        if (this.dek != null) {
            this.clr = this.dek.getmMediaPlayer();
            if (this.clr != null) {
                this.clr.setLooping(true);
            }
            this.cOt.postDelayed(new Runnable() {
                public void run() {
                    if (!TextUtils.isEmpty(C6687b.this.previewUrl)) {
                        C6687b.this.dek.start();
                    }
                    C6687b.this.dek.setBackgroundColor(0);
                }
            }, 500);
        }
    }

    public void onResume() {
        this.dek.start();
        if (this.dex > 0) {
            mo30102oT(this.dex);
        }
    }

    public void show() {
        if ((this.mContext instanceof Activity) && !((Activity) this.mContext).isFinishing()) {
            super.show();
            this.dej.setVisibility(4);
            if (TextUtils.isEmpty(this.previewUrl)) {
                this.clu.setVisibility(8);
                this.dej.setVisibility(0);
            } else {
                C4586g.m11703a(this.mContext, -1, (OnCancelListener) new OnCancelListener() {
                    public void onCancel(DialogInterface dialogInterface) {
                        try {
                            if (!((Activity) C6687b.this.mContext).isFinishing()) {
                                C4586g.m11696Sm();
                                C6687b.this.dismiss();
                            }
                        } catch (IllegalArgumentException e) {
                            C8048e.aBe().logException(e);
                        }
                    }
                });
                this.clu.setVisibility(0);
                this.dek.setBackgroundColor(-16777216);
                this.dek.setVideoURI(Uri.parse(this.previewUrl));
            }
        }
    }
}
