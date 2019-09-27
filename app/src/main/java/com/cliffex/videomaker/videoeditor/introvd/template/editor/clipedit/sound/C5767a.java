package com.introvd.template.editor.clipedit.sound;

import com.introvd.template.editor.R;
import com.introvd.template.editor.common.C5840b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.introvd.template.editor.clipedit.sound.a */
class C5767a {
    private static final Map<Float, C5768a> cBN = new HashMap();
    private static final List<C5768a> cBO = new ArrayList();

    /* renamed from: com.introvd.template.editor.clipedit.sound.a$a */
    static class C5768a {
        final boolean cBP;
        final boolean cBQ;
        final float cBR;
        final int iconRes;
        final int titleRes;

        C5768a(int i, int i2, float f) {
            this(false, false, i, i2, f);
        }

        C5768a(boolean z, boolean z2, int i, int i2, float f) {
            this.cBP = z;
            this.cBQ = z2;
            this.iconRes = i;
            this.titleRes = i2;
            this.cBR = f;
        }
    }

    static {
        List<C5768a> list = cBO;
        C5768a aVar = new C5768a(true, false, R.drawable.editor_layer_self_magic_sound, R.string.xiaoying_str_magic_sound_self, 2.14748365E9f);
        list.add(aVar);
        List<C5768a> list2 = cBO;
        C5768a aVar2 = new C5768a(false, true, R.drawable.editor_layer_magic_sound_original, R.string.xiaoying_str_magic_sound_original, C5840b.cED.floatValue());
        list2.add(aVar2);
        cBO.add(new C5768a(R.drawable.editor_icon_magic_sound_woman, R.string.xiaoying_str_magic_sound_m_to_w, C5840b.cEE.floatValue()));
        cBO.add(new C5768a(R.drawable.editor_icon_magic_sound_man, R.string.xiaoying_str_magic_sound_w_to_m, C5840b.cEF.floatValue()));
        cBO.add(new C5768a(R.drawable.editor_icon_magic_sound_tom_cat, R.string.xiaoying_str_magic_sound_tom_cat, C5840b.cEG.floatValue()));
        cBO.add(new C5768a(R.drawable.editor_icon_magic_sound_loli, R.string.xiaoying_str_magic_sound_loli, C5840b.cEH.floatValue()));
        cBO.add(new C5768a(R.drawable.editor_icon_magic_sound_alien, R.string.xiaoying_str_magic_sound_alien, C5840b.cEI.floatValue()));
        cBO.add(new C5768a(R.drawable.editor_icon_magic_sound_elder, R.string.xiaoying_str_magic_sound_elder, C5840b.cEJ.floatValue()));
    }

    static List<C5768a> afA() {
        return cBO;
    }

    /* renamed from: ao */
    static C5768a m16035ao(float f) {
        C5768a aVar = (C5768a) cBN.get(Float.valueOf(f));
        if (aVar != null) {
            return aVar;
        }
        Iterator it = cBO.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            C5768a aVar2 = (C5768a) it.next();
            if (aVar2 != null && ((double) Math.abs(aVar2.cBR - f)) < 1.0E-5d) {
                cBN.put(Float.valueOf(f), aVar2);
                aVar = aVar2;
                break;
            }
        }
        return (aVar != null || cBN.keySet().contains(Float.valueOf(f))) ? aVar : m16035ao(2.14748365E9f);
    }

    static String getName(int i) {
        return i != -15 ? i != -8 ? i != -5 ? i != 8 ? i != 10 ? i != 12 ? "原声" : "萝莉" : "tom猫" : "女生" : "老人" : "男生" : "外星人";
    }
}
