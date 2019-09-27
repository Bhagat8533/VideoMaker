package com.introvd.template.common.p236ui.emoji;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Spannable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView.BufferType;
import xiaoying.quvideo.com.vivabase.C10122R;

/* renamed from: com.introvd.template.common.ui.emoji.EmojiconEditText */
public class EmojiconEditText extends EditText {
    private int chB;
    private int chC;
    private boolean chD;
    private onTextChangedListener chE;
    private onSoftKeyBoardKeyEventListener chF;

    /* renamed from: com.introvd.template.common.ui.emoji.EmojiconEditText$onSoftKeyBoardKeyEventListener */
    public interface onSoftKeyBoardKeyEventListener {
        boolean onKeyPreIme(int i, KeyEvent keyEvent);
    }

    /* renamed from: com.introvd.template.common.ui.emoji.EmojiconEditText$onTextChangedListener */
    public interface onTextChangedListener {
        void onChanged(Spannable spannable);
    }

    public EmojiconEditText(Context context) {
        super(context);
        this.chD = true;
        this.chB = (int) getTextSize();
        this.chC = (int) getTextSize();
    }

    public EmojiconEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.chD = true;
        m14513a(attributeSet);
    }

    public EmojiconEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.chD = true;
        m14513a(attributeSet);
    }

    /* renamed from: a */
    private void m14513a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C10122R.styleable.Emojicon);
        this.chB = (int) obtainStyledAttributes.getDimension(C10122R.styleable.Emojicon_emojiconSize, getTextSize());
        this.chD = obtainStyledAttributes.getBoolean(C10122R.styleable.Emojicon_emojiconUseSystemDefault, false);
        obtainStyledAttributes.recycle();
        this.chC = (int) getTextSize();
        setText(getText());
    }

    private void updateText() {
        EmojiconHandler.addEmojis(getContext(), getText(), this.chB, this.chC, true);
    }

    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (this.chF != null) {
            this.chF.onKeyPreIme(i, keyEvent);
        }
        return super.onKeyPreIme(i, keyEvent);
    }

    /* access modifiers changed from: protected */
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        updateText();
        if (this.chE != null) {
            this.chE.onChanged(getText());
        }
    }

    public void setChangedListener(onTextChangedListener ontextchangedlistener) {
        this.chE = ontextchangedlistener;
    }

    public void setEmojiconSize(int i) {
        this.chB = i;
        updateText();
    }

    public void setOnSoftKeyBoardKeyEventListener(onSoftKeyBoardKeyEventListener onsoftkeyboardkeyeventlistener) {
        this.chF = onsoftkeyboardkeyeventlistener;
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
        super.setText(charSequence, bufferType);
    }

    public void setUseSystemDefault(boolean z) {
        this.chD = z;
    }
}
