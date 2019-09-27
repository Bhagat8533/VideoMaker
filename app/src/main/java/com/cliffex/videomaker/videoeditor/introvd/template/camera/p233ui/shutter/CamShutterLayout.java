package com.introvd.template.camera.p233ui.shutter;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.support.p024v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.introvd.template.camera.base.AbstractCameraView;
import com.introvd.template.camera.p208a.C4669h;
import com.introvd.template.camera.p229b.C4989b;
import com.introvd.template.camera.p229b.C4989b.C4990a;
import com.introvd.template.camera.p229b.C5008i;
import com.introvd.template.camera.p232e.C5031c;
import com.introvd.template.camera.p233ui.p234a.C5045a;
import com.introvd.template.camera.p233ui.p234a.C5045a.C5046a;
import com.introvd.template.camera.p233ui.view.CamRecordView;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.Constants;
import com.introvd.template.common.MSize;
import com.introvd.template.common.other.WeakHandler;
import com.introvd.template.common.recyclerviewutil.gallerylayoutmanager.GalleryLayoutManager;
import com.introvd.template.common.recyclerviewutil.gallerylayoutmanager.GalleryLayoutManager.OnItemSelectedListener;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.router.camera.CameraCodeMgr;
import com.introvd.template.sdk.p381b.p382a.C8386b;
import com.introvd.template.vivacamera.R;
import com.introvd.template.xyui.C9136a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.introvd.template.camera.ui.shutter.CamShutterLayout */
public class CamShutterLayout extends RelativeLayout implements OnClickListener {
    private static final String TAG = "CamShutterLayout";
    /* access modifiers changed from: private */
    public static List<C4990a> bVL = new ArrayList();
    private static int bVM = 1;
    /* access modifiers changed from: private */

    /* renamed from: Vu */
    public RecyclerView f3436Vu;
    /* access modifiers changed from: private */
    public C9136a bML;
    /* access modifiers changed from: private */
    public int bOz;
    private long bSR;
    private int bTr;
    /* access modifiers changed from: private */
    public CamRecordView bVI;
    private C5045a bVJ;
    private MSize bVK;
    /* access modifiers changed from: private */
    public List<Integer> bVN;
    /* access modifiers changed from: private */
    public C4669h bVO;
    /* access modifiers changed from: private */
    public volatile boolean bVP;
    /* access modifiers changed from: private */
    public AbstractCameraView bVQ;
    private ImageView bVR;
    /* access modifiers changed from: private */
    public ImageView bVS;
    private ImageView bVT;
    /* access modifiers changed from: private */
    public int bVU;
    OnItemSelectedListener bVV;
    private OnTouchListener bVW;
    private OnLongClickListener bVX;
    /* access modifiers changed from: private */
    public WeakReference<Activity> bwg;
    private Context mContext;
    /* access modifiers changed from: private */
    public Handler mHandler;
    private int mOrientation;
    /* access modifiers changed from: private */
    public int mState;

    /* renamed from: com.introvd.template.camera.ui.shutter.CamShutterLayout$a */
    public static class C5149a extends WeakHandler<CamShutterLayout> {
        public C5149a(CamShutterLayout camShutterLayout) {
            super(camShutterLayout);
        }

        public void handleMessage(Message message) {
            CamShutterLayout camShutterLayout = (CamShutterLayout) getOwner();
            if (camShutterLayout != null && message.what == 4097) {
                camShutterLayout.bVP = true;
                camShutterLayout.m13907XI();
            }
        }
    }

    public CamShutterLayout(Context context) {
        this(context, null);
    }

    public CamShutterLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CamShutterLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mState = -1;
        this.bVK = new MSize(800, 480);
        this.bOz = 1;
        this.bTr = 1;
        this.bVN = new ArrayList(5);
        this.bVP = false;
        this.bVU = 0;
        this.mOrientation = 256;
        this.bSR = 0;
        this.mHandler = new C5149a(this);
        this.bVV = new OnItemSelectedListener() {
            public void onItemSelected(RecyclerView recyclerView, View view, int i) {
                if (CamShutterLayout.this.bVO != null) {
                    if (CamShutterLayout.this.bVN != null && CamShutterLayout.this.bVN.contains(Integer.valueOf(i))) {
                        CamShutterLayout.this.bVN.remove(Integer.valueOf(i));
                    } else if (i >= 0 && i < CamShutterLayout.bVL.size()) {
                        CamShutterLayout.this.bVO.mo24995a((C4990a) CamShutterLayout.bVL.get(i));
                    }
                }
            }
        };
        this.bVW = new OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (C5008i.m12937VU().mo25615Wb()) {
                    if (CamShutterLayout.this.bVO != null) {
                        CamShutterLayout.this.bVO.mo24991UP();
                    }
                    return true;
                }
                if (!(!CameraCodeMgr.isParamMvNecessary(CamShutterLayout.this.bOz) || CamShutterLayout.this.bVQ.getCameraMusicMgr() == null || CamShutterLayout.this.bVO == null)) {
                    if (!CamShutterLayout.this.bVQ.getCameraMusicMgr().mo25576VK()) {
                        CamShutterLayout.this.bVO.mo24986UK();
                        return true;
                    } else if (CamShutterLayout.this.bVQ.getCameraMusicMgr().mo25578VM()) {
                        CamShutterLayout.this.bVO.mo24987UL();
                        return true;
                    }
                }
                boolean z = false;
                if (CamShutterLayout.this.bVI == null) {
                    return false;
                }
                int action = motionEvent.getAction();
                if (action != 3) {
                    switch (action) {
                        case 0:
                            CamShutterLayout.this.mo26050XO();
                            if (CamShutterLayout.this.mState != 2) {
                                CamShutterLayout.this.mHandler.sendEmptyMessageDelayed(4097, 200);
                                break;
                            }
                            break;
                        case 1:
                            break;
                    }
                }
                if (!CamShutterLayout.this.bVP) {
                    CamShutterLayout.this.mHandler.removeMessages(4097);
                    CamShutterLayout.this.m13907XI();
                    if (CamShutterLayout.this.bVO != null) {
                        C4669h d = CamShutterLayout.this.bVO;
                        if (CamShutterLayout.this.mState != 2) {
                            z = true;
                        }
                        d.mo24998ct(z);
                    }
                } else {
                    CamShutterLayout.this.bVP = false;
                    CamShutterLayout.this.mo26050XO();
                    if (CamShutterLayout.this.bVO != null) {
                        CamShutterLayout.this.bVO.mo24997cs(true);
                    }
                    if (CamShutterLayout.this.bVO != null) {
                        CamShutterLayout.this.bVO.mo24985UJ();
                    }
                    if (CamShutterLayout.this.bVO != null) {
                        CamShutterLayout.this.bVO.mo24994US();
                    }
                }
                return true;
            }
        };
        this.bVX = new OnLongClickListener() {
            public boolean onLongClick(View view) {
                if (view.equals(CamShutterLayout.this.bVI)) {
                    Activity activity = (Activity) CamShutterLayout.this.bwg.get();
                    if (activity != null && C5008i.m12937VU().mo25614Wa()) {
                        CamShutterLayout.this.bML.mo36087f(CamShutterLayout.this.bVI, 4, C4580b.m11666qi());
                        CamShutterLayout.this.bML.mo36086dt(activity.getResources().getString(R.string.xiaoying_str_cam_help_tip_08));
                        CamShutterLayout.this.bML.show();
                    }
                }
                return false;
            }
        };
        this.mContext = context;
        m13905Oj();
    }

    /* renamed from: Oj */
    private void m13905Oj() {
        if (Constants.getScreenSize() != null) {
            this.bVK.width = Constants.getScreenSize().width;
            this.bVK.height = Constants.getScreenSize().height;
        } else {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            this.bVK.height = displayMetrics.heightPixels;
            this.bVK.width = displayMetrics.widthPixels;
        }
        bVL = new ArrayList(C4989b.m12746iP(C5008i.m12937VU().mo25609VV()));
        bVM = C5008i.m12937VU().mo25629Wp() ? 1 : 0;
        if (C4580b.m11666qi()) {
            Collections.reverse(bVL);
        }
        LayoutInflater.from(this.mContext).inflate(R.layout.cam_view_shutter_por_new, this, true);
        this.f3436Vu = (RecyclerView) findViewById(R.id.recyclerview_cam_modes);
        GalleryLayoutManager galleryLayoutManager = new GalleryLayoutManager(0);
        galleryLayoutManager.attach(this.f3436Vu, bVM);
        galleryLayoutManager.setCallbackInFling(false);
        this.bVN.add(Integer.valueOf(bVM));
        this.bVJ = new C5045a(bVL);
        this.bVJ.mo25910a(new C5046a() {
            /* renamed from: a */
            public void mo25914a(View view, int i, C4990a aVar) {
                CamShutterLayout.this.f3436Vu.smoothScrollToPosition(i);
                CamShutterLayout.this.bVU = 1;
            }
        });
        this.f3436Vu.setAdapter(this.bVJ);
        galleryLayoutManager.setOnItemSelectedListener(this.bVV);
        this.bVI = (CamRecordView) findViewById(R.id.btn_rec);
        this.bVI.setOnLongClickListener(this.bVX);
        this.bVI.setOnTouchListener(this.bVW);
        this.bVR = (ImageView) findViewById(R.id.cam_btn_filter_effect);
        this.bVS = (ImageView) findViewById(R.id.cam_btn_fb_effect);
        m13906XH();
        this.bVT = (ImageView) findViewById(R.id.cam_btn_next);
        this.bVR.setOnClickListener(this);
        this.bVS.setOnClickListener(this);
        this.bVT.setOnClickListener(this);
        mo26054dp(true);
    }

    /* renamed from: XH */
    private void m13906XH() {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        int i = (int) (((double) this.bVK.width) * 0.112d);
        if (VERSION.SDK_INT >= 17) {
            layoutParams.setMarginStart(i);
        } else {
            layoutParams.setMargins(i, 0, 0, 0);
        }
        this.bVR.setLayoutParams(layoutParams);
        LayoutParams layoutParams2 = new LayoutParams(-2, -2);
        int i2 = (int) (((double) this.bVK.width) * 0.201d);
        if (VERSION.SDK_INT >= 17) {
            layoutParams2.setMarginStart(i2);
        } else {
            layoutParams2.setMargins(i2, 0, 0, 0);
        }
        ImageView imageView = this.bVS;
    }

    /* access modifiers changed from: private */
    /* renamed from: XI */
    public void m13907XI() {
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

    /* access modifiers changed from: private */
    /* renamed from: XK */
    public boolean m13908XK() {
        boolean z = false;
        try {
            if (C8386b.aHu() && CameraCodeMgr.isParamFacialEnable(this.bOz)) {
                z = true;
            }
            return z;
        } catch (Exception unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: XM */
    public void m13909XM() {
        Activity activity = (Activity) this.bwg.get();
        if (activity != null && this.bML != null && !AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_camera_use_sticker_tip", false) && this.bVS != null && this.bVS.getVisibility() == 0) {
            this.bML.mo36087f(this.bVS, 4, C4580b.m11666qi());
            this.bML.mo36086dt(activity.getResources().getString(R.string.xiaoying_str_cam_help_fd_try_tip));
            AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_camera_use_sticker_tip", true);
        }
    }

    /* renamed from: a */
    private void m13912a(View view, final View view2, float f, final boolean z) {
        String str = "translationX";
        float[] fArr = new float[1];
        if (C4580b.m11666qi()) {
            f = -f;
        }
        fArr[0] = f;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, str, fArr);
        ofFloat.setDuration(200);
        ofFloat.setStartDelay(100);
        ofFloat.addUpdateListener(new AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (view2 != null) {
                    double animatedFraction = (double) valueAnimator.getAnimatedFraction();
                    int i = 4;
                    if (animatedFraction > 0.9d && z && view2.getVisibility() != 0) {
                        View view = view2;
                        if (CamShutterLayout.this.m13908XK()) {
                            i = 0;
                        }
                        view.setVisibility(i);
                    } else if (animatedFraction > 0.1d && !z && view2.getVisibility() == 0) {
                        view2.setVisibility(4);
                    }
                }
            }
        });
        ofFloat.start();
    }

    /* renamed from: jA */
    private int m13924jA(int i) {
        if (CameraCodeMgr.isCameraParamFB(i)) {
            if (!C4580b.m11666qi()) {
                return 0;
            }
        } else if (!CameraCodeMgr.isCameraParamMV(i)) {
            return CameraCodeMgr.isCameraParamPerfect(i) ? 0 : 1;
        } else {
            if (C4580b.m11666qi()) {
                return 0;
            }
        }
        return 2;
    }

    /* renamed from: Uk */
    public void mo26046Uk() {
        Activity activity = (Activity) this.bwg.get();
        if (activity != null) {
            this.bML.mo36087f(this.bVI, 4, C4580b.m11666qi());
            this.bML.mo36086dt(activity.getResources().getString(R.string.xiaoying_str_cam_help_tip_05));
            this.bML.show();
        }
    }

    /* renamed from: XJ */
    public void mo26047XJ() {
        this.mState = C5008i.m12937VU().getState();
        this.bOz = C5008i.m12937VU().mo25610VW();
        switch (this.mState) {
            case 1:
                this.bVI.mo26137Yg();
                return;
            case 2:
                this.bVI.mo26136Yf();
                mo26050XO();
                if (CameraCodeMgr.isCameraParamFB(this.bOz)) {
                    C5031c.m13222b(getContext().getApplicationContext(), this.mOrientation, this.bSR);
                    return;
                }
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
    public void mo26048XL() {
        this.bOz = C5008i.m12937VU().mo25610VW();
        if (C5008i.m12937VU().mo25614Wa()) {
            this.bVI.setClickable(true);
            this.bVI.setLongClickable(true);
            this.bVI.mo26137Yg();
            return;
        }
        this.bVI.setClickable(false);
        this.bVI.setLongClickable(false);
    }

    /* renamed from: XN */
    public void mo26049XN() {
        Activity activity = (Activity) this.bwg.get();
        if (activity != null && this.bML != null && !AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_camera_first_record_tip", false) && this.bVI != null && this.bVI.getVisibility() == 0) {
            this.bML.mo36087f(this.bVI, 4, C4580b.m11666qi());
            this.bML.mo36086dt(activity.getResources().getString(R.string.xiaoying_str_cam_help_tap_or_hold_to_record));
            this.bML.mo36085dT(0, C4583d.m11673ii(10));
            AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_camera_first_record_tip", true);
        }
    }

    /* renamed from: XO */
    public void mo26050XO() {
        if (this.bML != null) {
            this.bML.aNX();
        }
    }

    /* renamed from: a */
    public void mo26051a(Activity activity, AbstractCameraView abstractCameraView) {
        this.bwg = new WeakReference<>(activity);
        this.bVQ = abstractCameraView;
        this.bML = new C9136a((Activity) this.bwg.get());
        if (this.bVI != null) {
            this.bVI.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    if (CamShutterLayout.this.bVI.isShown()) {
                        CamShutterLayout.this.mo26049XN();
                        CamShutterLayout.this.bVI.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    }
                }
            });
        }
    }

    /* renamed from: b */
    public void mo26052b(RelativeLayout relativeLayout) {
        relativeLayout.getLocationOnScreen(new int[2]);
        if (CameraCodeMgr.isCameraParamMV(this.bOz)) {
            if (this.bVI != null) {
                this.bVI.setGradientColor(Color.parseColor("#22C8FF"), Color.parseColor("#58FFC9"));
            }
        } else if (CameraCodeMgr.isCameraParamFB(this.bOz)) {
            if (this.bVI != null) {
                this.bVI.setGradientColor(Color.parseColor("#FC3964"), Color.parseColor("#FFB130"));
            }
        } else if (CameraCodeMgr.isCameraParamPerfect(this.bOz)) {
            if (this.bVI != null) {
                this.bVI.setGradientColor(Color.parseColor("#FF3030"), Color.parseColor("#FC3AA8"));
            }
        } else if (this.bVI != null) {
            this.bVI.setGradientColor(Color.parseColor("#FF6CFD"), Color.parseColor("#2C69FF"));
        }
    }

    /* renamed from: do */
    public void mo26053do(boolean z) {
        mo26050XO();
        int i = 0;
        this.bVU = 0;
        this.bOz = C5008i.m12937VU().mo25610VW();
        if (CameraCodeMgr.isParamFacialEnable(this.bTr)) {
            if (!CameraCodeMgr.isParamFacialEnable(this.bOz)) {
                m13912a(this.bVR, this.bVS, C4583d.dpToPixel(this.mContext, 18.0f), false);
            } else {
                ImageView imageView = this.bVS;
                if (!m13908XK()) {
                    i = 4;
                }
                imageView.setVisibility(i);
            }
        } else if (CameraCodeMgr.isParamFacialEnable(this.bOz)) {
            this.bVS.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    if (CamShutterLayout.this.bVS.isShown()) {
                        CamShutterLayout.this.m13909XM();
                        CamShutterLayout.this.bVS.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    }
                }
            });
            m13912a(this.bVR, this.bVS, -C4583d.dpToPixel(this.mContext, 18.0f), true);
        } else {
            this.bVS.setVisibility(4);
        }
        this.bTr = this.bOz;
        this.mState = C5008i.m12937VU().getState();
        mo26048XL();
        if (z) {
            this.bVU = -1;
            int jA = m13924jA(this.bOz);
            if (this.bVN != null && !this.bVN.contains(Integer.valueOf(jA))) {
                this.bVN.add(Integer.valueOf(jA));
                this.f3436Vu.smoothScrollToPosition(jA);
            }
        }
        if (CameraCodeMgr.isCameraParamFB(this.bOz)) {
            C5031c.m13224dR(getContext().getApplicationContext());
        }
    }

    /* renamed from: dp */
    public void mo26054dp(boolean z) {
        int clipCount = C5008i.m12937VU().getClipCount();
        int state = C5008i.m12937VU().getState();
        int i = 4;
        if (clipCount <= 0) {
            this.bVT.setVisibility(4);
        } else if (state != 2) {
            ImageView imageView = this.bVT;
            if (z) {
                i = 0;
            }
            imageView.setVisibility(i);
        } else {
            this.bVT.setVisibility(4);
        }
    }

    public int getModeSwitchType() {
        return this.bVU;
    }

    public void onClick(View view) {
        if (view.equals(this.bVR)) {
            if (this.bVO != null) {
                this.bVO.mo24999iM(0);
            }
        } else if (view.equals(this.bVS)) {
            if (this.bVO != null) {
                this.bVO.mo24999iM(1);
            }
        } else if (view.equals(this.bVT) && this.bVO != null) {
            this.bVO.mo24990UO();
        }
        mo26050XO();
    }

    public void onPause() {
        mo26050XO();
    }

    public void setCurrentEffectTemplateId(long j) {
        this.bSR = j;
    }

    public void setEnabled(boolean z) {
        int i = 4;
        this.bVS.setVisibility((z && m13908XK()) ? 0 : 4);
        this.bVR.setVisibility(z ? 0 : 4);
        this.bOz = C5008i.m12937VU().mo25610VW();
        this.f3436Vu.setVisibility(z ? 0 : 4);
        ImageView imageView = this.bVS;
        if (z && m13908XK()) {
            i = 0;
        }
        imageView.setVisibility(i);
        mo26054dp(z);
    }

    public void setOrientation(int i) {
        this.mOrientation = i;
    }

    public void setShutterLayoutEventListener(C4669h hVar) {
        this.bVO = hVar;
    }
}
