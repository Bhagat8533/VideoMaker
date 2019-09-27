package com.introvd.template.app.school.template.detail;

import android.app.Activity;
import android.support.p024v7.widget.RecyclerView.C1034u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.app.C3740b;
import com.introvd.template.app.p199v5.common.C4417b;
import com.introvd.template.app.school.C4203l;
import com.introvd.template.app.school.C4205m;
import com.introvd.template.app.school.api.model.TemplateInfo;
import com.introvd.template.app.school.p195a.C4145b;
import com.introvd.template.common.Constants;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.p310g.C7376o;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.introvd.template.app.school.template.detail.c */
public class C4223c extends C4417b<TemplateInfo> {
    /* access modifiers changed from: private */
    public static final int bzg = C4583d.m11673ii(44);
    /* access modifiers changed from: private */
    public static final int bzh = C4583d.m11673ii(55);
    /* access modifiers changed from: private */
    public static final int bzi = C4583d.m11673ii(90);
    /* access modifiers changed from: private */
    public String bzb;
    /* access modifiers changed from: private */
    public int bzc;
    /* access modifiers changed from: private */
    public OnClickListener bzj;

    /* renamed from: com.introvd.template.app.school.template.detail.c$a */
    class C4224a extends C1034u {
        private C7376o bzk;
        private C4229h bzl;

        C4224a(C7376o oVar) {
            super(oVar.getRoot());
            this.bzk = oVar;
            m10578Ot();
        }

        /* renamed from: Ot */
        private void m10578Ot() {
            this.bzl = new C4229h(this.bzk.cpD);
            this.bzk.bzs.setOnClickListener(new C4226e(this));
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ void m10579a(TemplateInfo templateInfo, View view) {
            if (!C4580b.m11632Sf() && (view.getContext() instanceof Activity)) {
                try {
                    List Hh = C3740b.m9101He().mo23112Hh();
                    C4203l.m10495a(templateInfo, (Activity) ((WeakReference) Hh.get(Hh.size() - 2)).get(), C4223c.this.bzc == 0 ? 49 : 50, C4223c.this.bzb);
                    HashMap hashMap = new HashMap();
                    hashMap.put("ttid", templateInfo.getTtid());
                    hashMap.put("tab", C4223c.this.bzb);
                    hashMap.put("position", "预览页");
                    UserBehaviorLog.onKVEvent(VivaBaseApplication.m8749FZ(), "Click_Module_Use", hashMap);
                    ((Activity) view.getContext()).finish();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: bM */
        public static /* synthetic */ void m10582bM(View view) {
        }

        /* access modifiers changed from: private */
        /* renamed from: bN */
        public static /* synthetic */ void m10583bN(View view) {
            if (view.getContext() instanceof Activity) {
                ((Activity) view.getContext()).finish();
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: bO */
        public /* synthetic */ void m10584bO(View view) {
            this.bzl.mo24197Ox();
            this.bzl.mo24199dS("click");
        }

        /* renamed from: d */
        private void m10587d(TemplateInfo templateInfo) {
            if (this.bzk.aaU()) {
                this.bzk.cpH.setPadding(C4223c.bzg, C4223c.bzi, C4223c.bzg, C4223c.bzi);
                this.bzk.cpE.getLayoutParams().height = C4583d.m11673ii(119);
                this.bzk.cpD.getLayoutParams().height = ((Constants.getScreenSize().width - C4583d.m11673ii(88)) * 9) / 16;
                this.bzk.cpD.setPadding(0, 0, 0, 0);
            } else {
                this.bzk.cpH.setPadding(C4223c.bzg, C4223c.bzh, C4223c.bzg, C4223c.bzh);
                this.bzk.cpE.getLayoutParams().height = C4583d.m11673ii(52);
                int i = Constants.getScreenSize().height;
                if (this.bzk.cpH.getContext() instanceof Activity) {
                    i = ((Activity) this.bzk.cpH.getContext()).findViewById(16908290).getMeasuredHeight();
                }
                int access$500 = (i - (C4223c.bzh * 2)) - C4583d.m11673ii(200);
                int access$300 = ((Constants.getScreenSize().width - (C4223c.bzg * 2)) * templateInfo.getHeight()) / templateInfo.getWidth();
                if (access$300 > access$500) {
                    this.bzk.cpD.getLayoutParams().width = (templateInfo.getWidth() * access$500) / templateInfo.getHeight();
                    this.bzk.cpD.getLayoutParams().height = access$500;
                } else {
                    this.bzk.cpD.getLayoutParams().width = (templateInfo.getWidth() * access$300) / templateInfo.getHeight();
                    this.bzk.cpD.getLayoutParams().height = access$300;
                }
            }
            this.bzk.getRoot().setOnClickListener(C4227f.bzp);
            this.bzk.cpH.setOnClickListener(C4228g.bzq);
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: Or */
        public void mo24189Or() {
            if (C4223c.this.getDataItemCount() <= 1 || !C4145b.m10328NT().mo23833NV()) {
                this.bzk.mo32006dL(false);
                return;
            }
            this.bzk.mo32006dL(true);
            C4145b.m10328NT().mo23832NU();
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: Os */
        public void mo24190Os() {
            this.bzl.mo24197Ox();
            this.bzl.mo24199dS("slide");
        }

        /* access modifiers changed from: 0000 */
        /* renamed from: c */
        public void mo24191c(TemplateInfo templateInfo) {
            boolean z = false;
            this.bzk.mo32005dK(templateInfo.getWidth() > templateInfo.getHeight());
            this.bzl.mo24198a(new C4233j(templateInfo.getVideoUrl(), templateInfo.getTtid(), C4223c.this.bzb));
            String str = "创作页";
            if (C4223c.this.bzc == 1) {
                str = "更多";
            } else if (C4223c.this.bzc == 2) {
                str = "TodoCode";
            }
            C4205m.m10499Q(templateInfo.getTtid(), str);
            this.bzk.mo32008e(templateInfo);
            m10587d(templateInfo);
            mo24189Or();
            C7376o oVar = this.bzk;
            if (C4223c.this.getDataItemCount() > 1) {
                z = true;
            }
            oVar.mo32007dM(z);
            this.bzk.cpz.setOnClickListener(new C4225d(this, templateInfo));
            if (C4223c.this.bzj != null) {
                this.bzk.cpB.setOnClickListener(C4223c.this.bzj);
            }
        }

        /* access modifiers changed from: 0000 */
        public void onPaused() {
            this.bzl.onPause();
        }
    }

    C4223c(String str, int i) {
        this.bzb = str;
        this.bzc = i;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo24188a(OnClickListener onClickListener) {
        this.bzj = onClickListener;
    }

    public boolean isSupportFooterItem() {
        return false;
    }

    public boolean isSupportHeaderItem() {
        return false;
    }

    public void onBindFooterViewHolder(C1034u uVar, int i) {
    }

    public void onBindHeaderViewHolder(C1034u uVar, int i) {
    }

    public void onBindItemViewHolder(C1034u uVar, int i) {
        TemplateInfo templateInfo = (TemplateInfo) getListItem(i, false);
        if (templateInfo != null) {
            ((C4224a) uVar).mo24191c(templateInfo);
        }
    }

    public C1034u onCreateFooterViewHolder(ViewGroup viewGroup, int i) {
        return null;
    }

    public C1034u onCreateHeaderViewHolder(ViewGroup viewGroup, int i) {
        return null;
    }

    public C1034u onCreateItemViewHolder(ViewGroup viewGroup, int i) {
        return new C4224a(C7376o.m21737c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false));
    }
}
