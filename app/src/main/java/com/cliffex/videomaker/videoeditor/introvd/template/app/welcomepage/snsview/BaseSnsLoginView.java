package com.introvd.template.app.welcomepage.snsview;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.introvd.template.R;
import com.introvd.template.common.model.AppStateModel;
import com.quvideo.auth.C4707a;

public abstract class BaseSnsLoginView extends RelativeLayout {
    public static int bIU = 4;
    protected boolean bIV;
    protected boolean bIW;
    protected boolean bIX;
    protected int bIY;
    protected int bIZ;
    protected int bJa;
    protected String countryCode;

    public BaseSnsLoginView(Context context) {
        super(context);
        init(context);
    }

    public BaseSnsLoginView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public BaseSnsLoginView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    @TargetApi(21)
    public BaseSnsLoginView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        init(context);
    }

    private void init(Context context) {
        this.bIV = AppStateModel.getInstance().isInChina();
        this.bIW = AppStateModel.getInstance().isInIndia();
        this.countryCode = AppStateModel.getInstance().getCountryCode();
        this.bIX = AppStateModel.getInstance().canLoginGoogle(context);
        this.bIY = context.getResources().getColor(R.color.color_8E8E93);
        this.bIZ = context.getResources().getColor(R.color.color_155599);
        this.bJa = context.getResources().getColor(R.color.color_b7b7b7);
        mo24728dp(context);
    }

    /* access modifiers changed from: protected */
    /* renamed from: N */
    public boolean mo24727N(Context context, int i) {
        return C4707a.isSnsSDKAndApkInstalled(context, i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: dp */
    public abstract void mo24728dp(Context context);
}
