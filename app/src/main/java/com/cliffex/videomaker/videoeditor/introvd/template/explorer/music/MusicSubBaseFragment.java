package com.introvd.template.explorer.music;

import android.os.Bundle;
import android.support.p021v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.gson.Gson;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.recycleviewutil.BaseItem;
import com.introvd.template.explorer.music.item.C7302d;
import com.introvd.template.explorer.music.p304b.C7262a;
import com.introvd.template.explorer.music.p304b.C7267f;
import com.introvd.template.template.data.api.model.TemplateAudioCategory;
import com.introvd.template.template.data.p406db.model.DBTemplateAudioInfo;
import java.util.List;
import org.greenrobot.eventbus.C10021c;
import org.greenrobot.eventbus.C10031j;
import org.greenrobot.eventbus.ThreadMode;

public abstract class MusicSubBaseFragment extends Fragment {
    protected View btV;
    private boolean bxM;

    /* renamed from: a */
    private void m21390a(C7267f fVar) {
        if (awR() != null && awR().size() != 0) {
            C7262a axo = fVar.axo();
            C7262a axn = fVar.axn();
            if (axo != null && getCategoryId().equals(axo.dBj) && awP() == axo.dBm) {
                boolean z = false;
                if (axn != null && axn.dBj != null && axn.dBj.equals(axo.dBj) && axn.dBm == awP()) {
                    z = true;
                }
                for (BaseItem baseItem : awR()) {
                    if (baseItem != null && (baseItem instanceof C7302d)) {
                        C7302d dVar = (C7302d) baseItem;
                        if (dVar.axy() != 1 && (!z || axn.dBk == null || !axn.dBk.equals(((DBTemplateAudioInfo) dVar.getItemData()).index))) {
                            dVar.axw();
                        }
                    }
                }
            }
        }
    }

    private void awI() {
        if (this.btV != null && getUserVisibleHint() && !this.bxM) {
            initData();
            StringBuilder sb = new StringBuilder();
            sb.append("Jamin ViewPage LazyLoad  = ");
            sb.append(awQ().name);
            LogUtilsV2.m14227d(sb.toString());
            this.bxM = true;
        }
    }

    /* renamed from: b */
    private void m21391b(C7267f fVar) {
        C7262a axn = fVar.axn();
        if (axn != null && axn.dBk != null && axn.dBj != null && axn.dBj.equals(getCategoryId()) && axn.dBm == awP()) {
            for (BaseItem baseItem : awR()) {
                if (baseItem instanceof C7302d) {
                    C7302d dVar = (C7302d) baseItem;
                    if (dVar.axy() != 1 && axn.dBk.equals(((DBTemplateAudioInfo) dVar.getItemData()).index)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Jamin MusicPlayerEvent to Music, ");
                        sb.append(new Gson().toJson((Object) fVar));
                        LogUtilsV2.m14227d(sb.toString());
                        switch (fVar.axp()) {
                            case 1:
                                dVar.mo31921qS(fVar.getDuration());
                                break;
                            case 2:
                                dVar.mo31920qR(fVar.getProgress());
                                break;
                            case 3:
                                dVar.pause();
                                break;
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: Oj */
    public abstract void mo31811Oj();

    /* access modifiers changed from: protected */
    public abstract int awP();

    /* access modifiers changed from: protected */
    public abstract TemplateAudioCategory awQ();

    /* access modifiers changed from: protected */
    public abstract List<BaseItem> awR();

    /* access modifiers changed from: protected */
    public abstract String getCategoryId();

    /* access modifiers changed from: protected */
    public abstract int getLayoutId();

    /* access modifiers changed from: protected */
    /* renamed from: hZ */
    public void mo31817hZ(boolean z) {
        this.bxM = z;
    }

    /* access modifiers changed from: protected */
    public abstract void initData();

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.btV != null) {
            ViewGroup viewGroup2 = (ViewGroup) this.btV.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(this.btV);
            }
        } else {
            this.btV = layoutInflater.inflate(getLayoutId(), viewGroup, false);
            mo31811Oj();
        }
        if (!C10021c.aZH().mo38495ay(this)) {
            C10021c.aZH().mo38494ax(this);
        }
        awI();
        return this.btV;
    }

    public void onDestroyView() {
        super.onDestroyView();
        if (C10021c.aZH().mo38495ay(this)) {
            C10021c.aZH().mo38496az(this);
        }
    }

    @C10031j(aZK = ThreadMode.MAIN)
    public void onEventMainThread(C7267f fVar) {
        if (fVar != null) {
            if (fVar.axp() == 4) {
                m21390a(fVar);
            } else {
                m21391b(fVar);
            }
        }
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        awI();
    }
}
