package com.introvd.template.app.ads;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.p131c.p132a.p135c.C2575a;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.introvd.template.app.ads.e */
public class C3720e implements Serializable {
    @SerializedName("orderno")
    private int adPositionInGroup;
    @SerializedName("disptype")
    private int adType;
    @SerializedName("ad")
    private List<C3721a> bhc;
    @SerializedName("dispPos")
    private String bjn;
    private int bjo = -1;
    @SerializedName("count")
    private int bjp = 1;
    @SerializedName("interval")
    private int bjq = 0;
    private List<Integer> bjr;
    @SerializedName("extend")
    private String bjs;
    private int bjt = -1;

    /* renamed from: com.introvd.template.app.ads.e$a */
    static class C3721a {
        @SerializedName("code")
        String bju;

        C3721a() {
        }
    }

    /* renamed from: Ib */
    private void m9025Ib() {
        if (this.bjr == null) {
            this.bjr = new ArrayList();
            for (C3721a aVar : this.bhc) {
                if (aVar != null) {
                    this.bjr.add(Integer.valueOf(C2575a.parseInt(aVar.bju)));
                }
            }
        }
    }

    /* renamed from: HV */
    public int mo23068HV() {
        return this.adType;
    }

    /* renamed from: HW */
    public int mo23069HW() {
        if (this.bjo >= 0) {
            return this.bjo;
        }
        if (!TextUtils.isEmpty(this.bjn)) {
            this.bjo = C2575a.parseInt(this.bjn);
        }
        return this.bjo;
    }

    /* renamed from: HX */
    public int mo23070HX() {
        return this.bjp;
    }

    /* renamed from: HY */
    public int mo23071HY() {
        return this.bjq;
    }

    /* renamed from: HZ */
    public int mo23072HZ() {
        return this.adPositionInGroup;
    }

    /* renamed from: I */
    public void mo23073I(List<C3721a> list) {
        this.bhc = list;
        m9025Ib();
    }

    /* renamed from: Ia */
    public List<Integer> mo23074Ia() {
        m9025Ib();
        return this.bjr;
    }

    /* renamed from: Ic */
    public int mo23075Ic() {
        if (this.bjt >= 0) {
            return this.bjt;
        }
        if (TextUtils.isEmpty(this.bjs)) {
            return this.bjt;
        }
        try {
            this.bjt = new JSONObject(this.bjs).optInt("waittime");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this.bjt;
    }

    public String getExtraInfo() {
        return this.bjs;
    }

    /* renamed from: gm */
    public void mo23077gm(int i) {
        this.adType = i;
    }

    /* renamed from: gn */
    public void mo23078gn(int i) {
        this.bjo = i;
    }
}
