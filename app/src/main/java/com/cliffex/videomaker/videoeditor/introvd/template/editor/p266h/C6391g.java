package com.introvd.template.editor.p266h;

import android.content.Context;
import android.text.TextUtils;
import com.google.gson.JsonObject;
import com.introvd.template.app.api.C3727b;
import com.introvd.template.common.CommonConfigure;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.utils.XYXMLParser;
import com.introvd.template.p203b.C4596h;
import com.p131c.p132a.p135c.C2575a;
import java.util.ArrayList;
import p037b.p050b.C1834l;
import p037b.p050b.C1840o;
import p037b.p050b.C1842q;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p076j.C1820a;
import xiaoying.engine.QEngine;

/* renamed from: com.introvd.template.editor.h.g */
public class C6391g {
    /* renamed from: fR */
    public static void m18384fR(Context context) {
        if (C4596h.m11724Sx()) {
            C1834l.m5257ah(Boolean.valueOf(true)).mo10157d(C1487a.aUa()).mo10152c(C1820a.aVi()).mo10167f((C1518f<? super T, ? extends R>) new C1518f<Boolean, String>() {
                /* renamed from: w */
                public String apply(Boolean bool) throws Exception {
                    XYXMLParser xYXMLParser = new XYXMLParser();
                    StringBuilder sb = new StringBuilder();
                    sb.append(CommonConfigure.APP_DATA_PATH);
                    sb.append("ini/hw_codec_cap.xml");
                    String sb2 = sb.toString();
                    String str = "131071";
                    if (!FileUtils.isFileExisted(sb2) || !xYXMLParser.parserXmlEx(sb2)) {
                        return str;
                    }
                    ArrayList attributeValue = xYXMLParser.getAttributeValue("root/version", "value");
                    return (attributeValue == null || attributeValue.size() <= 0) ? str : (String) attributeValue.get(0);
                }
            }).mo10162e((C1518f<? super T, ? extends C1840o<? extends R>>) new C1518f<String, C1840o<String>>() {
                /* renamed from: iM */
                public C1840o<String> apply(String str) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("0x");
                    sb.append(Long.toHexString((long) QEngine.VERSION_NUMBER));
                    final String sb2 = sb.toString();
                    final int parseInt = C2575a.parseInt(str);
                    return C3727b.m9079I(sb2, str).mo10199i(new C1518f<JsonObject, String>() {
                        /* renamed from: g */
                        public String apply(JsonObject jsonObject) {
                            String str = "";
                            try {
                                if ((jsonObject.has("hdConfigVer") ? jsonObject.get("hdConfigVer").getAsInt() : 0) <= parseInt) {
                                    return str;
                                }
                                if (Long.decode(sb2).longValue() < Long.decode(jsonObject.has("enginVersion") ? jsonObject.get("enginVersion").getAsString() : "").longValue()) {
                                    return str;
                                }
                                return jsonObject.has("configFileUrl") ? jsonObject.get("configFileUrl").getAsString() : "";
                            } catch (Exception e) {
                                e.printStackTrace();
                                return str;
                            }
                        }
                    }).aTS();
                }
            }).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<String>() {
                /* renamed from: a */
                public void mo9877a(C1495b bVar) {
                }

                /* renamed from: dA */
                public void mo9886K(String str) {
                    try {
                        if (!TextUtils.isEmpty(str)) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(CommonConfigure.APP_DATA_PATH);
                            sb.append("ini/hw_codec_cap_tmp.xml");
                            new C6388e(sb.toString(), str).execute((Params[]) new Void[0]);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                public void onComplete() {
                }

                public void onError(Throwable th) {
                    th.printStackTrace();
                }
            });
        }
    }
}
