package com.introvd.template.component.videofetcher.view;

import android.content.Context;
import android.support.p024v7.widget.C1108an;
import android.support.p024v7.widget.LinearLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1018h;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import com.introvd.template.component.videofetcher.p238b.C5366a;
import com.introvd.template.component.videofetcher.p239c.C5391a;
import com.introvd.template.component.videofetcher.p240d.C5409f;
import com.introvd.template.component.videofetcher.utils.C5486d;
import java.util.List;
import org.greenrobot.eventbus.C10021c;
import org.greenrobot.eventbus.C10031j;
import org.greenrobot.eventbus.ThreadMode;

public class VideoDownloadRecyclerView extends RecyclerView {
    /* access modifiers changed from: private */
    public C5409f cjk;
    private C5366a cnn;

    public VideoDownloadRecyclerView(Context context) {
        super(context);
        aaJ();
    }

    public VideoDownloadRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        aaJ();
    }

    public VideoDownloadRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        aaJ();
    }

    private void aaJ() {
        this.cnn = new C5366a(getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        ((C1108an) getItemAnimator()).mo8798am(false);
        mo7733a((C1018h) new C5506d(getContext()));
        setLayoutManager(linearLayoutManager);
        setAdapter(this.cnn);
        this.cnn.setItemClickListener(new C5409f() {
            /* renamed from: a */
            public void mo27036a(int i, FetcherRoundView fetcherRoundView, C5391a aVar) {
                if (VideoDownloadRecyclerView.this.cjk != null) {
                    VideoDownloadRecyclerView.this.cjk.mo27036a(i, fetcherRoundView, aVar);
                }
            }
        });
    }

    /* renamed from: aC */
    public void mo27212aC(List<C5391a> list) {
        if (this.cnn != null) {
            this.cnn.mo26937aC(list);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        C10021c.aZH().mo38494ax(this);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (C10021c.aZH().mo38495ay(this)) {
            C10021c.aZH().mo38496az(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, MeasureSpec.makeMeasureSpec(C5486d.m14894O(getContext(), 300), Integer.MIN_VALUE));
    }

    @C10031j(aZK = ThreadMode.MAIN, aZL = true)
    public void onProgress(C5391a aVar) {
        boolean z = aVar.state == 9;
        if (this.cnn != null && z) {
            this.cnn.mo26938b(aVar.getName(), Long.valueOf(aVar.ckb));
        }
    }

    public void setItemClickListener(C5409f fVar) {
        this.cjk = fVar;
    }
}
