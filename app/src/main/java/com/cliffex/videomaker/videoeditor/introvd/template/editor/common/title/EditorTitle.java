package com.introvd.template.editor.common.title;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.editor.R;
import com.p131c.p132a.p133a.C2564c;
import com.p131c.p132a.p135c.p136a.C2579b;
import com.p131c.p132a.p135c.p136a.C2579b.C2582a;

public class EditorTitle extends RelativeLayout {
    /* access modifiers changed from: private */
    public C5865a cFl;
    private boolean cFm;
    private ImageButton cFn;
    private ImageButton cFo;
    private ImageButton cFp;
    private TextView cFq;
    private TextView cFr;
    private ImageView cFs;
    private boolean cFt;
    private boolean cFu;
    private boolean cFv;

    public EditorTitle(Context context) {
        this(context, null);
    }

    public EditorTitle(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EditorTitle(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.cFt = true;
        this.cFu = true;
        this.cFv = true;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.EditorTitle);
            this.cFt = obtainStyledAttributes.getBoolean(R.styleable.EditorTitle_draftEnable, true);
            this.cFu = obtainStyledAttributes.getBoolean(R.styleable.EditorTitle_shareEnable, true);
            this.cFv = obtainStyledAttributes.getBoolean(R.styleable.EditorTitle_backEnable, true);
            obtainStyledAttributes.recycle();
        }
        m16395Oj();
    }

    /* renamed from: Oj */
    private void m16395Oj() {
        LayoutInflater.from(getContext()).inflate(R.layout.editor_title_layout, this, true);
        this.cFn = (ImageButton) findViewById(R.id.editor_back_btn);
        this.cFq = (TextView) findViewById(R.id.editor_draft);
        this.cFr = (TextView) findViewById(R.id.editor_publish);
        this.cFs = (ImageView) findViewById(R.id.editor_edit_lesson);
        this.cFo = (ImageButton) findViewById(R.id.editor_undo_btn);
        this.cFp = (ImageButton) findViewById(R.id.editor_redo_btn);
        int i = 8;
        this.cFn.setVisibility(this.cFv ? 0 : 8);
        this.cFr.setVisibility(this.cFu ? 0 : 8);
        TextView textView = this.cFq;
        if (this.cFt) {
            i = 0;
        }
        textView.setVisibility(i);
        C2579b.m7399a(new C2582a<View>() {
            public void onClick(View view) {
                C2564c.m7327dA(view);
                if (EditorTitle.this.cFl != null) {
                    EditorTitle.this.cFl.onBack();
                }
            }
        }, this.cFn);
        C2579b.m7399a(new C2582a<View>() {
            public void onClick(View view) {
                C2564c.m7327dA(view);
                if (EditorTitle.this.cFl != null) {
                    EditorTitle.this.cFl.ahD();
                }
            }
        }, this.cFq);
        C2579b.m7399a(new C2582a<View>() {
            public void onClick(View view) {
                C2564c.m7327dA(view);
                if (EditorTitle.this.cFl != null) {
                    EditorTitle.this.cFl.ahE();
                }
            }
        }, this.cFr);
        C2579b.m7399a(new C2582a<View>() {
            public void onClick(View view) {
                C2564c.m7327dA(view);
                if (EditorTitle.this.cFl != null) {
                    EditorTitle.this.cFl.ahF();
                }
            }
        }, this.cFs);
        C2579b.m7398a(new C2582a<View>() {
            public void onClick(View view) {
                C2564c.m7327dA(view);
                if (EditorTitle.this.cFl != null) {
                    EditorTitle.this.cFl.ahG();
                }
            }
        }, 300, this.cFo);
        C2579b.m7398a(new C2582a<View>() {
            public void onClick(View view) {
                C2564c.m7327dA(view);
                if (EditorTitle.this.cFl != null) {
                    EditorTitle.this.cFl.ahH();
                }
            }
        }, 300, this.cFp);
    }

    public boolean ahA() {
        return this.cFm;
    }

    public void ahB() {
        this.cFs.setVisibility(0);
    }

    public void ahC() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.8f, 1.2f, 0.8f, 1.2f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(1000);
        scaleAnimation.setRepeatMode(2);
        scaleAnimation.setRepeatCount(-1);
        this.cFs.startAnimation(scaleAnimation);
    }

    /* renamed from: eU */
    public void mo28282eU(boolean z) {
        this.cFr.setTextColor(getContext().getResources().getColor(z ? R.color.color_ff5e13 : R.color.color_ff5e13_p50));
    }

    /* renamed from: eV */
    public void mo28283eV(boolean z) {
        int i = 8;
        this.cFo.setVisibility(z ? 0 : 8);
        ImageButton imageButton = this.cFp;
        if (z) {
            i = 0;
        }
        imageButton.setVisibility(i);
    }

    /* renamed from: eW */
    public void mo28284eW(boolean z) {
        this.cFo.setAlpha(z ? 1.0f : 0.5f);
        this.cFo.setEnabled(z);
    }

    /* renamed from: eX */
    public void mo28285eX(boolean z) {
        this.cFp.setAlpha(z ? 1.0f : 0.5f);
        this.cFp.setEnabled(z);
    }

    /* renamed from: eY */
    public void mo28286eY(boolean z) {
        if (this.cFr != null) {
            this.cFr.setVisibility(z ? 0 : 8);
        }
    }

    /* renamed from: eZ */
    public void mo28287eZ(boolean z) {
        if (this.cFq != null) {
            this.cFq.setVisibility(z ? 0 : 8);
        }
    }

    public View getRedoView() {
        return this.cFp;
    }

    public View getUndoView() {
        return this.cFo;
    }

    public void hide() {
        this.cFm = false;
        startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.activity_slide_out_to_top));
        setVisibility(8);
    }

    /* renamed from: lY */
    public void mo28291lY(int i) {
        this.cFn.setImageResource(i);
    }

    /* renamed from: lZ */
    public void mo28292lZ(int i) {
        if (this.cFr != null) {
            this.cFr.setText(i);
        }
    }

    public void setTitleListener(C5865a aVar) {
        this.cFl = aVar;
    }

    public void show() {
        this.cFm = true;
        setVisibility(0);
        startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.activity_slide_in_from_top));
    }
}
