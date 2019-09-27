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
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.introvd.template.camera.base.CameraViewBase;
import com.introvd.template.camera.p208a.C4662a;
import com.introvd.template.camera.p208a.C4669h;
import com.introvd.template.camera.p229b.C5008i;
import com.introvd.template.camera.p233ui.view.BackDeleteButton;
import com.introvd.template.camera.p233ui.view.CamRecordView;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.MSize;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.router.camera.CameraCodeMgr;
import com.introvd.template.vivacamera.R;
import com.introvd.template.xyui.C9136a;
import java.lang.ref.WeakReference;

/* renamed from: com.introvd.template.camera.ui.shutter.ShutterLayoutPor */
public class ShutterLayoutPor extends RelativeLayout implements OnClickListener {
    private static final String TAG = "ShutterLayoutPor";
    private MSize bLT = new MSize(800, 480);
    /* access modifiers changed from: private */
    public C9136a bML;
    private int bOz = 9;
    /* access modifiers changed from: private */
    public CamRecordView bVI;
    /* access modifiers changed from: private */
    public C4669h bVO;
    /* access modifiers changed from: private */
    public volatile boolean bVP = false;
    private OnTouchListener bVW = new OnTouchListener() {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (C5008i.m12937VU().mo25615Wb()) {
                if (ShutterLayoutPor.this.bVO != null) {
                    ShutterLayoutPor.this.bVO.mo24991UP();
                }
                return true;
            }
            boolean z = false;
            if (ShutterLayoutPor.this.bVI == null) {
                return false;
            }
            int action = motionEvent.getAction();
            if (action != 3) {
                switch (action) {
                    case 0:
                        if (ShutterLayoutPor.this.mState != 2) {
                            ShutterLayoutPor.this.mHandler.sendEmptyMessageDelayed(4097, 200);
                            break;
                        }
                        break;
                    case 1:
                        break;
                }
            }
            if (!ShutterLayoutPor.this.bVP) {
                ShutterLayoutPor.this.mHandler.removeMessages(4097);
                ShutterLayoutPor.this.m13958XI();
                if (ShutterLayoutPor.this.bVO != null) {
                    C4669h b = ShutterLayoutPor.this.bVO;
                    if (ShutterLayoutPor.this.mState != 2) {
                        z = true;
                    }
                    b.mo24998ct(z);
                }
            } else {
                ShutterLayoutPor.this.bVP = false;
                ShutterLayoutPor.this.mo26088XO();
                if (ShutterLayoutPor.this.bVO != null) {
                    ShutterLayoutPor.this.bVO.mo24997cs(true);
                }
                if (ShutterLayoutPor.this.bVO != null) {
                    ShutterLayoutPor.this.bVO.mo24985UJ();
                }
                if (ShutterLayoutPor.this.bVO != null) {
                    ShutterLayoutPor.this.bVO.mo24994US();
                }
            }
            return true;
        }
    };
    private OnLongClickListener bVX = new OnLongClickListener() {
        public boolean onLongClick(View view) {
            if (view.equals(ShutterLayoutPor.this.bVI)) {
                Activity activity = (Activity) ShutterLayoutPor.this.bwg.get();
                if (activity != null && C5008i.m12937VU().mo25614Wa()) {
                    ShutterLayoutPor.this.bML.mo36087f(ShutterLayoutPor.this.bVI, 4, C4580b.m11666qi());
                    ShutterLayoutPor.this.bML.mo36086dt(activity.getResources().getString(R.string.xiaoying_str_cam_help_tip_08));
                    ShutterLayoutPor.this.bML.show();
                }
            }
            return false;
        }
    };
    private BackDeleteButton bWb;
    private boolean bWe = true;
    private CameraViewBase bWf;
    private long bWh = 0;
    private ImageView bWj;
    private C4662a bWk = new C4662a() {
        /* renamed from: cr */
        public void mo24976cr(boolean z) {
            ShutterLayoutPor.this.mo26088XO();
            if (ShutterLayoutPor.this.bVO != null) {
                ShutterLayoutPor.this.bVO.mo24996cr(z);
            }
            AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_help_camera_delete", true);
        }
    };
    private RelativeLayout bWn;
    private RelativeLayout bWo;
    private int bWp;
    private Button bWq;
    private boolean bWr = false;
    private boolean bWs = true;
    private Button bWt;
    /* access modifiers changed from: private */
    public WeakReference<Activity> bwg;
    private Context mContext;
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler() {
        public void handleMessage(Message message) {
            if (message.what == 4097) {
                ShutterLayoutPor.this.bVP = true;
                ShutterLayoutPor.this.m13958XI();
            }
        }
    };
    private int mIndicatorHeight;
    /* access modifiers changed from: private */
    public int mState = -1;

    public ShutterLayoutPor(Context context) {
        super(context);
        this.mContext = context;
        initUI();
    }

    public ShutterLayoutPor(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initUI();
    }

    public ShutterLayoutPor(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        initUI();
    }

    /* access modifiers changed from: private */
    /* renamed from: XI */
    public void m13958XI() {
        if (((Activity) this.bwg.get()) != null) {
            if (C5008i.m12937VU().mo25611VX() == 0) {
                if (this.mState == 2) {
                    if (this.bVO != null) {
                        this.bVO.mo24997cs(true);
                    }
                    if (this.bVO != null) {
                        this.bVO.mo24985UJ();
                    }
                } else {
                    if (this.bVO != null) {
                        this.bVO.mo24984UI();
                    }
                    if (this.bVO != null) {
                        this.bVO.mo24997cs(false);
                    }
                }
            } else if (!C5008i.m12937VU().mo25608Ul()) {
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
        }
    }

    /* renamed from: XR */
    private boolean m13959XR() {
        return -1 != C5008i.m12937VU().mo25622Wi() && !C5008i.m12937VU().mo25620Wg();
    }

    /* renamed from: dr */
    private void m13965dr(boolean z) {
        if (!CameraCodeMgr.isCameraParamPIP(this.bOz)) {
            this.bWt.setVisibility(8);
            this.bWq.setVisibility(8);
        }
        if (!z) {
            this.bWt.setVisibility(8);
            this.bWq.setVisibility(8);
            this.bWb.setVisibility(4);
            return;
        }
        boolean Wh = C5008i.m12937VU().mo25621Wh();
        if (C5008i.m12937VU().getClipCount() > 0) {
            if (!CameraCodeMgr.isCameraParamPIP(this.bOz)) {
                this.bWb.setVisibility(0);
            } else if (m13959XR()) {
                this.bWt.setVisibility(0);
                this.bWq.setVisibility(8);
                this.bWb.setVisibility(4);
            } else if (Wh) {
                this.bWt.setVisibility(8);
                this.bWq.setVisibility(0);
                this.bWb.setVisibility(4);
            } else {
                this.bWb.setVisibility(0);
                this.bWt.setVisibility(8);
                this.bWq.setVisibility(8);
            }
        } else if (!CameraCodeMgr.isCameraParamPIP(this.bOz)) {
            this.bWb.setVisibility(4);
        } else if (m13959XR()) {
            this.bWt.setVisibility(0);
            this.bWq.setVisibility(8);
            this.bWb.setVisibility(4);
        } else if (Wh) {
            this.bWt.setVisibility(8);
            this.bWq.setVisibility(0);
            this.bWb.setVisibility(4);
        } else {
            this.bWb.setVisibility(4);
            this.bWt.setVisibility(8);
            this.bWq.setVisibility(8);
        }
    }

    private void initUI() {
        WindowManager windowManager = (WindowManager) this.mContext.getSystemService("window");
        this.bLT.width = windowManager.getDefaultDisplay().getWidth();
        this.bLT.height = windowManager.getDefaultDisplay().getHeight();
        this.bWp = getResources().getDimensionPixelSize(R.dimen.v4_cam_default_shutter_btn_height);
        this.mIndicatorHeight = getResources().getDimensionPixelSize(R.dimen.v4_xiaoying_cam_indicator_height);
        LayoutInflater.from(this.mContext).inflate(R.layout.cam_view_shutter_por, this, true);
        this.bWn = (RelativeLayout) findViewById(R.id.cam_layout_shutter);
        this.bVI = (CamRecordView) findViewById(R.id.btn_rec);
        this.bVI.setOnLongClickListener(this.bVX);
        this.bWb = (BackDeleteButton) findViewById(R.id.xiaoying_cam_btn_delete);
        this.bWb.setDeleteSwitchClickListener(this.bWk);
        this.bWo = (RelativeLayout) findViewById(R.id.cam_layout_command);
        this.bVI.setOnTouchListener(this.bVW);
        this.bWq = (Button) findViewById(R.id.xiaoying_cam_btn_pip_gallery);
        this.bWq.setOnClickListener(this);
        this.bWt = (Button) findViewById(R.id.xiaoying_cam_pip_btn_back);
        this.bWt.setOnClickListener(this);
        this.bWj = (ImageView) findViewById(R.id.rec_blink);
    }

    /* renamed from: UB */
    public void mo26082UB() {
        if (((Activity) this.bwg.get()) != null) {
        }
    }

    /* renamed from: Uk */
    public void mo26083Uk() {
        Activity activity = (Activity) this.bwg.get();
        if (activity != null) {
            this.bML.mo36087f(this.bVI, 4, C4580b.m11666qi());
            this.bML.mo36086dt(activity.getResources().getString(R.string.xiaoying_str_cam_help_tip_05));
            this.bML.show();
        }
    }

    /* renamed from: Un */
    public void mo26084Un() {
        this.bWb.setDeleteEnable(false);
        if (this.bVO != null) {
            this.bVO.mo24983UH();
        }
    }

    /* renamed from: Ux */
    public void mo26085Ux() {
        if (Math.abs(System.currentTimeMillis() - this.bWh) >= 500 && !this.bWs) {
            this.bWh = System.currentTimeMillis();
            if (C5008i.m12937VU().mo25614Wa() && this.mState == 2) {
                this.bWj.setImageResource(this.bWe ? R.drawable.v4_xiaoying_cam_rec1 : R.drawable.v4_xiaoying_cam_rec2);
                this.bWe = !this.bWe;
            }
        }
    }

    /* renamed from: XJ */
    public void mo26086XJ() {
        this.mState = C5008i.m12937VU().getState();
        this.bOz = C5008i.m12937VU().mo25610VW();
        switch (this.mState) {
            case 1:
                this.bVI.mo26137Yg();
                return;
            case 2:
                this.bVI.mo26136Yf();
                mo26088XO();
                return;
            case 5:
                this.bVI.mo26137Yg();
                return;
            case 6:
                this.bVI.mo26137Yg();
                return;
            default:
                return;
        }
    }

    /* renamed from: XL */
    public void mo26087XL() {
        this.bOz = C5008i.m12937VU().mo25610VW();
        if (C5008i.m12937VU().mo25614Wa()) {
            this.bVI.setClickable(true);
            this.bVI.setLongClickable(true);
            this.bVI.mo26137Yg();
            if (this.bWs) {
                this.bWj.setVisibility(4);
            } else {
                this.bWj.setVisibility(0);
                this.bWj.setImageResource(R.drawable.v4_xiaoying_cam_rec1);
            }
            this.bWr = true;
            return;
        }
        this.bVI.setClickable(false);
        this.bVI.setLongClickable(false);
        this.bWj.setVisibility(4);
        this.bWr = false;
    }

    /* renamed from: XO */
    public void mo26088XO() {
        if (this.bML != null) {
            this.bML.aNX();
        }
    }

    /* renamed from: XS */
    public void mo26089XS() {
    }

    /* renamed from: XT */
    public void mo26090XT() {
        this.bOz = C5008i.m12937VU().mo25610VW();
        this.mState = C5008i.m12937VU().getState();
        if (!CameraCodeMgr.isCameraParamPIP(this.bOz)) {
            this.bWq.setVisibility(8);
            this.bWt.setVisibility(8);
        }
        mo26087XL();
        this.bWb.mo26105XT();
    }

    /* renamed from: XU */
    public void mo26091XU() {
        int clipCount = C5008i.m12937VU().getClipCount();
        this.bOz = C5008i.m12937VU().mo25610VW();
        C5008i.m12937VU().mo25621Wh();
        int state = C5008i.m12937VU().getState();
        boolean z = true;
        if (clipCount <= 0) {
            if (state == 2) {
                z = false;
            }
            m13965dr(z);
            return;
        }
        int appSettingInt = AppPreferencesSetting.getInstance().getAppSettingInt("pref_help_new_video_count", 0);
        boolean appSettingBoolean = AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_help_camera_delete", false);
        if (appSettingInt >= 4 && !appSettingBoolean) {
            Activity activity = (Activity) this.bwg.get();
            if (activity != null) {
                this.bML.mo36087f(this.bWb, 5, C4580b.m11666qi());
                this.bML.mo36086dt(getResources().getString(R.string.xiaoying_str_cam_help_indicator_delete));
                this.bML.show(-C4583d.m11670O(activity, 40));
                AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_help_camera_delete", true);
            }
        }
        if (state == 2) {
            z = false;
        }
        m13965dr(z);
    }

    /* renamed from: a */
    public void mo26092a(Activity activity, CameraViewBase cameraViewBase) {
        this.bwg = new WeakReference<>(activity);
        this.bWf = cameraViewBase;
        this.bML = new C9136a((Activity) this.bwg.get(), true);
    }

    /* renamed from: b */
    public void mo26093b(RelativeLayout relativeLayout) {
        relativeLayout.getLocationOnScreen(new int[2]);
        LayoutParams layoutParams = (LayoutParams) relativeLayout.getLayoutParams();
        int i = ((this.bLT.height - layoutParams.topMargin) - layoutParams.height) - this.mIndicatorHeight;
        LayoutParams layoutParams2 = (LayoutParams) this.bWo.getLayoutParams();
        layoutParams2.height = i;
        this.bWo.setLayoutParams(layoutParams2);
        LayoutParams layoutParams3 = (LayoutParams) this.bWn.getLayoutParams();
        if (i < this.bWp) {
            layoutParams3.height = i;
            layoutParams3.width = layoutParams3.height;
            this.bWn.setLayoutParams(layoutParams3);
        }
    }

    public BackDeleteButton getBackDeleteButton() {
        return this.bWb;
    }

    public View getBtnCapRec() {
        return this.bVI;
    }

    public void onClick(View view) {
        if (view.equals(this.bWq)) {
            if (this.bVO != null) {
                this.bVO.mo24992UQ();
            }
        } else if (view.equals(this.bWt) && this.bVO != null) {
            this.bVO.mo24993UR();
        }
    }

    public void onPause() {
        mo26088XO();
    }

    /* renamed from: p */
    public boolean mo26098p(MotionEvent motionEvent) {
        if (C5008i.m12937VU().mo25612VY()) {
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
                if (this.bVO != null) {
                    this.bVO.mo24996cr(true);
                }
            } else if (this.bVO == null) {
                return true;
            } else {
                this.bVO.mo24983UH();
                return true;
            }
        }
        return false;
    }

    public void setEnabled(boolean z) {
        this.bOz = C5008i.m12937VU().mo25610VW();
        if (C5008i.m12937VU().getClipCount() > 0) {
            m13965dr(z);
        } else {
            m13965dr(z);
        }
    }

    public void setShutterLayoutEventListener(C4669h hVar) {
        this.bVO = hVar;
    }

    public void update() {
        mo26086XJ();
        mo26090XT();
        mo26091XU();
        mo26087XL();
    }
}
