package com.introvd.template.module.iap.business.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.p021v4.content.ContextCompat;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.introvd.template.module.iap.R;
import com.introvd.template.module.p339c.C7689a;
import com.yan.rippledrawable.RippleLayout;

/* renamed from: com.introvd.template.module.iap.business.dialog.a */
public class C7885a extends Dialog {
    private Activity activity;
    private C7888b dQU;

    /* renamed from: com.introvd.template.module.iap.business.dialog.a$a */
    public static class C7886a {
        private Activity activity;
        protected TextView dQV;
        protected TextView dQW;
        private View dQX;
        /* access modifiers changed from: private */
        public C7885a dQY;

        public C7886a(Activity activity2) {
            this.activity = activity2;
            this.dQY = new C7885a(activity2);
        }

        /* renamed from: a */
        private TextView m22970a(String str, int i, OnClickListener onClickListener, int i2) {
            TextView textView = new TextView(this.activity);
            textView.setGravity(17);
            int ii = C7689a.m22599ii(5);
            textView.setPadding(ii, ii, ii, ii);
            textView.setTextSize(15.0f);
            LayoutParams layoutParams = new LayoutParams(-1, C7689a.m22599ii(52));
            int i3 = ii * 3;
            layoutParams.rightMargin = i3;
            layoutParams.leftMargin = i3;
            int ii2 = C7689a.m22599ii(6);
            layoutParams.bottomMargin = ii2;
            layoutParams.topMargin = ii2;
            textView.setLayoutParams(layoutParams);
            textView.setTypeface(Typeface.DEFAULT_BOLD);
            textView.setText(str);
            textView.setTextColor(ContextCompat.getColor(this.activity, i));
            textView.setOnClickListener(onClickListener);
            textView.setBackground(m22972ss(i2));
            return textView;
        }

        private View aCn() {
            if (this.dQX != null) {
                return this.dQX;
            }
            if (!(this.dQV == null && this.dQW == null)) {
                LinearLayout linearLayout = new LinearLayout(this.activity);
                linearLayout.setOrientation(1);
                if (this.dQV != null) {
                    linearLayout.addView(this.dQV);
                }
                if (this.dQW != null) {
                    linearLayout.addView(this.dQW);
                }
                int ii = C7689a.m22599ii(3);
                linearLayout.setPadding(0, ii * 7, 0, ii * 3);
                linearLayout.setGravity(17);
                this.dQX = linearLayout;
            }
            return this.dQX;
        }

        private void aCo() {
            C78871 r0 = new AccessibilityDelegate() {
                public void sendAccessibilityEvent(View view, int i) {
                    super.sendAccessibilityEvent(view, i);
                    C7886a.this.dQY.dismiss();
                }
            };
            if (this.dQW != null) {
                this.dQW.setAccessibilityDelegate(r0);
            }
            if (this.dQV != null) {
                this.dQV.setAccessibilityDelegate(r0);
            }
        }

        /* renamed from: ss */
        private Drawable m22972ss(int i) {
            Drawable drawable = ContextCompat.getDrawable(this.activity, i);
            return RippleLayout.m27642a(drawable, drawable, RippleLayout.DEFAULT_COLOR);
        }

        /* renamed from: A */
        public C7886a mo32815A(CharSequence charSequence) {
            this.dQY.setMessage(charSequence);
            return this;
        }

        /* renamed from: a */
        public C7886a mo32816a(String str, OnClickListener onClickListener) {
            this.dQV = m22970a(str, R.color.white, onClickListener, R.drawable.iap_vip_selector_bg_vip_home_extra);
            return this;
        }

        public Dialog aCm() {
            this.dQY.mo32809dd(aCn());
            aCo();
            return this.dQY;
        }

        /* renamed from: b */
        public C7886a mo32761b(String str, OnClickListener onClickListener) {
            this.dQW = m22970a(str, R.color.color_ff4601, onClickListener, R.drawable.iap_vip_shape_bg_common_dialog_btn_n);
            return this;
        }

        /* renamed from: c */
        public C7886a mo32818c(int i, OnClickListener onClickListener) {
            return mo32816a(this.activity.getString(i), onClickListener);
        }

        /* renamed from: d */
        public C7886a mo32819d(int i, OnClickListener onClickListener) {
            return mo32761b(this.activity.getString(i), onClickListener);
        }

        /* renamed from: de */
        public C7886a mo32820de(View view) {
            this.dQY.mo32808dc(view);
            return this;
        }
    }

    /* renamed from: com.introvd.template.module.iap.business.dialog.a$b */
    public interface C7888b {
        void aam();
    }

    public C7885a(Activity activity2) {
        super(activity2, R.style.vivavideo_iap_dialog_common_style);
        this.activity = activity2;
        setContentView(R.layout.iap_vip_dialog_common);
    }

    /* renamed from: E */
    private void m22966E(View view, int i) {
        if (view != null) {
            ViewStub viewStub = (ViewStub) findViewById(i);
            if (viewStub != null) {
                FrameLayout frameLayout = (FrameLayout) viewStub.inflate();
                if (frameLayout.getLayoutParams() == null) {
                    frameLayout.addView(view, new FrameLayout.LayoutParams(-1, -2));
                } else {
                    frameLayout.addView(view);
                }
            }
        }
    }

    /* renamed from: J */
    private <T extends View> T m22967J(int i, int i2, int i3) {
        T findViewById = findViewById(i2);
        if (findViewById != null) {
            return findViewById;
        }
        ViewStub viewStub = (ViewStub) findViewById(i3);
        if (viewStub != null) {
            getLayoutInflater().inflate(i, (FrameLayout) viewStub.inflate(), true);
        }
        return m22967J(i, i2, i3);
    }

    /* renamed from: dc */
    public void mo32808dc(View view) {
        m22966E(view, R.id.vs_title);
    }

    /* renamed from: dd */
    public void mo32809dd(View view) {
        m22966E(view, R.id.vs_btn);
    }

    public void onBackPressed() {
        super.onBackPressed();
        if (this.dQU != null) {
            this.dQU.aam();
        }
    }

    public void setMessage(CharSequence charSequence) {
        ((TextView) m22967J(R.layout.iap_vip_dialog_common_message, R.id.tv_message, R.id.vs_content)).setText(charSequence);
    }

    public void setTitle(int i) {
        setTitle((CharSequence) this.activity.getString(i));
    }

    public void setTitle(CharSequence charSequence) {
        ((TextView) m22967J(R.layout.iap_vip_dialog_common_title, R.id.tv_title, R.id.vs_title)).setText(charSequence);
    }

    public void show() {
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = (int) (((double) this.activity.getResources().getDisplayMetrics().widthPixels) * 0.8d);
        getWindow().setAttributes(attributes);
        super.show();
    }
}
