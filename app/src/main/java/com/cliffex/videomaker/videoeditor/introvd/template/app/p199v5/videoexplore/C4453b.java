package com.introvd.template.app.p199v5.videoexplore;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.afollestad.materialdialogs.C1885b;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1904j;
import com.google.gson.Gson;
import com.introvd.template.R;
import com.introvd.template.app.p199v5.videoexplore.VideoExploreCardView.C4451a;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.behavior.UserBehaviorUtils;
import com.introvd.template.common.p236ui.custom.VideoAutoPlayHelper;
import com.introvd.template.common.p236ui.custom.VideoViewModelForVideoExplore;
import com.introvd.template.common.p236ui.modechooser.ModeItemInfo.VideoInfo;
import com.introvd.template.p203b.C4600l;
import com.introvd.template.p414ui.dialog.C8978m;
import com.introvd.template.router.VivaRouter;
import com.introvd.template.router.community.VideoPlayIntentInfo;
import com.introvd.template.router.community.VivaCommunityRouter.VideoPlayerActivityParams;
import com.introvd.template.router.sns.MyResolveInfo;
import com.introvd.template.router.sns.PopupVideoShareInfo.Builder;
import com.introvd.template.router.sns.PopupVideoShareInfo.OnPopupItemClickListener;
import com.introvd.template.sns.SnsShareInfo;
import com.introvd.template.sns.SnsShareManager;
import com.introvd.template.sns.SnsShareTypeUtil;
import com.introvd.template.sns.VideoShareInfo;

/* renamed from: com.introvd.template.app.v5.videoexplore.b */
public class C4453b implements C4451a {
    /* access modifiers changed from: private */
    public C4452a bHA;
    private C4459a bHB = new C4459a() {
        /* renamed from: L */
        public void mo24624L(long j) {
            VideoPlayIntentInfo videoPlayIntentInfo = new VideoPlayIntentInfo();
            videoPlayIntentInfo.videoUrl = C4453b.this.mVideoInfo.mFileUrl;
            videoPlayIntentInfo.playPosition = (long) ((int) j);
            videoPlayIntentInfo.puid = C4453b.this.mVideoInfo.puid;
            StringBuilder sb = new StringBuilder();
            sb.append(C4453b.this.mVideoInfo.mVer);
            sb.append("");
            videoPlayIntentInfo.pver = sb.toString();
            videoPlayIntentInfo.coverUrl = C4453b.this.mVideoInfo.mCoverUrl;
            videoPlayIntentInfo.webUrl = C4453b.this.mVideoInfo.mVideoPlayUrl;
            videoPlayIntentInfo.desc = C4453b.this.mVideoInfo.mDesc;
            VivaRouter.getRouterBuilder(VideoPlayerActivityParams.URL).mo10399f("extra_video_play_intent_info", new Gson().toJson((Object) videoPlayIntentInfo)).mo10406h(VideoPlayerActivityParams.EXTRA_INTENT_TYPE, 4098).mo10391a(VideoPlayerActivityParams.EXTRA_IGNORE_LOGIN, true).mo10394aZ(R.anim.activity_right_enter_translate, R.anim.activity_left_exit_translate).mo10396b((Activity) C4453b.this.bHz.getContext(), 4097);
        }

        /* renamed from: Rp */
        public void mo24625Rp() {
        }

        public void addPlayCount() {
            VideoExploreCardView b = C4453b.this.bHz;
            VideoInfo a = C4453b.this.mVideoInfo;
            long j = a.mViewCount + 1;
            a.mViewCount = j;
            b.mo24602hZ((int) j);
        }

        public void onBuffering(boolean z) {
            C4453b.this.bHz.mo24599bV(z);
            if (z && C4453b.this.bHA != null) {
                C4453b.this.bHA.mo24609Ra();
            }
        }

        public boolean onDoubleClick() {
            C4453b.this.m11291dn(C4453b.this.bHz.getContext());
            return true;
        }

        public void onPlayerPreReset() {
        }

        public void onPlayerReset() {
            C4453b.this.bHz.mo24594Rl();
            if (VERSION.SDK_INT >= 21 && C4453b.this.bHA != null) {
                C4453b.this.bHA.mo24612dj(C4453b.this.bHz.getContext());
                C4453b.this.bHA = null;
            }
        }

        public void onSeekCompletion() {
            if (C4453b.this.bHA != null) {
                C4453b.this.bHA.mo24610Rb();
            }
        }

        public void onVideoCompletion() {
            if (C4453b.this.bHA != null) {
                C4453b.this.bHA.onVideoCompletion();
            }
        }

        public void onVideoStartRender() {
            C4453b.this.bHz.mo24595Rm();
            if (C4453b.this.bHA != null) {
                C4453b.this.bHA.mo24607J(VideoViewModelForVideoExplore.getInstance(C4453b.this.bHz.getContext(), 21).getDuration());
            }
        }
    };
    /* access modifiers changed from: private */
    public VideoExploreCardView bHz;
    /* access modifiers changed from: private */
    public VideoInfo mVideoInfo;

    /* renamed from: com.introvd.template.app.v5.videoexplore.b$a */
    public interface C4459a {
        /* renamed from: L */
        void mo24624L(long j);

        /* renamed from: Rp */
        void mo24625Rp();

        void addPlayCount();

        void onBuffering(boolean z);

        boolean onDoubleClick();

        void onPlayerPreReset();

        void onPlayerReset();

        void onSeekCompletion();

        void onVideoCompletion();

        void onVideoStartRender();
    }

    /* renamed from: dk */
    private void m11289dk(final Context context) {
        VideoViewModelForVideoExplore instance = VideoViewModelForVideoExplore.getInstance(context, 21);
        if (instance != null) {
            instance.pauseVideo();
        }
        C8978m.m26349hs(context).mo10296do(R.string.xiaoying_str_com_not_interest).mo10303dv(R.string.xiaoying_str_com_cancel).mo10299dr(R.string.xiaoying_str_com_yes).mo10281a((C1904j) new C1904j() {
            public void onClick(C1890f fVar, C1885b bVar) {
                Context context = context;
                StringBuilder sb = new StringBuilder();
                sb.append(C4453b.this.mVideoInfo.puid);
                sb.append("_");
                sb.append(C4453b.this.mVideoInfo.mVer);
                UserBehaviorUtils.recordMonExploreMoreClick(context, "yes", sb.toString());
            }
        }).mo10275a((OnCancelListener) new OnCancelListener() {
            public void onCancel(DialogInterface dialogInterface) {
                Context context = context;
                StringBuilder sb = new StringBuilder();
                sb.append(C4453b.this.mVideoInfo.puid);
                sb.append("_");
                sb.append(C4453b.this.mVideoInfo.mVer);
                UserBehaviorUtils.recordMonExploreMoreClick(context, "cancel", sb.toString());
            }
        }).mo10313qu().show();
    }

    /* renamed from: dm */
    private void m11290dm(final Context context) {
        if (!C4600l.m11739k(context, true)) {
            ToastUtils.show(context.getApplicationContext(), R.string.xiaoying_str_com_msg_network_inactive, 1);
        } else if (this.mVideoInfo != null) {
            final VideoShareInfo videoShareInfo = new VideoShareInfo();
            videoShareInfo.strTitle = "";
            videoShareInfo.strDesc = this.mVideoInfo.mDesc;
            videoShareInfo.strThumbPath = this.mVideoInfo.mCoverUrl;
            videoShareInfo.strThumbUrl = this.mVideoInfo.mCoverUrl;
            videoShareInfo.strPageUrl = this.mVideoInfo.mVideoPlayUrl;
            videoShareInfo.strPuid = this.mVideoInfo.puid;
            StringBuilder sb = new StringBuilder();
            sb.append(this.mVideoInfo.mVer);
            sb.append("");
            videoShareInfo.strPver = sb.toString();
            videoShareInfo.isMyWork = false;
            videoShareInfo.needReport = false;
            videoShareInfo.ownFlag = false;
            SnsShareManager.showVideoShareDialog(context, new Builder().myResolveInfoList(SnsShareTypeUtil.getSnsInfoAppList(context, true, false, false, false)).onPopupItemClickListener(new OnPopupItemClickListener() {
                public void onItemClick(MyResolveInfo myResolveInfo) {
                    SnsShareManager.shareLink((Activity) context, myResolveInfo.snsType, new SnsShareInfo.Builder().strTitle(videoShareInfo.strTitle).strDesc(videoShareInfo.strDesc).strImgUrl(videoShareInfo.strThumbUrl).strLinkUrl(videoShareInfo.strPageUrl).build(), "tool_explore");
                    if (myResolveInfo != null) {
                        UserBehaviorUtils.recordMonExploreShareClick(context, myResolveInfo.label.toString());
                    }
                }
            }).build());
            VideoViewModelForVideoExplore instance = VideoViewModelForVideoExplore.getInstance(context, 21);
            if (instance != null) {
                instance.pauseVideo();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: dn */
    public void m11291dn(Context context) {
        String str;
        String str2 = this.mVideoInfo.puid;
        StringBuilder sb = new StringBuilder();
        sb.append(this.mVideoInfo.mVer);
        sb.append("");
        String U = VideoExploreCardView.m11262U(str2, sb.toString());
        boolean z = !TextUtils.isEmpty(AppPreferencesSetting.getInstance().getAppSettingStr(U, ""));
        this.bHz.mo24601hY(z ? 1 : 0);
        if (!z) {
            str = "like";
            AppPreferencesSetting.getInstance().setAppSettingStr(U, "liked");
        } else {
            AppPreferencesSetting.getInstance().setAppSettingStr(U, "");
            str = "unlike";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.mVideoInfo.puid);
        sb2.append("_");
        sb2.append(this.mVideoInfo.mVer);
        UserBehaviorUtils.recordMonExploreLikeClick(context, str, sb2.toString());
    }

    /* renamed from: a */
    public void mo24615a(VideoInfo videoInfo) {
        this.mVideoInfo = videoInfo;
        this.bHz.mo24598a(videoInfo);
    }

    /* renamed from: b */
    public void mo24616b(VideoExploreCardView videoExploreCardView) {
        this.bHz = videoExploreCardView;
        this.bHz.setListener(this);
    }

    /* renamed from: bW */
    public void mo24617bW(boolean z) {
        if (this.bHz != null) {
            VideoViewModelForVideoExplore instance = VideoViewModelForVideoExplore.getInstance(this.bHz.getContext(), 21);
            if (z) {
                this.bHz.mo24594Rl();
            } else {
                instance.resetPlayer();
            }
            if (VERSION.SDK_INT >= 21 && this.bHA != null) {
                this.bHA.mo24612dj(this.bHz.getContext());
                this.bHA = null;
            }
        }
    }

    /* renamed from: bX */
    public void mo24606bX(View view) {
        if (view.getId() == R.id.xiaoying_com_layout_like) {
            m11291dn(view.getContext());
        } else if (view.getId() == R.id.xiaoying_com_btn_play) {
            mo24619i(view.getContext(), false);
        } else if (view.getId() == R.id.xiaoying_com_text_share_count) {
            m11290dm(view.getContext());
        } else if (view.getId() == R.id.btn_more) {
            m11289dk(view.getContext());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: dl */
    public void mo24618dl(Context context) {
        if (!C4600l.m11739k(context, true)) {
            ToastUtils.show(context.getApplicationContext(), R.string.xiaoying_str_com_msg_network_inactive, 1);
            return;
        }
        VideoViewModelForVideoExplore instance = VideoViewModelForVideoExplore.getInstance(context, 21);
        if (this.bHz.mo24597Ro()) {
            if (!instance.isVideoPlaying()) {
                instance.startVideo();
            }
            return;
        }
        instance.resetPlayer();
        instance.setListener(this.bHB);
        instance.setVideoView(this.bHz.getVideoView());
        if (this.mVideoInfo != null && !TextUtils.isEmpty(this.mVideoInfo.mFileUrl)) {
            if (this.bHA == null) {
                this.bHA = new C4452a("explore");
            }
            C4452a aVar = this.bHA;
            String str = this.mVideoInfo.puid;
            StringBuilder sb = new StringBuilder();
            sb.append(this.mVideoInfo.mVer);
            sb.append("");
            aVar.mo24613i(str, sb.toString(), this.mVideoInfo.mFileUrl);
            this.bHA.mo24611di(this.bHz.getContext());
            this.bHA.mo24608QZ();
            this.bHz.mo24596Rn();
            VideoExploreCardView videoExploreCardView = this.bHz;
            VideoInfo videoInfo = this.mVideoInfo;
            long j = videoInfo.mViewCount + 1;
            videoInfo.mViewCount = j;
            videoExploreCardView.mo24602hZ((int) j);
            if (VideoAutoPlayHelper.canAutoPlay(context)) {
                instance.setLooping(true);
            } else {
                instance.setLooping(false);
            }
            instance.setVideoUrl(this.mVideoInfo.mFileUrl);
            instance.startVideo();
        }
    }

    /* renamed from: i */
    public void mo24619i(final Context context, boolean z) {
        if (!C4600l.m11739k(context, true)) {
            ToastUtils.show(context.getApplicationContext(), R.string.xiaoying_str_com_msg_network_inactive, 1);
            return;
        }
        if (z) {
            mo24618dl(context);
        } else if (!VideoAutoPlayHelper.canAutoPlay(context)) {
            VideoAutoPlayHelper.showAutoPlayDialog(context, new OnClickListener() {
                public void onClick(View view) {
                    C4453b.this.mo24618dl(context);
                }
            });
        } else {
            VideoAutoPlayHelper.show4GPlayToast(context);
            mo24618dl(context);
        }
    }

    public boolean isPlaying() {
        return this.bHz.mo24597Ro() && VideoViewModelForVideoExplore.getInstance(this.bHz.getContext(), 21).isVideoPlaying();
    }

    public void resetPlayer() {
        VideoViewModelForVideoExplore.getInstance(this.bHz.getContext(), 21).resetPlayer();
    }
}
