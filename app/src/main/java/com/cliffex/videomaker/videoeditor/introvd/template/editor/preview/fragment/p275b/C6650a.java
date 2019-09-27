package com.introvd.template.editor.preview.fragment.p275b;

import com.introvd.template.editor.preview.fragment.BasePreviewFragment;
import com.introvd.template.editor.preview.fragment.BgmFragment;
import com.introvd.template.editor.preview.fragment.ClipEditFragment;
import com.introvd.template.editor.preview.fragment.EffectFragment;
import com.introvd.template.editor.preview.fragment.ThemeFragment;
import com.p131c.p132a.C2561a;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/* renamed from: com.introvd.template.editor.preview.fragment.b.a */
public class C6650a {
    private List<BasePreviewFragment> bVF;
    private ThemeFragment dcS;
    private ClipEditFragment dcT;
    private EffectFragment dcU;
    private BgmFragment dcV;
    private LinkedHashMap<Integer, BasePreviewFragment> dcW;

    public C6650a() {
        init(false);
    }

    public C6650a(boolean z) {
        init(z);
    }

    private void init(boolean z) {
        this.dcW = new LinkedHashMap<>();
        if (!C2561a.aOS() || z) {
            this.dcS = ThemeFragment.apO();
            this.dcV = BgmFragment.apq();
            this.dcW.put(Integer.valueOf(0), this.dcS);
            this.dcW.put(Integer.valueOf(3), this.dcV);
        }
        this.dcT = ClipEditFragment.apF();
        this.dcU = EffectFragment.apK();
        this.dcW.put(Integer.valueOf(1), this.dcT);
        this.dcW.put(Integer.valueOf(2), this.dcU);
        this.bVF = new ArrayList(this.dcW.values());
    }

    public List<BasePreviewFragment> aql() {
        return this.bVF;
    }

    public ThemeFragment aqm() {
        return this.dcS;
    }

    public ClipEditFragment aqn() {
        return this.dcT;
    }

    public EffectFragment aqo() {
        return this.dcU;
    }

    public BgmFragment aqp() {
        return this.dcV;
    }

    /* renamed from: oI */
    public int mo30032oI(int i) {
        BasePreviewFragment basePreviewFragment = (BasePreviewFragment) this.dcW.get(Integer.valueOf(i));
        if (basePreviewFragment != null) {
            return this.bVF.indexOf(basePreviewFragment);
        }
        return 0;
    }

    /* renamed from: oJ */
    public int mo30033oJ(int i) {
        BasePreviewFragment basePreviewFragment = (BasePreviewFragment) this.bVF.get(i);
        if (basePreviewFragment != null) {
            for (Integer num : this.dcW.keySet()) {
                if (this.dcW.get(num) == basePreviewFragment) {
                    return num.intValue();
                }
            }
        }
        return 0;
    }
}
