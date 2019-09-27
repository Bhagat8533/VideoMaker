package com.introvd.template.editor.gallery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.editor.R;

/* renamed from: com.introvd.template.editor.gallery.a */
public class C6327a {
    /* access modifiers changed from: private */
    public RelativeLayout cSO;
    /* access modifiers changed from: private */
    public RelativeLayout cSP;
    /* access modifiers changed from: private */
    public PopupWindow cSQ;
    private int cSR = 1;
    /* access modifiers changed from: private */
    public C6331a cSS;
    private Context mContext;

    /* renamed from: po */
    private OnClickListener f3505po = new OnClickListener() {
        public void onClick(View view) {
            if (view.equals(C6327a.this.cSO)) {
                C6327a.this.mo29328nA(1);
            } else if (view.equals(C6327a.this.cSP)) {
                C6327a.this.mo29328nA(0);
            }
            if (C6327a.this.cSQ != null && C6327a.this.cSQ.isShowing()) {
                C6327a.this.cSQ.dismiss();
            }
        }
    };

    /* renamed from: com.introvd.template.editor.gallery.a$a */
    public interface C6331a {
        /* renamed from: nx */
        void mo29305nx(int i);

        void onDismiss();
    }

    public C6327a(Context context, C6331a aVar) {
        this.mContext = context;
        this.cSS = aVar;
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.gallery_tab_title_pop_layout, null);
        this.cSQ = new PopupWindow(inflate, -2, -2, true);
        this.cSQ.setTouchable(true);
        this.cSQ.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.color.transparent));
        this.cSQ.setTouchInterceptor(new OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        });
        this.cSQ.setOnDismissListener(new OnDismissListener() {
            public void onDismiss() {
                if (C6327a.this.cSS != null) {
                    C6327a.this.cSS.onDismiss();
                }
            }
        });
        if (inflate != null) {
            this.cSO = (RelativeLayout) inflate.findViewById(R.id.xiaoying_gallery_video_tab);
            this.cSP = (RelativeLayout) inflate.findViewById(R.id.xiaoying_gallery_photo_tab);
            this.cSO.setOnClickListener(this.f3505po);
            this.cSP.setOnClickListener(this.f3505po);
        }
        mo29328nA(1);
    }

    /* renamed from: a */
    private void m18121a(RelativeLayout relativeLayout, boolean z) {
        if (relativeLayout != null) {
            TextView textView = (TextView) relativeLayout.getChildAt(0);
            if (z) {
                textView.setTextColor(this.mContext.getResources().getColor(R.color.color_fd6132));
            } else {
                textView.setTextColor(-1);
            }
        }
    }

    /* renamed from: B */
    public void mo29326B(View view, int i) {
        this.cSQ.showAtLocation(view, 48, 0, i);
    }

    public int amG() {
        int i = this.cSO.getVisibility() == 0 ? 1 : 0;
        return this.cSP.getVisibility() == 0 ? i + 1 : i;
    }

    /* renamed from: nA */
    public void mo29328nA(int i) {
        if (i == 1) {
            m18121a(this.cSO, true);
            m18121a(this.cSP, false);
        } else if (i == 0) {
            m18121a(this.cSO, false);
            m18121a(this.cSP, true);
        }
        this.cSR = i;
        if (this.cSS != null) {
            this.cSS.mo29305nx(i);
        }
    }

    /* renamed from: nz */
    public void mo29329nz(int i) {
        switch (i) {
            case 0:
                this.cSO.setVisibility(0);
                this.cSP.setVisibility(0);
                return;
            case 1:
                this.cSP.setVisibility(8);
                this.cSO.setVisibility(8);
                this.cSR = 1;
                return;
            case 2:
                this.cSP.setVisibility(8);
                this.cSO.setVisibility(8);
                this.cSR = 0;
                return;
            default:
                this.cSO.setVisibility(0);
                this.cSP.setVisibility(0);
                return;
        }
    }
}
