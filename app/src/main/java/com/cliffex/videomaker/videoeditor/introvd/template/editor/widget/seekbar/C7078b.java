package com.introvd.template.editor.widget.seekbar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.introvd.template.editor.R;
import com.introvd.template.p203b.C4583d;

/* renamed from: com.introvd.template.editor.widget.seekbar.b */
public class C7078b {
    private int cbc;
    private int[] cbq = new int[2];
    private View dtA;
    private float dtl;
    private final int dtq;
    private ArrowView dtr;
    private TextView dts;
    private PopupWindow dtt;
    private LinearLayout dtu;
    private int dtv;
    private int dtw;
    private IndicatorSeekBar dtx;
    private View dty;
    private View dtz;
    private Context mContext;
    private int mIndicatorColor;

    public C7078b(Context context, IndicatorSeekBar indicatorSeekBar, int i, int i2, int i3, int i4, View view, View view2) {
        this.mContext = context;
        this.dtx = indicatorSeekBar;
        this.mIndicatorColor = i;
        this.dtw = i2;
        this.dtz = view;
        this.dtA = view2;
        this.dtl = (float) i3;
        this.cbc = i4;
        this.dtq = auW();
        this.dtv = C4583d.m11670O(this.mContext, 2);
        auU();
    }

    /* renamed from: aC */
    private void m20773aC(float f) {
        if (this.dtw != 4 && this.dtw != 1) {
            int auX = auX();
            if (((float) auX) + f < ((float) (this.dtt.getContentView().getMeasuredWidth() / 2))) {
                m20774g(this.dtr, -((int) (((float) ((this.dtt.getContentView().getMeasuredWidth() / 2) - auX)) - f)), -1, -1, -1);
            } else if (((float) (this.dtq - auX)) - f < ((float) (this.dtt.getContentView().getMeasuredWidth() / 2))) {
                m20774g(this.dtr, (int) (((float) (this.dtt.getContentView().getMeasuredWidth() / 2)) - (((float) (this.dtq - auX)) - f)), -1, -1, -1);
            } else {
                m20774g(this.dtr, 0, 0, 0, 0);
            }
        }
    }

    private void auU() {
        if (this.dtw == 4) {
            if (this.dtz != null) {
                this.dty = this.dtz;
                int identifier = this.mContext.getResources().getIdentifier("isb_progress", "id", this.mContext.getApplicationContext().getPackageName());
                if (identifier > 0) {
                    View findViewById = this.dty.findViewById(identifier);
                    if (findViewById == null) {
                        return;
                    }
                    if (findViewById instanceof TextView) {
                        this.dts = (TextView) findViewById;
                        this.dts.setText(this.dtx.getIndicatorTextString());
                        this.dts.setTextSize((float) C4583d.m11672a(this.mContext, this.dtl));
                        this.dts.setTextColor(this.cbc);
                        return;
                    }
                    throw new ClassCastException("the view identified by isb_progress in indicator custom layout can not be cast to TextView");
                }
                return;
            }
            throw new IllegalArgumentException("the attr：indicator_custom_layout must be set while you set the indicator type to CUSTOM.");
        } else if (this.dtw == 1) {
            CircleBubbleView circleBubbleView = new CircleBubbleView(this.mContext, this.dtl, this.cbc, this.mIndicatorColor, "1000");
            this.dty = circleBubbleView;
            ((CircleBubbleView) this.dty).setProgress(this.dtx.getIndicatorTextString());
        } else {
            this.dty = View.inflate(this.mContext, R.layout.layout_seekbar_indicator, null);
            this.dtu = (LinearLayout) this.dty.findViewById(R.id.indicator_container);
            this.dtr = (ArrowView) this.dty.findViewById(R.id.indicator_arrow);
            this.dtr.setColor(this.mIndicatorColor);
            this.dts = (TextView) this.dty.findViewById(R.id.isb_progress);
            this.dts.setText(this.dtx.getIndicatorTextString());
            this.dts.setTextSize((float) C4583d.m11672a(this.mContext, this.dtl));
            this.dts.setTextColor(this.cbc);
            if (VERSION.SDK_INT >= 16) {
                this.dtu.setBackground(auV());
            } else {
                this.dtu.setBackgroundDrawable(auV());
            }
            if (this.dtA != null) {
                int identifier2 = this.mContext.getResources().getIdentifier("isb_progress", "id", this.mContext.getApplicationContext().getPackageName());
                View view = this.dtA;
                if (identifier2 > 0) {
                    View findViewById2 = view.findViewById(identifier2);
                    if (findViewById2 == null || !(findViewById2 instanceof TextView)) {
                        mo31175cO(view);
                    } else {
                        mo31170a(view, (TextView) findViewById2);
                    }
                } else {
                    mo31175cO(view);
                }
            }
        }
    }

    private Drawable auV() {
        if (this.dtw == 2) {
            return this.mContext.getResources().getDrawable(R.drawable.editor_layer_seekbar_indicator_rounded_corners);
        }
        Drawable drawable = this.mContext.getResources().getDrawable(R.drawable.editor_shape_seekbar_indicator_square_corners);
        ((GradientDrawable) drawable).setColor(this.mIndicatorColor);
        return drawable;
    }

    private int auW() {
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        if (windowManager != null) {
            return windowManager.getDefaultDisplay().getWidth();
        }
        return 0;
    }

    private int auX() {
        this.dtx.getLocationOnScreen(this.cbq);
        return this.cbq[0];
    }

    /* renamed from: g */
    private void m20774g(View view, int i, int i2, int i3, int i4) {
        if (view != null && (view.getLayoutParams() instanceof MarginLayoutParams)) {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
            if (i == -1) {
                i = marginLayoutParams.leftMargin;
            }
            if (i2 == -1) {
                i2 = marginLayoutParams.topMargin;
            }
            if (i3 == -1) {
                i3 = marginLayoutParams.rightMargin;
            }
            if (i4 == -1) {
                i4 = marginLayoutParams.bottomMargin;
            }
            marginLayoutParams.setMargins(i, i2, i3, i4);
            view.requestLayout();
        }
    }

    /* renamed from: a */
    public void mo31170a(View view, TextView textView) {
        this.dts = textView;
        this.dtu.removeAllViews();
        if (VERSION.SDK_INT >= 16) {
            view.setBackground(auV());
        } else {
            view.setBackgroundDrawable(auV());
        }
        this.dtu.addView(view);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: aD */
    public void mo31171aD(float f) {
        if (this.dtx.isEnabled() && this.dtx.getVisibility() == 0) {
            ava();
            if (this.dtt != null) {
                this.dtt.getContentView().measure(0, 0);
                this.dtt.showAsDropDown(this.dtx, (int) (f - (((float) this.dtt.getContentView().getMeasuredWidth()) / 2.0f)), -(((this.dtx.getMeasuredHeight() + this.dtt.getContentView().getMeasuredHeight()) - this.dtx.getPaddingTop()) + this.dtv));
                m20773aC(f);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    public void auY() {
        if (!(this.dtt != null || this.dtw == 0 || this.dty == null)) {
            this.dty.measure(0, 0);
            this.dtt = new PopupWindow(this.dty, -2, -2, false);
        }
    }

    /* access modifiers changed from: 0000 */
    public View auZ() {
        return this.dty;
    }

    /* access modifiers changed from: 0000 */
    public void ava() {
        String indicatorTextString = this.dtx.getIndicatorTextString();
        if (this.dty instanceof CircleBubbleView) {
            ((CircleBubbleView) this.dty).setProgress(indicatorTextString);
        } else if (this.dts != null) {
            this.dts.setText(indicatorTextString);
        }
    }

    /* renamed from: cO */
    public void mo31175cO(View view) {
        mo31170a(view, null);
    }

    /* access modifiers changed from: 0000 */
    public void hide() {
        if (this.dtt != null) {
            this.dtt.dismiss();
        }
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: iX */
    public void mo31177iX(String str) {
        if (this.dty instanceof CircleBubbleView) {
            ((CircleBubbleView) this.dty).setProgress(str);
        } else if (this.dts != null) {
            this.dts.setText(str);
        }
    }

    /* access modifiers changed from: 0000 */
    public boolean isShowing() {
        return this.dtt != null && this.dtt.isShowing();
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: qj */
    public void mo31179qj(int i) {
        m20774g(this.dty, i, -1, -1, -1);
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: qk */
    public void mo31180qk(int i) {
        m20774g(this.dtr, i, -1, -1, -1);
    }

    /* access modifiers changed from: 0000 */
    public void update(float f) {
        if (this.dtx.isEnabled() && this.dtx.getVisibility() == 0) {
            ava();
            if (this.dtt != null) {
                this.dtt.getContentView().measure(0, 0);
                this.dtt.update(this.dtx, (int) (f - ((float) (this.dtt.getContentView().getMeasuredWidth() / 2))), -(((this.dtx.getMeasuredHeight() + this.dtt.getContentView().getMeasuredHeight()) - this.dtx.getPaddingTop()) + this.dtv), -1, -1);
                m20773aC(f);
            }
        }
    }
}
