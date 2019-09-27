package com.introvd.template.editor.clipedit;

import android.os.Bundle;
import android.text.TextUtils;
import com.introvd.template.editor.base.C5686a;
import com.introvd.template.editor.p261g.C6293a;
import com.introvd.template.editor.p261g.C6312c;
import com.introvd.template.editor.p261g.p262a.p263a.C6301a.C6303a;
import com.introvd.template.router.PassThoughUrlGenerator;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.introvd.template.sdk.editor.cache.C8440a;
import com.introvd.template.sdk.model.editor.ProjectItem;
import com.introvd.template.sdk.utils.p394b.C8540q;
import java.util.ArrayList;
import java.util.List;
import xiaoying.engine.clip.QClip;
import xiaoying.engine.storyboard.QStoryboard;

/* renamed from: com.introvd.template.editor.clipedit.a */
public class C5694a extends C5686a {
    protected int cwZ;
    protected boolean cyO;
    protected List<Integer> cyP = new ArrayList();
    protected TODOParamModel cyQ;

    /* renamed from: B */
    public void mo27845B(Bundle bundle) {
        if (bundle != null) {
            this.cyP = bundle.getIntegerArrayList("ve_extra_clip_index_list");
            if (this.cyP == null || this.cyP.size() == 0) {
                this.cyP = new ArrayList();
                QStoryboard adO = adO();
                if (adO != null) {
                    boolean adU = adU();
                    int clipCount = adO.getClipCount();
                    int i = 0;
                    while (i < clipCount) {
                        this.cyP.add(Integer.valueOf(adU ? i + 1 : i));
                        i++;
                    }
                }
            }
            this.cwZ = this.cyP.size() == 0 ? 0 : ((Integer) this.cyP.get(this.cyP.size() - 1)).intValue();
            this.cyO = bundle.getBoolean("ve_extra_clip_applyall_enable", false);
            String string = bundle.getString(PassThoughUrlGenerator.EXTRA_PASS_THROUGH_URL, null);
            if (!TextUtils.isEmpty(string)) {
                this.cyQ = (TODOParamModel) PassThoughUrlGenerator.getInfoFromIntent(string, TODOParamModel.class);
            }
        }
    }

    /* renamed from: a */
    public void mo27883a(C6312c cVar) {
        mo27884a(cVar, false, false);
    }

    /* renamed from: a */
    public void mo27884a(C6312c cVar, boolean z, boolean z2) {
        C6293a.anj().mo29237a(new C6303a().mo29263f(adM()).mo29261bc(z ? aeJ() : aeK()).mo29262f(cVar).anB(), z2);
    }

    public List<Integer> aeJ() {
        ArrayList arrayList = new ArrayList();
        QStoryboard adO = adO();
        if (adO != null) {
            boolean adU = adU();
            int clipCount = adO.getClipCount();
            int i = 0;
            while (i < clipCount) {
                arrayList.add(Integer.valueOf(adU ? i + 1 : i));
                i++;
            }
        }
        return arrayList;
    }

    public List<Integer> aeK() {
        return this.cyP;
    }

    public boolean aeL() {
        return this.cyO;
    }

    public QClip aeM() {
        return C8540q.m24956i(adO(), this.cwZ);
    }

    public int getFocusIndex() {
        return this.cwZ;
    }

    public TODOParamModel getTodoParamModel() {
        return this.cyQ;
    }

    /* renamed from: ld */
    public int mo27891ld(int i) {
        return adU() ? i + 1 : i;
    }

    /* renamed from: le */
    public QClip mo27892le(int i) {
        return C8540q.m24956i(adO(), i);
    }

    /* renamed from: lf */
    public C8440a mo27893lf(int i) {
        ProjectItem ahP = adK().aHf();
        if (ahP != null) {
            return ahP.mClipModelCacheList.mo34307tX(i);
        }
        return null;
    }
}
