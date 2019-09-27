package com.introvd.template.camera.p233ui.view.indicator;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.PopupWindow;
import com.introvd.template.camera.p229b.C5008i;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.vivacamera.R;
import com.introvd.template.xyui.C9136a;
import java.lang.ref.WeakReference;

/* renamed from: com.introvd.template.camera.ui.view.indicator.c */
public class C5198c {
    private static final String TAG = "c";
    public static int bZn = 3000;
    public static int bZo = 6000;
    private C9136a bML;
    private View bZp;
    private View bZq;
    private View bZr;
    /* access modifiers changed from: private */
    public PopupWindow bZs;
    private WeakReference<Activity> bwg;
    private int nFlag = 0;

    public C5198c(Activity activity, boolean z) {
        this.bwg = new WeakReference<>(activity);
        this.bML = new C9136a(activity, z);
        bZn = 3000;
        bZo = 6000;
    }

    /* renamed from: YG */
    private void m14170YG() {
        if (!C5008i.m12937VU().mo25627Wn()) {
            this.bML.show();
        }
    }

    /* renamed from: ad */
    private void m14173ad(final Activity activity) {
        if (activity != null && !activity.isFinishing()) {
            View inflate = LayoutInflater.from(activity.getApplicationContext()).inflate(R.layout.cam_popup_filter_fling_help, null);
            this.bZs = new PopupWindow(activity);
            this.bZs.setContentView(inflate);
            this.bZs.setWidth(-1);
            this.bZs.setHeight(-1);
            this.bZs.setTouchable(true);
            this.bZs.setTouchInterceptor(new OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (C5198c.this.bZs != null) {
                        if (activity != null && !activity.isFinishing()) {
                            C5198c.this.bZs.dismiss();
                        }
                        C5198c.this.bZs = null;
                    }
                    return false;
                }
            });
            this.bZs.setOutsideTouchable(false);
            this.bZs.setBackgroundDrawable(new BitmapDrawable());
            View findViewById = activity.findViewById(R.id.cam_layout_main);
            if (!activity.isFinishing()) {
                this.bZs.showAtLocation(findViewById, 17, 0, 0);
            }
        }
    }

    /* renamed from: dx */
    public static void m14174dx(boolean z) {
        AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_view_show_tutorial", z);
    }

    /* renamed from: jH */
    public static void m14175jH(int i) {
        switch (i) {
            case 1:
                AppPreferencesSetting.getInstance().setAppSettingInt("key_single_click_record", AppPreferencesSetting.getInstance().getAppSettingInt("key_single_click_record", 0) + 1);
                return;
            case 2:
                AppPreferencesSetting.getInstance().setAppSettingInt("key_long_press_record", AppPreferencesSetting.getInstance().getAppSettingInt("key_long_press_record", 0) + 1);
                return;
            case 3:
                AppPreferencesSetting.getInstance().setAppSettingInt("key_enter_normal_mode", AppPreferencesSetting.getInstance().getAppSettingInt("key_enter_normal_mode", 0) + 1);
                return;
            case 4:
                AppPreferencesSetting.getInstance().setAppSettingInt("key_facebf_single_click_record", AppPreferencesSetting.getInstance().getAppSettingInt("key_facebf_single_click_record", 0) + 1);
                return;
            case 5:
                AppPreferencesSetting.getInstance().setAppSettingInt("key_facebf_long_press_record", AppPreferencesSetting.getInstance().getAppSettingInt("key_facebf_long_press_record", 0) + 1);
                return;
            default:
                return;
        }
    }

    /* renamed from: XJ */
    public void mo26313XJ() {
        int state = C5008i.m12937VU().getState();
        if (state != 2) {
            if (state == 6) {
                if ((this.nFlag & 4) != 4 && (this.nFlag & 8) != 8) {
                    mo26319jI(2);
                } else if ((this.nFlag & 4) == 4 && (this.nFlag & 8) != 8) {
                    mo26319jI(8);
                } else if ((this.nFlag & 8) == 8 && (this.nFlag & 32) != 32) {
                    mo26319jI(32);
                } else if ((this.nFlag & 32) == 32) {
                    mo26315XO();
                }
            }
        } else if ((this.nFlag & 4) != 4 && (this.nFlag & 32) != 32) {
            mo26319jI(2);
        } else if ((this.nFlag & 4) == 4 || (this.nFlag & 32) == 32) {
            mo26315XO();
        }
    }

    /* renamed from: XL */
    public void mo26314XL() {
        if (((Activity) this.bwg.get()) != null) {
        }
    }

    /* renamed from: XO */
    public void mo26315XO() {
        if (this.bML != null) {
            this.bML.aNX();
        }
        if (this.bZs != null) {
            this.bZs.dismiss();
            this.bZs = null;
        }
    }

    /* renamed from: YF */
    public boolean mo26316YF() {
        if (this.bZs != null) {
            return this.bZs.isShowing();
        }
        return false;
    }

    /* renamed from: a */
    public void mo26317a(View view, View view2, View view3, View view4) {
        this.bZp = view;
        this.bZr = view3;
        this.bZq = view4;
    }

    /* renamed from: jG */
    public void mo26318jG(int i) {
        Activity activity = (Activity) this.bwg.get();
        if (activity != null) {
            m14175jH(i);
            int appSettingInt = AppPreferencesSetting.getInstance().getAppSettingInt("key_single_click_record", 0);
            int appSettingInt2 = AppPreferencesSetting.getInstance().getAppSettingInt("key_long_press_record", 0);
            AppPreferencesSetting.getInstance().getAppSettingInt("key_enter_normal_mode", 0);
            int appSettingInt3 = AppPreferencesSetting.getInstance().getAppSettingInt("key_facebf_single_click_record", 0);
            int appSettingInt4 = AppPreferencesSetting.getInstance().getAppSettingInt("key_facebf_long_press_record", 0);
            if ((appSettingInt == 1 || appSettingInt2 == 2) && !AppPreferencesSetting.getInstance().getAppSettingBoolean("filter_help_show_flag", false)) {
                AppPreferencesSetting.getInstance().setAppSettingBoolean("filter_help_show_flag", true);
                m14173ad(activity);
            } else if ((appSettingInt == 2 || appSettingInt2 == 3) && !AppPreferencesSetting.getInstance().getAppSettingBoolean("record_finish_help_show", false)) {
                AppPreferencesSetting.getInstance().setAppSettingBoolean("record_finish_help_show", true);
                this.bML.mo36087f(this.bZp, 11, C4580b.m11666qi());
                this.bML.mo36086dt(activity.getResources().getString(R.string.xiaoying_str_cam_help_indicator_next));
                m14170YG();
            } else if ((appSettingInt3 == 1 || appSettingInt4 == 2) && !AppPreferencesSetting.getInstance().getAppSettingBoolean("fb_level_help_show", false)) {
                AppPreferencesSetting.getInstance().setAppSettingBoolean("fb_level_help_show", true);
                this.bML.mo36087f(this.bZq, 4, C4580b.m11666qi());
                this.bML.mo36086dt(activity.getResources().getString(R.string.xiaoying_str_help_cam_try_different_fb_level));
                m14170YG();
            }
        }
    }

    /* renamed from: jI */
    public void mo26319jI(int i) {
        mo26315XO();
    }

    public void onPause() {
        mo26315XO();
    }
}
