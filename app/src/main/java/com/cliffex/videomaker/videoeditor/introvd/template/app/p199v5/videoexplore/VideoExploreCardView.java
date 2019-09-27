package com.introvd.template.app.p199v5.videoexplore;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.introvd.template.R;
import com.introvd.template.app.p199v5.common.p200ui.videolist.C4436b;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.Constants;
import com.introvd.template.common.imageloader.ImageLoader;
import com.introvd.template.common.p236ui.modechooser.ModeItemInfo.VideoInfo;
import com.introvd.template.datacenter.SocialServiceDef;

/* renamed from: com.introvd.template.app.v5.videoexplore.VideoExploreCardView */
public class VideoExploreCardView extends RelativeLayout {
    private OnClickListener acD = new OnClickListener() {
        public void onClick(View view) {
            if (VideoExploreCardView.this.bHx != null) {
                VideoExploreCardView.this.bHx.mo24606bX(view);
            }
        }
    };
    private ImageView bGv;
    private ImageView bHk;
    private ToolVideoView bHl;
    private TextView bHm;
    private View bHn;
    private ImageView bHo;
    private TextView bHp;
    private ImageView bHq;
    private TextView bHr;
    private ImageView bHs;
    private ProgressBar bHt;
    private RelativeLayout bHu;
    private ImageView bHv;
    private AnimationSet bHw;
    /* access modifiers changed from: private */
    public C4451a bHx;

    /* renamed from: com.introvd.template.app.v5.videoexplore.VideoExploreCardView$a */
    public interface C4451a {
        /* renamed from: bX */
        void mo24606bX(View view);
    }

    public VideoExploreCardView(Context context) {
        super(context);
        m11261Iu();
    }

    public VideoExploreCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11261Iu();
    }

    public VideoExploreCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11261Iu();
    }

    /* renamed from: Iu */
    private void m11261Iu() {
        inflate(getContext(), R.layout.v5_video_explore_card_item_layout, this);
        this.bHk = (ImageView) findViewById(R.id.xiaoying_com_img_video_thumb);
        this.bHu = (RelativeLayout) findViewById(R.id.xiaoying_com_thumb_layout);
        this.bGv = (ImageView) findViewById(R.id.xiaoying_com_btn_play);
        this.bHl = (ToolVideoView) findViewById(R.id.xiaoying_com_video_view_layout);
        this.bHm = (TextView) findViewById(R.id.xiaoying_com_text_video_desc);
        this.bHn = findViewById(R.id.xiaoying_com_layout_like);
        this.bHp = (TextView) findViewById(R.id.xiaoying_com_text_like_count);
        this.bHo = (ImageView) findViewById(R.id.img_like);
        this.bHq = (ImageView) findViewById(R.id.xiaoying_com_text_share_count);
        this.bHr = (TextView) findViewById(R.id.text_play_count);
        this.bHs = (ImageView) findViewById(R.id.btn_more);
        this.bHv = (ImageView) findViewById(R.id.item_divider);
        this.bHt = (ProgressBar) findViewById(R.id.xiaoying_com_progress_video_loading);
        this.bGv.setOnClickListener(this.acD);
        this.bHq.setOnClickListener(this.acD);
        this.bHs.setOnClickListener(this.acD);
        this.bHn.setOnClickListener(this.acD);
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.xiaoying_star_anim1);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), R.anim.xiaoying_star_anim2);
        this.bHw = new AnimationSet(false);
        this.bHw.addAnimation(loadAnimation);
        this.bHw.addAnimation(loadAnimation2);
        this.bHw.setFillAfter(true);
    }

    /* renamed from: U */
    public static String m11262U(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(SocialServiceDef.UNION_KEY_VIDEO_LIKE);
        sb.append("_");
        sb.append(str);
        sb.append("_");
        sb.append(str2);
        return sb.toString();
    }

    /* renamed from: w */
    private void m11264w(int i, boolean z) {
        this.bHp.setText(C4436b.m11214M(getContext(), i));
        this.bHp.setTag(Integer.valueOf(i));
        this.bHo.setSelected(z);
    }

    /* renamed from: Rl */
    public void mo24594Rl() {
        this.bGv.setVisibility(0);
        this.bHl.setVisibility(4);
        this.bHk.setVisibility(0);
        mo24599bV(false);
    }

    /* renamed from: Rm */
    public void mo24595Rm() {
        mo24599bV(false);
        this.bHk.setVisibility(4);
    }

    /* renamed from: Rn */
    public void mo24596Rn() {
        this.bGv.setVisibility(4);
        this.bHl.setVisibility(0);
        mo24599bV(true);
    }

    /* renamed from: Ro */
    public boolean mo24597Ro() {
        return this.bGv.getVisibility() != 0;
    }

    /* renamed from: a */
    public void mo24598a(VideoInfo videoInfo) {
        ImageLoader.loadImage(getContext(), videoInfo.mCoverUrl, this.bHk);
        mo24602hZ((int) videoInfo.mViewCount);
        String str = videoInfo.puid;
        StringBuilder sb = new StringBuilder();
        sb.append(videoInfo.mVer);
        sb.append("");
        m11264w((int) videoInfo.mLikeCount, !TextUtils.isEmpty(AppPreferencesSetting.getInstance().getAppSettingStr(m11262U(str, sb.toString()), "")));
        this.bHm.setText(videoInfo.mDesc);
        if (videoInfo.mWidth <= 0 || videoInfo.mHeight <= 0) {
            LayoutParams layoutParams = (LayoutParams) this.bHu.getLayoutParams();
            layoutParams.width = Constants.getScreenSize().width;
            layoutParams.height = layoutParams.width;
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) this.bHu.getLayoutParams();
        layoutParams2.width = Constants.getScreenSize().width;
        if (((float) videoInfo.mHeight) / ((float) videoInfo.mWidth) > 1.0f) {
            layoutParams2.height = layoutParams2.width;
        } else {
            layoutParams2.height = (layoutParams2.width * videoInfo.mHeight) / videoInfo.mWidth;
        }
    }

    /* renamed from: bV */
    public void mo24599bV(boolean z) {
        if (this.bHt != null) {
            if (z) {
                this.bHt.setVisibility(0);
            } else {
                this.bHt.setVisibility(8);
            }
        }
    }

    public ToolVideoView getVideoView() {
        return this.bHl;
    }

    /* renamed from: hY */
    public int mo24601hY(int i) {
        int intValue = Integer.valueOf(this.bHp.getTag().toString()).intValue();
        boolean z = false;
        if (i == 0 && !this.bHo.isSelected()) {
            this.bHo.clearAnimation();
            this.bHo.startAnimation(this.bHw);
            intValue++;
        } else if (i == 1 && this.bHo.isSelected()) {
            intValue = intValue <= 0 ? 0 : intValue - 1;
        }
        if (i == 0) {
            z = true;
        }
        m11264w(intValue, z);
        return intValue;
    }

    /* renamed from: hZ */
    public void mo24602hZ(int i) {
        String str;
        if (i > 1) {
            str = getResources().getString(R.string.xiaoying_str_community_play_count_plural, new Object[]{C4436b.m11214M(getContext(), i)});
        } else {
            str = getResources().getString(R.string.xiaoying_str_community_play_count_singular, new Object[]{C4436b.m11214M(getContext(), i)});
        }
        this.bHr.setText(str);
    }

    public void setDividerViewVisible(boolean z) {
        this.bHv.setVisibility(z ? 0 : 8);
    }

    public void setListener(C4451a aVar) {
        this.bHx = aVar;
    }
}
