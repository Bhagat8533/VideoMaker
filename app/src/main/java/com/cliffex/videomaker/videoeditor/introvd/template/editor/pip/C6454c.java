package com.introvd.template.editor.pip;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import com.introvd.template.common.LogUtils;
import com.introvd.template.editor.R;

/* renamed from: com.introvd.template.editor.pip.c */
public class C6454c {

    /* renamed from: Jn */
    private View f3509Jn;
    private WindowManager bRY;
    private float bSb;
    /* access modifiers changed from: private */
    public C6458a cWJ;
    /* access modifiers changed from: private */
    public int cXm = -1;
    /* access modifiers changed from: private */
    public boolean cXn = false;
    /* access modifiers changed from: private */
    public ImageButton cXo;
    /* access modifiers changed from: private */
    public ImageButton cXp;
    /* access modifiers changed from: private */
    public ImageButton cXq;
    private CheckBox cXr;
    OnCheckedChangeListener cXs = new OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            C6454c.this.cXn = !z;
            LogUtils.m14223i("PIPPopupMenu", "onClick mBtnMutevideo");
            if (C6454c.this.cWJ != null) {
                C6454c.this.cWJ.mo29544S(C6454c.this.cXm, C6454c.this.aoc());
            }
        }
    };
    private Context mContext;
    private LayoutInflater mInflater;
    /* access modifiers changed from: private */
    public PopupWindow mPopupWindow;
    private int mWidth = 100;

    /* renamed from: po */
    private OnClickListener f3510po = new OnClickListener() {
        public void onClick(View view) {
            if (view.equals(C6454c.this.cXo)) {
                LogUtils.m14223i("PIPPopupMenu", "onClick mBtnPick");
                if (C6454c.this.cWJ != null) {
                    C6454c.this.cWJ.mo29546nT(C6454c.this.cXm);
                }
                C6454c.this.dismiss();
            } else if (view.equals(C6454c.this.cXp)) {
                LogUtils.m14223i("PIPPopupMenu", "onClick mBtnRotate");
                if (C6454c.this.cWJ != null) {
                    C6454c.this.cWJ.mo29545nS(C6454c.this.cXm);
                }
            } else if (view.equals(C6454c.this.cXq)) {
                LogUtils.m14223i("PIPPopupMenu", "onClick mBtnFlip");
                if (C6454c.this.cWJ != null) {
                    C6454c.this.cWJ.mo29547nU(C6454c.this.cXm);
                }
            }
        }
    };

    /* renamed from: com.introvd.template.editor.pip.c$a */
    public interface C6458a {
        /* renamed from: S */
        void mo29544S(int i, boolean z);

        /* renamed from: nS */
        void mo29545nS(int i);

        /* renamed from: nT */
        void mo29546nT(int i);

        /* renamed from: nU */
        void mo29547nU(int i);
    }

    public C6454c(Context context, boolean z) {
        this.mContext = context;
        this.cXn = z;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.bRY = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.bRY.getDefaultDisplay().getMetrics(displayMetrics);
        this.bSb = displayMetrics.scaledDensity;
        this.mPopupWindow = new PopupWindow(context);
        this.mPopupWindow.setTouchInterceptor(new OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 4) {
                    return false;
                }
                C6454c.this.mPopupWindow.dismiss();
                return true;
            }
        });
        setContentView(this.mInflater.inflate(R.layout.editor_pip_popup_menu, null));
    }

    /* renamed from: WU */
    private void m18658WU() {
        this.mPopupWindow.setWidth((int) (((float) this.mWidth) * this.bSb));
        this.mPopupWindow.setHeight(-2);
        this.mPopupWindow.setTouchable(true);
        this.mPopupWindow.setFocusable(true);
        this.mPopupWindow.setOutsideTouchable(true);
        this.mPopupWindow.setAnimationStyle(16973826);
        this.mPopupWindow.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.drawable_color_transparent));
    }

    private void setContentView(View view) {
        this.f3509Jn = view;
        this.cXo = (ImageButton) this.f3509Jn.findViewById(R.id.xiaoying_ve_pip_popmenu_btn_pick);
        this.cXp = (ImageButton) this.f3509Jn.findViewById(R.id.xiaoying_ve_pip_popmenu_btn_rotate);
        this.cXq = (ImageButton) this.f3509Jn.findViewById(R.id.xiaoying_ve_pip_popmenu_btn_flip);
        this.cXr = (CheckBox) view.findViewById(R.id.xiaoying_ve_pip_popmenu_chkbox_mutevideo);
        this.cXr.setChecked(!aoc());
        this.cXr.setOnCheckedChangeListener(this.cXs);
        this.cXq.setOnClickListener(this.f3510po);
        this.cXp.setOnClickListener(this.f3510po);
        this.cXo.setOnClickListener(this.f3510po);
        this.mPopupWindow.setContentView(view);
    }

    /* renamed from: a */
    public void mo29622a(C6458a aVar) {
        this.cWJ = aVar;
    }

    public boolean aoc() {
        return this.cXn;
    }

    public void dismiss() {
        if (this.mPopupWindow != null && this.mPopupWindow.isShowing()) {
            this.mPopupWindow.dismiss();
        }
    }

    /* renamed from: n */
    public void mo29625n(Rect rect) {
        m18658WU();
        if (rect == null || rect.width() <= 0 || rect.height() <= 0) {
            this.mPopupWindow.showAtLocation(((Activity) this.mContext).getWindow().getDecorView(), 17, 0, 0);
            return;
        }
        this.f3509Jn.invalidate();
        int centerX = rect.centerX() - (this.mPopupWindow.getWidth() / 2);
        int centerY = rect.centerY() - 20;
        this.mPopupWindow.showAtLocation(((Activity) this.mContext).getWindow().getDecorView(), 51, centerX, centerY);
    }

    /* renamed from: oc */
    public void mo29626oc(int i) {
        this.cXm = i;
    }
}
