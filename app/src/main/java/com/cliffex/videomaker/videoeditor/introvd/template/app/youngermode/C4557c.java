package com.introvd.template.app.youngermode;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.introvd.template.R;
import com.introvd.template.app.youngermode.p202b.C4556a;
import com.introvd.template.common.ResultListener;
import com.introvd.template.explorer.extract.C7234b;
import com.introvd.template.router.AppRouter;

/* renamed from: com.introvd.template.app.youngermode.c */
public class C4557c extends Dialog {
    private TextView bKi;
    private TextView bjW;
    /* access modifiers changed from: private */
    public Context mContext;
    private TextView mTvCancel;
    /* access modifiers changed from: private */
    public int mType;

    public C4557c(Context context, int i) {
        super(context, R.style.xiaoying_style_younger_dialog);
        this.mType = i;
        this.mContext = context;
        setCancelable(true);
        setCanceledOnTouchOutside(false);
    }

    /* renamed from: RM */
    private void m11513RM() {
        if (this.mType == 1) {
            this.bjW.setText(R.string.viva_younger_open_content);
            this.bKi.setText(R.string.viva_younger_into_mode);
            return;
        }
        this.bjW.setText(R.string.viva_younger_close_content);
        this.bKi.setText(R.string.viva_younger_enter_password);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_younger_open);
        this.bjW = (TextView) findViewById(R.id.dialog_younger_content);
        this.bKi = (TextView) findViewById(R.id.dialog_younger_enter);
        this.mTvCancel = (TextView) findViewById(R.id.dialog_younger_cancel);
        this.bKi.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (C4557c.this.mType == 1) {
                    C4556a.m11507ae(C4557c.this.mContext, "on");
                    AppRouter.startWebPage((Activity) C4557c.this.mContext, "https://hybrid.xiaoying.tv/web/vivavideo/shaonian.html", "");
                } else if (C4557c.this.mType == 2) {
                    AppRouter.startYoungerModeSetting(C4557c.this.mContext, 5);
                }
                C4557c.this.dismiss();
            }
        });
        this.mTvCancel.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (2 == C4557c.this.mType) {
                    ResultListener RL = C4553b.m11491RJ().mo24786RL();
                    if (RL != null) {
                        RL.onError(new Exception(C7234b.TAG));
                    }
                } else if (1 == C4557c.this.mType) {
                    C4556a.m11507ae(C4557c.this.mContext, "cancel");
                    C4560d.m11516RN().mo24812cb(false);
                }
                C4557c.this.dismiss();
            }
        });
        m11513RM();
    }
}
