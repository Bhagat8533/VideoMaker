package com.introvd.template.picker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.C0421b;
import android.support.design.widget.TabLayout.C0422c;
import android.support.design.widget.TabLayout.C0427f;
import android.support.p021v4.app.FragmentActivity;
import android.support.p021v4.view.ViewPager;
import android.support.p021v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.introvd.template.common.LogUtils;
import com.introvd.template.explorer.p298c.C7142b;
import com.introvd.template.explorer.p298c.C7142b.C7147a;
import com.introvd.template.picker.C8186b.C8187a;
import com.introvd.template.picker.adapter.PickerPagerAdapter;
import com.introvd.template.picker.fragment.AbstractPickerFragment;
import com.introvd.template.picker.fragment.ExtraPickerFragment;
import com.introvd.template.picker.fragment.FacebookPickerFragment;
import com.introvd.template.picker.fragment.InstagramPickerFragment;
import com.introvd.template.picker.fragment.OthersPickerFragment;
import com.introvd.template.picker.fragment.SystemPickerFragment;
import com.introvd.template.picker.p365a.C8172a;
import com.introvd.template.picker.p366b.C8189b;
import com.introvd.template.picker.p366b.C8191d;
import com.introvd.template.picker.p367c.C8197b;
import com.introvd.template.picker.p369d.C8218b;
import com.introvd.template.picker.view.C8248a;
import com.introvd.template.picker.view.C8248a.C8249a;
import com.introvd.template.picker.view.CoordinatorContainer;
import com.introvd.template.picker.view.CoordinatorContainer.C8246a;
import com.introvd.template.router.VivaRouter;
import com.introvd.template.router.explorer.ExplorerRouter.FileExplorerParams;
import com.introvd.template.router.setting.VivaSettingRouter.SettingLocalLocaleParams;
import com.introvd.template.router.user.SnsAuthServiceProxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MediaPickerView extends AbstractPickerView implements C8191d {
    private TabLayout dAr;
    private Integer[] dGf;
    /* access modifiers changed from: private */
    public boolean dHU;
    private ViewPager dLB;
    private PickerPagerAdapter dXA;
    private CoordinatorContainer dXB;
    /* access modifiers changed from: private */
    public C8189b dXC;
    private C8197b dXD;
    private int dXE;
    private C8248a dXF;
    private ArrayList<String> dXG;
    private View dXz;
    /* access modifiers changed from: private */
    public C7142b dyR;
    /* access modifiers changed from: private */
    public List<AbstractPickerFragment> mFragments;
    /* access modifiers changed from: private */
    public int mSourceType;

    public MediaPickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MediaPickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dXE = -1;
        this.mSourceType = 1;
        this.mFragments = new ArrayList();
        this.dGf = new Integer[]{Integer.valueOf(R.string.xiaoying_str_studio_filter_all), Integer.valueOf(R.string.xiaoying_str_edit_gallery_tab_others_singleline), Integer.valueOf(R.string.xiaoying_str_com_intl_share_facebook), Integer.valueOf(R.string.xiaoying_str_com_intl_share_instagram)};
        aFj();
    }

    private void aFj() {
        this.dXG = C8171a.aFq();
        this.dXD = new C8197b((Activity) getContext());
        LayoutInflater.from(getContext()).inflate(R.layout.picker_view_main_layout, this, true);
        this.dAr = (TabLayout) findViewById(R.id.picker_tablayout);
        this.dLB = (ViewPager) findViewById(R.id.picker_viewpager);
        this.dXz = findViewById(R.id.picker_blank);
        this.dXB = (CoordinatorContainer) findViewById(R.id.coordinator_root);
        aFl();
        m23602sU(0);
        ams();
    }

    private void aFl() {
        List asList = Arrays.asList(this.dGf);
        if (this.dXG == null || this.dXG.size() == 0) {
            SystemPickerFragment aFV = SystemPickerFragment.aFV();
            OthersPickerFragment aFU = OthersPickerFragment.aFU();
            this.mFragments.add(aFV);
            this.mFragments.add(aFU);
            if (C8171a.aFp()) {
                asList = asList.subList(0, 2);
                this.dLB.setOffscreenPageLimit(1);
            } else {
                FacebookPickerFragment aFS = FacebookPickerFragment.aFS();
                InstagramPickerFragment aFT = InstagramPickerFragment.aFT();
                this.mFragments.add(aFS);
                this.mFragments.add(aFT);
                this.dLB.setOffscreenPageLimit(3);
            }
        } else {
            asList = asList.subList(0, 1);
            this.mFragments.add(ExtraPickerFragment.m23749r(this.dXG));
            this.dAr.setVisibility(8);
        }
        for (AbstractPickerFragment abstractPickerFragment : this.mFragments) {
            abstractPickerFragment.mo33367c(this.dXD);
            abstractPickerFragment.mo33362a((C8191d) this);
        }
        this.dXA = new PickerPagerAdapter(getContext(), asList, ((FragmentActivity) getContext()).getSupportFragmentManager(), this.mFragments);
        this.dLB.setAdapter(this.dXA);
        this.dAr.setupWithViewPager(this.dLB);
        String[] strArr = {SettingLocalLocaleParams.LOCALE_DEFAULT_VALUE, "other gallery", "facebook", "instagram"};
        for (int i = 0; i < this.dAr.getTabCount(); i++) {
            C0427f aI = this.dAr.mo2008aI(i);
            if (aI != null) {
                aI.mo2092f((CharSequence) strArr[i]);
                aI.mo2088E(this.dXA.mo33263ox(i));
                View customView = aI.getCustomView();
                if (customView != null) {
                    LayoutParams layoutParams = customView.getLayoutParams();
                    layoutParams.width = C8218b.m23733gH(getContext()).widthPixels / 3;
                    customView.setLayoutParams(layoutParams);
                }
            }
        }
        this.dAr.mo2003a((C0421b) new C0422c() {
            /* renamed from: i */
            public void mo2071i(C0427f fVar) {
                if (MediaPickerView.this.dXC != null) {
                    MediaPickerView.this.dXC.amE();
                }
                CharSequence contentDescription = fVar.getContentDescription();
                if (contentDescription != null) {
                    C8172a.m23622cj(MediaPickerView.this.getContext(), contentDescription.toString());
                }
            }

            /* renamed from: j */
            public void mo2072j(C0427f fVar) {
                if (MediaPickerView.this.dXC != null) {
                    MediaPickerView.this.dXC.amD();
                }
            }

            /* renamed from: k */
            public void mo2073k(C0427f fVar) {
            }
        });
    }

    /* access modifiers changed from: private */
    public void aFn() {
        if (this.mFragments != null && this.mFragments.size() > 1) {
            ((AbstractPickerFragment) this.mFragments.get(0)).mo33366al(this.mSourceType, true);
            ((AbstractPickerFragment) this.mFragments.get(1)).mo33366al(this.mSourceType, true);
        }
    }

    private void ams() {
        this.dXB.setCoordinatorStateListener(new C8246a() {
            List<Point> dXH = new ArrayList();

            /* renamed from: dv */
            public void mo33257dv(int i, int i2) {
                int gE = C8171a.m23615gE(MediaPickerView.this.getContext());
                int i3 = gE / 8;
                int i4 = i - i2;
                int i5 = 1;
                if (Math.abs(i4) <= gE / 4) {
                    if (this.dXH.size() > 0) {
                        LogUtils.m14222e("Coordinator", "结束---------滑动忽略事件");
                        int i6 = i3 / 2;
                        int abs = Math.abs(((Point) this.dXH.get(0)).x - ((Point) this.dXH.get(0)).y) / i6;
                        int i7 = ((Point) this.dXH.get(0)).x - ((Point) this.dXH.get(0)).y;
                        for (int i8 = 1; i8 <= abs; i8++) {
                            MediaPickerView.this.m23603sV(i7 > 0 ? i6 : -i6);
                        }
                        MediaPickerView mediaPickerView = MediaPickerView.this;
                        if (i7 <= 0) {
                            i6 = -i6;
                        }
                        mediaPickerView.m23603sV(i7 - (i6 * abs));
                        this.dXH.clear();
                    }
                    if (Math.abs(i4) > i3) {
                        int i9 = i3 / 2;
                        int abs2 = Math.abs(i4) / i9;
                        while (i5 <= abs2) {
                            MediaPickerView.this.m23603sV(i4 > 0 ? i9 : -i9);
                            i5++;
                        }
                        MediaPickerView mediaPickerView2 = MediaPickerView.this;
                        if (i4 <= 0) {
                            i9 = -i9;
                        }
                        mediaPickerView2.m23603sV(i4 - (i9 * abs2));
                        return;
                    }
                    MediaPickerView.this.m23603sV(i4);
                } else if (this.dXH.size() <= 0) {
                    LogUtils.m14222e("Coordinator", "触发---------滑动忽略事件");
                    this.dXH.add(new Point(i, i2));
                } else if (Math.abs(((Point) this.dXH.get(0)).x - i2) >= 5 || Math.abs(((Point) this.dXH.get(0)).y - i) >= 5) {
                    LogUtils.m14222e("Coordinator", "=========不是滑动忽略事件");
                    int i10 = i3 / 2;
                    int abs3 = Math.abs(((Point) this.dXH.get(0)).x - ((Point) this.dXH.get(0)).y) / i10;
                    int i11 = ((Point) this.dXH.get(0)).x - ((Point) this.dXH.get(0)).y;
                    while (i5 <= abs3) {
                        MediaPickerView.this.m23603sV(i11 > 0 ? i10 : -i10);
                        i5++;
                    }
                    MediaPickerView mediaPickerView3 = MediaPickerView.this;
                    if (i11 <= 0) {
                        i10 = -i10;
                    }
                    mediaPickerView3.m23603sV(i11 - (i10 * abs3));
                    this.dXH.clear();
                    this.dXH.add(new Point(i, i2));
                } else {
                    this.dXH.clear();
                    LogUtils.m14222e("Coordinator", "---------滑动忽略事件");
                }
            }

            public void onStateChanged(int i) {
                if (MediaPickerView.this.dXC != null) {
                    MediaPickerView.this.dXC.mo29313ny(i);
                }
            }
        });
        this.dLB.addOnPageChangeListener(new OnPageChangeListener() {
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f, int i2) {
            }

            public void onPageSelected(int i) {
                ((AbstractPickerFragment) MediaPickerView.this.mFragments.get(i)).aFO();
            }
        });
        C8186b.aFr().mo33288a(new C8187a() {
            /* renamed from: cz */
            public void mo33259cz(List<String> list) {
                for (AbstractPickerFragment aFN : MediaPickerView.this.mFragments) {
                    aFN.aFN();
                }
            }

            /* renamed from: mk */
            public void mo33260mk(String str) {
                for (AbstractPickerFragment mA : MediaPickerView.this.mFragments) {
                    mA.mo33370mA(str);
                }
            }
        });
    }

    /* renamed from: sU */
    private void m23602sU(int i) {
        int i2 = C8218b.m23733gH(getContext()).widthPixels;
        int gE = C8171a.m23615gE(getContext());
        this.dXz.getLayoutParams().height = i2 - C8171a.dXK;
        this.dXB.setTopViewParam(i2 + i + C8171a.aFo(), C8171a.aFo() + i);
        this.dXB.getLayoutParams().height = i2 + gE;
        this.dLB.getLayoutParams().height = gE - i;
    }

    /* access modifiers changed from: private */
    /* renamed from: sV */
    public void m23603sV(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("---------offset:");
        sb.append(i);
        LogUtils.m14223i("Coordinator", sb.toString());
        LayoutParams layoutParams = this.dLB.getLayoutParams();
        layoutParams.height += i;
        this.dLB.requestLayout();
        this.dLB.setLayoutParams(layoutParams);
        for (AbstractPickerFragment th : this.mFragments) {
            th.mo33372th(i);
        }
    }

    public void aFk() {
        if (this.dXF == null) {
            this.dXF = new C8248a(getContext());
            this.dXF.mo33402a(new C8249a() {
                public void azl() {
                    if (MediaPickerView.this.dyR == null) {
                        MediaPickerView.this.dyR = new C7142b(MediaPickerView.this.getContext(), MediaPickerView.this.mSourceType == 1 ? 2 : 4, new C7147a() {
                            public void awr() {
                                MediaPickerView.this.aFn();
                            }
                        });
                    }
                    MediaPickerView.this.dyR.awl();
                }

                public void azm() {
                    MediaPickerView.this.dHU = true;
                    VivaRouter.getRouterBuilder(FileExplorerParams.URL).mo10406h(FileExplorerParams.KEY_EXPLORER_FILE_TYPE, MediaPickerView.this.mSourceType == 1 ? 2 : 4).mo10382H(MediaPickerView.this.getContext());
                }
            });
        }
        if (!this.dXF.isShowing()) {
            this.dXF.showAtLocation(this, 81, 0, 0);
        }
    }

    public void aFm() {
        aFk();
    }

    /* renamed from: b */
    public void mo33248b(int i, int i2, Intent intent) {
        if (this.dXE != -1) {
            SnsAuthServiceProxy.authorizeCallBack((Activity) getContext(), this.dXE, i, i2, intent);
        }
    }

    public CoordinatorContainer getCoordinatorRootView() {
        return this.dXB;
    }

    public View getFirstCompletelyVisibleItemSelectBtn() {
        if (this.mFragments != null && this.mFragments.size() > 0) {
            int currentItem = this.dLB.getCurrentItem();
            if (currentItem >= 0 && currentItem < this.mFragments.size()) {
                return ((AbstractPickerFragment) this.mFragments.get(currentItem)).getFirstCompletelyVisibleItemSelectBtn();
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onActivityDestory() {
        super.onActivityDestory();
        this.dXD.release();
        C8171a.reset();
        C8186b.aFr().reset();
    }

    /* access modifiers changed from: protected */
    public void onActivityResume() {
        super.onActivityResume();
        if (this.dHU) {
            aFn();
        }
    }

    public boolean onBackPressed() {
        return ((AbstractPickerFragment) this.mFragments.get(this.dLB.getCurrentItem())).onBackPressed();
    }

    /* renamed from: sT */
    public void mo33252sT(int i) {
        m23602sU(i);
        for (AbstractPickerFragment th : this.mFragments) {
            th.mo33372th(-i);
        }
    }

    /* renamed from: sW */
    public void mo33253sW(int i) {
        if (i == 0) {
            if (this.dXB.getState() != 0) {
                this.dXB.aFW();
            }
        } else if (i == 1 && this.dXB.getState() != 1) {
            this.dXB.aFX();
        }
    }

    /* renamed from: sX */
    public void mo33254sX(int i) {
        C8172a.m23621ci(getContext(), i == 28 ? "FB" : "instagram");
        this.dXE = i;
    }

    /* renamed from: sY */
    public void mo33255sY(int i) {
        this.mSourceType = i;
        for (AbstractPickerFragment al : this.mFragments) {
            al.mo33366al(i, false);
        }
    }

    public void setExternalCallback(C8189b bVar) {
        this.dXC = bVar;
        for (AbstractPickerFragment a : this.mFragments) {
            a.mo33361a(bVar);
        }
    }
}
