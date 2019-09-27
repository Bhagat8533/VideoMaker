package com.introvd.template.app.school.view;

import android.arch.lifecycle.C0061e;
import android.arch.lifecycle.C0061e.C0062a;
import android.arch.lifecycle.C0068f;
import android.arch.lifecycle.C0078n;
import android.content.Context;
import android.support.p021v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.View;
import com.introvd.template.app.school.api.model.VideoLabelInfo;
import com.introvd.template.app.school.p196b.C4167g;
import com.introvd.template.app.school.p196b.C4168h;
import com.introvd.template.common.p236ui.XYViewPager;
import com.introvd.template.xyui.viewpager.ListViewPagerAdapter;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.C10021c;
import org.greenrobot.eventbus.C10031j;
import org.greenrobot.eventbus.ThreadMode;

public class SchoolVideoListViewPager extends XYViewPager implements C0068f {
    private ArrayList<View> bAI;
    private boolean byW;

    public SchoolVideoListViewPager(Context context) {
        super(context);
        setBackgroundColor(-1);
    }

    public SchoolVideoListViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* renamed from: ae */
    private void m10719ae(List<VideoLabelInfo> list) {
        if (getContext() instanceof FragmentActivity) {
            C0061e lifecycle = ((FragmentActivity) getContext()).getLifecycle();
            ArrayList<View> arrayList = new ArrayList<>();
            for (VideoLabelInfo videoLabelInfo : list) {
                SchoolVideoListView schoolVideoListView = new SchoolVideoListView(getContext());
                schoolVideoListView.mo24287v(videoLabelInfo.getId().intValue(), this.byW);
                lifecycle.mo152a(schoolVideoListView);
                arrayList.add(schoolVideoListView);
            }
            this.bAI = arrayList;
            setAdapter(new ListViewPagerAdapter(this.bAI));
        }
    }

    /* renamed from: OL */
    public void mo24288OL() {
        View curPageView = getCurPageView();
        if (curPageView instanceof SchoolVideoListView) {
            ((SchoolVideoListView) curPageView).mo24283Kp();
        }
    }

    public View getCurPageView() {
        int currentItem = getCurrentItem();
        if (this.bAI == null || currentItem >= this.bAI.size()) {
            return null;
        }
        return (View) this.bAI.get(currentItem);
    }

    @C0078n(mo161n = C0062a.ON_CREATE)
    public void onCreate() {
        if (!C10021c.aZH().mo38495ay(this)) {
            C10021c.aZH().mo38494ax(this);
        }
    }

    @C0078n(mo161n = C0062a.ON_DESTROY)
    public void onDestroy() {
        C10021c.aZH().mo38496az(this);
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onEventMainThread(C4167g gVar) {
        setCurrentItem(gVar.getIndex(), true);
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onEventMainThread(C4168h hVar) {
        if (hVar != null && !hVar.getDataList().isEmpty()) {
            m10719ae(hVar.getDataList());
        }
    }

    public void setIsFromCreatePage(boolean z) {
        this.byW = z;
    }
}
