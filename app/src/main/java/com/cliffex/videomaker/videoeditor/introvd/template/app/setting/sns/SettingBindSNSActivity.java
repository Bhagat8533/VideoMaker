package com.introvd.template.app.setting.sns;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.database.ContentObserver;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.p021v4.content.LocalBroadcastManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import com.afollestad.materialdialogs.C1885b;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1904j;
import com.introvd.template.EventActivity;
import com.introvd.template.R;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.p203b.C4586g;
import com.introvd.template.p203b.C4600l;
import com.introvd.template.p374q.C8358i;
import com.introvd.template.p414ui.dialog.C8978m;
import com.introvd.template.router.user.SnsAuthServiceProxy;
import com.introvd.template.router.user.model.SnsAuthTransData.Builder;
import com.introvd.template.sns.SnsConst;
import com.introvd.template.sns.SnsResItem;
import com.introvd.template.sns.SnsShareManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class SettingBindSNSActivity extends EventActivity implements OnSharedPreferenceChangeListener, OnClickListener {
    private int bBg;
    private C4341a bDA = new C4341a(this);
    private ArrayList<SnsResItem> bDB;
    private ListView bDx;
    /* access modifiers changed from: private */
    public C4344a bDy;
    private C4343b bDz;
    private BroadcastReceiver bfy;
    private LocalBroadcastManager bfz;
    private ImageView bvn;

    /* renamed from: com.introvd.template.app.setting.sns.SettingBindSNSActivity$a */
    private static class C4341a extends Handler {
        private WeakReference<SettingBindSNSActivity> bwg;

        public C4341a(SettingBindSNSActivity settingBindSNSActivity) {
            this.bwg = new WeakReference<>(settingBindSNSActivity);
        }

        public void handleMessage(Message message) {
            SettingBindSNSActivity settingBindSNSActivity = (SettingBindSNSActivity) this.bwg.get();
            if (settingBindSNSActivity != null && message.what == 101 && !settingBindSNSActivity.isFinishing()) {
                C4586g.m11706a(settingBindSNSActivity, false, Integer.valueOf(-1), Integer.valueOf(R.string.xiaoying_str_com_follow_official_weibo), Integer.valueOf(R.string.xiaoying_str_com_yes), Integer.valueOf(R.string.xiaoying_str_com_no), new OnClickListener() {
                    public void onClick(View view) {
                        C4586g.m11697Sn();
                    }
                });
            }
        }
    }

    /* renamed from: com.introvd.template.app.setting.sns.SettingBindSNSActivity$b */
    private class C4343b extends ContentObserver {
        public C4343b(Handler handler) {
            super(handler);
        }

        public void onChange(boolean z) {
            LogUtils.m14221d("SettingBindSNSActivity", "Sns table ContentObserver received notification");
            if (SettingBindSNSActivity.this.bDy != null) {
                SettingBindSNSActivity.this.bDy.notifyDataSetChanged();
            }
        }
    }

    /* renamed from: Gn */
    private void m10873Gn() {
        ContentResolver contentResolver = getContentResolver();
        if (this.bDz != null) {
            contentResolver.unregisterContentObserver(this.bDz);
        }
    }

    private void registerObserver() {
        getContentResolver().registerContentObserver(SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_SNS), true, this.bDz);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        SnsAuthServiceProxy.authorizeCallBack(this, this.bBg, i, i2, intent);
    }

    public void onClick(View view) {
        if (view.equals(this.bvn)) {
            finish();
            overridePendingTransition(R.anim.activity_slide_in_from_left, R.anim.activity_slide_out_to_right);
        } else {
            final int intValue = ((Integer) view.getTag()).intValue();
            if (!SnsAuthServiceProxy.isAuthed(intValue)) {
                this.bBg = intValue;
                if ((1 != this.bBg || SnsShareManager.isSnsSDKAndApkInstalled(this, 1, true)) && C4600l.m11739k(this, true)) {
                    SnsAuthServiceProxy.auth(this, new Builder().snsType(this.bBg));
                }
            } else {
                SnsResItem itemBySnsId = SnsConst.getInstance().getItemBySnsId(intValue);
                if (itemBySnsId != null && !isFinishing()) {
                    String string = getResources().getString(itemBySnsId.mTitleResId);
                    String string2 = getResources().getString(R.string.xiaoying_str_community_sns_unbind);
                    C8978m.m26349hs(this).mo10312q(string2).mo10315r(getResources().getString(R.string.xiaoying_str_community_dialog_unregister_ask, new Object[]{string})).mo10303dv(R.string.xiaoying_str_com_cancel).mo10299dr(R.string.xiaoying_str_com_ok).mo10281a((C1904j) new C1904j() {
                        public void onClick(C1890f fVar, C1885b bVar) {
                            SnsAuthServiceProxy.unAuth(SettingBindSNSActivity.this, intValue);
                            C8358i.m24108cs(SettingBindSNSActivity.this, String.valueOf(intValue));
                            SettingBindSNSActivity.this.bDy.notifyDataSetChanged();
                        }
                    }).mo10313qu().show();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.v4_setting_bind_sns);
        this.bDA = new C4341a(this);
        this.bDz = new C4343b(this.bDA);
        this.bvn = (ImageView) findViewById(R.id.img_back);
        this.bvn.setOnClickListener(this);
        this.bDx = (ListView) findViewById(R.id.setting_bind_sns_list);
        this.bDB = SnsConst.getInstance().getSnsItemList(SnsConst.BIND_IDS);
        this.bDy = new C4344a(this, this.bDB, this);
        this.bDx.setAdapter(this.bDy);
        registerObserver();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.bDy = null;
        m10873Gn();
        if (this.bfz != null) {
            this.bfz.unregisterReceiver(this.bfy);
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        if (this.bDA != null) {
            this.bDA.removeMessages(101);
        }
        overridePendingTransition(R.anim.activity_slide_in_from_left, R.anim.activity_slide_out_to_right);
        super.onPause();
        UserBehaviorLog.onPause(this);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        UserBehaviorLog.onResume(this);
        this.bDy.notifyDataSetChanged();
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
    }
}
