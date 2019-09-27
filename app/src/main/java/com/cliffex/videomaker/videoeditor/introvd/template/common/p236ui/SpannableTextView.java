package com.introvd.template.common.p236ui;

import android.content.Context;
import android.graphics.Canvas;
import android.support.p024v7.widget.AppCompatTextView;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.method.Touch;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;
import com.introvd.template.common.p236ui.SpannableTextInfo.SpanInfoBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import xiaoying.quvideo.com.vivabase.C10122R;

/* renamed from: com.introvd.template.common.ui.SpannableTextView */
public class SpannableTextView extends AppCompatTextView {
    private static Pattern cfZ = Pattern.compile("\t|\r|\n");
    private SpannableString cfX;
    private int cfY;
    private C5311d cga;
    private C5312e cgb;
    private C5313f cgc;
    private Context mContext = null;
    protected OnLineCountListener mOnLineCountListener;
    protected int maxLine = Integer.MAX_VALUE;

    /* renamed from: com.introvd.template.common.ui.SpannableTextView$OnLineCountListener */
    public interface OnLineCountListener {
        void onLineCountCallback();
    }

    /* renamed from: com.introvd.template.common.ui.SpannableTextView$OnSpannableTextClickListener */
    public interface OnSpannableTextClickListener {
        void onTextClicked(View view, String str);
    }

    /* renamed from: com.introvd.template.common.ui.SpannableTextView$a */
    private class C5308a extends ClickableSpan implements OnClickListener {
        private final OnClickListener bDF;
        private int[] cge;
        private int mTextColor;

        public C5308a(int i, OnClickListener onClickListener) {
            this.bDF = onClickListener;
            this.mTextColor = i;
        }

        public C5308a(int[] iArr, int i, OnClickListener onClickListener) {
            this.bDF = onClickListener;
            this.mTextColor = i;
            this.cge = iArr;
        }

        public void onClick(View view) {
            if (this.bDF != null) {
                if (this.cge != null) {
                    view.setTag(this.cge);
                }
                this.bDF.onClick(view);
            }
        }

        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(this.mTextColor);
            textPaint.setUnderlineText(false);
        }
    }

    /* renamed from: com.introvd.template.common.ui.SpannableTextView$b */
    private class C5309b extends ClickableSpan implements OnClickListener {
        private int[] cge;
        private final OnSpannableTextClickListener cgf;
        private int mTextColor;
        private String text;

        public C5309b(int[] iArr, String str, int i, OnSpannableTextClickListener onSpannableTextClickListener) {
            this.cgf = onSpannableTextClickListener;
            this.mTextColor = i;
            this.cge = iArr;
            this.text = str;
        }

        public void onClick(View view) {
            if (this.cgf != null) {
                if (this.cge != null) {
                    view.setTag(this.cge);
                }
                this.cgf.onTextClicked(view, this.text);
            }
        }

        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(this.mTextColor);
            textPaint.setUnderlineText(false);
        }
    }

    /* renamed from: com.introvd.template.common.ui.SpannableTextView$c */
    private static class C5310c extends LinkMovementMethod {
        static C5310c cgg;

        private C5310c() {
        }

        /* renamed from: Zt */
        public static C5310c m14439Zt() {
            if (cgg == null) {
                cgg = new C5310c();
            }
            return cgg;
        }

        public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 1 || action == 0) {
                int x = (((int) motionEvent.getX()) - textView.getTotalPaddingLeft()) + textView.getScrollX();
                int y = (((int) motionEvent.getY()) - textView.getTotalPaddingTop()) + textView.getScrollY();
                Layout layout = textView.getLayout();
                try {
                    int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(y), (float) x);
                    ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
                    if (clickableSpanArr.length != 0) {
                        if (action == 1) {
                            clickableSpanArr[0].onClick(textView);
                        } else if (action == 0) {
                            Selection.setSelection(spannable, spannable.getSpanStart(clickableSpanArr[0]), spannable.getSpanEnd(clickableSpanArr[0]));
                        }
                        return true;
                    }
                    Selection.removeSelection(spannable);
                    Touch.onTouchEvent(textView, spannable, motionEvent);
                    return false;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return false;
        }
    }

    /* renamed from: com.introvd.template.common.ui.SpannableTextView$d */
    private class C5311d {
        int cgh;
        int cgi;
        OnClickListener cgj;
        int spanColor;
        String text;

        public C5311d(String str, int i, int i2, int i3, OnClickListener onClickListener) {
            this.text = str;
            this.cgh = i;
            this.cgi = i2;
            this.spanColor = i3;
            this.cgj = onClickListener;
        }
    }

    /* renamed from: com.introvd.template.common.ui.SpannableTextView$e */
    private class C5312e {
        OnClickListener cgj;
        ArrayList<int[]> cgk;
        int spanColor;
        String text;

        public C5312e(String str, ArrayList<int[]> arrayList, int i, OnClickListener onClickListener) {
            this.text = str;
            this.cgk = arrayList;
            this.spanColor = i;
            this.cgj = onClickListener;
        }
    }

    /* renamed from: com.introvd.template.common.ui.SpannableTextView$f */
    private class C5313f {
        SpannableTextInfo cgl;
        OnSpannableTextClickListener cgm;

        public C5313f(SpannableTextInfo spannableTextInfo, OnSpannableTextClickListener onSpannableTextClickListener) {
            this.cgl = spannableTextInfo;
            this.cgm = onSpannableTextClickListener;
        }
    }

    public SpannableTextView(Context context) {
        super(context);
        this.mContext = context;
        m14432Zq();
    }

    public SpannableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        m14432Zq();
    }

    public SpannableTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        m14432Zq();
    }

    /* renamed from: Zq */
    private void m14432Zq() {
        this.cfY = this.mContext.getResources().getColor(C10122R.color.color_d9d9d9);
        setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                TextView textView = (TextView) view;
                CharSequence text = textView.getText();
                if (text instanceof Spanned) {
                    Spanned spanned = (Spanned) text;
                    int action = motionEvent.getAction();
                    if (action == 1 || action == 0) {
                        int x = (int) motionEvent.getX();
                        try {
                            int totalPaddingLeft = (x - textView.getTotalPaddingLeft()) + textView.getScrollX();
                            int y = (((int) motionEvent.getY()) - textView.getTotalPaddingTop()) + textView.getScrollY();
                            Layout layout = textView.getLayout();
                            if (layout != null) {
                                int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(y), (float) totalPaddingLeft);
                                ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spanned.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
                                if (clickableSpanArr.length != 0) {
                                    if (action == 1) {
                                        clickableSpanArr[0].onClick(textView);
                                    }
                                    return true;
                                }
                            }
                        } catch (Exception unused) {
                        }
                    }
                }
                return false;
            }
        });
        getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                SpannableTextView.this.m14433Zr();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: Zr */
    public void m14433Zr() {
        if (this.mOnLineCountListener != null) {
            this.mOnLineCountListener.onLineCountCallback();
        }
    }

    /* renamed from: Zs */
    private void m14434Zs() {
        if (this.cfX != null) {
            int lineCount = getLineCount();
            if (this.maxLine == Integer.MAX_VALUE || lineCount < this.maxLine) {
                setText(this.cfX);
            } else if (getLayout() != null && lineCount > 1) {
                int lineEnd = getLayout().getLineEnd(this.maxLine - 1);
                if (lineEnd > 3) {
                    if (getText().length() > 3) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(getText().subSequence(0, lineEnd - 3));
                        sb.append("...");
                        String sb2 = sb.toString();
                        SpannableString spannableString = this.cga != null ? m14435a(sb2, this.cga) : this.cgb != null ? m14436a(sb2, this.cgb) : this.cgc != null ? m14437a(sb2, this.cgc) : new SpannableString(sb2);
                        setText(spannableString);
                    } else {
                        setText(this.cfX);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private SpannableString m14435a(String str, C5311d dVar) {
        SpannableString spannableString = new SpannableString(str);
        int i = dVar.cgh;
        int length = dVar.cgi > str.length() ? str.length() : dVar.cgi;
        if (i <= length && i <= str.length() - 1) {
            spannableString.setSpan(new C5308a(dVar.spanColor, dVar.cgj), i, length, 33);
        }
        return spannableString;
    }

    /* renamed from: a */
    private SpannableString m14436a(String str, C5312e eVar) {
        SpannableString spannableString = new SpannableString(str);
        Iterator it = eVar.cgk.iterator();
        while (it.hasNext()) {
            int[] iArr = (int[]) it.next();
            int i = iArr[0];
            int length = iArr[1] + 1 > str.length() ? str.length() : iArr[1] + 1;
            if (i <= length && i <= str.length() - 1) {
                if (eVar.cgj != null) {
                    spannableString.setSpan(new C5308a(iArr, eVar.spanColor, eVar.cgj), i, length, 33);
                } else {
                    spannableString.setSpan(new ForegroundColorSpan(eVar.spanColor), i, length, 33);
                }
            }
        }
        return spannableString;
    }

    /* renamed from: a */
    private SpannableString m14437a(String str, C5313f fVar) {
        C5313f fVar2 = fVar;
        SpannableString spannableString = new SpannableString(str);
        for (SpanInfoBean spanInfoBean : fVar2.cgl.spanTextList) {
            int i = spanInfoBean.startIndexOfText;
            int length = spanInfoBean.startIndexOfText + spanInfoBean.spanText.length();
            if (length > str.length()) {
                length = str.length();
            }
            if (i <= length && i <= str.length() - 1) {
                if (spanInfoBean.type == 1) {
                    spannableString.setSpan(new StyleSpan(1), i, length, 33);
                    if (fVar2.cgm != null) {
                        C5309b bVar = new C5309b(new int[]{i, length}, spanInfoBean.spanText, spanInfoBean.spanColor, fVar2.cgm);
                        spannableString.setSpan(bVar, i, length, 33);
                    } else {
                        spannableString.setSpan(new ForegroundColorSpan(spanInfoBean.spanColor), i, length, 33);
                    }
                } else if (fVar2.cgm != null) {
                    C5309b bVar2 = new C5309b(new int[]{i, length}, spanInfoBean.spanText, spanInfoBean.spanColor, fVar2.cgm);
                    spannableString.setSpan(bVar2, i, length, 33);
                } else {
                    spannableString.setSpan(new ForegroundColorSpan(spanInfoBean.spanColor), i, length, 33);
                }
            }
        }
        return spannableString;
    }

    public static String replaceBlank(String str) {
        return str != null ? cfZ.matcher(str).replaceAll(" ") : "";
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m14433Zr();
    }

    public void setMaxLines(int i) {
        this.maxLine = i;
        m14434Zs();
        super.setMaxLines(i);
    }

    public void setOnLineCountListener(OnLineCountListener onLineCountListener) {
        this.mOnLineCountListener = onLineCountListener;
    }

    public void setSpanText(SpannableTextInfo spannableTextInfo, OnSpannableTextClickListener onSpannableTextClickListener) {
        try {
            spannableTextInfo.text = replaceBlank(spannableTextInfo.text);
            this.cgc = new C5313f(spannableTextInfo, onSpannableTextClickListener);
            this.cfX = m14437a(spannableTextInfo.text, this.cgc);
            this.cga = null;
            this.cgb = null;
            if (onSpannableTextClickListener != null) {
                setMovementMethod(C5310c.m14439Zt());
            }
            setText(this.cfX);
            setHighlightColor(0);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        if (this.maxLine != Integer.MAX_VALUE) {
            m14434Zs();
        }
    }

    public void setSpanText(String str, int i, int i2, int i3, OnClickListener onClickListener) {
        String replaceBlank = replaceBlank(str);
        C5311d dVar = new C5311d(replaceBlank, i, i2, i3, onClickListener);
        this.cga = dVar;
        this.cfX = m14435a(replaceBlank, this.cga);
        this.cgb = null;
        this.cgc = null;
        setText(this.cfX);
        setMovementMethod(C5310c.m14439Zt());
        setHighlightColor(this.cfY);
        setBackgroundResource(C10122R.C10123drawable.v4_xiaoying_com_spannable_textview_bg_color_selector);
        if (this.maxLine != Integer.MAX_VALUE) {
            m14434Zs();
        }
    }

    public void setSpanText(String str, ArrayList<int[]> arrayList, int i, int i2, int i3, OnClickListener onClickListener) {
        String replaceBlank = replaceBlank(str);
        C5312e eVar = new C5312e(replaceBlank, arrayList, i, onClickListener);
        this.cgb = eVar;
        this.cfX = m14436a(replaceBlank, this.cgb);
        this.cga = null;
        this.cgc = null;
        setMovementMethod(C5310c.m14439Zt());
        setText(this.cfX);
        if (i2 != -1) {
            setHighlightColor(this.cfY);
        }
        setBackgroundResource(i3);
        if (this.maxLine != Integer.MAX_VALUE) {
            m14434Zs();
        }
    }
}
