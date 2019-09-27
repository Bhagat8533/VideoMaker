package com.introvd.template.module.iap.utils.animation;

import android.text.SpannableStringBuilder;
import android.widget.TextView;

/* renamed from: com.introvd.template.module.iap.utils.animation.a */
public class C8076a {
    private TextView dWh;
    private long dWi;
    private float dWj;
    private JumpForTextSpan[] dWk;
    private long duration;
    private int endPos;
    private int startPos;
    private CharSequence text;

    /* renamed from: com.introvd.template.module.iap.utils.animation.a$a */
    public static class C8077a {
        private final TextView dWh;
        private long dWi = -1;
        private float dWj = 0.65f;
        private long duration = 1200;
        private int endPos;
        private int startPos;
        private CharSequence text;

        public C8077a(TextView textView) {
            this.dWh = textView;
            this.text = textView.getText();
            this.startPos = 0;
            this.endPos = this.text.length();
        }

        public C8076a aER() {
            if (this.dWi < 0) {
                if (this.endPos - this.startPos > 0) {
                    this.dWi = this.duration / ((long) ((this.endPos - this.startPos) * 2));
                } else {
                    this.dWi = 0;
                }
            }
            C8076a aVar = new C8076a(this.dWh, this.text, this.duration, this.dWi, this.startPos, this.endPos, this.dWj);
            aVar.create();
            return aVar;
        }

        /* renamed from: sO */
        public C8077a mo33130sO(int i) {
            this.startPos = i;
            return this;
        }

        /* renamed from: sP */
        public C8077a mo33131sP(int i) {
            this.endPos = i;
            return this;
        }
    }

    public C8076a(TextView textView, CharSequence charSequence, long j, long j2, int i, int i2, float f) {
        this.dWh = textView;
        this.duration = j;
        this.dWi = j2;
        this.startPos = i;
        this.endPos = i2;
        this.dWj = f;
        this.text = charSequence;
    }

    /* renamed from: i */
    public static C8077a m23436i(TextView textView) {
        return new C8077a(textView);
    }

    public void aEQ() {
        JumpForTextSpan[] jumpForTextSpanArr;
        if (this.dWk != null) {
            for (JumpForTextSpan jumpForTextSpan : this.dWk) {
                if (jumpForTextSpan != null) {
                    jumpForTextSpan.aEQ();
                }
            }
        }
    }

    public void create() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.text);
        this.dWk = new JumpForTextSpan[(this.endPos - this.startPos)];
        int i = this.startPos;
        while (i < this.endPos) {
            JumpForTextSpan jumpForTextSpan = new JumpForTextSpan(this.dWh, this.duration, this.dWi * ((long) i), this.dWj);
            int i2 = i + 1;
            spannableStringBuilder.setSpan(jumpForTextSpan, i, i2, 33);
            this.dWk[i - this.startPos] = jumpForTextSpan;
            i = i2;
        }
        this.dWh.setText(spannableStringBuilder);
    }
}
