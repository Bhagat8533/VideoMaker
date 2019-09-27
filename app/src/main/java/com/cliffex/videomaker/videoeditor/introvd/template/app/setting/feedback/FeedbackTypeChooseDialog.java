package com.introvd.template.app.setting.feedback;

import android.os.Bundle;
import android.support.p021v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.introvd.template.R;

public class FeedbackTypeChooseDialog extends DialogFragment {
    /* access modifiers changed from: private */
    public C4332a bDc;

    /* renamed from: com.introvd.template.app.setting.feedback.FeedbackTypeChooseDialog$a */
    public interface C4332a {
        /* renamed from: hk */
        void mo24344hk(int i);
    }

    /* renamed from: bS */
    private void m10858bS(View view) {
        view.findViewById(R.id.fb_close).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                FeedbackTypeChooseDialog.this.dismissAllowingStateLoss();
            }
        });
        view.findViewById(R.id.fb_online_container).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (FeedbackTypeChooseDialog.this.bDc != null) {
                    FeedbackTypeChooseDialog.this.dismissAllowingStateLoss();
                    FeedbackTypeChooseDialog.this.bDc.mo24344hk(0);
                }
            }
        });
        view.findViewById(R.id.fb_call_container).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (FeedbackTypeChooseDialog.this.bDc != null) {
                    FeedbackTypeChooseDialog.this.dismissAllowingStateLoss();
                    FeedbackTypeChooseDialog.this.bDc.mo24344hk(1);
                }
            }
        });
    }

    /* renamed from: a */
    public void mo24377a(C4332a aVar) {
        this.bDc = aVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.app_dialog_feedback_type_choose, viewGroup, false);
        getDialog().setCanceledOnTouchOutside(false);
        m10858bS(inflate);
        return inflate;
    }

    public void onStart() {
        super.onStart();
    }
}
