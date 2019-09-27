package com.introvd.template.app.p184h.p185a;

import android.app.Activity;
import android.content.Context;
import android.support.p024v7.p025a.p026a.C0802a;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.introvd.template.R;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.behavior.UserBehaviorUtilsV5;
import com.introvd.template.p242d.C5527a;
import com.introvd.template.router.sns.MyResolveInfo;
import com.introvd.template.router.sns.PopupVideoShareInfo.Builder;
import com.introvd.template.router.sns.PopupVideoShareInfo.OnPopupItemClickListener;
import com.introvd.template.sns.SnsShareInfo;
import com.introvd.template.sns.SnsShareManager;
import com.introvd.template.sns.SnsShareTypeUtil;
import com.introvd.template.sns.VideoShareInfo;
import com.quvideo.sns.base.p228b.C4982c;
import com.vivavideo.mobile.h5api.api.C9335a;
import com.vivavideo.mobile.h5api.api.C9337c;
import com.vivavideo.mobile.h5api.api.C9345j;
import com.vivavideo.mobile.h5api.api.C9358q;
import com.vivavideo.mobile.h5api.api.C9363v;
import com.vivavideo.mobile.h5api.p432a.C9334a;
import org.json.JSONException;
import org.json.JSONObject;

@C9334a(aPx = {"setShareButton", "optionMenu"})
/* renamed from: com.introvd.template.app.h.a.n */
public class C3907n extends C9363v implements C9358q {
    /* access modifiers changed from: private */
    public C9345j bsV;
    /* access modifiers changed from: private */
    public C3912a bta = null;

    /* renamed from: com.introvd.template.app.h.a.n$a */
    public class C3912a {
        @SerializedName("shareTitle")
        String btf;
        @SerializedName("shareImgSrc")
        String btg;
        @SerializedName("shareDesc")
        String bth;
        @SerializedName("shareLink")
        String bti;
    }

    public C3907n(Context context) {
        super(context);
        this.cOt.setBackgroundColor(-1);
        this.eLa.setImageResource(R.drawable.vivavideo_com_nav_back);
        this.bAk.setTextColor(C0802a.getColorStateList(context, R.color.color_666666));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9614a(final Activity activity, C3912a aVar) {
        if (activity != null && aVar != null) {
            final VideoShareInfo videoShareInfo = new VideoShareInfo();
            videoShareInfo.strTitle = aVar.btf;
            videoShareInfo.strThumbUrl = aVar.btg;
            videoShareInfo.strThumbPath = aVar.btg;
            videoShareInfo.strDesc = aVar.bth;
            videoShareInfo.strPageUrl = aVar.bti;
            videoShareInfo.needReport = false;
            SnsShareManager.showVideoShareDialog(activity, new Builder().myResolveInfoList(SnsShareTypeUtil.getSnsInfoAppList(activity, true, false, false, false)).onPopupItemClickListener(new OnPopupItemClickListener() {
                public void onItemClick(MyResolveInfo myResolveInfo) {
                    SnsShareInfo.Builder snsShareListener = new SnsShareInfo.Builder().strTitle(videoShareInfo.strTitle).strDesc(videoShareInfo.strDesc).strImgUrl(videoShareInfo.strThumbUrl).strLinkUrl(videoShareInfo.strPageUrl).snsShareListener(new C4982c() {
                        public void onHandleIntentShare(int i) {
                        }

                        public void onShareCanceled(int i) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("onShareCanceled snsType = ");
                            sb.append(i);
                            LogUtilsV2.m14227d(sb.toString());
                            C3907n.this.m9617a(C3907n.this.bsV, false, i);
                        }

                        public void onShareFailed(int i, int i2, String str) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("onShareFailed snsType = ");
                            sb.append(i);
                            LogUtilsV2.m14227d(sb.toString());
                            C3907n.this.m9617a(C3907n.this.bsV, false, i);
                        }

                        public void onShareSuccess(int i) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("onShareSuccess snsType = ");
                            sb.append(i);
                            LogUtilsV2.m14227d(sb.toString());
                            C3907n.this.m9617a(C3907n.this.bsV, true, i);
                        }
                    });
                    if (myResolveInfo != null && myResolveInfo.label != null) {
                        UserBehaviorUtilsV5.onEventVideoShare(activity, C5527a.m14968kj(29), myResolveInfo.label.toString(), videoShareInfo.strTitle);
                        SnsShareManager.shareLink(activity, myResolveInfo.snsType, snsShareListener.build(), C5527a.m14968kj(29));
                    }
                }
            }).build());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9617a(C9345j jVar, boolean z, int i) {
        if (jVar != null) {
            C9337c aPE = jVar.aPE();
            if (aPE != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("result", z);
                    jSONObject.put("snsType", i);
                    StringBuilder sb = new StringBuilder();
                    sb.append("response = ");
                    sb.append(jSONObject);
                    LogUtilsV2.m14227d(sb.toString());
                    aPE.mo36554a("shareButtonCallBack", jSONObject, null);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void getFilter(C9335a aVar) {
    }

    public boolean handleEvent(final C9345j jVar) throws JSONException {
        this.bsV = jVar;
        if (!"setShareButton".equals(jVar.getAction())) {
            return false;
        }
        String action = jVar.getAction();
        StringBuilder sb = new StringBuilder();
        sb.append("h5Event getAction = ");
        sb.append(action);
        LogUtilsV2.m14227d(sb.toString());
        JSONObject aPD = jVar.aPD();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("h5Event getParam = ");
        sb2.append(aPD);
        LogUtilsV2.m14227d(sb2.toString());
        this.bta = (C3912a) new Gson().fromJson(aPD.toString(), C3912a.class);
        if (this.bta == null) {
            return true;
        }
        this.eLh.post(new Runnable() {
            public void run() {
                C3907n.this.eLh.setVisibility(0);
                ((ImageButton) C3907n.this.eLh).setImageResource(R.drawable.vivavideo_share_n);
                C3907n.this.eLh.setOnClickListener(new OnClickListener() {
                    public void onClick(View view) {
                        C3907n.this.m9614a(jVar.getActivity(), C3907n.this.bta);
                    }
                });
            }
        });
        StringBuilder sb3 = new StringBuilder();
        sb3.append("h5Event hybridShareInfo = ");
        sb3.append(new Gson().toJson((Object) this.bta));
        LogUtilsV2.m14227d(sb3.toString());
        return true;
    }

    public boolean interceptEvent(C9345j jVar) throws JSONException {
        if (!"optionMenu".equals(jVar.getAction())) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("h5Event interceptEvent getAction = ");
        sb.append(jVar.getAction());
        LogUtilsV2.m14227d(sb.toString());
        m9614a(jVar.getActivity(), this.bta);
        return true;
    }

    public void onRelease() {
    }
}
