package com.introvd.template.app.school.template.detail;

import android.app.Activity;
import android.content.Intent;
import android.databinding.C0171f;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.introvd.template.EventActivity;
import com.introvd.template.R;
import com.introvd.template.app.school.api.model.TemplateInfo;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.p236ui.custom.VideoAutoPlayHelper;
import com.introvd.template.p242d.C5527a;
import com.introvd.template.p310g.C7361c;
import com.introvd.template.xyui.feedrecycler.C9165a;
import com.introvd.template.xyui.feedrecycler.FeedRecylayoutManager;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import p037b.p050b.p051a.p053b.C1487a;

public class TemplateDetailAct extends EventActivity {
    private C7361c bza;
    private String bzb;
    private int bzc;
    private List<TemplateInfo> dataList;

    /* renamed from: On */
    private void m10562On() {
        C42192 r0 = new FeedRecylayoutManager(this, 1, false) {
            public boolean canScrollVertically() {
                return true;
            }
        };
        r0.mo36147a((C9165a) new C9165a() {
            /* renamed from: Op */
            public void mo24183Op() {
            }

            /* renamed from: f */
            public void mo24184f(boolean z, int i) {
                C4224a a = TemplateDetailAct.this.m10569hr(z ^ true ? 1 : 0);
                if (a != null) {
                    a.onPaused();
                }
            }

            /* renamed from: u */
            public void mo24185u(int i, boolean z) {
                StringBuilder sb = new StringBuilder();
                sb.append("onPageSelected : ");
                sb.append(i);
                LogUtilsV2.m14230i(sb.toString());
                C4224a a = TemplateDetailAct.this.m10569hr(0);
                if (a != null) {
                    a.mo24189Or();
                    if (VideoAutoPlayHelper.canAutoPlay(TemplateDetailAct.this)) {
                        a.mo24190Os();
                    }
                }
            }
        });
        this.bza.coP.setLayoutManager(r0);
        C4223c cVar = new C4223c(this.bzb, this.bzc);
        cVar.mo24188a((OnClickListener) new C4222b(this, r0));
        this.bza.coP.setAdapter(cVar);
        cVar.setDataList(this.dataList);
        cVar.notifyDataSetChanged();
    }

    /* access modifiers changed from: private */
    /* renamed from: Oo */
    public /* synthetic */ void m10563Oo() {
        C4224a hr = m10569hr(0);
        if (VideoAutoPlayHelper.canAutoPlay(this) && hr != null) {
            hr.mo24190Os();
        }
    }

    /* renamed from: a */
    public static void m10565a(Activity activity, List<TemplateInfo> list, int i, String str, int i2) {
        if (list != null && i < list.size()) {
            HashMap hashMap = new HashMap();
            hashMap.put("ttid", ((TemplateInfo) list.get(i)).getTtid());
            hashMap.put("position", C5527a.m14968kj(i2 == 0 ? 49 : 50));
            UserBehaviorLog.onKVEvent(activity, "School_Module_Cover_Click", hashMap);
            Intent intent = new Intent(activity, TemplateDetailAct.class);
            intent.putExtra("extra_template_info_json", new Gson().toJson((Object) list));
            intent.putExtra("extra_template_index", i);
            intent.putExtra("extra_template_tab_name", str);
            intent.putExtra("extra_from_page_type", i2);
            activity.startActivity(intent);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m10568a(FeedRecylayoutManager feedRecylayoutManager, View view) {
        this.bza.coP.smoothScrollToPosition(feedRecylayoutManager.aco() + 1);
    }

    /* access modifiers changed from: private */
    /* renamed from: hr */
    public C4224a m10569hr(int i) {
        View childAt = this.bza.coP.getChildAt(i);
        if (childAt == null) {
            return null;
        }
        return (C4224a) this.bza.coP.mo7766av(childAt);
    }

    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.xiaoying_activity_enter, R.anim.xiaoying_activity_exit);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
            return;
        }
        this.bzc = getIntent().getIntExtra("extra_from_page_type", 0);
        this.bzb = getIntent().getStringExtra("extra_template_tab_name");
        String stringExtra = getIntent().getStringExtra("extra_template_info_json");
        int intExtra = getIntent().getIntExtra("extra_template_index", 0);
        if (TextUtils.isEmpty(stringExtra)) {
            finish();
            return;
        }
        this.dataList = (List) new Gson().fromJson(stringExtra, new TypeToken<List<TemplateInfo>>() {
        }.getType());
        this.bza = (C7361c) C0171f.m361a(this, R.layout.app_act_school_template_detail);
        m10562On();
        if (intExtra > 0) {
            this.bza.coP.scrollToPosition(intExtra);
        }
        C1487a.aUa().mo9777a(new C4221a(this), 500, TimeUnit.MILLISECONDS);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        C4224a hr = m10569hr(0);
        if (hr != null) {
            hr.onPaused();
        }
    }
}
