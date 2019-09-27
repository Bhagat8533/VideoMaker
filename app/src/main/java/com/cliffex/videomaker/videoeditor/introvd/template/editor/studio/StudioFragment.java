package com.introvd.template.editor.studio;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.p021v4.app.Fragment;
import android.support.p021v4.content.LocalBroadcastManager;
import android.support.p021v4.widget.NestedScrollView;
import android.support.p024v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.C4681i;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.editor.R;
import com.introvd.template.editor.common.p247a.C5839a;
import com.introvd.template.editor.service.ProjectScanService;
import com.introvd.template.module.p326ad.C7680l;
import com.introvd.template.module.p326ad.p327a.C7589a;
import com.introvd.template.p203b.C4562a;
import com.introvd.template.router.StudioRouter;
import com.introvd.template.sdk.p380a.C8381b;
import com.introvd.template.sdk.p390f.C8446b;
import com.introvd.template.sdk.utils.C8553i;
import java.util.HashMap;
import java.util.List;

@C1942a(mo10417rZ = "/studio/fragment")
public class StudioFragment extends Fragment {

    /* renamed from: Vu */
    private RecyclerView f3516Vu;
    /* access modifiers changed from: private */
    public LinearLayout djJ;
    /* access modifiers changed from: private */
    public View djK = null;
    private View djL = null;
    private C6884a djM;
    private C6913d djN = null;
    private NestedScrollView djO;
    private boolean djP = false;
    private boolean djQ = false;
    private boolean djR = false;
    /* access modifiers changed from: private */
    public int djh = 0;
    private boolean dji = false;
    private int djj;

    /* renamed from: com.introvd.template.editor.studio.StudioFragment$a */
    public interface C6884a {
        void ast();
    }

    /* access modifiers changed from: private */
    public void asA() {
        if (!this.djR && this.djN != null) {
            this.djN.mo30563hk(true);
        }
    }

    /* access modifiers changed from: private */
    public void asB() {
        if (!this.djP) {
            ProjectScanService.m19506fl(VivaBaseApplication.m8749FZ());
            C68838 r0 = new BroadcastReceiver() {
                public void onReceive(Context context, Intent intent) {
                    if (StudioRouter.LOCAL_ACTION_SCAN_PROJECT_FINISH.equals(intent.getAction())) {
                        int intExtra = intent.getIntExtra(StudioRouter.LOCAL_ACTION_SCAN_PROJECT_FINISH_INTENT_RESULT, 0);
                        C4681i.m12184Gp().mo25016Gr().recordScanResultEvt(StudioFragment.this.getActivity(), intExtra);
                        int i = R.string.xiaoying_str_Draft_prj_scan_result_tipfmt;
                        StringBuilder sb = new StringBuilder();
                        sb.append("");
                        sb.append(intExtra);
                        StudioFragment.this.m20082iJ(context.getString(i, new Object[]{sb.toString()}));
                        LocalBroadcastManager.getInstance(context).unregisterReceiver(this);
                    }
                }
            };
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(StudioRouter.LOCAL_ACTION_SCAN_PROJECT_FINISH);
            LocalBroadcastManager.getInstance(VivaBaseApplication.m8749FZ()).registerReceiver(r0, intentFilter);
            this.djP = true;
        }
    }

    private void asu() {
        this.djN = new C6913d(getActivity());
        this.djN.mo30568px(this.djh);
        this.djN.mo30561a(this.f3516Vu, this.djO);
        this.djN.mo30567pw(this.djj);
        this.djN.mo30562hj(this.dji);
        this.djN.mo30563hk(true);
    }

    private void asv() {
        if (AppPreferencesSetting.getInstance().getAppSettingInt("key_show_rate_dialog_flag", 101) != 102 || !C3742b.m9111II().mo23116IJ()) {
            if ("8888/8888".equals(AppPreferencesSetting.getInstance().getAppSettingStr("key_show_share_dialog_flag", "7777/7777"))) {
                this.djQ = true;
                asw();
                return;
            }
            return;
        }
        this.djQ = true;
        C4681i.m12184Gp().mo25016Gr().showRateDialog(getActivity());
    }

    private void asw() {
        AppPreferencesSetting.getInstance().setAppSettingStr("key_show_share_dialog_flag", "9999/9999");
        C4681i.m12184Gp().mo25016Gr().showShareAppDialog(getActivity());
    }

    private void asx() {
        if (this.djK != null) {
            List list = C8446b.aIZ().getList();
            if (list != null) {
                if (list.size() == 1 && !AppPreferencesSetting.getInstance().getAppSettingBoolean("key_preferences_studio_show_tips", false)) {
                    this.djK.setVisibility(0);
                    AppPreferencesSetting.getInstance().setAppSettingBoolean("key_preferences_studio_show_tips", true);
                    this.djK.postDelayed(new Runnable() {
                        public void run() {
                            StudioFragment.this.asy();
                        }
                    }, 10000);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public void asy() {
        if (this.djM != null) {
            this.djM.ast();
        }
        if (this.djK != null) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(this.djK, "translationY", new float[]{0.0f, (float) (-this.djK.getHeight())}).setDuration(1500);
            duration.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    StudioFragment.this.djK.setVisibility(8);
                }
            });
            duration.start();
            this.djL.setOnClickListener(null);
        }
    }

    /* access modifiers changed from: private */
    public void asz() {
        ImageView imageView = (ImageView) this.djJ.findViewById(R.id.imgview_draft_search_icon);
        Animation loadAnimation = AnimationUtils.loadAnimation(VivaBaseApplication.m8749FZ(), R.anim.xiaoying_anim_rotate_loading);
        loadAnimation.setInterpolator(new LinearInterpolator());
        imageView.startAnimation(loadAnimation);
        this.djJ.setVisibility(0);
        C4562a.m11533a(this.djJ, true, true, 0);
        HashMap hashMap = new HashMap();
        hashMap.put("action", "find");
        UserBehaviorLog.onKVEvent(VivaBaseApplication.m8749FZ(), "Find_Draft_Show", hashMap);
    }

    /* renamed from: bS */
    private void m20073bS(View view) {
        this.f3516Vu = (RecyclerView) view.findViewById(R.id.studio_recyclerview);
        this.djJ = (LinearLayout) view.findViewById(R.id.linearlayout_draft_search_tip);
        this.djK = view.findViewById(R.id.studio_tips_layout);
        this.djL = view.findViewById(R.id.xiaoying_btn_hide);
        this.djO = (NestedScrollView) view.findViewById(R.id.studio_scroll_view2);
        if (this.djL != null) {
            this.djL.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    StudioFragment.this.asy();
                }
            });
        }
    }

    /* renamed from: hi */
    private int m20079hi(boolean z) {
        return z ? 2 : 3;
    }

    /* renamed from: hp */
    private boolean m20080hp(boolean z) {
        return C7589a.getAdView(getActivity(), m20079hi(z)) == null;
    }

    /* renamed from: hq */
    private void m20081hq(boolean z) {
        C7589a.m22360aj(getActivity(), m20079hi(z));
    }

    /* access modifiers changed from: private */
    /* renamed from: iJ */
    public void m20082iJ(String str) {
        ImageView imageView = (ImageView) this.djJ.findViewById(R.id.imgview_draft_search_icon);
        imageView.setImageResource(R.drawable.xy_studio_imgview_draft_search_done_icon);
        imageView.clearAnimation();
        ((TextView) this.djJ.findViewById(R.id.txtview_draft_info)).setText(str);
        this.djJ.postDelayed(new Runnable() {
            public void run() {
                if (StudioFragment.this.getActivity() != null && !StudioFragment.this.getActivity().isFinishing()) {
                    StudioFragment.this.asA();
                    C4562a.m11533a(StudioFragment.this.djJ, false, true, 0);
                    StudioFragment.this.djJ.setVisibility(8);
                }
            }
        }, 900);
    }

    /* renamed from: a */
    public void mo30521a(C6884a aVar) {
        this.djM = aVar;
    }

    /* renamed from: ho */
    public void mo30522ho(boolean z) {
        if (this.djh < 2) {
            boolean z2 = false;
            if (m20080hp(this.djh == 0)) {
                if (this.djh == 0) {
                    z2 = true;
                }
                m20081hq(z2);
            }
            this.djh = z ^ true ? 1 : 0;
            this.djN.mo30568px(this.djh);
            this.djN.mo30563hk(true);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C8553i.setContext(VivaBaseApplication.m8749FZ());
        C8553i.m25005ut(23);
        Bundle arguments = getArguments();
        boolean z = false;
        if (arguments != null) {
            this.djh = arguments.getInt(StudioRouter.KEY_LIST_MODE, 0);
            this.djj = arguments.getInt(StudioRouter.KEY_FROM, 0);
            this.dji = arguments.getBoolean("key_Is_ProjectSelectMode", false);
        }
        View inflate = layoutInflater.inflate(R.layout.editor_studio_draft_fragment_layout, viewGroup, false);
        m20073bS(inflate);
        asu();
        asv();
        if (!this.djQ && getActivity() != null) {
            C7680l.aAf().mo32490aw(getActivity());
        }
        if (this.djh != 2) {
            if (this.djh == 0) {
                z = true;
            }
            m20081hq(z);
        }
        int count = C8446b.aIZ().getCount();
        if (!this.djP && C8381b.aHj() > count) {
            this.f3516Vu.postDelayed(new Runnable() {
                public void run() {
                    StudioFragment.this.asz();
                }
            }, 1000);
            this.f3516Vu.postDelayed(new Runnable() {
                public void run() {
                    StudioFragment.this.asB();
                }
            }, 1500);
        }
        this.f3516Vu.postDelayed(new Runnable() {
            public void run() {
                if (StudioFragment.this.djh < 2) {
                    C5839a.m16336z(VivaBaseApplication.m8749FZ(), StudioFragment.this.djh == 0);
                }
            }
        }, 400);
        return inflate;
    }

    public void onDestroy() {
        if (this.djN != null) {
            this.djN.onDestroy();
        }
        super.onDestroy();
    }

    public void onPause() {
        if (this.djN != null) {
            this.djN.onPause();
        }
        super.onPause();
        this.djR = true;
    }

    public void onResume() {
        if (this.djN != null) {
            this.djN.onResume();
            if (this.djR) {
                this.djN.mo30563hk(true);
            }
        }
        asx();
        super.onResume();
        this.djR = false;
    }
}
