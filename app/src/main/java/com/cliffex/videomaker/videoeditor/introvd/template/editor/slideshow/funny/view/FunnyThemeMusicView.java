package com.introvd.template.editor.slideshow.funny.view;

import android.content.Context;
import android.support.p021v4.app.Fragment;
import android.support.p021v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.aiii.android.arouter.p091c.C1919a;
import com.introvd.template.editor.R;
import com.introvd.template.editor.effects.music.EditorVolumeSetView;
import com.introvd.template.editor.effects.music.EditorVolumeSetView.C6176a;
import com.introvd.template.editor.slideshow.funny.p284b.C6825a;
import com.introvd.template.editor.slideshow.p278a.C6738a;
import com.introvd.template.explorer.music.XYMusicFragment;
import com.introvd.template.explorer.p297b.C7140b;
import com.introvd.template.router.explorer.ExplorerRouter.MusicParams;
import com.introvd.template.router.explorer.MusicDataItem;

public class FunnyThemeMusicView extends RelativeLayout {
    private XYMusicFragment bRj;
    TextView daY;
    LinearLayout daZ;
    ImageView dba;
    ImageView dbb;
    RelativeLayout ddE;
    RelativeLayout ddm;
    EditorVolumeSetView dhO;
    private boolean dhP;
    private String dhQ;
    /* access modifiers changed from: private */
    public C6825a dhv;

    /* renamed from: com.introvd.template.editor.slideshow.funny.view.FunnyThemeMusicView$a */
    private class C6833a implements OnClickListener {
        private C6833a() {
        }

        public void onClick(View view) {
            if (view.equals(FunnyThemeMusicView.this.ddm)) {
                if (FunnyThemeMusicView.this.dhv != null) {
                    FunnyThemeMusicView.this.dhv.arT();
                }
            } else if (view.equals(FunnyThemeMusicView.this.daY)) {
                FunnyThemeMusicView.this.m19944Wy();
            } else if (view.equals(FunnyThemeMusicView.this.dba)) {
                FunnyThemeMusicView.this.reset();
                C6738a.m19566fp(FunnyThemeMusicView.this.getContext());
            } else if (view.equals(FunnyThemeMusicView.this.dbb)) {
                FunnyThemeMusicView.this.clear();
                C6738a.m19565fo(FunnyThemeMusicView.this.getContext());
            }
        }
    }

    public FunnyThemeMusicView(Context context) {
        this(context, null);
    }

    public FunnyThemeMusicView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FunnyThemeMusicView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dhP = true;
        init();
    }

    /* access modifiers changed from: private */
    /* renamed from: Wy */
    public void m19944Wy() {
        if (this.dhv != null) {
            if (this.bRj == null) {
                this.bRj = (XYMusicFragment) C1919a.m5529sc().mo10355al(MusicParams.URL).mo10412rX();
                this.bRj.mo31826a((C7140b) new C7140b() {
                    /* renamed from: WC */
                    public void mo25762WC() {
                    }

                    /* renamed from: c */
                    public void mo25763c(MusicDataItem musicDataItem) {
                        if (!(musicDataItem == null || TextUtils.isEmpty(musicDataItem.filePath) || FunnyThemeMusicView.this.dhv == null)) {
                            FunnyThemeMusicView.this.dhO.mo28980nh(100);
                            FunnyThemeMusicView.this.m19950iG(musicDataItem.title);
                            FunnyThemeMusicView.this.dhv.mo30373e(musicDataItem.filePath, musicDataItem.startTimeStamp, musicDataItem.stopTimeStamp - musicDataItem.startTimeStamp);
                        }
                    }

                    /* renamed from: cZ */
                    public void mo25764cZ(boolean z) {
                    }
                });
                ((FragmentActivity) this.dhv.getHostActivity()).getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.activity_slide_in_from_top, R.anim.activity_slide_out_to_top).add(R.id.music_container, (Fragment) this.bRj).commitAllowingStateLoss();
            } else {
                ((FragmentActivity) this.dhv.getHostActivity()).getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.activity_slide_in_from_top, R.anim.activity_slide_out_to_top).show(this.bRj).commitAllowingStateLoss();
            }
        }
    }

    private boolean akp() {
        if (this.bRj == null || this.dhv == null) {
            return false;
        }
        ((FragmentActivity) this.dhv.getHostActivity()).getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.activity_slide_in_from_top, R.anim.activity_slide_out_to_top).remove(this.bRj).commitAllowingStateLoss();
        this.bRj.mo31826a((C7140b) null);
        this.bRj = null;
        return true;
    }

    /* access modifiers changed from: private */
    public void clear() {
        if (this.dhv != null) {
            this.dhv.arV();
        }
        m19950iG(null);
    }

    /* access modifiers changed from: private */
    /* renamed from: iG */
    public void m19950iG(String str) {
        if (TextUtils.isEmpty(str)) {
            this.daZ.setVisibility(8);
            this.dhO.setVisibility(8);
            this.daY.setText(R.string.xiaoying_str_ve_no_bgm_title_tip);
            return;
        }
        this.daZ.setVisibility(0);
        this.dhO.setVisibility(0);
        this.daY.setText(str);
    }

    private void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.funny_theme_music_view_layout, this, true);
        this.ddE = (RelativeLayout) inflate.findViewById(R.id.rlThemeMusicEditor);
        this.ddm = (RelativeLayout) inflate.findViewById(R.id.layout_2lev_hide);
        this.daY = (TextView) inflate.findViewById(R.id.txtview_bgm_name);
        this.daZ = (LinearLayout) inflate.findViewById(R.id.llMusicEdit);
        this.dba = (ImageView) inflate.findViewById(R.id.iv_reset_music);
        this.dbb = (ImageView) inflate.findViewById(R.id.iv_del_music);
        this.dhO = (EditorVolumeSetView) inflate.findViewById(R.id.volume_view);
        this.dhO.mo28980nh(100);
        this.dhO.setVolumeSetListener(new C6176a() {
            /* renamed from: mu */
            public void mo28584mu(int i) {
                if (FunnyThemeMusicView.this.dhv != null) {
                    FunnyThemeMusicView.this.dhv.mo30375pn(i);
                }
            }
        });
        C6833a aVar = new C6833a();
        this.ddm.setOnClickListener(aVar);
        this.daY.setOnClickListener(aVar);
        this.dba.setOnClickListener(aVar);
        this.dbb.setOnClickListener(aVar);
    }

    /* access modifiers changed from: private */
    public void reset() {
        if (this.dhv != null) {
            this.dhv.arU();
        }
        this.dhO.mo28980nh(100);
        m19950iG(this.dhQ);
    }

    /* renamed from: a */
    public void mo30408a(String str, C6825a aVar) {
        this.dhQ = str;
        this.dhv = aVar;
        m19950iG(str);
    }

    public boolean asb() {
        CharSequence text = this.daY.getText();
        boolean z = true;
        if (text == null || !text.toString().equals(this.dhQ)) {
            return true;
        }
        if (this.dhO.getProgress() == 100) {
            z = false;
        }
        return z;
    }

    public boolean isHidden() {
        return this.dhP;
    }

    public boolean onBackPressed() {
        if (akp()) {
            return true;
        }
        reset();
        return false;
    }

    public void onHiddenChanged(boolean z) {
        this.dhP = z;
    }
}
