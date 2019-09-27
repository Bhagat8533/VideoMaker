package com.introvd.template.module.iap.business.coupon;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import com.google.gson.annotations.SerializedName;
import com.introvd.template.module.iap.utils.C8078b;
import com.introvd.template.router.editor.EditorRouter;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* renamed from: com.introvd.template.module.iap.business.coupon.a */
public class C7846a implements Serializable {
    @SerializedName("couponCode")
    public String code;
    @SerializedName("applicableGoods")
    public String dQu;
    private List<String> dQv;
    @SerializedName("content")
    public double dQw;
    private String dQx;
    @SerializedName("activityId")
    public int dQy;
    @SerializedName("isValidityPeriod")
    public boolean dQz;
    @SerializedName("effectEndTime")
    public long endTime;
    @SerializedName("couponName")
    public String name;
    @SerializedName("effectStartTime")
    public long startTime;
    @SerializedName("type")
    public String type;

    /* renamed from: aJ */
    private String m22886aJ(long j) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd", Locale.CHINA);
        if (j < 0) {
            j = System.currentTimeMillis();
        }
        return simpleDateFormat.format(Long.valueOf(j));
    }

    public List<String> aCa() {
        if (this.dQv != null) {
            return this.dQv;
        }
        if (TextUtils.isEmpty(this.dQu)) {
            this.dQv = new ArrayList();
            return this.dQv;
        }
        this.dQv = Arrays.asList(this.dQu.split(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP));
        return this.dQv;
    }

    public String aCb() {
        if (!TextUtils.isEmpty(this.dQx)) {
            return this.dQx;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(m22886aJ(this.startTime));
        sb.append("-");
        sb.append(m22886aJ(this.endTime));
        this.dQx = sb.toString();
        return this.dQx;
    }

    public String aCc() {
        if ("DISCOUNT".equals(this.type)) {
            String lS = C8078b.m23443lS(String.valueOf((this.dQw * 100.0d) / 10.0d));
            StringBuilder sb = new StringBuilder();
            sb.append(lS);
            sb.append("折");
            return sb.toString();
        }
        String lS2 = C8078b.m23443lS(String.valueOf(this.dQw / 100.0d));
        StringBuilder sb2 = new StringBuilder();
        sb2.append("¥");
        sb2.append(lS2);
        return sb2.toString();
    }

    public boolean aCd() {
        if (this.dQz) {
            return true;
        }
        boolean z = false;
        if (this.startTime <= 0 || this.endTime < this.startTime) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis >= this.startTime && currentTimeMillis <= this.endTime) {
            z = true;
        }
        return z;
    }

    /* renamed from: aK */
    public String mo32772aK(long j) {
        if (j <= 0) {
            return C8078b.m23440aP(0);
        }
        String b = "DISCOUNT".equals(this.type) ? C8078b.m23441b((double) j, this.dQw) : C8078b.m23442j(((double) j) - this.dQw);
        if (TextUtils.isEmpty(b)) {
            b = C8078b.m23440aP(j);
        }
        return b;
    }

    public boolean isValid() {
        return this.dQz;
    }

    /* renamed from: sp */
    public SpannableString mo32774sp(int i) {
        String aCc = aCc();
        SpannableString spannableString = new SpannableString(aCc);
        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(i, true);
        if ("DISCOUNT".equals(this.type)) {
            spannableString.setSpan(absoluteSizeSpan, aCc.length() - "折".length(), aCc.length(), 33);
        } else {
            spannableString.setSpan(absoluteSizeSpan, 0, "¥".length(), 33);
        }
        return spannableString;
    }
}
