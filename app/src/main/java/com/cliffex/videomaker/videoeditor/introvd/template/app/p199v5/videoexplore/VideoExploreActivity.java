package com.introvd.template.app.p199v5.videoexplore;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.p021v4.widget.SwipeRefreshLayout;
import android.support.p021v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.support.p024v7.widget.LinearLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1022l;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.introvd.template.EventActivity;
import com.introvd.template.R;
import com.introvd.template.app.creation.C3821d;
import com.introvd.template.app.p199v5.common.C4420c;
import com.introvd.template.app.p199v5.common.C4420c.C4421a;
import com.introvd.template.common.behavior.UserBehaviorUtilsV5;
import com.introvd.template.common.p236ui.custom.VideoAutoPlayHelper;
import com.introvd.template.common.p236ui.custom.VideoViewModelForVideoExplore;
import com.introvd.template.common.p236ui.modechooser.ModeItemInfo;
import com.introvd.template.module.p326ad.C7680l;
import com.introvd.template.module.p326ad.p327a.C7589a;
import com.ironsource.sdk.constants.Constants.ParametersKeys;
import java.util.List;

/* renamed from: com.introvd.template.app.v5.videoexplore.VideoExploreActivity */
public class VideoExploreActivity extends EventActivity {

    /* renamed from: VC */
    private C1022l f3404VC = new C1022l() {
        int bHi;
        int bHj;

        /* renamed from: a */
        public void mo8095a(RecyclerView recyclerView, int i, int i2) {
            super.mo8095a(recyclerView, i, i2);
        }

        /* renamed from: d */
        public void mo8096d(RecyclerView recyclerView, int i) {
            super.mo8096d(recyclerView, i);
            if (i == 0) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                int findFirstCompletelyVisibleItemPosition = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
                int findLastCompletelyVisibleItemPosition = linearLayoutManager.findLastCompletelyVisibleItemPosition();
                View childAt = recyclerView.getChildAt(0);
                if (childAt != null) {
                    int[] iArr = new int[2];
                    childAt.getLocationOnScreen(iArr);
                    String str = ParametersKeys.ORIENTATION_NONE;
                    String str2 = this.bHi > findFirstVisibleItemPosition ? "down" : this.bHi < findFirstVisibleItemPosition ? "up" : this.bHj > iArr[1] ? "up" : "down";
                    if (findFirstCompletelyVisibleItemPosition == 0) {
                        str = "top";
                    } else if (findLastCompletelyVisibleItemPosition == VideoExploreActivity.this.bGZ.getDataItemCount() - 1) {
                        str = "bottom";
                    }
                    UserBehaviorUtilsV5.onEventVideoExploreScroll(VideoExploreActivity.this, str2, str);
                }
                VideoAutoPlayHelper.autoPlayVideoV2(recyclerView, findFirstVisibleItemPosition, linearLayoutManager.findLastVisibleItemPosition());
            } else if (i == 1) {
                this.bHi = ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
                View childAt2 = recyclerView.getChildAt(0);
                if (childAt2 != null) {
                    int[] iArr2 = new int[2];
                    childAt2.getLocationOnScreen(iArr2);
                    this.bHj = iArr2[1];
                }
            }
        }
    };
    protected C4420c bFg;
    protected RecyclerView bGX;
    protected C3821d bGY;
    protected C4460c bGZ;
    /* access modifiers changed from: private */
    public String bHa;
    /* access modifiers changed from: private */
    public String bHb;
    /* access modifiers changed from: private */
    public boolean bHc;
    private final int bHd = 1;
    private final int bHe = 2;
    private final int bHf = 3;
    private final int bHg = 4;
    private C4421a bkc = new C4421a() {
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    C7589a.m22360aj(VideoExploreActivity.this, 15);
                    List ce = VideoExploreActivity.this.bGY.mo23316ce(VideoExploreActivity.this);
                    int a = VideoExploreActivity.this.m11257at(ce);
                    if (a > 0) {
                        VideoExploreActivity.this.bFg.sendMessage(VideoExploreActivity.this.bFg.obtainMessage(2, a, 0));
                    } else if (!VideoExploreActivity.this.bHc) {
                        VideoExploreActivity.this.bFg.sendMessage(VideoExploreActivity.this.bFg.obtainMessage(3, a, 0));
                    }
                    VideoExploreActivity.this.bGZ.setDataList(ce);
                    VideoExploreActivity.this.bGZ.notifyDataSetChanged();
                    return;
                case 2:
                    int i = message.arg1;
                    ((LinearLayoutManager) VideoExploreActivity.this.bGX.getLayoutManager()).scrollToPositionWithOffset(i, 0);
                    VideoExploreActivity.this.bHa = null;
                    VideoExploreActivity.this.bHb = null;
                    if (!VideoExploreActivity.this.bHc) {
                        VideoExploreActivity.this.bFg.sendMessage(VideoExploreActivity.this.bFg.obtainMessage(3, i, 0));
                        return;
                    }
                    return;
                case 3:
                    VideoExploreActivity.this.bHc = true;
                    VideoAutoPlayHelper.autoPlayFirstVideo(VideoExploreActivity.this.bGX, message.arg1);
                    return;
                case 4:
                    C7589a.m22360aj(VideoExploreActivity.this, 15);
                    VideoExploreActivity.this.btY.setRefreshing(false);
                    return;
                default:
                    return;
            }
        }
    };
    protected SwipeRefreshLayout btY;

    /* access modifiers changed from: private */
    /* renamed from: at */
    public int m11257at(List<ModeItemInfo> list) {
        if (TextUtils.isEmpty(this.bHa) || TextUtils.isEmpty(this.bHb)) {
            return 0;
        }
        for (int i = 0; i < list.size(); i++) {
            ModeItemInfo modeItemInfo = (ModeItemInfo) list.get(i);
            if (!modeItemInfo.isAdvItem() && this.bHa.equals(modeItemInfo.mVideoInfo.puid)) {
                String str = this.bHb;
                StringBuilder sb = new StringBuilder();
                sb.append(modeItemInfo.mVideoInfo.mVer);
                sb.append("");
                if (str.equals(sb.toString())) {
                    return i;
                }
            }
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.bGZ != null) {
            this.bGZ.onActivityResult(i, i2, intent);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.bHa = getIntent().getStringExtra("intent_extra_key_video_puid");
        this.bHb = getIntent().getStringExtra("intent_extra_key_video_pver");
        this.bFg = new C4420c();
        this.bFg.mo24501a(this.bkc);
        setContentView(R.layout.v5_activity_videoexplore);
        this.bGY = new C3821d();
        this.bGY.mo23318cg(this);
        ((ImageView) findViewById(R.id.img_back)).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                VideoExploreActivity.this.finish();
            }
        });
        this.bGX = (RecyclerView) findViewById(R.id.recycler_view);
        this.btY = (SwipeRefreshLayout) findViewById(R.id.pull_refresh_view);
        this.btY.setOnRefreshListener(new OnRefreshListener() {
            public void onRefresh() {
                VideoViewModelForVideoExplore.getInstance(VideoExploreActivity.this, 21).resetPlayer();
                VideoExploreActivity.this.bFg.sendEmptyMessage(4);
            }
        });
        this.bGX.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.bGZ = new C4460c(this);
        this.bGX.setAdapter(this.bGZ);
        this.bGX.mo7737a(this.f3404VC);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        if (this.bGZ != null) {
            this.bGZ.mo24634do(this);
        }
        C7680l.aAe().releasePosition(15);
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        VideoViewModelForVideoExplore.getInstance(this, 21).resetPlayer();
        if (isFinishing()) {
            VideoViewModelForVideoExplore.getInstance(this, 21).release();
        }
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.bFg.sendEmptyMessage(1);
    }
}
