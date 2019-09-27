package com.introvd.template.explorer.music;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.C0427f;
import android.support.p021v4.app.Fragment;
import android.support.p021v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.p236ui.XYViewPager;
import com.introvd.template.explorer.music.adapter.MusicTabAdapter;
import com.introvd.template.explorer.music.download.TabDownloadedMusicFragment;
import com.introvd.template.explorer.music.item.C7307e;
import com.introvd.template.explorer.music.online.TabOnlineMusicFragment;
import com.introvd.template.explorer.music.p303a.C7256a;
import com.introvd.template.explorer.music.p304b.C7264c;
import com.introvd.template.explorer.music.p304b.C7265d;
import com.introvd.template.explorer.music.p304b.C7269h;
import com.introvd.template.explorer.music.p304b.C7271j;
import com.introvd.template.explorer.p297b.C7140b;
import com.introvd.template.router.explorer.ExplorerRouter.MusicParams;
import com.introvd.template.router.explorer.MusicDataItem;
import com.introvd.template.vivaexplorermodule.R;
import com.p131c.p132a.p133a.C2564c;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.C10021c;
import org.greenrobot.eventbus.C10031j;
import org.greenrobot.eventbus.ThreadMode;

@C1942a(mo10417rZ = "/Explorer/MusicEffect")
public class XYMusicEffectFragment extends Fragment implements OnClickListener {
    private View btV;
    private ImageView cRX;
    private TabLayout dAr;
    private MusicTabAdapter dAs;
    /* access modifiers changed from: private */
    public ImageView dAt;
    /* access modifiers changed from: private */
    public C7257b dAu;
    private C7140b dAv;
    /* access modifiers changed from: private */
    public boolean dAw;
    private boolean dAx = false;
    private MusicDataItem dAy;
    private XYViewPager mViewPager;

    private void ahL() {
        if (!(this.dAy == null || FileUtils.isFileExisted(this.dAy.filePath) || this.dAv == null)) {
            this.dAv.mo25764cZ(false);
        }
        if (this.dAv != null) {
            this.dAv.mo25762WC();
        }
        if (getFragmentManager() != null) {
            getFragmentManager().beginTransaction().setCustomAnimations(R.anim.activity_slide_in_from_top, R.anim.activity_slide_out_to_top).hide(this).commitAllowingStateLoss();
        }
    }

    private void awS() {
        this.mViewPager.setOffscreenPageLimit(2);
        this.dAs = new MusicTabAdapter(this, awT());
        this.mViewPager.setAdapter(this.dAs);
        this.dAr.setupWithViewPager(this.mViewPager);
        this.mViewPager.validateDatasetObserver();
        for (int i = 0; i < this.dAr.getTabCount(); i++) {
            C0427f aI = this.dAr.mo2008aI(i);
            if (aI != null) {
                aI.mo2088E(this.dAs.mo31849ox(i));
            }
        }
        this.mViewPager.addOnPageChangeListener(new OnPageChangeListener() {
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f, int i2) {
            }

            public void onPageSelected(int i) {
                if (i != 1 || !XYMusicEffectFragment.this.dAw) {
                    XYMusicEffectFragment.this.dAt.setSelected(false);
                    XYMusicEffectFragment.this.dAt.setVisibility(8);
                } else {
                    XYMusicEffectFragment.this.dAt.setVisibility(0);
                }
                if (XYMusicEffectFragment.this.dAu != null) {
                    XYMusicEffectFragment.this.dAu.release();
                }
                C10021c.aZH().mo38492aA(new C7269h(0));
                C7256a.m21410bV(XYMusicEffectFragment.this.getContext(), i == 0 ? "on_line" : "downloaded");
            }
        });
    }

    private void awU() {
        if (this.dAt == null || !this.dAt.isSelected()) {
            ahL();
            return;
        }
        this.dAt.setSelected(false);
        C10021c.aZH().mo38492aA(new C7269h(0));
    }

    private void initUI() {
        this.dAr = (TabLayout) this.btV.findViewById(R.id.music_tablayout);
        this.mViewPager = (XYViewPager) this.btV.findViewById(R.id.music_viewpager);
        this.cRX = (ImageView) this.btV.findViewById(R.id.music_back_icon);
        this.cRX.setVisibility(8);
        this.dAt = (ImageView) this.btV.findViewById(R.id.music_rubbish_icon);
        this.cRX.setOnClickListener(this);
        this.dAt.setOnClickListener(this);
    }

    /* renamed from: a */
    public void mo31820a(C7140b bVar) {
        this.dAv = bVar;
    }

    public List<C7307e> awT() {
        String str = "";
        if (getArguments() != null) {
            str = getArguments().getString(MusicParams.EXTRA_CATEGORY_ID);
        }
        ArrayList arrayList = new ArrayList();
        TabOnlineMusicFragment r = TabOnlineMusicFragment.m21643r(2, str);
        TabDownloadedMusicFragment qN = TabDownloadedMusicFragment.m21509qN(2);
        arrayList.add(new C7307e(getContext(), R.string.xiaoying_str_online, r));
        arrayList.add(new C7307e(getContext(), R.string.xiaoying_str_template_state_downloaded2, qN));
        return arrayList;
    }

    public void onClick(View view) {
        if (view == this.cRX) {
            awU();
        } else if (view == this.dAt) {
            C2564c.m7331dz(this.dAt);
            int i = 1;
            this.dAt.setSelected(!this.dAt.isSelected());
            C10021c aZH = C10021c.aZH();
            if (!this.dAt.isSelected()) {
                i = 2;
            }
            aZH.mo38492aA(new C7269h(i));
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.btV = layoutInflater.inflate(R.layout.xiaoying_music_fragment, viewGroup, false);
        this.dAu = new C7257b(getActivity());
        if (!C10021c.aZH().mo38495ay(this)) {
            C10021c.aZH().mo38494ax(this);
        }
        initUI();
        awS();
        return this.btV;
    }

    public void onDetach() {
        super.onDetach();
        if (this.dAu != null) {
            this.dAu.onDetach();
        }
        if (C10021c.aZH().mo38495ay(this)) {
            C10021c.aZH().mo38496az(this);
        }
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onEventMainThread(C7264c cVar) {
        int currentItem = this.mViewPager.getCurrentItem();
        int i = 0;
        this.dAw = cVar.getMode() == 1;
        if (currentItem == 1) {
            ImageView imageView = this.dAt;
            if (cVar.getMode() != 1) {
                i = 8;
            }
            imageView.setVisibility(i);
        }
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onEventMainThread(C7265d dVar) {
        if (!this.dAx) {
            if (this.dAt != null && this.dAt.isSelected()) {
                this.dAt.setSelected(false);
            }
            this.dAy = dVar.axl();
            if (!(this.dAv == null || this.dAy == null)) {
                this.dAv.mo25763c(this.dAy);
            }
            if (this.dAu != null) {
                this.dAu.mo31851ib(true);
            }
            ahL();
        }
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onEventMainThread(C7271j jVar) {
        if (jVar.getEventType() == 1) {
            if (this.dAt != null && this.dAt.isSelected()) {
                this.dAt.setSelected(false);
            }
            if (this.dAu != null) {
                this.dAu.release();
            }
        }
    }

    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (this.dAs != null) {
            this.dAs.onHiddenChanged(z);
        }
        if (this.dAu != null) {
            this.dAu.mo31851ib(z);
        }
    }

    public void onPause() {
        super.onPause();
        if (this.dAu != null) {
            this.dAu.release();
        }
        this.dAx = true;
    }

    public void onResume() {
        super.onResume();
        if (this.dAu != null) {
            this.dAu.anG();
        }
        this.dAx = false;
    }
}
