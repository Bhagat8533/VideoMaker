package com.introvd.template.xyui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.exoplayer2.extractor.p151ts.TsExtractor;
import com.introvd.template.ui.widget.R;
import com.introvd.template.xyui.p421b.C9162a;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.sdk.constants.Constants.RequestParameters;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import xiaoying.engine.base.QDisplayContext;

/* renamed from: com.introvd.template.xyui.a */
public class C9136a {

    /* renamed from: NE */
    private int f3679NE = 0;

    /* renamed from: NF */
    private int f3680NF = 0;
    private WeakReference<Activity> bwg;
    private View eCf;
    private View eCg;
    private int eCh = 0;
    private boolean eCi = false;
    private int eCj = TsExtractor.TS_STREAM_TYPE_HDMV_DTS;
    private int eCk = 3000;
    private boolean eCl = true;
    private int eCm = 0;
    private boolean eCn = false;
    private String eCo;
    private int eCp = 0;
    private Handler mHandler = new C9150a(this);
    /* access modifiers changed from: private */
    public PopupWindow mPopupWindow;
    private int mTextSize = 0;

    /* renamed from: com.introvd.template.xyui.a$a */
    private static class C9150a extends Handler {
        private WeakReference<C9136a> eCu = null;

        public C9150a(C9136a aVar) {
            this.eCu = new WeakReference<>(aVar);
        }

        public void handleMessage(Message message) {
            C9136a aVar = (C9136a) this.eCu.get();
            if (aVar != null && message.what == 4097 && aVar.mPopupWindow != null && aVar.mPopupWindow.isShowing()) {
                removeMessages(4097);
                aVar.aNU();
            }
        }
    }

    public C9136a(Activity activity) {
        this.bwg = new WeakReference<>(activity);
    }

    public C9136a(Activity activity, boolean z) {
        this.bwg = new WeakReference<>(activity);
        this.eCn = z;
    }

    /* renamed from: a */
    private void m26605a(final PopupWindow popupWindow) {
        if (VERSION.SDK_INT <= 17) {
            try {
                final Field declaredField = PopupWindow.class.getDeclaredField("mAnchor");
                declaredField.setAccessible(true);
                Field declaredField2 = PopupWindow.class.getDeclaredField("mOnScrollChangedListener");
                declaredField2.setAccessible(true);
                final OnScrollChangedListener onScrollChangedListener = (OnScrollChangedListener) declaredField2.get(popupWindow);
                declaredField2.set(popupWindow, new OnScrollChangedListener() {
                    public void onScrollChanged() {
                        try {
                            WeakReference weakReference = (WeakReference) declaredField.get(popupWindow);
                            if (weakReference != null) {
                                if (weakReference.get() != null) {
                                    onScrollChangedListener.onScrollChanged();
                                }
                            }
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean aNV() {
        Activity activity = (Activity) this.bwg.get();
        if (activity == null) {
            return false;
        }
        aNU();
        this.mPopupWindow = new PopupWindow(activity);
        m26605a(this.mPopupWindow);
        this.mHandler.removeMessages(4097);
        return true;
    }

    private void aNW() {
        this.mHandler.removeMessages(4097);
        this.mHandler.sendEmptyMessageDelayed(4097, (long) this.eCk);
    }

    /* renamed from: e */
    private void m26606e(boolean z, int i, int i2) {
        Activity activity = (Activity) this.bwg.get();
        if (activity != null) {
            if (!"X909T".equals(Build.MODEL) || !this.eCn) {
                try {
                    switch (this.eCm) {
                        case 0:
                            mo36091j(this.eCf, this.eCg);
                            break;
                        case 1:
                            mo36088h(this.eCf, this.eCg);
                            break;
                        case 2:
                            mo36078a(this.eCf, this.eCg, z, i, 0);
                            break;
                        case 3:
                        case 4:
                        case 5:
                            mo36078a(this.eCf, this.eCg, z, i, i2);
                            break;
                        case 6:
                            mo36089i(this.eCf, this.eCg);
                            break;
                        case 7:
                            mo36078a(this.eCf, this.eCg, z, i, i2);
                            break;
                        case 8:
                            mo36083b(this.eCf, this.eCg, z, i, i2);
                            break;
                        case 9:
                            mo36076a(this.eCf, this.eCg, z);
                            break;
                        case 10:
                            mo36082b(this.eCf, this.eCg, z);
                            break;
                        case 11:
                            mo36084c(this.eCf, this.eCg, z, i, i2);
                            break;
                        case 12:
                            mo36077a(this.eCf, this.eCg, z, C9162a.m26662O(activity, 200));
                            break;
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* renamed from: rm */
    private ArrayList<String> m26607rm(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        while (-1 != str.indexOf(RequestParameters.LEFT_BRACKETS, 0)) {
            int indexOf = str.indexOf(RequestParameters.LEFT_BRACKETS, 0);
            if (-1 != indexOf) {
                int indexOf2 = str.indexOf(RequestParameters.RIGHT_BRACKETS, 0);
                arrayList.add(str.substring(0, indexOf));
                str = str.substring(indexOf2 + 1);
            }
        }
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(str);
        }
        return arrayList;
    }

    /* renamed from: rn */
    private ArrayList<String> m26608rn(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        while (-1 != str.indexOf(RequestParameters.LEFT_BRACKETS, 0)) {
            int indexOf = str.indexOf(RequestParameters.LEFT_BRACKETS, 0);
            if (-1 != indexOf) {
                int indexOf2 = str.indexOf(RequestParameters.RIGHT_BRACKETS, 0);
                String substring = str.substring(indexOf + 1, indexOf2);
                StringBuilder sb = new StringBuilder();
                sb.append(" ");
                sb.append(substring);
                sb.append(" ");
                arrayList.add(sb.toString());
                str = str.substring(indexOf2 + 1);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public void mo36076a(View view, View view2, boolean z) {
        Activity activity = (Activity) this.bwg.get();
        if (activity != null && aNV()) {
            if (z) {
                aNW();
            }
            if (this.eCk <= 0) {
                this.eCk = 3000;
            }
            TextView textView = (TextView) view2.findViewById(R.id.tv_text);
            this.mPopupWindow.setContentView(view2);
            this.mPopupWindow.setWidth(C9162a.m26662O(activity, QDisplayContext.DISPLAY_ROTATION_180));
            this.mPopupWindow.setHeight(C9162a.m26662O(activity, 70));
            this.mPopupWindow.setFocusable(false);
            this.mPopupWindow.setOutsideTouchable(false);
            this.mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
            textView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    C9136a.this.aNX();
                }
            });
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            this.mPopupWindow.showAtLocation(view, 0, iArr[0] + ((view.getWidth() - this.mPopupWindow.getWidth()) / 2), iArr[1] + ((view.getHeight() - this.mPopupWindow.getHeight()) / 2));
        }
    }

    /* renamed from: a */
    public void mo36077a(View view, View view2, boolean z, int i) {
        Activity activity = (Activity) this.bwg.get();
        if (activity != null && aNV()) {
            if (z) {
                aNW();
            }
            TextView textView = (TextView) view2.findViewById(R.id.tv_text);
            this.mPopupWindow.setContentView(view2);
            this.mPopupWindow.setWidth(i);
            this.mPopupWindow.setHeight(C9162a.m26662O(activity, 80));
            this.mPopupWindow.setFocusable(false);
            this.mPopupWindow.setOutsideTouchable(false);
            this.mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
            textView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    C9136a.this.aNX();
                }
            });
            view.getLocationOnScreen(new int[2]);
            this.mPopupWindow.showAsDropDown(view, (view.getWidth() - this.mPopupWindow.getWidth()) / 2, 0);
        }
    }

    /* renamed from: a */
    public void mo36078a(View view, View view2, boolean z, int i, int i2) {
        Activity activity = (Activity) this.bwg.get();
        if (activity != null && aNV()) {
            if (z) {
                aNW();
            }
            if (this.eCh <= 0) {
                this.eCh = IronSourceConstants.REWARDED_VIDEO_DAILY_CAPPED;
            }
            if (this.eCk <= 0) {
                this.eCk = 3000;
            }
            TextView textView = (TextView) view2.findViewById(R.id.tv_text);
            if (!(this.eCm == 4 || this.eCm == 2)) {
                try {
                    textView.setMaxWidth(C9162a.m26662O(activity, this.eCh));
                } catch (NoSuchMethodError unused) {
                    textView.setWidth(C9162a.m26662O(activity, this.eCh));
                }
            }
            this.mPopupWindow.setContentView(view2);
            if (this.eCm == 4 || this.eCm == 2 || this.eCm == 7) {
                TextPaint paint = textView.getPaint();
                int measureText = (int) paint.measureText(textView.getText().toString());
                int i3 = (int) (paint.getFontMetrics().descent - paint.getFontMetrics().ascent);
                if (this.eCm == 4) {
                    int O = C9162a.m26662O(activity, IronSourceConstants.INTERSTITIAL_DAILY_CAPPED);
                    int O2 = C9162a.m26662O(activity, 30) + measureText;
                    if (O2 > O) {
                        int i4 = O2 / O;
                        if (O2 - (i4 * O) > 0) {
                            i4++;
                        }
                        this.mPopupWindow.setWidth(O);
                        this.mPopupWindow.setHeight((i4 * i3) + C9162a.m26662O(activity, 70));
                    } else {
                        this.mPopupWindow.setWidth(measureText + (C9162a.m26662O(activity, 30) * 2));
                        this.mPopupWindow.setHeight(i3 + C9162a.m26662O(activity, 50));
                    }
                } else {
                    this.mPopupWindow.setWidth(measureText + C9162a.m26662O(activity, 30));
                    this.mPopupWindow.setHeight(i3 + C9162a.m26662O(activity, 50));
                }
                view2.setOnClickListener(new OnClickListener() {
                    public void onClick(View view) {
                        C9136a.this.aNX();
                    }
                });
            } else {
                this.mPopupWindow.setWidth(C9162a.m26662O(activity, this.eCh));
                this.mPopupWindow.setHeight(C9162a.m26662O(activity, this.eCj));
            }
            this.mPopupWindow.setFocusable(false);
            this.mPopupWindow.setOutsideTouchable(false);
            this.mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
            textView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    C9136a.this.aNX();
                }
            });
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int width = (view.getWidth() - this.mPopupWindow.getWidth()) / 2;
            int i5 = iArr[0] + width;
            if (this.eCm == 3) {
                i5 = iArr[0] + width + ((C9162a.m26662O(activity, this.eCh) / 2) - C9162a.m26662O(activity, 19)) + i;
            }
            if (this.eCm == 5) {
                i5 = iArr[0] + width + ((-C9162a.m26662O(activity, this.eCh)) / 2) + C9162a.m26662O(activity, 19) + i;
            }
            int height = (iArr[1] - this.mPopupWindow.getHeight()) + this.f3680NF + i2 + C9162a.m26662O(activity, 5);
            if (this.eCl) {
                this.mPopupWindow.setAnimationStyle(R.style.popup_animation);
            }
            this.mPopupWindow.showAtLocation(view, 0, i5, height);
        }
    }

    /* renamed from: a */
    public boolean mo36079a(boolean z, int i, String str, View view, boolean z2, int i2, int i3, int i4, int i5) {
        this.f3679NE = i2;
        this.f3680NF = i3;
        this.eCh = i4;
        this.eCk = i5;
        if (z) {
            mo36087f(view, i, z2);
            mo36086dt(str);
            mo36093k(this.eCf, this.eCg);
            this.eCk = 3000;
            return true;
        }
        if (this.eCh == 0) {
            this.eCh = IronSourceConstants.REWARDED_VIDEO_DAILY_CAPPED;
        }
        this.eCk = 3000;
        return false;
    }

    public void aNU() {
        if (this.mPopupWindow != null && this.mPopupWindow.isShowing()) {
            try {
                this.mPopupWindow.dismiss();
            } catch (Exception unused) {
            }
            this.mPopupWindow = null;
        }
    }

    public void aNX() {
        this.mHandler.removeMessages(4097);
        if (this.mPopupWindow != null) {
            aNU();
            this.mPopupWindow = null;
        }
    }

    /* renamed from: b */
    public void mo36082b(View view, View view2, boolean z) {
        Activity activity = (Activity) this.bwg.get();
        if (activity != null && aNV()) {
            if (z) {
                aNW();
            }
            TextView textView = (TextView) view2.findViewById(R.id.tv_text);
            this.mPopupWindow.setContentView(view2);
            this.mPopupWindow.setWidth(C9162a.m26662O(activity, QDisplayContext.DISPLAY_ROTATION_180));
            this.mPopupWindow.setHeight(C9162a.m26662O(activity, 80));
            this.mPopupWindow.setFocusable(false);
            this.mPopupWindow.setOutsideTouchable(false);
            this.mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
            textView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    C9136a.this.aNX();
                }
            });
            view.getLocationOnScreen(new int[2]);
            this.mPopupWindow.showAsDropDown(view, (view.getWidth() - this.mPopupWindow.getWidth()) / 2, 0);
        }
    }

    /* renamed from: b */
    public void mo36083b(View view, View view2, boolean z, int i, int i2) {
        Activity activity = (Activity) this.bwg.get();
        if (activity != null && aNV()) {
            if (z) {
                aNW();
            }
            if (this.eCk <= 0) {
                this.eCk = 3000;
            }
            TextView textView = (TextView) view2.findViewById(R.id.tv_text);
            this.mPopupWindow.setContentView(view2);
            this.mPopupWindow.setWidth(-2);
            this.mPopupWindow.setHeight(-2);
            this.mPopupWindow.setFocusable(false);
            this.mPopupWindow.setOutsideTouchable(false);
            this.mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
            textView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    C9136a.this.aNX();
                }
            });
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int width = iArr[0] + ((view.getWidth() - C9162a.m26662O(activity, 65)) / 2) + i;
            int height = iArr[1] + view.getHeight() + i2;
            if (this.eCl) {
                this.mPopupWindow.setAnimationStyle(R.style.popup_animation);
            }
            this.mPopupWindow.showAtLocation(view, 0, width, height);
        }
    }

    /* renamed from: c */
    public void mo36084c(View view, View view2, boolean z, int i, int i2) {
        Activity activity = (Activity) this.bwg.get();
        if (activity != null && aNV()) {
            if (z) {
                aNW();
            }
            if (this.eCk <= 0) {
                this.eCk = 3000;
            }
            TextView textView = (TextView) view2.findViewById(R.id.tv_text);
            this.mPopupWindow.setContentView(view2);
            this.mPopupWindow.setWidth(C9162a.m26662O(activity, QDisplayContext.DISPLAY_ROTATION_180));
            this.mPopupWindow.setHeight(-2);
            this.mPopupWindow.setFocusable(false);
            this.mPopupWindow.setOutsideTouchable(false);
            this.mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
            textView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    C9136a.this.aNX();
                }
            });
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            int width = this.eCi ? ((C9162a.dQd - this.mPopupWindow.getWidth()) - iArr[0]) + i : ((C9162a.dQd - iArr[0]) - ((view.getWidth() / 2) + C9162a.m26662O(activity, 24))) + i;
            int height = iArr[1] + view.getHeight() + i2;
            if (this.eCl) {
                this.mPopupWindow.setAnimationStyle(R.style.popup_animation);
            }
            this.mPopupWindow.showAtLocation(view, 53, width, height);
        }
    }

    /* renamed from: dT */
    public void mo36085dT(int i, int i2) {
        m26606e(false, i, i2);
    }

    /* renamed from: dt */
    public void mo36086dt(String str) {
        Activity activity = (Activity) this.bwg.get();
        if (activity != null && this.eCg != null) {
            this.eCo = str;
            TextView textView = (TextView) this.eCg.findViewById(R.id.tv_text);
            if (this.mTextSize != 0) {
                textView.setTextSize((float) this.mTextSize);
            }
            if (textView != null) {
                ArrayList rm = m26607rm(this.eCo);
                ArrayList rn = m26608rn(this.eCo);
                String str2 = "";
                for (int i = 0; i < Math.max(rm.size(), rn.size()); i++) {
                    if (i < rm.size()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(str2);
                        sb.append((String) rm.get(i));
                        str2 = sb.toString();
                    }
                    if (i < rn.size()) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str2);
                        sb2.append((String) rn.get(i));
                        str2 = sb2.toString();
                    }
                }
                textView.setText(str2);
                SpannableString spannableString = new SpannableString(textView.getText());
                for (int i2 = 0; i2 < rn.size(); i2++) {
                    String str3 = (String) rn.get(i2);
                    AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(C9162a.m26662O(activity, 15));
                    int indexOf = str2.indexOf(str3);
                    spannableString.setSpan(absoluteSizeSpan, indexOf, str3.length() + indexOf, 33);
                }
                textView.setText(spannableString);
            }
        }
    }

    /* renamed from: f */
    public void mo36087f(View view, int i, boolean z) {
        this.eCi = z;
        Activity activity = (Activity) this.bwg.get();
        if (activity != null) {
            this.eCf = view;
            this.eCm = i;
            if (this.eCg != null) {
                this.eCg.setVisibility(8);
                this.eCg = null;
            }
            switch (i) {
                case 0:
                    this.eCg = LayoutInflater.from(activity).inflate(R.layout.xyui_popup_full_screen, null);
                    break;
                case 1:
                    this.eCg = LayoutInflater.from(activity).inflate(R.layout.xyui_popup_tip_view, null);
                    RelativeLayout relativeLayout = (RelativeLayout) this.eCg.findViewById(R.id.txt_layout);
                    ((LayoutParams) relativeLayout.getLayoutParams()).addRule(13);
                    relativeLayout.setBackgroundResource(R.drawable.xyui_bg_help_toast);
                    break;
                case 2:
                    this.eCg = LayoutInflater.from(activity).inflate(R.layout.xyui_popup_tip_view, null);
                    RelativeLayout relativeLayout2 = (RelativeLayout) this.eCg.findViewById(R.id.txt_layout);
                    LayoutParams layoutParams = (LayoutParams) relativeLayout2.getLayoutParams();
                    layoutParams.addRule(14);
                    layoutParams.addRule(12);
                    relativeLayout2.setBackgroundResource(R.drawable.xyui_bg_help_toast);
                    break;
                case 3:
                    this.eCg = LayoutInflater.from(activity).inflate(R.layout.xyui_popup_tip_view, null);
                    RelativeLayout relativeLayout3 = (RelativeLayout) this.eCg.findViewById(R.id.txt_layout);
                    LayoutParams layoutParams2 = (LayoutParams) relativeLayout3.getLayoutParams();
                    if (z) {
                        layoutParams2.addRule(11);
                    } else {
                        layoutParams2.addRule(9);
                    }
                    layoutParams2.addRule(12);
                    relativeLayout3.setBackgroundResource(R.drawable.xyui_bg_help_pop_left_up);
                    break;
                case 4:
                    this.eCg = LayoutInflater.from(activity).inflate(R.layout.xyui_popup_tip_view, null);
                    RelativeLayout relativeLayout4 = (RelativeLayout) this.eCg.findViewById(R.id.txt_layout);
                    LayoutParams layoutParams3 = (LayoutParams) relativeLayout4.getLayoutParams();
                    layoutParams3.addRule(14);
                    layoutParams3.addRule(12);
                    relativeLayout4.setBackgroundResource(R.drawable.xyui_bg_help_pop_center_up);
                    break;
                case 5:
                    this.eCg = LayoutInflater.from(activity).inflate(R.layout.xyui_popup_tip_view, null);
                    RelativeLayout relativeLayout5 = (RelativeLayout) this.eCg.findViewById(R.id.txt_layout);
                    LayoutParams layoutParams4 = (LayoutParams) relativeLayout5.getLayoutParams();
                    if (z) {
                        layoutParams4.addRule(9);
                    } else {
                        layoutParams4.addRule(11);
                    }
                    layoutParams4.addRule(12);
                    relativeLayout5.setBackgroundResource(R.drawable.xyui_bg_help_pop_right_up);
                    break;
                case 6:
                    this.eCg = LayoutInflater.from(activity).inflate(R.layout.xyui_popup_hor_view, null);
                    RelativeLayout relativeLayout6 = (RelativeLayout) this.eCg.findViewById(R.id.txt_layout);
                    ((LayoutParams) relativeLayout6.getLayoutParams()).addRule(13);
                    relativeLayout6.setBackgroundResource(R.drawable.xyui_bg_help_toast_land);
                    break;
                case 7:
                    this.eCg = LayoutInflater.from(activity).inflate(R.layout.xyui_popup_hor_view, null);
                    RelativeLayout relativeLayout7 = (RelativeLayout) this.eCg.findViewById(R.id.txt_layout);
                    LayoutParams layoutParams5 = (LayoutParams) relativeLayout7.getLayoutParams();
                    layoutParams5.addRule(14);
                    layoutParams5.addRule(12);
                    relativeLayout7.setBackgroundResource(R.drawable.xyui_bg_help_pop_center_up);
                    break;
                case 8:
                    this.eCg = LayoutInflater.from(activity).inflate(R.layout.xyui_popup_tip_view, null);
                    RelativeLayout relativeLayout8 = (RelativeLayout) this.eCg.findViewById(R.id.txt_layout);
                    LayoutParams layoutParams6 = (LayoutParams) relativeLayout8.getLayoutParams();
                    if (z) {
                        layoutParams6.addRule(11);
                    } else {
                        layoutParams6.addRule(9);
                    }
                    layoutParams6.addRule(10);
                    relativeLayout8.setBackgroundResource(R.drawable.xyui_bg_help_pop_left_down);
                    break;
                case 9:
                    this.eCg = LayoutInflater.from(activity).inflate(R.layout.xyui_popup_tip_view, null);
                    RelativeLayout relativeLayout9 = (RelativeLayout) this.eCg.findViewById(R.id.txt_layout);
                    ((LayoutParams) relativeLayout9.getLayoutParams()).addRule(13);
                    relativeLayout9.setBackgroundResource(R.drawable.xyui_bg_help_pop_center_down);
                    break;
                case 10:
                    this.eCg = LayoutInflater.from(activity).inflate(R.layout.xyui_popup_tip_view, null);
                    RelativeLayout relativeLayout10 = (RelativeLayout) this.eCg.findViewById(R.id.txt_layout);
                    ((LayoutParams) relativeLayout10.getLayoutParams()).addRule(14);
                    relativeLayout10.setBackgroundResource(R.drawable.xyui_bg_help_pop_center_down);
                    break;
                case 11:
                    this.eCg = LayoutInflater.from(activity).inflate(R.layout.xyui_popup_tip_view, null);
                    RelativeLayout relativeLayout11 = (RelativeLayout) this.eCg.findViewById(R.id.txt_layout);
                    LayoutParams layoutParams7 = (LayoutParams) relativeLayout11.getLayoutParams();
                    if (z) {
                        layoutParams7.addRule(9);
                    } else {
                        layoutParams7.addRule(11);
                    }
                    layoutParams7.addRule(10);
                    layoutParams7.topMargin = C9162a.m26662O(activity, 5);
                    relativeLayout11.setBackgroundResource(R.drawable.xyui_bg_help_pop_right_down);
                    break;
                case 12:
                    this.eCg = LayoutInflater.from(activity).inflate(R.layout.xyui_popup_hor_view, null);
                    RelativeLayout relativeLayout12 = (RelativeLayout) this.eCg.findViewById(R.id.txt_layout);
                    ((LayoutParams) relativeLayout12.getLayoutParams()).addRule(14);
                    relativeLayout12.setBackgroundResource(R.drawable.xyui_bg_help_pop_center_down);
                    break;
            }
            if (this.eCg != null) {
                this.eCg.setOnClickListener(new OnClickListener() {
                    public void onClick(View view) {
                        C9136a.this.aNX();
                    }
                });
                try {
                    Drawable drawable = activity.getResources().getDrawable(R.drawable.xyui_icon_pupup_close_n);
                    drawable.setBounds(0, 0, C9162a.m26663P(10.0f), C9162a.m26663P(10.0f));
                    if (z) {
                        ((TextView) this.eCg.findViewById(R.id.tv_text)).setCompoundDrawables(drawable, null, null, null);
                    } else {
                        ((TextView) this.eCg.findViewById(R.id.tv_text)).setCompoundDrawables(null, null, drawable, null);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: h */
    public void mo36088h(View view, View view2) {
        if (aNV()) {
            aNW();
            this.mPopupWindow.setContentView(view2);
            this.mPopupWindow.setWidth(-2);
            this.mPopupWindow.setHeight(-2);
            this.mPopupWindow.setFocusable(false);
            this.mPopupWindow.setOutsideTouchable(false);
            this.mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
            ((TextView) view2.findViewById(R.id.tv_text)).setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    C9136a.this.aNX();
                }
            });
            view.getLocationOnScreen(new int[2]);
            this.mPopupWindow.showAtLocation(view, 17, 0, 0);
        }
    }

    /* renamed from: i */
    public void mo36089i(View view, View view2) {
        if (aNV()) {
            aNW();
            this.mPopupWindow.setContentView(view2);
            this.mPopupWindow.setWidth(-2);
            this.mPopupWindow.setHeight(-2);
            this.mPopupWindow.setFocusable(false);
            this.mPopupWindow.setOutsideTouchable(false);
            this.mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
            XYUiRotateTextView xYUiRotateTextView = (XYUiRotateTextView) view2.findViewById(R.id.tv_text);
            TextPaint paint = xYUiRotateTextView.getPaint();
            int i = (int) (paint.getFontMetrics().descent - paint.getFontMetrics().ascent);
            int measureText = (int) paint.measureText(this.eCo);
            xYUiRotateTextView.setWidth(i);
            xYUiRotateTextView.setHeight(measureText);
            xYUiRotateTextView.setDegree(QDisplayContext.DISPLAY_ROTATION_270);
            xYUiRotateTextView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    C9136a.this.aNX();
                }
            });
            view.getLocationOnScreen(new int[2]);
            this.mPopupWindow.showAtLocation(view, 17, 0, 0);
        }
    }

    public boolean isShowing() {
        return this.mPopupWindow != null && this.mPopupWindow.isShowing();
    }

    /* renamed from: j */
    public void mo36091j(View view, View view2) {
        if (aNV()) {
            this.mPopupWindow.setContentView(view2);
            this.mPopupWindow.setWidth(-1);
            this.mPopupWindow.setHeight(-1);
            this.mPopupWindow.setFocusable(false);
            this.mPopupWindow.setOutsideTouchable(false);
            this.mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
            view2.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                }
            });
            this.mPopupWindow.showAtLocation(view, 17, 0, 0);
        }
    }

    /* renamed from: jQ */
    public void mo36092jQ(boolean z) {
        this.eCl = z;
    }

    @TargetApi(17)
    /* renamed from: k */
    public void mo36093k(View view, View view2) {
        Activity activity = (Activity) this.bwg.get();
        if (activity != null && !activity.isFinishing()) {
            if (VERSION.SDK_INT >= 17) {
                try {
                    if (activity.isDestroyed()) {
                        return;
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            if (aNV()) {
                if (this.eCh <= 0) {
                    this.eCh = IronSourceConstants.REWARDED_VIDEO_DAILY_CAPPED;
                }
                if (this.eCk <= 0) {
                    this.eCk = 3000;
                }
                TextView textView = (TextView) view2.findViewById(R.id.tv_text);
                if (this.eCm != 2) {
                    try {
                        textView.setMaxWidth(C9162a.m26662O(activity, this.eCh));
                    } catch (NoSuchMethodError unused) {
                        textView.setWidth(C9162a.m26662O(activity, this.eCh));
                    }
                }
                this.mPopupWindow.setContentView(view2);
                if (this.eCm == 2) {
                    this.mPopupWindow.setWidth(-1);
                } else {
                    this.mPopupWindow.setWidth(C9162a.m26662O(activity, this.eCh));
                }
                this.mPopupWindow.setHeight(C9162a.m26662O(activity, this.eCp > 0 ? this.eCp : 100));
                this.mPopupWindow.setFocusable(false);
                this.mPopupWindow.setOutsideTouchable(false);
                this.mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
                textView.setOnClickListener(new OnClickListener() {
                    public void onClick(View view) {
                        C9136a.this.aNX();
                    }
                });
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                try {
                    int width = iArr[0] + ((view.getWidth() - this.mPopupWindow.getWidth()) / 2) + C9162a.m26663P((float) this.f3679NE);
                    int height = (iArr[1] - this.mPopupWindow.getHeight()) + C9162a.m26663P((float) this.f3680NF);
                    if (this.eCl) {
                        this.mPopupWindow.setAnimationStyle(R.style.popup_animation);
                    }
                    this.mPopupWindow.showAtLocation(view, 0, width, height);
                } catch (Exception unused2) {
                }
            }
        }
    }

    public void show() {
        m26606e(false, 0, 0);
    }

    public void show(int i) {
        m26606e(false, i, 0);
    }

    public void unInit() {
        aNU();
        if (this.eCf != null) {
            this.eCf = null;
        }
        if (this.eCg != null) {
            this.eCg.setVisibility(8);
            this.eCg = null;
        }
    }

    /* renamed from: vO */
    public void mo36097vO(int i) {
        this.eCj = i;
    }

    /* renamed from: vP */
    public void mo36098vP(int i) {
        this.eCh = i;
    }
}
