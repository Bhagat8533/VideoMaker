package com.introvd.template.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.BlurMaskFilter.Blur;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore.Images.Media;
import android.support.p021v4.content.ContextCompat;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.LeadingMarginSpan;
import android.text.style.LeadingMarginSpan.Standard;
import android.text.style.LineHeightSpan;
import android.text.style.MaskFilterSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ReplacementSpan;
import android.text.style.ScaleXSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.text.style.UpdateAppearance;
import android.util.Log;
import com.introvd.template.VivaBaseApplication;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;

public final class SpanUtils {
    private static final String ezS = System.getProperty("line.separator");
    private int backgroundColor;
    private int eAA;
    private int eAB;
    private SpannableStringBuilder eAC = new SpannableStringBuilder();
    private final int eAD = 0;
    private final int eAE = 1;
    private final int eAF = 2;
    private int eAa;
    private Bitmap eAb;
    private Drawable eAc;
    private Uri eAd;
    private int eAe;
    private int eAf;
    private int eAg;
    private boolean eAh;
    private float eAi;
    private float eAj;
    private boolean eAk;
    private boolean eAl;
    private boolean eAm;
    private boolean eAn;
    private boolean eAo;
    private boolean eAp;
    private Alignment eAq;
    private ClickableSpan eAr;
    private float eAs;
    private Blur eAt;
    private Shader eAu;
    private Object[] eAv;
    private Bitmap eAw;
    private Drawable eAx;
    private int eAy;
    private int eAz;
    private int ezT;
    private int ezU;
    private int ezV;
    private int ezW;
    private int ezX;
    private int ezY;
    private int ezZ;
    private int first;
    private int flag;
    private String fontFamily;
    private int fontSize;
    private int foregroundColor;
    private Uri imageUri;
    private boolean isBold;
    private int lineHeight;
    private CharSequence mText = "";
    private int mType;

    /* renamed from: qs */
    private float f3633qs;

    /* renamed from: qt */
    private float f3634qt;

    /* renamed from: qu */
    private float f3635qu;
    private int shadowColor;
    private Typeface typeface;
    private String url;

    @SuppressLint({"ParcelCreator"})
    class CustomTypefaceSpan extends TypefaceSpan {
        private final Typeface eAO;

        CustomTypefaceSpan(Typeface typeface) {
            super("");
            this.eAO = typeface;
        }

        /* renamed from: a */
        private void m26416a(Paint paint, Typeface typeface) {
            Typeface typeface2 = paint.getTypeface();
            int style = (typeface2 == null ? 0 : typeface2.getStyle()) & (~typeface.getStyle());
            if ((style & 1) != 0) {
                paint.setFakeBoldText(true);
            }
            if ((style & 2) != 0) {
                paint.setTextSkewX(-0.25f);
            }
            paint.getShader();
            paint.setTypeface(typeface);
        }

        public void updateDrawState(TextPaint textPaint) {
            m26416a(textPaint, this.eAO);
        }

        public void updateMeasureState(TextPaint textPaint) {
            m26416a(textPaint, this.eAO);
        }
    }

    /* renamed from: com.introvd.template.util.SpanUtils$a */
    class C8996a implements LeadingMarginSpan {
        private final int color;
        private final int eAG;
        private Path eAH = null;
        private final int radius;

        C8996a(int i, int i2, int i3) {
            this.color = i;
            this.radius = i2;
            this.eAG = i3;
        }

        public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
            if (((Spanned) charSequence).getSpanStart(this) == i6) {
                Style style = paint.getStyle();
                int color2 = paint.getColor();
                paint.setColor(this.color);
                paint.setStyle(Style.FILL);
                if (canvas.isHardwareAccelerated()) {
                    if (this.eAH == null) {
                        this.eAH = new Path();
                        this.eAH.addCircle(0.0f, 0.0f, (float) this.radius, Direction.CW);
                    }
                    canvas.save();
                    canvas.translate((float) (i + (i2 * this.radius)), ((float) (i3 + i5)) / 2.0f);
                    canvas.drawPath(this.eAH, paint);
                    canvas.restore();
                } else {
                    canvas.drawCircle((float) (i + (i2 * this.radius)), ((float) (i3 + i5)) / 2.0f, (float) this.radius, paint);
                }
                paint.setColor(color2);
                paint.setStyle(style);
            }
        }

        public int getLeadingMargin(boolean z) {
            return (this.radius * 2) + this.eAG;
        }
    }

    /* renamed from: com.introvd.template.util.SpanUtils$b */
    abstract class C8997b extends ReplacementSpan {
        private WeakReference<Drawable> chN;
        final int mVerticalAlignment;

        C8997b(int i) {
            this.mVerticalAlignment = i;
        }

        /* renamed from: Zy */
        private Drawable m26417Zy() {
            WeakReference<Drawable> weakReference = this.chN;
            if ((weakReference != null ? (Drawable) weakReference.get() : null) == null) {
                this.chN = new WeakReference<>(getDrawable());
            }
            return getDrawable();
        }

        public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
            Drawable Zy = m26417Zy();
            Rect bounds = Zy.getBounds();
            canvas.save();
            float f2 = paint.getFontMetrics().descent - paint.getFontMetrics().ascent;
            int i6 = i5 - bounds.bottom;
            if (((float) bounds.height()) < f2) {
                if (this.mVerticalAlignment == 1) {
                    i6 -= paint.getFontMetricsInt().descent;
                } else if (this.mVerticalAlignment == 2) {
                    i6 = (int) (((float) i6) - ((f2 - ((float) bounds.height())) / 2.0f));
                } else if (this.mVerticalAlignment == 3) {
                    i6 = (int) (((float) i6) - (f2 - ((float) bounds.height())));
                }
            }
            canvas.translate(f, (float) i6);
            paint.measureText(charSequence, i, i2);
            Zy.draw(canvas);
            paint.measureText(charSequence, i, i2);
            canvas.restore();
        }

        public abstract Drawable getDrawable();

        public int getSize(Paint paint, CharSequence charSequence, int i, int i2, FontMetricsInt fontMetricsInt) {
            Rect bounds = m26417Zy().getBounds();
            int i3 = (int) (paint.getFontMetrics().descent - paint.getFontMetrics().ascent);
            if (fontMetricsInt != null && bounds.height() > i3) {
                if (this.mVerticalAlignment == 3) {
                    fontMetricsInt.descent += bounds.height() - i3;
                } else if (this.mVerticalAlignment == 2) {
                    fontMetricsInt.ascent -= (bounds.height() - i3) / 2;
                    fontMetricsInt.descent += (bounds.height() - i3) / 2;
                } else {
                    fontMetricsInt.ascent -= bounds.height() - i3;
                }
            }
            return bounds.right;
        }
    }

    /* renamed from: com.introvd.template.util.SpanUtils$c */
    class C8998c implements LeadingMarginSpan, LineHeightSpan {
        private boolean dJc;
        private int eAJ;
        private int eAK;
        private int eAL;
        private int eAM;
        private int lineHeight;
        Bitmap mBitmap;
        final int mVerticalAlignment;

        C8998c(Context context, int i, int i2, int i3) {
            this.mBitmap = m26419aq(context, i);
            this.eAJ = i2;
            this.mVerticalAlignment = i3;
        }

        C8998c(Context context, Uri uri, int i, int i2) {
            this.mBitmap = m26420f(context, uri);
            this.eAJ = i;
            this.mVerticalAlignment = i2;
        }

        C8998c(Bitmap bitmap, int i, int i2) {
            this.mBitmap = bitmap;
            this.eAJ = i;
            this.mVerticalAlignment = i2;
        }

        C8998c(Drawable drawable, int i, int i2) {
            this.mBitmap = m26418M(drawable);
            this.eAJ = i;
            this.mVerticalAlignment = i2;
        }

        /* renamed from: M */
        private Bitmap m26418M(Drawable drawable) {
            Bitmap bitmap;
            if (drawable instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                if (bitmapDrawable.getBitmap() != null) {
                    return bitmapDrawable.getBitmap();
                }
            }
            if (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
                bitmap = Bitmap.createBitmap(1, 1, drawable.getOpacity() != -1 ? Config.ARGB_8888 : Config.RGB_565);
            } else {
                bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Config.ARGB_8888 : Config.RGB_565);
            }
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return bitmap;
        }

        /* renamed from: aq */
        private Bitmap m26419aq(Context context, int i) {
            Drawable drawable = ContextCompat.getDrawable(context, i);
            if (drawable == null) {
                return null;
            }
            Canvas canvas = new Canvas();
            Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Config.ARGB_8888);
            canvas.setBitmap(createBitmap);
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            drawable.draw(canvas);
            return createBitmap;
        }

        /* renamed from: f */
        private Bitmap m26420f(Context context, Uri uri) {
            try {
                return Media.getBitmap(context.getContentResolver(), uri);
            } catch (IOException e) {
                e.printStackTrace();
                return Bitmap.createBitmap(1, 1, Config.ARGB_8888);
            }
        }

        public void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, FontMetricsInt fontMetricsInt) {
            if (this.lineHeight == 0) {
                this.lineHeight = i4 - i3;
            }
            if (this.eAL == 0 && i2 == ((Spanned) charSequence).getSpanEnd(this)) {
                int height = this.mBitmap.getHeight();
                this.eAL = height - (((fontMetricsInt.descent + i4) - fontMetricsInt.ascent) - i3);
                this.eAM = height - (((fontMetricsInt.bottom + i4) - fontMetricsInt.top) - i3);
                this.eAK = (i4 - i3) + this.lineHeight;
                return;
            }
            if (this.eAL > 0 || this.eAM > 0) {
                if (this.mVerticalAlignment == 3) {
                    if (i2 == ((Spanned) charSequence).getSpanEnd(this)) {
                        if (this.eAL > 0) {
                            fontMetricsInt.descent += this.eAL;
                        }
                        if (this.eAM > 0) {
                            fontMetricsInt.bottom += this.eAM;
                        }
                    }
                } else if (this.mVerticalAlignment == 2) {
                    Spanned spanned = (Spanned) charSequence;
                    if (i == spanned.getSpanStart(this)) {
                        if (this.eAL > 0) {
                            fontMetricsInt.ascent -= this.eAL / 2;
                        }
                        if (this.eAM > 0) {
                            fontMetricsInt.top -= this.eAM / 2;
                        }
                    } else if (!this.dJc) {
                        if (this.eAL > 0) {
                            fontMetricsInt.ascent += this.eAL / 2;
                        }
                        if (this.eAM > 0) {
                            fontMetricsInt.top += this.eAM / 2;
                        }
                        this.dJc = true;
                    }
                    if (i2 == spanned.getSpanEnd(this)) {
                        if (this.eAL > 0) {
                            fontMetricsInt.descent += this.eAL / 2;
                        }
                        if (this.eAM > 0) {
                            fontMetricsInt.bottom += this.eAM / 2;
                        }
                    }
                } else if (i == ((Spanned) charSequence).getSpanStart(this)) {
                    if (this.eAL > 0) {
                        fontMetricsInt.ascent -= this.eAL;
                    }
                    if (this.eAM > 0) {
                        fontMetricsInt.top -= this.eAM;
                    }
                } else if (!this.dJc) {
                    if (this.eAL > 0) {
                        fontMetricsInt.ascent += this.eAL;
                    }
                    if (this.eAM > 0) {
                        fontMetricsInt.top += this.eAM;
                    }
                    this.dJc = true;
                }
            }
        }

        public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
            int lineTop = layout.getLineTop(layout.getLineForOffset(((Spanned) charSequence).getSpanStart(this)));
            if (i2 < 0) {
                i -= this.mBitmap.getWidth();
            }
            int height = this.eAK - this.mBitmap.getHeight();
            if (height <= 0) {
                canvas.drawBitmap(this.mBitmap, (float) i, (float) lineTop, paint);
            } else if (this.mVerticalAlignment == 3) {
                canvas.drawBitmap(this.mBitmap, (float) i, (float) lineTop, paint);
            } else if (this.mVerticalAlignment == 2) {
                canvas.drawBitmap(this.mBitmap, (float) i, (float) (lineTop + (height / 2)), paint);
            } else {
                canvas.drawBitmap(this.mBitmap, (float) i, (float) (lineTop + height), paint);
            }
        }

        public int getLeadingMargin(boolean z) {
            return this.mBitmap.getWidth() + this.eAJ;
        }
    }

    /* renamed from: com.introvd.template.util.SpanUtils$d */
    class C8999d extends C8997b {
        private Uri eAN;
        private Context mContext;
        private Drawable mDrawable;
        private int mResourceId;

        C8999d(Context context, int i, int i2) {
            super(i2);
            this.mContext = context;
            this.mResourceId = i;
        }

        C8999d(Context context, Bitmap bitmap, int i) {
            super(i);
            this.mContext = context;
            this.mDrawable = context != null ? new BitmapDrawable(context.getResources(), bitmap) : new BitmapDrawable(bitmap);
            int intrinsicWidth = this.mDrawable.getIntrinsicWidth();
            int intrinsicHeight = this.mDrawable.getIntrinsicHeight();
            Drawable drawable = this.mDrawable;
            if (intrinsicWidth <= 0) {
                intrinsicWidth = 0;
            }
            if (intrinsicHeight <= 0) {
                intrinsicHeight = 0;
            }
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }

        C8999d(Context context, Uri uri, int i) {
            super(i);
            this.mContext = context;
            this.eAN = uri;
        }

        C8999d(Drawable drawable, int i) {
            super(i);
            this.mDrawable = drawable;
            this.mDrawable.setBounds(0, 0, this.mDrawable.getIntrinsicWidth(), this.mDrawable.getIntrinsicHeight());
        }

        public Drawable getDrawable() {
            Drawable drawable;
            if (this.mDrawable != null) {
                return this.mDrawable;
            }
            Drawable drawable2 = null;
            if (this.eAN != null) {
                try {
                    InputStream openInputStream = this.mContext.getContentResolver().openInputStream(this.eAN);
                    BitmapDrawable bitmapDrawable = new BitmapDrawable(this.mContext.getResources(), BitmapFactory.decodeStream(openInputStream));
                    try {
                        bitmapDrawable.setBounds(0, 0, bitmapDrawable.getIntrinsicWidth(), bitmapDrawable.getIntrinsicHeight());
                        if (openInputStream != null) {
                            openInputStream.close();
                        }
                        return bitmapDrawable;
                    } catch (Exception e) {
                        e = e;
                        drawable2 = bitmapDrawable;
                        StringBuilder sb = new StringBuilder();
                        sb.append("Failed to loaded content ");
                        sb.append(this.eAN);
                        Log.e("sms", sb.toString(), e);
                        return drawable2;
                    }
                } catch (Exception e2) {
                    e = e2;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Failed to loaded content ");
                    sb2.append(this.eAN);
                    Log.e("sms", sb2.toString(), e);
                    return drawable2;
                }
            } else {
                try {
                    drawable = ContextCompat.getDrawable(this.mContext, this.mResourceId);
                    if (drawable == null) {
                        return drawable;
                    }
                    try {
                        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                        return drawable;
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                    drawable = null;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Unable to find resource: ");
                    sb3.append(this.mResourceId);
                    Log.e("sms", sb3.toString());
                    return drawable;
                }
            }
        }
    }

    /* renamed from: com.introvd.template.util.SpanUtils$e */
    class C9000e extends CharacterStyle implements LineHeightSpan {
        private final int height;
        final int mVerticalAlignment;

        C9000e(int i, int i2) {
            this.height = i;
            this.mVerticalAlignment = i2;
        }

        public void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, FontMetricsInt fontMetricsInt) {
            int i5 = this.height;
            int i6 = i5 - (((fontMetricsInt.descent + i4) - fontMetricsInt.ascent) - i3);
            if (i6 > 0) {
                if (this.mVerticalAlignment == 3) {
                    fontMetricsInt.descent += i6;
                } else if (this.mVerticalAlignment == 2) {
                    int i7 = i6 / 2;
                    fontMetricsInt.descent += i7;
                    fontMetricsInt.ascent -= i7;
                } else {
                    fontMetricsInt.ascent -= i6;
                }
            }
            int i8 = i5 - (((i4 + fontMetricsInt.bottom) - fontMetricsInt.top) - i3);
            if (i8 <= 0) {
                return;
            }
            if (this.mVerticalAlignment == 3) {
                fontMetricsInt.top += i8;
            } else if (this.mVerticalAlignment == 2) {
                int i9 = i8 / 2;
                fontMetricsInt.bottom += i9;
                fontMetricsInt.top -= i9;
            } else {
                fontMetricsInt.top -= i8;
            }
        }

        public void updateDrawState(TextPaint textPaint) {
        }
    }

    /* renamed from: com.introvd.template.util.SpanUtils$f */
    class C9001f implements LeadingMarginSpan {
        private final int color;
        private final int eAG;
        private final int ezV;

        C9001f(int i, int i2, int i3) {
            this.color = i;
            this.ezV = i2;
            this.eAG = i3;
        }

        public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i3, int i4, int i5, CharSequence charSequence, int i6, int i7, boolean z, Layout layout) {
            Paint paint2 = paint;
            int i8 = i;
            Style style = paint.getStyle();
            int color2 = paint.getColor();
            paint.setStyle(Style.FILL);
            paint.setColor(this.color);
            canvas.drawRect((float) i8, (float) i3, (float) (i8 + (this.ezV * i2)), (float) i5, paint);
            paint.setStyle(style);
            paint.setColor(color2);
        }

        public int getLeadingMargin(boolean z) {
            return this.ezV + this.eAG;
        }
    }

    /* renamed from: com.introvd.template.util.SpanUtils$g */
    class C9002g extends CharacterStyle implements UpdateAppearance {
        private Shader mShader;

        private C9002g(Shader shader) {
            this.mShader = shader;
        }

        public void updateDrawState(TextPaint textPaint) {
            textPaint.setShader(this.mShader);
        }
    }

    /* renamed from: com.introvd.template.util.SpanUtils$h */
    class C9003h extends CharacterStyle implements UpdateAppearance {
        private float eAP;
        private float eAQ;

        /* renamed from: oS */
        private float f3636oS;
        private int shadowColor;

        C9003h(float f, float f2, float f3, int i) {
            this.f3636oS = f;
            this.eAP = f2;
            this.eAQ = f3;
            this.shadowColor = i;
        }

        public void updateDrawState(TextPaint textPaint) {
            textPaint.setShadowLayer(this.f3636oS, this.eAP, this.eAQ, this.shadowColor);
        }
    }

    /* renamed from: com.introvd.template.util.SpanUtils$i */
    class C9004i extends ReplacementSpan {
        private final int color;
        private final int width;

        C9004i(int i, int i2) {
            this.width = i;
            this.color = i2;
        }

        public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i3, int i4, int i5, Paint paint) {
            Style style = paint.getStyle();
            int color2 = paint.getColor();
            paint.setStyle(Style.FILL);
            paint.setColor(this.color);
            canvas.drawRect(f, (float) i3, f + ((float) this.width), (float) i5, paint);
            paint.setStyle(style);
            paint.setColor(color2);
        }

        public int getSize(Paint paint, CharSequence charSequence, int i, int i2, FontMetricsInt fontMetricsInt) {
            return this.width;
        }
    }

    public SpanUtils() {
        aNi();
    }

    /* renamed from: LM */
    private void m26409LM() {
        int length = this.eAC.length();
        this.eAC.append("<img>");
        int i = length + 5;
        if (this.eAw != null) {
            this.eAC.setSpan(new C8999d(VivaBaseApplication.m8749FZ().getApplicationContext(), this.eAw, this.eAz), length, i, this.flag);
        } else if (this.eAx != null) {
            this.eAC.setSpan(new C8999d(this.eAx, this.eAz), length, i, this.flag);
        } else if (this.imageUri != null) {
            this.eAC.setSpan(new C8999d(VivaBaseApplication.m8749FZ().getApplicationContext(), this.imageUri, this.eAz), length, i, this.flag);
        } else if (this.eAy != -1) {
            this.eAC.setSpan(new C8999d(VivaBaseApplication.m8749FZ().getApplicationContext(), this.eAy, this.eAz), length, i, this.flag);
        }
    }

    private void aNi() {
        this.flag = 33;
        this.foregroundColor = 301989888;
        this.backgroundColor = 301989888;
        this.lineHeight = -1;
        this.ezU = 301989888;
        this.first = -1;
        this.ezY = 301989888;
        this.eAb = null;
        this.eAc = null;
        this.eAd = null;
        this.eAe = -1;
        this.eAf = -1;
        this.fontSize = -1;
        this.eAi = -1.0f;
        this.eAj = -1.0f;
        this.eAk = false;
        this.eAl = false;
        this.eAm = false;
        this.eAn = false;
        this.isBold = false;
        this.eAo = false;
        this.eAp = false;
        this.fontFamily = null;
        this.typeface = null;
        this.eAq = null;
        this.eAr = null;
        this.url = null;
        this.eAs = -1.0f;
        this.eAu = null;
        this.f3635qu = -1.0f;
        this.eAv = null;
        this.eAw = null;
        this.eAx = null;
        this.imageUri = null;
        this.eAy = -1;
        this.eAA = -1;
    }

    private void aNm() {
        if (this.mType == 0) {
            aNn();
        } else if (this.mType == 1) {
            m26409LM();
        } else if (this.mType == 2) {
            aNo();
        }
        aNi();
    }

    private void aNn() {
        if (this.mText != null && this.mText.length() != 0) {
            int length = this.eAC.length();
            this.eAC.append(this.mText);
            int length2 = this.eAC.length();
            if (this.foregroundColor != 301989888) {
                this.eAC.setSpan(new ForegroundColorSpan(this.foregroundColor), length, length2, this.flag);
            }
            if (this.backgroundColor != 301989888) {
                this.eAC.setSpan(new BackgroundColorSpan(this.backgroundColor), length, length2, this.flag);
            }
            if (this.lineHeight != -1) {
                this.eAC.setSpan(new C9000e(this.lineHeight, this.ezT), length, length2, this.flag);
            }
            if (this.first != -1) {
                this.eAC.setSpan(new Standard(this.first, this.ezX), length, length2, this.flag);
            }
            if (this.ezU != 301989888) {
                this.eAC.setSpan(new C9001f(this.ezU, this.ezV, this.ezW), length, length2, this.flag);
            }
            if (this.ezY != 301989888) {
                this.eAC.setSpan(new C8996a(this.ezY, this.ezZ, this.eAa), length, length2, this.flag);
            }
            if (this.eAf != -1) {
                if (this.eAb != null) {
                    this.eAC.setSpan(new C8998c(this.eAb, this.eAf, this.eAg), length, length2, this.flag);
                } else if (this.eAc != null) {
                    this.eAC.setSpan(new C8998c(this.eAc, this.eAf, this.eAg), length, length2, this.flag);
                } else if (this.eAd != null) {
                    SpannableStringBuilder spannableStringBuilder = this.eAC;
                    C8998c cVar = new C8998c(VivaBaseApplication.m8749FZ().getApplicationContext(), this.eAd, this.eAf, this.eAg);
                    spannableStringBuilder.setSpan(cVar, length, length2, this.flag);
                } else if (this.eAe != -1) {
                    SpannableStringBuilder spannableStringBuilder2 = this.eAC;
                    C8998c cVar2 = new C8998c(VivaBaseApplication.m8749FZ().getApplicationContext(), this.eAe, this.eAf, this.eAg);
                    spannableStringBuilder2.setSpan(cVar2, length, length2, this.flag);
                }
            }
            if (this.fontSize != -1) {
                this.eAC.setSpan(new AbsoluteSizeSpan(this.fontSize, this.eAh), length, length2, this.flag);
            }
            if (this.eAi != -1.0f) {
                this.eAC.setSpan(new RelativeSizeSpan(this.eAi), length, length2, this.flag);
            }
            if (this.eAj != -1.0f) {
                this.eAC.setSpan(new ScaleXSpan(this.eAj), length, length2, this.flag);
            }
            if (this.eAk) {
                this.eAC.setSpan(new StrikethroughSpan(), length, length2, this.flag);
            }
            if (this.eAl) {
                this.eAC.setSpan(new UnderlineSpan(), length, length2, this.flag);
            }
            if (this.eAm) {
                this.eAC.setSpan(new SuperscriptSpan(), length, length2, this.flag);
            }
            if (this.eAn) {
                this.eAC.setSpan(new SubscriptSpan(), length, length2, this.flag);
            }
            if (this.isBold) {
                this.eAC.setSpan(new StyleSpan(1), length, length2, this.flag);
            }
            if (this.eAo) {
                this.eAC.setSpan(new StyleSpan(2), length, length2, this.flag);
            }
            if (this.eAp) {
                this.eAC.setSpan(new StyleSpan(3), length, length2, this.flag);
            }
            if (this.fontFamily != null) {
                this.eAC.setSpan(new TypefaceSpan(this.fontFamily), length, length2, this.flag);
            }
            if (this.typeface != null) {
                this.eAC.setSpan(new CustomTypefaceSpan(this.typeface), length, length2, this.flag);
            }
            if (this.eAq != null) {
                this.eAC.setSpan(new AlignmentSpan.Standard(this.eAq), length, length2, this.flag);
            }
            if (this.eAr != null) {
                this.eAC.setSpan(this.eAr, length, length2, this.flag);
            }
            if (this.url != null) {
                this.eAC.setSpan(new URLSpan(this.url), length, length2, this.flag);
            }
            if (this.eAs != -1.0f) {
                this.eAC.setSpan(new MaskFilterSpan(new BlurMaskFilter(this.eAs, this.eAt)), length, length2, this.flag);
            }
            if (this.eAu != null) {
                this.eAC.setSpan(new C9002g(this.eAu), length, length2, this.flag);
            }
            if (this.f3635qu != -1.0f) {
                SpannableStringBuilder spannableStringBuilder3 = this.eAC;
                C9003h hVar = new C9003h(this.f3635qu, this.f3633qs, this.f3634qt, this.shadowColor);
                spannableStringBuilder3.setSpan(hVar, length, length2, this.flag);
            }
            if (this.eAv != null) {
                for (Object span : this.eAv) {
                    this.eAC.setSpan(span, length, length2, this.flag);
                }
            }
        }
    }

    private void aNo() {
        int length = this.eAC.length();
        this.eAC.append("< >");
        this.eAC.setSpan(new C9004i(this.eAA, this.eAB), length, length + 3, this.flag);
    }

    /* renamed from: vI */
    private void m26410vI(int i) {
        aNm();
        this.mType = i;
    }

    /* renamed from: B */
    public SpanUtils mo35760B(CharSequence charSequence) {
        m26410vI(0);
        this.mText = charSequence;
        return this;
    }

    /* renamed from: a */
    public SpanUtils mo35761a(ClickableSpan clickableSpan) {
        this.eAr = clickableSpan;
        return this;
    }

    public SpanUtils aNj() {
        this.eAl = true;
        return this;
    }

    public SpanUtils aNk() {
        this.isBold = true;
        return this;
    }

    public SpannableStringBuilder aNl() {
        aNm();
        return this.eAC;
    }

    /* renamed from: aq */
    public SpanUtils mo35765aq(int i, boolean z) {
        this.fontSize = i;
        this.eAh = z;
        return this;
    }

    /* renamed from: vG */
    public SpanUtils mo35766vG(int i) {
        this.flag = i;
        return this;
    }

    /* renamed from: vH */
    public SpanUtils mo35767vH(int i) {
        this.foregroundColor = i;
        return this;
    }
}
