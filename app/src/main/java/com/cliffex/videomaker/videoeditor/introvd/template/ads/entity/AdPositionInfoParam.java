package com.introvd.template.ads.entity;

public class AdPositionInfoParam {
    public int position;
    public int providerOrder;

    public AdPositionInfoParam(int i, int i2) {
        this.providerOrder = i;
        this.position = i2;
    }

    public static AdPositionInfoParam convertParam(AdConfigParam adConfigParam) {
        if (adConfigParam != null) {
            return new AdPositionInfoParam(adConfigParam.providerOrder, adConfigParam.position);
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AdPositionInfoParam{providerOrder=");
        sb.append(this.providerOrder);
        sb.append(", position=");
        sb.append(this.position);
        sb.append('}');
        return sb.toString();
    }
}
