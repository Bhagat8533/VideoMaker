package com.introvd.template.module.iap.business.p349a;

import android.text.TextUtils;
import com.introvd.template.module.iap.C8048e;
import com.introvd.template.vivaiap.base.p417a.C9023a;
import com.p131c.p132a.p135c.C2575a;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.introvd.template.module.iap.business.a.b */
public class C7827b extends C9023a implements Serializable {
    private String dRK;
    private String dRL;
    private long dRM;
    private JSONObject dRN;
    private String dRO;
    private Boolean dRP;
    protected boolean isValid;
    private String token;

    public C7827b(String str) {
        this(str, true);
    }

    public C7827b(String str, String str2) throws JSONException {
        this(m22803ks(str2), true);
        this.dRK = str;
        if (!TextUtils.isEmpty(str2)) {
            this.dRN = new JSONObject(str2);
        }
    }

    public C7827b(String str, boolean z) {
        super(str);
        this.dRO = "subscription";
        this.isValid = z;
    }

    /* renamed from: ks */
    private static String m22803ks(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new JSONObject(str).optString("productId");
    }

    /* renamed from: Mp */
    public String mo32696Mp() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        long aCw = aCw();
        if (aCw < 0) {
            aCw = System.currentTimeMillis();
        }
        return simpleDateFormat.format(Long.valueOf(aCw));
    }

    public boolean aCv() {
        if (this.dRP != null) {
            return this.dRP.booleanValue();
        }
        boolean z = false;
        if (this.dRN != null && this.dRN.optBoolean("autoRenewing", false)) {
            z = true;
        }
        Boolean valueOf = Boolean.valueOf(z);
        this.dRP = valueOf;
        return valueOf.booleanValue();
    }

    public long aCw() {
        return C2575a.parseLong(this.dRL);
    }

    public int aCx() {
        try {
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(C2575a.parseLong(this.dRL));
            int i = instance.get(6);
            int i2 = instance.get(1);
            Calendar instance2 = Calendar.getInstance();
            instance2.setTimeInMillis(this.dRM);
            return (i - instance2.get(6)) + ((i2 - instance2.get(1)) * 365);
        } catch (NumberFormatException e) {
            C8048e.aBe().logException(e);
            return 0;
        }
    }

    /* renamed from: aL */
    public void mo32700aL(long j) {
        this.dRM = j;
    }

    public String getToken() {
        if (this.dRN != null) {
            this.token = this.dRN.optString(AccountKitGraphConstants.TOKEN_RESPONSE_TYPE, this.dRN.optString("purchaseToken"));
        }
        return this.token;
    }

    public boolean isValid() {
        return this.isValid;
    }

    /* renamed from: ld */
    public void mo32703ld(String str) {
        this.dRL = str;
    }

    /* renamed from: le */
    public void mo32704le(String str) {
        this.dRO = str;
    }

    /* renamed from: st */
    public void mo32705st(int i) {
        if (i > 0) {
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(C2575a.parseLong(this.dRL));
            instance.add(6, i);
            this.dRL = String.valueOf(instance.getTimeInMillis());
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Purchase{itemTypeForGoogle='");
        sb.append(this.dRK);
        sb.append('\'');
        sb.append(", token='");
        sb.append(this.token);
        sb.append('\'');
        sb.append(", validTime='");
        sb.append(this.dRL);
        sb.append('\'');
        sb.append(", realServerTime=");
        sb.append(this.dRM);
        sb.append(", originalDataJson=");
        sb.append(this.dRN);
        sb.append(", itemType='");
        sb.append(this.dRO);
        sb.append('\'');
        sb.append(", isValid=");
        sb.append(this.isValid);
        sb.append('}');
        return sb.toString();
    }
}
