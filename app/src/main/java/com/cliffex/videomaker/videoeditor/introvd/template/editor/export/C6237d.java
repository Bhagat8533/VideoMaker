package com.introvd.template.editor.export;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.afollestad.materialdialogs.C1890f;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.editor.R;
import com.introvd.template.p414ui.dialog.C8978m;
import java.util.HashMap;

/* renamed from: com.introvd.template.editor.export.d */
class C6237d {

    /* renamed from: com.introvd.template.editor.export.d$a */
    interface C6243a {
        /* renamed from: nn */
        void mo29086nn(int i);
    }

    /* renamed from: a */
    static void m17889a(Context context, final C6243a aVar) {
        View eX = m17891eX(context);
        final C1890f qu = C8978m.m26349hs(context).mo10307g(eX, false).mo10313qu();
        View findViewById = eX.findViewById(R.id.viewItem1);
        View findViewById2 = eX.findViewById(R.id.viewItem2);
        final CheckBox checkBox = (CheckBox) eX.findViewById(R.id.chb1);
        final CheckBox checkBox2 = (CheckBox) eX.findViewById(R.id.chb2);
        final View findViewById3 = eX.findViewById(R.id.btnOk);
        m17890a(checkBox, checkBox2);
        if (checkBox.isChecked() || checkBox2.isChecked()) {
            findViewById3.setEnabled(true);
        } else {
            findViewById3.setEnabled(false);
        }
        findViewById.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                checkBox.setChecked(true);
                checkBox2.setChecked(false);
                findViewById3.setEnabled(true);
            }
        });
        findViewById2.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                checkBox.setChecked(false);
                checkBox2.setChecked(true);
                findViewById3.setEnabled(true);
            }
        });
        checkBox.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                checkBox.setChecked(true);
                checkBox2.setChecked(false);
                findViewById3.setEnabled(true);
            }
        });
        checkBox2.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                checkBox.setChecked(false);
                checkBox2.setChecked(true);
                findViewById3.setEnabled(true);
            }
        });
        findViewById3.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (aVar != null) {
                    boolean isChecked = checkBox.isChecked();
                    aVar.mo29086nn(isChecked ? 1 : 0);
                    C6237d.m17892nl(isChecked);
                }
                qu.dismiss();
            }
        });
        qu.show();
        aln();
    }

    /* renamed from: a */
    private static void m17890a(CheckBox checkBox, CheckBox checkBox2) {
        int IN = C3742b.m9111II().mo23120IN();
        if (IN == 0) {
            checkBox.setChecked(false);
            checkBox2.setChecked(false);
        } else if (IN == 1) {
            checkBox.setChecked(false);
            checkBox2.setChecked(true);
        } else if (IN == 2) {
            checkBox.setChecked(true);
            checkBox2.setChecked(false);
        }
    }

    private static void aln() {
        UserBehaviorLog.onKVEvent(VivaBaseApplication.m8749FZ(), "Publish_Resolution_Pop_show", new HashMap());
    }

    /* renamed from: eX */
    private static View m17891eX(Context context) {
        return LayoutInflater.from(context).inflate(R.layout.editor_dialog_export_choose_simple, null, false);
    }

    /* access modifiers changed from: private */
    /* renamed from: nl */
    public static void m17892nl(int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", i == 1 ? "720P" : "480P");
        UserBehaviorLog.onKVEvent(VivaBaseApplication.m8749FZ(), "Publish_Resolution_Pop_Confirm_Click", hashMap);
    }
}
