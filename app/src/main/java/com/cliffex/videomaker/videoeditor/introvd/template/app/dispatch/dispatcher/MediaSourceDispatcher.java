package com.introvd.template.app.dispatch.dispatcher;

import android.app.Activity;
import android.arch.lifecycle.C0061e.C0062a;
import android.arch.lifecycle.C0068f;
import android.arch.lifecycle.C0069g;
import android.arch.lifecycle.C0078n;
import android.content.DialogInterface;
import android.net.Uri;
import android.support.p021v4.app.FragmentActivity;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.app.C3855d;
import com.introvd.template.app.C3999i;
import com.introvd.template.app.C4027k;
import com.introvd.template.app.dispatch.C3863a;
import com.introvd.template.app.youngermode.C4560d;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.introduce.p319a.C7518a;
import com.introvd.template.introduce.p319a.C7518a.C7520a;
import com.introvd.template.introduce.page.IntroduceActivity;
import com.introvd.template.introduce.page.model.IntroduceModel;
import com.introvd.template.module.p326ad.C7678j;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.p131c.p132a.p135c.C2575a;
import com.quvideo.priority.p217a.C4892c;
import com.vivavideo.mobile.component.sharedpref.C9324b;
import com.vivavideo.mobile.component.sharedpref.C9327e;
import java.util.ArrayList;
import java.util.HashMap;
import org.greenrobot.eventbus.C10021c;

public class MediaSourceDispatcher implements C3863a {

    public static class IntroducePopF extends C4892c {
        /* access modifiers changed from: private */
        public static boolean bqq;
        private IntroduceLifeCycleObserver bqr = new IntroduceLifeCycleObserver();

        private class IntroduceLifeCycleObserver implements C0068f {
            private C0069g bqs;
            private boolean bqt;

            private IntroduceLifeCycleObserver() {
                this.bqt = true;
            }

            /* access modifiers changed from: private */
            /* renamed from: j */
            public void m9518j(C0069g gVar) {
                this.bqs = gVar;
            }

            @C0078n(mo161n = C0062a.ON_PAUSE)
            public void onPause() {
                this.bqt = false;
            }

            @C0078n(mo161n = C0062a.ON_RESUME)
            public void onResume() {
                if (!this.bqt) {
                    if (this.bqs != null) {
                        this.bqs.getLifecycle().mo153b(this);
                    }
                    IntroducePopF.this.mo25344EW();
                }
            }
        }

        /* renamed from: KX */
        private ArrayList<IntroduceModel> m9513KX() {
            IntroduceModel introduceModel;
            try {
                introduceModel = (IntroduceModel) new Gson().fromJson(C3999i.biy, IntroduceModel.class);
            } catch (Exception e) {
                e.printStackTrace();
                introduceModel = null;
            }
            if (introduceModel == null || introduceModel.getUrlArray() == null || introduceModel.getUrlArray().isEmpty()) {
                return null;
            }
            ArrayList<IntroduceModel> arrayList = new ArrayList<>();
            arrayList.add(introduceModel);
            return arrayList;
        }

        /* access modifiers changed from: protected */
        /* renamed from: p */
        public boolean mo23396p(Activity activity) {
            if (C4560d.m11516RN().isYoungerMode() || bqq) {
                return false;
            }
            ArrayList KX = m9513KX();
            if (KX == null || KX.isEmpty()) {
                return false;
            }
            bqq = true;
            IntroduceActivity.m22267a(activity, C3999i.bix, C3999i.todoContent, KX);
            C0069g gVar = (C0069g) activity;
            this.bqr.m9518j(gVar);
            gVar.getLifecycle().mo152a(this.bqr);
            MediaSourceDispatcher.m9509KW();
            return true;
        }

        /* renamed from: sb */
        public int mo23397sb() {
            return 100;
        }
    }

    /* renamed from: com.introvd.template.app.dispatch.dispatcher.MediaSourceDispatcher$a */
    public static class C3865a extends C4892c {
        private C9324b bqo = C9327e.m27034cR(C7678j.aAd().getContext(), "app_domestic_media");

        /* access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ void m9519a(DialogInterface dialogInterface) {
            mo25344EW();
        }

        /* access modifiers changed from: protected */
        /* renamed from: p */
        public boolean mo23396p(Activity activity) {
            if (this.bqo.getBoolean("key_shown_flag", false)) {
                return false;
            }
            boolean a = C7518a.m22236a(activity, new C7520a(C3999i.biy, C2575a.parseInt(C3999i.bix), C3999i.todoContent), new C3868c(this));
            if (a) {
                MediaSourceDispatcher.m9509KW();
            }
            this.bqo.setBoolean("key_shown_flag", a);
            return a;
        }

        /* renamed from: sb */
        public int mo23397sb() {
            return 100;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: KW */
    public static void m9509KW() {
        HashMap hashMap = new HashMap(1);
        hashMap.put("name", "投放承接页");
        UserBehaviorLog.onKVEvent(VivaBaseApplication.m8749FZ(), "viva_home_popup_record", hashMap);
    }

    /* renamed from: a */
    public static void m9511a(Activity activity, Uri uri) {
        if (uri != null) {
            if (uri.getPath() != null && uri.getPath().contains("vivavideo")) {
                String lastPathSegment = uri.getLastPathSegment();
                String queryParameter = uri.getQueryParameter(SocialConstDef.ONLINE_TASK_TODO_CONTENT);
                TODOParamModel tODOParamModel = new TODOParamModel();
                tODOParamModel.mJsonParam = queryParameter;
                tODOParamModel.mTODOCode = C2575a.parseInt(lastPathSegment, 0);
                C4027k.m9994a(activity, null, tODOParamModel);
            }
        }
    }

    /* renamed from: e */
    public boolean mo23395e(FragmentActivity fragmentActivity) {
        StringBuilder sb = new StringBuilder();
        sb.append("extraStr=");
        sb.append(C3999i.biy);
        LogUtilsV2.m14230i(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("todoCode=");
        sb2.append(C3999i.bix);
        LogUtilsV2.m14230i(sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append("todoContent=");
        sb3.append(C3999i.todoContent);
        LogUtilsV2.m14230i(sb3.toString());
        if (!TextUtils.isEmpty(C3999i.biy)) {
            return IntroducePopF.bqq;
        }
        if (!TextUtils.isEmpty(C3999i.bix)) {
            int parseInt = C2575a.parseInt(C3999i.bix);
            if (parseInt > 0) {
                TODOParamModel tODOParamModel = new TODOParamModel();
                tODOParamModel.mTODOCode = parseInt;
                tODOParamModel.mJsonParam = C3999i.todoContent;
                C10021c.aZH().mo38492aA(new C3855d(tODOParamModel));
                HashMap hashMap = new HashMap();
                hashMap.put(SocialConstDef.TEMPLATEMONETIZATION_ITEM_TODOCODE, C3999i.bix);
                hashMap.put(SocialConstDef.TEMPLATEMONETIZATION_ITEM_TODOCONTENT, C3999i.todoContent);
                if (C3999i.biA.get()) {
                    hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, "VCM");
                } else if (C3999i.biB.get()) {
                    hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, "UAC");
                } else {
                    hashMap.put(SocialServiceDef.EXTRAS_UPGRADE_FROM, "LinkMe");
                }
                UserBehaviorLog.onKVEvent(VivaBaseApplication.m8749FZ().getApplicationContext(), "Home_Deeplink_Jump", hashMap);
                return true;
            }
        } else if (C3999i.biz != null) {
            m9511a(fragmentActivity, C3999i.biz);
        }
        return false;
    }
}
