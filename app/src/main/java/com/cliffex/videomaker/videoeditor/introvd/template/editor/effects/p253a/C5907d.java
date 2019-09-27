package com.introvd.template.editor.effects.p253a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.editor.R;

/* renamed from: com.introvd.template.editor.effects.a.d */
public class C5907d {
    private View bse;
    private PopupWindow mPopupWindow;

    public C5907d() {
        akU();
    }

    private void akU() {
        this.mPopupWindow = new PopupWindow();
        this.bse = LayoutInflater.from(VivaBaseApplication.m8749FZ()).inflate(R.layout.editor_effect_keyframe_scroll_timeline_tip, null);
    }

    /* renamed from: LI */
    public void mo28508LI() {
        if (this.mPopupWindow != null && this.mPopupWindow.isShowing()) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
    }

    /* renamed from: h */
    public void mo28509h(View view, int i, int i2) {
        if (this.mPopupWindow == null) {
            this.mPopupWindow = new PopupWindow();
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i3 = iArr[0] + i;
        int i4 = iArr[1] + i2;
        this.mPopupWindow.setWidth(-2);
        this.mPopupWindow.setHeight(-2);
        this.mPopupWindow.setContentView(this.bse);
        this.bse.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C5907d.this.mo28508LI();
            }
        });
        try {
            this.mPopupWindow.showAtLocation(view, 51, i3, i4);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
