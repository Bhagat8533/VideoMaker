package com.introvd.template.app.videoplayer;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
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
import com.introvd.template.common.Constants;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.imageloader.ImageLoader;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.common.p236ui.custom.CustomVideoForCreationView;

public class VideoCardForCreationView extends RelativeLayout implements OnClickListener {
    private ImageView bHL;
    private CustomVideoForCreationView bHM;
    private RelativeLayout bHN;
    private RelativeLayout bHO;
    private RelativeLayout bHP;
    private TextView bHQ;
    private TextView bHR;
    private C4464a bHS;
    private ProgressBar bHt;
    private AnimationSet bHw;
    private int position;
    private int rawId;

    /* renamed from: com.introvd.template.app.videoplayer.VideoCardForCreationView$a */
    public interface C4464a {
        /* renamed from: bX */
        void mo24655bX(View view);
    }

    public VideoCardForCreationView(Context context) {
        super(context);
        init();
    }

    public VideoCardForCreationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public VideoCardForCreationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.v5_xiaoying_creation_video_item_layout, this, true);
        this.bHL = (ImageView) findViewById(R.id.xiaoying_com_img_video_thumb);
        this.bHN = (RelativeLayout) findViewById(R.id.xiaoying_com_thumb_layout);
        this.bHM = (CustomVideoForCreationView) findViewById(R.id.xiaoying_com_video_view_layout);
        this.bHO = (RelativeLayout) findViewById(R.id.xiaoying_com_info_layout);
        this.bHt = (ProgressBar) findViewById(R.id.xiaoying_com_progress_video_loading);
        this.bHQ = (TextView) findViewById(R.id.xiaoying_com_play_num);
        this.bHR = (TextView) findViewById(R.id.xiaoying_com_video_desc);
        this.bHP = (RelativeLayout) findViewById(R.id.xiaoying_com_play_info_layout);
        this.bHO.setOnClickListener(this);
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.xiaoying_star_anim1);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), R.anim.xiaoying_star_anim2);
        this.bHw = new AnimationSet(false);
        this.bHw.addAnimation(loadAnimation);
        this.bHw.addAnimation(loadAnimation2);
        this.bHw.setFillAfter(true);
    }

    /* renamed from: Rl */
    public void mo24645Rl() {
        LogUtilsV2.m14230i("resetVideoViewState");
        this.bHP.setVisibility(0);
        this.bHM.setVisibility(4);
        this.bHO.setVisibility(0);
        this.bHL.setVisibility(0);
        mo24650bV(false);
    }

    /* renamed from: Rm */
    public void mo24646Rm() {
        mo24650bV(false);
        this.bHO.setVisibility(8);
        this.bHL.setVisibility(8);
    }

    /* renamed from: Rn */
    public void mo24647Rn() {
        this.bHP.setVisibility(4);
        this.bHM.setVisibility(0);
        mo24650bV(true);
    }

    /* renamed from: Ro */
    public boolean mo24648Ro() {
        return this.bHP.getVisibility() != 0;
    }

    /* renamed from: b */
    public void mo24649b(C4436b bVar, int i) {
        int i2;
        int i3;
        if (this.bHM != null) {
            this.bHM.setBehaviorParams(this.position, this.rawId, bVar.strTitle);
        }
        int i4 = bVar.bGd;
        int i5 = bVar.bGe;
        StringBuilder sb = new StringBuilder();
        sb.append("Video Size : ");
        sb.append(i4);
        sb.append(" x ");
        sb.append(i5);
        LogUtilsV2.m14230i(sb.toString());
        if (i4 <= 0 || i5 <= 0) {
            LayoutParams layoutParams = (LayoutParams) this.bHN.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) this.bHM.getLayoutParams();
            layoutParams.width = i;
            layoutParams.height = layoutParams.width;
            layoutParams2.width = layoutParams.width;
            layoutParams2.height = layoutParams.height;
            this.bHN.setLayoutParams(layoutParams);
            i2 = layoutParams2.width;
            i3 = layoutParams2.height;
            this.bHM.setLayoutParams(layoutParams2);
        } else {
            LayoutParams layoutParams3 = (LayoutParams) this.bHN.getLayoutParams();
            LayoutParams layoutParams4 = (LayoutParams) this.bHM.getLayoutParams();
            layoutParams4.width = i;
            if (((float) i5) / ((float) i4) > 1.0f) {
                layoutParams4.height = layoutParams4.width;
            } else {
                layoutParams4.height = (layoutParams4.width * i5) / i4;
            }
            i2 = layoutParams4.width;
            i3 = layoutParams4.height;
            this.bHM.setLayoutParams(layoutParams4);
            layoutParams3.width = Constants.getScreenSize().width;
            layoutParams3.height = layoutParams4.height;
            this.bHN.setLayoutParams(layoutParams3);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("paramsVideo : ");
            sb2.append(layoutParams4.width);
            sb2.append(" x ");
            sb2.append(layoutParams4.height);
            LogUtilsV2.m14230i(sb2.toString());
        }
        ImageLoader.loadImage(getContext(), bVar.strCoverURL, this.bHL, i2, i3);
        if (!AppStateModel.getInstance().isCommunitySupport()) {
            String M = C4436b.m11214M(getContext(), bVar.bGf);
            this.bHQ.setText(M);
            this.bHM.setPlayNum(M);
        }
        CustomVideoForCreationView customVideoForCreationView = this.bHM;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(bVar.strPuid);
        sb3.append("_");
        sb3.append(bVar.strPver);
        customVideoForCreationView.setVideoId(sb3.toString());
        if (!TextUtils.isEmpty(bVar.bGg)) {
            this.bHR.setText(bVar.bGg);
            this.bHR.setVisibility(0);
            return;
        }
        this.bHR.setVisibility(8);
    }

    /* renamed from: bV */
    public void mo24650bV(boolean z) {
        if (this.bHt != null) {
            if (z) {
                this.bHt.setVisibility(0);
            } else {
                this.bHt.setVisibility(8);
            }
        }
    }

    public CustomVideoForCreationView getVideoView() {
        return this.bHM;
    }

    public void onClick(View view) {
        if (this.bHS != null) {
            this.bHS.mo24655bX(view);
        }
    }

    public void setBehaviorParams(int i, int i2) {
        this.position = i;
        this.rawId = i2;
    }

    public void setListener(C4464a aVar) {
        this.bHS = aVar;
    }
}
