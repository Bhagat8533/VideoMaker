package com.introvd.template.ads.entity;

import java.util.List;

public class AdServerParam {
    public int adCounts = 0;
    public int adPositionInGroup;
    public final int adType;
    private final List<Integer> bhc;
    public String extraJson;
    public long intervalTime;
    public final int position;
    public final int strategy;
    public long waitTime;

    public AdServerParam(int i, int i2, int i3, List<Integer> list) {
        this.strategy = i;
        this.adType = i2;
        this.position = i3;
        this.bhc = list;
    }

    public List<Integer> getProviderList() {
        return this.bhc;
    }
}
