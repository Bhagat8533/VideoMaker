package com.introvd.template.app.school.api.model;

import android.support.annotation.Keep;
import com.introvd.template.R;
import com.introvd.template.VivaBaseApplication;
import p464d.p466b.p467a.C9649c;

@Keep
public final class CommodityInfo {
    private Number amount = Integer.valueOf(0);
    private String commodityCode = "";
    private boolean isCommodity;
    private Number managerId = Integer.valueOf(0);
    private String puiddigest = "";
    private boolean purchased;
    private Number ver = Integer.valueOf(1);

    public final String formatAmountStr() {
        String string = VivaBaseApplication.m8749FZ().getString(R.string.viva_svip_gold_count, new Object[]{this.amount});
        C9649c.m27671i(string, "VivaBaseApplication.getI…_svip_gold_count, amount)");
        return string;
    }

    public final Number getAmount() {
        return this.amount;
    }

    public final String getCommodityCode() {
        return this.commodityCode;
    }

    public final Number getManagerId() {
        return this.managerId;
    }

    public final String getPuiddigest() {
        return this.puiddigest;
    }

    public final boolean getPurchased() {
        return this.purchased;
    }

    public final Number getVer() {
        return this.ver;
    }

    public final boolean isCommodity() {
        return this.isCommodity;
    }

    public final void setAmount(Number number) {
        C9649c.m27672j(number, "<set-?>");
        this.amount = number;
    }

    public final void setCommodity(boolean z) {
        this.isCommodity = z;
    }

    public final void setCommodityCode(String str) {
        C9649c.m27672j(str, "<set-?>");
        this.commodityCode = str;
    }

    public final void setManagerId(Number number) {
        C9649c.m27672j(number, "<set-?>");
        this.managerId = number;
    }

    public final void setPuiddigest(String str) {
        C9649c.m27672j(str, "<set-?>");
        this.puiddigest = str;
    }

    public final void setPurchased(boolean z) {
        this.purchased = z;
    }

    public final void setVer(Number number) {
        C9649c.m27672j(number, "<set-?>");
        this.ver = number;
    }
}
