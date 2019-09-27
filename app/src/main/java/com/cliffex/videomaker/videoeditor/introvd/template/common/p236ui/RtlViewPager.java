package com.introvd.template.common.p236ui;

import android.content.Context;
import android.database.DataSetObserver;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.support.p021v4.util.ArrayMap;
import android.support.p021v4.view.PagerAdapter;
import android.support.p021v4.view.ViewPager;
import android.support.p021v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.introvd.template.p203b.C4580b;
import java.util.Map;

/* renamed from: com.introvd.template.common.ui.RtlViewPager */
public class RtlViewPager extends ViewPager {
    private final Map<OnPageChangeListener, C5305c> cfN = new ArrayMap(1);
    private DataSetObserver cfO;
    /* access modifiers changed from: private */
    public boolean cfP;

    /* renamed from: com.introvd.template.common.ui.RtlViewPager$SavedState */
    public static class SavedState implements Parcelable {
        public static final ClassLoaderCreator<SavedState> CREATOR = new ClassLoaderCreator<SavedState>() {
            /* renamed from: F */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            /* renamed from: jR */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }

            /* renamed from: p */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }
        };
        Parcelable cfV;
        boolean cfW;
        int position;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            if (classLoader == null) {
                classLoader = getClass().getClassLoader();
            }
            this.cfV = parcel.readParcelable(classLoader);
            this.position = parcel.readInt();
            this.cfW = parcel.readByte() != 0;
        }

        public SavedState(Parcelable parcelable, int i, boolean z) {
            this.cfV = parcelable;
            this.position = i;
            this.cfW = z;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.cfV, i);
            parcel.writeInt(this.position);
            parcel.writeByte(this.cfW ? (byte) 1 : 0);
        }
    }

    /* renamed from: com.introvd.template.common.ui.RtlViewPager$a */
    private static class C5303a extends DataSetObserver {
        private final C5304b cfQ;

        private C5303a(C5304b bVar) {
            this.cfQ = bVar;
        }

        public void onChanged() {
            super.onChanged();
            this.cfQ.m14430Zp();
        }
    }

    /* renamed from: com.introvd.template.common.ui.RtlViewPager$b */
    private class C5304b extends C5314a {
        private int cfR;

        public C5304b(PagerAdapter pagerAdapter) {
            super(pagerAdapter);
            this.cfR = pagerAdapter.getCount();
        }

        /* access modifiers changed from: private */
        /* renamed from: Zp */
        public void m14430Zp() {
            int count = getCount();
            if (count != this.cfR) {
                RtlViewPager.this.setCurrentItemWithoutNotification(Math.max(0, this.cfR - 1));
                this.cfR = count;
            }
        }

        private int reverse(int i) {
            return (getCount() - i) - 1;
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            super.destroyItem(viewGroup, reverse(i), obj);
        }

        public int getItemPosition(Object obj) {
            int itemPosition = super.getItemPosition(obj);
            return itemPosition < 0 ? itemPosition : reverse(itemPosition);
        }

        public CharSequence getPageTitle(int i) {
            return super.getPageTitle(reverse(i));
        }

        public float getPageWidth(int i) {
            return super.getPageWidth(reverse(i));
        }

        public Object instantiateItem(ViewGroup viewGroup, int i) {
            return super.instantiateItem(viewGroup, reverse(i));
        }

        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            super.setPrimaryItem(viewGroup, (this.cfR - i) - 1, obj);
        }
    }

    /* renamed from: com.introvd.template.common.ui.RtlViewPager$c */
    private class C5305c implements OnPageChangeListener {
        private final OnPageChangeListener cfT;
        private int cfU;

        private C5305c(OnPageChangeListener onPageChangeListener) {
            this.cfT = onPageChangeListener;
            this.cfU = -1;
        }

        private int reverse(int i) {
            PagerAdapter adapter = RtlViewPager.this.getAdapter();
            return adapter == null ? i : (adapter.getCount() - i) - 1;
        }

        public void onPageScrollStateChanged(int i) {
            if (!RtlViewPager.this.cfP) {
                this.cfT.onPageScrollStateChanged(i);
            }
        }

        public void onPageScrolled(int i, float f, int i2) {
            if (!RtlViewPager.this.cfP) {
                int i3 = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
                if (i3 == 0 && i2 == 0) {
                    this.cfU = reverse(i);
                } else {
                    this.cfU = reverse(i + 1);
                }
                OnPageChangeListener onPageChangeListener = this.cfT;
                int i4 = this.cfU;
                if (i3 > 0) {
                    f = 1.0f - f;
                }
                onPageChangeListener.onPageScrolled(i4, f, i2);
            }
        }

        public void onPageSelected(int i) {
            if (!RtlViewPager.this.cfP) {
                this.cfT.onPageSelected(reverse(i));
            }
        }
    }

    public RtlViewPager(Context context) {
        super(context);
    }

    public RtlViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* renamed from: Zo */
    private void m14422Zo() {
        PagerAdapter adapter = super.getAdapter();
        if ((adapter instanceof C5304b) && this.cfO != null) {
            adapter.unregisterDataSetObserver(this.cfO);
            this.cfO = null;
        }
    }

    /* renamed from: a */
    private void m14423a(PagerAdapter pagerAdapter) {
        if ((pagerAdapter instanceof C5304b) && this.cfO == null) {
            C5304b bVar = (C5304b) pagerAdapter;
            this.cfO = new C5303a(bVar);
            pagerAdapter.registerDataSetObserver(this.cfO);
            bVar.m14430Zp();
        }
    }

    /* renamed from: jQ */
    private int m14426jQ(int i) {
        if (i < 0 || !isRtl()) {
            return i;
        }
        PagerAdapter adapter = getAdapter();
        return adapter == null ? 0 : (adapter.getCount() - i) - 1;
    }

    /* access modifiers changed from: private */
    public void setCurrentItemWithoutNotification(int i) {
        this.cfP = true;
        setCurrentItem(i, false);
        this.cfP = false;
    }

    public void addOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        if (isRtl()) {
            OnPageChangeListener cVar = new C5305c(onPageChangeListener);
            this.cfN.put(onPageChangeListener, cVar);
            onPageChangeListener = cVar;
        }
        super.addOnPageChangeListener(onPageChangeListener);
    }

    public void fakeDragBy(float f) {
        if (!isRtl()) {
            f = -f;
        }
        super.fakeDragBy(f);
    }

    public PagerAdapter getAdapter() {
        PagerAdapter adapter = super.getAdapter();
        return adapter instanceof C5304b ? ((C5304b) adapter).mo26718Zn() : adapter;
    }

    public int getCurrentItem() {
        return m14426jQ(super.getCurrentItem());
    }

    /* access modifiers changed from: protected */
    public boolean isRtl() {
        return C4580b.m11666qi();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m14423a(super.getAdapter());
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        m14422Zo();
        super.onDetachedFromWindow();
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.cfV);
        if (savedState.cfW != isRtl()) {
            setCurrentItem(savedState.position, false);
        }
    }

    public Parcelable onSaveInstanceState() {
        return new SavedState(super.onSaveInstanceState(), getCurrentItem(), isRtl());
    }

    public void removeOnPageChangeListener(OnPageChangeListener onPageChangeListener) {
        if (isRtl()) {
            onPageChangeListener = (OnPageChangeListener) this.cfN.remove(onPageChangeListener);
        }
        super.removeOnPageChangeListener(onPageChangeListener);
    }

    public void setAdapter(PagerAdapter pagerAdapter) {
        m14422Zo();
        boolean z = pagerAdapter != null && isRtl();
        if (z) {
            PagerAdapter bVar = new C5304b(pagerAdapter);
            m14423a(bVar);
            pagerAdapter = bVar;
        }
        super.setAdapter(pagerAdapter);
        if (z) {
            setCurrentItemWithoutNotification(0);
        }
    }

    public void setCurrentItem(int i) {
        super.setCurrentItem(m14426jQ(i));
    }

    public void setCurrentItem(int i, boolean z) {
        super.setCurrentItem(m14426jQ(i), z);
    }

    public boolean validateDatasetObserver() {
        if (!(super.getAdapter() instanceof C5304b)) {
            return false;
        }
        ((C5304b) super.getAdapter()).mo26717Zm();
        return true;
    }
}
