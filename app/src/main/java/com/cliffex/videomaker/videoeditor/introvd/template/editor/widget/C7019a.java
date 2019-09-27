package com.introvd.template.editor.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.afollestad.materialdialogs.C1885b;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1904j;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.editor.R;
import com.introvd.template.p414ui.dialog.C8978m;

/* renamed from: com.introvd.template.editor.widget.a */
public class C7019a extends Dialog {
    private ProgressBar bqi;
    private TextView cDq;
    /* access modifiers changed from: private */
    public C1890f cQt;
    private TextView dqd;
    private ImageButton dqe;
    /* access modifiers changed from: private */
    public C7023a dqf;
    private int dqg;
    private int progress = 0;

    /* renamed from: com.introvd.template.editor.widget.a$a */
    public interface C7023a {
        void onCancel();
    }

    public C7019a(Context context, int i) {
        super(context, R.style.xiaoying_style_com_dialog);
        setCancelable(true);
        this.dqg = i;
    }

    /* access modifiers changed from: private */
    public void auB() {
        if (this.cQt == null) {
            String string = getContext().getString(R.string.xiaoying_str_com_ok);
            this.cQt = C8978m.m26348af(getContext(), getContext().getString(R.string.xiaoying_str_com_cancel), string).mo10296do(R.string.editor_gallery_transcode_cancel_tip).mo10281a((C1904j) new C1904j() {
                public void onClick(C1890f fVar, C1885b bVar) {
                    if (C7019a.this.dqf != null) {
                        C7019a.this.dqf.onCancel();
                    }
                    C7019a.this.setProgress(0);
                    C7019a.this.dismiss();
                }
            }).mo10313qu();
        }
        this.cQt.show();
    }

    /* renamed from: a */
    public void mo30938a(C7023a aVar) {
        this.dqf = aVar;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.editor_trascoding_layout);
        this.cDq = (TextView) findViewById(R.id.tv_import_scene_progress);
        this.dqd = (TextView) findViewById(R.id.txtview_progressview);
        this.bqi = (ProgressBar) findViewById(R.id.progress_bar_import);
        this.bqi.setMax(100);
        this.dqe = (ImageButton) findViewById(R.id.iv_cancel);
        this.dqe.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C7019a.this.auB();
            }
        });
        setOnDismissListener(new OnDismissListener() {
            public void onDismiss(DialogInterface dialogInterface) {
                if (C7019a.this.cQt != null) {
                    C7019a.this.cQt.dismiss();
                    C7019a.this.cQt = null;
                }
            }
        });
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        auB();
        return true;
    }

    /* renamed from: qb */
    public void mo30941qb(int i) {
        this.progress += i;
        setProgress(this.progress);
    }

    /* renamed from: qc */
    public void mo30942qc(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("onProgress updateSecondProgress progress=");
        sb.append(i);
        LogUtilsV2.m14230i(sb.toString());
        if (this.bqi != null) {
            this.bqi.setProgress(i);
            this.bqi.postInvalidate();
        }
        if (this.dqd != null) {
            TextView textView = this.dqd;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(i);
            sb2.append("%");
            textView.setText(sb2.toString());
        }
    }

    public void setProgress(int i) {
        if (this.cDq != null) {
            String valueOf = String.valueOf(i);
            String valueOf2 = String.valueOf(this.dqg);
            String string = getContext().getString(R.string.editor_gallery_transcode_prog_fmt, new Object[]{valueOf, valueOf2});
            StringBuilder sb = new StringBuilder();
            sb.append("transService setProgress value=");
            sb.append(valueOf);
            sb.append(",maxValue=");
            sb.append(valueOf2);
            sb.append("; obj=");
            sb.append(this);
            LogUtilsV2.m14230i(sb.toString());
            this.cDq.setText(string);
        }
    }
}
