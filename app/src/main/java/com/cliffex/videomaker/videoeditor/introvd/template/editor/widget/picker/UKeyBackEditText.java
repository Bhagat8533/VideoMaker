package com.introvd.template.editor.widget.picker;

import android.content.Context;
import android.support.p024v7.widget.AppCompatEditText;
import android.util.AttributeSet;
import android.view.KeyEvent;

public class UKeyBackEditText extends AppCompatEditText {
    private C7046a drf;

    /* renamed from: com.introvd.template.editor.widget.picker.UKeyBackEditText$a */
    public interface C7046a {
        void auH();
    }

    public UKeyBackEditText(Context context) {
        super(context);
    }

    public UKeyBackEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public UKeyBackEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1 && this.drf != null) {
            this.drf.auH();
        }
        return super.onKeyPreIme(i, keyEvent);
    }

    public void setKeyBackListener(C7046a aVar) {
        this.drf = aVar;
    }
}
