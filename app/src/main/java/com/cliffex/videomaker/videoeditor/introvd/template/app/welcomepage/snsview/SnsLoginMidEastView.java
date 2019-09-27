package com.introvd.template.app.welcomepage.snsview;

import android.app.Activity;
import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.R;
import com.introvd.template.app.p190j.C4023a;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.router.AppRouter;
import com.introvd.template.util.SpanUtils;
import com.ironsource.sdk.constants.Constants.RequestParameters;

public class SnsLoginMidEastView extends RelativeLayout {
    private ImageView bJA;
    private ImageView bJB;
    /* access modifiers changed from: private */
    public ImageView bJC;
    /* access modifiers changed from: private */
    public C4526a bJD;
    /* access modifiers changed from: private */
    public TextView bJE;
    /* access modifiers changed from: private */
    public LinearLayout bJF;
    private boolean bJG;
    private TextView bJh;
    private RelativeLayout bJt;
    private RelativeLayout bJu;
    /* access modifiers changed from: private */
    public ImageView bJv;
    private ImageView bJw;
    /* access modifiers changed from: private */
    public ImageView bJx;
    private ImageView bJy;
    private ImageView bJz;

    /* renamed from: com.introvd.template.app.welcomepage.snsview.SnsLoginMidEastView$a */
    public interface C4526a {
        /* renamed from: id */
        void mo24718id(int i);
    }

    public SnsLoginMidEastView(Context context) {
        super(context);
        m11429Oj();
    }

    public SnsLoginMidEastView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11429Oj();
    }

    public SnsLoginMidEastView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11429Oj();
    }

    public SnsLoginMidEastView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m11429Oj();
    }

    /* renamed from: In */
    private void m11428In() {
        this.bJt.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (SnsLoginMidEastView.this.bJD != null) {
                    SnsLoginMidEastView.this.bJD.mo24718id(28);
                }
            }
        });
        this.bJu.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (SnsLoginMidEastView.this.bJD != null) {
                    SnsLoginMidEastView.this.bJD.mo24718id(3);
                }
            }
        });
        this.bJv.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                int intValue = ((Integer) SnsLoginMidEastView.this.bJv.getTag()).intValue();
                if (SnsLoginMidEastView.this.bJD != null) {
                    SnsLoginMidEastView.this.bJD.mo24718id(intValue);
                }
            }
        });
        this.bJw.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (SnsLoginMidEastView.this.bJD != null) {
                    SnsLoginMidEastView.this.bJD.mo24718id(29);
                }
            }
        });
        this.bJy.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (SnsLoginMidEastView.this.bJD != null) {
                    SnsLoginMidEastView.this.bJD.mo24718id(38);
                }
            }
        });
        this.bJx.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                int intValue = ((Integer) SnsLoginMidEastView.this.bJx.getTag()).intValue();
                if (SnsLoginMidEastView.this.bJD != null) {
                    SnsLoginMidEastView.this.bJD.mo24718id(intValue);
                }
            }
        });
        this.bJC.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                SnsLoginMidEastView.this.bJF.setVisibility(0);
                SnsLoginMidEastView.this.bJC.setVisibility(8);
                SnsLoginMidEastView.this.bJE.setOnClickListener(null);
            }
        });
    }

    /* renamed from: Oj */
    private void m11429Oj() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.app_layout_mideast_wel_login, this, true);
        this.bJt = (RelativeLayout) inflate.findViewById(R.id.login_wel_fb_rl);
        this.bJu = (RelativeLayout) inflate.findViewById(R.id.login_wel_phone_rl);
        this.bJv = (ImageView) inflate.findViewById(R.id.login_wel_google);
        this.bJx = (ImageView) inflate.findViewById(R.id.login_wel_ins);
        this.bJw = (ImageView) inflate.findViewById(R.id.login_wel_twitter);
        this.bJy = (ImageView) inflate.findViewById(R.id.login_wel_line);
        this.bJz = (ImageView) inflate.findViewById(R.id.login_wel_phone);
        this.bJh = (TextView) inflate.findViewById(R.id.login_wel_terms_and_privacy);
        this.bJA = (ImageView) inflate.findViewById(R.id.login_wel_wire1);
        this.bJB = (ImageView) inflate.findViewById(R.id.login_wel_wire2);
        this.bJC = (ImageView) inflate.findViewById(R.id.login_wel_more_arrow);
        this.bJE = (TextView) inflate.findViewById(R.id.login_wel_other_text);
        this.bJF = (LinearLayout) inflate.findViewById(R.id.login_wel_other_ll);
        this.bJG = AppStateModel.getInstance().canLoginGoogle(getContext());
        m11430RC();
        setTestABMode(C4023a.m9973MK().getLoginPopUIStyle());
        m11428In();
    }

    /* renamed from: RC */
    private void m11430RC() {
        String string = getContext().getString(R.string.xiaoying_str_community_pre_terms_and_privacy);
        SpanUtils spanUtils = new SpanUtils();
        String string2 = getContext().getString(R.string.xiaoying_str_setting_about_privacy_text4);
        String string3 = getContext().getString(R.string.xiaoying_str_setting_about_privacy_text1);
        spanUtils.mo35760B(string).mo35767vH(getResources().getColor(R.color.color_8e8e93)).mo35766vG(33);
        spanUtils.mo35760B(string2).mo35767vH(getResources().getColor(R.color.color_155599)).mo35761a(new ClickableSpan() {
            public void onClick(View view) {
                String str = "https://hybrid.xiaoying.tv/web/vivavideo/User_Agreement.html";
                if (SnsLoginMidEastView.this.getContext() != null) {
                    AppRouter.startWebPage((Activity) SnsLoginMidEastView.this.getContext(), str, null);
                }
            }
        }).mo35766vG(33);
        spanUtils.mo35760B(RequestParameters.AMPERSAND).mo35767vH(getResources().getColor(R.color.color_8e8e93)).mo35766vG(33);
        spanUtils.mo35760B(string3).mo35767vH(getResources().getColor(R.color.color_155599)).mo35761a(new ClickableSpan() {
            public void onClick(View view) {
                String str = "https://hybrid.xiaoying.tv/web/vivavideo/terms_privacy.html";
                if (SnsLoginMidEastView.this.getContext() != null) {
                    AppRouter.startWebPage((Activity) SnsLoginMidEastView.this.getContext(), str, null);
                }
            }
        }).mo35766vG(33);
        this.bJh.setText(spanUtils.aNl());
        this.bJh.setMovementMethod(new LinkMovementMethod());
    }

    public void setSnsItemClick(C4526a aVar) {
        this.bJD = aVar;
    }

    public void setTestABMode(boolean z) {
        int i = 8;
        if (z) {
            this.bJz.setVisibility(0);
            this.bJu.setVisibility(8);
            this.bJA.setVisibility(8);
            this.bJB.setVisibility(8);
            this.bJF.setVisibility(4);
            this.bJC.setVisibility(0);
            ImageView imageView = this.bJx;
            if (this.bJG) {
                i = 0;
            }
            imageView.setVisibility(i);
            this.bJv.setTag(Integer.valueOf(31));
            this.bJv.setImageResource(R.drawable.app_wel_login_ins_icon);
            this.bJx.setTag(Integer.valueOf(25));
            this.bJx.setImageResource(R.drawable.app_wel_login_google_icon);
            this.bJE.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    SnsLoginMidEastView.this.bJF.setVisibility(0);
                    SnsLoginMidEastView.this.bJC.setVisibility(8);
                    SnsLoginMidEastView.this.bJE.setOnClickListener(null);
                }
            });
            return;
        }
        this.bJz.setVisibility(8);
        this.bJu.setVisibility(0);
        this.bJA.setVisibility(0);
        this.bJB.setVisibility(0);
        this.bJF.setVisibility(0);
        this.bJC.setVisibility(8);
        ImageView imageView2 = this.bJv;
        if (this.bJG) {
            i = 0;
        }
        imageView2.setVisibility(i);
        this.bJv.setTag(Integer.valueOf(25));
        this.bJv.setImageResource(R.drawable.app_wel_login_google_icon);
        this.bJx.setTag(Integer.valueOf(31));
        this.bJx.setImageResource(R.drawable.app_wel_login_ins_icon);
        this.bJE.setOnClickListener(null);
    }
}
