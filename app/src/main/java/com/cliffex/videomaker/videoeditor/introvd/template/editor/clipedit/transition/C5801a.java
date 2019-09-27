package com.introvd.template.editor.clipedit.transition;

import android.text.TextUtils;
import com.introvd.template.editor.clipedit.C5694a;
import com.introvd.template.editor.common.model.EffectInfo;
import com.introvd.template.editor.preview.p271b.C6550a;
import com.introvd.template.sdk.utils.C8560o;
import com.introvd.template.sdk.utils.p394b.C8540q;
import org.greenrobot.eventbus.C10021c;
import xiaoying.engine.storyboard.QStoryboard;

/* renamed from: com.introvd.template.editor.clipedit.transition.a */
public class C5801a extends C5694a {
    private boolean cCM = false;

    /* renamed from: a */
    private boolean m16147a(QStoryboard qStoryboard, int i, int i2, EffectInfo effectInfo) {
        if (!m16148a(qStoryboard, effectInfo, i, i2)) {
            return false;
        }
        adL().mo34669jt(true);
        return true;
    }

    /* renamed from: a */
    private boolean m16148a(QStoryboard qStoryboard, EffectInfo effectInfo, int i, int i2) {
        if (qStoryboard == null || effectInfo == null || i2 < 0) {
            return false;
        }
        String str = effectInfo.mEffectPath;
        if (TextUtils.isEmpty(str)) {
            i = 0;
        }
        if (!C8540q.m24933a(qStoryboard, i2, str, i, effectInfo.mChildIndex)) {
            return false;
        }
        adQ().mo34302dz(i2, C8540q.m24916a(i2, qStoryboard));
        if (adK().aHe() != null && !adK().aHe().isAdvBGMMode()) {
            C8540q.m24903L(qStoryboard);
            if (adS() != null) {
                adS().mo34143b(qStoryboard, true);
            }
        } else if (adS() != null) {
            adS().mo34143b(qStoryboard, false);
        }
        return true;
    }

    /* renamed from: gM */
    static EffectInfo m16149gM(String str) {
        EffectInfo effectInfo = new EffectInfo();
        effectInfo.mEffectPath = str;
        int oP = C8540q.m24966oP(str);
        if (oP > 1) {
            effectInfo.mChildIndex = C8560o.m25040dH(0, oP - 1);
        }
        return effectInfo;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: a */
    public void mo28087a(EffectInfo effectInfo) {
        if (this.cCM) {
            QStoryboard adO = adO();
            if (adO != null) {
                int clipCount = adO.getClipCount();
                for (int i = 0; i < clipCount; i++) {
                    if (!mo28089lt(i)) {
                        m16147a(adO(), 1000, i, m16149gM(effectInfo.mEffectPath));
                    }
                }
            }
            C10021c.aZH().mo38492aA(new C6550a(2));
            return;
        }
        for (Integer intValue : aeK()) {
            int intValue2 = intValue.intValue();
            if (!mo28089lt(intValue2)) {
                m16147a(adO(), 1000, intValue2, m16149gM(effectInfo.mEffectPath));
            }
        }
        C10021c.aZH().mo38492aA(new C6550a(1, aeK()));
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: eF */
    public void mo28088eF(boolean z) {
        this.cCM = z;
    }

    /* access modifiers changed from: 0000 */
    /* renamed from: lt */
    public boolean mo28089lt(int i) {
        return i == (adO() != null ? C8540q.m24895D(adO()) : 0) - 1;
    }
}
