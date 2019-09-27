package com.introvd.template.common.html;

import android.graphics.Color;
import android.text.Editable;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.html.HtmlTagHandler.TagHandler;
import com.introvd.template.p203b.C4604n;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xml.sax.Attributes;

public class SpanTagHandler implements TagHandler {
    private String ceZ = "";
    private String cfa = "";
    private String cfb = "";
    private int cfc = 0;

    /* renamed from: fs */
    private static String m14390fs(String str) {
        Matcher matcher = Pattern.compile("#[0-9a-fA-F]{6}").matcher(str);
        return matcher.find() ? matcher.group() : "";
    }

    /* renamed from: ft */
    private static String m14391ft(String str) {
        Matcher matcher = Pattern.compile("#[0-9]*").matcher(str);
        return matcher.find() ? matcher.group() : "";
    }

    public void handleTag(boolean z, String str, Editable editable, Attributes attributes) {
        if (!TtmlNode.TAG_SPAN.equals(str.toLowerCase())) {
            return;
        }
        if (z) {
            for (int i = 0; i < attributes.getLength(); i++) {
                StringBuilder sb = new StringBuilder();
                sb.append("handleTag attrs : ");
                sb.append(attributes.getLocalName(i));
                LogUtilsV2.m14227d(sb.toString());
                if ("color".equals(attributes.getLocalName(i))) {
                    this.ceZ = attributes.getValue(i);
                } else if ("size".equals(attributes.getLocalName(i))) {
                    this.cfb = attributes.getValue(i);
                } else if ("style".equals(attributes.getLocalName(i))) {
                    String value = attributes.getValue(i);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("handle style : ");
                    sb2.append(attributes.getValue(i));
                    LogUtilsV2.m14227d(sb2.toString());
                    if (value.contains("background-color:")) {
                        this.cfa = m14390fs(value);
                    } else if (value.contains("color:")) {
                        this.ceZ = m14390fs(value);
                    } else if (value.contains("font-size:")) {
                        this.cfb = m14391ft(value);
                    }
                }
            }
            this.cfc = editable.length();
            return;
        }
        int length = editable.length();
        if (!TextUtils.isEmpty(this.ceZ)) {
            try {
                editable.setSpan(new ForegroundColorSpan(Color.parseColor(this.ceZ)), this.cfc, length, 33);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.ceZ = "";
        }
        if (!TextUtils.isEmpty(this.cfb)) {
            try {
                editable.setSpan(new AbsoluteSizeSpan(C4604n.m11747Q((float) Integer.valueOf(this.cfb).intValue())), this.cfc, length, 33);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.cfb = "";
        }
        if (!TextUtils.isEmpty(this.cfa)) {
            try {
                editable.setSpan(new BackgroundColorSpan(Color.parseColor(this.cfa)), this.cfc, length, 33);
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            this.cfa = "";
        }
    }
}
