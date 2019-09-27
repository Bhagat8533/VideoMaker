package com.introvd.template.camera.p233ui.facial;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.C0427f;
import android.support.p021v4.app.FragmentActivity;
import android.support.p021v4.view.ViewPager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.introvd.template.common.imageloader.ImageLoader;
import com.introvd.template.p203b.C4562a;
import com.introvd.template.p203b.C4602m;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.template.model.TemplateGroupInfo;
import com.introvd.template.template.model.TemplatePackageInfo;
import com.introvd.template.template.p407e.C8738h;
import com.introvd.template.template.p407e.C8741j;
import com.introvd.template.template.p407e.C8742k;
import com.introvd.template.template.p409g.C8762d;
import com.introvd.template.vivacamera.R;
import com.p131c.p132a.p135c.C2575a;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;
import java.util.ArrayList;
import java.util.List;
import p037b.p050b.C1834l;
import p037b.p050b.C1838m;
import p037b.p050b.C1839n;
import p037b.p050b.C1840o;
import p037b.p050b.C1842q;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.camera.ui.facial.CameraFacialView */
public class CameraFacialView extends RelativeLayout {
    private static int bVr = 20;
    /* access modifiers changed from: private */
    public C8738h bVe;
    private TabLayout bVj;
    private List<CameraFacialFragment> bVk;
    private List<TemplateGroupInfo> bVl;
    private List<Long> bVm;
    private C5138c bVn;
    private boolean bVo;
    private String bVp;
    private long bVq;

    /* renamed from: yH */
    private ViewPager f3435yH;

    public CameraFacialView(Context context) {
        this(context, null);
    }

    public CameraFacialView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CameraFacialView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bVe = new C8738h();
        this.bVk = new ArrayList();
        this.bVl = new ArrayList();
        this.bVm = new ArrayList();
        this.bVo = false;
        init();
    }

    /* renamed from: XD */
    static /* synthetic */ int m13858XD() {
        int i = bVr;
        bVr = i - 1;
        return i;
    }

    /* access modifiers changed from: private */
    /* renamed from: ax */
    public void m13861ax(List<TemplateGroupInfo> list) {
        if (list != null && list.size() != 0) {
            this.bVl = list;
            for (TemplateGroupInfo a : list) {
                CameraFacialFragment a2 = CameraFacialFragment.m13832a(a);
                if (this.bVn != null) {
                    a2.mo26003a(this.bVn);
                }
                this.bVk.add(a2);
            }
            mo26017g(this.bVp, this.bVq);
            if (getContext() instanceof FragmentActivity) {
                FacialFragmentAdapter facialFragmentAdapter = new FacialFragmentAdapter(((FragmentActivity) getContext()).getSupportFragmentManager(), this.bVk);
                this.f3435yH.setAdapter(facialFragmentAdapter);
                this.bVj.setupWithViewPager(this.f3435yH);
                for (int i = 0; i < facialFragmentAdapter.getCount(); i++) {
                    TemplateGroupInfo templateGroupInfo = null;
                    if (i < list.size()) {
                        templateGroupInfo = (TemplateGroupInfo) list.get(i);
                    }
                    C0427f aI = this.bVj.mo2008aI(i);
                    if (!(templateGroupInfo == null || aI == null)) {
                        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.cam_view_sticker_tab, this, false);
                        inflate.findViewById(R.id.img_new_flag).setVisibility(C8741j.m25534cD(getContext(), templateGroupInfo.strGroupCode) ? 0 : 8);
                        DynamicLoadingImageView dynamicLoadingImageView = (DynamicLoadingImageView) inflate.findViewById(R.id.img_tab_icon);
                        if (TextUtils.isEmpty(templateGroupInfo.thumbPath)) {
                            dynamicLoadingImageView.setImageResource(R.drawable.recommend_app_default_icon);
                        } else {
                            ImageLoader.loadImage(templateGroupInfo.thumbPath, dynamicLoadingImageView);
                        }
                        aI.mo2088E(inflate);
                    }
                }
            }
            this.bVo = true;
        }
    }

    private void getGroupInfoList() {
        C1834l.m5254a((C1839n<T>) new C1839n<Boolean>() {
            /* renamed from: a */
            public void mo10177a(C1838m<Boolean> mVar) throws Exception {
                C5131a.m13872Xx().mo26030dP(CameraFacialView.this.getContext());
                mVar.mo9791K(Boolean.valueOf(true));
            }
        }).mo10157d(C1820a.aVi()).mo10152c(C1820a.aVi()).mo10162e((C1518f<? super T, ? extends C1840o<? extends R>>) new C1518f<Boolean, C1840o<List<TemplatePackageInfo>>>() {
            /* renamed from: h */
            public C1840o<List<TemplatePackageInfo>> apply(Boolean bool) throws Exception {
                List cG = C8742k.aMi().mo35177cG(CameraFacialView.this.getContext(), "camera_facedetectsticker");
                if (cG != null) {
                    return C1834l.m5257ah(cG);
                }
                throw new RuntimeException("data empty,please retry!");
            }
        }).mo10152c(C1820a.aVi()).mo10167f((C1518f<? super T, ? extends R>) new C1518f<List<TemplatePackageInfo>, List<TemplateGroupInfo>>() {
            public List<TemplateGroupInfo> apply(List<TemplatePackageInfo> list) throws Exception {
                ArrayList arrayList = new ArrayList();
                for (TemplatePackageInfo templatePackageInfo : list) {
                    TemplateGroupInfo templateGroupInfo = new TemplateGroupInfo();
                    templateGroupInfo.showList = true;
                    templateGroupInfo.showGroup = true;
                    templateGroupInfo.strGroupDisplayName = templatePackageInfo.strTitle;
                    templateGroupInfo.strGroupCode = templatePackageInfo.strGroupCode;
                    templateGroupInfo.thumbPath = templatePackageInfo.strIcon;
                    arrayList.add(templateGroupInfo);
                }
                return arrayList;
            }
        }).mo10170g((C1518f<? super C1834l<Throwable>, ? extends C1840o<?>>) new C4602m<Object,Object>(20, 200)).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<List<TemplateGroupInfo>>() {
            /* renamed from: R */
            public void mo9886K(List<TemplateGroupInfo> list) {
                if (CameraFacialView.this.bVe != null && CameraFacialView.this.bVe.mo35165hf(CameraFacialView.this.getContext()) > 0) {
                    TemplateGroupInfo templateGroupInfo = new TemplateGroupInfo();
                    templateGroupInfo.strGroupDisplayName = "facial_test/";
                    templateGroupInfo.is4Test = true;
                    list.add(0, templateGroupInfo);
                }
                CameraFacialView.this.m13861ax(list);
            }

            /* renamed from: a */
            public void mo9877a(C1495b bVar) {
            }

            public void onComplete() {
            }

            public void onError(Throwable th) {
            }
        });
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.cam_view_sticker_view, this, true);
        this.f3435yH = (ViewPager) findViewById(R.id.viewpager);
        this.bVj = (TabLayout) findViewById(R.id.tablayout);
        this.f3435yH.setOffscreenPageLimit(3);
        C1820a.aVi().mo10058o(new Runnable() {
            public void run() {
                C8762d.aMt().mo35219Q(CameraFacialView.this.getContext(), true);
            }
        });
        getGroupInfoList();
    }

    /* renamed from: c */
    public void mo26015c(Long l, int i) {
        for (CameraFacialFragment c : this.bVk) {
            c.mo26004c(l, i);
        }
    }

    /* renamed from: e */
    public void mo26016e(Long l) {
        for (CameraFacialFragment e : this.bVk) {
            e.mo26005e(l);
        }
    }

    /* renamed from: g */
    public void mo26017g(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            this.f3435yH.setCurrentItem(0);
        }
        this.bVp = str;
        this.bVq = j;
        if (this.bVk != null && this.bVk.size() > 0 && this.bVq > 0) {
            mo26016e(Long.valueOf(this.bVq));
        }
    }

    /* renamed from: g */
    public boolean mo26018g(Long l) {
        return this.bVm.contains(l);
    }

    /* renamed from: h */
    public void mo26019h(TemplateInfo templateInfo) {
        if (templateInfo != null) {
            for (CameraFacialFragment g : this.bVk) {
                g.mo26006g(templateInfo);
            }
            this.bVm.add(Long.valueOf(C2575a.m7391rq(templateInfo.ttid)));
        }
    }

    public void setChoosedSceneItem(final String str) {
        if (!this.bVo && bVr > 0) {
            postDelayed(new Runnable() {
                public void run() {
                    CameraFacialView.this.setChoosedSceneItem(str);
                    CameraFacialView.m13858XD();
                }
            }, 200);
        }
        int i = 0;
        setViewVisibility(0);
        if (this.bVl != null && this.bVl.size() > 0) {
            int i2 = 0;
            while (true) {
                if (i2 < this.bVl.size()) {
                    if (this.bVl.get(i2) != null && ((TemplateGroupInfo) this.bVl.get(i2)).strGroupCode != null && ((TemplateGroupInfo) this.bVl.get(i2)).strGroupCode.equals(str)) {
                        i = i2;
                        break;
                    }
                    i2++;
                } else {
                    break;
                }
            }
        }
        this.f3435yH.setCurrentItem(i);
    }

    public void setOnItemClickListener(C5138c cVar) {
        this.bVn = cVar;
        if (this.bVk != null && this.bVk.size() > 0) {
            for (CameraFacialFragment a : this.bVk) {
                a.mo26003a(cVar);
            }
        }
    }

    public void setViewVisibility(int i) {
        if (getVisibility() != i) {
            if (i == 0) {
                C4562a.m11536c(this, true, true, 0);
            } else {
                C4562a.m11536c(this, false, true, 0);
            }
            super.setVisibility(i);
        }
    }

    public void setVisibility(int i) {
        setViewVisibility(i);
    }
}
