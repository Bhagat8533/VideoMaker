package com.introvd.template.app.school.view;

import android.arch.lifecycle.C0061e.C0062a;
import android.arch.lifecycle.C0068f;
import android.arch.lifecycle.C0078n;
import android.content.Context;
import android.support.p024v7.widget.LinearLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1022l;
import android.util.AttributeSet;
import com.introvd.template.R;
import com.introvd.template.app.school.C4191j;
import com.introvd.template.app.school.p196b.C4166f;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.p203b.C4600l;
import org.greenrobot.eventbus.C10021c;
import org.greenrobot.eventbus.C10031j;
import org.greenrobot.eventbus.ThreadMode;

public class SchoolVideoListView extends RecyclerView implements C0068f {
    /* access modifiers changed from: private */
    public C4279h bAF;
    /* access modifiers changed from: private */
    public int bAG = -1;
    /* access modifiers changed from: private */
    public int pageNum;
    /* access modifiers changed from: private */
    public int totalCount;

    public SchoolVideoListView(Context context) {
        super(context);
        init();
    }

    public SchoolVideoListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public SchoolVideoListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        this.bAF = new C4279h();
        setAdapter(this.bAF);
        mo7737a((C1022l) new C1022l() {
            /* renamed from: d */
            public void mo8096d(RecyclerView recyclerView, int i) {
                if (i == 0) {
                    int dataItemCount = SchoolVideoListView.this.bAF.getDataItemCount() - 5;
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                    if (linearLayoutManager != null) {
                        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                        if (dataItemCount > 0 && findLastVisibleItemPosition >= dataItemCount) {
                            if (!C4600l.m11739k(SchoolVideoListView.this.getContext(), false)) {
                                ToastUtils.show(SchoolVideoListView.this.getContext(), R.string.xiaoying_str_com_msg_network_inactive, 0);
                                SchoolVideoListView.this.bAF.mo24301hy(0);
                            } else if (SchoolVideoListView.this.bAF.getDataItemCount() < SchoolVideoListView.this.totalCount) {
                                C4191j.m10442Nv().mo24158bG(SchoolVideoListView.this.bAG, SchoolVideoListView.this.pageNum + 1);
                            }
                        }
                    }
                }
            }
        });
    }

    /* renamed from: Kp */
    public void mo24283Kp() {
        C4191j.m10442Nv().mo24158bG(this.bAG, 1);
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
    public void onEventMainThread(C4166f fVar) {
        if (fVar != null && fVar.getLabelId() == this.bAG && !fVar.getDataList().isEmpty()) {
            this.pageNum = fVar.getPageNum();
            if (this.pageNum == 1) {
                this.totalCount = fVar.mo23995Oi();
            }
            this.bAF.mo24301hy(fVar.getDataList().size() >= this.totalCount ? 6 : 2);
            this.bAF.mo36114dh(fVar.getDataList());
        }
    }

    /* renamed from: v */
    public void mo24287v(int i, boolean z) {
        this.bAG = i;
        mo24283Kp();
        this.bAF.setIsFromCreatePage(z);
    }
}
