package com.introvd.template.editor.fast;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.editor.R;
import com.introvd.template.editor.common.C5852d;
import com.introvd.template.editor.common.model.EditorToolItem;
import com.introvd.template.editor.common.p247a.C5839a;
import com.introvd.template.editor.fast.p260a.C6284a;
import com.introvd.template.editor.fast.p260a.C6287b;
import com.introvd.template.editor.fast.view.C6292a;
import com.introvd.template.editor.fast.view.FastMoreToolLayout;
import com.introvd.template.editor.fast.view.FastToolItemView;
import com.introvd.template.editor.p246c.C5688b;
import com.introvd.template.editor.preview.BasePreviewOpsView;
import com.introvd.template.editor.provider.C6710e;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.router.editor.EditorModes;
import java.util.ArrayList;
import java.util.Iterator;

@SuppressLint({"ViewConstructor"})
public class FastPreviewOpsView extends BasePreviewOpsView implements C6287b {
    private C6284a cRq;
    private C6292a cRr = new C6292a() {
        /* renamed from: nu */
        public void mo29221nu(int i) {
            if (FastPreviewOpsView.this.cyC != null) {
                FastPreviewOpsView.this.getVideoOperator().aoi();
                if (EditorModes.isClipEditMode(i)) {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("ve_extra_clip_applyall_enable", false);
                    FastPreviewOpsView.this.cyC.mo27786f(i, bundle);
                } else if (!EditorModes.isEffectMode(i)) {
                    FastPreviewOpsView.this.ami();
                } else if (C5852d.agW().agX() - C5852d.agW().agY() < 500) {
                    ToastUtils.shortShow(FastPreviewOpsView.this.getContext(), R.string.xiaoying_str_ve_msg_duration_not_long_enough);
                    return;
                } else {
                    FastPreviewOpsView.this.cyC.mo27788kZ(i);
                }
                if (EditorModes.isClipEditMode(i) || EditorModes.isEffectMode(i)) {
                    C5839a.m16329aW(FastPreviewOpsView.this.getContext(), EditorModes.getEditorModeName(i));
                } else {
                    C5839a.m16331ey(FastPreviewOpsView.this.getContext());
                }
            }
        }
    };
    private FastMoreToolLayout cRs;

    public FastPreviewOpsView(Activity activity) {
        super(activity);
    }

    private void amh() {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.tool_container);
        ArrayList aqA = new C6710e(getContext()).aqA();
        LayoutParams layoutParams = new LayoutParams(0, -1, 1.0f);
        Iterator it = aqA.iterator();
        while (it.hasNext()) {
            EditorToolItem editorToolItem = (EditorToolItem) it.next();
            FastToolItemView fastToolItemView = new FastToolItemView(getContext());
            fastToolItemView.setItemData(editorToolItem.mode, false, editorToolItem.coverResID, editorToolItem.titleResID);
            fastToolItemView.setListener(this.cRr);
            linearLayout.addView(fastToolItemView, layoutParams);
        }
        FastToolItemView fastToolItemView2 = new FastToolItemView(getContext());
        fastToolItemView2.setItemData(-1, false, R.drawable.editor_fast_icon_tool_more, getContext().getResources().getString(R.string.xiaoying_str_com_more));
        fastToolItemView2.setListener(this.cRr);
        linearLayout.addView(fastToolItemView2, layoutParams);
    }

    /* access modifiers changed from: private */
    public void ami() {
        if (this.cRs == null || this.cRs.getParent() == null) {
            this.cRs = new FastMoreToolLayout(getContext());
            this.cRs.setToolItemListener(this.cRr);
            this.cyC.aeo().addView(this.cRs, new ViewGroup.LayoutParams(-1, -1));
        }
        this.cRs.show();
    }

    public void aex() {
        super.aex();
        this.cRq = new C6284a();
        this.cRq.attachView((C6287b) this);
        this.cRq.mo29222a(getContext(), this.cyD);
        amh();
    }

    /* renamed from: cC */
    public void mo29219cC(int i, int i2) {
        if (this.cyC != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("ve_extra_effect_id", i2);
            this.cyC.mo27786f(i, bundle);
        }
    }

    public C5688b getFineTuningListener() {
        if (this.cRq == null) {
            return null;
        }
        return this.cRq.getFineTuningListener();
    }

    public Activity getHostActivity() {
        return getActivity();
    }

    public int getLayoutId() {
        return R.layout.editor_fast_preview_ops_layout;
    }

    public int getViewHeight() {
        return C4583d.m11670O(getContext(), 100);
    }

    public boolean onBackPressed() {
        if (this.cRs == null || !this.cRs.isShown()) {
            return false;
        }
        this.cRs.hide();
        return true;
    }
}
