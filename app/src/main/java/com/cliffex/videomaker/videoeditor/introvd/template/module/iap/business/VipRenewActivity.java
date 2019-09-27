package com.introvd.template.module.iap.business;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.p021v4.content.ContextCompat;
import android.support.p021v4.widget.NestedScrollView;
import android.support.p021v4.widget.NestedScrollView.OnScrollChangeListener;
import android.support.p024v7.widget.LinearLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager.BadTokenException;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.aiii.android.arouter.p091c.C1919a;
import com.introvd.template.apicore.C3635l;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.module.iap.C8049f;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.iap.R;
import com.introvd.template.module.iap.business.coupon.C7846a;
import com.introvd.template.module.iap.business.coupon.C7853c;
import com.introvd.template.module.iap.business.coupon.C7853c.C7856a;
import com.introvd.template.module.iap.business.coupon.C7858e;
import com.introvd.template.module.iap.business.coupon.C7858e.C7864a;
import com.introvd.template.module.iap.business.dialog.C7889b;
import com.introvd.template.module.iap.business.dialog.C7889b.C7891a;
import com.introvd.template.module.iap.business.exchange.C7916c;
import com.introvd.template.module.iap.business.exchange.C7916c.C7920a;
import com.introvd.template.module.iap.business.exchange.C7922d;
import com.introvd.template.module.iap.business.home.C7958a;
import com.introvd.template.module.iap.business.p349a.C7832c;
import com.introvd.template.module.iap.business.p349a.p351b.C7830c;
import com.introvd.template.module.iap.business.p352b.C7834a;
import com.introvd.template.module.iap.business.p352b.C7835b;
import com.introvd.template.module.iap.business.p355d.C7874a;
import com.introvd.template.module.iap.business.p356e.C7897a;
import com.introvd.template.module.iap.business.p356e.C7898b;
import com.introvd.template.module.iap.business.vip.p360a.C8025g;
import com.introvd.template.module.iap.p341b.C7738c;
import com.introvd.template.module.iap.p341b.p343b.C7733a;
import com.introvd.template.module.iap.p341b.p343b.C7735c;
import com.introvd.template.module.iap.p341b.p343b.C7737e;
import com.introvd.template.module.iap.utils.C8078b;
import com.introvd.template.module.iap.utils.C8083g;
import com.introvd.template.module.p338b.C7686a;
import com.introvd.template.module.p339c.C7689a;
import com.introvd.template.router.AdRouter;
import com.introvd.template.router.AdRouter.VipHomeParams;
import com.introvd.template.router.common.ICommonFuncRouter;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.introvd.template.router.todoCode.TodoConstants;
import com.introvd.template.router.user.UserServiceProxy;
import com.introvd.template.router.user.model.LoginUserInfo;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;
import com.yan.rippledrawable.RippleLayout;
import java.util.HashMap;
import java.util.List;
import org.greenrobot.eventbus.C10021c;
import org.greenrobot.eventbus.C10031j;
import org.greenrobot.eventbus.ThreadMode;

@C1942a(mo10417rZ = "/XYVIP/VipRenew/entry")
public class VipRenewActivity extends Activity {
    private boolean bBv = false;
    private final OnClickListener bTD = new OnClickListener() {
        public void onClick(View view) {
            if (view.getId() == R.id.tv_subscribe) {
                view.setSelected(!view.isSelected());
                String aBU = VipRenewActivity.this.dPt.aBU();
                VipRenewActivity.this.dPD.mo32844r(aBU, view.isSelected());
                VipRenewActivity.this.dPI.mo32683q(aBU, true);
            } else if (view.getId() == R.id.btn_pay) {
                VipRenewActivity.this.m22779kI(VipRenewActivity.this.dPt.aBV());
            }
        }
    };
    /* access modifiers changed from: private */
    public C7853c dPA = new C7853c(null, new C7856a() {
        /* renamed from: a */
        public void mo32672a(C7846a aVar) {
            String str;
            String aBV = VipRenewActivity.this.dPt.aBV();
            TextView b = VipRenewActivity.this.dPx;
            if (aVar == null) {
                str = VipRenewActivity.this.getString(R.string.xiaoying_str_iap_coupon_not_chosen);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(aVar.name);
                sb.append(aVar.aCc());
                str = sb.toString();
            }
            b.setText(str);
            VipRenewActivity.this.dPD.mo32845s(aBV, aVar != null);
            VipRenewActivity.this.m22780kJ(aBV);
        }
    });
    /* access modifiers changed from: private */
    public C7889b dPB;
    private String dPC;
    /* access modifiers changed from: private */
    public C7894e dPD = new C7894e();
    /* access modifiers changed from: private */
    public C7819a dPE;
    private boolean dPF = false;
    private boolean dPG = false;
    private C7874a dPH = new C7874a();
    /* access modifiers changed from: private */
    public C7946a dPI = new C7946a() {
        /* renamed from: q */
        public void mo32683q(String str, boolean z) {
            VipRenewActivity.this.dPw.setVisibility((!C7958a.m23118lx(str) || !VipRenewActivity.this.dPD.mo32840kR(str)) ? 8 : 0);
            VipRenewActivity.this.aBF();
            VipRenewActivity.this.dPy.setSelected(VipRenewActivity.this.dPD.mo32839kQ(str));
            String kO = VipRenewActivity.this.dPD.mo32837kO(str);
            VipRenewActivity.this.dPD.mo32845s(kO, true);
            VipRenewActivity.this.m22778kH(kO);
            VipRenewActivity.this.dPz.setText(VipRenewActivity.this.dPD.mo32833k(VipRenewActivity.this.getApplicationContext(), str, VipRenewActivity.this.dPy.isSelected()));
            VipRenewActivity.this.m22780kJ(kO);
            VipRenewActivity.this.dPE.m22794c(VipRenewActivity.this.dPD.mo32843kV(str));
            if (z) {
                C7832c cVar = (C7832c) C7738c.aEv().aNw().mo35913ri(str);
                if (cVar != null) {
                    HashMap hashMap = new HashMap();
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(" + ");
                    sb.append(cVar.mo32756sp());
                    hashMap.put("selected", sb.toString());
                    if (VipRenewActivity.this.dPw.getVisibility() == 0) {
                        hashMap.put("subscription", VipRenewActivity.this.findViewById(R.id.tv_subscribe).isSelected() ? "选中" : "取消");
                    } else {
                        hashMap.put("subscription", null);
                    }
                    C8048e.aBe().mo23653g("Domestic_VIP_MembershipPage_switch", hashMap);
                }
            }
        }
    };
    /* access modifiers changed from: private */
    public boolean dPr = true;
    /* access modifiers changed from: private */
    public C7928f dPs;
    /* access modifiers changed from: private */
    public C7944h dPt;
    private boolean dPu = true;
    private boolean dPv = false;
    /* access modifiers changed from: private */
    public View dPw;
    /* access modifiers changed from: private */
    public TextView dPx = null;
    /* access modifiers changed from: private */
    public TextView dPy;
    /* access modifiers changed from: private */
    public TextView dPz = null;
    private boolean isPaused = false;
    private boolean isVip = false;

    /* renamed from: com.introvd.template.module.iap.business.VipRenewActivity$a */
    private class C7819a implements OnClickListener {
        private View dPR;
        private View dPS;
        private final boolean dPT;

        private C7819a() {
            this.dPR = VipRenewActivity.this.findViewById(R.id.ll_wechat_pay_container);
            this.dPS = VipRenewActivity.this.findViewById(R.id.ll_alipay_pay_container);
            this.dPT = C8048e.aBe().mo23628Mt();
            VipRenewActivity.this.findViewById(R.id.ll_pay_ways_container).setVisibility(this.dPT ? 8 : 0);
            if (!this.dPT) {
                C8083g.init();
                VipRenewActivity.this.m22761a((ViewGroup) VipRenewActivity.this.findViewById(R.id.ll_alipay_tag_container), C8083g.m23457mb("alipay"));
                VipRenewActivity.this.m22761a((ViewGroup) VipRenewActivity.this.findViewById(R.id.ll_wechat_tag_container), C8083g.m23457mb("wx"));
                this.dPR.setOnClickListener(this);
                this.dPS.setOnClickListener(this);
                this.dPR.setSelected(true);
            }
        }

        /* access modifiers changed from: private */
        public int aBQ() {
            if (this.dPT) {
                return 2;
            }
            return this.dPR.isSelected() ? 5 : 6;
        }

        /* access modifiers changed from: private */
        /* renamed from: c */
        public void m22794c(boolean[] zArr) {
            if (!this.dPT && zArr != null) {
                this.dPR.setVisibility(zArr[0] ? 0 : 4);
                this.dPS.setVisibility((!zArr[1] || C8048e.aBe().mo23615MG()) ? 4 : 0);
                if (this.dPS.getVisibility() == 4 && this.dPS.isSelected()) {
                    this.dPR.setSelected(true);
                    this.dPS.setSelected(false);
                }
            }
        }

        public void onClick(View view) {
            boolean z = view.getId() == R.id.ll_wechat_pay_container;
            this.dPR.setSelected(z);
            this.dPS.setSelected(!z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: PA */
    public void m22758PA() {
        this.dPF = true;
        this.isVip = C8072q.aBx().isVip();
        this.bBv = !TextUtils.isEmpty(UserServiceProxy.getUserId());
        C8048e.aBe().mo23642b(this, true);
        C7897a.aDf();
        if (C7738c.aEv().aNw().isEmpty()) {
            C7738c.aEv().aNu().aNr();
        }
        C7738c.aEv().aNu().aNs();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22761a(ViewGroup viewGroup, List<String> list) {
        if (list != null && !list.isEmpty()) {
            for (String str : list) {
                TextView textView = new TextView(this);
                textView.setBackgroundResource(R.drawable.iap_vip_shape_pay_ways_tag);
                textView.setTextSize(1, 12.0f);
                textView.setText(str);
                int ii = C7689a.m22599ii(1);
                int i = ii * 6;
                int i2 = ii * 2;
                textView.setPadding(i, i2, i, i2);
                textView.setTextColor(ContextCompat.getColor(this, R.color.color_ff4e18));
                textView.setLines(1);
                viewGroup.addView(textView);
            }
        }
    }

    private void aBD() {
        ((AppBarLayout) findViewById(R.id.appbar)).setExpanded(UserServiceProxy.isLogin(), false);
    }

    private void aBE() {
        TextView textView = (TextView) findViewById(R.id.tv_feedback);
        SpannableString spannableString = new SpannableString(getString(R.string.iap_vip_renew_help_feedback));
        spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 33);
        textView.setText(spannableString);
        textView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C8048e.aBe().mo23637a((Activity) VipRenewActivity.this, C8048e.aBe().mo23647dD("https://hybrid.xiaoying.tv/web/vivaVideo/TermsPrivacy.html"), VipRenewActivity.this.getResources().getString(R.string.xiaoying_str_vip_subscription_desc));
            }
        });
        TextView textView2 = (TextView) findViewById(R.id.tv_privacy_policy);
        SpannableString spannableString2 = new SpannableString(getString(R.string.iap_vip_renew_privacy_policy));
        spannableString2.setSpan(new UnderlineSpan(), 0, textView2.length(), 33);
        textView2.setText(spannableString2);
        textView2.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C8048e.aBe().mo23637a((Activity) VipRenewActivity.this, C8048e.aBe().mo23647dD("http://hybrid.xiaoying.tv/web/vivaVideo/index/TermsCN.html"), VipRenewActivity.this.getResources().getString(R.string.iap_vip_renew_privacy_policy));
            }
        });
        findViewById(R.id.tv_helper).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C8048e.aBe().mo23651e(VipRenewActivity.this, 101);
            }
        });
        findViewById(R.id.iv_back).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                VipRenewActivity.this.onBackPressed();
            }
        });
        this.dPw = findViewById(R.id.ll_vip_subscribe_container);
        findViewById(R.id.iv_subscribe_help).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                ToastUtils.longShow(VipRenewActivity.this.getApplicationContext(), VipRenewActivity.this.getString(R.string.xiaoying_str_continuous_subscribe_notice));
            }
        });
        this.dPz = (TextView) findViewById(R.id.tv_label_subscribe_notice);
        this.dPy = (TextView) findViewById(R.id.tv_subscribe);
        this.dPy.setOnClickListener(this.bTD);
        this.dPE = new C7819a();
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.fl_operator_banner_container);
        if (!C8048e.aBe().isYoungerMode()) {
            View h = C8048e.aBe().mo23657h(viewGroup, 360);
            if (h != null) {
                viewGroup.removeAllViews();
                viewGroup.addView(h);
                viewGroup.setVisibility(0);
            }
        } else {
            viewGroup.setVisibility(8);
        }
        findViewById(R.id.btn_pay).setOnClickListener(this.bTD);
        if (C7686a.aAO() && findViewById(R.id.fl_iqy_enter) == null) {
            ((ViewStub) findViewById(R.id.vs_iqy_enter)).inflate();
            final ImageView imageView = (ImageView) findViewById(R.id.fl_iqy_enter);
            imageView.post(new Runnable() {
                public void run() {
                    Drawable drawable = ContextCompat.getDrawable(VipRenewActivity.this.getBaseContext(), R.drawable.iap_vip_img_banner_member);
                    if (drawable != null) {
                        imageView.getLayoutParams().height = (imageView.getMeasuredWidth() * drawable.getIntrinsicHeight()) / drawable.getIntrinsicWidth();
                    }
                    imageView.setImageDrawable(RippleLayout.m27639C(drawable));
                }
            });
            imageView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    ICommonFuncRouter iCommonFuncRouter = (ICommonFuncRouter) C1919a.m5529sc().mo10356i(ICommonFuncRouter.class);
                    TODOParamModel tODOParamModel = new TODOParamModel();
                    tODOParamModel.mTODOCode = TodoConstants.TODO_TYPE_OPEN_URL;
                    tODOParamModel.mJsonParam = "{\"url\": \"https://xiaoying.tv/h5/united_vip.html\", \"existParam\": \"1\", \"useHybrid\": \"1\"}";
                    iCommonFuncRouter.executeTodo(VipRenewActivity.this, tODOParamModel, null);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void aBF() {
        int i = 0;
        boolean z = this.dPw.getVisibility() == 0 && C7686a.aAM();
        this.dPz.setVisibility(z ? 0 : 8);
        View findViewById = findViewById(R.id.iv_subscribe_help);
        if (z) {
            i = 8;
        }
        findViewById.setVisibility(i);
    }

    private void aBG() {
        TextView textView = (TextView) findViewById(R.id.tv_user_name);
        final View findViewById = findViewById(R.id.ll_user_info);
        findViewById.post(new Runnable() {
            public void run() {
                LayoutParams layoutParams = (LayoutParams) findViewById.getLayoutParams();
                layoutParams.rightMargin = VipRenewActivity.this.findViewById(R.id.tv_vip_restore).getWidth();
                findViewById.setLayoutParams(layoutParams);
            }
        });
        DynamicLoadingImageView dynamicLoadingImageView = (DynamicLoadingImageView) findViewById(R.id.dynamic_loading_iv_user_portrait);
        dynamicLoadingImageView.setOval(true);
        C78145 r2 = new OnClickListener() {
            public void onClick(View view) {
                if (!UserServiceProxy.isLogin()) {
                    VipRenewActivity.this.aBO();
                }
            }
        };
        dynamicLoadingImageView.setOnClickListener(r2);
        textView.setOnClickListener(r2);
        dynamicLoadingImageView.setImage(R.drawable.iap_vip_icon_default_avatar);
        dynamicLoadingImageView.setPlaceholderImage(R.drawable.iap_vip_icon_default_avatar);
        LoginUserInfo userInfo = UserServiceProxy.getUserInfo();
        if (userInfo != null) {
            if (!TextUtils.isEmpty(userInfo.avatarUrl)) {
                dynamicLoadingImageView.setImageURI(userInfo.avatarUrl);
            }
            textView.setText(userInfo.nickname);
            aBH();
            TextView textView2 = (TextView) findViewById(R.id.tv_user_vip_status);
            SpannableString aBI = aBI();
            if (TextUtils.isEmpty(aBI)) {
                textView2.setVisibility(8);
            } else {
                textView2.setText(aBI);
                textView2.setVisibility(0);
            }
            View findViewById2 = findViewById(R.id.tv_vip_restore);
            findViewById2.setVisibility(0);
            findViewById2.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (!C8048e.aBe().mo23644bB(true)) {
                        ToastUtils.show((Context) VipRenewActivity.this, R.string.xiaoying_str_com_msg_network_inactive, 1);
                        return;
                    }
                    if (!UserServiceProxy.isLogin()) {
                        VipRenewActivity.this.aBO();
                    }
                    VipRenewActivity.this.m22758PA();
                }
            });
        }
    }

    private void aBH() {
        ImageView imageView = (ImageView) findViewById(R.id.iv_user_vip_flag);
        if (imageView != null) {
            if (C8072q.aBx().isVip()) {
                imageView.setImageResource(R.drawable.iap_vip_icon_user_vip_flag_enable);
            } else {
                imageView.setImageResource(R.drawable.iap_vip_icon_user_vip_flag_disable);
            }
            if (this.dPs != null) {
                this.dPs.aBS();
            }
        }
    }

    private SpannableString aBI() {
        int aBC = C7833b.aBC();
        if (!C7833b.m22830sj(aBC)) {
            return C7833b.m22831sk(aBC) ? new SpannableString(getString(R.string.iap_vip_renew_out_of_date)) : new SpannableString(getString(R.string.xiaoying_str_vip_no_vip));
        }
        return new SpannableString(getString(R.string.xiaoying_str_iap_valid_until_time, new Object[]{C7833b.aBB()}));
    }

    private void aBJ() {
        aBK();
        if (C7916c.aCW().aCY()) {
            C7916c.aCW().mo32876a((C7920a) new C7920a() {
                /* renamed from: a */
                public void mo32574a(C7922d dVar) {
                    VipRenewActivity.this.aBK();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void aBK() {
        findViewById(R.id.tv_exchange_by_code).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (UserServiceProxy.isLogin()) {
                    AdRouter.launchVipExchange(VipRenewActivity.this);
                } else {
                    VipRenewActivity.this.aBO();
                }
            }
        });
    }

    private void aBL() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_purchase_item_group);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, 0, false));
        this.dPt = new C7944h(this, this.dPD, this.dPI);
        List wS = C7738c.aEv().aNw().mo35914wS();
        if (wS != null && !wS.isEmpty()) {
            this.dPD.update();
            this.dPt.update(this.dPC);
        }
        recyclerView.setAdapter(this.dPt);
        if (recyclerView.getItemDecorationCount() > 0) {
            recyclerView.mo7774ce(0);
        }
        C8049f.aBf().aBg();
    }

    private void aBM() {
        if (this.dPs == null) {
            this.dPs = C7942g.m23082h(getWindow().getDecorView(), R.id.rv_privilege, R.id.tv_icon_title, R.id.vs_iqy_enter_top, R.id.vs_iqy_enter_bottom);
        }
        aBN();
    }

    private void aBN() {
        C8048e.aBe().mo23643b(new C3635l<List<C7830c>>() {
            public void onError(String str) {
                super.onError(str);
            }

            public void onSuccess(List<C7830c> list) {
                if (VipRenewActivity.this.dPs != null && list.size() > 0) {
                    VipRenewActivity.this.dPs.mo32891ch(list);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void aBO() {
        C8048e.aBe().mo23621Mm();
    }

    private void aBP() {
        C7858e.m22915a(new C7864a() {
            /* renamed from: iD */
            public void mo32659iD(boolean z) {
                if (VipRenewActivity.this.dPt != null) {
                    String aBV = VipRenewActivity.this.dPt.aBV();
                    VipRenewActivity.this.m22780kJ(aBV);
                    VipRenewActivity.this.m22778kH(aBV);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    @SuppressLint({"SetTextI18n"})
    /* renamed from: kH */
    public void m22778kH(String str) {
        if (this.dPx == null) {
            this.dPx = (TextView) findViewById(R.id.tv_notice_coupon);
            this.dPx.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (!UserServiceProxy.isLogin()) {
                        VipRenewActivity.this.aBO();
                        return;
                    }
                    String aBV = VipRenewActivity.this.dPt.aBV();
                    C7846a kX = C7858e.m22921kX(aBV);
                    if (kX != null) {
                        VipRenewActivity.this.dPA.mo32782a(kX, VipRenewActivity.this.dPD.mo32842kU(aBV));
                        if (VipRenewActivity.this.dPB == null) {
                            VipRenewActivity.this.dPB = new C7891a(VipRenewActivity.this).mo32827a(VipRenewActivity.this.dPA).aCs();
                        }
                        VipRenewActivity.this.dPB.show();
                    }
                }
            });
        }
        C7846a kX = C7858e.m22921kX(str);
        if (kX == null) {
            this.dPx.setText(UserServiceProxy.isLogin() ? R.string.xiaoying_str_vip_no_coupons : R.string.xiaoying_str_sign_in_view_coupons);
            return;
        }
        TextView textView = this.dPx;
        StringBuilder sb = new StringBuilder();
        sb.append(kX.name);
        sb.append(kX.aCc());
        textView.setText(sb.toString());
    }

    /* access modifiers changed from: private */
    /* renamed from: kI */
    public void m22779kI(String str) {
        m22786p(str, true);
    }

    /* access modifiers changed from: private */
    /* renamed from: kJ */
    public void m22780kJ(String str) {
        this.dPt.mo32907t(str, this.dPy.isSelected());
        C7832c cVar = (C7832c) C7738c.aEv().aNw().mo35913ri(str);
        if (cVar != null) {
            this.dPy.setText(this.dPD.mo32834kL(str));
            TextView textView = (TextView) findViewById(R.id.tv_goods_description);
            textView.setText(cVar.getDescription());
            textView.setVisibility(TextUtils.isEmpty(cVar.getDescription()) ? 8 : 0);
            C7846a kW = C7858e.m22920kW(str);
            ((Button) findViewById(R.id.btn_pay)).setText(getString(R.string.xiaoying_str_pay_yuan_immediately, new Object[]{(kW == null || !this.dPD.mo32842kU(str)) ? C8078b.m23442j((double) cVar.aCE()) : kW.mo32772aK(cVar.aCE())}));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: p */
    public void m22786p(String str, boolean z) {
        if (str != null) {
            if (!z || !mo32661kK(str)) {
                int a = this.dPE.aBQ();
                StringBuilder sb = new StringBuilder();
                sb.append("=== id: ");
                sb.append(str);
                LogUtils.m14222e("doPay", sb.toString());
                this.dPv = C8072q.aBx().isVip();
                C7846a kW = C7858e.m22920kW(str);
                boolean kU = this.dPD.mo32842kU(str);
                C7738c.aEv().mo32611a(this, str, (!kU || kW == null) ? null : kW.code, a, null);
            }
        }
    }

    /* access modifiers changed from: 0000 */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x004d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004e  */
    /* renamed from: kK */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo32661kK(java.lang.String r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            boolean r2 = r17.isFinishing()
            r3 = 0
            if (r2 == 0) goto L_0x000c
            return r3
        L_0x000c:
            com.introvd.template.module.iap.g r2 = com.introvd.template.module.iap.C8048e.aBe()
            boolean r2 = r2.isInChina()
            if (r2 != 0) goto L_0x0017
            return r3
        L_0x0017:
            java.lang.String r2 = com.introvd.template.module.iap.business.home.C7958a.C7959a.dTk
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x0020
            return r3
        L_0x0020:
            com.introvd.template.module.iap.b.c r2 = com.introvd.template.module.iap.p341b.C7738c.aEv()
            com.introvd.template.vivaiap.warehouse.d r2 = r2.aNw()
            java.lang.String r4 = com.introvd.template.module.iap.business.home.C7958a.C7959a.dTk
            com.introvd.template.vivaiap.base.a.a r2 = r2.mo35913ri(r4)
            com.introvd.template.module.iap.business.a.c r2 = (com.introvd.template.module.iap.business.p349a.C7832c) r2
            if (r2 != 0) goto L_0x0033
            return r3
        L_0x0033:
            int r4 = com.introvd.template.module.p338b.C7686a.aAU()
            r5 = 2
            r6 = 1
            if (r4 != r6) goto L_0x003f
            java.lang.String r4 = com.introvd.template.module.iap.business.home.C7958a.C7960b.dTk
        L_0x003d:
            r7 = 0
            goto L_0x0047
        L_0x003f:
            if (r4 != r5) goto L_0x0045
            java.lang.String r4 = com.introvd.template.module.iap.business.home.C7958a.C7959a.dTm
            r7 = 1
            goto L_0x0047
        L_0x0045:
            r4 = 0
            goto L_0x003d
        L_0x0047:
            boolean r8 = android.text.TextUtils.isEmpty(r4)
            if (r8 == 0) goto L_0x004e
            return r3
        L_0x004e:
            com.introvd.template.module.iap.b.c r8 = com.introvd.template.module.iap.p341b.C7738c.aEv()
            com.introvd.template.vivaiap.warehouse.d r8 = r8.aNw()
            com.introvd.template.vivaiap.base.a.a r8 = r8.mo35913ri(r4)
            com.introvd.template.module.iap.business.a.c r8 = (com.introvd.template.module.iap.business.p349a.C7832c) r8
            if (r8 != 0) goto L_0x005f
            return r3
        L_0x005f:
            r9 = 4636737291354636288(0x4059000000000000, double:100.0)
            if (r7 == 0) goto L_0x0078
            long r11 = r2.aCE()
            double r11 = (double) r11
            long r13 = r8.aCE()
            double r13 = (double) r13
            r15 = 4622945017495814144(0x4028000000000000, double:12.0)
            double r13 = r13 / r15
            double r11 = r11 - r13
            double r11 = r11 / r9
            double r9 = java.lang.Math.ceil(r11)
            int r2 = (int) r9
            goto L_0x0088
        L_0x0078:
            long r11 = r2.aCE()
            long r13 = r8.aCE()
            long r11 = r11 - r13
            double r11 = (double) r11
            double r11 = r11 / r9
            double r9 = java.lang.Math.ceil(r11)
            int r2 = (int) r9
        L_0x0088:
            if (r2 > 0) goto L_0x008b
            return r3
        L_0x008b:
            int r7 = com.introvd.template.module.iap.R.string.xiaoying_str_iap_domestic_intercept_tip
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.String r8 = r8.getName()
            r5[r3] = r8
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r5[r6] = r2
            java.lang.String r2 = r0.getString(r7, r5)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r1)
            java.lang.String r7 = ","
            r5.append(r7)
            r5.append(r4)
            java.lang.String r5 = r5.toString()
            java.lang.String r7 = "cancel"
            java.lang.String[] r7 = new java.lang.String[]{r7}
            com.afollestad.materialdialogs.f$a r8 = new com.afollestad.materialdialogs.f$a
            r8.<init>(r0)
            com.afollestad.materialdialogs.f$a r2 = r8.mo10315r(r2)
            int r8 = com.introvd.template.module.iap.R.string.xiaoying_str_iap_domestic_want_discount
            com.afollestad.materialdialogs.f$a r2 = r2.mo10299dr(r8)
            com.introvd.template.module.iap.business.VipRenewActivity$15 r8 = new com.introvd.template.module.iap.business.VipRenewActivity$15
            r8.<init>(r4, r7)
            com.afollestad.materialdialogs.f$a r2 = r2.mo10281a(r8)
            int r4 = com.introvd.template.module.iap.R.string.xiaoying_str_continue_to_pay
            com.afollestad.materialdialogs.f$a r2 = r2.mo10303dv(r4)
            com.introvd.template.module.iap.business.VipRenewActivity$14 r4 = new com.introvd.template.module.iap.business.VipRenewActivity$14
            r4.<init>(r1, r7)
            com.afollestad.materialdialogs.f$a r1 = r2.mo10291b(r4)
            com.introvd.template.module.iap.business.VipRenewActivity$13 r2 = new com.introvd.template.module.iap.business.VipRenewActivity$13
            r2.<init>(r7, r5)
            com.afollestad.materialdialogs.f$a r1 = r1.mo10276a(r2)
            com.afollestad.materialdialogs.f r1 = r1.mo10313qu()
            r1.show()     // Catch:{ BadTokenException -> 0x00f1 }
            r3 = 1
        L_0x00f1:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.module.iap.business.VipRenewActivity.mo32661kK(java.lang.String):boolean");
    }

    public void onBackPressed() {
        if (!this.dPH.mo32794aM(this)) {
            super.onBackPressed();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C7897a.m23022b("会员页", C7898b.dSX, new String[0]);
        setContentView(R.layout.iap_vip_act_renew);
        this.dPC = getIntent().getStringExtra(VipHomeParams.VIP_RENEW_DEFAULT_GOODS_ID);
        this.dPG = getIntent().getBooleanExtra(VipHomeParams.VIP_IS_WAITING_FOR_RESULT, false);
        C10021c.aZH().mo38494ax(this);
        aBE();
        aBG();
        aBL();
        aBM();
        aBD();
        C8048e.aBe().mo23653g("Subscription_RenewNow_Enter", new HashMap());
        final NestedScrollView nestedScrollView = (NestedScrollView) findViewById(R.id.ns_iap_container);
        nestedScrollView.setOnScrollChangeListener(new OnScrollChangeListener() {
            public void onScrollChange(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
                if (VipRenewActivity.this.dPr && nestedScrollView != null) {
                    VipRenewActivity.this.dPr = false;
                    nestedScrollView.scrollTo(i3, i4);
                }
            }
        });
        C7897a.m23022b("会员页", C7898b.dSX, new String[0]);
        aBP();
        C7834a.aCL();
        this.dPH.aDe();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (this.dPG) {
            AdRouter.sendVipRenewPayResult(this);
        }
        C10021c.aZH().mo38496az(this);
        C7897a.m23026f("Iap_Domestic_Todo_Code", new String[0]);
        this.dPH.destroy();
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onEventMainThread(C7735c cVar) {
        String str;
        if (cVar != null) {
            aBG();
            if (this.dPt != null) {
                this.dPt.notifyDataSetChanged();
            }
            int responseCode = cVar.getResponseCode();
            C8048e.aBe().mo23623Mo();
            if (responseCode == 1) {
                setResult(-1);
                str = getString(R.string.xiaoying_str_vip_restore_purchases_suc);
            } else if (responseCode == 0) {
                str = getString(R.string.iap_vip_restore_empty_vip_info);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(getString(R.string.xiaoying_str_com_restore_purchases));
                sb.append(getString(R.string.xiaoying_str_com_task_state_fail));
                str = sb.toString();
            }
            C7835b.m22844a("VIP page", this.isVip, responseCode);
            if (this.bBv) {
                C7835b.m22852b("VIP page", this.isVip, responseCode);
            }
            if (this.dPu && this.dPF) {
                ToastUtils.show((Context) this, str, 0);
                this.dPF = false;
            }
        }
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onGoodsReload(C7733a aVar) {
        if (aVar != null && this.dPt != null) {
            this.dPD.update();
            this.dPt.update(this.dPC);
        }
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        StringBuilder sb = new StringBuilder();
        sb.append("  ");
        sb.append(intent);
        LogUtils.m14222e("onNewIntent", sb.toString());
        ((NestedScrollView) findViewById(R.id.ns_iap_container)).scrollTo(0, 0);
        aBD();
        if (intent != null) {
            String stringExtra = intent.getStringExtra(VipHomeParams.VIP_RENEW_DEFAULT_GOODS_ID);
            if (!TextUtils.isEmpty(stringExtra) && this.dPt != null) {
                C7944h hVar = this.dPt;
                this.dPC = stringExtra;
                hVar.update(stringExtra);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.dPu = false;
        this.isPaused = true;
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onPurchaseResult(C7737e eVar) {
        if (eVar != null) {
            if (this.dPG) {
                if (eVar.isSuccess()) {
                    ToastUtils.show((Context) this, R.string.xiaoying_str_iap_domestic_purchase_success, 0);
                } else {
                    ToastUtils.show((Context) this, R.string.xiaoying_str_iap_domestic_purchase_fail, 0);
                }
                finish();
            } else if (eVar.isSuccess()) {
                if (this.dPv) {
                    ToastUtils.show((Context) this, R.string.xiaoying_str_iap_domestic_purchase_success, 0);
                } else {
                    try {
                        new C8025g(this).show();
                    } catch (BadTokenException e) {
                        C8048e.aBe().logException(e);
                    }
                }
                aBG();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        C8049f.aBf().aBh();
        aBP();
        this.dPt.notifyDataSetChanged();
        this.dPu = true;
        if (this.isPaused) {
            aBG();
            this.isPaused = false;
        }
        aBJ();
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onSignQueryResult(C7995j jVar) {
        if (this.dPG) {
            finish();
        }
    }
}
