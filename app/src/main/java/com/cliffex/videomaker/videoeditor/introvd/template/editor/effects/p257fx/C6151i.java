package com.introvd.template.editor.effects.p257fx;

import android.graphics.Bitmap;
import com.introvd.template.sdk.model.editor.EffectInfoModel;

/* renamed from: com.introvd.template.editor.effects.fx.i */
public class C6151i {
    private final EffectInfoModel cMf;
    private int cMg;
    private String cMh;
    private int position;
    private String sceneCode;
    private Bitmap thumbnail;

    public C6151i(EffectInfoModel effectInfoModel) {
        this.cMf = effectInfoModel;
    }

    public EffectInfoModel akN() {
        return this.cMf;
    }

    public String akO() {
        return this.cMh;
    }

    public int akP() {
        return this.cMg;
    }

    public String akw() {
        return this.sceneCode;
    }

    public int getPosition() {
        return this.position;
    }

    public Bitmap getThumbnail() {
        return this.thumbnail;
    }

    /* renamed from: hC */
    public void mo28949hC(String str) {
        this.cMh = str;
    }

    /* renamed from: hD */
    public void mo28950hD(String str) {
        this.sceneCode = str;
    }

    /* renamed from: mU */
    public void mo28951mU(int i) {
        this.cMg = i;
    }

    public void setPosition(int i) {
        this.position = i;
    }

    public void setThumbnail(Bitmap bitmap) {
        this.thumbnail = bitmap;
    }
}
