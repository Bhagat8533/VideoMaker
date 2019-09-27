package com.introvd.template.module.iap.business.p349a.p351b;

import com.google.gson.annotations.SerializedName;

/* renamed from: com.introvd.template.module.iap.business.a.b.a */
public class C7828a {
    @SerializedName("effectiveTime")
    int dRV;
    @SerializedName("domesticServerId")
    private String dRY;
    @SerializedName("originMoney")
    private int dSf;
    @SerializedName("intro")
    private String description;
    @SerializedName("type")
    private String goodsId;
    @SerializedName("label")
    private String label;
    @SerializedName("orderNo")
    private int order;
    @SerializedName("money")
    private int price;
    @SerializedName("title")
    private String title;

    public String aCF() {
        return this.dRY;
    }

    public int aCG() {
        return this.dRV;
    }

    public String aCH() {
        return this.goodsId;
    }

    public int aCI() {
        return this.price;
    }

    public int aCJ() {
        return this.dSf;
    }

    public String getDescription() {
        return this.description;
    }

    public String getLabel() {
        return this.label;
    }

    public int getOrder() {
        return this.order;
    }

    public String getTitle() {
        return this.title;
    }

    /* renamed from: lj */
    public void mo32716lj(String str) {
        this.label = str;
    }

    /* renamed from: ln */
    public void mo32717ln(String str) {
        this.dRY = str;
    }

    /* renamed from: lo */
    public void mo32718lo(String str) {
        this.goodsId = str;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setOrder(int i) {
        this.order = i;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    /* renamed from: su */
    public void mo32722su(int i) {
        this.dRV = i;
    }

    /* renamed from: sv */
    public void mo32723sv(int i) {
        this.price = i;
    }

    /* renamed from: sw */
    public void mo32724sw(int i) {
        this.dSf = i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DomesticGoods{order=");
        sb.append(this.order);
        sb.append(", goodsId='");
        sb.append(this.goodsId);
        sb.append('\'');
        sb.append(", validTime=");
        sb.append(this.dRV);
        sb.append(", label='");
        sb.append(this.label);
        sb.append('\'');
        sb.append(", title='");
        sb.append(this.title);
        sb.append('\'');
        sb.append(", description='");
        sb.append(this.description);
        sb.append('\'');
        sb.append(", price=");
        sb.append(this.price);
        sb.append(", previousPrice=");
        sb.append(this.dSf);
        sb.append(", domesticServerId=");
        sb.append(this.dRY);
        sb.append('}');
        return sb.toString();
    }
}
