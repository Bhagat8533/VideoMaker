package com.introvd.template.app.p199v5.common.p200ui.videolist;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.introvd.template.app.videoplayer.C4465a;
import com.introvd.template.common.behavior.UserBehaviorUtils;
import com.introvd.template.common.behavior.UserBehaviorUtilsV5;
import com.introvd.template.common.p236ui.custom.VideoAutoPlayHelper;
import com.introvd.template.common.p236ui.custom.VideoViewForCreationModel;
import com.ironsource.sdk.constants.Constants.ParametersKeys;

/* renamed from: com.introvd.template.app.v5.common.ui.videolist.CreationListView */
public class CreationListView extends ListView {
    private int bFO;
    /* access modifiers changed from: private */
    public int bFP;
    /* access modifiers changed from: private */
    public int bFQ;
    /* access modifiers changed from: private */
    public int bFR;
    /* access modifiers changed from: private */
    public int bFS;
    /* access modifiers changed from: private */
    public int bFT;
    /* access modifiers changed from: private */
    public int bFU;
    /* access modifiers changed from: private */
    public String bFV;
    /* access modifiers changed from: private */
    public C4423a bFW;
    /* access modifiers changed from: private */
    public C4424b bFX;
    /* access modifiers changed from: private */
    public String bFs;
    /* access modifiers changed from: private */
    public String bFt;
    /* access modifiers changed from: private */
    public C4426a bvt;

    /* renamed from: com.introvd.template.app.v5.common.ui.videolist.CreationListView$a */
    public interface C4423a {
        /* renamed from: Nd */
        void mo23731Nd();

        /* renamed from: bD */
        void mo23732bD(boolean z);
    }

    /* renamed from: com.introvd.template.app.v5.common.ui.videolist.CreationListView$b */
    public interface C4424b {
        /* renamed from: QY */
        void mo24516QY();
    }

    /* renamed from: com.introvd.template.app.v5.common.ui.videolist.CreationListView$c */
    private class C4425c implements Comparable<C4425c> {
        boolean bFZ = false;
        int bGa = -1;
        int position;

        public C4425c(int i, boolean z, int i2) {
            this.bGa = i;
            this.bFZ = z;
            this.position = i2;
        }

        /* renamed from: a */
        public int compareTo(C4425c cVar) {
            int i = cVar.bFZ ? -1 : 0;
            if (this.bFZ) {
                i = 1;
            }
            return (!this.bFZ || !cVar.bFZ) ? i : this.bGa - cVar.bGa;
        }
    }

    public CreationListView(Context context) {
        this(context, null);
    }

    public CreationListView(final Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.bFO = Integer.MAX_VALUE;
        this.bFP = 0;
        this.bFQ = 0;
        this.bFR = -1;
        this.bFS = -1;
        this.bFT = 10;
        this.bFU = 0;
        setOnScrollListener(new OnScrollListener() {
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                int i4 = i2 - 1;
                if (absListView.getChildCount() > i4 && i2 > 0) {
                    View childAt = absListView.getChildAt(0);
                    View childAt2 = absListView.getChildAt(i4);
                    if (i == 0 && childAt.getTop() == 0) {
                        CreationListView.this.bFt = "top";
                    } else if (i2 + i != i3 || childAt2.getBottom() > CreationListView.this.bFS + 10) {
                        CreationListView.this.bFt = ParametersKeys.ORIENTATION_NONE;
                    } else {
                        CreationListView.this.bFt = "bottom";
                    }
                    if (CreationListView.this.bFP > i) {
                        CreationListView.this.bFs = "down";
                    } else if (CreationListView.this.bFP < i) {
                        CreationListView.this.bFs = "up";
                    } else {
                        int top = childAt.getTop();
                        if (CreationListView.this.bFQ + CreationListView.this.bFT < top) {
                            CreationListView.this.bFs = "down";
                        } else if (CreationListView.this.bFQ - CreationListView.this.bFT > top) {
                            CreationListView.this.bFs = "up";
                        }
                    }
                    if (CreationListView.this.bFX != null && "up".equals(CreationListView.this.bFs)) {
                        CreationListView.this.bFX.mo24516QY();
                    }
                    CreationListView.this.bFP = i;
                    CreationListView.this.bFQ = childAt.getTop();
                }
                if (CreationListView.this.bFW != null) {
                    CreationListView.this.bFW.mo23732bD(CreationListView.this.m11169hS(i));
                    View childAt3 = absListView.getChildAt(0);
                    if (childAt3 != null) {
                        if (CreationListView.this.bFU != childAt3.getTop()) {
                            CreationListView.this.bFW.mo23731Nd();
                        }
                        CreationListView.this.bFU = childAt3.getTop();
                    }
                }
            }

            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    if (CreationListView.this.bFR < 0 || CreationListView.this.bFS < 0) {
                        CreationListView.this.bFR = CreationListView.this.getTop();
                        CreationListView.this.bFS = CreationListView.this.getBottom();
                    }
                    int firstVisiblePosition = CreationListView.this.getFirstVisiblePosition();
                    int lastVisiblePosition = CreationListView.this.getLastVisiblePosition();
                    C4425c cVar = null;
                    boolean z = false;
                    for (int i2 = 0; i2 <= lastVisiblePosition - firstVisiblePosition; i2++) {
                        View childAt = CreationListView.this.getChildAt(i2);
                        int headerViewsCount = (i2 + firstVisiblePosition) - CreationListView.this.getHeaderViewsCount();
                        C4425c a = CreationListView.this.m11174u(childAt, headerViewsCount);
                        if (cVar == null || cVar.compareTo(a) < 0) {
                            cVar = a;
                        }
                        C4465a hQ = CreationListView.this.bvt.mo24527hQ(headerViewsCount);
                        if (!(childAt == null || hQ == null)) {
                            if (VideoAutoPlayHelper.isInAutoPlayArea(childAt)) {
                                if ("Home_Video_Scroll".equals(CreationListView.this.bFV) ? VideoAutoPlayHelper.isCreationVideoAutoPlayEnable() : VideoAutoPlayHelper.isExportedVideoAutoPlayEnable()) {
                                    hQ.mo24661i(CreationListView.this.getContext(), true);
                                    z = true;
                                }
                            } else {
                                hQ.mo24658bW(true);
                            }
                        }
                    }
                    if (cVar != null && !TextUtils.isEmpty(CreationListView.this.bFs) && !TextUtils.isEmpty(CreationListView.this.bFt)) {
                        int i3 = cVar.position;
                        if ("bottom".equals(CreationListView.this.bFt)) {
                            i3 = CreationListView.this.bvt.getCount() - 1;
                        }
                        UserBehaviorUtils.recordMonHOrRScroll(context, CreationListView.this.bFs, CreationListView.this.bFt, CreationListView.this.bvt.mo24526hO(i3), CreationListView.this.bFV);
                        UserBehaviorUtilsV5.onEventHomeScroll(CreationListView.this.getContext(), CreationListView.this.bFs);
                    }
                    if (!z) {
                        VideoViewForCreationModel.getInstance(absListView.getContext()).resetPlayer();
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: hS */
    public boolean m11169hS(int i) {
        return i > this.bFO;
    }

    /* access modifiers changed from: private */
    /* renamed from: u */
    public C4425c m11174u(View view, int i) {
        int i2;
        if (view == null) {
            return null;
        }
        int top = view.getTop();
        int bottom = view.getBottom();
        boolean z = false;
        if (top < this.bFR) {
            i2 = bottom - getTop();
        } else if (bottom > this.bFS) {
            i2 = this.bFS - top;
        } else {
            z = true;
            i2 = view.getHeight();
        }
        return new C4425c(i2, z, i);
    }

    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter instanceof C4426a) {
            this.bvt = (C4426a) listAdapter;
        }
        super.setAdapter(listAdapter);
    }

    public void setOnOffsetTopListener(C4423a aVar) {
        this.bFW = aVar;
    }

    public void setOnScrollUpListener(C4424b bVar) {
        this.bFX = bVar;
    }

    public void setScrollEventId(String str) {
        this.bFV = str;
    }

    public void setThresholdPage(int i) {
        this.bFO = (int) (((float) (i > 0 ? i - 1 : 0)) * 2.5f);
    }
}
