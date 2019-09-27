package com.introvd.template.component.videofetcher.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Toast;
import com.introvd.template.component.videofetcher.C5355a;
import com.introvd.template.component.videofetcher.R;
import com.introvd.template.component.videofetcher.p237a.C5357b;
import com.introvd.template.component.videofetcher.p239c.C5391a;
import com.introvd.template.component.videofetcher.p240d.C5409f;
import com.introvd.template.component.videofetcher.p240d.C5410g;
import com.introvd.template.component.videofetcher.utils.C5489g;
import com.introvd.template.component.videofetcher.utils.C5496j;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.introvd.template.component.videofetcher.view.b */
public class C5503b extends Dialog {
    private List<C5391a> cmJ;
    private VideoDownloadRecyclerView cmK;
    private C5410g cmL;

    public C5503b(Context context, List<C5391a> list) {
        super(context, R.style.fetcher_download_dialog);
        this.cmJ = list;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14935a(C5391a aVar, FetcherRoundView fetcherRoundView) {
        C5489g.m14902d("ruomiz", "开始下载dialog");
        if (!C5496j.isNetworkAvaliable(getContext())) {
            Toast.makeText(getContext(), getContext().getString(R.string.video_fetcher_str_network_unavailable), 0).show();
        }
        if (this.cmL != null) {
            this.cmL.clearAnimation();
        }
        if (isShowing()) {
            dismiss();
        }
        Toast.makeText(getContext(), getContext().getString(R.string.video_fetcher_str_start_download), 0).show();
        C5357b.m14586ZJ().mo26925a(getContext(), aVar.getName(), aVar.getAddress(), C5355a.ciX, aVar.cka, null);
    }

    private void aaG() {
        Window window = getWindow();
        LayoutParams attributes = window.getAttributes();
        window.getDecorView().setPadding(0, 0, 0, 0);
        attributes.gravity = 80;
        attributes.width = -1;
        attributes.height = -2;
        attributes.windowAnimations = R.style.dialog_anim;
        window.setAttributes(attributes);
    }

    /* renamed from: a */
    public void mo27217a(C5410g gVar) {
        this.cmL = gVar;
    }

    /* renamed from: e */
    public void mo27218e(ArrayList<C5391a> arrayList) {
        this.cmJ = arrayList;
        if (this.cmK != null) {
            this.cmK.mo27212aC(this.cmJ);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.fetcher_ppw_download);
        aaG();
        setCanceledOnTouchOutside(true);
        this.cmK = (VideoDownloadRecyclerView) findViewById(R.id.ppw_recycle);
        this.cmK.mo27212aC(this.cmJ);
        this.cmK.setItemClickListener(new C5409f() {
            /* renamed from: a */
            public void mo27036a(int i, FetcherRoundView fetcherRoundView, C5391a aVar) {
                StringBuilder sb = new StringBuilder();
                sb.append("开始下载");
                sb.append(i);
                C5489g.m14902d("ruomiz", sb.toString());
                C5503b.this.m14935a(aVar, fetcherRoundView);
            }
        });
    }
}
