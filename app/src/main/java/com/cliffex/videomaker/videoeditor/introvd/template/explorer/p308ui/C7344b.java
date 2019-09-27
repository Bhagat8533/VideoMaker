package com.introvd.template.explorer.p308ui;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.introvd.template.p414ui.dialog.C8943a;
import com.introvd.template.p414ui.dialog.C8966i.C8968a;
import com.introvd.template.vivaexplorermodule.R;

/* renamed from: com.introvd.template.explorer.ui.b */
public class C7344b extends C8943a {
    public static int dDC = -1;
    private ImageView aMK = ((ImageView) this.f3621PM.findViewById(R.id.custom_iv_finished));
    private C7346a dDB;
    private Animation dDD;
    private TextView mTextView = ((TextView) this.f3621PM.findViewById(R.id.custom_content));

    /* renamed from: com.introvd.template.explorer.ui.b$a */
    public interface C7346a {
        void awx();
    }

    public C7344b(Context context, C7346a aVar) {
        super(context);
        this.dDB = aVar;
        this.f3621PM = LayoutInflater.from(context).inflate(R.layout.xiaoying_com_dialog_scan, null);
        this.mTextView.setSingleLine();
        this.mTextView.setEllipsize(TruncateAt.MIDDLE);
        this.dDD = AnimationUtils.loadAnimation(context, R.anim.xiaoying_anim_rotate_loading);
        this.dDD.setInterpolator(new LinearInterpolator());
    }

    /* renamed from: Q */
    public void mo31986Q(Object obj) {
        if (obj instanceof Integer) {
            this.ewN.title = this.ewN.context.getText(((Integer) obj).intValue());
        } else if (obj instanceof String) {
            this.ewN.title = (CharSequence) obj;
        }
    }

    /* renamed from: jq */
    public void mo31987jq(String str) {
        if (this.mTextView != null) {
            this.mTextView.setText(str);
        }
    }

    public void onClick(View view) {
        switch ((C8968a) view.getTag()) {
            case POSITIVE:
                if (this.dDB != null) {
                    this.dDB.awx();
                    break;
                }
                break;
            case NEGATIVE:
                if (this.dDB != null) {
                    this.dDB.awx();
                    break;
                }
                break;
        }
        dismiss();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.aMK.startAnimation(this.dDD);
    }

    /* renamed from: ra */
    public void mo31990ra(int i) {
        if (this.aMK != null) {
            this.aMK.clearAnimation();
            this.aMK.setImageResource(i);
        }
    }
}
