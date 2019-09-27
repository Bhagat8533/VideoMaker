package com.introvd.template.common.p236ui.emoji;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView.BufferType;
import com.introvd.template.common.p236ui.SpannableTextView;
import xiaoying.quvideo.com.vivabase.C10122R;

/* renamed from: com.introvd.template.common.ui.emoji.EmojiconTextView */
public class EmojiconTextView extends SpannableTextView {
    private int chB;
    private int chC;
    private int chO = 0;
    private int chP = -1;

    public EmojiconTextView(Context context) {
        super(context);
        m14517a(null);
    }

    public EmojiconTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m14517a(attributeSet);
    }

    public EmojiconTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m14517a(attributeSet);
    }

    /* renamed from: a */
    private void m14517a(AttributeSet attributeSet) {
        this.chC = (int) getTextSize();
        if (attributeSet == null) {
            this.chB = (int) getTextSize();
        } else {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C10122R.styleable.Emojicon);
            this.chB = (int) obtainStyledAttributes.getDimension(C10122R.styleable.Emojicon_emojiconSize, getTextSize());
            this.chO = obtainStyledAttributes.getInteger(C10122R.styleable.Emojicon_emojiconTextStart, 0);
            this.chP = obtainStyledAttributes.getInteger(C10122R.styleable.Emojicon_emojiconTextLength, -1);
            obtainStyledAttributes.getBoolean(C10122R.styleable.Emojicon_emojiconUseSystemDefault, false);
            obtainStyledAttributes.recycle();
        }
        setText(getText());
    }

    public void setEmojiconSize(int i) {
        this.chB = i;
        super.setText(getText());
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
        if (!TextUtils.isEmpty(charSequence)) {
            Spannable spannableStringBuilder = new SpannableStringBuilder(charSequence);
            EmojiconHandler.addEmojis(getContext(), spannableStringBuilder, this.chB, this.chC, this.chO, this.chP, true);
            charSequence = spannableStringBuilder;
        }
        super.setText(charSequence, bufferType);
    }

    public void setUseSystemDefault(boolean z) {
    }
}
