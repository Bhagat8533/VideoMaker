package com.introvd.template.app.homepage.p186a;

import android.content.Context;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.introvd.template.module.p339c.C7689a;
import com.introvd.template.ui.widget.R;

/* renamed from: com.introvd.template.app.homepage.a.b */
public class C3932b {
    private View bse;
    /* access modifiers changed from: private */
    public C3934a bsf;
    private String bsg;
    private PopupWindow mPopupWindow = new PopupWindow();

    /* renamed from: ue */
    private boolean f3379ue;

    /* renamed from: com.introvd.template.app.homepage.a.b$a */
    public interface C3934a {
        /* renamed from: LK */
        void mo23472LK();
    }

    public C3932b(Context context, boolean z) {
        this.f3379ue = z;
        this.bse = LayoutInflater.from(context).inflate(R.layout.xyui_popup_imgae_tip_view, null);
        this.bse.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (C3932b.this.bsf != null) {
                    C3932b.this.bsf.mo23472LK();
                }
                C3932b.this.mo23464LI();
            }
        });
    }

    /* renamed from: LI */
    public void mo23464LI() {
        if (this.mPopupWindow != null) {
            this.mPopupWindow.dismiss();
            this.mPopupWindow = null;
        }
    }

    /* renamed from: LJ */
    public boolean mo23465LJ() {
        if (this.mPopupWindow == null) {
            return false;
        }
        return this.mPopupWindow.isShowing();
    }

    /* renamed from: a */
    public void mo23466a(int i, Context context) {
        if (this.bse != null) {
            TextView textView = (TextView) this.bse.findViewById(R.id.text);
            ImageView imageView = (ImageView) this.bse.findViewById(R.id.image);
            View findViewById = this.bse.findViewById(R.id.container);
            if (!TextUtils.isEmpty(this.bsg)) {
                textView.setText(this.bsg);
            }
            switch (i) {
                case 0:
                    textView.setTextColor(context.getResources().getColor(R.color.black));
                    imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.xyui_image_help_v2_white));
                    if (!this.f3379ue) {
                        findViewById.setBackground(context.getResources().getDrawable(R.drawable.xyui_bg_help_v2_white));
                        break;
                    } else {
                        findViewById.setBackground(context.getResources().getDrawable(R.drawable.xyui_bg_help_v2_white_rtl));
                        break;
                    }
                case 1:
                    textView.setTextColor(context.getResources().getColor(R.color.white));
                    imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.xyui_image_help_v2_orange));
                    if (!this.f3379ue) {
                        findViewById.setBackground(context.getResources().getDrawable(R.drawable.xyui_bg_help_v2_orange));
                        break;
                    } else {
                        findViewById.setBackground(context.getResources().getDrawable(R.drawable.xyui_bg_help_v2_orange_rtl));
                        break;
                    }
                case 2:
                    textView.setTextColor(context.getResources().getColor(R.color.black));
                    imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.xyui_image_help_v2_white));
                    findViewById.setBackground(context.getResources().getDrawable(R.drawable.xyui_bg_help_v2_white_center));
                    break;
                case 3:
                    textView.setTextColor(context.getResources().getColor(R.color.white));
                    imageView.setImageDrawable(context.getResources().getDrawable(R.drawable.xyui_image_help_v2_orange));
                    if (!this.f3379ue) {
                        findViewById.setBackground(context.getResources().getDrawable(R.drawable.xyui_bg_help_v2_oringe_center));
                        break;
                    } else {
                        findViewById.setBackground(context.getResources().getDrawable(R.drawable.xyui_bg_help_v2_oringe_center_rtl));
                        break;
                    }
            }
        }
    }

    /* renamed from: a */
    public void mo23467a(View view, int i, int i2, Animation animation) {
        int i3;
        if (animation != null) {
            this.bse.startAnimation(animation);
        }
        TextView textView = (TextView) this.bse.findViewById(R.id.text);
        TextPaint paint = textView.getPaint();
        int measureText = (int) paint.measureText(textView.getText().toString());
        int i4 = (int) (paint.getFontMetrics().descent - paint.getFontMetrics().ascent);
        int aR = C7689a.m22597aR(121.0f);
        if (measureText > aR) {
            int i5 = measureText / aR;
            if (measureText - (aR * i5) > 0) {
                i5++;
            }
            i3 = (i5 * i4) + C7689a.m22599ii(62);
        } else {
            i3 = i4 + C7689a.m22599ii(62);
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i6 = iArr[0] + i;
        int i7 = iArr[1];
        if (!this.f3379ue) {
            i = i6;
        }
        if (this.mPopupWindow == null) {
            this.mPopupWindow = new PopupWindow();
        }
        this.mPopupWindow.setWidth(-2);
        this.mPopupWindow.setHeight(-2);
        this.mPopupWindow.setContentView(this.bse);
        try {
            if (this.f3379ue) {
                this.mPopupWindow.showAtLocation(view, 8388661, i, (i7 - i3) - i2);
            } else {
                this.mPopupWindow.showAtLocation(view, 51, i, (i7 - i3) - i2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void mo23468a(C3934a aVar) {
        this.bsf = aVar;
    }

    /* renamed from: b */
    public void mo23469b(View view, int i, int i2, Animation animation) {
        int i3;
        if (animation != null) {
            this.bse.startAnimation(animation);
        }
        TextView textView = (TextView) this.bse.findViewById(R.id.text);
        TextPaint paint = textView.getPaint();
        int measureText = (int) paint.measureText(textView.getText().toString());
        int i4 = (int) (paint.getFontMetrics().descent - paint.getFontMetrics().ascent);
        int aR = C7689a.m22597aR(121.0f);
        if (measureText > aR) {
            int i5 = measureText / aR;
            if (measureText - (aR * i5) > 0) {
                i5++;
            }
            i3 = (i5 * i4) + C7689a.m22599ii(62);
        } else {
            i3 = i4 + C7689a.m22599ii(62);
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i6 = iArr[1];
        if (this.mPopupWindow == null) {
            this.mPopupWindow = new PopupWindow();
        }
        this.mPopupWindow.setWidth(-2);
        this.mPopupWindow.setHeight(-2);
        this.mPopupWindow.setContentView(this.bse);
        try {
            this.mPopupWindow.showAtLocation(view, 48, i, (i6 - i3) - i2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: dt */
    public void mo23470dt(String str) {
        this.bsg = str;
    }
}
