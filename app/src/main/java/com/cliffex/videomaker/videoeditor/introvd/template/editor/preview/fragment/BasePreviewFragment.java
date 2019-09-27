package com.introvd.template.editor.preview.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.aiii.android.arouter.p091c.C1919a;
import com.introvd.template.common.FragmentBase;
import com.introvd.template.editor.base.C5686a;
import com.introvd.template.editor.common.C5843c;
import com.introvd.template.editor.common.model.EditorToolItem;
import com.introvd.template.editor.p246c.C5688b;
import com.introvd.template.editor.p259f.C6280b;
import com.introvd.template.editor.player.p269b.C6499a;
import com.introvd.template.editor.preview.p272c.C6555a;
import com.introvd.template.editor.preview.p272c.C6556b;
import com.introvd.template.router.editor.EditorIntentInfo;
import com.introvd.template.router.editor.EditorRouter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p503cz.msebera.android.httpclient.HttpStatus;

public abstract class BasePreviewFragment extends FragmentBase {
    protected View btV;
    protected C5686a cyD;
    protected EditorIntentInfo cyn;
    protected C6499a daT;
    protected C6556b daU;
    protected int daV = -1;
    private C1495b daW;

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo29886a(LayoutInflater layoutInflater, ViewGroup viewGroup);

    /* renamed from: a */
    public void mo29887a(C5686a aVar, C6499a aVar2, C6556b bVar, EditorIntentInfo editorIntentInfo) {
        this.cyD = aVar;
        this.daT = aVar2;
        this.daU = bVar;
        this.cyn = editorIntentInfo;
    }

    /* renamed from: a */
    public void mo29888a(C6555a aVar) {
    }

    public boolean aeL() {
        return false;
    }

    public void aeU() {
    }

    public void apk() {
    }

    public boolean apl() {
        return this.daV == C5843c.agO().getTabMode();
    }

    /* renamed from: bi */
    public void mo29893bi(List<Integer> list) {
    }

    /* renamed from: c */
    public void mo29894c(ArrayList<EditorToolItem> arrayList, int i) {
        C1919a.m5529sc().mo10355al(EditorRouter.EDITOR_SORT_URL).mo10406h(EditorRouter.SORT_MODE, i).mo10388a(EditorRouter.EDITOR_TOOL_LIST, (Serializable) arrayList).mo10396b((Activity) getActivity(), 24583);
    }

    /* renamed from: gA */
    public void mo29895gA(boolean z) {
    }

    /* renamed from: gB */
    public void mo29896gB(boolean z) {
    }

    public C5688b getFineTuningListener() {
        return null;
    }

    public C6280b getPlayerStatusListener() {
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract void initUI();

    public boolean onBackPressed() {
        return super.onBackPressed();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if ((this.cyD == null || this.daT == null || this.daU == null) && getActivity() != null) {
            getActivity().finish();
            return null;
        }
        mo29886a(layoutInflater, viewGroup);
        aeU();
        this.daW = C1487a.aUa().mo9777a(new Runnable() {
            public void run() {
                BasePreviewFragment.this.initUI();
            }
        }, (long) (this.daV == C5843c.agO().getTabMode() ? 100 : HttpStatus.SC_INTERNAL_SERVER_ERROR), TimeUnit.MILLISECONDS);
        return this.btV;
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (this.daW != null) {
            this.daW.dispose();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: oy */
    public void mo29900oy(int i) {
        this.daV = i;
    }

    /* renamed from: oz */
    public void mo29901oz(int i) {
    }
}
