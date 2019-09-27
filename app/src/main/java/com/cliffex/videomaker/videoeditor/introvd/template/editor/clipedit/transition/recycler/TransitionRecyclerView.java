package com.introvd.template.editor.clipedit.transition.recycler;

import android.content.Context;
import android.support.p024v7.widget.LinearLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import com.introvd.template.editor.R;
import com.introvd.template.editor.clipedit.transition.C5802b;

public class TransitionRecyclerView extends RelativeLayout {
    private RecyclerView cDd;
    private LinearLayoutManager cDe;
    private C5805b cDf;

    public TransitionRecyclerView(Context context) {
        super(context);
        m16157Oj();
    }

    public TransitionRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m16157Oj();
    }

    public TransitionRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m16157Oj();
    }

    /* renamed from: Oj */
    private void m16157Oj() {
        LayoutInflater.from(getContext().getApplicationContext()).inflate(R.layout.editor_transition_recycler_view_layout, this, true);
        this.cDd = (RecyclerView) findViewById(R.id.gallery_common_content_filter);
    }

    /* renamed from: a */
    public boolean mo28090a(C5804a aVar, C5802b bVar) {
        this.cDe = new LinearLayoutManager(getContext().getApplicationContext());
        this.cDe.setOrientation(0);
        this.cDd.setLayoutManager(this.cDe);
        this.cDf = new C5805b(getContext().getApplicationContext(), this.cDe, aVar, bVar);
        this.cDd.setAdapter(this.cDf);
        return true;
    }

    /* renamed from: d */
    public void mo28091d(long j, String str) {
        if (this.cDf != null) {
            this.cDf.mo28107d(j, str);
        }
    }

    /* renamed from: e */
    public void mo28092e(long j, int i) {
        if (this.cDf != null) {
            this.cDf.mo28108e(j, i);
        }
    }

    /* renamed from: gQ */
    public void mo28093gQ(String str) {
        if (this.cDf != null) {
            this.cDf.mo28109gQ(str);
        }
    }
}
