package com.introvd.template.component.videofetcher.view;

import android.app.Activity;
import android.content.Context;
import android.support.p024v7.widget.C1108an;
import android.support.p024v7.widget.RecyclerView;
import android.util.AttributeSet;
import com.introvd.template.component.videofetcher.p238b.C5381e;
import com.introvd.template.component.videofetcher.p239c.C5392b;
import com.introvd.template.component.videofetcher.p239c.C5393c;
import org.greenrobot.eventbus.C10021c;
import org.greenrobot.eventbus.C10031j;
import org.greenrobot.eventbus.ThreadMode;

public class VideoUploadListView extends RecyclerView {
    private C5381e cnp;

    public VideoUploadListView(Context context) {
        super(context);
        aaJ();
    }

    public VideoUploadListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        aaJ();
    }

    public VideoUploadListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        aaJ();
    }

    private void aaJ() {
        this.cnp = new C5381e((Activity) getContext(), getContext().getApplicationContext());
        ((C1108an) getItemAnimator()).mo8798am(false);
        DownloadLayoutManager downloadLayoutManager = new DownloadLayoutManager(getContext());
        downloadLayoutManager.setOrientation(1);
        setLayoutManager(downloadLayoutManager);
        setAdapter(this.cnp);
    }

    @C10031j(aZK = ThreadMode.MAIN, aZL = true)
    public void onAddDownloadItemEvent(C5393c cVar) {
        if (this.cnp != null) {
            this.cnp.mo26962e(cVar);
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
        C10021c.aZH().mo38496az(this);
    }

    @C10031j(aZK = ThreadMode.MAIN, aZL = true)
    public void onDownloadProgressEvent(C5392b bVar) {
        if (this.cnp != null) {
            this.cnp.mo26961b(bVar.name, bVar.progress, bVar.state);
        }
    }
}
