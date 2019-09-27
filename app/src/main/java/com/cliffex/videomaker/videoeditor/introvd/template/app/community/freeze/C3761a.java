package com.introvd.template.app.community.freeze;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.introvd.template.R;
import com.introvd.template.app.p199v5.common.C4420c;
import com.introvd.template.app.p199v5.common.C4420c.C4421a;
import com.introvd.template.app.utils.C4395c;
import com.introvd.template.component.feedback.C5349b;
import com.introvd.template.p203b.C4580b;

/* renamed from: com.introvd.template.app.community.freeze.a */
public class C3761a extends Dialog implements OnClickListener {
    private TextView bjW;
    /* access modifiers changed from: private */
    public TextView bjX;
    private TextView bjY;
    private TextView bjZ;
    private TextView bka;
    private TextView bkb;
    private C4421a bkc;
    /* access modifiers changed from: private */
    public C4420c bkd;
    /* access modifiers changed from: private */
    public String bke;
    private String bkf;
    /* access modifiers changed from: private */
    public int count = 0;
    /* access modifiers changed from: private */
    public Context mContext;
    private int mType;

    public C3761a(Context context, String str) {
        super(context, R.style.xiaoying_style_freeze_dialog);
        this.mContext = context;
        this.bkf = str;
    }

    /* renamed from: In */
    private void m9221In() {
        this.bjY.setOnClickListener(this);
        this.bjZ.setOnClickListener(this);
        this.bka.setOnClickListener(this);
        this.bkc = new C4421a() {
            public void handleMessage(Message message) {
                if (message.what == 5) {
                    C3761a.this.bke = C3763b.m9232It();
                    if (!TextUtils.isEmpty(C3761a.this.bke)) {
                        C3761a.this.bjX.setText(C3761a.this.mContext.getString(R.string.viva_freeze_reason_text, new Object[]{C3761a.this.bke}));
                    } else if (C3761a.this.count < 3) {
                        C3761a.this.count = C3761a.this.count + 1;
                        C3761a.this.bkd.sendEmptyMessageDelayed(5, 1000);
                    }
                }
            }
        };
        this.bkd.mo24501a(this.bkc);
    }

    /* renamed from: Io */
    private void m9222Io() {
        if (this.mType == 105) {
            this.bjW.setText(R.string.viva_freeze_reason_login_msg2);
        } else if (this.mType != 203) {
        } else {
            if (!TextUtils.isEmpty(this.bkf)) {
                this.bjW.setText(R.string.viva_freeze_reason_login_msg);
            } else {
                this.bjW.setText(R.string.viva_freeze_reason_no_login_msg);
            }
        }
    }

    /* renamed from: Ip */
    private void m9223Ip() {
        StringBuilder sb = new StringBuilder();
        sb.append("Duid : ");
        sb.append(C4580b.m11653dz(this.mContext));
        String sb2 = sb.toString();
        if (!TextUtils.isEmpty(this.bkf)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2);
            sb3.append(" Auid : ");
            sb3.append(this.bkf);
            sb2 = sb3.toString();
        }
        C4395c.m11090a((Activity) this.mContext, sb2, 16, this.mContext.getString(R.string.xiaoying_feedback_freeze_issue_type_content));
    }

    public void onClick(View view) {
        if (view.equals(this.bjY)) {
            dismiss();
        } else if (view.equals(this.bjZ)) {
            m9223Ip();
            dismiss();
        } else if (view.equals(this.bka) && (this.mContext instanceof Activity)) {
            if (C5349b.m14581ej(this.mContext)) {
                C4395c.m11089a((Activity) this.mContext, -1, true);
            } else {
                m9223Ip();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_freeze_reason);
        this.bjW = (TextView) findViewById(R.id.dialog_freeze_content);
        this.bjX = (TextView) findViewById(R.id.dialog_freeze_reason);
        this.bjZ = (TextView) findViewById(R.id.dialog_freeze_positive);
        this.bjY = (TextView) findViewById(R.id.dialog_freeze_negative);
        this.bka = (TextView) findViewById(R.id.dialog_freeze_go_message);
        this.bkb = (TextView) findViewById(R.id.dialog_freeze_go_message_count);
        this.bkd = new C4420c();
        this.mType = C3763b.getFreezeCode();
        this.bkd.sendEmptyMessage(5);
        m9221In();
        m9222Io();
    }

    public void setUserId(String str) {
        this.bkf = str;
    }
}
