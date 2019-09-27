package com.introvd.template.editor.preview.theme.themetitle;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.p024v7.widget.LinearLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.MSize;
import com.introvd.template.editor.R;
import com.introvd.template.editor.base.BaseOperationView;
import com.introvd.template.editor.base.C5686a;
import com.introvd.template.editor.p261g.C6293a;
import com.introvd.template.editor.p261g.C6312c;
import com.introvd.template.editor.p261g.p262a.C6307c;
import com.introvd.template.editor.p261g.p262a.C6308d.C6310a;
import com.introvd.template.editor.p266h.C6386d;
import com.introvd.template.editor.player.p267a.C6496m;
import com.introvd.template.editor.preview.p271b.C6552c;
import com.introvd.template.editor.preview.theme.C6664c;
import com.introvd.template.editor.preview.theme.themetitle.C6680a.C6682b;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.p414ui.dialog.C8950d;
import com.introvd.template.p414ui.dialog.C8950d.C8956c;
import com.introvd.template.sdk.model.editor.EngineSubtitleInfoModel;
import com.introvd.template.sdk.model.editor.ScaleRotateViewState;
import com.introvd.template.sdk.utils.VeMSize;
import com.introvd.template.sdk.utils.p394b.C8540q;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.C10021c;
import xiaoying.engine.clip.QClip;
import xiaoying.engine.cover.QCover;

@SuppressLint({"ViewConstructor"})
public class ThemeTitleView extends BaseOperationView<C5686a> {
    private List<EngineSubtitleInfoModel> dbY = new ArrayList();
    private View ddN;
    /* access modifiers changed from: private */
    public boolean ddO = false;
    private View ddP;
    private RecyclerView ddQ;
    /* access modifiers changed from: private */
    public C6680a ddR;
    private C6682b ddS = new C6682b() {
        /* renamed from: d */
        private int m19441d(EngineSubtitleInfoModel engineSubtitleInfoModel) {
            int previewTime = engineSubtitleInfoModel.getPreviewTime();
            int effectLen = engineSubtitleInfoModel.getEffectLen();
            if (effectLen > 0 && ThemeTitleView.this.getEditor().adO() != null) {
                int i = ((effectLen * 3) / 4) + previewTime;
                if (i < ThemeTitleView.this.getEditor().adO().getDuration()) {
                    return i;
                }
            }
            return previewTime;
        }

        /* renamed from: a */
        public void mo30071a(int i, EngineSubtitleInfoModel engineSubtitleInfoModel) {
            if (engineSubtitleInfoModel != null) {
                ThemeTitleView.this.getEditor().adX();
                int adZ = ThemeTitleView.this.getEditor().adZ();
                int d = m19441d(engineSubtitleInfoModel);
                if (adZ != d) {
                    ThemeTitleView.this.getEditor().mo27846H(d, false);
                }
                C8950d dVar = new C8950d(ThemeTitleView.this.getActivity(), engineSubtitleInfoModel.mText, new C6679a(i, engineSubtitleInfoModel), false);
                try {
                    dVar.mo35594dR(R.string.xiaoying_str_com_cancel, R.string.xiaoying_str_com_ok);
                    dVar.show();
                } catch (Exception e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("ex:");
                    sb.append(e.getMessage());
                    LogUtilsV2.m14228e(sb.toString());
                }
            }
        }

        /* renamed from: b */
        public void mo30072b(EngineSubtitleInfoModel engineSubtitleInfoModel) {
            if (engineSubtitleInfoModel != null) {
                ThemeTitleView.this.getEditor().adX();
                ThemeTitleView.this.getEditor().mo27846H(m19441d(engineSubtitleInfoModel), false);
            }
        }
    };

    /* renamed from: com.introvd.template.editor.preview.theme.themetitle.ThemeTitleView$a */
    private class C6679a implements C8956c {
        private EngineSubtitleInfoModel ddU;
        private int position;

        C6679a(int i, EngineSubtitleInfoModel engineSubtitleInfoModel) {
            this.position = i;
            this.ddU = engineSubtitleInfoModel;
        }

        /* renamed from: a */
        public void mo27683a(int i, CharSequence charSequence) {
            switch (i) {
                case 1:
                    if (ThemeTitleView.this.ddR != null) {
                        ScaleRotateViewState scaleRotateViewState = this.ddU.textState;
                        if (scaleRotateViewState != null && !TextUtils.equals(scaleRotateViewState.getTextBubbleText(), charSequence.toString())) {
                            scaleRotateViewState.setTextBubbleText(charSequence.toString());
                            scaleRotateViewState.setShadowInfo(null);
                            this.ddU.mText = scaleRotateViewState.getTextBubbleText();
                            ThemeTitleView.this.ddR.mo30075p(this.position, scaleRotateViewState.getTextBubbleText());
                            C6664c.m19369fi(ThemeTitleView.this.getContext());
                            ThemeTitleView.this.m19440c(this.ddU);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public ThemeTitleView(Activity activity) {
        super(activity, C5686a.class);
    }

    /* renamed from: a */
    private boolean m19437a(ScaleRotateViewState scaleRotateViewState, QCover qCover, String str, int i) {
        if (qCover == null || i < 0) {
            return false;
        }
        boolean z = true;
        C6496m go = new C6496m(10).mo29740o(scaleRotateViewState).mo29737a(qCover).mo29739ij(str).mo29741ol(i).mo29738go(true);
        if (getVideoOperator() == null || !getVideoOperator().mo29678a(go)) {
            z = false;
        }
        return z;
    }

    private void aqt() {
        MSize surfaceSize = this.cyD.getSurfaceSize();
        List<EngineSubtitleInfoModel> a = C8540q.m24926a(this.cyD.adP(), this.cyD.adO(), new VeMSize(surfaceSize.width, surfaceSize.height));
        int duration = getEditor().adO().getDuration();
        for (EngineSubtitleInfoModel engineSubtitleInfoModel : a) {
            if (engineSubtitleInfoModel.mTimeVeRange.getmPosition() <= duration) {
                this.dbY.add(engineSubtitleInfoModel);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m19440c(EngineSubtitleInfoModel engineSubtitleInfoModel) {
        if (getEditor() != null && engineSubtitleInfoModel != null && engineSubtitleInfoModel.textState != null) {
            if (C6386d.m18372a(getEditor().adO(), engineSubtitleInfoModel)) {
                C6386d.m18365a(getEditor(), engineSubtitleInfoModel);
            }
            C6293a.anj().mo29246b((C6307c) new C6310a().mo29282e(C6312c.THEME_TITLE).mo29280a(engineSubtitleInfoModel).mo29285nJ(0).mo29283e(getEditor().adK().aHf()).any());
            boolean z = engineSubtitleInfoModel.mGroupType != 2;
            int i = engineSubtitleInfoModel.mClipIndex;
            ScaleRotateViewState scaleRotateViewState = engineSubtitleInfoModel.textState;
            if (z) {
                QClip i2 = C8540q.m24956i(getEditor().adO(), i);
                if ((i2 instanceof QCover) && m19437a(scaleRotateViewState, (QCover) i2, scaleRotateViewState.getTextBubbleText(), engineSubtitleInfoModel.mIndex)) {
                    getVideoOperator().mo29687cH(0, -1);
                }
            } else {
                C6496m go = new C6496m(10).mo29740o(scaleRotateViewState).mo29741ol(engineSubtitleInfoModel.mIndex).mo29742om(engineSubtitleInfoModel.groupId).mo29738go(false);
                if (getVideoOperator() != null) {
                    getVideoOperator().mo29678a(go);
                }
            }
        }
    }

    public void aex() {
        super.aex();
        this.ddO = getBundle().getBoolean("bundle_is_only_edit_theme_title", false);
        this.ddP = findViewById(R.id.txtview_empty_titles_tip);
        this.ddN = findViewById(R.id.layout_2lev_hide);
        this.ddQ = (RecyclerView) findViewById(R.id.rv_editor_theme_title_list);
        C10021c.aZH().mo38492aA(new C6552c());
        aqt();
        this.ddQ.setLayoutManager(new LinearLayoutManager(getContext().getApplicationContext()));
        this.ddR = new C6680a(getContext(), this.dbY, this.ddS);
        this.ddQ.setAdapter(this.ddR);
        getEditor().adX();
        if (this.dbY.size() > 0) {
            this.ddP.setVisibility(8);
            this.ddQ.setVisibility(0);
        } else {
            this.ddP.setVisibility(0);
            this.ddQ.setVisibility(8);
        }
        this.ddN.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (!ThemeTitleView.this.ddO) {
                    ThemeTitleView.this.getEditor().adX();
                    C10021c.aZH().mo38492aA(new C6552c());
                    ThemeTitleView.this.exit();
                }
            }
        });
    }

    public int getLayoutId() {
        return R.layout.editor_subtext_edit_view_layout;
    }

    public int getViewHeight() {
        return C4583d.m11673ii(190);
    }

    public void onActivityDestroy() {
        super.onActivityDestroy();
    }

    public boolean onBackPressed() {
        if (this.ddO) {
            return true;
        }
        getEditor().adX();
        C10021c.aZH().mo38492aA(new C6552c());
        return false;
    }
}
