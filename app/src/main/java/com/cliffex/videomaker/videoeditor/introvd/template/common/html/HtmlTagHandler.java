package com.introvd.template.common.html;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.Html.ImageGetter;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.ParagraphStyle;
import android.text.style.QuoteSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.TextAppearanceSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.introvd.template.editor.p252e.C5878a;
import com.introvd.template.explorer.extract.C7234b;
import com.introvd.template.p203b.C4604n;
import java.io.StringReader;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.XMLReader;

public class HtmlTagHandler {

    public interface TagHandler {
        void handleTag(boolean z, String str, Editable editable, Attributes attributes);
    }

    /* renamed from: com.introvd.template.common.html.HtmlTagHandler$a */
    static class C5279a implements ContentHandler {
        private static final float[] ceN = {1.5f, 1.4f, 1.3f, 1.2f, 1.1f, 1.0f};
        private String ceO;
        private SpannableStringBuilder ceP = new SpannableStringBuilder();
        private ImageGetter ceQ;
        private TagHandler ceR;
        private ClickableSpan ceS;

        /* renamed from: com.introvd.template.common.html.HtmlTagHandler$a$a */
        private static class C5280a {
            private C5280a() {
            }
        }

        /* renamed from: com.introvd.template.common.html.HtmlTagHandler$a$b */
        private static class C5281b {
            private C5281b() {
            }
        }

        /* renamed from: com.introvd.template.common.html.HtmlTagHandler$a$c */
        private static class C5282c {
            private C5282c() {
            }
        }

        /* renamed from: com.introvd.template.common.html.HtmlTagHandler$a$d */
        private static class C5283d {
            public String ceT;
            public String ceU;

            public C5283d(String str, String str2) {
                this.ceT = str;
                this.ceU = str2;
            }
        }

        /* renamed from: com.introvd.template.common.html.HtmlTagHandler$a$e */
        private static class C5284e {
            /* access modifiers changed from: private */
            public int mLevel;

            public C5284e(int i) {
                this.mLevel = i;
            }
        }

        /* renamed from: com.introvd.template.common.html.HtmlTagHandler$a$f */
        private static class C5285f {
            public String ceV;
            public String ceW;
            public String ceX;

            public C5285f(String str, String str2, String str3) {
                this.ceV = str;
                this.ceW = str2;
                this.ceX = str3;
            }
        }

        /* renamed from: com.introvd.template.common.html.HtmlTagHandler$a$g */
        private static class C5286g {
            private C5286g() {
            }
        }

        /* renamed from: com.introvd.template.common.html.HtmlTagHandler$a$h */
        private static class C5287h {
            private C5287h() {
            }
        }

        /* renamed from: com.introvd.template.common.html.HtmlTagHandler$a$i */
        private static class C5288i {
            private C5288i() {
            }
        }

        /* renamed from: com.introvd.template.common.html.HtmlTagHandler$a$j */
        private static class C5289j {
            private C5289j() {
            }
        }

        /* renamed from: com.introvd.template.common.html.HtmlTagHandler$a$k */
        private static class C5290k {
            private C5290k() {
            }
        }

        /* renamed from: com.introvd.template.common.html.HtmlTagHandler$a$l */
        private static class C5291l {
            private C5291l() {
            }
        }

        public C5279a(String str, ImageGetter imageGetter, TagHandler tagHandler, ClickableSpan clickableSpan) {
            this.ceO = str;
            this.ceQ = imageGetter;
            this.ceR = tagHandler;
            this.ceS = clickableSpan;
        }

        /* renamed from: a */
        private static Object m14375a(Spanned spanned, Class cls) {
            Object[] spans = spanned.getSpans(0, spanned.length(), cls);
            if (spans.length == 0) {
                return null;
            }
            return spans[spans.length - 1];
        }

        /* renamed from: a */
        private static void m14376a(SpannableStringBuilder spannableStringBuilder) {
            int length = spannableStringBuilder.length();
            if (length < 1 || spannableStringBuilder.charAt(length - 1) != 10) {
                if (length != 0) {
                    spannableStringBuilder.append("\n\n");
                }
            } else if (length < 2 || spannableStringBuilder.charAt(length - 2) != 10) {
                spannableStringBuilder.append("\n");
            }
        }

        /* renamed from: a */
        private static void m14377a(SpannableStringBuilder spannableStringBuilder, ClickableSpan clickableSpan) {
            int length = spannableStringBuilder.length();
            Object a = m14375a((Spanned) spannableStringBuilder, C5285f.class);
            int spanStart = spannableStringBuilder.getSpanStart(a);
            spannableStringBuilder.removeSpan(a);
            if (spanStart != length) {
                C5285f fVar = (C5285f) a;
                if (fVar.ceV != null) {
                    LinkSpan linkSpan = new LinkSpan(fVar.ceV);
                    linkSpan.setClickableSpan(clickableSpan);
                    spannableStringBuilder.setSpan(linkSpan, spanStart, length, 33);
                    if (!TextUtils.isEmpty(fVar.ceW)) {
                        spannableStringBuilder.setSpan(new AbsoluteSizeSpan(C4604n.m11747Q((float) Integer.valueOf(fVar.ceW).intValue())), spanStart, length, 33);
                    }
                    if (!TextUtils.isEmpty(fVar.ceX)) {
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor(fVar.ceX)), spanStart, length, 33);
                    }
                }
            }
        }

        /* renamed from: a */
        private static void m14378a(SpannableStringBuilder spannableStringBuilder, Class cls, Object obj) {
            int length = spannableStringBuilder.length();
            Object a = m14375a((Spanned) spannableStringBuilder, cls);
            int spanStart = spannableStringBuilder.getSpanStart(a);
            spannableStringBuilder.removeSpan(a);
            if (spanStart != length) {
                spannableStringBuilder.setSpan(obj, spanStart, length, 33);
            }
        }

        /* renamed from: a */
        private static void m14379a(SpannableStringBuilder spannableStringBuilder, Object obj) {
            int length = spannableStringBuilder.length();
            spannableStringBuilder.setSpan(obj, length, length, 17);
        }

        /* renamed from: a */
        private static void m14380a(SpannableStringBuilder spannableStringBuilder, Attributes attributes) {
            String value = attributes.getValue("", "color");
            String value2 = attributes.getValue("", "face");
            int length = spannableStringBuilder.length();
            spannableStringBuilder.setSpan(new C5283d(value, value2), length, length, 17);
        }

        /* renamed from: a */
        private static void m14381a(SpannableStringBuilder spannableStringBuilder, Attributes attributes, ImageGetter imageGetter) {
            String value = attributes.getValue("", "src");
            Drawable drawable = imageGetter != null ? imageGetter.getDrawable(value) : null;
            if (drawable == null) {
                drawable = Resources.getSystem().getDrawable(17301533);
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            }
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append("￼");
            spannableStringBuilder.setSpan(new ImageSpan(drawable, value), length, spannableStringBuilder.length(), 33);
        }

        /* renamed from: a */
        private void m14382a(String str, Attributes attributes) {
            if (!TtmlNode.TAG_BR.equalsIgnoreCase(str)) {
                if (TtmlNode.TAG_P.equalsIgnoreCase(str)) {
                    m14376a(this.ceP);
                } else if (TtmlNode.TAG_DIV.equalsIgnoreCase(str)) {
                    m14376a(this.ceP);
                } else if ("strong".equalsIgnoreCase(str)) {
                    m14379a(this.ceP, (Object) new C5282c());
                } else if (C7234b.TAG.equalsIgnoreCase(str)) {
                    m14379a(this.ceP, (Object) new C5282c());
                } else if ("em".equalsIgnoreCase(str)) {
                    m14379a(this.ceP, (Object) new C5286g());
                } else if ("cite".equalsIgnoreCase(str)) {
                    m14379a(this.ceP, (Object) new C5286g());
                } else if ("dfn".equalsIgnoreCase(str)) {
                    m14379a(this.ceP, (Object) new C5286g());
                } else if ("i".equalsIgnoreCase(str)) {
                    m14379a(this.ceP, (Object) new C5286g());
                } else if ("big".equalsIgnoreCase(str)) {
                    m14379a(this.ceP, (Object) new C5280a());
                } else if ("small".equalsIgnoreCase(str)) {
                    m14379a(this.ceP, (Object) new C5288i());
                } else if ("font".equalsIgnoreCase(str)) {
                    m14380a(this.ceP, attributes);
                } else if ("blockquote".equalsIgnoreCase(str)) {
                    m14376a(this.ceP);
                    m14379a(this.ceP, (Object) new C5281b());
                } else if (TtmlNode.TAG_TT.equalsIgnoreCase(str)) {
                    m14379a(this.ceP, (Object) new C5287h());
                } else if (C5878a.TAG.equalsIgnoreCase(str)) {
                    m14384b(this.ceP, attributes);
                } else if ("u".equalsIgnoreCase(str)) {
                    m14379a(this.ceP, (Object) new C5291l());
                } else if ("sup".equalsIgnoreCase(str)) {
                    m14379a(this.ceP, (Object) new C5290k());
                } else if ("sub".equalsIgnoreCase(str)) {
                    m14379a(this.ceP, (Object) new C5289j());
                } else if (str.length() == 2 && Character.toLowerCase(str.charAt(0)) == 'h' && str.charAt(1) >= '1' && str.charAt(1) <= '6') {
                    m14376a(this.ceP);
                    m14379a(this.ceP, (Object) new C5284e(str.charAt(1) - '1'));
                } else if ("img".equalsIgnoreCase(str)) {
                    m14381a(this.ceP, attributes, this.ceQ);
                } else if (this.ceR != null) {
                    this.ceR.handleTag(true, str, this.ceP, attributes);
                }
            }
        }

        /* renamed from: b */
        private static void m14383b(SpannableStringBuilder spannableStringBuilder) {
            spannableStringBuilder.append("\n");
        }

        /* renamed from: b */
        private static void m14384b(SpannableStringBuilder spannableStringBuilder, Attributes attributes) {
            String value = attributes.getValue("", "href");
            String value2 = attributes.getValue("", "color");
            String value3 = attributes.getValue("", "size");
            int length = spannableStringBuilder.length();
            spannableStringBuilder.setSpan(new C5285f(value, value3, value2), length, length, 17);
        }

        /* renamed from: c */
        private static void m14385c(SpannableStringBuilder spannableStringBuilder) {
            int length = spannableStringBuilder.length();
            Object a = m14375a((Spanned) spannableStringBuilder, C5283d.class);
            int spanStart = spannableStringBuilder.getSpanStart(a);
            spannableStringBuilder.removeSpan(a);
            if (spanStart != length) {
                C5283d dVar = (C5283d) a;
                if (!TextUtils.isEmpty(dVar.ceT)) {
                    if (dVar.ceT.startsWith("@")) {
                        Resources system = Resources.getSystem();
                        int identifier = system.getIdentifier(dVar.ceT.substring(1), "color", "android");
                        if (identifier != 0) {
                            TextAppearanceSpan textAppearanceSpan = new TextAppearanceSpan(null, 0, 0, system.getColorStateList(identifier), null);
                            spannableStringBuilder.setSpan(textAppearanceSpan, spanStart, length, 33);
                        }
                    } else {
                        int parseColor = Color.parseColor(dVar.ceT);
                        if (parseColor != -1) {
                            spannableStringBuilder.setSpan(new ForegroundColorSpan(parseColor | -16777216), spanStart, length, 33);
                        }
                    }
                }
                if (dVar.ceU != null) {
                    spannableStringBuilder.setSpan(new TypefaceSpan(dVar.ceU), spanStart, length, 33);
                }
            }
        }

        /* renamed from: d */
        private static void m14386d(SpannableStringBuilder spannableStringBuilder) {
            int length = spannableStringBuilder.length();
            Object a = m14375a((Spanned) spannableStringBuilder, C5284e.class);
            int spanStart = spannableStringBuilder.getSpanStart(a);
            spannableStringBuilder.removeSpan(a);
            while (length > spanStart && spannableStringBuilder.charAt(length - 1) == 10) {
                length--;
            }
            if (spanStart != length) {
                spannableStringBuilder.setSpan(new RelativeSizeSpan(ceN[((C5284e) a).mLevel]), spanStart, length, 33);
                spannableStringBuilder.setSpan(new StyleSpan(1), spanStart, length, 33);
            }
        }

        /* renamed from: fr */
        private void m14387fr(String str) {
            if (TtmlNode.TAG_BR.equalsIgnoreCase(str)) {
                m14383b(this.ceP);
            } else if (TtmlNode.TAG_P.equalsIgnoreCase(str)) {
                m14376a(this.ceP);
            } else if (TtmlNode.TAG_DIV.equalsIgnoreCase(str)) {
                m14376a(this.ceP);
            } else if ("strong".equalsIgnoreCase(str)) {
                m14378a(this.ceP, C5282c.class, (Object) new StyleSpan(1));
            } else if (C7234b.TAG.equalsIgnoreCase(str)) {
                m14378a(this.ceP, C5282c.class, (Object) new StyleSpan(1));
            } else if ("em".equalsIgnoreCase(str)) {
                m14378a(this.ceP, C5286g.class, (Object) new StyleSpan(2));
            } else if ("cite".equalsIgnoreCase(str)) {
                m14378a(this.ceP, C5286g.class, (Object) new StyleSpan(2));
            } else if ("dfn".equalsIgnoreCase(str)) {
                m14378a(this.ceP, C5286g.class, (Object) new StyleSpan(2));
            } else if ("i".equalsIgnoreCase(str)) {
                m14378a(this.ceP, C5286g.class, (Object) new StyleSpan(2));
            } else if ("big".equalsIgnoreCase(str)) {
                m14378a(this.ceP, C5280a.class, (Object) new RelativeSizeSpan(1.25f));
            } else if ("small".equalsIgnoreCase(str)) {
                m14378a(this.ceP, C5288i.class, (Object) new RelativeSizeSpan(0.8f));
            } else if ("font".equalsIgnoreCase(str)) {
                m14385c(this.ceP);
            } else if ("blockquote".equalsIgnoreCase(str)) {
                m14376a(this.ceP);
                m14378a(this.ceP, C5281b.class, (Object) new QuoteSpan());
            } else if (TtmlNode.TAG_TT.equalsIgnoreCase(str)) {
                m14378a(this.ceP, C5287h.class, (Object) new TypefaceSpan("monospace"));
            } else if (C5878a.TAG.equalsIgnoreCase(str)) {
                m14377a(this.ceP, this.ceS);
            } else if ("u".equalsIgnoreCase(str)) {
                m14378a(this.ceP, C5291l.class, (Object) new UnderlineSpan());
            } else if ("sup".equalsIgnoreCase(str)) {
                m14378a(this.ceP, C5290k.class, (Object) new SuperscriptSpan());
            } else if ("sub".equalsIgnoreCase(str)) {
                m14378a(this.ceP, C5289j.class, (Object) new SubscriptSpan());
            } else if (str.length() == 2 && Character.toLowerCase(str.charAt(0)) == 'h' && str.charAt(1) >= '1' && str.charAt(1) <= '6') {
                m14376a(this.ceP);
                m14386d(this.ceP);
            } else if (this.ceR != null) {
                this.ceR.handleTag(false, str, this.ceP, null);
            }
        }

        /* renamed from: Zj */
        public Spanned mo26570Zj() {
            try {
                XMLReader xMLReader = SAXParserFactory.newInstance().newSAXParser().getXMLReader();
                xMLReader.setContentHandler(this);
                xMLReader.parse(new InputSource(new StringReader(this.ceO)));
            } catch (Exception e) {
                e.printStackTrace();
            }
            Object[] spans = this.ceP.getSpans(0, this.ceP.length(), ParagraphStyle.class);
            for (int i = 0; i < spans.length; i++) {
                int spanStart = this.ceP.getSpanStart(spans[i]);
                int spanEnd = this.ceP.getSpanEnd(spans[i]);
                int i2 = spanEnd - 2;
                if (i2 >= 0 && this.ceP.charAt(spanEnd - 1) == 10 && this.ceP.charAt(i2) == 10) {
                    spanEnd--;
                }
                if (spanEnd == spanStart) {
                    this.ceP.removeSpan(spans[i]);
                } else {
                    this.ceP.setSpan(spans[i], spanStart, spanEnd, 51);
                }
            }
            return this.ceP;
        }

        public void characters(char[] cArr, int i, int i2) {
            char c;
            StringBuilder sb = new StringBuilder();
            for (int i3 = 0; i3 < i2; i3++) {
                char c2 = cArr[i3 + i];
                if (c2 == ' ' || c2 == 10) {
                    int length = sb.length();
                    if (length == 0) {
                        int length2 = this.ceP.length();
                        c = length2 == 0 ? 10 : this.ceP.charAt(length2 - 1);
                    } else {
                        c = sb.charAt(length - 1);
                    }
                    if (!(c == ' ' || c == 10)) {
                        sb.append(' ');
                    }
                } else {
                    sb.append(c2);
                }
            }
            this.ceP.append(sb);
        }

        public void endDocument() {
        }

        public void endElement(String str, String str2, String str3) {
            m14387fr(str2);
        }

        public void endPrefixMapping(String str) {
        }

        public void ignorableWhitespace(char[] cArr, int i, int i2) {
        }

        public void processingInstruction(String str, String str2) {
        }

        public void setDocumentLocator(Locator locator) {
        }

        public void skippedEntity(String str) {
        }

        public void startDocument() {
        }

        public void startElement(String str, String str2, String str3, Attributes attributes) {
            m14382a(str2, attributes);
        }

        public void startPrefixMapping(String str, String str2) {
        }
    }

    /* renamed from: fq */
    private static String m14374fq(String str) {
        try {
            return str.replaceAll("&nbsp;", " ").replaceAll("&lsquo;", "‘").replaceAll("&rsquo;", "’").replaceAll("&ldquo;", "“").replaceAll("&rdquo;", "”").replaceAll("&middot;", "·").replaceAll("&hellip;", "...");
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static Spanned fromHtml(String str, ImageGetter imageGetter, TagHandler tagHandler, ClickableSpan clickableSpan) {
        return new C5279a(m14374fq(str), imageGetter, tagHandler, clickableSpan).mo26570Zj();
    }
}
