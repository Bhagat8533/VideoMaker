package com.introvd.template.component.videofetcher.p241ui;

import android.os.Bundle;
import android.support.p021v4.app.Fragment;
import android.support.p021v4.app.FragmentTransaction;
import android.support.p024v7.widget.GridLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1018h;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.introvd.template.component.videofetcher.C5390c;
import com.introvd.template.component.videofetcher.C5402d;
import com.introvd.template.component.videofetcher.R;
import com.introvd.template.component.videofetcher.p238b.C5376d;
import com.introvd.template.component.videofetcher.p239c.C5396f;
import com.introvd.template.component.videofetcher.p240d.C5405c;
import com.introvd.template.component.videofetcher.utils.C5485c;
import com.introvd.template.component.videofetcher.view.C5505c;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: com.introvd.template.component.videofetcher.ui.StatusFragment */
public class StatusFragment extends Fragment {
    private View btV;
    protected TextView ckR;
    private ImageView ckS;
    private RecyclerView clQ;
    private WebInstagramFragment clR;
    private WebFaceBookFragment clS;
    private WebLiveLeakFragment clT;
    private WhatsAppFragment clU;
    protected boolean clV;

    /* renamed from: Oj */
    private void m14810Oj() {
        this.ckR = (TextView) this.btV.findViewById(R.id.fetcher_title);
        this.ckS = (ImageView) this.btV.findViewById(R.id.fetcher_back);
        this.clQ = (RecyclerView) this.btV.findViewById(R.id.status_recycleview);
        this.ckR.setText(getResources().getString(R.string.video_fetcher_str_toolbar_download_title));
        this.clQ.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        this.clQ.mo7733a((C1018h) new C5505c());
        final C5376d dVar = new C5376d();
        this.clQ.setAdapter(dVar);
        dVar.mo26957d(aax());
        dVar.mo26956a((C5405c) new C5405c() {
            /* renamed from: e */
            public void mo27033e(int i, View view) {
                if (dVar.getItemViewType(i) == 18) {
                    if (StatusFragment.this.getActivity() != null) {
                        C5390c ZH = C5402d.m14716ZG().mo27026ZH();
                        if (ZH != null) {
                            HashMap hashMap = new HashMap();
                            hashMap.put("icon", "feedback");
                            ZH.mo24462a(StatusFragment.this.getActivity().getApplicationContext(), "Video_Downloader_Home_Click", hashMap);
                            ZH.mo24460QM();
                        }
                    }
                } else if (((C5396f) dVar.mo26955ZK().get(i)).mo27005ZW() == 1) {
                    StatusFragment.this.m14815ad("icon", "whatsapp");
                    StatusFragment.this.aaw();
                } else if (dVar.mo26955ZK() != null && !dVar.mo26955ZK().isEmpty()) {
                    StatusFragment.this.m14811a((C5396f) dVar.mo26955ZK().get(i));
                }
            }
        });
        this.ckS.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (!StatusFragment.this.isHidden() && StatusFragment.this.getActivity() != null) {
                    StatusFragment.this.getActivity().finish();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14811a(C5396f fVar) {
        if (fVar != null) {
            FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
            m14816b(beginTransaction);
            this.clV = true;
            if (fVar.mo27005ZW() == 4) {
                if (this.clR == null) {
                    this.clR = WebInstagramFragment.m14840fI(fVar.getAddress());
                    beginTransaction.add(R.id.status_container, this.clR, "Instagram");
                } else {
                    beginTransaction.show(this.clR);
                }
                m14815ad("icon", "ins");
            } else if (fVar.mo27005ZW() == 2) {
                if (this.clS == null) {
                    this.clS = WebFaceBookFragment.m14825fG(fVar.getAddress());
                    beginTransaction.add(R.id.status_container, this.clS, "Facebook");
                } else {
                    beginTransaction.show(this.clS);
                }
                m14815ad("icon", "FB");
            } else if (fVar.mo27005ZW() == 3) {
                if (this.clT == null) {
                    this.clT = WebLiveLeakFragment.m14853fK(fVar.getAddress());
                    beginTransaction.add(R.id.status_container, this.clT, "liveLeak");
                } else {
                    beginTransaction.show(this.clT);
                }
                m14815ad("icon", "liveleak");
            }
            beginTransaction.commit();
        }
    }

    /* access modifiers changed from: private */
    public void aaw() {
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        m14816b(beginTransaction);
        this.clV = true;
        if (this.clU == null) {
            this.clU = new WhatsAppFragment();
            beginTransaction.add(R.id.status_container, this.clU, "WhatsApp");
        } else {
            beginTransaction.show(this.clU);
        }
        beginTransaction.commit();
    }

    private ArrayList<C5396f> aax() {
        ArrayList<C5396f> arrayList = new ArrayList<>(5);
        C5396f fVar = new C5396f(0, getString(R.string.video_fetcher_str_status_tips), "", 16, 5);
        arrayList.add(fVar);
        C5396f fVar2 = new C5396f(R.drawable.fetcher_icon_whatsapp, getString(R.string.video_fetcher_str_status_item_whatsapp), "", 17, 1);
        arrayList.add(fVar2);
        C5396f fVar3 = new C5396f(R.drawable.fetcher_icon_instagram, getString(R.string.video_fetcher_str_status_item_instagram), "https://www.instagram.com/", 17, 4);
        arrayList.add(fVar3);
        C5396f fVar4 = new C5396f(R.drawable.fetcher_icon_facebook, getString(R.string.video_fetcher_str_status_item_facebook), "https://m.facebook.com/", 17, 2);
        arrayList.add(fVar4);
        C5396f fVar5 = new C5396f(R.drawable.fetcher_icon_liveleak, getString(R.string.video_fetcher_str_status_item_liveleak), "https://www.liveleak.com/", 17, 3);
        arrayList.add(fVar5);
        C5396f fVar6 = new C5396f(R.drawable.fetcher_icon_more, getString(R.string.video_fetcher_str_status_item_more), "", 18, 5);
        arrayList.add(fVar6);
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: ad */
    public void m14815ad(String str, String str2) {
        if (getActivity() != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(str, str2);
            C5402d.m14716ZG().mo27029a(getActivity().getApplicationContext(), "Video_Downloader_Home_Click", hashMap);
        }
    }

    /* renamed from: b */
    private void m14816b(FragmentTransaction fragmentTransaction) {
        if (this.clR != null) {
            fragmentTransaction.hide(this.clR);
        }
        if (this.clS != null) {
            fragmentTransaction.hide(this.clS);
        }
        if (this.clT != null) {
            fragmentTransaction.hide(this.clT);
        }
        if (this.clU != null) {
            fragmentTransaction.hide(this.clU);
        }
    }

    public void aam() {
        if (!C5485c.m14890Sf()) {
            if (this.clV) {
                if (this.clR != null && !this.clR.isHidden() && this.clR.canGoBack()) {
                    this.clR.goBack();
                } else if (this.clS != null && !this.clS.isHidden() && this.clS.canGoBack()) {
                    this.clS.goBack();
                } else if (this.clT == null || this.clT.isHidden() || !this.clT.canGoBack()) {
                    boolean z = true;
                    boolean z2 = this.clR == null || this.clR.isHidden();
                    boolean z3 = this.clS == null || this.clS.isHidden();
                    boolean z4 = this.clT == null || this.clT.isHidden();
                    if (this.clU != null && !this.clU.isHidden()) {
                        z = false;
                    }
                    if (!z2 || !z3 || !z4 || !z) {
                        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
                        m14816b(beginTransaction);
                        beginTransaction.commit();
                        this.clV = false;
                    } else if (getActivity() != null && !getActivity().isFinishing()) {
                        getActivity().finish();
                        getActivity().overridePendingTransition(R.anim.activity_slide_in_from_left, R.anim.activity_slide_out_to_right);
                    }
                } else {
                    this.clT.goBack();
                }
            } else if (getActivity() != null && !getActivity().isFinishing()) {
                getActivity().finish();
                getActivity().overridePendingTransition(R.anim.activity_slide_in_from_left, R.anim.activity_slide_out_to_right);
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.btV = layoutInflater.inflate(R.layout.fetcher_frag_status, viewGroup, false);
        m14810Oj();
        return this.btV;
    }

    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (this.clT != null && !this.clT.isHidden()) {
            this.clT.mo27143dE(z);
        }
        if (this.clR != null && !this.clR.isHidden()) {
            this.clR.mo27131dE(z);
        }
        if (this.clS != null && !this.clS.isHidden()) {
            this.clS.mo27114dE(z);
        }
    }
}
