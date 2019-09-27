package com.introvd.template.editor.effects.customwatermark;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.editor.R;
import com.introvd.template.editor.base.BaseOperationView;
import com.introvd.template.editor.common.p248b.C5842b;
import com.introvd.template.editor.common.terminator.Terminator;
import com.introvd.template.editor.common.terminator.Terminator.C5858a;
import com.introvd.template.editor.effects.PlayerFakeView;
import com.introvd.template.editor.effects.PlayerFakeView.C5889a;
import com.introvd.template.editor.effects.PlayerFakeView.C5890b;
import com.introvd.template.editor.effects.quickposition.PixelMoveControlView;
import com.introvd.template.editor.effects.quickposition.PixelMoveControlView.C6189a;
import com.introvd.template.editor.widget.scalerotate.p295a.C7065a;
import com.introvd.template.explorer.C7134a;
import com.introvd.template.explorer.p298c.C7149c;
import com.introvd.template.module.iap.C8049f;
import com.introvd.template.module.iap.C8070o;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.p204a.C4576e;
import com.introvd.template.p203b.p204a.C4577f;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.router.iap.IapRTConstants;
import com.introvd.template.sdk.model.StylePositionModel;
import com.introvd.template.sdk.model.editor.ScaleRotateViewState;
import com.introvd.template.xyui.C9136a;
import org.greenrobot.eventbus.C10021c;
import org.greenrobot.eventbus.C10031j;
import org.greenrobot.eventbus.ThreadMode;
import p037b.p050b.p054b.C1494a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p076j.C1820a;

@SuppressLint({"ViewConstructor"})
public class CustomWaterMarkOperationView extends BaseOperationView<C6089b> {
    /* access modifiers changed from: private */
    public PlayerFakeView cGY;
    /* access modifiers changed from: private */
    public View cJK;
    /* access modifiers changed from: private */
    public View cJL;
    /* access modifiers changed from: private */
    public View cJM;
    /* access modifiers changed from: private */
    public View cJN;
    /* access modifiers changed from: private */
    public View cJO;
    private View cJP;
    private SeekBar cJQ;
    private SeekBar cJR;
    /* access modifiers changed from: private */
    public TextView cJS;
    /* access modifiers changed from: private */
    public TextView cJT;
    /* access modifiers changed from: private */
    public TextView cJU;
    private C9136a cJV;
    private C6096h cJW;
    private C5858a cJX = new C5858a() {
        public void aeW() {
            CustomWaterMarkOperationView.this.cGY.adl();
            CustomWaterMarkOperationView.this.aka();
            if (!C8072q.aBx().mo33072ku(C7825a.USER_WATER_MARK.getId())) {
                C6091d.ajW().mo28829a(null);
            }
            CustomWaterMarkOperationView.this.akc();
            CustomWaterMarkOperationView.this.finish();
        }

        public void aeX() {
            if (!C8049f.aBf().aBr() || C8072q.aBx().mo33072ku(C7825a.USER_WATER_MARK.getId())) {
                CustomWaterMarkOperationView.this.akc();
                if (CustomWaterMarkOperationView.this.cGY != null && CustomWaterMarkOperationView.this.cGY.getScaleRotateView() != null && CustomWaterMarkOperationView.this.cGY.getScaleRotateView().getScaleViewState() != null) {
                    if (CustomWaterMarkOperationView.this.cGY.getScaleRotateView().getVisibility() != 0 || TextUtils.isEmpty(CustomWaterMarkOperationView.this.cGY.getScaleRotateView().getScaleViewState().mStylePath)) {
                        C10021c.aZH().mo38492aA(new C6090c(true));
                        C1495b o = C1820a.aVi().mo10058o(new Runnable() {
                            public void run() {
                                C6091d.ajW().mo28829a(null);
                                if (((C6089b) CustomWaterMarkOperationView.this.getEditor()).adM() != null) {
                                    C6092e.m17361hn(C6092e.m17362ho(((C6089b) CustomWaterMarkOperationView.this.getEditor()).adM().mProjectDataItem.strPrjURL));
                                }
                                C6092e.ajZ();
                            }
                        });
                        if (CustomWaterMarkOperationView.this.compositeDisposable != null) {
                            CustomWaterMarkOperationView.this.compositeDisposable.mo9785e(o);
                        }
                        CustomWaterMarkOperationView.this.finish();
                        return;
                    }
                    final C6096h hVar = new C6096h(CustomWaterMarkOperationView.this.cGY.getScaleRotateView().getScaleViewState(), ((C6089b) CustomWaterMarkOperationView.this.getEditor()).getStreamSize(), ((C6089b) CustomWaterMarkOperationView.this.getEditor()).getSurfaceSize());
                    C10021c.aZH().mo38492aA(new C6090c(hVar));
                    if (C6091d.ajW().ajX() == null || !hVar.equals(C6091d.ajW().ajX())) {
                        C1495b o2 = C1820a.aVi().mo10058o(new Runnable() {
                            public void run() {
                                C6091d.ajW().mo28829a(hVar);
                                if (((C6089b) CustomWaterMarkOperationView.this.getEditor()).adM() != null) {
                                    C6092e.m17357a(C6092e.m17362ho(((C6089b) CustomWaterMarkOperationView.this.getEditor()).adM().mProjectDataItem.strPrjURL), hVar);
                                }
                            }
                        });
                        if (CustomWaterMarkOperationView.this.compositeDisposable != null) {
                            CustomWaterMarkOperationView.this.compositeDisposable.mo9785e(o2);
                        }
                        CustomWaterMarkOperationView.this.cGY.adl();
                        CustomWaterMarkOperationView.this.finish();
                        return;
                    }
                    CustomWaterMarkOperationView.this.cGY.adl();
                    CustomWaterMarkOperationView.this.finish();
                    return;
                }
                return;
            }
            C8049f.aBf().mo33097b(CustomWaterMarkOperationView.this.getContext(), C8070o.aBw(), C7825a.USER_WATER_MARK.getId(), "customize_watermark", IapRTConstants.REQUEST_CODE_FOR_VIP);
        }
    };
    private C6189a cJY = new C6189a() {
        /* renamed from: mH */
        public void mo28772mH(int i) {
            if (CustomWaterMarkOperationView.this.cGY != null && CustomWaterMarkOperationView.this.cGY.getScaleRotateView() != null) {
                String str = "";
                int i2 = 2;
                int i3 = 0;
                switch (i) {
                    case 0:
                        str = "up";
                        i2 = -2;
                        break;
                    case 1:
                        str = TtmlNode.LEFT;
                        i2 = 0;
                        i3 = -2;
                        break;
                    case 2:
                        str = TtmlNode.RIGHT;
                        i2 = 0;
                        i3 = 2;
                        break;
                    case 3:
                        str = "down";
                        break;
                    default:
                        i2 = 0;
                        break;
                }
                C6088a.m17348bi(VivaBaseApplication.m8749FZ(), str);
                CustomWaterMarkOperationView.this.cGY.getScaleRotateView().mo31001E(3, i3, i2);
            }
        }
    };
    private C6095g cJZ = new C6095g() {
        /* renamed from: m */
        public void mo28815m(int i, String str) {
            if (CustomWaterMarkOperationView.this.cGY != null) {
                C6088a.m17349bj(VivaBaseApplication.m8749FZ(), str);
                CustomWaterMarkOperationView.this.cGY.mo28363mi(i);
            }
        }
    };
    private OnSeekBarChangeListener cKa = new OnSeekBarChangeListener() {
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z && CustomWaterMarkOperationView.this.cGY != null && CustomWaterMarkOperationView.this.cGY.getScaleRotateView() != null) {
                CustomWaterMarkOperationView.this.cGY.getScaleRotateView().mo31002L(((float) i) / ((float) seekBar.getMax()), 0.016666668f);
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            C6088a.m17351eL(VivaBaseApplication.m8749FZ());
        }
    };
    private OnSeekBarChangeListener cKb = new OnSeekBarChangeListener() {
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z && CustomWaterMarkOperationView.this.cGY != null && CustomWaterMarkOperationView.this.cGY.getScaleRotateView() != null) {
                CustomWaterMarkOperationView.this.cGY.getScaleRotateView().mo31014qi((int) ((((float) seekBar.getMax()) * 0.1f) + (((float) i) * 0.9f)));
            }
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
            C6088a.m17352eM(VivaBaseApplication.m8749FZ());
        }
    };
    public final int cKc = IapRTConstants.REQUEST_CODE_FOR_VIP;
    /* access modifiers changed from: private */
    public C1494a compositeDisposable;
    private C4576e czL;

    /* renamed from: po */
    private OnClickListener f3497po = new OnClickListener() {
        public void onClick(View view) {
            if (view.equals(CustomWaterMarkOperationView.this.cJK)) {
                CustomWaterMarkOperationView.this.cJN.setVisibility(0);
                CustomWaterMarkOperationView.this.cJO.setVisibility(8);
                CustomWaterMarkOperationView.this.cJK.setBackgroundColor(CustomWaterMarkOperationView.this.getResources().getColor(R.color.white_p10));
                CustomWaterMarkOperationView.this.cJL.setBackgroundColor(CustomWaterMarkOperationView.this.getResources().getColor(R.color.transparent));
                CustomWaterMarkOperationView.this.cJT.setTextColor(CustomWaterMarkOperationView.this.getResources().getColor(R.color.white));
                CustomWaterMarkOperationView.this.cJU.setTextColor(CustomWaterMarkOperationView.this.getResources().getColor(R.color.white_p50));
            } else if (view.equals(CustomWaterMarkOperationView.this.cJL)) {
                CustomWaterMarkOperationView.this.cJN.setVisibility(8);
                CustomWaterMarkOperationView.this.cJO.setVisibility(0);
                CustomWaterMarkOperationView.this.cJK.setBackgroundColor(CustomWaterMarkOperationView.this.getResources().getColor(R.color.transparent));
                CustomWaterMarkOperationView.this.cJL.setBackgroundColor(CustomWaterMarkOperationView.this.getResources().getColor(R.color.white_p10));
                CustomWaterMarkOperationView.this.cJT.setTextColor(CustomWaterMarkOperationView.this.getResources().getColor(R.color.white_p50));
                CustomWaterMarkOperationView.this.cJU.setTextColor(CustomWaterMarkOperationView.this.getResources().getColor(R.color.white));
            } else if (view.equals(CustomWaterMarkOperationView.this.cJM) || view.equals(CustomWaterMarkOperationView.this.cJS)) {
                if (view.equals(CustomWaterMarkOperationView.this.cJS)) {
                    C6088a.m17350eK(VivaBaseApplication.m8749FZ());
                }
                CustomWaterMarkOperationView.this.akc();
                EditorRouter.launchLocalFileAlbumActivity(CustomWaterMarkOperationView.this.getContext(), 2);
            }
        }
    };

    public CustomWaterMarkOperationView(Activity activity) {
        super(activity, C6089b.class);
    }

    /* renamed from: Oj */
    private void m17316Oj() {
        this.cJK = findViewById(R.id.watermark_basic);
        this.cJL = findViewById(R.id.watermark_position);
        this.cJN = findViewById(R.id.watermark_basic_content);
        this.cJO = findViewById(R.id.watermark_position_content);
        this.cJM = findViewById(R.id.replace_watermark);
        Terminator terminator = (Terminator) findViewById(R.id.terminator);
        PixelMoveControlView pixelMoveControlView = (PixelMoveControlView) findViewById(R.id.pixel_move);
        CustomWaterMarkQuickPositionView customWaterMarkQuickPositionView = (CustomWaterMarkQuickPositionView) findViewById(R.id.quick_position);
        this.cJQ = (SeekBar) findViewById(R.id.watermark_size_degree);
        this.cJR = (SeekBar) findViewById(R.id.watermark_alpha_degree);
        this.cJP = findViewById(R.id.empty_layout);
        this.cJS = (TextView) findViewById(R.id.add_watermark);
        this.cJT = (TextView) findViewById(R.id.basic_tv);
        this.cJU = (TextView) findViewById(R.id.pos_tv);
        this.cJK.setOnClickListener(this.f3497po);
        this.cJL.setOnClickListener(this.f3497po);
        this.cJM.setOnClickListener(this.f3497po);
        terminator.setTerminatorListener(this.cJX);
        pixelMoveControlView.setOnLongMoveListener(this.cJY);
        customWaterMarkQuickPositionView.setWaterMarkQuickPositionListener(this.cJZ);
        this.cJQ.setOnSeekBarChangeListener(this.cKa);
        this.cJR.setOnSeekBarChangeListener(this.cKb);
        this.cJS.setOnClickListener(this.f3497po);
        terminator.setTitle(R.string.xiaoying_str_editor_custom_watermark);
        if (C6091d.ajW().ajX() == null) {
            this.cJP.setVisibility(0);
            return;
        }
        this.cJP.setVisibility(8);
        m17329k(C6091d.ajW().ajX().cKy);
    }

    private void ajU() {
        this.cGY = (PlayerFakeView) findViewById(R.id.watermark_player_faker_view);
        this.cGY.mo28354a(((C6089b) getEditor()).adN(), ((C6089b) getEditor()).getSurfaceSize(), true, 50);
        this.cGY.setScaleRotateViewDecoder(new C7065a());
        this.cGY.aiF();
        this.cGY.setOnDelListener(new C5889a() {
            public void aan() {
                CustomWaterMarkOperationView.this.cGY.adl();
            }
        });
        this.cGY.setOnMoveListener(new C5890b() {
            public void aiH() {
                C6088a.m17353eN(VivaBaseApplication.m8749FZ());
            }

            /* renamed from: b */
            public void mo28388b(RectF rectF, float f, int i) {
            }
        });
    }

    /* access modifiers changed from: private */
    public void aka() {
        C6091d.ajW().mo28829a(this.cJW);
    }

    private void akb() {
        if (getActivity() != null && C5842b.ahl()) {
            C5842b.ahk();
            if (this.cJV == null) {
                this.cJV = new C9136a(getActivity());
            }
            this.cJV.mo36087f(this.cJM, 3, C4580b.m11666qi());
            this.cJV.mo36086dt(getResources().getString(R.string.xiaoying_str_editor_replace_watermark));
            this.cJV.show();
        }
    }

    /* access modifiers changed from: private */
    public void akc() {
        if (this.cJV != null && this.cJV.isShowing()) {
            this.cJV.aNX();
        }
    }

    private void akd() {
        if (!C8072q.aBx().mo33072ku(C7825a.USER_WATER_MARK.getId()) && !C4577f.m11630i(this.czL)) {
            this.czL = C4577f.m11623a(getContext(), (View) this, "customize_watermark", (int) IapRTConstants.REQUEST_CODE_FOR_VIP);
        }
    }

    /* renamed from: hp */
    private void m17325hp(String str) {
        if (C6091d.ajW().ajX() != null) {
            StylePositionModel stylePositionModel = this.cGY.getScaleRotateView().getScaleViewState().mPosInfo;
            ScaleRotateViewState c = ((C6089b) getEditor()).mo28801c(str, this.cGY.getScaleRotateView().getScaleViewState());
            if (!(c == null || c.mPosInfo == null)) {
                StylePositionModel stylePositionModel2 = c.mPosInfo;
                if (!(stylePositionModel2.getmHeight() == 0.0f || stylePositionModel2.getmWidth() == 0.0f)) {
                    float f = stylePositionModel2.getmWidth() / stylePositionModel2.getmHeight();
                    float f2 = stylePositionModel.getmWidth() * stylePositionModel.getmHeight();
                    float sqrt = (float) Math.sqrt((double) (f * f2));
                    float sqrt2 = (float) Math.sqrt((double) (f2 / f));
                    stylePositionModel.setmWidth(sqrt);
                    stylePositionModel.setmHeight(sqrt2);
                }
            }
            if (c != null) {
                c.mPosInfo = stylePositionModel;
            }
            this.cGY.setSimpleMode(true);
            this.cGY.mo28360d(c);
            this.cGY.getScaleRotateView().mo31014qi((int) ((((float) this.cJR.getMax()) * 0.1f) + (((float) this.cJR.getProgress()) * 0.9f)));
            C6088a.m17354eO(VivaBaseApplication.m8749FZ());
            return;
        }
        mo28810hj(str);
    }

    /* renamed from: k */
    private void m17329k(ScaleRotateViewState scaleRotateViewState) {
        if (scaleRotateViewState != null) {
            this.cJR.setProgress((int) (((scaleRotateViewState.mAlpha * ((float) this.cJR.getMax())) - (((float) this.cJR.getMax()) * 0.1f)) / 0.9f));
            float f = scaleRotateViewState.mPosInfo.getmWidth() * scaleRotateViewState.mPosInfo.getmHeight();
            float f2 = (float) (((C6089b) getEditor()).getSurfaceSize().width * ((C6089b) getEditor()).getSurfaceSize().height);
            if (f2 != 0.0f) {
                float f3 = 0.016666668f * f2;
                this.cJQ.setProgress((int) (((f - f3) / (f2 - f3)) * ((float) this.cJQ.getMax())));
            }
        }
    }

    public void aex() {
        super.aex();
        if (getEditor() == null) {
            finish();
            return;
        }
        this.compositeDisposable = new C1494a();
        C10021c.aZH().mo38494ax(this);
        m17316Oj();
        ajU();
        this.cJW = C6091d.ajW().ajX();
        C7149c.m21148hY(false);
    }

    public boolean aey() {
        return true;
    }

    public void aez() {
        if (getEditor() != null) {
            if (!(C6091d.ajW().ajX() == null || C6091d.ajW().ajX().cKy == null)) {
                ScaleRotateViewState scaleRotateViewState = C6091d.ajW().ajX().cKy;
                this.cGY.setSimpleMode(true);
                this.cGY.mo28360d(scaleRotateViewState);
                C10021c.aZH().mo38492aA(new C6090c(true));
                if (this.cGY.getScaleRotateView() != null) {
                    this.cGY.getScaleRotateView().mo31014qi((int) (scaleRotateViewState.mAlpha * 255.0f));
                }
            }
            super.aez();
        }
    }

    /* access modifiers changed from: protected */
    public void finish() {
        super.finish();
        C7149c.m21148hY(true);
    }

    public int getLayoutId() {
        return R.layout.editor_effect_watermark_layout;
    }

    /* renamed from: hj */
    public void mo28810hj(String str) {
        if (!TextUtils.isEmpty(str) && this.cGY != null && this.cGY.getScaleRotateView() != null) {
            akb();
            ScaleRotateViewState d = ((C6089b) getEditor()).mo28802d(str, this.cGY.getScaleRotateView().getScaleViewState());
            d.mPosInfo = C6094f.m17366a(d, ((C6089b) getEditor()).getSurfaceSize());
            this.cGY.setSimpleMode(true);
            this.cGY.mo28360d(d);
            this.cGY.getScaleRotateView().mo31014qi((int) ((((float) this.cJR.getMax()) * 0.1f) + (((float) this.cJR.getProgress()) * 0.9f)));
            C6091d.ajW().mo28829a(new C6096h(d, ((C6089b) getEditor()).getStreamSize(), ((C6089b) getEditor()).getSurfaceSize()));
        }
    }

    public void onActivityDestroy() {
        C10021c.aZH().mo38496az(this);
        if (this.compositeDisposable != null) {
            this.compositeDisposable.clear();
        }
        super.onActivityDestroy();
        C4577f.m11629e(this.czL);
    }

    public void onActivityResume() {
        super.onActivityResume();
        akd();
    }

    public boolean onBackPressed() {
        if (this.cGY != null) {
            this.cGY.adl();
            if (!C8072q.aBx().mo33072ku(C7825a.USER_WATER_MARK.getId())) {
                C6091d.ajW().mo28829a(null);
            }
        }
        aka();
        finish();
        return true;
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onFileChooseEvent(C7134a aVar) {
        this.cJP.setVisibility(8);
        m17325hp(aVar.getFilePath());
    }
}
