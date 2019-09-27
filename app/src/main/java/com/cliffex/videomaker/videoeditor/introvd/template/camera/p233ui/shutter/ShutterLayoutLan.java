package com.introvd.template.camera.p233ui.shutter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.introvd.template.camera.base.CameraViewBase;
import com.introvd.template.camera.p208a.C4662a;
import com.introvd.template.camera.p208a.C4669h;
import com.introvd.template.camera.p229b.C5008i;
import com.introvd.template.camera.p232e.C5031c;
import com.introvd.template.camera.p233ui.view.BackDeleteButton;
import com.introvd.template.camera.p233ui.view.CamRecordView;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p414ui.view.RotateImageView;
import com.introvd.template.router.camera.CameraCodeMgr;
import com.introvd.template.vivacamera.R;
import com.introvd.template.xyui.C9136a;
import java.lang.ref.WeakReference;

/* renamed from: com.introvd.template.camera.ui.shutter.ShutterLayoutLan */
public class ShutterLayoutLan extends RelativeLayout implements OnClickListener {
    private C9136a bML;
    private int bOz = 9;
    /* access modifiers changed from: private */
    public C4669h bVO;
    /* access modifiers changed from: private */
    public volatile boolean bVP = false;
    private CamRecordView bWa;
    private BackDeleteButton bWb;
    private RelativeLayout bWc;
    private RelativeLayout bWd;
    private boolean bWe = true;
    private CameraViewBase bWf;
    private RotateImageView bWg;
    private long bWh = 0;
    private RotateImageView bWi;
    private ImageView bWj;
    private C4662a bWk = new C4662a() {
        /* renamed from: cr */
        public void mo24976cr(boolean z) {
            ShutterLayoutLan.this.mo26071XO();
            if (ShutterLayoutLan.this.bVO != null) {
                ShutterLayoutLan.this.bVO.mo24996cr(z);
            }
            AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_help_camera_delete", true);
        }
    };
    private OnTouchListener bWl = new OnTouchListener() {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (C5008i.m12937VU().mo25615Wb()) {
                if (ShutterLayoutLan.this.bVO != null) {
                    ShutterLayoutLan.this.bVO.mo24991UP();
                }
                return true;
            }
            ShutterLayoutLan.this.mo26071XO();
            ShutterLayoutLan.this.mState = C5008i.m12937VU().getState();
            int action = motionEvent.getAction();
            if (action != 3) {
                switch (action) {
                    case 0:
                        if (ShutterLayoutLan.this.mState != 2) {
                            ShutterLayoutLan.this.mHandler.sendEmptyMessageDelayed(4097, 200);
                            break;
                        }
                        break;
                    case 1:
                        break;
                }
            }
            if (!ShutterLayoutLan.this.bVP) {
                ShutterLayoutLan.this.mHandler.removeMessages(4097);
                ShutterLayoutLan.this.m13940XQ();
                C5031c.m13216al(ShutterLayoutLan.this.getContext().getApplicationContext(), "tap");
            } else {
                ShutterLayoutLan.this.bVP = false;
                if (ShutterLayoutLan.this.bVO != null) {
                    ShutterLayoutLan.this.bVO.mo24997cs(true);
                }
                if (ShutterLayoutLan.this.bVO != null) {
                    ShutterLayoutLan.this.bVO.mo24985UJ();
                }
            }
            return true;
        }
    };
    private WeakReference<Activity> bwg;
    private Context mContext;
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            if (message.what == 4097) {
                ShutterLayoutLan.this.bVP = true;
                ShutterLayoutLan.this.m13940XQ();
            }
        }
    };
    /* access modifiers changed from: private */
    public int mState = -1;

    public ShutterLayoutLan(Context context) {
        super(context);
        this.mContext = context;
        initUI();
    }

    public ShutterLayoutLan(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initUI();
    }

    public ShutterLayoutLan(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        initUI();
    }

    /* access modifiers changed from: private */
    /* renamed from: XQ */
    public void m13940XQ() {
        if (C5008i.m12937VU().mo25611VX() != 0) {
            if (!C5008i.m12937VU().mo25608Ul()) {
                if (this.mState == 2) {
                    if (this.bVO != null) {
                        this.bVO.mo24997cs(true);
                    }
                    if (this.bVO != null) {
                        this.bVO.mo24985UJ();
                    }
                } else if (this.bVO != null) {
                    this.bVO.mo24988UM();
                }
            } else if (this.bVO != null) {
                this.bVO.mo24989UN();
            }
        } else if (this.mState == 2) {
            if (this.bVO != null) {
                this.bVO.mo24985UJ();
            }
        } else if (this.bVO != null) {
            this.bVO.mo24984UI();
        }
    }

    /* renamed from: XR */
    private boolean m13941XR() {
        return -1 != C5008i.m12937VU().mo25622Wi() && !C5008i.m12937VU().mo25620Wg();
    }

    /* renamed from: dr */
    private void m13948dr(boolean z) {
        if (!CameraCodeMgr.isCameraParamPIP(this.bOz)) {
            this.bWi.setVisibility(8);
            this.bWg.setVisibility(8);
        }
        if (!z) {
            this.bWi.setVisibility(8);
            this.bWg.setVisibility(8);
            this.bWb.setVisibility(4);
            return;
        }
        boolean Wh = C5008i.m12937VU().mo25621Wh();
        if (C5008i.m12937VU().getClipCount() > 0) {
            if (!CameraCodeMgr.isCameraParamPIP(this.bOz)) {
                this.bWb.setVisibility(0);
            } else if (m13941XR()) {
                this.bWi.setVisibility(0);
                this.bWg.setVisibility(8);
                this.bWb.setVisibility(4);
            } else if (Wh) {
                this.bWi.setVisibility(8);
                this.bWg.setVisibility(0);
                this.bWb.setVisibility(4);
            } else {
                this.bWb.setVisibility(0);
                this.bWi.setVisibility(8);
                this.bWg.setVisibility(8);
            }
        } else if (!CameraCodeMgr.isCameraParamPIP(this.bOz)) {
            this.bWb.setVisibility(4);
        } else if (m13941XR()) {
            this.bWi.setVisibility(0);
            this.bWg.setVisibility(8);
            this.bWb.setVisibility(4);
        } else if (Wh) {
            this.bWi.setVisibility(8);
            this.bWg.setVisibility(0);
            this.bWb.setVisibility(4);
        } else {
            this.bWb.setVisibility(4);
            this.bWi.setVisibility(8);
            this.bWg.setVisibility(8);
        }
    }

    private void initUI() {
        LayoutInflater.from(this.mContext).inflate(R.layout.cam_view_shutter_lan, this, true);
        this.bWa = (CamRecordView) findViewById(R.id.btn_rec_hor);
        this.bWa.setOnTouchListener(this.bWl);
        this.bWb = (BackDeleteButton) findViewById(R.id.xiaoying_cam_btn_delete);
        this.bWb.setDeleteSwitchClickListener(this.bWk);
        this.bWc = (RelativeLayout) findViewById(R.id.cam_next_layout);
        this.bWc.setOnClickListener(this);
        this.bWd = (RelativeLayout) findViewById(R.id.cam_layout_command_hor);
        this.bWg = (RotateImageView) findViewById(R.id.xiaoying_cam_btn_pip_gallery);
        this.bWg.setOnClickListener(this);
        this.bWi = (RotateImageView) findViewById(R.id.xiaoying_cam_pip_btn_back);
        this.bWi.setOnClickListener(this);
        this.bWj = (ImageView) findViewById(R.id.rec_blink);
    }

    /* renamed from: Un */
    public void mo26069Un() {
        this.bWb.setDeleteEnable(false);
        if (this.bVO != null) {
            this.bVO.mo24983UH();
        }
    }

    /* renamed from: Ux */
    public void mo26070Ux() {
        if (Math.abs(System.currentTimeMillis() - this.bWh) >= 500) {
            this.bWh = System.currentTimeMillis();
            if (this.mState == 2) {
                this.bWj.setImageResource(this.bWe ? R.drawable.v4_xiaoying_cam_rec1_lan : R.drawable.v4_xiaoying_cam_rec2_lan);
                this.bWe = !this.bWe;
            }
        }
    }

    /* renamed from: XO */
    public void mo26071XO() {
        if (this.bML != null) {
            this.bML.aNX();
        }
    }

    /* renamed from: a */
    public void mo26072a(Activity activity, CameraViewBase cameraViewBase) {
        this.bwg = new WeakReference<>(activity);
        this.bWf = cameraViewBase;
        this.bML = new C9136a((Activity) this.bwg.get(), true);
    }

    /* renamed from: dq */
    public void mo26073dq(boolean z) {
        this.bOz = C5008i.m12937VU().mo25610VW();
        if (!CameraCodeMgr.isCameraParamPIP(this.bOz)) {
            this.bWg.setVisibility(8);
            this.bWi.setVisibility(8);
        }
        if (z) {
            boolean Wh = C5008i.m12937VU().mo25621Wh();
            if (!CameraCodeMgr.isCameraParamPIP(this.bOz)) {
                this.bWc.setVisibility(0);
            } else if (Wh) {
                this.bWc.setVisibility(0);
            } else {
                this.bWc.setVisibility(4);
            }
            this.bWd.setBackgroundResource(R.drawable.xiaoying_cam_haft_trans_bg);
            if (C5008i.m12937VU().getClipCount() > 0) {
                m13948dr(z);
            } else {
                m13948dr(z);
            }
        } else {
            this.bWc.setVisibility(4);
            this.bWd.setBackgroundResource(R.drawable.xiaoying_com_trans_bg);
            this.bWb.setVisibility(4);
            this.bWg.setVisibility(4);
            this.bWi.setVisibility(4);
        }
    }

    /* renamed from: jB */
    public void mo26074jB(int i) {
        this.bOz = C5008i.m12937VU().mo25610VW();
        C5008i.m12937VU().mo25621Wh();
        if (!CameraCodeMgr.isCameraParamPIP(this.bOz)) {
            this.bWg.setVisibility(8);
        }
        if (i <= 0) {
            m13948dr(true);
            this.bWc.setVisibility(4);
            return;
        }
        int appSettingInt = AppPreferencesSetting.getInstance().getAppSettingInt("pref_help_new_video_count", 0);
        boolean appSettingBoolean = AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_help_camera_delete", false);
        if (appSettingInt >= 4 && !appSettingBoolean) {
            this.bML.mo36087f(this.bWb, 7, C4580b.m11666qi());
            this.bML.mo36086dt(getResources().getString(R.string.xiaoying_str_cam_help_indicator_delete));
            this.bML.show();
            AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_help_camera_delete", true);
        }
        m13948dr(true);
        boolean Wh = C5008i.m12937VU().mo25621Wh();
        if (!CameraCodeMgr.isCameraParamPIP(this.bOz)) {
            this.bWc.setVisibility(0);
        } else if (Wh) {
            this.bWc.setVisibility(0);
        } else {
            this.bWc.setVisibility(4);
        }
    }

    public void onClick(View view) {
        if (view.equals(this.bWg)) {
            if (this.bVO != null) {
                this.bVO.mo24992UQ();
            }
        } else if (view.equals(this.bWi)) {
            if (this.bVO != null) {
                this.bVO.mo24993UR();
            }
        } else if (view.equals(this.bWc)) {
            if (this.bVO != null) {
                this.bVO.mo24990UO();
            }
        } else if (view.equals(this.bWa)) {
            mo26071XO();
            this.mState = C5008i.m12937VU().getState();
            if (((Activity) this.bwg.get()) != null) {
                C5031c.m13216al(getContext().getApplicationContext(), "tap");
                m13940XQ();
            }
        }
    }

    public void onPause() {
        mo26071XO();
    }

    /* renamed from: p */
    public boolean mo26077p(MotionEvent motionEvent) {
        if (!C5008i.m12937VU().mo25612VY()) {
            return false;
        }
        int width = this.bWb.getWidth();
        int height = this.bWb.getHeight();
        int[] iArr = new int[2];
        this.bWb.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        rect.left = iArr[0];
        rect.top = iArr[1];
        rect.right = rect.left + width;
        rect.bottom = rect.top + height;
        this.bWb.setDeleteEnable(false);
        if (rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            if (this.bVO == null) {
                return true;
            }
            this.bVO.mo24996cr(true);
            return true;
        } else if (this.bVO == null) {
            return true;
        } else {
            this.bVO.mo24983UH();
            return true;
        }
    }

    public void setShutterLayoutLanEventListener(C4669h hVar) {
        this.bVO = hVar;
    }

    public void update() {
        this.bOz = C5008i.m12937VU().mo25610VW();
        C5008i.m12937VU().getClipCount();
        this.mState = C5008i.m12937VU().getState();
        if (!CameraCodeMgr.isCameraParamPIP(this.bOz)) {
            this.bWg.setVisibility(8);
            this.bWi.setVisibility(8);
        }
        switch (this.mState) {
            case 1:
                this.bWa.mo26137Yg();
                break;
            case 2:
                this.bWa.mo26136Yf();
                m13948dr(false);
                break;
            case 5:
                this.bWa.mo26137Yg();
                break;
            case 6:
                this.bWa.mo26137Yg();
                break;
        }
        this.bWb.mo26105XT();
    }
}
