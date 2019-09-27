package com.introvd.template.p310g;

import android.databinding.C0170e;
import android.databinding.ViewDataBinding;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.introvd.template.app.school.view.CreationEditorSubToolLayout;
import com.introvd.template.common.p236ui.banner.LoopViewPager;

/* renamed from: com.introvd.template.g.g */
public abstract class C7368g extends ViewDataBinding {
    public final FrameLayout cpe;
    public final C7370i cpf;
    public final C7370i cpg;
    public final LinearLayout cph;
    public final CreationEditorSubToolLayout cpi;
    public final LoopViewPager cpj;

    protected C7368g(C0170e eVar, View view, int i, FrameLayout frameLayout, C7370i iVar, C7370i iVar2, LinearLayout linearLayout, CreationEditorSubToolLayout creationEditorSubToolLayout, LoopViewPager loopViewPager) {
        super(eVar, view, i);
        this.cpe = frameLayout;
        this.cpf = iVar;
        setContainedBinding(this.cpf);
        this.cpg = iVar2;
        setContainedBinding(this.cpg);
        this.cph = linearLayout;
        this.cpi = creationEditorSubToolLayout;
        this.cpj = loopViewPager;
    }
}
