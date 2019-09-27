package com.introvd.template.component.videofetcher.p241ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.Video.Media;
import android.support.p021v4.app.Fragment;
import android.support.p021v4.widget.SwipeRefreshLayout;
import android.support.p021v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1018h;
import android.support.p024v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.introvd.template.component.videofetcher.C5355a;
import com.introvd.template.component.videofetcher.C5402d;
import com.introvd.template.component.videofetcher.R;
import com.introvd.template.component.videofetcher.dao.C5412b;
import com.introvd.template.component.videofetcher.dao.C5414c;
import com.introvd.template.component.videofetcher.p238b.C5369b;
import com.introvd.template.component.videofetcher.p239c.C5391a;
import com.introvd.template.component.videofetcher.p239c.C5393c;
import com.introvd.template.component.videofetcher.p239c.C5395e;
import com.introvd.template.component.videofetcher.p239c.C5398h;
import com.introvd.template.component.videofetcher.p240d.C5403a;
import com.introvd.template.component.videofetcher.utils.C5488f;
import com.introvd.template.component.videofetcher.utils.C5489g;
import com.introvd.template.component.videofetcher.utils.C5492i;
import com.introvd.template.component.videofetcher.view.C5502a;
import com.introvd.template.component.videofetcher.view.C5508f;
import com.introvd.template.component.videofetcher.view.C5508f.C5511a;
import com.introvd.template.component.videofetcher.view.VideoUploadListView;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.C10021c;
import org.greenrobot.eventbus.C10031j;
import org.greenrobot.eventbus.ThreadMode;
import p037b.p050b.C1834l;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p057e.C1517e;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.component.videofetcher.ui.DownloadFragment */
public class DownloadFragment extends Fragment {
    private View btV;
    protected TextView ckR;
    private ImageView ckS;
    /* access modifiers changed from: private */
    public RecyclerView ckT;
    /* access modifiers changed from: private */
    public LinearLayout ckU;
    private RelativeLayout ckV;
    /* access modifiers changed from: private */
    public C5369b ckW;
    /* access modifiers changed from: private */
    public List<C5391a> ckX;
    /* access modifiers changed from: private */
    public List<C5391a> ckY;
    /* access modifiers changed from: private */
    public TextView ckZ;
    /* access modifiers changed from: private */
    public SwipeRefreshLayout cla;
    /* access modifiers changed from: private */
    public boolean isDownloading;

    /* renamed from: Oj */
    private void m14760Oj() {
        this.ckX = new ArrayList();
        this.ckR = (TextView) this.btV.findViewById(R.id.fetcher_title);
        this.ckS = (ImageView) this.btV.findViewById(R.id.fetcher_back);
        this.ckT = (RecyclerView) this.btV.findViewById(R.id.donwload_recycle);
        this.ckU = (LinearLayout) this.btV.findViewById(R.id.download_empty);
        this.ckZ = (TextView) this.btV.findViewById(R.id.download_tips);
        this.cla = (SwipeRefreshLayout) this.btV.findViewById(R.id.download_swiperefresh);
        this.ckR.setText(getResources().getString(R.string.video_fetcher_str_tab_download));
        this.ckV = (RelativeLayout) this.btV.findViewById(R.id.download_layout);
        LayoutParams layoutParams = new LayoutParams(-1, -2);
        VideoUploadListView videoUploadListView = new VideoUploadListView(getActivity());
        if (videoUploadListView.getParent() != null) {
            ((ViewGroup) videoUploadListView.getParent()).removeView(videoUploadListView);
        }
        this.ckV.addView(videoUploadListView, layoutParams);
        this.ckT.setLayoutManager(new StaggeredGridLayoutManager(2, 1));
        if (getActivity() != null) {
            this.ckW = new C5369b(getActivity().getApplicationContext());
            this.ckT.mo7733a((C1018h) new C5502a());
            this.ckT.setAdapter(this.ckW);
        }
        this.ckS.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (!DownloadFragment.this.isHidden() && DownloadFragment.this.getActivity() != null) {
                    DownloadFragment.this.getActivity().finish();
                }
            }
        });
        this.ckW.mo26943a((C5403a<C5391a>) new C5403a<C5391a>() {
            /* renamed from: b */
            public void mo27031c(int i, C5391a aVar) {
                if (DownloadFragment.this.getActivity() != null) {
                    C5402d.m14716ZG().mo27029a(DownloadFragment.this.getActivity().getApplicationContext(), "Video_Downloader_MyVideo_Video_Click", new HashMap());
                }
                DownloadFragment.this.m14761a(i, aVar);
            }
        });
        this.cla.setOnRefreshListener(new OnRefreshListener() {
            public void onRefresh() {
                DownloadFragment.this.aak();
            }
        });
        aak();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m14761a(final int i, final C5391a aVar) {
        if (getActivity() != null) {
            final C5508f fVar = new C5508f(getActivity());
            fVar.mo27225a((C5511a) new C5511a() {
                public void aan() {
                    C5489g.m14902d("ruomiz", aVar.filePath);
                    if (C5488f.m14899fN(aVar.filePath)) {
                        try {
                            C5488f.deleteFile(aVar.filePath);
                            DownloadFragment.m14765av(DownloadFragment.this.getActivity(), aVar.filePath);
                            DownloadFragment.this.m14766aw(DownloadFragment.this.getActivity(), aVar.filePath);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    C5414c aaa = C5412b.m14731ZZ().aaa();
                    if (!TextUtils.isEmpty(aVar.getName())) {
                        aaa.mo27042fF(aVar.getName());
                    }
                    if (DownloadFragment.this.ckX != null && DownloadFragment.this.ckX.contains(aVar)) {
                        if (i < DownloadFragment.this.ckY.size()) {
                            DownloadFragment.this.ckX.remove(aVar);
                            DownloadFragment.this.ckW.notifyItemRemoved(i);
                        } else {
                            DownloadFragment.this.ckX.remove(aVar);
                            DownloadFragment.this.ckW.notifyDataSetChanged();
                        }
                        if (DownloadFragment.this.ckX.isEmpty()) {
                            DownloadFragment.this.ckZ.setVisibility(8);
                            DownloadFragment.this.ckT.setVisibility(8);
                            DownloadFragment.this.ckU.setVisibility(0);
                        }
                    }
                    fVar.dismiss();
                }

                public void aao() {
                    if (DownloadFragment.this.getActivity() != null) {
                        ShareActivity.m14793b(DownloadFragment.this.getActivity(), aVar.getFilePath(), 17, aVar.thumbnailPath);
                    }
                    fVar.dismiss();
                }
            });
            fVar.show();
        }
    }

    /* access modifiers changed from: private */
    @SuppressLint({"CheckResult"})
    public void aak() {
        if (this.cla != null) {
            this.cla.setRefreshing(true);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("数据库数据--obtainLocalVideo--list--");
        sb.append(this.ckX.size());
        C5489g.m14902d("ruomiz", sb.toString());
        C1834l.m5257ah(Boolean.valueOf(true)).mo10158e(AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS, TimeUnit.MILLISECONDS).mo10157d(C1820a.aVi()).mo10152c(C1820a.aVi()).mo10161e((C1517e<? super T>) new C1517e<Boolean>() {
            /* renamed from: d */
            public void accept(Boolean bool) throws Exception {
                C5414c aaa = C5412b.m14731ZZ().aaa();
                if (aaa != null) {
                    List ZY = aaa.mo27038ZY();
                    if (ZY != null && !ZY.isEmpty()) {
                        if (DownloadFragment.this.ckX != null && !DownloadFragment.this.ckX.isEmpty()) {
                            DownloadFragment.this.ckX.clear();
                        }
                        DownloadFragment.this.ckX.addAll(ZY);
                    }
                }
            }
        }).mo10152c(C1487a.aUa()).mo10128a((C1517e<? super T>) new C1517e<Boolean>() {
            /* renamed from: d */
            public void accept(Boolean bool) throws Exception {
                if (DownloadFragment.this.cla != null && DownloadFragment.this.cla.isRefreshing()) {
                    DownloadFragment.this.cla.setRefreshing(false);
                }
                StringBuilder sb = new StringBuilder();
                sb.append("数据库数据--");
                sb.append(DownloadFragment.this.ckX.size());
                C5489g.m14902d("ruomiz", sb.toString());
                if (DownloadFragment.this.ckX != null && !DownloadFragment.this.ckX.isEmpty()) {
                    if (DownloadFragment.this.ckU != null && DownloadFragment.this.ckU.getVisibility() == 0) {
                        DownloadFragment.this.ckU.setVisibility(8);
                    }
                    if (DownloadFragment.this.ckT != null) {
                        DownloadFragment.this.ckT.setVisibility(0);
                    }
                    Collections.reverse(DownloadFragment.this.ckX);
                    if (DownloadFragment.this.ckW != null) {
                        DownloadFragment.this.ckW.mo26944aD(DownloadFragment.this.ckX);
                    }
                    DownloadFragment.this.aal();
                } else if (!DownloadFragment.this.isDownloading) {
                    C5489g.m14902d("ruomiz", "数据库数据--mDownloadEmpty--VISIBLE");
                    DownloadFragment.this.ckT.setVisibility(8);
                    DownloadFragment.this.ckU.setVisibility(0);
                }
            }
        }, (C1517e<? super Throwable>) new C1517e<Throwable>() {
            /* renamed from: m */
            public void accept(Throwable th) throws Exception {
                C5489g.m14902d("ruomiz", th.toString());
            }
        });
    }

    /* access modifiers changed from: private */
    public void aal() {
        if (C5488f.m14901fP(C5355a.ciX)) {
            C5489g.m14902d("ruomiz", "文件夹不存在删除数据库数据");
            C5414c aaa = C5412b.m14731ZZ().aaa();
            if (aaa != null) {
                aaa.deleteAll();
            }
            C5488f.deleteDirectory(C5492i.cmE);
            this.ckT.setVisibility(8);
            this.ckU.setVisibility(0);
        }
        if (this.ckX != null && !this.ckX.isEmpty()) {
            this.ckY = new ArrayList();
            for (C5391a aVar : this.ckX) {
                if (!TextUtils.isEmpty(aVar.filePath) && !C5488f.m14899fN(aVar.filePath)) {
                    C5414c aaa2 = C5412b.m14731ZZ().aaa();
                    if (aaa2 != null) {
                        aaa2.mo27042fF(aVar.getName());
                    }
                    C5488f.deleteFile(aVar.thumbnailPath);
                    this.ckY.add(aVar);
                }
            }
            if (this.ckY != null && !this.ckY.isEmpty()) {
                if (this.ckY.size() == this.ckX.size()) {
                    this.ckT.setVisibility(8);
                    this.ckU.setVisibility(0);
                    this.ckX.clear();
                } else {
                    this.ckX.removeAll(this.ckY);
                    Collections.reverse(this.ckX);
                    this.ckW.mo26944aD(this.ckX);
                }
            }
        }
    }

    /* renamed from: av */
    public static boolean m14765av(Context context, String str) {
        if (context == null) {
            return false;
        }
        String[] strArr = {str};
        context.getContentResolver().delete(Media.EXTERNAL_CONTENT_URI, "_data = ?", strArr);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: aw */
    public void m14766aw(Context context, String str) {
        if (context != null) {
            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData(Uri.fromFile(new File(str)));
            context.sendBroadcast(intent);
        }
    }

    public void aam() {
        if (getActivity() != null && !getActivity().isFinishing()) {
            getActivity().finish();
        }
    }

    @C10031j(aZK = ThreadMode.MAIN, aZL = true)
    public void onAllRemove(C5395e eVar) {
        this.isDownloading = false;
        if (this.ckZ != null && this.ckZ.getVisibility() == 0) {
            this.ckZ.setVisibility(8);
        }
        if (this.cla != null) {
            this.cla.setEnabled(true);
        }
        if (this.ckX != null && this.ckX.isEmpty() && this.ckU.getVisibility() == 8) {
            this.ckU.setVisibility(0);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.btV = layoutInflater.inflate(R.layout.fetcher_frag_donwload, viewGroup, false);
        m14760Oj();
        C10021c.aZH().mo38494ax(this);
        return this.btV;
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (C10021c.aZH().mo38495ay(this)) {
            C10021c.aZH().mo38496az(this);
        }
    }

    @C10031j(aZK = ThreadMode.MAIN, aZL = true)
    public void onDownloadAdd(C5391a aVar) {
        if (aVar.state == 8) {
            StringBuilder sb = new StringBuilder();
            sb.append("onDownloadAdd下载完成 add之前 list");
            sb.append(this.ckX.size());
            C5489g.m14902d("ruomiz", sb.toString());
            if (!this.ckX.contains(aVar) && this.ckW != null) {
                this.ckX.add(0, aVar);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onDownloadAdd下载完成 add之后");
                sb2.append(this.ckX.size());
                C5489g.m14902d("ruomiz", sb2.toString());
                this.ckW.mo26944aD(this.ckX);
            }
        }
    }

    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (!z) {
            if (this.cla != null) {
                this.cla.setRefreshing(true);
            }
            aak();
        }
    }

    @C10031j(aZK = ThreadMode.MAIN, aZL = true)
    public void onStartDownload(C5393c cVar) {
        this.isDownloading = true;
        if (this.ckU == null || this.ckX == null || this.ckX.isEmpty()) {
            C5489g.m14902d("ruomiz", "onStartDownload---GONE");
            if (this.ckU != null && this.ckU.getVisibility() == 0) {
                this.ckU.setVisibility(8);
            }
        } else {
            if (this.ckZ.getVisibility() == 8) {
                this.ckZ.setVisibility(0);
            }
            this.ckU.setVisibility(8);
        }
        if (this.cla != null) {
            this.cla.setEnabled(false);
        }
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onUpdate(C5398h hVar) {
        this.isDownloading = false;
        if (hVar != null && hVar.type == 5) {
            C5489g.m14902d("ruomiz", "downloadFragment----onUpdate-");
            if (!isHidden()) {
                aak();
            }
        }
    }
}
