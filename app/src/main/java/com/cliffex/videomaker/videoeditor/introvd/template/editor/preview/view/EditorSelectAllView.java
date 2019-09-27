package com.introvd.template.editor.preview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import com.introvd.template.editor.R;
import com.p131c.p132a.p133a.C2564c;
import com.p131c.p132a.p135c.p136a.C2579b;
import com.p131c.p132a.p135c.p136a.C2579b.C2582a;

public class EditorSelectAllView extends RelativeLayout {
    ImageButton ddW;
    private Animation ded;
    /* access modifiers changed from: private */
    public C6685a dee;

    /* renamed from: com.introvd.template.editor.preview.view.EditorSelectAllView$a */
    public interface C6685a {
        /* renamed from: gI */
        void mo29945gI(boolean z);
    }

    public EditorSelectAllView(Context context) {
        this(context, null);
    }

    public EditorSelectAllView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EditorSelectAllView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.ded = AnimationUtils.loadAnimation(getContext(), R.anim.editor_anim_select_all_view_show);
        LayoutInflater.from(getContext()).inflate(R.layout.editor_select_all_view_layout, this, true);
        this.ddW = (ImageButton) findViewById(R.id.btn_select);
        C2579b.m7398a(new C2582a<View>() {
            public void onClick(View view) {
                C2564c.show(EditorSelectAllView.this.ddW);
                EditorSelectAllView.this.mo30085gU(!EditorSelectAllView.this.ddW.isSelected());
                if (EditorSelectAllView.this.dee != null) {
                    EditorSelectAllView.this.dee.mo29945gI(EditorSelectAllView.this.ddW.isSelected());
                }
            }
        }, 600, this);
    }

    /* renamed from: gU */
    public void mo30085gU(boolean z) {
        this.ddW.setSelected(z);
        setBackgroundResource(z ? R.drawable.editor_shape_select_all_s_bg : R.drawable.editor_shape_select_all_bg);
    }

    public void hide(boolean z) {
        setVisibility(8);
        if (z) {
            mo30085gU(false);
        }
    }

    public void setListener(C6685a aVar) {
        this.dee = aVar;
    }

    public void show() {
        setVisibility(0);
        startAnimation(this.ded);
    }
}
