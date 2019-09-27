package com.introvd.template.camera.p233ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
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
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.camera.p233ui.C5054b.C5055a;
import com.introvd.template.camera.p233ui.view.HorizontalListView;
import com.introvd.template.common.Constants;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.p414ui.view.RotateImageView;
import com.introvd.template.p414ui.view.RotateTextView;
import com.introvd.template.vivacamera.R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.introvd.template.camera.ui.d */
public class C5111d extends C5054b {
    private static float bRW = 40.0f;
    private static float bRX = 10.0f;

    /* renamed from: Jn */
    private View f3432Jn;
    private WindowManager bRY;
    /* access modifiers changed from: private */
    public List<C5055a> bSa;
    private float bSb;
    private HorizontalListView bSf;

    /* renamed from: ei */
    private int f3433ei;
    private Context mContext;
    private int mHeight = 127;
    /* access modifiers changed from: private */
    public LayoutInflater mInflater;
    /* access modifiers changed from: private */
    public PopupWindow mPopupWindow;

    /* renamed from: com.introvd.template.camera.ui.d$a */
    private class C5114a extends ArrayAdapter<C5055a> {
        public C5114a(Context context, List<C5055a> list) {
            super(context, 0, list);
        }

        public View getView(final int i, View view, ViewGroup viewGroup) {
            C5116b bVar;
            if (view == null) {
                view = C5111d.this.mInflater.inflate(R.layout.cam_popup_item_menu_lan_duration, null);
                bVar = new C5116b();
                bVar.bSe = (RelativeLayout) view.findViewById(R.id.item_layout);
                bVar.bSi = (RotateImageView) view.findViewById(R.id.popup_item_icon);
                bVar.bSj = (RotateTextView) view.findViewById(R.id.popup_item_title);
                view.setTag(bVar);
            } else {
                bVar = (C5116b) view.getTag();
            }
            bVar.bSe.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (C5111d.this.mPopupWindow.isShowing()) {
                        C5111d.this.mPopupWindow.dismiss();
                    }
                    if (((C5055a) C5111d.this.bSa.get(i)).isClickable() && C5111d.this.bRS != null) {
                        C5111d.this.bRS.mo25941a((C5055a) C5111d.this.bSa.get(i));
                    }
                }
            });
            C5055a aVar = (C5055a) C5111d.this.bSa.get(i);
            if (aVar.isSelected()) {
                bVar.bSi.setVisibility(0);
            } else {
                bVar.bSi.setVisibility(8);
            }
            if (!TextUtils.isEmpty(aVar.getTitle())) {
                TextPaint paint = bVar.bSj.getPaint();
                int i2 = (int) (paint.getFontMetrics().descent - paint.getFontMetrics().ascent);
                int measureText = (int) paint.measureText(aVar.getTitle());
                bVar.bSj.setWidth(i2);
                bVar.bSj.setHeight(measureText);
                bVar.bSj.setText(aVar.getTitle());
                bVar.bSj.setSelected(aVar.isSelected());
                bVar.bSj.setVisibility(0);
            } else {
                bVar.bSj.setVisibility(8);
            }
            return view;
        }
    }

    /* renamed from: com.introvd.template.camera.ui.d$b */
    static class C5116b {
        RelativeLayout bSe;
        RotateImageView bSi;
        RotateTextView bSj;

        C5116b() {
        }
    }

    public C5111d(Context context) {
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
                if (C5111d.this.mPopupWindow.isShowing()) {
                    C5111d.this.mPopupWindow.dismiss();
                }
                return true;
            }
        });
        setContentView(this.mInflater.inflate(R.layout.cam_popup_menu_lan, null));
    }

    /* renamed from: WU */
    private void m13822WU() {
        this.mPopupWindow.setWidth((int) (((float) ((this.bSa.size() * 40) + 0)) * this.bSb));
        this.mPopupWindow.setHeight(this.f3433ei);
        this.mPopupWindow.setTouchable(true);
        this.mPopupWindow.setFocusable(true);
        this.mPopupWindow.setOutsideTouchable(true);
        this.mPopupWindow.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.drawable.xiaoying_ve_gallery_title_pop_bg_shape));
        this.mPopupWindow.setOnDismissListener(new OnDismissListener() {
            public void onDismiss() {
                if (C5111d.this.bRT != null) {
                    C5111d.this.bRT.onDismiss();
                }
            }
        });
    }

    private void setContentView(View view) {
        this.f3432Jn = view;
        this.bSf = (HorizontalListView) view.findViewById(R.id.popup_items);
        this.mPopupWindow.setContentView(view);
    }

    /* renamed from: c */
    public C5055a mo25997c(int i, int i2, boolean z, boolean z2) {
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

    public void show(View view) {
        if (this.bSa.size() != 0) {
            this.f3433ei = (int) (((float) this.mHeight) * this.bSb);
            TextView textView = new TextView(this.mContext);
            textView.setTextSize(2, 16.0f);
            TextPaint paint = textView.getPaint();
            for (int i = 0; i < this.bSa.size(); i++) {
                int measureText = (int) (paint.measureText(((C5055a) this.bSa.get(i)).getTitle()) + (this.bSb * 30.0f * 2.0f));
                if (measureText > this.f3433ei) {
                    this.f3433ei = measureText;
                }
            }
            m13822WU();
            this.bSf.setAdapter((ListAdapter) new C5114a(this.mContext, this.bSa));
            if (view == null) {
                this.mPopupWindow.showAtLocation(((Activity) this.mContext).getWindow().getDecorView(), 17, 0, 0);
                return;
            }
            this.f3432Jn.invalidate();
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            Rect rect = new Rect(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
            this.f3432Jn.setLayoutParams(new LayoutParams(-2, -2));
            this.f3432Jn.measure(-2, -2);
            float f = bRW;
            float f2 = bRX;
            float f3 = this.bSb;
            this.bSa.size();
            this.mPopupWindow.showAtLocation(view, 51, (Constants.getScreenSize().width - C4583d.dpFloatToPixel(this.mContext, 4.0f)) - this.mPopupWindow.getWidth(), rect.centerY() - (this.mPopupWindow.getHeight() / 2));
            return;
        }
        throw new IllegalStateException("PopupMenu#add was not called with a menu item to display.");
    }
}
