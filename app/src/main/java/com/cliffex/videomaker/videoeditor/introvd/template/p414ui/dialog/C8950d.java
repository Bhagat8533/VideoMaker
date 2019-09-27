package com.introvd.template.p414ui.dialog;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.introvd.template.common.LogUtils;
import com.introvd.template.p414ui.dialog.C8966i.C8968a;
import java.lang.ref.WeakReference;
import xiaoying.quvideo.com.vivabase.C10122R;

/* renamed from: com.introvd.template.ui.dialog.d */
public class C8950d extends C8943a implements OnClickListener {
    private C8955b cxK;
    private C8956c ewF;
    /* access modifiers changed from: private */
    public EditText ewG;
    private CharSequence ewH;
    private boolean ewI = true;
    /* access modifiers changed from: private */
    public Context mContext;
    private Handler mHandler = new C8954a(this);

    /* renamed from: com.introvd.template.ui.dialog.d$a */
    private static class C8954a extends Handler {
        private WeakReference<C8950d> ewK = null;

        public C8954a(C8950d dVar) {
            this.ewK = new WeakReference<>(dVar);
        }

        public void handleMessage(Message message) {
            C8950d dVar = (C8950d) this.ewK.get();
            if (!(dVar == null || message.what != 0 || dVar.ewG == null)) {
                dVar.ewG.setSelection(0, dVar.ewG.getText().length());
                dVar.ewG.requestFocus();
                ((InputMethodManager) dVar.mContext.getSystemService("input_method")).showSoftInput(dVar.ewG, 0);
            }
        }
    }

    /* renamed from: com.introvd.template.ui.dialog.d$b */
    public interface C8955b {
        /* renamed from: gv */
        boolean mo27669gv(String str);
    }

    /* renamed from: com.introvd.template.ui.dialog.d$c */
    public interface C8956c {
        /* renamed from: a */
        void mo27683a(int i, CharSequence charSequence);
    }

    public C8950d(Context context, CharSequence charSequence, C8956c cVar, boolean z) {
        super(context, C10122R.style.xiaoying_style_edit_dialog);
        this.f3621PM = LayoutInflater.from(context).inflate(C10122R.C10126layout.xiaoying_com_dialog_text_edit, null);
        this.ewN.f3623zd = this.f3621PM;
        this.mContext = context;
        this.ewH = charSequence;
        this.ewF = cVar;
        this.ewI = z;
    }

    /* renamed from: a */
    public void mo35604a(C8955b bVar) {
        this.cxK = bVar;
    }

    public void onClick(View view) {
        switch ((C8968a) view.getTag()) {
            case POSITIVE:
                if (this.cxK == null) {
                    if (this.ewF != null) {
                        this.ewF.mo27683a(1, this.ewG.getText());
                        break;
                    }
                } else if (this.cxK.mo27669gv(this.ewG.getText().toString())) {
                    if (this.ewF != null) {
                        this.ewF.mo27683a(1, this.ewG.getText());
                        break;
                    }
                } else {
                    return;
                }
                break;
            case NEGATIVE:
                if (this.ewF != null) {
                    this.ewF.mo27683a(0, this.ewH);
                    break;
                }
                break;
        }
        dismiss();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ewG = (EditText) findViewById(C10122R.C10124id.edit_text);
        this.ewG.setText(this.ewH);
        C89511 r5 = new OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return keyEvent != null && keyEvent.getKeyCode() == 66;
            }
        };
        C89522 r0 = new InputFilter() {
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                if ("\n".equals(charSequence)) {
                    return "";
                }
                StringBuilder sb = new StringBuilder();
                sb.append("filter source=");
                sb.append(charSequence);
                sb.append(";dest=");
                sb.append(spanned);
                LogUtils.m14223i("TextWatcher", sb.toString());
                return null;
            }
        };
        if (this.ewI) {
            this.ewG.setFilters(new InputFilter[]{r0});
            this.ewG.setOnEditorActionListener(r5);
        }
        this.ewG.clearFocus();
        this.mHandler.sendEmptyMessageDelayed(0, 300);
    }
}
