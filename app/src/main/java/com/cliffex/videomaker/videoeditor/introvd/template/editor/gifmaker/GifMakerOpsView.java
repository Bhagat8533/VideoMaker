package com.introvd.template.editor.gifmaker;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.p024v7.app.C0839a.C0840a;
import android.support.p024v7.widget.LinearLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import com.introvd.template.editor.R;
import com.introvd.template.editor.gifmaker.p265a.C6367a;
import com.introvd.template.editor.gifmaker.p265a.C6367a.C6369a;
import com.introvd.template.editor.preview.BasePreviewOpsView;
import com.introvd.template.editor.provider.C6711f;
import com.introvd.template.sdk.utils.p394b.C8540q;
import xiaoying.engine.clip.QClip;

@SuppressLint({"ViewConstructor"})
public class GifMakerOpsView extends BasePreviewOpsView {
    private RecyclerView cUs;
    private C6367a cUt;
    private C6711f cUu;

    public GifMakerOpsView(Activity activity) {
        super(activity);
    }

    /* renamed from: Kl */
    private void m18310Kl() {
        this.cUu = new C6711f(getContext());
        this.cUs = (RecyclerView) findViewById(R.id.rc_gifmaker_tool);
        this.cUs.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        this.cUt = new C6367a(getContext());
        this.cUt.mo29415a((C6369a) new C6369a() {
            /* renamed from: hk */
            public void mo29412hk(int i) {
                if (i != 3) {
                    GifMakerOpsView.this.m18312nI(i);
                }
            }
        });
        this.cUs.setAdapter(this.cUt);
        this.cUt.mo29417ba(this.cUu.aqA());
    }

    private void anc() {
        final Activity activity = (Activity) this.bwg.get();
        if (activity != null && !activity.isFinishing()) {
            new C0840a(activity).mo6528h((CharSequence) activity.getString(R.string.xiaoying_str_exit_no_save_msg)).mo6517F(true).mo6518a(R.string.xiaoying_str_com_yes, (OnClickListener) new OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (GifMakerOpsView.this.getEditor() != null) {
                        GifMakerOpsView.this.getEditor().adV();
                    }
                    activity.finish();
                }
            }).mo6523b(R.string.xiaoying_str_com_no, null).mo6526gk().show();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: nI */
    public void m18312nI(int i) {
        if (i == 1013) {
            QClip i2 = C8540q.m24956i(this.cyD.adO(), 0);
            if (i2 != null && i2.setProperty(12315, Integer.valueOf((((Integer) i2.getProperty(12315)).intValue() + 90) % 360)) == 0) {
                if (this.cyD.adL() != null) {
                    this.cyD.adL().mo34669jt(true);
                }
                if (getVideoOperator() != null) {
                    getVideoOperator().mo29676a(getPlayerInitTime(), null, false);
                }
            }
        } else if (this.cyC != null) {
            this.cyC.mo27788kZ(i);
        }
    }

    public void aex() {
        super.aex();
        m18310Kl();
    }

    public int getLayoutId() {
        return R.layout.editor_gif_maker_ops;
    }

    public boolean onBackPressed() {
        anc();
        return true;
    }
}
