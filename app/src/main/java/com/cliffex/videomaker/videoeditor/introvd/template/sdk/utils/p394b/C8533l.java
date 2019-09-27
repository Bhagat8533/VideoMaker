package com.introvd.template.sdk.utils.p394b;

import android.text.TextUtils;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.sdk.C8410e;
import com.introvd.template.sdk.model.editor.SymbolStringInfo;
import com.introvd.template.sdk.utils.C8554j;
import com.introvd.template.sdk.utils.p393a.C8496e;
import com.introvd.template.sdk.utils.p396c.C8544b;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

/* renamed from: com.introvd.template.sdk.utils.b.l */
public class C8533l {
    private C8535b eid;

    /* renamed from: com.introvd.template.sdk.utils.b.l$a */
    public static class C8534a implements C8535b {
        public String aJN() {
            return "";
        }

        public String aJO() {
            String string = C8410e.aGX().aGZ().getString("key_location_cache_city", "unknow");
            StringBuilder sb = new StringBuilder();
            sb.append("prepareLocENCity strCity=");
            sb.append(string);
            C8554j.m25008i("TextTemplateStrPrepareUtils", sb.toString());
            return "重庆".equals(string) ? "ChongQing" : C8496e.m24586oz(string);
        }

        public String ata() {
            return "";
        }

        public String atb() {
            return "";
        }

        public String atc() {
            return "";
        }

        public String atd() {
            return "";
        }

        public String ate() {
            return "";
        }

        public String atf() {
            return "";
        }

        public String atg() {
            return "";
        }

        public String ath() {
            return "";
        }

        public String ati() {
            return "";
        }

        public String atj() {
            return "";
        }

        public String atk() {
            return "";
        }

        /* renamed from: nR */
        public String mo34630nR(String str) {
            try {
                return new C8544b(str, Locale.getDefault()).format(new Date());
            } catch (Exception unused) {
                return "";
            }
        }
    }

    /* renamed from: com.introvd.template.sdk.utils.b.l$b */
    public interface C8535b {
        String aJN();

        String aJO();

        String ata();

        String atb();

        String atc();

        String atd();

        String ate();

        String atf();

        String atg();

        String ath();

        String ati();

        String atj();

        String atk();

        /* renamed from: nR */
        String mo34630nR(String str);
    }

    /* renamed from: a */
    private String m24771a(SymbolStringInfo symbolStringInfo) {
        String str = symbolStringInfo.getmSymbolString();
        int indexOf = str.indexOf("locN ");
        if (-1 == indexOf) {
            return m24773y(str, false);
        }
        if (indexOf == 0) {
            return m24773y(str.substring("locN ".length()), true);
        }
        return null;
    }

    /* renamed from: oL */
    public static boolean m24772oL(String str) {
        if (TextUtils.isEmpty(str) || !C8531j.m24766oJ(str)) {
            return false;
        }
        SymbolStringInfo J = C8531j.m24765J(str, 0);
        if (J == null || TextUtils.isEmpty(J.getmSymbolString())) {
            return false;
        }
        return J.getmSymbolString().equals("filmname");
    }

    /* renamed from: y */
    private String m24773y(String str, boolean z) {
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.equals("location")) {
            if (str.equals("POI")) {
                if (this.eid != null) {
                    str2 = this.eid.atd();
                }
            } else if (str.equals("City")) {
                if (this.eid != null) {
                    str2 = this.eid.atb();
                }
            } else if (str.equals("EnCity")) {
                if (this.eid != null) {
                    str2 = this.eid.aJO();
                }
            } else if (str.equals("Province")) {
                if (this.eid != null) {
                    str2 = this.eid.ate();
                }
            } else if (str.equals("Country")) {
                if (this.eid != null) {
                    str2 = this.eid.atc();
                }
            } else if (str.equals("nickname")) {
                if (this.eid != null) {
                    str2 = this.eid.atf();
                }
            } else if (str.equals("filmname")) {
                if (this.eid != null) {
                    str2 = this.eid.aJN();
                }
            } else if (!str.equals("weather") && !str.equals("selfdef") && !str.equals(AppStateModel.COUNTRY_CODE_Palestine)) {
                if (str.equals("filmmaker")) {
                    if (this.eid != null) {
                        str2 = this.eid.ata();
                    }
                } else if (str.equals("director")) {
                    if (this.eid != null) {
                        str2 = this.eid.ati();
                    }
                } else if (str.equals("screenwriter")) {
                    if (this.eid != null) {
                        str2 = this.eid.atk();
                    }
                } else if (str.equals("actor")) {
                    if (this.eid != null) {
                        str2 = this.eid.atg();
                    }
                } else if (str.equals("editor")) {
                    if (this.eid != null) {
                        str2 = this.eid.ath();
                    }
                } else if (str.equals("photographer")) {
                    if (this.eid != null) {
                        str2 = this.eid.atj();
                    }
                } else if (!z) {
                    if (this.eid != null) {
                        str2 = this.eid.mo34630nR(str);
                    } else {
                        try {
                            str2 = new C8544b(str, Locale.getDefault()).format(new Date());
                        } catch (Exception unused) {
                        }
                    }
                }
            }
        }
        return str2;
    }

    /* renamed from: b */
    public void mo34788b(C8535b bVar) {
        this.eid = bVar;
    }

    /* renamed from: oM */
    public boolean mo34789oM(String str) {
        return !TextUtils.isEmpty(str) && C8531j.m24766oJ(str);
    }

    /* renamed from: oN */
    public String mo34790oN(String str) {
        if (TextUtils.isEmpty(str) || !C8531j.m24766oJ(str)) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = C8531j.m24767oK(new StringBuilder(str).toString()).iterator();
        while (it.hasNext()) {
            SymbolStringInfo symbolStringInfo = (SymbolStringInfo) it.next();
            if (symbolStringInfo != null) {
                if (symbolStringInfo.isSymbolStr()) {
                    String a = m24771a(symbolStringInfo);
                    if (!TextUtils.isEmpty(a)) {
                        stringBuffer.append(a);
                    }
                } else {
                    stringBuffer.append(symbolStringInfo.getmSymbolString());
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("destStrBuf:");
        sb.append(stringBuffer);
        C8554j.m25008i("TextTemplateStrPrepareUtils", sb.toString());
        return stringBuffer.toString();
    }
}
