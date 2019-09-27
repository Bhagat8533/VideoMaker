package com.introvd.template.editor.slideshow;

import android.content.Context;
import android.support.p024v7.widget.LinearLayoutManager;
import android.support.p024v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.introvd.template.editor.R;
import com.introvd.template.editor.common.C5840b;
import com.introvd.template.editor.slideshow.adapter.C6749d;
import com.introvd.template.editor.slideshow.adapter.C6749d.C6751b;
import com.introvd.template.editor.slideshow.p278a.C6739b;
import com.introvd.template.editor.slideshow.p279b.C6755c;
import com.introvd.template.p414ui.dialog.C8950d;
import com.introvd.template.p414ui.dialog.C8950d.C8956c;
import com.p131c.p132a.p133a.C2564c;
import com.p131c.p132a.p133a.C2564c.C2569a;
import java.util.ArrayList;
import java.util.List;
import xiaoying.engine.base.QTextAnimationInfo;

public class SlideSubTextView extends RelativeLayout {
    private View ddN;
    private View ddP;
    private RecyclerView ddQ;
    private List<QTextAnimationInfo> dfl;
    /* access modifiers changed from: private */
    public C6749d dfm;
    private boolean dfn;
    /* access modifiers changed from: private */
    public C6755c dfo;

    /* renamed from: com.introvd.template.editor.slideshow.SlideSubTextView$a */
    private class C6731a implements C8956c {
        private QTextAnimationInfo dfq;
        private int position;

        C6731a(int i, QTextAnimationInfo qTextAnimationInfo) {
            this.position = i;
            this.dfq = qTextAnimationInfo;
        }

        /* renamed from: a */
        public void mo27683a(int i, CharSequence charSequence) {
            switch (i) {
                case 1:
                    if (charSequence != null) {
                        SlideSubTextView.this.dfm.mo30261p(this.position, charSequence.toString());
                        if (SlideSubTextView.this.dfo != null) {
                            this.dfq.setText(charSequence.toString());
                            SlideSubTextView.this.dfo.mo30218a(this.dfq, false);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public SlideSubTextView(Context context) {
        this(context, null);
    }

    public SlideSubTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlideSubTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dfl = new ArrayList();
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.editor_subtext_edit_view_layout, this, true);
        this.ddP = findViewById(R.id.txtview_empty_titles_tip);
        this.ddN = findViewById(R.id.layout_2lev_hide);
        this.ddQ = (RecyclerView) findViewById(R.id.rv_editor_theme_title_list);
        this.ddQ.setLayoutManager(new LinearLayoutManager(getContext().getApplicationContext()));
        this.dfm = new C6749d(getContext());
        this.ddQ.setAdapter(this.dfm);
        this.ddN.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                SlideSubTextView.this.hide();
            }
        });
    }

    /* renamed from: by */
    public void mo30220by(List<QTextAnimationInfo> list) {
        this.dfl = list;
        if (this.dfl.size() > 0) {
            this.ddP.setVisibility(8);
            this.ddQ.setVisibility(0);
        } else {
            this.ddP.setVisibility(0);
            this.ddQ.setVisibility(8);
        }
        this.dfm.mo30260bB(list);
        this.dfm.mo30258a((C6751b) new C6751b() {
            /* renamed from: a */
            public void mo30226a(int i, QTextAnimationInfo qTextAnimationInfo) {
                if (qTextAnimationInfo != null) {
                    if (SlideSubTextView.this.dfo != null) {
                        SlideSubTextView.this.dfo.mo30219ab(qTextAnimationInfo.getPosition(), false);
                    }
                    C8950d dVar = new C8950d(SlideSubTextView.this.getContext(), qTextAnimationInfo.getText(), new C6731a(i, qTextAnimationInfo), false);
                    try {
                        dVar.mo35594dR(R.string.xiaoying_str_com_cancel, R.string.xiaoying_str_com_ok);
                        dVar.show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            /* renamed from: b */
            public void mo30227b(int i, QTextAnimationInfo qTextAnimationInfo) {
                if (!(qTextAnimationInfo == null || SlideSubTextView.this.dfo == null)) {
                    SlideSubTextView.this.dfo.mo30219ab(qTextAnimationInfo.getPosition(), false);
                }
            }
        });
    }

    public void hide() {
        C6739b.m19579fs(getContext());
        this.dfn = false;
        C2564c.m7324b(this, 0.0f, (float) C5840b.cEx, new C2569a() {
            public void onFinish() {
                SlideSubTextView.this.setVisibility(8);
            }
        });
    }

    public boolean isShowing() {
        return isShown() && this.dfn;
    }

    public void setTextEditCallback(C6755c cVar) {
        this.dfo = cVar;
    }

    public void show() {
        this.dfn = true;
        setVisibility(0);
        C2564c.m7322a(this, (float) C5840b.cEx, 0.0f, null);
    }
}
