package com.introvd.template.editor.preview.clipsort;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.p024v7.widget.GridLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1018h;
import android.support.p024v7.widget.p031a.C1072a;
import android.view.View;
import android.widget.ImageView;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.EventActivity;
import com.introvd.template.common.LogUtils;
import com.introvd.template.editor.R;
import com.introvd.template.editor.clipedit.C5695b;
import com.introvd.template.editor.preview.adapter.C6548e;
import com.introvd.template.editor.preview.model.ClipItemInfo;
import com.introvd.template.p414ui.view.p415a.C8986a;
import com.introvd.template.p414ui.view.p415a.C8986a.C8988b;
import com.introvd.template.picker.adapter.C8185d;
import com.introvd.template.sdk.editor.C8420b;
import com.introvd.template.sdk.editor.cache.C8440a;
import com.introvd.template.sdk.editor.cache.C8443d;
import com.introvd.template.sdk.model.editor.ProjectItem;
import com.introvd.template.sdk.utils.p394b.C8501a;
import com.introvd.template.sdk.utils.p394b.C8522g;
import com.introvd.template.sdk.utils.p394b.C8537n;
import com.introvd.template.sdk.utils.p394b.C8540q;
import com.introvd.template.template.p408f.C8750d;
import com.p131c.p132a.C2570b;
import com.p131c.p132a.p133a.C2564c;
import java.util.ArrayList;
import xiaoying.engine.clip.QClip;
import xiaoying.engine.storyboard.QStoryboard;

@C1942a(mo10417rZ = "/XYVideoEditor/ClipSort")
public class ClipSortActivity extends EventActivity {
    private C8522g bMM;
    private C8501a bOK;
    RecyclerView cBC;
    private ProjectItem cFL;
    private C8420b cFN;
    C6559a daw;
    private boolean dax;
    private C6548e day = new C6548e() {
        /* renamed from: d */
        public Bitmap mo29861d(ImageView imageView, int i) {
            return ClipSortActivity.this.m19013e(imageView, i);
        }
    };
    private C8443d mClipModelCacheList;
    private QStoryboard mStoryBoard;

    /* renamed from: Kl */
    private void m19008Kl() {
        this.cBC = (RecyclerView) findViewById(R.id.clip_sort_rcview);
        this.cBC.setLayoutManager(new GridLayoutManager(getApplicationContext(), C6559a.daB));
        this.daw = new C6559a(getApplicationContext(), this.day);
        this.cBC.mo7733a((C1018h) new C8185d(C6559a.daB, C6559a.daA, true));
        this.cBC.setAdapter(this.daw);
        C8986a aVar = new C8986a(this.daw, true);
        aVar.mo35758a(new C8988b() {
            /* renamed from: D */
            public void mo29870D(View view, int i) {
                if (ClipSortActivity.this.daw != null) {
                    ClipSortActivity.this.daw.mo29878gz(true);
                }
                C2564c.m7323a(view, null);
                Vibrator vibrator = (Vibrator) view.getContext().getSystemService("vibrator");
                if (vibrator != null) {
                    vibrator.vibrate(100);
                }
            }

            /* renamed from: cM */
            public void mo29871cM(int i, int i2) {
                if (ClipSortActivity.this.daw != null) {
                    ClipSortActivity.this.daw.mo29878gz(false);
                }
                C5695b.m15719n(ClipSortActivity.this.getApplicationContext(), String.valueOf(Math.abs(i - i2)), "grid");
                if (i != i2 && !ClipSortActivity.this.isFinishing()) {
                    boolean a = ClipSortActivity.this.m19012cL(i, i2);
                    StringBuilder sb = new StringBuilder();
                    sb.append("exchanged result");
                    sb.append(a);
                    LogUtils.m14223i("ClipDrag", sb.toString());
                }
            }
        });
        new C1072a(aVar).mo8593a(this.cBC);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.mClipModelCacheList.getCount(); i++) {
            C8440a tX = this.mClipModelCacheList.mo34307tX(i);
            if (tX != null && !tX.isCover()) {
                arrayList.add(m19010a(i, tX));
            }
        }
        this.daw.mo29877bf(arrayList);
    }

    /* renamed from: a */
    private ClipItemInfo m19010a(int i, C8440a aVar) {
        ClipItemInfo clipItemInfo = new ClipItemInfo();
        clipItemInfo.state = 0;
        Bitmap aHM = aVar.aHM();
        if (aHM != null) {
            clipItemInfo.bmpThumbnail = aHM;
        }
        boolean jM = C8750d.m25573jM(aVar.aHU());
        clipItemInfo.isImage = aVar.isImage();
        clipItemInfo.isGif = jM;
        clipItemInfo.lDuration = (long) aVar.aHV();
        clipItemInfo.bAudioEnable = !aVar.isImage();
        clipItemInfo.lTransDuration = (long) aVar.aHO();
        QClip i2 = C8540q.m24956i(this.mStoryBoard, i);
        if (i2 != null) {
            clipItemInfo.bAudioOn = !C8537n.m24837p(i2);
        }
        return clipItemInfo;
    }

    private int abx() {
        if (this.bMM == null) {
            return 1;
        }
        this.cFL = this.bMM.aHf();
        if (this.cFL == null) {
            return 1;
        }
        this.mStoryBoard = this.cFL.mStoryBoard;
        if (this.mStoryBoard == null) {
            return 1;
        }
        this.mClipModelCacheList = this.cFL.mClipModelCacheList;
        if (this.mClipModelCacheList == null) {
            return 1;
        }
        C8540q.m24907P(this.mStoryBoard);
        return 0;
    }

    private void aby() {
        this.cFN = new C8420b();
        this.cFN.mo34145t(this.mStoryBoard);
    }

    private boolean aph() {
        this.bMM = C8522g.aJA();
        if (this.bMM == null) {
            return false;
        }
        this.bOK = C8501a.aJs();
        return this.bOK != null && abw() == 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: cL */
    public boolean m19012cL(int i, int i2) {
        if (this.mStoryBoard == null || this.mClipModelCacheList == null) {
            return false;
        }
        if (C8540q.m24976w(this.mStoryBoard)) {
            i++;
            i2++;
        }
        QStoryboard qStoryboard = this.mStoryBoard;
        C8443d dVar = this.mClipModelCacheList;
        QClip i3 = C8540q.m24956i(qStoryboard, i);
        if (i3 != null && C8540q.m24938b(qStoryboard, i3, i2) == 0) {
            dVar.mo34300dB(i, i2);
            dVar.mo34301dC(i, i2);
            dVar.aIl();
            if (!this.bMM.aHe().isAdvBGMMode()) {
                C8540q.m24903L(qStoryboard);
                if (this.cFN != null) {
                    if (i <= i2) {
                        i = i2;
                    }
                    this.cFN.mo34142a(qStoryboard, true, i);
                }
            } else if (this.cFN != null) {
                if (i <= i2) {
                    i = i2;
                }
                this.cFN.mo34142a(qStoryboard, false, i);
            }
        }
        this.dax = true;
        this.bOK.mo34669jt(true);
        return true;
    }

    private void confirm() {
        setResult(this.dax ? -1 : 0);
        finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public Bitmap m19013e(ImageView imageView, int i) {
        int i2;
        if (this.mClipModelCacheList != null) {
            try {
                if (C8540q.m24976w(this.mStoryBoard)) {
                    i++;
                }
                int i3 = i;
                C8440a tX = this.mClipModelCacheList.mo34307tX(i3);
                if (tX != null) {
                    String aHU = tX.aHU();
                    int dimension = (int) getResources().getDimension(R.dimen.xiaoying_glide_clip_thumb_length);
                    int i4 = tX.aHT().get(0);
                    int i5 = tX.edJ.get(0);
                    int aHX = tX.aHX();
                    int i6 = -1;
                    if (!tX.aIa() || tX.aHZ() == null) {
                        i2 = -1;
                    } else {
                        int i7 = tX.aHZ().get(0);
                        i6 = i7;
                        i2 = tX.aHZ().get(1) + i7;
                    }
                    C6562b bVar = new C6562b(i3, aHU, i4, i5, aHX, i6, i2, this.mStoryBoard, tX.isClipReverse());
                    C2570b.m7336hy(getApplicationContext()).mo12209w(bVar).mo12869dX(dimension, dimension).mo12186g(imageView);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public int abw() {
        if (abx() != 0) {
            return 1;
        }
        aby();
        return 0;
    }

    public void onBackPressed() {
        confirm();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        mo22815FX();
        setContentView(R.layout.editor_clip_sort_activity);
        if (!aph()) {
            finish();
        } else {
            m19008Kl();
        }
    }

    public void sortConfirm(View view) {
        confirm();
    }
}
