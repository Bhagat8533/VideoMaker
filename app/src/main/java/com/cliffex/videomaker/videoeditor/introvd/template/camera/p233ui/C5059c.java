package com.introvd.template.camera.p233ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.camera.p233ui.C5054b.C5055a;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.vivacamera.R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.introvd.template.camera.ui.c */
public class C5059c extends C5054b {
    private static float bRW = 40.0f;
    private static float bRX = 10.0f;

    /* renamed from: Jn */
    private View f3428Jn;
    private WindowManager bRY;
    private ListView bRZ;
    /* access modifiers changed from: private */
    public List<C5055a> bSa;
    private float bSb;

    /* renamed from: eh */
    private int f3429eh;
    protected Context mContext;
    /* access modifiers changed from: private */
    public LayoutInflater mInflater;
    /* access modifiers changed from: private */
    public PopupWindow mPopupWindow;
    private int mWidth = 127;

    /* renamed from: com.introvd.template.camera.ui.c$a */
    private class C5062a extends ArrayAdapter<C5055a> {
        public C5062a(Context context, List<C5055a> list) {
            super(context, 0, list);
        }

        public View getView(final int i, View view, ViewGroup viewGroup) {
            C5064b bVar;
            if (view == null) {
                view = C5059c.this.mInflater.inflate(R.layout.cam_popup_menu_duration_item, null);
                bVar = new C5064b();
                bVar.bSe = (RelativeLayout) view.findViewById(R.id.item_layout);
                bVar.f3431pc = (ImageView) view.findViewById(R.id.popup_item_icon);
                bVar.alJ = (TextView) view.findViewById(R.id.popup_item_title);
                view.setTag(bVar);
            } else {
                bVar = (C5064b) view.getTag();
            }
            bVar.bSe.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (C5059c.this.mPopupWindow.isShowing()) {
                        C5059c.this.mPopupWindow.dismiss();
                    }
                    if (((C5055a) C5059c.this.bSa.get(i)).isClickable() && C5059c.this.bRS != null) {
                        C5059c.this.bRS.mo25941a((C5055a) C5059c.this.bSa.get(i));
                    }
                }
            });
            C5055a aVar = (C5055a) C5059c.this.bSa.get(i);
            if (aVar.isSelected()) {
                bVar.f3431pc.setVisibility(0);
            } else {
                bVar.f3431pc.setVisibility(8);
            }
            if (!TextUtils.isEmpty(aVar.getTitle())) {
                bVar.alJ.setText(aVar.getTitle());
                bVar.alJ.setSelected(aVar.isSelected());
                bVar.alJ.setVisibility(0);
            } else {
                bVar.alJ.setVisibility(8);
            }
            return view;
        }
    }

    /* renamed from: com.introvd.template.camera.ui.c$b */
    static class C5064b {
        TextView alJ;
        RelativeLayout bSe;

        /* renamed from: pc */
        ImageView f3431pc;

        C5064b() {
        }
    }

    public C5059c(Context context) {
        this.mContext = context;
        this.mInflater = (LayoutInflater) context.getSystemService("layout_inflater");
        this.bRY = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.bRY.getDefaultDisplay().getMetrics(displayMetrics);
        this.bSb = displayMetrics.scaledDensity;
        this.bSa = new ArrayList();
        this.mPopupWindow = new PopupWindow(context);
        this.mPopupWindow.setTouchInterceptor(new OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 4) {
                    return false;
                }
                if (C5059c.this.mPopupWindow.isShowing()) {
                    C5059c.this.mPopupWindow.dismiss();
                }
                return true;
            }
        });
        setContentView(this.mInflater.inflate(R.layout.cam_popup_menu, null));
    }

    /* renamed from: WU */
    private void m13308WU() {
        this.mPopupWindow.setWidth(this.f3429eh);
        this.mPopupWindow.setHeight(-2);
        this.mPopupWindow.setTouchable(true);
        this.mPopupWindow.setFocusable(true);
        this.mPopupWindow.setOutsideTouchable(true);
        this.mPopupWindow.setBackgroundDrawable(mo25908WT());
        this.mPopupWindow.setOnDismissListener(new OnDismissListener() {
            public void onDismiss() {
                if (C5059c.this.bRT != null) {
                    C5059c.this.bRT.onDismiss();
                }
            }
        });
    }

    private void setContentView(View view) {
        this.f3428Jn = view;
        this.bRZ = (ListView) view.findViewById(R.id.popup_items);
        this.mPopupWindow.setContentView(view);
    }

    /* access modifiers changed from: protected */
    /* renamed from: WT */
    public Drawable mo25908WT() {
        return this.mContext.getResources().getDrawable(R.drawable.v4_xiaoying_cam_popup_list_bg);
    }

    /* renamed from: c */
    public C5055a mo25946c(int i, int i2, boolean z, boolean z2) {
        C5055a aVar = new C5055a();
        aVar.setItemId(i);
        if (-1 != i2) {
            aVar.setTitle(this.mContext.getString(i2));
        }
        aVar.setSelected(z);
        aVar.setClickable(z2);
        this.bSa.add(aVar);
        return aVar;
    }

    public void setWidth(int i) {
        this.mWidth = i;
    }

    public void show(View view) {
        if (this.bSa.size() != 0) {
            this.f3429eh = (int) (((float) this.mWidth) * this.bSb);
            TextView textView = new TextView(this.mContext);
            textView.setTextSize(2, 16.0f);
            TextPaint paint = textView.getPaint();
            for (int i = 0; i < this.bSa.size(); i++) {
                int measureText = (int) (paint.measureText(((C5055a) this.bSa.get(i)).getTitle()) + (this.bSb * 30.0f * 2.0f));
                if (measureText > this.f3429eh) {
                    this.f3429eh = measureText;
                }
            }
            m13308WU();
            this.bRZ.setAdapter(new C5062a(this.mContext, this.bSa));
            if (view == null) {
                this.mPopupWindow.showAtLocation(((Activity) this.mContext).getWindow().getDecorView(), 17, 0, 0);
                return;
            }
            this.f3428Jn.invalidate();
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            Rect rect = new Rect(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
            this.f3428Jn.setLayoutParams(new LayoutParams(-2, -2));
            this.f3428Jn.measure(-2, -2);
            this.mPopupWindow.showAtLocation(view, 51, rect.centerX() - (this.mPopupWindow.getWidth() / 2), mo25909z(rect.top, rect.bottom, (int) ((bRW + bRX) * this.bSb * ((float) this.bSa.size()))));
            return;
        }
        throw new IllegalStateException("PopupMenu#add was not called with a menu item to display.");
    }

    /* access modifiers changed from: protected */
    /* renamed from: z */
    public int mo25909z(int i, int i2, int i3) {
        if (i > i3) {
            i2 = i - i3;
        }
        return i2 + C4583d.dpFloatToPixel(this.mContext, 5.0f);
    }
}
