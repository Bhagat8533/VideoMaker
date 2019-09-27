package com.introvd.template.camera.p233ui.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.introvd.template.camera.p233ui.view.seekbar.C5201a;
import com.introvd.template.camera.p233ui.view.seekbar.C5201a.C5203a;
import com.introvd.template.camera.p233ui.view.seekbar.DraggableSeekBar;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.p203b.C4562a;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.vivacamera.R;

/* renamed from: com.introvd.template.camera.ui.view.a */
public class C5179a extends PopupWindow implements OnClickListener {
    private static final int[] bYw = {0, 3, 5, 10};
    private C5201a bWV;
    private View bYC;
    private DraggableSeekBar bYD;
    private float bYE = 1.0f;
    private ImageView bYF;
    private RelativeLayout bYG;
    private RelativeLayout bYH;
    private ImageView bYI;
    private ImageView bYJ;
    private ImageView bYK;
    private LinearLayout bYL;
    private LinearLayout bYM;
    private int bYN = 0;
    private boolean bYO;
    private boolean bYP;
    private boolean bYQ;
    /* access modifiers changed from: private */
    public C5181a bYR;
    private Context mContext;

    /* renamed from: com.introvd.template.camera.ui.view.a$a */
    public interface C5181a {
        /* renamed from: Xp */
        void mo25980Xp();

        /* renamed from: Xq */
        void mo25981Xq();

        /* renamed from: Xr */
        void mo25982Xr();

        /* renamed from: jv */
        void mo25983jv(int i);

        void onSpeedChanged(float f);
    }

    public C5179a(Context context) {
        super(context);
        this.mContext = context;
        this.bYC = LayoutInflater.from(context).inflate(R.layout.cam_popup_tool_setting, null);
        setWidth(-1);
        setHeight(mo26222U(200.0f));
        setBackgroundDrawable(new ColorDrawable(0));
        setContentView(this.bYC);
        setFocusable(true);
        setOutsideTouchable(true);
        setAnimationStyle(R.style.xiaoying_window_preview);
        m14084Oj();
    }

    /* renamed from: Oj */
    private void m14084Oj() {
        m14085Yt();
        this.bYF = (ImageView) this.bYC.findViewById(R.id.icon_tool_flashlight);
        this.bYI = (ImageView) this.bYC.findViewById(R.id.icon_tool_grid);
        this.bYJ = (ImageView) this.bYC.findViewById(R.id.icon_tool_time);
        this.bYK = (ImageView) this.bYC.findViewById(R.id.icon_tool_aelock);
        this.bYG = (RelativeLayout) this.bYC.findViewById(R.id.layout_tool_flashlight);
        this.bYH = (RelativeLayout) this.bYC.findViewById(R.id.layout_tool_aelock);
        this.bYL = (LinearLayout) this.bYC.findViewById(R.id.line);
        this.bYM = (LinearLayout) this.bYC.findViewById(R.id.layout_speed);
        this.bYF.setOnClickListener(this);
        this.bYI.setOnClickListener(this);
        this.bYJ.setOnClickListener(this);
        this.bYK.setOnClickListener(this);
        mo26223Yu();
    }

    /* renamed from: Yt */
    private void m14085Yt() {
        this.bYD = (DraggableSeekBar) this.bYC.findViewById(R.id.speed_bar);
        this.bWV = new C5201a(this.bYD, false);
        this.bWV.mo26350a(new String[]{"1/4", "1", "2", "3", "4"}, new String[]{"1/4", "1/3", "1/2", "2/3", "4/5", "1", "1.2", "1.4", "1.6", "1.8", "2", "2.2", "2.4", "2.6", "2.8", "3", "3.2", "3.4", "3.6", "3.8", "4"}, new Float[]{Float.valueOf(4.0f), Float.valueOf(3.0f), Float.valueOf(2.0f), Float.valueOf(1.5f), Float.valueOf(1.25f), Float.valueOf(1.0f), Float.valueOf(0.9f), Float.valueOf(0.8f), Float.valueOf(0.7f), Float.valueOf(0.6f), Float.valueOf(0.5f), Float.valueOf(0.467f), Float.valueOf(0.433f), Float.valueOf(0.4f), Float.valueOf(0.367f), Float.valueOf(0.333f), Float.valueOf(0.316f), Float.valueOf(0.3f), Float.valueOf(0.283f), Float.valueOf(0.267f), Float.valueOf(0.25f)}, this.bYE, 1308622847, true, true);
        this.bWV.mo26349a((C5203a) new C5203a() {
            /* renamed from: R */
            public void mo26133R(float f) {
                if (C5179a.this.bYR != null) {
                    C5179a.this.bYR.onSpeedChanged(f);
                }
            }

            /* renamed from: Yc */
            public void mo26134Yc() {
            }
        });
    }

    /* renamed from: Yv */
    private void m14086Yv() {
        if ("on".equals(AppPreferencesSetting.getInstance().getAppSettingStr("pref_timer_onoff_key", "off"))) {
            int appSettingInt = AppPreferencesSetting.getInstance().getAppSettingInt("pref_timer_onoff_value_key", 0);
            if (appSettingInt == 0) {
                this.bYJ.setImageResource(R.drawable.xiaoying_cam_icon_tool_timer_nrm);
            } else if (appSettingInt == 3) {
                this.bYJ.setImageResource(R.drawable.xiaoying_cam_icon_tool_timer_three);
            } else if (appSettingInt == 5) {
                this.bYJ.setImageResource(R.drawable.xiaoying_cam_icon_tool_timer_five);
            } else if (appSettingInt == 10) {
                this.bYJ.setImageResource(R.drawable.xiaoying_cam_icon_tool_timer_ten);
            }
        } else {
            this.bYJ.setImageResource(R.drawable.xiaoying_cam_icon_tool_timer_nrm);
        }
    }

    /* renamed from: Yw */
    private void m14087Yw() {
        String appSettingStr = AppPreferencesSetting.getInstance().getAppSettingStr("pref_view_flash_mode", "no_flash");
        if ("on".equals(appSettingStr)) {
            this.bYG.setVisibility(0);
            this.bYF.setImageResource(R.drawable.xiaoying_cam_icon_tool_flashlight_on);
            this.bYO = true;
        } else if ("off".equals(appSettingStr)) {
            this.bYG.setVisibility(0);
            this.bYF.setImageResource(R.drawable.xiaoying_cam_icon_tool_flashlight_off);
            this.bYO = false;
        } else if ("no_flash".equals(appSettingStr)) {
            this.bYG.setVisibility(8);
            this.bYO = false;
        }
    }

    /* renamed from: Yx */
    private void m14088Yx() {
        if ("off".equals(AppPreferencesSetting.getInstance().getAppSettingStr("pref_view_grid", "off"))) {
            this.bYI.setImageResource(R.drawable.xiaoying_cam_icon_tool_grid_nrm);
            this.bYP = false;
            return;
        }
        this.bYI.setImageResource(R.drawable.xiaoying_cam_icon_tool_grid_on);
        this.bYP = true;
    }

    /* renamed from: Yy */
    private void m14089Yy() {
        String appSettingStr = AppPreferencesSetting.getInstance().getAppSettingStr("pref_view_ae_lock", "no_aelock");
        if ("unlock".equals(appSettingStr)) {
            this.bYH.setVisibility(0);
            this.bYK.setImageResource(R.drawable.xiaoying_cam_icon_tool_aelock_nrm);
            this.bYQ = true;
        } else if (SocialConstDef.TEMPLATELOCKINFO_ITEM_LOCK.equals(appSettingStr)) {
            this.bYH.setVisibility(0);
            this.bYK.setImageResource(R.drawable.xiaoying_cam_icon_tool_aelock_unlock);
            this.bYQ = false;
        } else if ("no_aelock".equals(appSettingStr)) {
            this.bYH.setVisibility(8);
            this.bYQ = true;
        }
    }

    private int getIndex(int i) {
        for (int i2 = 0; i2 < bYw.length; i2++) {
            if (bYw[i2] == i) {
                return i2;
            }
        }
        return 0;
    }

    /* renamed from: S */
    public void mo26220S(float f) {
        this.bYE = f;
    }

    /* renamed from: T */
    public void mo26221T(float f) {
        this.bYE = f;
        this.bWV.update(f);
    }

    /* renamed from: U */
    public int mo26222U(float f) {
        return (int) C4583d.dpToPixel(this.mContext, f);
    }

    /* renamed from: Yu */
    public void mo26223Yu() {
        m14087Yw();
        m14088Yx();
        m14086Yv();
        m14089Yy();
    }

    /* renamed from: a */
    public void mo26224a(C5181a aVar) {
        this.bYR = aVar;
    }

    /* renamed from: cp */
    public void mo26225cp(View view) {
        if (!isShowing()) {
            showAsDropDown(view, 0, mo26222U(12.0f));
            if (view != null && view.getTag() != null) {
                mo26227iH(((Integer) view.getTag()).intValue());
                return;
            }
            return;
        }
        dismiss();
    }

    /* renamed from: dw */
    public void mo26226dw(boolean z) {
        if (z) {
            this.bYL.setVisibility(0);
            this.bYM.setVisibility(0);
            setWidth(-1);
            setHeight(mo26222U(200.0f));
            update();
            return;
        }
        this.bYL.setVisibility(8);
        this.bYM.setVisibility(8);
        setWidth(-1);
        setHeight(mo26222U(85.0f));
        update();
    }

    /* renamed from: iH */
    public void mo26227iH(int i) {
        if (isShowing() && getContentView() != null) {
            C4562a.m11540v(getContentView().findViewById(R.id.icon_tool_flashlight), i);
            C4562a.m11540v(getContentView().findViewById(R.id.icon_tool_grid), i);
            C4562a.m11540v(getContentView().findViewById(R.id.icon_tool_time), i);
            C4562a.m11540v(getContentView().findViewById(R.id.icon_tool_aelock), i);
        }
    }

    public void onClick(View view) {
        if (view.getId() == R.id.icon_tool_flashlight) {
            if (this.bYR != null) {
                this.bYR.mo25980Xp();
            }
        } else if (view.getId() == R.id.icon_tool_grid) {
            if (this.bYR != null) {
                this.bYR.mo25981Xq();
            }
        } else if (view.getId() == R.id.icon_tool_time) {
            if (!C4580b.m11664ig(600)) {
                int index = getIndex(this.bYN) + 1;
                if (index >= bYw.length) {
                    index = 0;
                }
                this.bYN = bYw[index];
                if (this.bYR != null) {
                    this.bYR.mo25983jv(this.bYN);
                }
            }
        } else if (view.getId() == R.id.icon_tool_aelock && this.bYR != null) {
            this.bYR.mo25982Xr();
        }
    }
}
