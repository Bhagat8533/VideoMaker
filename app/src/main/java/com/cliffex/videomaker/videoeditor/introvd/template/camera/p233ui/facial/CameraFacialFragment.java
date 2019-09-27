package com.introvd.template.camera.p233ui.facial;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.p021v4.app.Fragment;
import android.support.p024v7.widget.GridLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1022l;
import android.support.p024v7.widget.RecyclerView.C1025n;
import android.support.p024v7.widget.RecyclerView.C1031r;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.introvd.template.camera.p208a.C4667f;
import com.introvd.template.camera.p232e.C5031c;
import com.introvd.template.common.behavior.UserBehaviorUtils;
import com.introvd.template.p203b.C4600l;
import com.introvd.template.p203b.C4602m;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.sdk.p391g.C8450a;
import com.introvd.template.template.model.TemplateGroupInfo;
import com.introvd.template.template.p407e.C8735f;
import com.introvd.template.template.p407e.C8738h;
import com.introvd.template.template.p407e.C8742k;
import com.introvd.template.vivacamera.R;
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

/* renamed from: com.introvd.template.camera.ui.facial.CameraFacialFragment */
public class CameraFacialFragment extends Fragment {
    private RecyclerView ama;
    private boolean bVa;
    private boolean bVb;
    private String bVc = "";
    /* access modifiers changed from: private */
    public TemplateGroupInfo bVd;
    /* access modifiers changed from: private */
    public C8738h bVe = new C8738h();
    private C5134b bVf;
    /* access modifiers changed from: private */
    public C5138c bVg;
    private C5141e bVh = new C5141e() {
        /* renamed from: XC */
        public void mo26011XC() {
            if (CameraFacialFragment.this.bVg != null) {
                CameraFacialFragment.this.bVg.mo25968e(null);
            }
        }

        /* renamed from: c */
        public void mo26012c(int i, Object obj) {
            if ((obj instanceof TemplateInfo) && CameraFacialFragment.this.bVg != null) {
                TemplateInfo templateInfo = (TemplateInfo) obj;
                UserBehaviorUtils.recordTemplateExposureRate(CameraFacialFragment.this.getContext(), "Cam_Facial_Effect_Preview", templateInfo.strTitle, i, templateInfo.ttid);
                CameraFacialFragment.this.bVg.mo25968e(templateInfo);
            }
        }

        /* renamed from: d */
        public void mo26013d(int i, Object obj) {
            if (CameraFacialFragment.this.bVg != null && obj != null) {
                CameraFacialFragment.this.bVg.mo25969f((TemplateInfo) obj);
            }
        }

        /* renamed from: e */
        public boolean mo26014e(int i, Object obj) {
            if (!C4600l.m11739k(CameraFacialFragment.this.getContext(), true)) {
                return false;
            }
            if (!(obj == null || !(obj instanceof TemplateInfo) || CameraFacialFragment.this.bVg == null)) {
                CameraFacialFragment.this.bVg.mo25968e((TemplateInfo) obj);
            }
            return true;
        }
    };
    private Handler handler = new Handler();
    /* access modifiers changed from: private */
    public int retryCount = 50;
    /* access modifiers changed from: private */
    public List<TemplateInfo> templateInfoList = new ArrayList();

    /* renamed from: com.introvd.template.camera.ui.facial.CameraFacialFragment$a */
    private class C5124a extends GridLayoutManager {
        C5124a(Context context, int i) {
            super(context, i);
        }

        public void onLayoutChildren(C1025n nVar, C1031r rVar) {
            try {
                super.onLayoutChildren(nVar, rVar);
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }

        public boolean supportsPredictiveItemAnimations() {
            return false;
        }
    }

    /* renamed from: XA */
    private void m13827XA() {
        C1834l.m5254a((C1839n<T>) new C1839n<List<TemplateInfo>>() {
            /* renamed from: a */
            public void mo10177a(C1838m<List<TemplateInfo>> mVar) throws Exception {
                Object arrayList = new ArrayList();
                if (CameraFacialFragment.this.bVd != null) {
                    if (!CameraFacialFragment.this.bVd.is4Test || CameraFacialFragment.this.bVe == null) {
                        C8742k.aMi().mo35178cz(CameraFacialFragment.this.getContext(), CameraFacialFragment.this.bVd.strGroupCode);
                        arrayList = C8742k.aMi().mo35183qt(CameraFacialFragment.this.bVd.strGroupCode);
                    } else {
                        arrayList = CameraFacialFragment.this.bVe.mo35169hj(CameraFacialFragment.this.getContext());
                    }
                }
                mVar.mo9791K(arrayList);
            }
        }).mo10157d(C1820a.aVi()).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<List<TemplateInfo>>() {
            /* renamed from: R */
            public void mo9886K(List<TemplateInfo> list) {
                if (list == null || list.size() <= 0) {
                    CameraFacialFragment.this.m13828XB();
                } else {
                    CameraFacialFragment.this.templateInfoList = list;
                }
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

    /* access modifiers changed from: private */
    /* renamed from: XB */
    public void m13828XB() {
        C1834l.m5254a((C1839n<T>) new C1839n<Boolean>() {
            /* renamed from: a */
            public void mo10177a(C1838m<Boolean> mVar) throws Exception {
                if (CameraFacialFragment.this.bVd != null) {
                    C5131a.m13872Xx().mo26029ag(CameraFacialFragment.this.getContext(), CameraFacialFragment.this.bVd.strGroupCode);
                    mVar.mo9791K(Boolean.valueOf(true));
                    return;
                }
                mVar.onComplete();
            }
        }).mo10157d(C1820a.aVi()).mo10152c(C1820a.aVi()).mo10162e((C1518f<? super T, ? extends C1840o<? extends R>>) new C1518f<Boolean, C1840o<List<TemplateInfo>>>() {
            /* renamed from: h */
            public C1840o<List<TemplateInfo>> apply(Boolean bool) throws Exception {
                List list;
                if (!CameraFacialFragment.this.bVd.is4Test || CameraFacialFragment.this.bVe == null) {
                    C8742k.aMi().mo35178cz(CameraFacialFragment.this.getContext(), CameraFacialFragment.this.bVd.strGroupCode);
                    list = C8742k.aMi().mo35183qt(CameraFacialFragment.this.bVd.strGroupCode);
                } else {
                    list = CameraFacialFragment.this.bVe.mo35169hj(CameraFacialFragment.this.getContext());
                }
                return (list == null || list.size() == 0) ? C1834l.m5263w(new RuntimeException("data empty,please retry!")) : C1834l.m5257ah(list);
            }
        }).mo10170g((C1518f<? super C1834l<Throwable>, ? extends C1840o<?>>) new C4602m<Object,Object>(20, 200)).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<List<TemplateInfo>>() {
            /* renamed from: R */
            public void mo9886K(List<TemplateInfo> list) {
                if (list != null) {
                    CameraFacialFragment.this.templateInfoList = list;
                } else {
                    CameraFacialFragment.this.templateInfoList = new ArrayList();
                }
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

    /* access modifiers changed from: private */
    /* renamed from: Xy */
    public void m13829Xy() {
        if (this.bVa && this.bVb) {
            if (this.templateInfoList != null && this.templateInfoList.size() > 0) {
                this.bVf.mo26035ay(this.templateInfoList);
                m13830Xz();
                StringBuilder sb = new StringBuilder();
                for (TemplateInfo templateInfo : this.templateInfoList) {
                    sb.append("/");
                    sb.append(templateInfo.ttid);
                }
                C5031c.m13215ak(getContext(), sb.toString());
            } else if (this.retryCount > 0) {
                if (this.handler == null) {
                    this.handler = new Handler();
                }
                this.handler.postDelayed(new Runnable() {
                    public void run() {
                        CameraFacialFragment.this.retryCount = CameraFacialFragment.this.retryCount - 1;
                        CameraFacialFragment.this.m13829Xy();
                    }
                }, 200);
            }
        }
    }

    /* renamed from: Xz */
    private void m13830Xz() {
        if (!TextUtils.isEmpty(this.bVc) && this.bVf != null && this.ama != null) {
            int ff = this.bVf.mo26037ff(this.bVc);
            if (-1 != ff) {
                this.ama.scrollToPosition(ff);
            }
        }
    }

    /* renamed from: a */
    public static CameraFacialFragment m13832a(TemplateGroupInfo templateGroupInfo) {
        CameraFacialFragment cameraFacialFragment = new CameraFacialFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_camera_sticker_groupcode", templateGroupInfo);
        cameraFacialFragment.setArguments(bundle);
        return cameraFacialFragment;
    }

    /* renamed from: co */
    private void m13836co(View view) {
        this.ama = (RecyclerView) view.findViewById(R.id.recycler_view);
        this.ama.setLayoutManager(new C5124a(getContext(), 5));
        this.ama.mo7737a((C1022l) new C4667f());
        this.bVf = new C5134b(getContext());
        this.bVf.mo26034a(this.bVh);
        this.bVf.mo26036fe(this.bVc);
        this.ama.setAdapter(this.bVf);
    }

    /* renamed from: f */
    private int m13839f(Long l) {
        for (int i = 0; i < this.templateInfoList.size(); i++) {
            TemplateInfo templateInfo = (TemplateInfo) this.templateInfoList.get(i);
            if (templateInfo != null && TextUtils.equals(C8450a.m24469bn(l.longValue()), templateInfo.ttid)) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: a */
    public void mo26003a(C5138c cVar) {
        this.bVg = cVar;
    }

    /* renamed from: c */
    public void mo26004c(Long l, int i) {
        if (this.bVf != null) {
            int f = m13839f(l);
            if (f >= 0) {
                this.bVf.mo26031B(f, i > 0);
            }
        }
        String bn = C8450a.m24469bn(l.longValue());
        TemplateInfo qp = C8735f.aMf().mo35155qp(bn);
        if (qp == null) {
            return;
        }
        if (i == -1) {
            qp.nState = 6;
        } else if (i == -2) {
            qp.nState = 1;
            C8735f.aMf().mo35153qn(bn);
        }
    }

    /* renamed from: e */
    public void mo26005e(Long l) {
        String bn = l.longValue() <= 0 ? "" : C8450a.m24469bn(l.longValue());
        this.bVc = bn;
        if (this.bVf != null) {
            this.bVf.mo26036fe(bn);
        }
    }

    /* renamed from: g */
    public void mo26006g(TemplateInfo templateInfo) {
        int indexOf = this.templateInfoList.indexOf(templateInfo);
        if (indexOf >= 0) {
            TemplateInfo templateInfo2 = (TemplateInfo) this.templateInfoList.get(indexOf);
            if (templateInfo2 != null && templateInfo2.nState == 1) {
                templateInfo2.nState = 8;
            }
            if (this.bVf != null) {
                this.bVf.mo26031B(indexOf, true);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.bVd = (TemplateGroupInfo) getArguments().getParcelable("key_camera_sticker_groupcode");
            m13827XA();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.cam_frag_sticker_layout, viewGroup, false);
        m13836co(inflate);
        return inflate;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.bVa = false;
        this.bVb = false;
        this.ama = null;
        if (this.handler != null) {
            this.handler.removeCallbacksAndMessages(null);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.bVa = true;
        this.retryCount = 50;
        m13829Xy();
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z) {
            this.bVb = true;
            this.retryCount = 50;
            m13829Xy();
            return;
        }
        this.bVb = false;
    }
}
