package com.introvd.template.app.setting.sns;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.introvd.template.EventActivity;
import com.introvd.template.R;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.p203b.C4600l;
import com.introvd.template.router.user.SnsAuthListener;
import com.introvd.template.router.user.SnsAuthServiceProxy;
import com.introvd.template.router.user.model.SnsAuthTransData.Builder;
import com.introvd.template.sns.SnsResItem;
import com.introvd.template.sns.SnsType;
import com.ironsource.sdk.controller.BannerJSAdapter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SettingBindInternationalSnsActivity extends EventActivity implements OnClickListener {
    private int bBg = -1;
    private ListView bDk;
    private ImageView bDl;
    /* access modifiers changed from: private */
    public C4338a bDm;
    private List<SnsResItem> bDn;
    private List<SnsResItem> bDo;

    /* renamed from: com.introvd.template.app.setting.sns.SettingBindInternationalSnsActivity$a */
    private class C4338a extends ArrayAdapter<SnsResItem> {
        List<SnsResItem> bDq;
        OnClickListener bDr;
        Context context;
        int resourceId;

        /* renamed from: com.introvd.template.app.setting.sns.SettingBindInternationalSnsActivity$a$a */
        class C4339a {
            TextView alJ;
            RelativeLayout bDs;
            TextView bDt;
            public ImageView bDu;
            public ImageView bDv;

            /* renamed from: pc */
            ImageView f3398pc;

            C4339a() {
            }
        }

        public C4338a(Context context2, int i, List<SnsResItem> list, OnClickListener onClickListener) {
            super(context2, i, list);
            this.context = context2;
            this.resourceId = i;
            this.bDq = list;
            this.bDr = onClickListener;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            C4339a aVar;
            SnsResItem snsResItem = (SnsResItem) this.bDq.get(i);
            if (view == null) {
                view = LayoutInflater.from(this.context).inflate(this.resourceId, null);
                aVar = new C4339a();
                aVar.bDs = (RelativeLayout) view.findViewById(R.id.setting_bind_sns_list_item_layout_bg);
                aVar.alJ = (TextView) view.findViewById(R.id.setting_bind_sns_list_item_txt_title);
                aVar.f3398pc = (ImageView) view.findViewById(R.id.setting_bind_sns_list_item_icon);
                aVar.bDt = (TextView) view.findViewById(R.id.setting_bind_sns_list_item_btn_txt);
                aVar.bDu = (ImageView) view.findViewById(R.id.item_divider_top);
                aVar.bDv = (ImageView) view.findViewById(R.id.item_divider_bottom);
                view.setTag(aVar);
            } else {
                aVar = (C4339a) view.getTag();
            }
            aVar.bDu.setVisibility(4);
            LayoutParams layoutParams = (LayoutParams) aVar.bDv.getLayoutParams();
            boolean z = true;
            if (i != getCount() - 1) {
                z = false;
            }
            int i2 = 8;
            aVar.bDv.setVisibility(z ? 0 : 8);
            ImageView imageView = aVar.bDu;
            if (z) {
                i2 = 0;
            }
            imageView.setVisibility(i2);
            aVar.bDt.setText(snsResItem.mIconResId);
            boolean isAuthed = SnsAuthServiceProxy.isAuthed(snsResItem.mSnsType);
            aVar.bDt.setText(!isAuthed ? R.string.xiaoying_str_community_sns_bind : R.string.xiaoying_str_community_sns_unbind);
            aVar.bDt.setBackgroundResource(!isAuthed ? R.drawable.xiaoying_app_setting_sns_bind_btn_bg : R.drawable.drawable_color_transparent);
            int color = this.context.getResources().getColor(R.color.color_ff774e);
            int color2 = this.context.getResources().getColor(R.color.color_b7b7b7);
            TextView textView = aVar.bDt;
            if (isAuthed) {
                color = color2;
            }
            textView.setTextColor(color);
            aVar.f3398pc.setImageResource(snsResItem.mIconResId);
            aVar.f3398pc.setEnabled(isAuthed);
            aVar.bDt.setTag(Integer.valueOf(snsResItem.mSnsType));
            aVar.alJ.setText(snsResItem.mTitleResStr);
            aVar.bDs.setTag(Integer.valueOf(snsResItem.mSnsType));
            aVar.bDs.setOnClickListener(this.bDr);
            aVar.bDt.setOnClickListener(this.bDr);
            return view;
        }
    }

    /* renamed from: PI */
    public static List<SnsResItem> m10870PI() {
        SnsType[] values;
        ArrayList arrayList = new ArrayList();
        for (SnsType snsType : SnsType.values()) {
            if (snsType == SnsType.SNS_TYPE_INSTAGRAM) {
                arrayList.add(new SnsResItem(31, R.drawable.v4_xiaoying_sns_instagram_icon_selector, R.drawable.v4_xiaoying_sns_instagram_icon_selector, VivaBaseApplication.m8749FZ().getString(R.string.xiaoying_str_studio_sns_app_gallery, new Object[]{"Instagram"})));
            } else if (snsType == SnsType.SNS_TYPE_FACEBOOK) {
                arrayList.add(new SnsResItem(28, R.drawable.v4_xiaoying_sns_facebook_icon_selector, R.drawable.v4_xiaoying_sns_facebook_icon_selector, VivaBaseApplication.m8749FZ().getString(R.string.xiaoying_str_studio_sns_app_gallery, new Object[]{"Facebook"})));
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private List<SnsResItem> m10872a(int[] iArr, List<SnsResItem> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            for (int i2 : iArr) {
                SnsResItem snsResItem = (SnsResItem) list.get(i);
                if (snsResItem.mSnsType == i2) {
                    arrayList.add(snsResItem);
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        SnsAuthServiceProxy.authorizeCallBack(this, this.bBg, i, i2, intent);
        super.onActivityResult(i, i2, intent);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.img_back) {
            finish();
            overridePendingTransition(R.anim.activity_enter, R.anim.activity_exit);
        } else if (C4600l.m11739k(this, true)) {
            this.bBg = ((Integer) view.getTag()).intValue();
            if (!SnsAuthServiceProxy.isAuthed(this.bBg)) {
                HashMap hashMap = new HashMap();
                if (this.bBg == 28) {
                    hashMap.put("which", "facebook");
                } else if (this.bBg == 31) {
                    hashMap.put("which", "instagram");
                }
                UserBehaviorLog.onKVEvent(this, "Gallery_Online_login", hashMap);
                SnsAuthServiceProxy.auth(this, new Builder().snsType(this.bBg).snsAuthListener(new SnsAuthListener() {
                    public void onAuthCancel(int i) {
                        ToastUtils.show((Context) SettingBindInternationalSnsActivity.this, R.string.xiaoying_str_sns_gallery_longin_tip_cancel, 0);
                        HashMap hashMap = new HashMap();
                        hashMap.put("result", "cancel");
                        if (i == 28) {
                            UserBehaviorLog.onKVEvent(SettingBindInternationalSnsActivity.this, "Gallery_Blind_Facebook", hashMap);
                        } else if (i == 31) {
                            UserBehaviorLog.onKVEvent(SettingBindInternationalSnsActivity.this, "Gallery_Blind_Instagram", hashMap);
                        }
                    }

                    public void onAuthComplete(int i, Bundle bundle) {
                        SettingBindInternationalSnsActivity.this.bDm.notifyDataSetChanged();
                        HashMap hashMap = new HashMap();
                        hashMap.put("result", "success");
                        if (i == 28) {
                            UserBehaviorLog.onKVEvent(SettingBindInternationalSnsActivity.this, "Gallery_Blind_Facebook", hashMap);
                        } else if (i == 31) {
                            UserBehaviorLog.onKVEvent(SettingBindInternationalSnsActivity.this, "Gallery_Blind_Instagram", hashMap);
                        }
                        if (AppPreferencesSetting.getInstance().getAppSettingBoolean("key_show_online_album", true)) {
                            AppPreferencesSetting.getInstance().setAppSettingBoolean("key_show_online_album", false);
                        }
                    }

                    public void onAuthFail(int i, int i2, String str) {
                        ToastUtils.show((Context) SettingBindInternationalSnsActivity.this, R.string.xiaoying_str_sns_gallery_longin_tip_fail, 0);
                        HashMap hashMap = new HashMap();
                        hashMap.put("result", BannerJSAdapter.FAIL);
                        if (i == 28) {
                            UserBehaviorLog.onKVEvent(SettingBindInternationalSnsActivity.this, "Gallery_Blind_Facebook", hashMap);
                        } else if (i == 31) {
                            UserBehaviorLog.onKVEvent(SettingBindInternationalSnsActivity.this, "Gallery_Blind_Instagram", hashMap);
                        }
                    }
                }));
            } else if (this.bBg == 28) {
                SnsAuthServiceProxy.unAuth(this, this.bBg);
            } else if (this.bBg == 31) {
                SnsAuthServiceProxy.unAuth(this, this.bBg);
            }
            this.bDm.notifyDataSetChanged();
        } else {
            ToastUtils.show((Context) this, R.string.xiaoying_str_com_msg_network_inactive, 1);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_setting_bind_international_sns);
        this.bDk = (ListView) findViewById(R.id.setting_bind_sns_list);
        this.bDl = (ImageView) findViewById(R.id.img_back);
        this.bDl.setOnClickListener(this);
        this.bDo = m10870PI();
        this.bDn = m10872a(new int[]{31, 28}, this.bDo);
        C4338a aVar = new C4338a(this, R.layout.v4_setting_bind_sns_list_item, this.bDn, this);
        this.bDm = aVar;
        this.bDk.setAdapter(this.bDm);
    }
}
