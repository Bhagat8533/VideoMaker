package com.introvd.template.editor.preview.fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
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
import com.introvd.template.common.MediaFileUtils;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.editor.R;
import com.introvd.template.editor.base.BaseEditorActivity;
import com.introvd.template.editor.p261g.C6293a;
import com.introvd.template.editor.p261g.C6293a.C6296a;
import com.introvd.template.editor.p261g.C6312c;
import com.introvd.template.editor.p261g.p262a.C6298a;
import com.introvd.template.editor.p261g.p262a.C6298a.C6300a;
import com.introvd.template.editor.p261g.p262a.C6307c;
import com.introvd.template.editor.player.p267a.C6483a;
import com.introvd.template.editor.preview.p271b.C6551b;
import com.introvd.template.editor.preview.p271b.C6554e;
import com.introvd.template.editor.preview.theme.C6664c;
import com.introvd.template.editor.preview.theme.ThemeAudioTrackMixView;
import com.introvd.template.editor.preview.theme.ThemeAudioTrackMixView.C6655a;
import com.introvd.template.explorer.music.XYMusicFragment;
import com.introvd.template.explorer.music.p304b.C7263b;
import com.introvd.template.explorer.p297b.C7140b;
import com.introvd.template.explorer.p300e.C7213f;
import com.introvd.template.explorer.p300e.p301a.C7192a;
import com.introvd.template.explorer.p300e.p301a.C7192a.C7195a;
import com.introvd.template.explorer.p308ui.RangeLogicSeekBar;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.router.explorer.ExplorerRouter.MusicParams;
import com.introvd.template.router.explorer.MusicDataItem;
import com.introvd.template.sdk.utils.p394b.C8501a;
import com.introvd.template.sdk.utils.p394b.C8538o;
import com.introvd.template.sdk.utils.p394b.C8540q;
import com.introvd.template.template.p409g.C8762d;
import com.introvd.template.xyui.audiowave.RangeSeekBarV4;
import com.introvd.template.xyui.audiowave.RangeSeekBarV4.C9159b;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.C10021c;
import org.greenrobot.eventbus.C10031j;
import org.greenrobot.eventbus.ThreadMode;
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

public class BgmFragment extends BasePreviewFragment {
    /* access modifiers changed from: private */
    public XYMusicFragment bRj;
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
            if (BgmFragment.this.dbc != null) {
                BgmFragment.this.dbc.setImageViewBgmAudioIconEnable();
            }
            BgmFragment.this.m19057d(BgmFragment.this.dbf, num.intValue(), num2.intValue());
        }

        /* renamed from: a */
        public void mo29910a(RangeSeekBarV4<?> rangeSeekBarV4, boolean z) {
            C6664c.m19364L(BgmFragment.this.getContext(), z);
        }

        /* renamed from: b */
        public void mo29909a(RangeSeekBarV4<?> rangeSeekBarV4, Integer num, Integer num2) {
        }
    };
    private C6655a dbh = new C6655a() {
        public void apt() {
            BgmFragment.this.m19069oA(0);
        }

        /* renamed from: gD */
        public void mo29914gD(boolean z) {
            BgmFragment.this.m19051aa(0, !z);
        }

        /* renamed from: gE */
        public void mo29915gE(boolean z) {
            BgmFragment.this.m19051aa(1, z);
        }

        /* renamed from: oB */
        public void mo29916oB(int i) {
            if (BgmFragment.this.getContext() != null) {
                C6664c.m19366aa(BgmFragment.this.getContext().getApplicationContext(), i / 10);
                C8540q.m24964o(BgmFragment.this.cyD.adO(), i);
            }
        }
    };

    /* renamed from: com.introvd.template.editor.preview.fragment.BgmFragment$a */
    private class C6575a implements OnClickListener {
        private C6575a() {
        }

        public void onClick(View view) {
            if (view.equals(BgmFragment.this.daY)) {
                BgmFragment.this.m19040Wy();
            } else if (view.equals(BgmFragment.this.dba)) {
                BgmFragment.this.m19061g(C6312c.BGM_MODIFY);
                BgmFragment.this.app();
                C6664c.m19370fj(BgmFragment.this.getContext());
            } else if (view.equals(BgmFragment.this.dbb)) {
                BgmFragment.this.m19061g(C6312c.BGM_MODIFY);
                BgmFragment.this.apo();
                C6664c.m19371fk(BgmFragment.this.getContext());
            }
        }
    }

    public BgmFragment() {
        mo29900oy(3);
    }

    /* renamed from: Nu */
    private void m19039Nu() {
        C6575a aVar = new C6575a();
        this.daY.setOnClickListener(aVar);
        this.dba.setOnClickListener(aVar);
        this.dbb.setOnClickListener(aVar);
        this.dbd.setOnRangeSeekBarChangeListener(this.dbg);
    }

    /* access modifiers changed from: private */
    /* renamed from: Wy */
    public void m19040Wy() {
        if (getActivity() != null && !getActivity().isFinishing()) {
            this.daT.aoi();
            if (this.daU != null && (this.daU.getActivity() instanceof BaseEditorActivity)) {
                ((BaseEditorActivity) this.daU.getActivity()).abj();
            }
            if (this.bRj == null) {
                this.bRj = (XYMusicFragment) C1919a.m5529sc().mo10355al(MusicParams.URL).mo10412rX();
                this.bRj.mo31826a((C7140b) new C7140b() {
                    /* renamed from: WC */
                    public void mo25762WC() {
                        if (BgmFragment.this.bRj != null) {
                            BgmFragment.this.apm();
                        }
                    }

                    /* renamed from: c */
                    public void mo25763c(MusicDataItem musicDataItem) {
                        if (musicDataItem != null && !TextUtils.isEmpty(musicDataItem.filePath)) {
                            boolean z = C8540q.m24901J(BgmFragment.this.cyD.adO()) && !C8540q.m24900I(BgmFragment.this.cyD.adO());
                            String G = C8540q.m24898G(BgmFragment.this.cyD.adO());
                            if (!z || !FileUtils.isFileExisted(G)) {
                                BgmFragment.this.m19061g(C6312c.BGM_APPLY);
                            } else {
                                BgmFragment.this.m19061g(C6312c.BGM_MODIFY);
                            }
                            if (!(BgmFragment.this.cyD.adK() == null || BgmFragment.this.cyD.adK().aHe() == null)) {
                                BgmFragment.this.cyD.adK().aHe().setBGMMode(false);
                            }
                            BgmFragment.this.m19050a(musicDataItem.filePath, musicDataItem.title, musicDataItem.startTimeStamp, musicDataItem.stopTimeStamp);
                            C8540q.m24903L(BgmFragment.this.cyD.adO());
                            String str = musicDataItem.filePath;
                            BgmFragment.this.m19053b(str, MediaFileUtils.getVideoDuration(str), musicDataItem.startTimeStamp, musicDataItem.stopTimeStamp);
                        }
                    }

                    /* renamed from: cZ */
                    public void mo25764cZ(boolean z) {
                    }
                });
                getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.activity_slide_in_from_top, R.anim.activity_slide_out_to_top).add(R.id.fragment_container, this.bRj, "fragment_tag_bgm").commitAllowingStateLoss();
            } else {
                getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.activity_slide_in_from_top, R.anim.activity_slide_out_to_top).show(this.bRj).commitAllowingStateLoss();
            }
        }
    }

    /* renamed from: a */
    private int m19041a(C8501a aVar, QStoryboard qStoryboard, String str, int i, int i2, int i3, int i4, int i5) {
        if (aVar == null) {
            return 1;
        }
        return C8540q.m24919a(aVar.aJv(), qStoryboard, str, i, i2, i3, i4, i5);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19050a(String str, String str2, int i, int i2) {
        int i3 = i2 - i;
        int i4 = -1 > i3 ? i3 : -1;
        if (C8540q.m24901J(this.cyD.adO())) {
            this.daT.mo29678a(new C6483a().mo29719ok(0));
            C8540q.m24902K(this.cyD.adO());
        }
        if (m19041a(this.cyD.adL(), this.cyD.adO(), str, 0, i4, i, i3, 50) == 0) {
            C8540q.m24903L(this.cyD.adO());
            if (C8540q.m24957j(this.cyD.adO().getDataClip(), 1) > 0) {
                this.daT.mo29678a(new C6483a().mo29718c(C8540q.m24947d(this.cyD.adO().getDataClip(), 1, 0)).mo29719ok(3));
            }
        }
        m19065il(str2);
        this.daT.mo29675H(0, true);
    }

    /* access modifiers changed from: private */
    /* renamed from: aa */
    public void m19051aa(int i, boolean z) {
        if (i == 0) {
            if (z) {
                ToastUtils.show(getContext(), R.string.xiaoying_str_ve_msg_storyboard_video_set_open_tip, 0);
            } else {
                ToastUtils.show(getContext(), R.string.xiaoying_str_ve_msg_storyboard_video_set_mute_tip, 0);
            }
            if (C8540q.m24954f(this.cyD.adO(), !z)) {
                C6664c.m19362J(getContext().getApplicationContext(), z);
            }
        } else {
            if (z) {
                ToastUtils.show(getContext(), R.string.xiaoying_str_ve_msg_storyboard_bgm_set_mute_tip, 0);
            } else {
                ToastUtils.show(getContext(), R.string.xiaoying_str_ve_msg_storyboard_bgm_set_open_tip, 0);
            }
            C8540q.m24951e(this.cyD.adO(), z);
            C6664c.m19363K(getContext().getApplicationContext(), z);
        }
        apn();
    }

    /* access modifiers changed from: private */
    public void apm() {
        if (getActivity() != null) {
            getActivity().getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.activity_slide_in_from_top, R.anim.activity_slide_out_to_top).remove(this.bRj).commitAllowingStateLoss();
            this.bRj.mo31826a((C7140b) null);
            this.bRj = null;
            if (this.daU != null && (this.daU.getActivity() instanceof BaseEditorActivity)) {
                ((BaseEditorActivity) this.daU.getActivity()).abl();
            }
        }
    }

    /* access modifiers changed from: private */
    public void apo() {
        if (C8540q.m24902K(this.cyD.adO())) {
            this.daT.mo29678a(new C6483a().mo29719ok(0));
            m19069oA(this.dbc != null ? this.dbc.bYB : 0);
            if (this.cyD.adS() != null) {
                this.cyD.adS().mo34145t(this.cyD.adO());
            }
            m19062gC(false);
            this.dbf = "";
            m19065il(null);
        }
    }

    /* access modifiers changed from: private */
    public void app() {
        QEffect d = C8540q.m24947d(this.cyD.adO().getDataClip(), 1, 0);
        if (d != null) {
            d.setProperty(QEffect.PROP_EFFECT_ADDBYTHEME, Boolean.valueOf(true));
        }
        if (C8540q.m24914W(this.cyD.adO())) {
            this.daT.mo29678a(new C6483a().mo29719ok(3));
            if (this.cyD.adS() != null) {
                this.cyD.adS().mo34145t(this.cyD.adO());
            }
            m19062gC(true);
            m19065il(null);
        }
    }

    public static BgmFragment apq() {
        return new BgmFragment();
    }

    private void apr() {
        if (aps() && this.cyD.adO() != null) {
            boolean z = C8540q.m24901J(this.cyD.adO()) && !C8540q.m24900I(this.cyD.adO());
            QEffect H = C8540q.m24899H(this.cyD.adO());
            String G = C8540q.m24898G(this.cyD.adO());
            if (!FileUtils.isFileExisted(G) || !z || H == null) {
                if (this.dbd.getVisibility() == 0) {
                    m19062gC(false);
                }
            } else if (!this.dbf.equals(G) || this.dbd.getVisibility() != 0) {
                this.dbf = G;
                final int videoDuration = MediaFileUtils.getVideoDuration(G);
                QRange qRange = (QRange) H.getProperty(QEffect.PROP_AUDIO_FRAME_RANGE);
                final int i = qRange.get(0);
                final int i2 = qRange.get(1) == -1 ? videoDuration : qRange.get(1) + i;
                C7192a.m21254a(this.dbf, new C7195a() {
                    /* renamed from: b */
                    public void mo29919b(double[] dArr) {
                        if (dArr != null && dArr.length > 0) {
                            BgmFragment.this.dbd.mo36125a(Integer.valueOf(0), Integer.valueOf(videoDuration), 1000.0d, dArr, Integer.valueOf(i), Integer.valueOf(i2), true);
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
    public void m19053b(String str, final int i, final int i2, final int i3) {
        if (!aps() || TextUtils.isEmpty(str)) {
            return;
        }
        if (!this.dbf.equals(str) || ((Integer) this.dbd.getAbsoluteMaxValue()).intValue() != i) {
            m19062gC(true);
            if (i > 0 && this.cyD.adO() != null) {
                C7192a.m21254a(str, new C7195a() {
                    /* renamed from: b */
                    public void mo29919b(double[] dArr) {
                        if (dArr != null && dArr.length > 0) {
                            BgmFragment.this.dbd.mo36125a(Integer.valueOf(0), Integer.valueOf(i), 1000.0d, dArr, Integer.valueOf(i2), Integer.valueOf(i3), true);
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
    public void m19057d(String str, int i, int i2) {
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
                this.daT.mo29678a(new C6483a().mo29719ok(0));
                C8540q.m24902K(this.cyD.adO());
            } else {
                z = false;
            }
            if (m19041a(this.cyD.adL(), this.cyD.adO(), str, 0, i4, i, i3, 50) == 0) {
                C8540q.m24903L(this.cyD.adO());
                if (C8540q.m24957j(this.cyD.adO().getDataClip(), 1) > 0) {
                    QEffect d2 = C8540q.m24947d(this.cyD.adO().getDataClip(), 1, 0);
                    d2.setProperty(QEffect.PROP_EFFECT_ADDBYTHEME, Boolean.valueOf(z));
                    this.daT.mo29678a(new C6483a().mo29718c(d2).mo29719ok(3));
                }
            }
            this.daT.mo29675H(0, true);
            C8540q.m24903L(this.cyD.adO());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m19061g(C6312c cVar) {
        C6293a.anj().mo29246b((C6307c) new C6300a().mo29254b(this.cyD.adK().aHf()).mo29255gb(C8540q.m24900I(this.cyD.adO())).mo29256ii(C8540q.m24898G(this.cyD.adO())).mo29253b(cVar).ans());
    }

    /* renamed from: gC */
    private void m19062gC(boolean z) {
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

    /* access modifiers changed from: private */
    /* renamed from: il */
    public void m19065il(final String str) {
        if (this.cyD != null && this.cyD.adO() != null) {
            apn();
            if (C8540q.m24901J(this.cyD.adO()) && !C8540q.m24900I(this.cyD.adO())) {
                this.daZ.setVisibility(0);
                this.dbb.setVisibility(0);
                final String G = C8540q.m24898G(this.cyD.adO());
                if (FileUtils.isFileExisted(G)) {
                    C1848s.m5326ai(Boolean.valueOf(true)).mo10194f(C1820a.aVi()).mo10199i(new C1518f<Boolean, String>() {
                        /* renamed from: w */
                        public String apply(Boolean bool) throws Exception {
                            return BgmFragment.this.m19066im(G) ? VivaBaseApplication.m8749FZ().getApplicationContext().getString(R.string.xiaoying_str_ve_bgm_change) : C7213f.m21300D(BgmFragment.this.getContext().getApplicationContext(), G, str);
                        }
                    }).mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C1810c<String>() {
                        /* renamed from: dV */
                        public void onSuccess(String str) {
                            TextView b = BgmFragment.this.daY;
                            if (TextUtils.isEmpty(str)) {
                                str = "";
                            }
                            b.setText(str);
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
            if (!C8540q.m24893B(this.cyD.adO()) || m19066im(C8540q.m24898G(this.cyD.adO()))) {
                this.dba.setVisibility(8);
            } else {
                this.dba.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: im */
    public boolean m19066im(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String[] themeDefaultMusicPaths = QStyle.getThemeDefaultMusicPaths(this.cyD.adP(), C8762d.aMt().mo35225bB(C8540q.m24894C(this.cyD.adO()).longValue()));
        if (themeDefaultMusicPaths != null && themeDefaultMusicPaths.length > 0) {
            if (str.equals(themeDefaultMusicPaths[0])) {
                return true;
            }
            if (themeDefaultMusicPaths[0].contains("assets_android://xiaoying/theme/")) {
                String[] split = str.split("/");
                String[] split2 = themeDefaultMusicPaths[0].split("/");
                if (split.length > 0 && split2.length > 0) {
                    return split[split.length - 1].equals(split2[split2.length - 1]);
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: oA */
    public void m19069oA(int i) {
        if (!(this.cyD == null || this.cyD.adO() == null || C8540q.m24901J(this.cyD.adO()))) {
            StringBuilder sb = new StringBuilder();
            sb.append(CommonConfigure.APP_DATA_PATH);
            sb.append("/ini/dummy.mp3");
            m19041a(this.cyD.adL(), this.cyD.adO(), sb.toString(), 0, -1, 0, 1000, i);
            if (C8540q.m24957j(this.cyD.adO().getDataClip(), 1) > 0) {
                this.daT.mo29678a(new C6483a().mo29718c(C8540q.m24947d(this.cyD.adO().getDataClip(), 1, 0)).mo29719ok(3));
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo29886a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        this.btV = layoutInflater.inflate(R.layout.editor_fragment_bgm, viewGroup, false);
    }

    public void aeU() {
        if (!C10021c.aZH().mo38495ay(this)) {
            C10021c.aZH().mo38494ax(this);
        }
        C6293a.anj().mo29234a((C6296a) new C6296a() {
            /* renamed from: a */
            public void mo27778a(boolean z, C6307c cVar, C6307c cVar2, boolean z2) {
                if (z) {
                    if (cVar2 instanceof C6298a) {
                        if (BgmFragment.this.daT != null) {
                            BgmFragment.this.daT.mo29687cH(0, 0);
                        }
                        BgmFragment.this.m19065il(null);
                    }
                } else if (cVar instanceof C6298a) {
                    if (BgmFragment.this.daT != null) {
                        BgmFragment.this.daT.mo29687cH(0, 0);
                    }
                    BgmFragment.this.m19065il(null);
                }
            }
        });
    }

    public void apn() {
        if (this.cyD != null) {
            QStoryboard adO = this.cyD.adO();
            if (adO != null) {
                int i = 2;
                int U = C8540q.m24911T(adO) ? 2 : C8540q.m24912U(adO);
                if (C8540q.m24901J(adO) && !C8540q.m24900I(adO)) {
                    i = C8538o.m24884n(C8540q.m24899H(adO));
                }
                this.dbc.mo30040C(U, i, C8540q.m24950e(adO, 1, 0));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void initUI() {
        this.daY = (TextView) this.btV.findViewById(R.id.txtview_bgm_name);
        this.daZ = (LinearLayout) this.btV.findViewById(R.id.llMusicEdit);
        this.dba = (ImageView) this.btV.findViewById(R.id.iv_reset_music);
        this.dbb = (ImageView) this.btV.findViewById(R.id.iv_del_music);
        this.dbc = (ThemeAudioTrackMixView) this.btV.findViewById(R.id.mixview);
        this.dbd = (RangeLogicSeekBar) this.btV.findViewById(R.id.music_item_play_seek_bar);
        this.dbe = (RelativeLayout) this.btV.findViewById(R.id.relativelayout_music_panel);
        m19039Nu();
        if (!this.cyD.adW()) {
            m19069oA(0);
        }
        m19065il(null);
        if (!aps()) {
            m19062gC(false);
        }
        apr();
        this.dbc.setmOnMixChangeListener(this.dbh);
        if (this.cyn != null && !TextUtils.isEmpty((String) this.cyn.paramMap.get(EditorRouter.KEY_PARAMS_THEME_MUSIC_DOWNLOAD))) {
            C1487a.aUa().mo9777a(new Runnable() {
                public void run() {
                    BgmFragment.this.m19040Wy();
                }
            }, 100, TimeUnit.MILLISECONDS);
        }
    }

    public boolean onBackPressed() {
        if (this.bRj == null) {
            return super.onBackPressed();
        }
        this.daT.aoi();
        if (!this.bRj.awY()) {
            apm();
            return true;
        } else if (this.bRj.awX()) {
            this.bRj.awV();
            return true;
        } else {
            this.bRj.mo31831ic(false);
            return true;
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.dbc.setmOnMixChangeListener(null);
        C10021c.aZH().mo38496az(this);
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onEventMainThread(C6551b bVar) {
        if (this.cyD != null && !this.cyD.adW()) {
            m19069oA(0);
        }
        if (C3742b.m9111II().mo23141JI() && this.cyD != null) {
            C8540q.m24964o(this.cyD.adO(), 100);
        }
        m19065il(null);
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onEventMainThread(C6554e eVar) {
        if (this.cyD != null && !this.cyD.adW()) {
            m19069oA(0);
        }
        m19065il(null);
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onEventMainThread(C7263b bVar) {
        if (bVar.axj() == 2) {
            if (this.cyD != null && !this.cyD.adW()) {
                m19069oA(0);
            }
            m19065il(null);
        }
    }

    public void onHiddenChanged(boolean z) {
        if (!z) {
            m19062gC(true);
        }
    }
}
