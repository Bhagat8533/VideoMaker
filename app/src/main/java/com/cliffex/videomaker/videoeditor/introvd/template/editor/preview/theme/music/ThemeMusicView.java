package com.introvd.template.editor.preview.theme.music;

import android.app.Activity;
import android.support.p021v4.app.Fragment;
import android.support.p021v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.aiii.android.arouter.p091c.C1919a;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.common.CommonConfigure;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.MediaFileUtils;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.editor.R;
import com.introvd.template.editor.base.BaseOperationView;
import com.introvd.template.editor.base.C5686a;
import com.introvd.template.editor.player.p267a.C6483a;
import com.introvd.template.editor.preview.p271b.C6552c;
import com.introvd.template.editor.preview.p271b.C6554e;
import com.introvd.template.editor.preview.theme.C6664c;
import com.introvd.template.editor.preview.theme.ThemeAudioTrackMixView;
import com.introvd.template.editor.preview.theme.ThemeAudioTrackMixView.C6655a;
import com.introvd.template.explorer.music.XYMusicFragment;
import com.introvd.template.explorer.p297b.C7140b;
import com.introvd.template.explorer.p300e.C7213f;
import com.introvd.template.explorer.p300e.p301a.C7192a;
import com.introvd.template.explorer.p300e.p301a.C7192a.C7195a;
import com.introvd.template.explorer.p308ui.RangeLogicSeekBar;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.router.PassThoughUrlGenerator;
import com.introvd.template.router.editor.EditorIntentInfo;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.router.explorer.ExplorerRouter.MusicParams;
import com.introvd.template.router.explorer.MusicDataItem;
import com.introvd.template.router.lbs.LbsManagerProxy;
import com.introvd.template.sdk.utils.p394b.C8501a;
import com.introvd.template.sdk.utils.p394b.C8538o;
import com.introvd.template.sdk.utils.p394b.C8540q;
import com.introvd.template.template.p409g.C8762d;
import com.introvd.template.xyui.audiowave.RangeSeekBarV4;
import com.introvd.template.xyui.audiowave.RangeSeekBarV4.C9159b;
import org.greenrobot.eventbus.C10021c;
import p037b.p050b.C1848s;
import p037b.p050b.C1850u;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p073g.C1810c;
import p037b.p050b.p076j.C1820a;
import xiaoying.engine.base.QRange;
import xiaoying.engine.base.QStyle;
import xiaoying.engine.clip.QEffect;
import xiaoying.engine.storyboard.QStoryboard;

public class ThemeMusicView extends BaseOperationView<C5686a> {
    private static final float ddD = ((float) C4583d.m11671P(190.0f));
    private XYMusicFragment bRj;
    /* access modifiers changed from: private */
    public TextView daY;
    private LinearLayout daZ;
    /* access modifiers changed from: private */
    public ImageView dba;
    /* access modifiers changed from: private */
    public ImageView dbb;
    /* access modifiers changed from: private */
    public ThemeAudioTrackMixView dbc;
    /* access modifiers changed from: private */
    public RangeLogicSeekBar dbd;
    private RelativeLayout dbe;
    /* access modifiers changed from: private */
    public String dbf = "";
    private C9159b<Integer> dbg = new C9159b<Integer>() {
        /* renamed from: a */
        public void mo29912b(RangeSeekBarV4<?> rangeSeekBarV4, Integer num, Integer num2) {
            if (ThemeMusicView.this.dbc != null) {
                ThemeMusicView.this.dbc.setImageViewBgmAudioIconEnable();
            }
            ThemeMusicView.this.m19404d(ThemeMusicView.this.dbf, num.intValue(), num2.intValue());
        }

        /* renamed from: a */
        public void mo29910a(RangeSeekBarV4<?> rangeSeekBarV4, boolean z) {
            C6664c.m19364L(ThemeMusicView.this.getContext(), z);
        }

        /* renamed from: b */
        public void mo29909a(RangeSeekBarV4<?> rangeSeekBarV4, Integer num, Integer num2) {
        }
    };
    private C6655a dbh = new C6655a() {
        public void apt() {
            ThemeMusicView.this.m19418oA(0);
        }

        /* renamed from: gD */
        public void mo29914gD(boolean z) {
            ThemeMusicView.this.m19399aa(0, !z);
        }

        /* renamed from: gE */
        public void mo29915gE(boolean z) {
            ThemeMusicView.this.m19399aa(1, z);
        }

        /* renamed from: oB */
        public void mo29916oB(int i) {
            C6664c.m19366aa(ThemeMusicView.this.getContext().getApplicationContext(), i / 10);
            C8540q.m24964o(ThemeMusicView.this.getEditor().adO(), i);
        }
    };
    private RelativeLayout ddE;
    /* access modifiers changed from: private */
    public boolean ddF = false;
    /* access modifiers changed from: private */
    public RelativeLayout ddm;

    /* renamed from: com.introvd.template.editor.preview.theme.music.ThemeMusicView$a */
    private class C6676a implements OnClickListener {
        private C6676a() {
        }

        public void onClick(View view) {
            if (view.equals(ThemeMusicView.this.ddm)) {
                ThemeMusicView.this.handleBack();
                ThemeMusicView.this.exit();
            } else if (view.equals(ThemeMusicView.this.daY)) {
                ThemeMusicView.this.m19390Wy();
            } else if (view.equals(ThemeMusicView.this.dba)) {
                C6664c.m19370fj(ThemeMusicView.this.getContext());
                ThemeMusicView.this.app();
                ThemeMusicView.this.ddF = true;
            } else if (view.equals(ThemeMusicView.this.dbb)) {
                C6664c.m19371fk(ThemeMusicView.this.getContext());
                ThemeMusicView.this.apo();
                ThemeMusicView.this.ddF = true;
            }
        }
    }

    public ThemeMusicView(Activity activity) {
        super(activity, C5686a.class);
    }

    /* renamed from: Nu */
    private void m19389Nu() {
        C6676a aVar = new C6676a();
        this.ddm.setOnClickListener(aVar);
        this.daY.setOnClickListener(aVar);
        this.dba.setOnClickListener(aVar);
        this.dbb.setOnClickListener(aVar);
        this.dbd.setOnRangeSeekBarChangeListener(this.dbg);
    }

    /* access modifiers changed from: private */
    /* renamed from: Wy */
    public void m19390Wy() {
        if (getActivity() != null && !getActivity().isFinishing()) {
            getEditor().adX();
            if (this.bRj == null) {
                this.bRj = (XYMusicFragment) C1919a.m5529sc().mo10355al(MusicParams.URL).mo10412rX();
                this.bRj.mo31826a((C7140b) new C7140b() {
                    /* renamed from: WC */
                    public void mo25762WC() {
                    }

                    /* renamed from: c */
                    public void mo25763c(MusicDataItem musicDataItem) {
                        if (musicDataItem != null && !TextUtils.isEmpty(musicDataItem.filePath)) {
                            String str = musicDataItem.filePath;
                            int videoDuration = MediaFileUtils.getVideoDuration(str);
                            if (!(ThemeMusicView.this.getEditor().adK() == null || ThemeMusicView.this.getEditor().adK().aHe() == null)) {
                                ThemeMusicView.this.getEditor().adK().aHe().setBGMMode(false);
                            }
                            ThemeMusicView.this.cyD.adL().mo34669jt(true);
                            ThemeMusicView.this.mo30063a(musicDataItem.filePath, musicDataItem.title, musicDataItem.startTimeStamp, musicDataItem.stopTimeStamp);
                            ThemeMusicView.this.ald();
                            C8540q.m24903L(ThemeMusicView.this.getEditor().adO());
                            ThemeMusicView.this.m19400b(str, videoDuration, musicDataItem.startTimeStamp, musicDataItem.stopTimeStamp);
                        }
                    }

                    /* renamed from: cZ */
                    public void mo25764cZ(boolean z) {
                    }
                });
                ((FragmentActivity) getActivity()).getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.activity_slide_in_from_top, R.anim.activity_slide_out_to_top).add(R.id.music_container, (Fragment) this.bRj).commitAllowingStateLoss();
            } else {
                ((FragmentActivity) getActivity()).getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.activity_slide_in_from_top, R.anim.activity_slide_out_to_top).show(this.bRj).commitAllowingStateLoss();
            }
        }
    }

    /* renamed from: a */
    private int m19391a(C8501a aVar, QStoryboard qStoryboard, String str, int i, int i2, int i3, int i4, int i5) {
        if (aVar == null) {
            return 1;
        }
        int a = C8540q.m24919a(aVar.aJv(), qStoryboard, str, i, i2, i3, i4, i5);
        if (a == 0) {
            aVar.mo34669jt(true);
        }
        return a;
    }

    /* access modifiers changed from: private */
    /* renamed from: aa */
    public void m19399aa(int i, boolean z) {
        boolean z2 = false;
        if (i == 0) {
            if (z) {
                ToastUtils.show(getContext(), R.string.xiaoying_str_ve_msg_storyboard_video_set_open_tip, 0);
            } else {
                ToastUtils.show(getContext(), R.string.xiaoying_str_ve_msg_storyboard_video_set_mute_tip, 0);
            }
            if (C8540q.m24954f(getEditor().adO(), !z)) {
                LogUtilsV2.m14230i("disableStoryBoardClipAudio suc");
                C6664c.m19362J(getContext().getApplicationContext(), z);
            }
        } else {
            if (z) {
                ToastUtils.show(getContext(), R.string.xiaoying_str_ve_msg_storyboard_bgm_set_mute_tip, 0);
            } else {
                ToastUtils.show(getContext(), R.string.xiaoying_str_ve_msg_storyboard_bgm_set_open_tip, 0);
            }
            C8540q.m24951e(getEditor().adO(), z);
            C6664c.m19363K(getContext().getApplicationContext(), z);
        }
        LogUtilsV2.m14228e("bPrjSaveLock 3false");
        if (C8540q.m24901J(getEditor().adO()) && !C8540q.m24900I(getEditor().adO())) {
            z2 = true;
        }
        m19409gQ(z2);
    }

    /* access modifiers changed from: private */
    public void apo() {
        this.cyD.adL().mo34669jt(true);
        if (C8540q.m24902K(getEditor().adO())) {
            getVideoOperator().mo29678a(new C6483a().mo29719ok(0));
            m19418oA(this.dbc != null ? this.dbc.bYB : 0);
            if (getEditor().adS() != null) {
                getEditor().adS().mo34145t(getEditor().adO());
            }
            m19408gC(false);
            this.dbf = "";
            m19412il(null);
        }
    }

    /* access modifiers changed from: private */
    public void app() {
        QEffect d = C8540q.m24947d(getEditor().adO().getDataClip(), 1, 0);
        if (d != null) {
            d.setProperty(QEffect.PROP_EFFECT_ADDBYTHEME, Boolean.valueOf(true));
        }
        if (C8540q.m24914W(getEditor().adO())) {
            this.cyD.adL().mo34669jt(true);
            getVideoOperator().mo29678a(new C6483a().mo29719ok(3));
            if (getEditor().adS() != null) {
                getEditor().adS().mo34145t(getEditor().adO());
            }
            m19408gC(true);
            m19412il(null);
        }
    }

    private void apr() {
        if (aps() && this.cyD.adO() != null) {
            boolean z = C8540q.m24901J(getEditor().adO()) && !C8540q.m24900I(getEditor().adO());
            String G = C8540q.m24898G(this.cyD.adO());
            QEffect H = C8540q.m24899H(this.cyD.adO());
            if (!FileUtils.isFileExisted(G) || !z || H == null) {
                if (this.dbd.getVisibility() == 0) {
                    m19408gC(false);
                }
            } else if (!this.dbf.equals(G)) {
                this.dbf = G;
                final int videoDuration = MediaFileUtils.getVideoDuration(G);
                QRange qRange = (QRange) H.getProperty(QEffect.PROP_AUDIO_FRAME_RANGE);
                final int i = qRange.get(0);
                final int i2 = qRange.get(1) == -1 ? videoDuration : qRange.get(1) + i;
                C7192a.m21254a(this.dbf, new C7195a() {
                    /* renamed from: b */
                    public void mo29919b(double[] dArr) {
                        if (dArr != null && dArr.length > 0) {
                            ThemeMusicView.this.dbd.mo36125a(Integer.valueOf(0), Integer.valueOf(videoDuration), 1000.0d, dArr, Integer.valueOf(i), Integer.valueOf(i2), true);
                        }
                    }
                });
            }
        }
    }

    private boolean aps() {
        return C3742b.m9111II().mo23133JA();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m19400b(String str, final int i, final int i2, final int i3) {
        if (!aps() || TextUtils.isEmpty(str)) {
            return;
        }
        if (!this.dbf.equals(str) || ((Integer) this.dbd.getAbsoluteMaxValue()).intValue() != i) {
            m19408gC(true);
            this.dbf = str;
            if (i > 0 && this.cyD.adO() != null) {
                C7192a.m21254a(str, new C7195a() {
                    /* renamed from: b */
                    public void mo29919b(double[] dArr) {
                        if (dArr != null && dArr.length > 0) {
                            ThemeMusicView.this.dbd.mo36125a(Integer.valueOf(0), Integer.valueOf(i), 1000.0d, dArr, Integer.valueOf(i2), Integer.valueOf(i3), true);
                        }
                    }
                });
            }
            return;
        }
        this.dbd.setSelectedMinValue(Integer.valueOf(i2));
        this.dbd.setSelectedMaxValue(Integer.valueOf(i3));
        this.dbd.invalidate();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m19404d(String str, int i, int i2) {
        boolean z;
        if (!TextUtils.isEmpty(str)) {
            if (!(this.cyD.adK() == null || this.cyD.adK().aHe() == null)) {
                this.cyD.adK().aHe().setBGMMode(false);
            }
            this.cyD.adL().mo34669jt(true);
            int i3 = i2 - i;
            int i4 = -1 > i3 ? i3 : -1;
            if (C8540q.m24901J(this.cyD.adO())) {
                QEffect d = C8540q.m24947d(this.cyD.adO().getDataClip(), 1, 0);
                z = d != null ? ((Boolean) d.getProperty(QEffect.PROP_EFFECT_ADDBYTHEME)).booleanValue() : false;
                getVideoOperator().mo29678a(new C6483a().mo29719ok(0));
                C8540q.m24902K(this.cyD.adO());
            } else {
                z = false;
            }
            if (m19391a(this.cyD.adL(), this.cyD.adO(), str, 0, i4, i, i3, 50) == 0) {
                C8540q.m24903L(this.cyD.adO());
                if (C8540q.m24957j(this.cyD.adO().getDataClip(), 1) > 0) {
                    QEffect d2 = C8540q.m24947d(this.cyD.adO().getDataClip(), 1, 0);
                    d2.setProperty(QEffect.PROP_EFFECT_ADDBYTHEME, Boolean.valueOf(z));
                    getVideoOperator().mo29678a(new C6483a().mo29718c(d2).mo29719ok(3));
                }
            }
            getEditor().mo27846H(0, true);
            C8540q.m24903L(this.cyD.adO());
        }
    }

    /* renamed from: gC */
    private void m19408gC(boolean z) {
        if (this.dbd != null && this.dbe != null) {
            LayoutParams layoutParams = this.dbe.getLayoutParams();
            if (!z || !aps()) {
                layoutParams.height = -2;
                this.dbd.setVisibility(8);
            } else {
                layoutParams.height = C4583d.m11671P(50.0f);
                this.dbd.setVisibility(0);
                apr();
            }
            this.dbe.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: gQ */
    private void m19409gQ(boolean z) {
        int i = 2;
        int U = C8540q.m24911T(getEditor().adO()) ? 2 : C8540q.m24912U(getEditor().adO());
        QEffect H = C8540q.m24899H(getEditor().adO());
        if (z) {
            i = C8538o.m24884n(H);
        }
        this.dbc.mo30040C(U, i, C8540q.m24950e(getEditor().adO(), 1, 0));
    }

    /* access modifiers changed from: private */
    public boolean handleBack() {
        getEditor().adX();
        if (this.bRj == null) {
            C10021c.aZH().mo38492aA(new C6552c());
            return false;
        } else if (!this.bRj.awY()) {
            ((FragmentActivity) getActivity()).getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.activity_slide_in_from_top, R.anim.activity_slide_out_to_top).remove(this.bRj).commitAllowingStateLoss();
            this.bRj.mo31826a((C7140b) null);
            this.bRj = null;
            return true;
        } else if (this.bRj.awX()) {
            this.bRj.awV();
            return true;
        } else {
            this.bRj.mo31831ic(false);
            return true;
        }
    }

    /* renamed from: il */
    private void m19412il(final String str) {
        boolean z = C8540q.m24901J(getEditor().adO()) && !C8540q.m24900I(getEditor().adO());
        m19409gQ(z);
        if (getEditor().adO() != null) {
            if (z) {
                this.daZ.setVisibility(0);
                this.dbb.setVisibility(0);
                final String G = C8540q.m24898G(getEditor().adO());
                if (FileUtils.isFileExisted(G)) {
                    C1848s.m5326ai(Boolean.valueOf(true)).mo10194f(C1820a.aVi()).mo10199i(new C1518f<Boolean, String>() {
                        /* renamed from: w */
                        public String apply(Boolean bool) throws Exception {
                            return ThemeMusicView.this.m19413im(G) ? VivaBaseApplication.m8749FZ().getApplicationContext().getString(R.string.xiaoying_str_ve_bgm_change) : C7213f.m21300D(ThemeMusicView.this.getContext().getApplicationContext(), G, str);
                        }
                    }).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1810c<String>() {
                        /* renamed from: dV */
                        public void onSuccess(String str) {
                            TextView d = ThemeMusicView.this.daY;
                            if (TextUtils.isEmpty(str)) {
                                str = "";
                            }
                            d.setText(str);
                        }

                        public void onError(Throwable th) {
                        }
                    });
                } else {
                    this.daY.setText(R.string.xiaoying_str_ve_no_bgm_title_tip);
                }
            } else if (C8540q.m24893B(this.cyD.adO())) {
                this.dbb.setVisibility(8);
                this.daY.setText(R.string.xiaoying_str_ve_no_bgm_title_tip);
            } else {
                this.daZ.setVisibility(8);
                this.daY.setText(R.string.xiaoying_str_ve_no_bgm_title_tip);
            }
            if (!C8540q.m24893B(getEditor().adO()) || m19413im(C8540q.m24898G(getEditor().adO()))) {
                this.dba.setVisibility(8);
            } else {
                this.dba.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: im */
    public boolean m19413im(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String[] themeDefaultMusicPaths = QStyle.getThemeDefaultMusicPaths(getEditor().adP(), C8762d.aMt().mo35225bB(C8540q.m24894C(getEditor().adO()).longValue()));
        return themeDefaultMusicPaths != null && themeDefaultMusicPaths.length > 0 && str.equals(themeDefaultMusicPaths[0]);
    }

    /* access modifiers changed from: private */
    /* renamed from: oA */
    public void m19418oA(int i) {
        if (!C8540q.m24901J(getEditor().adO())) {
            StringBuilder sb = new StringBuilder();
            sb.append(CommonConfigure.APP_DATA_PATH);
            sb.append("/ini/dummy.mp3");
            m19391a(getEditor().adL(), getEditor().adO(), sb.toString(), 0, -1, 0, 1000, i);
            if (C8540q.m24957j(getEditor().adO().getDataClip(), 1) > 0) {
                getVideoOperator().mo29678a(new C6483a().mo29718c(C8540q.m24947d(getEditor().adO().getDataClip(), 1, 0)).mo29719ok(3));
            }
        }
    }

    /* renamed from: a */
    public void mo30063a(String str, String str2, int i, int i2) {
        int i3 = i2 - i;
        int i4 = -1 > i3 ? i3 : -1;
        if (C8540q.m24901J(getEditor().adO())) {
            getVideoOperator().mo29678a(new C6483a().mo29719ok(0));
            C8540q.m24902K(getEditor().adO());
        }
        if (m19391a(getEditor().adL(), getEditor().adO(), str, 0, i4, i, i3, 50) == 0) {
            C8540q.m24903L(getEditor().adO());
            if (C8540q.m24957j(getEditor().adO().getDataClip(), 1) > 0) {
                getVideoOperator().mo29678a(new C6483a().mo29718c(C8540q.m24947d(getEditor().adO().getDataClip(), 1, 0)).mo29719ok(3));
            }
        }
        m19412il(str2);
        getEditor().mo27846H(0, true);
    }

    public void aex() {
        super.aex();
        this.ddE = (RelativeLayout) findViewById(R.id.rlThemeMusicEditor);
        this.ddm = (RelativeLayout) findViewById(R.id.layout_2lev_hide);
        this.daY = (TextView) findViewById(R.id.txtview_bgm_name);
        this.daZ = (LinearLayout) findViewById(R.id.llMusicEdit);
        this.dba = (ImageView) findViewById(R.id.iv_reset_music);
        this.dbb = (ImageView) findViewById(R.id.iv_del_music);
        this.dbc = (ThemeAudioTrackMixView) findViewById(R.id.mixview);
        this.dbd = (RangeLogicSeekBar) findViewById(R.id.music_item_play_seek_bar);
        this.dbe = (RelativeLayout) findViewById(R.id.relativelayout_music_panel);
        LayoutParams layoutParams = this.ddE.getLayoutParams();
        layoutParams.height = (int) ddD;
        layoutParams.width = -1;
        this.ddE.setLayoutParams(layoutParams);
        getEditor().adX();
        m19389Nu();
        LbsManagerProxy.updateLocationCache();
        if (getEditor().adK().aHe() != null && !getEditor().adK().aHe().isMVPrj()) {
            m19418oA(0);
        }
        m19412il(null);
        if (!aps()) {
            m19408gC(false);
        }
        apr();
        this.dbc.setmOnMixChangeListener(this.dbh);
        String str = "";
        EditorIntentInfo editorIntentInfo = (EditorIntentInfo) PassThoughUrlGenerator.getInfoFromBundle(getBundle(), EditorIntentInfo.class);
        if (editorIntentInfo != null) {
            str = (String) editorIntentInfo.paramMap.get(EditorRouter.KEY_PARAMS_THEME_MUSIC_DOWNLOAD);
        }
        if (TextUtils.isEmpty(str)) {
            str = getBundle().getString(EditorRouter.KEY_PARAMS_THEME_MUSIC_DOWNLOAD, "");
        }
        if (!TextUtils.isEmpty(str)) {
            m19390Wy();
        }
    }

    public boolean aey() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void ald() {
        C10021c.aZH().mo38492aA(new C6554e());
    }

    public int getLayoutId() {
        return R.layout.editor_theme_music_view;
    }

    /* access modifiers changed from: protected */
    public float getTouchViewHeight() {
        return ddD;
    }

    public void onActivityDestroy() {
        super.onActivityDestroy();
        if (this.ddF) {
            ald();
            this.ddF = false;
        }
    }

    public boolean onBackPressed() {
        return handleBack();
    }
}
