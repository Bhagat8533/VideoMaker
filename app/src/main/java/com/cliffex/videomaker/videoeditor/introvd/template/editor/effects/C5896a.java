package com.introvd.template.editor.effects;

import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextUtils;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.MSize;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.model.Range;
import com.introvd.template.editor.base.C5686a;
import com.introvd.template.editor.p245b.C5655b;
import com.introvd.template.editor.player.p267a.C6485b;
import com.introvd.template.sdk.editor.C8418a;
import com.introvd.template.sdk.editor.cache.C8441b;
import com.introvd.template.sdk.editor.p387a.C8419a;
import com.introvd.template.sdk.model.VeRange;
import com.introvd.template.sdk.model.editor.ScaleRotateViewState;
import com.introvd.template.sdk.model.editor.TextBubbleInfo;
import com.introvd.template.sdk.model.editor.TextBubbleInfo.TextBubble;
import com.introvd.template.sdk.p391g.C8450a;
import com.introvd.template.sdk.utils.C8562q;
import com.introvd.template.sdk.utils.VeMSize;
import com.introvd.template.sdk.utils.p394b.C8501a;
import com.introvd.template.sdk.utils.p394b.C8530i;
import com.introvd.template.sdk.utils.p394b.C8538o;
import com.introvd.template.sdk.utils.p394b.C8540q;
import com.introvd.template.template.p409g.C8762d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import p037b.p050b.C1834l;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p057e.C1517e;
import p037b.p050b.p076j.C1820a;
import p503cz.msebera.android.httpclient.HttpStatus;
import xiaoying.engine.base.QStyle;
import xiaoying.engine.clip.QEffect;
import xiaoying.engine.clip.QKeyFrameTransformData;
import xiaoying.engine.clip.QKeyFrameTransformData.Value;
import xiaoying.engine.storyboard.QStoryboard;
import xiaoying.utils.QRect;

/* renamed from: com.introvd.template.editor.effects.a */
public abstract class C5896a extends C5686a {
    /* access modifiers changed from: private */
    public int cGu = -1;
    /* access modifiers changed from: private */
    public ArrayList<C8441b> cGv = new ArrayList<>();
    private volatile ArrayList<C8441b> cGw = new ArrayList<>();

    /* renamed from: a */
    private void m16506a(C5655b bVar, int i) {
        super.mo27848a(bVar);
        this.cGu = i;
        MSize surfaceSize = getSurfaceSize();
        VeMSize veMSize = surfaceSize != null ? new VeMSize(surfaceSize.width, surfaceSize.height) : null;
        this.cGw = C8419a.m24325a(adO(), this.cGu, veMSize);
        aiu();
        if (this.cGw != null) {
            this.cGv = C8419a.m24325a(adO(), this.cGu, veMSize);
        }
    }

    /* renamed from: a */
    private void m16507a(ScaleRotateViewState scaleRotateViewState, ScaleRotateViewState scaleRotateViewState2, boolean z) {
        float f;
        float f2;
        if (scaleRotateViewState != null) {
            String str = scaleRotateViewState.mStylePath;
            if (FileUtils.isFileExisted(str)) {
                ScaleRotateViewState scaleRotateViewState3 = null;
                VeMSize veMSize = getSurfaceSize() != null ? new VeMSize(getSurfaceSize().width, getSurfaceSize().height) : null;
                if (this.cGu == 3) {
                    scaleRotateViewState3 = C8538o.m24868c(adP(), str, veMSize);
                } else if (this.cGu == 8 || this.cGu == 40) {
                    scaleRotateViewState3 = C8530i.m24759b(adP(), str, veMSize);
                } else if (this.cGu == 20) {
                    try {
                        scaleRotateViewState3 = C8530i.m24746a(adP(), str, veMSize);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (scaleRotateViewState3 != null) {
                    f2 = scaleRotateViewState3.mPosInfo.getmHeight();
                    f = scaleRotateViewState3.mPosInfo.getmWidth();
                } else {
                    f2 = 0.0f;
                    f = 0.0f;
                }
                float f3 = scaleRotateViewState.mPosInfo.getmHeight();
                float f4 = scaleRotateViewState.mPosInfo.getmWidth();
                if (scaleRotateViewState.isDftTemplate && scaleRotateViewState.mLineNum > 0) {
                    f3 = scaleRotateViewState.mPosInfo.getmHeight() / ((float) scaleRotateViewState.mLineNum);
                    f4 = scaleRotateViewState.mPosInfo.getmWidth() / ((float) scaleRotateViewState.mLineNum);
                }
                if (!z && f2 > 0.0f) {
                    int i = (f3 > 0.0f ? 1 : (f3 == 0.0f ? 0 : -1));
                    if (i > 0) {
                        boolean z2 = false;
                        boolean z3 = f > 0.0f;
                        if (i > 0) {
                            z2 = true;
                        }
                        if (z3 && z2) {
                            float f5 = f3 / f2;
                            scaleRotateViewState2.mPosInfo.setmWidth((float) ((int) (scaleRotateViewState2.mPosInfo.getmWidth() * (f4 / f))));
                            scaleRotateViewState2.mPosInfo.setmHeight((float) ((int) (scaleRotateViewState2.mPosInfo.getmHeight() * f5)));
                        }
                    }
                }
                if (f2 > 0.0f && f3 > 0.0f) {
                    float f6 = f3 / f2;
                    scaleRotateViewState2.mPosInfo.setmWidth((float) ((int) (scaleRotateViewState2.mPosInfo.getmWidth() * f6)));
                    scaleRotateViewState2.mPosInfo.setmHeight((float) ((int) (scaleRotateViewState2.mPosInfo.getmHeight() * f6)));
                }
            }
        }
    }

    private void aiC() {
        if (this.cGu < 0) {
            throw new IllegalStateException("Please call  super init(EditorController controller, @GroupId int groupId) to init group Id.");
        }
    }

    private void aiu() {
        ArrayList aK = mo28465aK(this.cGw);
        if (aK != null && aK.size() != 0) {
            int i = 0;
            Iterator it = aK.iterator();
            while (it.hasNext()) {
                int intValue = ((Integer) it.next()).intValue() - i;
                if (intValue >= 0 && mo28481me(intValue)) {
                    i++;
                }
            }
        }
    }

    private void aiv() {
        C8501a.aJs().mo34669jt(true);
    }

    /* renamed from: b */
    private void m16509b(C8441b bVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("effectDataModel", bVar.toString());
        UserBehaviorLog.onKVEvent(VivaBaseApplication.m8749FZ().getApplicationContext(), "Dev_Event_Effect_Len_Error", hashMap);
    }

    /* renamed from: b */
    private void m16510b(boolean z, ScaleRotateViewState scaleRotateViewState, ScaleRotateViewState scaleRotateViewState2) {
        TextBubbleInfo textBubbleInfo = scaleRotateViewState2.mTextBubbleInfo;
        TextBubbleInfo textBubbleInfo2 = scaleRotateViewState.mTextBubbleInfo;
        if (textBubbleInfo != null && textBubbleInfo2 != null) {
            TextBubble dftTextBubble = textBubbleInfo.getDftTextBubble();
            TextBubble dftTextBubble2 = textBubbleInfo2.getDftTextBubble();
            if (dftTextBubble != null && dftTextBubble2 != null) {
                dftTextBubble2.mFontPath = dftTextBubble.mFontPath;
                String str = dftTextBubble.mText;
                if (!TextUtils.isEmpty(str)) {
                    dftTextBubble2.mText = str;
                }
                if (z) {
                    dftTextBubble2.mText = dftTextBubble2.mDftText;
                }
                long templateID = C8762d.aMt().getTemplateID(scaleRotateViewState.mStylePath);
                if (C8450a.m24466bk(templateID) || templateID == QStyle.DEFAULT_BUBBLE_TEMPLATE_ID || z) {
                    if (dftTextBubble.mTextColor != dftTextBubble.mDftTextColor) {
                        dftTextBubble2.mTextColor = dftTextBubble.mTextColor;
                    }
                    dftTextBubble2.mShadowInfo = dftTextBubble.mShadowInfo;
                    dftTextBubble2.mStrokeInfo = dftTextBubble.mStrokeInfo;
                    dftTextBubble2.mTextAlignment = dftTextBubble.mTextAlignment;
                    textBubbleInfo2.isAnimOn = textBubbleInfo.isAnimOn;
                }
            }
        }
    }

    /* renamed from: a */
    public float mo28451a(Value value) {
        if (value == null) {
            return 0.0f;
        }
        return value.rotation;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo28452a(Point point, int i) {
        aiC();
        QStoryboard adO = adO();
        MSize surfaceSize = getSurfaceSize();
        if (adO == null || surfaceSize == null) {
            return -1;
        }
        return C8419a.m24322a(adO, new VeMSize(surfaceSize.width, surfaceSize.height), point, i, this.cGu);
    }

    /* renamed from: a */
    public Rect mo28453a(Value value, int i) {
        QEffect b = C8540q.m24940b(adO(), getGroupId(), i);
        if (b == null || b.getProperty(QEffect.PROP_EFFECT_KEYFRAME_TRANSFORM_ORIGIN_REGION) == null || value == null || getSurfaceSize() == null) {
            return null;
        }
        QRect qRect = (QRect) b.getProperty(QEffect.PROP_EFFECT_KEYFRAME_TRANSFORM_ORIGIN_REGION);
        if (qRect == null) {
            return null;
        }
        QRect a = C8538o.m24853a(value, qRect);
        if (a == null) {
            return null;
        }
        return C8530i.m24758b(new Rect(a.left, a.top, a.right, a.bottom), getSurfaceSize().width, getSurfaceSize().height);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C8441b mo28454a(C8441b bVar) {
        aiC();
        QStoryboard adO = adO();
        MSize streamSize = getStreamSize();
        MSize surfaceSize = getSurfaceSize();
        if (adO == null || surfaceSize == null || bVar == null || streamSize == null) {
            return null;
        }
        if (bVar.aIc() != null && bVar.aIc().getmTimeLength() <= 0) {
            m16509b(bVar);
            bVar.aIc().setmTimeLength(HttpStatus.SC_INTERNAL_SERVER_ERROR);
            LogUtilsV2.m14228e("effect length set to < 500");
        }
        if (C8419a.m24321a(adO, bVar, new VeMSize(surfaceSize.width, surfaceSize.height), new VeMSize(streamSize.width, streamSize.height)) != 0) {
            return null;
        }
        this.cGw.add(bVar);
        aiv();
        return bVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C8441b mo28455a(ScaleRotateViewState scaleRotateViewState, Range range) {
        C8441b bVar = new C8441b();
        bVar.mo34280r(scaleRotateViewState);
        bVar.mo34273b(range != null ? new VeRange(range.getmPosition(), range.getmTimeLength()) : null);
        bVar.groupId = this.cGu;
        bVar.mo34279nG(scaleRotateViewState.mStylePath);
        return bVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C8441b mo28456a(ScaleRotateViewState scaleRotateViewState, C8441b bVar) {
        bVar.mo34280r(scaleRotateViewState);
        bVar.mo34279nG(scaleRotateViewState.mStylePath);
        return bVar;
    }

    /* renamed from: a */
    public Value mo28457a(int i, Range range, int i2) {
        if (i < 0 || range == null) {
            return null;
        }
        int i3 = i - range.getmPosition();
        QEffect b = C8540q.m24940b(adO(), getGroupId(), i2);
        if (b == null) {
            return null;
        }
        return b.getKeyframeTransformValue(i3);
    }

    /* renamed from: a */
    public void mo27848a(C5655b bVar) {
        m16506a(bVar, getGroupId());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo28458a(boolean z, ScaleRotateViewState scaleRotateViewState, ScaleRotateViewState scaleRotateViewState2) {
        mo28459a(z, scaleRotateViewState, scaleRotateViewState2, true);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo28459a(boolean z, ScaleRotateViewState scaleRotateViewState, ScaleRotateViewState scaleRotateViewState2, boolean z2) {
        if (scaleRotateViewState2 != null && scaleRotateViewState != null) {
            scaleRotateViewState.mPosInfo.setmCenterPosX(scaleRotateViewState2.mPosInfo.getmCenterPosX());
            scaleRotateViewState.mPosInfo.setmCenterPosY(scaleRotateViewState2.mPosInfo.getmCenterPosY());
            scaleRotateViewState.mDegree = scaleRotateViewState2.mDegree;
            scaleRotateViewState.mAlpha = scaleRotateViewState2.mAlpha;
            m16510b(z, scaleRotateViewState, scaleRotateViewState2);
            m16507a(scaleRotateViewState2, scaleRotateViewState, z2);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo28460a(int i, Range range, boolean z) {
        aiC();
        if (adO() == null || range == null || i < 0 || i >= this.cGw.size()) {
            return false;
        }
        if (C8419a.m24319a(adO(), this.cGu, i, new VeRange(range.getmPosition(), range.getmTimeLength()), z) != 0) {
            return false;
        }
        C8441b mg = mo28483mg(i);
        if (mg != null) {
            mg.mo34273b(new VeRange(range.getmPosition(), range.getmTimeLength()));
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo28461a(int i, C8441b bVar) {
        aiC();
        QStoryboard adO = adO();
        MSize surfaceSize = getSurfaceSize();
        MSize streamSize = getStreamSize();
        boolean z = false;
        if (adO == null || surfaceSize == null || bVar == null || streamSize == null) {
            return false;
        }
        if (bVar.aIc() != null && bVar.aIc().getmTimeLength() <= 0) {
            m16509b(bVar);
            bVar.aIc().setmTimeLength(HttpStatus.SC_INTERNAL_SERVER_ERROR);
            LogUtilsV2.m14228e("effect length set to < 500");
        }
        int a = C8419a.m24320a(adO, bVar, i, new VeMSize(surfaceSize.width, surfaceSize.height), new VeMSize(streamSize.width, streamSize.height));
        if (a != 0) {
            return false;
        }
        aiv();
        mo28472b(i, bVar);
        if (a == 0) {
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    public boolean mo28462a(int i, ScaleRotateViewState scaleRotateViewState) {
        QEffect b = C8540q.m24940b(adO(), getGroupId(), i);
        if (b == null || scaleRotateViewState == null || scaleRotateViewState.getRectArea() == null) {
            return false;
        }
        return C8538o.m24860a(b, C8562q.m25042a(scaleRotateViewState.getRectArea(), getSurfaceSize().width, getSurfaceSize().height));
    }

    /* renamed from: a */
    public boolean mo28463a(Range range, ArrayList<C8418a> arrayList, int i) {
        if (arrayList == null || arrayList.size() == 0 || range == null) {
            return true;
        }
        int i2 = range.getmPosition();
        int i3 = range.getmPosition() + range.getmTimeLength();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C8418a aVar = (C8418a) it.next();
            if (aVar.edv < i2 || aVar.edv > i3) {
                it.remove();
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            C8418a aVar2 = (C8418a) it2.next();
            if (!(i2 != aVar2.edv - aVar2.edw)) {
                break;
            }
            aVar2.edw = aVar2.edv - i2;
        }
        return mo28474b(arrayList, i);
    }

    /* renamed from: a */
    public float[] mo28464a(Rect rect, int i) {
        float[] fArr = {1.0f, 1.0f};
        QEffect b = C8540q.m24940b(adO(), getGroupId(), i);
        if (b == null || b.getProperty(QEffect.PROP_EFFECT_KEYFRAME_TRANSFORM_ORIGIN_REGION) == null) {
            return fArr;
        }
        QRect qRect = (QRect) b.getProperty(QEffect.PROP_EFFECT_KEYFRAME_TRANSFORM_ORIGIN_REGION);
        if (qRect.right - qRect.left == 0 || qRect.bottom - qRect.top == 0) {
            return fArr;
        }
        float width = ((float) rect.width()) / ((float) (qRect.right - qRect.left));
        float height = ((float) rect.height()) / ((float) (qRect.bottom - qRect.top));
        fArr[0] = width;
        fArr[1] = height;
        return fArr;
    }

    /* renamed from: aK */
    public ArrayList<Integer> mo28465aK(List<C8441b> list) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (list == null || list.size() == 0) {
            return arrayList;
        }
        int i = 0;
        for (C8441b aIf : list) {
            if (!C8450a.m24475nY(aIf.aIf())) {
                arrayList.add(Integer.valueOf(i));
            }
            i++;
        }
        return arrayList;
    }

    public int aiA() {
        if (this.cGw == null) {
            return 0;
        }
        return this.cGw.size() - 1;
    }

    public int aiB() {
        if (this.cGw == null) {
            return 0;
        }
        return this.cGw.size();
    }

    public boolean aiw() {
        if (this.cGv == null || this.cGw == null) {
            return false;
        }
        if (this.cGv.size() != this.cGw.size()) {
            return true;
        }
        for (int i = 0; i < this.cGv.size(); i++) {
            if (!((C8441b) this.cGv.get(i)).equals(this.cGw.get(i))) {
                return true;
            }
        }
        return false;
    }

    public void aix() {
        adX();
        mo27873h(0, adO().getDuration(), false);
    }

    public C1834l<Boolean> aiy() {
        return this.cyg == null ? C1834l.m5257ah(Boolean.valueOf(false)) : C1834l.m5257ah(Boolean.valueOf(true)).mo10157d(C1820a.aVi()).mo10152c(C1820a.aVi()).mo10161e((C1517e<? super T>) new C1517e<Boolean>() {
            /* renamed from: d */
            public void accept(Boolean bool) {
                long currentTimeMillis = System.currentTimeMillis();
                C8419a.m24330e(C5896a.this.adO(), C5896a.this.cGu);
                StringBuilder sb = new StringBuilder();
                sb.append("restore cacheDataList = ");
                sb.append(C5896a.this.cGv.size());
                sb.append(", effectGroupId = ");
                sb.append(C5896a.this.cGu);
                LogUtilsV2.m14227d(sb.toString());
                VeMSize veMSize = null;
                VeMSize veMSize2 = C5896a.this.getSurfaceSize() != null ? new VeMSize(C5896a.this.getSurfaceSize().width, C5896a.this.getSurfaceSize().height) : null;
                if (C5896a.this.getStreamSize() != null) {
                    veMSize = new VeMSize(C5896a.this.getStreamSize().width, C5896a.this.getStreamSize().height);
                }
                Iterator it = C5896a.this.cGv.iterator();
                while (it.hasNext()) {
                    C8419a.m24321a(C5896a.this.adO(), (C8441b) it.next(), veMSize2, veMSize);
                }
                C5896a.this.cyg.mo29678a(new C6485b());
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("restore cacheDataList = ");
                sb2.append(C5896a.this.cGv.size());
                sb2.append(", effectGroupId = ");
                sb2.append(C5896a.this.cGu);
                sb2.append(", cost = ");
                sb2.append(currentTimeMillis2);
                sb2.append("ms");
                LogUtilsV2.m14227d(sb2.toString());
            }
        }).mo10152c(C1487a.aUa()).mo10161e((C1517e<? super T>) new C1517e<Boolean>() {
            /* renamed from: d */
            public void accept(Boolean bool) {
            }
        });
    }

    public ArrayList<C8441b> aiz() {
        return this.cGw;
    }

    /* renamed from: b */
    public void mo28472b(int i, C8441b bVar) {
        if (this.cGw != null && i < this.cGw.size() && i >= 0) {
            this.cGw.remove(i);
            this.cGw.add(i, bVar);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo28473b(int i, Range range) {
        aiC();
        if (adO() == null || range == null || i < 0 || i >= this.cGw.size()) {
            return false;
        }
        if (C8419a.m24318a(adO(), this.cGu, i, new VeRange(range.getmPosition(), range.getmTimeLength())) != 0) {
            return false;
        }
        C8441b mg = mo28483mg(i);
        if (mg != null) {
            mg.mo34273b(new VeRange(range.getmPosition(), range.getmTimeLength()));
        }
        return true;
    }

    /* renamed from: b */
    public boolean mo28474b(ArrayList<C8418a> arrayList, int i) {
        boolean z = true;
        if (arrayList == null) {
            return true;
        }
        int size = arrayList.size();
        QEffect b = C8540q.m24940b(adO(), getGroupId(), i);
        if (b == null) {
            return true;
        }
        if (size == 0) {
            if (b.setProperty(QEffect.PROP_EFFECT_KEYFRAME_CLEAR, Boolean.valueOf(true)) != 0) {
                z = false;
            }
            return z;
        }
        QKeyFrameTransformData qKeyFrameTransformData = new QKeyFrameTransformData();
        qKeyFrameTransformData.values = new Value[size];
        for (int i2 = 0; i2 < size; i2++) {
            C8418a aVar = (C8418a) arrayList.get(i2);
            qKeyFrameTransformData.values[i2] = new Value();
            qKeyFrameTransformData.values[i2].f3721ts = aVar.edw;
            qKeyFrameTransformData.values[i2].f3722x = aVar.centerX;
            qKeyFrameTransformData.values[i2].f3723y = aVar.centerY;
            qKeyFrameTransformData.values[i2].widthRatio = aVar.widthRatio;
            qKeyFrameTransformData.values[i2].heightRatio = aVar.heightRatio;
            qKeyFrameTransformData.values[i2].rotation = (float) aVar.rotation;
        }
        if (b.setProperty(QEffect.PROP_EFFECT_KEYFRAME_TRANSFORM, qKeyFrameTransformData) != 0) {
            z = false;
        }
        return z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: cs */
    public boolean mo28475cs(int i, int i2) {
        aiC();
        QStoryboard adO = adO();
        MSize surfaceSize = getSurfaceSize();
        MSize streamSize = getStreamSize();
        if (adO == null || surfaceSize == null || streamSize == null || C8419a.m24316a(adO, this.cGu, i, i2) != 0) {
            return false;
        }
        C8441b bVar = (C8441b) aiz().get(i);
        aiz().remove(i);
        aiz().add(i2, bVar);
        aiv();
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: ct */
    public boolean mo28476ct(int i, int i2) {
        aiC();
        if (adO() == null || i2 < 0 || i2 > 100) {
            return false;
        }
        boolean b = C8419a.m24329b(adO(), this.cGu, i, i2);
        if (b) {
            C8441b mg = mo28483mg(i);
            if (mg != null) {
                mg.eef = i2;
            }
        }
        return b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: cu */
    public int mo28477cu(int i, int i2) {
        int duration = adO().getDuration() - i;
        return i2 <= duration ? i2 : duration;
    }

    /* renamed from: fe */
    public List<ScaleRotateViewState> mo28478fe(boolean z) {
        return C8538o.m24852a(C8501a.aJs().aJv(), adO(), getSurfaceSize() != null ? new VeMSize(getSurfaceSize().width, getSurfaceSize().height) : null, this.cGu, adZ(), z);
    }

    /* renamed from: gX */
    public String mo28479gX(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        long templateID = C8762d.aMt().getTemplateID(str);
        if (templateID < 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getTtidByFilePath = ");
        sb.append(templateID);
        LogUtilsV2.m14227d(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(templateID);
        sb2.append("");
        return sb2.toString();
    }

    public abstract int getGroupId();

    /* access modifiers changed from: protected */
    /* renamed from: me */
    public boolean mo28481me(int i) {
        aiC();
        if (i >= this.cGw.size() || i < 0 || C8419a.m24315a(adO(), this.cGu, i) != 0) {
            return false;
        }
        this.cGw.remove(i);
        StringBuilder sb = new StringBuilder();
        sb.append("effectDataModelList = ");
        sb.append(this.cGw.size());
        LogUtilsV2.m14227d(sb.toString());
        aiv();
        return true;
    }

    /* renamed from: mf */
    public List<Integer> mo28482mf(int i) {
        aiC();
        ArrayList arrayList = new ArrayList();
        if (i < 0) {
            return arrayList;
        }
        int i2 = 0;
        Iterator it = this.cGw.iterator();
        while (it.hasNext()) {
            C8441b bVar = (C8441b) it.next();
            if (bVar.aIc() != null) {
                if (bVar.aIc().contains2(i)) {
                    arrayList.add(Integer.valueOf(i2));
                }
                i2++;
            }
        }
        return arrayList;
    }

    /* renamed from: mg */
    public C8441b mo28483mg(int i) {
        if (this.cGw == null || i >= this.cGw.size() || i < 0) {
            return null;
        }
        return (C8441b) this.cGw.get(i);
    }

    /* renamed from: mh */
    public boolean mo28484mh(int i) {
        QEffect b = C8540q.m24940b(adO(), getGroupId(), i);
        boolean z = true;
        if (b == null) {
            return true;
        }
        if (b.setProperty(QEffect.PROP_EFFECT_KEYFRAME_CLEAR, Boolean.valueOf(true)) != 0) {
            z = false;
        }
        return z;
    }

    public void restore() {
        if (this.cyg != null) {
            long currentTimeMillis = System.currentTimeMillis();
            C8419a.m24330e(adO(), this.cGu);
            StringBuilder sb = new StringBuilder();
            sb.append("restore cacheDataList = ");
            sb.append(this.cGv.size());
            sb.append(", effectGroupId = ");
            sb.append(this.cGu);
            LogUtilsV2.m14227d(sb.toString());
            VeMSize veMSize = null;
            VeMSize veMSize2 = getSurfaceSize() != null ? new VeMSize(getSurfaceSize().width, getSurfaceSize().height) : null;
            if (getStreamSize() != null) {
                veMSize = new VeMSize(getStreamSize().width, getStreamSize().height);
            }
            Iterator it = this.cGv.iterator();
            while (it.hasNext()) {
                C8419a.m24321a(adO(), (C8441b) it.next(), veMSize2, veMSize);
            }
            this.cyg.mo29678a(new C6485b());
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("restore cacheDataList = ");
            sb2.append(this.cGv.size());
            sb2.append(", effectGroupId = ");
            sb2.append(this.cGu);
            sb2.append(", cost = ");
            sb2.append(currentTimeMillis2);
            sb2.append("ms");
            LogUtilsV2.m14227d(sb2.toString());
        }
    }
}
