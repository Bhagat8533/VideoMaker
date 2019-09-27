package com.introvd.template.explorer.music;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.C0427f;
import android.support.p021v4.app.Fragment;
import android.support.p021v4.view.ViewPager.OnPageChangeListener;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.p236ui.XYViewPager;
import com.introvd.template.explorer.music.adapter.MusicTabAdapter;
import com.introvd.template.explorer.music.download.TabDownloadedMusicFragment;
import com.introvd.template.explorer.music.item.C7307e;
import com.introvd.template.explorer.music.local.TabLocalMusicFragment;
import com.introvd.template.explorer.music.online.TabOnlineMusicFragment;
import com.introvd.template.explorer.music.p303a.C7256a;
import com.introvd.template.explorer.music.p304b.C7264c;
import com.introvd.template.explorer.music.p304b.C7265d;
import com.introvd.template.explorer.music.p304b.C7268g;
import com.introvd.template.explorer.music.p304b.C7269h;
import com.introvd.template.explorer.music.p304b.C7271j;
import com.introvd.template.explorer.music.p306d.C7273a;
import com.introvd.template.explorer.music.p306d.p307a.C7274a;
import com.introvd.template.explorer.music.p306d.p307a.C7275b;
import com.introvd.template.explorer.music.p306d.p307a.C7276c;
import com.introvd.template.explorer.p297b.C7140b;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.router.explorer.ExplorerRouter.MusicParams;
import com.introvd.template.router.explorer.MusicDataItem;
import com.introvd.template.vivaexplorermodule.R;
import com.p131c.p132a.C2561a;
import com.p131c.p132a.p133a.C2564c;
import com.p131c.p132a.p135c.p136a.C2579b;
import com.p131c.p132a.p135c.p136a.C2579b.C2582a;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.C10021c;
import org.greenrobot.eventbus.C10031j;
import org.greenrobot.eventbus.ThreadMode;

@C1942a(mo10417rZ = "/Explorer/Music")
public class XYMusicFragment extends Fragment implements OnClickListener {
    private View btV;
    private ImageView cRX;
    private View dAA;
    private EditText dAB;
    /* access modifiers changed from: private */
    public ImageView dAC;
    private RelativeLayout dAD;
    /* access modifiers changed from: private */
    public boolean dAE = false;
    private Animation dAF;
    private Animation dAG;
    private TextWatcher dAH = new TextWatcher() {
        public void afterTextChanged(Editable editable) {
            if (XYMusicFragment.this.dAE) {
                C10021c.aZH().mo38492aA(new C7276c(editable.toString()));
                if (TextUtils.isEmpty(editable.toString())) {
                    XYMusicFragment.this.dAC.setVisibility(8);
                } else {
                    XYMusicFragment.this.dAC.setVisibility(0);
                }
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    };
    private OnEditorActionListener dAI = new OnEditorActionListener() {
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i == 3) {
                C7273a.m21457av(XYMusicFragment.this.getActivity());
            }
            return false;
        }
    };
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
                if (i != 1 || !XYMusicFragment.this.dAw) {
                    XYMusicFragment.this.dAt.setSelected(false);
                    XYMusicFragment.this.dAt.setVisibility(8);
                } else {
                    XYMusicFragment.this.dAt.setVisibility(0);
                }
                if (XYMusicFragment.this.dAu != null) {
                    XYMusicFragment.this.dAu.release();
                }
                C10021c.aZH().mo38492aA(new C7269h(0));
            }
        });
    }

    private List<C7307e> awT() {
        String str = "";
        if (getArguments() != null) {
            str = getArguments().getString(MusicParams.EXTRA_CATEGORY_ID);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C7307e(getContext(), R.string.xiaoying_str_online, TabOnlineMusicFragment.m21643r(1, str)));
        arrayList.add(new C7307e(getContext(), R.string.xiaoying_str_template_state_downloaded2, TabDownloadedMusicFragment.m21509qN(1)));
        arrayList.add(new C7307e(getContext(), R.string.xiaoying_str_ve_music_my_music_library, TabLocalMusicFragment.axJ()));
        return arrayList;
    }

    private void awU() {
        if (this.dAt == null || !this.dAt.isSelected()) {
            ahL();
            return;
        }
        this.dAt.setSelected(false);
        C10021c.aZH().mo38492aA(new C7269h(0));
    }

    /* renamed from: id */
    private void m21403id(boolean z) {
        if (this.dAD != null) {
            int i = 8;
            if (C2561a.aON()) {
                this.dAD.setVisibility(8);
                return;
            }
            RelativeLayout relativeLayout = this.dAD;
            if (z) {
                i = 0;
            }
            relativeLayout.setVisibility(i);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void initUI() {
        this.dAr = (TabLayout) this.btV.findViewById(R.id.music_tablayout);
        this.mViewPager = (XYViewPager) this.btV.findViewById(R.id.music_viewpager);
        this.cRX = (ImageView) this.btV.findViewById(R.id.music_back_icon);
        this.dAt = (ImageView) this.btV.findViewById(R.id.music_rubbish_icon);
        this.dAA = this.btV.findViewById(R.id.search_container);
        this.dAB = (EditText) this.btV.findViewById(R.id.music_search_edt);
        this.dAC = (ImageView) this.btV.findViewById(R.id.music_filter_clear);
        this.dAD = (RelativeLayout) this.btV.findViewById(R.id.layout_extract_music_s);
        m21403id(true);
        this.cRX.setOnClickListener(this);
        this.dAt.setOnClickListener(this);
        this.dAA.setOnClickListener(this);
        this.dAB.addTextChangedListener(this.dAH);
        this.dAB.setOnEditorActionListener(this.dAI);
        this.dAC.setOnClickListener(this);
        this.dAD.setOnClickListener(this);
        this.dAF = AnimationUtils.loadAnimation(getContext(), R.anim.explorer_slide_bottom_enter);
        this.dAG = AnimationUtils.loadAnimation(getContext(), R.anim.explorer_slide_bottom_exit);
        C2579b.m7399a(new C2582a<View>() {
            public void onClick(View view) {
                C2564c.m7327dA(view);
                C7256a.m21413fS(XYMusicFragment.this.getContext());
                EditorRouter.launchLocalFileAlbumActivity(XYMusicFragment.this.getContext(), 1);
            }
        }, this.dAD);
        ((ViewGroup) this.btV.findViewById(R.id.music_title_layout)).setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
    }

    /* renamed from: a */
    public void mo31826a(C7140b bVar) {
        this.dAv = bVar;
    }

    public void awV() {
        this.dAB.clearFocus();
        C7273a.m21457av(getActivity());
    }

    public void awW() {
        this.dAB.requestFocus();
        C7273a.m21456a(this.dAB);
    }

    public boolean awX() {
        return C7273a.m21458b(this.dAB);
    }

    public boolean awY() {
        return this.dAE;
    }

    /* renamed from: ic */
    public void mo31831ic(boolean z) {
        if (z) {
            this.dAE = true;
            this.dAr.setVisibility(8);
            this.dAt.setVisibility(8);
            this.dAA.setVisibility(0);
            this.dAB.setFocusable(true);
            this.dAB.setFocusableInTouchMode(true);
            this.dAB.requestFocus();
        } else {
            this.dAE = false;
            C10021c.aZH().mo38492aA(new C7275b());
            if (this.dAu != null) {
                this.dAu.release();
            }
            this.dAr.setVisibility(0);
            this.dAA.setVisibility(8);
            this.dAB.clearFocus();
            this.dAB.setText("");
            this.dAC.setVisibility(8);
        }
        if (this.mViewPager != null) {
            this.mViewPager.setCanScroll(!z);
        }
    }

    public void onClick(View view) {
        if (view == this.cRX) {
            if (this.dAE) {
                awV();
                mo31831ic(false);
                return;
            }
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
        } else if (view == this.dAC) {
            this.dAB.setText("");
            this.dAC.setVisibility(8);
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
        if (dVar.axm() || !this.dAx) {
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
    public void onEventMainThread(C7268g gVar) {
        if (gVar != null && this.dAD != null && getActivity() != null && !getActivity().isFinishing()) {
            int i = gVar.eventType;
            if (i != 4) {
                switch (i) {
                    case 1:
                        if (this.dAD.getVisibility() != 0) {
                            m21403id(true);
                            this.dAD.startAnimation(this.dAF);
                            break;
                        } else {
                            return;
                        }
                    case 2:
                        if (8 != this.dAD.getVisibility()) {
                            this.dAD.startAnimation(this.dAG);
                            m21403id(false);
                            break;
                        } else {
                            return;
                        }
                }
            } else if (8 != this.dAD.getVisibility()) {
                m21403id(false);
            }
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

    @C10031j(aZK = ThreadMode.MAIN)
    public void onEventMainThread(C7274a aVar) {
        if (this.dAu != null) {
            this.dAu.release();
        }
        awW();
        mo31831ic(true);
    }

    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (this.dAs != null) {
            this.dAs.onHiddenChanged(z);
        }
        if (this.dAu != null) {
            this.dAu.mo31851ib(z);
        }
        if (!z) {
            mo31831ic(false);
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
