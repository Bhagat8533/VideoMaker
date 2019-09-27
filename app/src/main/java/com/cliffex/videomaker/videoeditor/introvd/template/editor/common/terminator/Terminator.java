package com.introvd.template.editor.common.terminator;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.editor.R;
import com.p131c.p132a.p135c.p136a.C2579b;
import com.p131c.p132a.p135c.p136a.C2579b.C2582a;

public class Terminator extends RelativeLayout {
    private TextView cFf;
    private ImageView cFg;
    private ImageView cFh;
    private FrameLayout cFi;
    /* access modifiers changed from: private */
    public C5858a cFj;

    /* renamed from: com.introvd.template.editor.common.terminator.Terminator$a */
    public interface C5858a {
        void aeW();

        void aeX();
    }

    public Terminator(Context context) {
        this(context, null);
    }

    public Terminator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Terminator(Context context, AttributeSet attributeSet, int i) {
        String str;
        super(context, attributeSet, i);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.Terminator);
            str = obtainStyledAttributes.getString(R.styleable.Terminator_terminatorText);
            obtainStyledAttributes.recycle();
        } else {
            str = null;
        }
        m16394eg(str);
    }

    /* renamed from: eg */
    private void m16394eg(String str) {
        LayoutInflater.from(getContext()).inflate(R.layout.editor_terminator_layout, this, true);
        this.cFf = (TextView) findViewById(R.id.terminator_title);
        this.cFg = (ImageView) findViewById(R.id.terminator_left);
        this.cFh = (ImageView) findViewById(R.id.terminator_right);
        this.cFi = (FrameLayout) findViewById(R.id.terminator_content);
        if (!TextUtils.isEmpty(str)) {
            this.cFf.setVisibility(0);
            this.cFf.setText(str);
        }
        C2579b.m7398a(new C2582a<View>() {
            public void onClick(View view) {
                if (Terminator.this.cFj != null) {
                    Terminator.this.cFj.aeW();
                }
            }
        }, 500, this.cFg);
        C2579b.m7398a(new C2582a<View>() {
            public void onClick(View view) {
                if (Terminator.this.cFj != null) {
                    Terminator.this.cFj.aeX();
                }
            }
        }, 500, this.cFh);
    }

    public void setBtnVisibility(boolean z) {
        int i = 8;
        if (this.cFg != null) {
            this.cFg.setVisibility(z ? 0 : 8);
        }
        if (this.cFh != null) {
            ImageView imageView = this.cFh;
            if (z) {
                i = 0;
            }
            imageView.setVisibility(i);
        }
    }

    public void setTerminatorListener(C5858a aVar) {
        this.cFj = aVar;
    }

    public void setTitle(int i) {
        setTitle((CharSequence) getContext().getString(i));
    }

    public void setTitle(CharSequence charSequence) {
        this.cFi.setVisibility(8);
        this.cFf.setVisibility(0);
        if (!TextUtils.isEmpty(charSequence)) {
            this.cFf.setText(charSequence);
        }
    }

    public void setTitleContentLayout(View view) {
        this.cFf.setVisibility(8);
        this.cFi.removeAllViews();
        this.cFi.setVisibility(0);
        this.cFi.addView(view);
    }
}
