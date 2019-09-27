package com.introvd.template.app.videoplayer;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.aiii.android.arouter.p091c.C1919a;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.introvd.template.R;
import com.introvd.template.app.p199v5.common.p200ui.videolist.C4436b;
import com.introvd.template.app.p199v5.videoexplore.C4452a;
import com.introvd.template.app.p199v5.videoexplore.C4463d;
import com.introvd.template.app.videoplayer.VideoCardForCreationView.C4464a;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.behavior.UserBehaviorUtils;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.common.p236ui.custom.VideoAutoPlayHelper;
import com.introvd.template.common.p236ui.custom.VideoViewForCreationModel;
import com.introvd.template.common.p236ui.custom.VideoViewForCreationModel.VideoPlayControlListener;
import com.introvd.template.crash.C5523b;
import com.introvd.template.p153p.C3209a;
import com.introvd.template.p203b.C4600l;
import com.introvd.template.router.VivaRouter;
import com.introvd.template.router.community.ICommunityAPI;
import com.introvd.template.router.community.VivaCommunityRouter.FeedVideoActivityParams;
import com.quvideo.xyvideoplayer.library.p422a.C9194e;

/* renamed from: com.introvd.template.app.videoplayer.a */
public class C4465a implements C4464a {
    private int aeD;
    /* access modifiers changed from: private */
    public C4452a bHA;
    /* access modifiers changed from: private */
    public int bHI;
    /* access modifiers changed from: private */
    public VideoCardForCreationView bHT;
    /* access modifiers changed from: private */
    public C4436b bHU;
    /* access modifiers changed from: private */
    public C4463d bHV;
    /* access modifiers changed from: private */
    public C4468a bHW;
    private VideoPlayControlListener bHX = new VideoPlayControlListener() {
        public void addPlayCount() {
        }

        public void onBuffering(boolean z) {
            C4465a.this.bHT.mo24650bV(z);
            if (z && C4465a.this.bHA != null) {
                C4465a.this.bHA.mo24609Ra();
            }
            if (z && C4465a.this.bHV != null) {
                C4465a.this.bHV.mo24640Ra();
            }
        }

        public void onPauseVideo() {
            if (C4465a.this.bHV != null) {
                C4465a.this.bHV.mo24637M(C9194e.m26753hw(C4465a.this.bHT.getContext()).aOt());
            }
        }

        public void onPlayerPreReset() {
            VideoViewForCreationModel instance = VideoViewForCreationModel.getInstance(C4465a.this.bHT.getContext());
            if (C4465a.this.bHT.mo24648Ro()) {
                C4465a.this.m11321N(instance.getRealPlayDuration());
            }
            if (C4465a.this.bHV != null) {
                C4465a.this.bHV.mo24642a(C4465a.this.bHU.strPuid, C4465a.this.bHU.strPver, C4465a.this.bHI);
                C4465a.this.bHV.mo24643em(C4465a.this.bHU.bGc);
                C4465a.this.bHV.mo24637M(instance.getCurDuration());
                C4465a.this.bHV.mo24638OA();
                C4465a.this.bHV = null;
            }
        }

        public void onPlayerReset() {
            C4465a.this.bHT.mo24645Rl();
            if (C4465a.this.bHA != null) {
                C4465a.this.bHA.mo24612dj(C4465a.this.bHT.getContext());
                C4465a.this.bHA = null;
            }
        }

        public void onSeekCompletion() {
            if (C4465a.this.bHA != null) {
                C4465a.this.bHA.mo24610Rb();
            }
            if (C4465a.this.bHV != null) {
                C4465a.this.bHV.mo24641Rb();
            }
        }

        public void onVideoCompletion() {
            if (C4465a.this.bHA != null) {
                C4465a.this.bHA.onVideoCompletion();
            }
            if (C4465a.this.bHV != null) {
                C4465a.this.bHV.onVideoCompletion();
            }
            if (C4465a.this.bHU != null) {
                C4465a.this.m11321N(VideoViewForCreationModel.getInstance(C4465a.this.bHT.getContext()).getRealPlayDuration());
            }
        }

        public void onVideoStartRender() {
            C4465a.this.bHT.mo24646Rm();
            if (C4465a.this.bHA != null) {
                C4465a.this.bHA.mo24607J(VideoViewForCreationModel.getInstance(C4465a.this.bHT.getContext()).getDuration());
            }
            if (C4465a.this.bHV != null) {
                C4465a.this.bHV.mo24636J(C9194e.m26753hw(C4465a.this.bHT.getContext()).getDuration());
            }
            if (C4465a.this.bHW != null) {
                C4465a.this.bHW.mo24534a(C4465a.this);
            }
        }

        public void onViewClick() {
            if (C4465a.this.bHW == null || !C4465a.this.bHW.mo24535bW(C4465a.this.bHT)) {
                if (AppStateModel.getInstance().isCommunitySupport()) {
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("puid", C4465a.this.bHU.strPuid);
                    jsonObject.addProperty("pver", C4465a.this.bHU.strPver);
                    VivaRouter.getRouterBuilder(FeedVideoActivityParams.URL).mo10399f(FeedVideoActivityParams.EXTRA_VIDEO_TYPE_SINGLE_JSON, new Gson().toJson((JsonElement) jsonObject)).mo10406h(FeedVideoActivityParams.EXTRA_VIDEO_PAGE_FROM, C4465a.this.bHI).mo10394aZ(R.anim.activity_right_enter_translate, R.anim.activity_left_exit_translate).mo10382H(C4465a.this.bHT.getContext());
                } else {
                    C4465a.this.mo24661i(C4465a.this.bHT.getContext(), false);
                    StringBuilder sb = new StringBuilder();
                    sb.append(C4465a.this.bHU.strPuid);
                    sb.append("_");
                    sb.append(C4465a.this.bHU.strPver);
                    UserBehaviorUtils.recordMonHomeSingleVideoClick(C4465a.this.bHT.getContext(), "play", sb.toString());
                }
            }
        }
    };

    /* renamed from: com.introvd.template.app.videoplayer.a$a */
    public interface C4468a {
        /* renamed from: a */
        void mo24534a(C4465a aVar);

        /* renamed from: bW */
        boolean mo24535bW(View view);
    }

    public C4465a(int i) {
        this.bHI = i;
    }

    /* access modifiers changed from: private */
    /* renamed from: N */
    public void m11321N(long j) {
        if (this.bHU != null) {
            ICommunityAPI iCommunityAPI = (ICommunityAPI) C1919a.m5529sc().mo10356i(ICommunityAPI.class);
            if (iCommunityAPI != null) {
                iCommunityAPI.requestVideoPlay(this.bHU.strPuid, this.bHU.strPver, this.bHI, j, this.bHU.bGh, "notfollow");
            }
        }
    }

    /* renamed from: a */
    public void mo24656a(VideoCardForCreationView videoCardForCreationView) {
        this.bHT = videoCardForCreationView;
        this.bHT.setListener(this);
        this.bHT.mo24649b(this.bHU, this.aeD);
    }

    /* renamed from: a */
    public void mo24657a(C4468a aVar) {
        this.bHW = aVar;
    }

    /* renamed from: bW */
    public void mo24658bW(boolean z) {
        VideoViewForCreationModel instance = VideoViewForCreationModel.getInstance(this.bHT.getContext());
        if (z) {
            this.bHT.mo24645Rl();
        } else {
            instance.resetPlayer();
        }
        if (this.bHA != null) {
            this.bHA.mo24612dj(this.bHT.getContext());
            this.bHA = null;
        }
        if (this.bHV != null) {
            this.bHV.mo24642a(this.bHU.strPuid, this.bHU.strPver, this.bHI);
            this.bHV.mo24643em(this.bHU.bGc);
            this.bHV.mo24637M(instance.getCurDuration());
            this.bHV.mo24638OA();
            this.bHV = null;
        }
    }

    /* renamed from: bX */
    public void mo24655bX(View view) {
        if (view.getId() == R.id.xiaoying_com_info_layout && (this.bHW == null || !this.bHW.mo24535bW(view))) {
            if (AppStateModel.getInstance().isCommunitySupport()) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("puid", this.bHU.strPuid);
                jsonObject.addProperty("pver", this.bHU.strPver);
                VivaRouter.getRouterBuilder(FeedVideoActivityParams.URL).mo10399f(FeedVideoActivityParams.EXTRA_VIDEO_TYPE_SINGLE_JSON, new Gson().toJson((JsonElement) jsonObject)).mo10406h(FeedVideoActivityParams.EXTRA_VIDEO_PAGE_FROM, this.bHI).mo10394aZ(R.anim.activity_right_enter_translate, R.anim.activity_left_exit_translate).mo10382H(view.getContext());
            } else {
                mo24661i(view.getContext(), false);
                StringBuilder sb = new StringBuilder();
                sb.append(this.bHU.strPuid);
                sb.append("_");
                sb.append(this.bHU.strPver);
                UserBehaviorUtils.recordMonHomeSingleVideoClick(view.getContext(), "play", sb.toString());
            }
        }
    }

    /* renamed from: c */
    public void mo24659c(C4436b bVar, int i) {
        this.bHU = bVar;
        this.aeD = i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: dl */
    public void mo24660dl(Context context) {
        VideoViewForCreationModel instance = VideoViewForCreationModel.getInstance(context);
        if (this.bHT.mo24648Ro()) {
            if (!instance.isVideoPlaying()) {
                instance.startVideo();
            }
            return;
        }
        instance.resetPlayer();
        instance.setListener(this.bHX);
        instance.setVideoView(this.bHT.getVideoView());
        this.bHT.mo24647Rn();
        if (this.bHU != null && !TextUtils.isEmpty(this.bHU.bGc)) {
            if (this.bHA == null) {
                this.bHA = new C4452a("home");
            }
            C4452a aVar = this.bHA;
            String str = this.bHU.strPuid;
            StringBuilder sb = new StringBuilder();
            sb.append(this.bHU.strPver);
            sb.append("");
            aVar.mo24613i(str, sb.toString(), this.bHU.bGc);
            this.bHA.mo24611di(this.bHT.getContext());
            this.bHA.mo24608QZ();
            this.bHV = new C4463d();
            String str2 = this.bHU.bGc;
            if (VideoAutoPlayHelper.canAutoPlay(context)) {
                instance.setLooping(true);
            } else {
                instance.setLooping(false);
            }
            try {
                instance.setMute(C3209a.aJZ().mo18326gM(this.bHT.getContext()));
                instance.setVideoUrl(str2);
                this.bHV.mo24639QZ();
                instance.startVideo();
            } catch (IllegalStateException e) {
                C5523b.logException(e);
            }
        }
    }

    /* renamed from: i */
    public void mo24661i(final Context context, boolean z) {
        if (!C4600l.m11739k(context, true)) {
            ToastUtils.show(context.getApplicationContext(), R.string.xiaoying_str_com_msg_network_inactive, 1);
            return;
        }
        if (z) {
            mo24660dl(context);
        } else if (!VideoAutoPlayHelper.canAutoPlay(context)) {
            VideoAutoPlayHelper.showAutoPlayDialog(context, new OnClickListener() {
                public void onClick(View view) {
                    C4465a.this.mo24660dl(context);
                }
            });
        } else {
            VideoAutoPlayHelper.show4GPlayToast(context);
            mo24660dl(context);
        }
    }

    public boolean isPlaying() {
        return this.bHT.mo24648Ro() && VideoViewForCreationModel.getInstance(this.bHT.getContext()).isVideoPlaying();
    }

    public void release() {
    }

    public void resetPlayer() {
        VideoViewForCreationModel.getInstance(this.bHT.getContext()).resetPlayer();
    }
}
