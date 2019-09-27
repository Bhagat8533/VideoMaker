package com.introvd.template.app.welcomepage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.Editable;
import android.text.Html;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.afollestad.materialdialogs.C1885b;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1895a;
import com.afollestad.materialdialogs.C1890f.C1904j;
import com.aiii.android.arouter.facade.C1941a;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.firebase.analytics.FirebaseAnalytics.Event;
import com.introvd.template.C3569a;
import com.introvd.template.C4681i;
import com.introvd.template.EventActivity;
import com.introvd.template.R;
import com.introvd.template.app.AppListener;
import com.introvd.template.app.ApplicationBase;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.app.p190j.C4023a;
import com.introvd.template.app.welcomepage.snsview.SnsLoginListView;
import com.introvd.template.app.welcomepage.snsview.SnsLoginMidEastView;
import com.introvd.template.app.welcomepage.snsview.SnsLoginMidEastView.C4526a;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.SnsConfigMgr;
import com.introvd.template.common.SnsConfigMgr.SnsItemInfo;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.ViewClickEffectMgr;
import com.introvd.template.common.behavior.UserBehaviorUtils;
import com.introvd.template.common.behavior.UserBehaviorUtilsV5;
import com.introvd.template.common.behavior.UserBehaviorUtilsV7;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.common.p236ui.video.XYSimpleVideoView;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4598j;
import com.introvd.template.p203b.C4600l;
import com.introvd.template.p203b.C4606p;
import com.introvd.template.p242d.C5527a;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.IMRouter;
import com.introvd.template.router.VivaRouter;
import com.introvd.template.router.app.IAppService;
import com.introvd.template.router.community.ICommunityAPI;
import com.introvd.template.router.user.IUserService;
import com.introvd.template.router.user.LoginUserBehaviorUtils;
import com.introvd.template.router.user.UserRouter.AccountInfoEditorParams;
import com.introvd.template.sns.login.coupling.LoginCouplingConstant;
import com.introvd.template.sns.login.coupling.SnsLoginResultEvent;
import com.introvd.template.starvlogs.logfirebase.ActionFirebaseStarVlogs;
import com.p131c.p132a.C2561a;
import com.p131c.p132a.p135c.p136a.C2579b;
import com.p131c.p132a.p135c.p136a.C2579b.C2582a;
import com.videoeditor.intromaker.introview.FillTextSplash;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.greenrobot.eventbus.C10021c;
import org.greenrobot.eventbus.C10031j;
import org.greenrobot.eventbus.ThreadMode;
import p037b.p050b.p076j.C1820a;

public class WelcomeV6Activity extends EventActivity implements OnClickListener {
    /* access modifiers changed from: private */
    public boolean bIA;
    private boolean bIB = false;
    private C4503a bIC;
    private List<SnsItemInfo> bID;
    private TextView bIE;
    private ImageView bIF;
    private ImageView bIG;
    private ImageView bIH;
    private ImageView bII;
    private LinearLayout bIJ;
    private TextView bIK;
    private TextView bIL;
    private int bIM;
    private int bIN = 1;
    private IUserService bIO;
    /* access modifiers changed from: private */
    public C4502a bIu;
    private SnsLoginListView bIv;
    private View bIw;
    private SnsLoginMidEastView bIx;
    /* access modifiers changed from: private */
    public TextView bIy;
    private View bIz;
    /* access modifiers changed from: private */
    public int mType;
    private long uniqueRequestId = System.currentTimeMillis();

    /* renamed from: com.introvd.template.app.welcomepage.WelcomeV6Activity$a */
    private static class C4502a extends Handler {
        private WeakReference<WelcomeV6Activity> bwg;

        public C4502a(WelcomeV6Activity welcomeV6Activity) {
            this.bwg = new WeakReference<>(welcomeV6Activity);
        }

        public void handleMessage(Message message) {
            WelcomeV6Activity welcomeV6Activity = (WelcomeV6Activity) this.bwg.get();
            if (welcomeV6Activity != null && !welcomeV6Activity.isFinishing()) {
                boolean z = false;
                switch (message.what) {
                    case 4103:
                        if (C2561a.aOR() != 1) {
                            welcomeV6Activity.mType = 3;
                        } else if (AppStateModel.getInstance().isInChina()) {
                            welcomeV6Activity.mType = 4;
                        } else {
                            if (C3742b.m9111II().isCommunityCloseSoon() && AppStateModel.getInstance().isCommunityCloseSoon()) {
                                z = true;
                            }
                            if (z) {
                                welcomeV6Activity.mType = 3;
                            } else if (!AppStateModel.getInstance().isCommunitySupport()) {
                                welcomeV6Activity.mType = 3;
                            } else if (C3742b.m9111II().mo23152JT()) {
                                welcomeV6Activity.mType = 5;
                            } else {
                                welcomeV6Activity.mType = 2;
                            }
                        }
                        welcomeV6Activity.m11400ib(welcomeV6Activity.mType);
                        break;
                    case 4104:
                        welcomeV6Activity.bIy.setVisibility(0);
                        break;
                }
            }
        }
    }

    /* renamed from: HQ */
    private void m11382HQ() {
        m11387Rw();
        this.bIK.setText(mo24700Rv());
        if (!C10021c.aZH().mo38495ay(this)) {
            C10021c.aZH().mo38494ax(this);
        }
    }

    /* renamed from: Nu */
    private void m11383Nu() {
        this.bIE.setOnClickListener(this);
        this.bIK.setOnClickListener(this);
        this.bIx.setSnsItemClick(new C4526a() {
            /* renamed from: id */
            public void mo24718id(int i) {
                WelcomeV6Activity.this.m11399i(i, null);
            }
        });
        C2579b.m7399a(new C2582a<View>() {
            public void onClick(View view) {
                UserBehaviorUtilsV5.onEventHomeSlide(WelcomeV6Activity.this.getApplicationContext(), "skip", "skip");
                WelcomeV6Activity.this.m11389Ry();
                WelcomeV6Activity.this.finish();
            }
        }, this.bIy);
    }

    /* renamed from: Oj */
    private void m11384Oj() {
        this.bIv = (SnsLoginListView) findViewById(R.id.sns_login_list_view);
        this.bIz = findViewById(R.id.wel_layout_tools);
        this.bIF = (ImageView) findViewById(R.id.wel_vivavideo_text_english);
        this.bIG = (ImageView) findViewById(R.id.wel_vivavideo_text_china);
        this.bIH = (ImageView) findViewById(R.id.wel_logo_img_english);
        this.bII = (ImageView) findViewById(R.id.wel_logo_img_china);
        this.bIL = (TextView) findViewById(R.id.wel_logo_text_english);
        this.bIy = (TextView) findViewById(R.id.wel_skip);
        this.bIw = findViewById(R.id.layout_wel_phone_cn);
        this.bIx = (SnsLoginMidEastView) findViewById(R.id.sns_login_mideast_view);
        m11386Ru();
        this.bIE = (TextView) findViewById(R.id.wel_tools_start);
        this.bIJ = (LinearLayout) findViewById(R.id.tools_protocol_layout);
        this.bIK = (TextView) findViewById(R.id.tools_text_terms_and_privacy);
        this.bIC = new C4503a((XYSimpleVideoView) findViewById(R.id.wel_videoview));
    }

    /* access modifiers changed from: private */
    /* renamed from: Rt */
    public void m11385Rt() {
        final long currentTimeMillis = System.currentTimeMillis();
        C1820a.aVi().mo10058o(new Runnable() {
            public void run() {
                while (System.currentTimeMillis() - currentTimeMillis < DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS && !ApplicationBase.bip) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (!ApplicationBase.bip) {
                    ApplicationBase.bin = true;
                }
                WelcomeV6Activity.this.bIA = true ^ AppStateModel.getInstance().isInChina();
                WelcomeV6Activity.this.bIu.sendEmptyMessage(4103);
            }
        });
    }

    /* renamed from: Ru */
    private void m11386Ru() {
        String countryCode = AppStateModel.getInstance().getCountryCode();
        int i = 0;
        if (AppStateModel.getInstance().isInChina()) {
            this.bID = new ArrayList();
            SnsItemInfo snsItemInfo = new SnsItemInfo();
            snsItemInfo.mSnsCode = 46;
            snsItemInfo.mCountryCode = countryCode;
            this.bID.add(snsItemInfo);
            SnsItemInfo snsItemInfo2 = new SnsItemInfo();
            snsItemInfo2.mSnsCode = 1;
            snsItemInfo2.mCountryCode = countryCode;
            this.bID.add(snsItemInfo2);
            SnsItemInfo snsItemInfo3 = new SnsItemInfo();
            snsItemInfo3.mSnsCode = 7;
            snsItemInfo3.mCountryCode = countryCode;
            this.bID.add(snsItemInfo3);
            SnsItemInfo snsItemInfo4 = new SnsItemInfo();
            snsItemInfo4.mSnsCode = 10;
            snsItemInfo4.mCountryCode = countryCode;
            this.bID.add(snsItemInfo4);
            SnsItemInfo snsItemInfo5 = new SnsItemInfo();
            snsItemInfo5.mSnsCode = 48;
            snsItemInfo5.mCountryCode = countryCode;
            this.bID.add(snsItemInfo5);
        } else {
            this.bID = SnsConfigMgr.getSnsConfigItemList(this, countryCode, "2");
            if (this.bID == null || this.bID.isEmpty()) {
                this.bID = SnsConfigMgr.getDefaultSnsConfigItemList();
            }
            if (!AppStateModel.getInstance().canLoginGoogle(this)) {
                int size = this.bID.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        break;
                    } else if (((SnsItemInfo) this.bID.get(i2)).mSnsCode == 25) {
                        this.bID.remove(i2);
                        break;
                    } else {
                        i2++;
                    }
                }
            }
        }
        if (!C4580b.m11650dw(this)) {
            int size2 = this.bID.size();
            while (true) {
                if (i >= size2) {
                    break;
                } else if (((SnsItemInfo) this.bID.get(i)).mSnsCode == 46) {
                    this.bID.remove(i);
                    break;
                } else {
                    i++;
                }
            }
        }
        if (this.bID.size() == 1) {
            this.bIB = true;
        }
    }

    /* renamed from: Rw */
    private void m11387Rw() {
        if (C4598j.m11730SA()) {
            this.bIG.setVisibility(0);
            this.bIF.setVisibility(8);
            this.bIH.setVisibility(8);
            this.bII.setVisibility(0);
            this.bIL.setVisibility(8);
            return;
        }
        this.bIG.setVisibility(8);
        this.bIF.setVisibility(0);
        this.bIH.setVisibility(0);
        this.bII.setVisibility(8);
        this.bIL.setVisibility(0);
    }

    /* renamed from: Rx */
    private void m11388Rx() {
        TextView textView = (TextView) findViewById(R.id.text_terms_and_privacy);
        textView.setText(Html.fromHtml(getString(R.string.xiaoying_str_community_login_read_agree, new Object[]{getString(R.string.xiaoying_str_community_setting_about_privacy_terms)})));
        textView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                IAppService iAppService = (IAppService) BizServiceManager.getService(IAppService.class);
                if (iAppService != null) {
                    iAppService.showPrivacyTerms(WelcomeV6Activity.this, 0);
                }
            }
        });
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ll_wel_login_phone_china);
        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.ll_login_phone_style);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rl_login_shanyan);
        TextView textView2 = (TextView) findViewById(R.id.tv_login_phone_message);
        View findViewById = findViewById(R.id.btn_login_wechat);
        View findViewById2 = findViewById(R.id.btn_login_qq);
        View findViewById3 = findViewById(R.id.btn_login_weibo);
        View findViewById4 = findViewById(R.id.btn_login_huawei);
        findViewById4.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                WelcomeV6Activity.this.m11399i(46, null);
            }
        });
        findViewById.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                WelcomeV6Activity.this.m11399i(7, null);
            }
        });
        findViewById2.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                WelcomeV6Activity.this.m11399i(10, null);
            }
        });
        findViewById3.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                WelcomeV6Activity.this.m11399i(1, null);
            }
        });
        relativeLayout.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                WelcomeV6Activity.this.m11399i(52, null);
            }
        });
        textView2.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                WelcomeV6Activity.this.m11399i(48, null);
            }
        });
        final EditText editText = (EditText) findViewById(R.id.et_phone_input);
        final View findViewById5 = findViewById(R.id.tv_phone_next);
        ViewClickEffectMgr.addEffectForViews(WelcomeV6Activity.class.getSimpleName(), findViewById5);
        editText.setFilters(new InputFilter[]{new LengthFilter(15)});
        if (VERSION.SDK_INT >= 21) {
            editText.addTextChangedListener(new PhoneNumberFormattingTextWatcher(AppStateModel.COUNTRY_CODE_China));
        } else {
            editText.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
        }
        editText.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                findViewById5.setEnabled(charSequence.length() > 0);
            }
        });
        findViewById5.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (editText.getText() != null) {
                    String replaceAll = editText.getText().toString().replaceAll(" ", "").replaceAll("-", "");
                    if (C4606p.m11748eL(replaceAll)) {
                        WelcomeV6Activity.this.m11399i(48, replaceAll);
                    } else {
                        ToastUtils.shortShow((Context) WelcomeV6Activity.this, R.string.xiaoying_str_verify_phone_page_result_error_phonenum);
                    }
                }
            }
        });
        findViewById4.setVisibility(C4580b.m11650dw(this) ? 0 : 8);
        ICommunityAPI iCommunityAPI = (ICommunityAPI) BizServiceManager.getService(ICommunityAPI.class);
        if (iCommunityAPI == null || !iCommunityAPI.getChinaPhoneLogin()) {
            linearLayout2.setVisibility(8);
            linearLayout.setVisibility(0);
            return;
        }
        linearLayout2.setVisibility(0);
        linearLayout.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: Ry */
    public void m11389Ry() {
        boolean booleanExtra = getIntent().getBooleanExtra("isFirstTime", false);
        if (getIntent().getBooleanExtra("isUpgrade", false) || booleanExtra) {
            HashMap hashMap = new HashMap();
            hashMap.put(C5527a.cnJ, Boolean.valueOf(false));
            AppListener.gotoHomePageActivity(this, hashMap);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m11399i(int i, String str) {
        if (!C4600l.m11739k(this, true)) {
            ToastUtils.show((Context) this, R.string.xiaoying_str_com_msg_network_inactive, 1);
            return;
        }
        this.bIM = i;
        this.uniqueRequestId = System.currentTimeMillis();
        if (this.bIO != null) {
            this.bIO.startSnsLogin(this, this.uniqueRequestId, -1, i, false, LoginUserBehaviorUtils.LOGIN_POSITION_WELCOME, str);
        }
        UserBehaviorUtils.recordUserLoginPosition(this, LoginUserBehaviorUtils.LOGIN_POSITION_WELCOME);
        String behaviorSnsName = UserBehaviorUtils.getBehaviorSnsName(i);
        Context applicationContext = getApplicationContext();
        boolean z = true ^ this.bIA;
        String str2 = LoginUserBehaviorUtils.LOGIN_POSITION_WELCOME;
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append("");
        UserBehaviorUtils.recordUserLoginEvent(applicationContext, z, behaviorSnsName, str2, sb.toString());
        UserBehaviorUtilsV5.onEventHomeSlide(this, Event.LOGIN, behaviorSnsName);
        if (AppStateModel.ZONE_MIDDLE_EAST.equals(AppStateModel.getInstance().getZoneCode())) {
            HashMap hashMap = new HashMap();
            hashMap.put("socialEnable", AppStateModel.getInstance().isCommunitySupport() ? "enable" : "disable");
            hashMap.put("country", AppStateModel.getInstance().getCountryCode());
            hashMap.put("zone", AppStateModel.getInstance().getZoneCode());
            hashMap.put("localeinfo", Locale.getDefault().toString());
            UserBehaviorLog.onKVEvent(getApplicationContext(), "Dev_Event_Login_Error", hashMap);
        }
        if (i == 31) {
            LoginCouplingConstant.mLoginPosition = 100;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: ib */
    public void m11400ib(int i) {
        this.bIN = C3742b.m9111II().mo23183cb(this);
        if (i == 2) {
            if (this.bIN <= 0) {
                this.bIy.setVisibility(8);
            } else {
                this.bIu.sendEmptyMessageDelayed(4104, (long) (this.bIN * 1000));
            }
            if (this.bIB) {
                this.bIv.setVisibility(8);
                this.bIz.setVisibility(0);
                this.bIJ.setVisibility(0);
                String string = getString(mo24701ic(((SnsItemInfo) this.bID.get(0)).mSnsCode));
                this.bIE.setText(getString(R.string.xiaoying_str_com_login_with, new Object[]{string}));
                this.bIE.setTag(Integer.valueOf(((SnsItemInfo) this.bID.get(0)).mSnsCode));
            } else if (this.bID != null && this.bID.size() != 0) {
                this.uniqueRequestId = System.currentTimeMillis();
                this.bIv.mo24730a(this, true, this.uniqueRequestId, -1, this.bID, "welcome", null, false);
                this.bIv.setVisibility(0);
                this.bIz.setVisibility(8);
            }
        } else if (i == 3) {
            this.bIy.setVisibility(8);
            this.bIv.setVisibility(8);
            this.bIz.setVisibility(0);
        } else if (i == 4) {
            if (this.bIN <= 0) {
                this.bIy.setVisibility(8);
            } else {
                this.bIu.sendEmptyMessageDelayed(4104, (long) (this.bIN * 1000));
            }
            this.bIG.setVisibility(8);
            this.bIF.setVisibility(8);
            this.bIH.setVisibility(8);
            this.bII.setVisibility(8);
            this.bIL.setVisibility(8);
            this.bIw.setVisibility(0);
            m11388Rx();
        } else if (i == 5) {
            if (this.bIN <= 0) {
                this.bIy.setVisibility(8);
            } else {
                this.bIu.sendEmptyMessageDelayed(4104, (long) (this.bIN * 1000));
            }
            this.bIv.setVisibility(8);
            this.bIz.setVisibility(8);
            this.bIx.setVisibility(0);
            this.bIx.setTestABMode(C4023a.m9973MK().getLoginPopUIStyle());
            UserBehaviorUtilsV7.eventPageviewOverseasLogin(this, LoginUserBehaviorUtils.LOGIN_POSITION_WELCOME, LoginUserBehaviorUtils.LOGIN_POSITION_WELCOME);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: Rv */
    public CharSequence mo24700Rv() {
        String string = getString(R.string.xiaoying_str_community_pre_terms_and_privacy);
        String string2 = getString(R.string.xiaoying_str_community_setting_about_privacy_terms);
        StringBuilder sb = new StringBuilder();
        sb.append(string);
        sb.append(" ");
        sb.append(string2);
        SpannableString spannableString = new SpannableString(sb.toString());
        spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.color_b7b7b7)), 0, string.length(), 18);
        return spannableString;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ic */
    public int mo24701ic(int i) {
        if (i == 28) {
            return R.string.xiaoying_str_com_intl_share_facebook;
        }
        if (i == 25) {
            return R.string.xiaoying_str_com_intl_share_google;
        }
        if (i == 31) {
            return R.string.xiaoying_str_com_intl_share_instagram;
        }
        if (i == 38) {
            return R.string.xiaoying_str_com_intl_share_line;
        }
        if (i == 3) {
            return R.string.xiaoying_str_login_telephone;
        }
        if (i == 29) {
            return R.string.xiaoying_str_com_intl_share_twitter;
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        StringBuilder sb = new StringBuilder();
        sb.append("onActivityResult <------------- requestCode: ");
        sb.append(i);
        LogUtilsV2.m14230i(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onActivityResult <------------- resultCode: ");
        sb2.append(i2);
        LogUtilsV2.m14230i(sb2.toString());
        if (200 == i && i2 == -1) {
            HashMap hashMap = new HashMap();
            hashMap.put(C5527a.cnJ, Boolean.valueOf(false));
            AppPreferencesSetting.getInstance().setAppSettingInt(C5527a.cnQ, 0);
            AppListener.gotoHomePageActivity(this, hashMap);
            finish();
        }
        if (this.bIO != null) {
            this.bIO.handleSnsLoginActivityResult(this, i, i2, intent);
        }
    }

    public void onBackPressed() {
    }

    public void onClick(View view) {
        if (!C4580b.m11664ig(1000)) {
            Object tag = view.getTag();
            int intValue = tag instanceof Integer ? ((Integer) tag).intValue() : -1;
            if (view.equals(this.bIE)) {
                if (this.mType != 2 || !this.bIB || intValue == -1) {
                    UserBehaviorUtilsV5.onEventHomeSlide(this, "skip", "skip");
                    m11389Ry();
                    finish();
                } else {
                    m11399i(intValue, null);
                }
            } else if (view.equals(this.bIK)) {
                IAppService iAppService = (IAppService) BizServiceManager.getService(IAppService.class);
                if (iAppService != null) {
                    iAppService.showPrivacyTerms(this, 0);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_welcome_v6);
        ActionFirebaseStarVlogs.actionWelcomeActivity(this);
        FillTextSplash.introFill(this);
        this.bIu = new C4502a(this);
        m11384Oj();
        m11382HQ();
        m11383Nu();
        this.bIO = (IUserService) C4681i.m12184Gp().getService(IUserService.class);
        if (this.bIO != null) {
            this.bIO.registerSnsLoginListener(this);
        }
        this.bIu.postDelayed(new Runnable() {
            public void run() {
                WelcomeV6Activity.this.m11385Rt();
            }
        }, 500);
        HashMap hashMap = new HashMap();
        hashMap.put("isNew", String.valueOf(C3569a.m8772FK()));
        UserBehaviorLog.onKVEvent(getApplicationContext(), "Home_Slide_Enter", hashMap);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        C10021c.aZH().mo38496az(this);
        super.onDestroy();
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onEventMainThread(SnsLoginResultEvent snsLoginResultEvent) {
        if (snsLoginResultEvent.state == 10) {
            HashMap hashMap = new HashMap();
            hashMap.put(C5527a.cnJ, Boolean.valueOf(false));
            AppPreferencesSetting.getInstance().setAppSettingInt(C5527a.cnQ, 0);
            AppListener.gotoHomePageActivity(this, hashMap);
            finish();
        } else if (snsLoginResultEvent.uniqueRequestId == this.uniqueRequestId) {
            if (snsLoginResultEvent.state == 2) {
                UserBehaviorUtils.recordUserLoginOpEvent(getApplicationContext(), LoginCouplingConstant.mLoginPosition, "cancel");
                LoginCouplingConstant.mLoginPosition = 100;
                IMRouter.initIMService(this);
                HashMap hashMap2 = new HashMap();
                hashMap2.put(C5527a.cnJ, Boolean.valueOf(false));
                AppListener.gotoHomePageActivity(this, hashMap2);
                finish();
            } else if (snsLoginResultEvent.state == 1) {
                if (this.bIM == 52) {
                    new C1895a(this).mo10296do(R.string.viva_comm_dialog_shanyan_error).mo10299dr(R.string.xiaoying_str_com_ok).mo10281a((C1904j) new C1904j() {
                        public void onClick(C1890f fVar, C1885b bVar) {
                            WelcomeV6Activity.this.m11399i(48, null);
                        }
                    }).mo10314qv();
                }
            } else if (snsLoginResultEvent.state == 0) {
                IMRouter.initIMService(this);
                if (snsLoginResultEvent.needModifyProfile) {
                    C1941a routerBuilder = VivaRouter.getRouterBuilder(AccountInfoEditorParams.URL);
                    if (snsLoginResultEvent.bundle != null) {
                        routerBuilder.mo10400g(snsLoginResultEvent.bundle);
                    }
                    routerBuilder.mo10406h(AccountInfoEditorParams.INTENT_EXTRA_KEY_MODE, 2);
                    routerBuilder.mo10396b((Activity) this, 200);
                } else {
                    HashMap hashMap3 = new HashMap();
                    hashMap3.put(C5527a.cnJ, Boolean.valueOf(false));
                    AppPreferencesSetting.getInstance().setAppSettingInt(C5527a.cnQ, 0);
                    AppListener.gotoHomePageActivity(this, hashMap3);
                    finish();
                }
            }
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i == 4 && LoginCouplingConstant.mLoginPosition != 100) {
            UserBehaviorUtils.recordUserLoginOpEvent(getApplicationContext(), LoginCouplingConstant.mLoginPosition, "cancel");
            LoginCouplingConstant.mLoginPosition = 100;
        }
        return super.onKeyUp(i, keyEvent);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        if (isFinishing()) {
            this.bIC.mo24721Ow();
        } else {
            this.bIC.pauseVideo();
        }
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.bIC != null) {
            this.bIC.mo24722RA();
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
    }
}
