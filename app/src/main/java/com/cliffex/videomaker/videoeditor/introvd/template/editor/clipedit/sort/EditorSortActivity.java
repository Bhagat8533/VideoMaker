package com.introvd.template.editor.clipedit.sort;

import android.content.Intent;
import android.os.Bundle;
import android.support.p024v7.widget.LinearLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.support.p024v7.widget.RecyclerView.C1034u;
import android.support.p024v7.widget.p031a.C1072a;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.introvd.template.EventActivity;
import com.introvd.template.editor.R;
import com.introvd.template.editor.clipedit.sort.C5755a.C5757a;
import com.introvd.template.editor.common.model.EditorToolItem;
import com.introvd.template.editor.common.p248b.C5842b;
import com.introvd.template.editor.p244a.C5554b;
import com.introvd.template.p414ui.view.p415a.C8986a;
import com.introvd.template.router.editor.EditorModes;
import com.introvd.template.router.editor.EditorRouter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@C1942a(mo10417rZ = "/XYVideoEditor/EditorSort")
public class EditorSortActivity extends EventActivity {
    private int cBB;
    private RecyclerView cBC;
    private ArrayList<EditorToolItem> cBD;
    private C5755a cBE;
    private RelativeLayout cBF;

    /* renamed from: aJ */
    private String m16003aJ(List<EditorToolItem> list) {
        if (list == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (EditorToolItem editorToolItem : list) {
            if (!TextUtils.isEmpty(sb.toString())) {
                sb.append(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
            }
            sb.append(editorToolItem.mode);
        }
        return sb.toString();
    }

    /* access modifiers changed from: private */
    public void afy() {
        String str;
        ArrayList afz = this.cBE.afz();
        Intent intent = new Intent();
        intent.putExtra(EditorRouter.EDITOR_TOOL_LIST, afz);
        setResult(-1, intent);
        switch (this.cBB) {
            case 0:
                str = "key_editor_clipedit_tool_list_order";
                StringBuilder sb = new StringBuilder();
                Iterator it = afz.iterator();
                while (it.hasNext()) {
                    String editorModeName = EditorModes.getEditorModeName(((EditorToolItem) it.next()).mode);
                    if (!TextUtils.isEmpty(sb.toString())) {
                        sb.append("+");
                    }
                    sb.append(editorModeName);
                }
                C5554b.m15024aE(getApplicationContext(), sb.toString());
                break;
            case 1:
                str = "key_editor_effects_tool_list_order";
                break;
            case 2:
                str = "key_editor_gifmaker_tool_list_order";
                break;
            default:
                str = null;
                break;
        }
        String aJ = m16003aJ(afz);
        if (str != null && aJ != null) {
            C5842b.aha().mo28219NS().setString(str, aJ);
        }
    }

    private void initUI() {
        this.cBF = (RelativeLayout) findViewById(R.id.layout_confirm);
        this.cBF.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                EditorSortActivity.this.afy();
                EditorSortActivity.this.setResult(-1);
                EditorSortActivity.this.finish();
            }
        });
        this.cBC = (RecyclerView) findViewById(R.id.sort_rc_view);
        this.cBE = new C5755a(this, this.cBD);
        this.cBC.setHasFixedSize(true);
        this.cBC.setAdapter(this.cBE);
        this.cBC.setLayoutManager(new LinearLayoutManager(this));
        final C1072a aVar = new C1072a(new C8986a(this.cBE));
        aVar.mo8593a(this.cBC);
        this.cBE.mo28028a((C5757a) new C5757a() {
            /* renamed from: X */
            public void mo28027X(C1034u uVar) {
                aVar.mo8591T(uVar);
            }
        });
    }

    public void onBackPressed() {
        setResult(0);
        finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        mo22815FX();
        setContentView(R.layout.editor_tool_sort_activity);
        this.cBB = getIntent().getIntExtra(EditorRouter.SORT_MODE, 0);
        Serializable serializableExtra = getIntent().getSerializableExtra(EditorRouter.EDITOR_TOOL_LIST);
        if (serializableExtra == null) {
            setResult(0);
            finish();
        }
        if (serializableExtra instanceof List) {
            this.cBD = (ArrayList) serializableExtra;
        }
        initUI();
    }
}
