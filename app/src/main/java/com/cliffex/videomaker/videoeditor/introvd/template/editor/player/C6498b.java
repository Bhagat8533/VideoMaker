package com.introvd.template.editor.player;

import android.graphics.Rect;
import android.text.TextUtils;
import com.introvd.template.common.Constants;
import com.introvd.template.common.MSize;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.controller.BaseController;
import com.introvd.template.editor.R;
import com.introvd.template.editor.common.model.ClipEditPanelStateModel;
import com.introvd.template.editor.p266h.C6386d;
import com.introvd.template.editor.p266h.C6408m;
import com.introvd.template.editor.player.p267a.C6483a;
import com.introvd.template.editor.player.p267a.C6485b;
import com.introvd.template.editor.player.p267a.C6486c;
import com.introvd.template.editor.player.p267a.C6487d;
import com.introvd.template.editor.player.p267a.C6488e;
import com.introvd.template.editor.player.p267a.C6489f;
import com.introvd.template.editor.player.p267a.C6490g;
import com.introvd.template.editor.player.p267a.C6491h;
import com.introvd.template.editor.player.p267a.C6493j;
import com.introvd.template.editor.player.p267a.C6494k;
import com.introvd.template.editor.player.p267a.C6495l;
import com.introvd.template.editor.player.p267a.C6496m;
import com.introvd.template.editor.player.p267a.C6497n;
import com.introvd.template.sdk.model.VeRange;
import com.introvd.template.sdk.model.editor.ScaleRotateViewState;
import com.introvd.template.sdk.model.editor.TextEffectParams;
import com.introvd.template.sdk.p383c.C8400d;
import com.introvd.template.sdk.p391g.C8450a;
import com.introvd.template.sdk.utils.C8572y;
import com.introvd.template.sdk.utils.VeMSize;
import com.introvd.template.sdk.utils.p394b.C8530i;
import com.introvd.template.sdk.utils.p394b.C8537n;
import com.introvd.template.sdk.utils.p394b.C8538o;
import com.introvd.template.sdk.utils.p394b.C8540q;
import com.introvd.template.template.p409g.C8762d;
import java.util.List;
import java.util.Map;
import xiaoying.engine.base.QBubbleTextSource;
import xiaoying.engine.base.QRange;
import xiaoying.engine.base.QStyle.QEffectPropertyData;
import xiaoying.engine.base.QUtils;
import xiaoying.engine.clip.QClip;
import xiaoying.engine.clip.QEffect;
import xiaoying.engine.cover.QTitleInfo;
import xiaoying.engine.storyboard.QStoryboard;
import xiaoying.utils.QPoint;
import xiaoying.utils.QRect;

/* renamed from: com.introvd.template.editor.player.b */
public class C6498b extends BaseController<C6482a> {
    /* renamed from: a */
    private QBubbleTextSource m18781a(ScaleRotateViewState scaleRotateViewState, int i, int i2, int i3, String str, MSize mSize, long j) {
        MSize mSize2 = mSize;
        if (mSize2 == null) {
            return null;
        }
        Rect a = C6408m.m18453a(C8530i.m24763t(scaleRotateViewState), mSize2.width, mSize2.height);
        if (a == null) {
            return null;
        }
        float f = (float) i3;
        QBubbleTextSource qBubbleTextSource = new QBubbleTextSource(-1, false, false, f, new QPoint(0, 0), new QRect(a.left, a.top, a.right, a.bottom), 100, i, str, j, null);
        return qBubbleTextSource;
    }

    /* renamed from: a */
    private void m18782a(C6485b bVar) {
        C6482a aVar = (C6482a) getMvpView();
        if (aVar != null) {
            QEffect b = C8537n.m24816b(aVar.getStoryboard().getDataClip(), bVar.groupId, bVar.cYV);
            switch (bVar.actionId) {
                case 1:
                case 6:
                    aVar.mo29677a(6, null);
                    break;
                case 2:
                    aVar.mo29677a(2, b);
                    break;
                case 3:
                    aVar.mo29677a(3, b);
                    break;
                case 4:
                    C8538o.m24870c(b, true);
                    break;
                case 5:
                    C8538o.m24870c(b, false);
                    break;
            }
            aVar.aos();
        }
    }

    /* renamed from: a */
    private void m18783a(C6486c cVar) {
        C6482a aVar = (C6482a) getMvpView();
        QClip clip = aVar.getClip(0);
        if (cVar.type == 0) {
            C8540q.m24917a(aVar.getVEEngine(), cVar.cYW, 0, true, clip);
            QEffect a = C8537n.m24797a(clip, 2, 0);
            m18787a(a, cVar.cYX, cVar.value);
            aVar.mo29685b(2, a);
        } else if (cVar.type == 1) {
            m18787a(C8537n.m24797a(clip, 2, 0), cVar.cYX, cVar.value);
        }
        aVar.aos();
    }

    /* renamed from: a */
    private void m18784a(C6489f fVar) {
        C6482a aVar = (C6482a) getMvpView();
        List<Integer> aox = fVar.aox();
        if (aox != null && aox.size() > 0) {
            for (Integer intValue : aox) {
                C8540q.m24932a(aVar.getStoryboard(), intValue.intValue(), Boolean.valueOf(fVar.aow()));
            }
            aVar.aos();
        }
    }

    /* renamed from: a */
    private void m18785a(C6491h hVar) {
        C6482a aVar = (C6482a) getMvpView();
        Map aoz = hVar.aoz();
        if (aoz != null && aoz.size() > 0) {
            for (Integer num : aoz.keySet()) {
                QClip clip = aVar.getClip(num.intValue());
                ClipEditPanelStateModel clipEditPanelStateModel = (ClipEditPanelStateModel) aoz.get(num);
                if (clip != null && clipEditPanelStateModel != null) {
                    int groupId = clipEditPanelStateModel.getGroupId();
                    QEffect qEffect = null;
                    if (groupId == -10) {
                        qEffect = C8537n.m24816b(clip, groupId, 0);
                    } else if (groupId == -3) {
                        qEffect = C8537n.m24797a(clip, groupId, 0);
                    }
                    C8537n.m24792a(clipEditPanelStateModel.getmClipParamDatas(), qEffect);
                    aVar.mo29685b(2, qEffect);
                } else {
                    return;
                }
            }
            aVar.aos();
        }
    }

    /* renamed from: a */
    private void m18786a(QClip qClip, float f, boolean z) {
        float audioDeltaPitch = !z ? QUtils.getAudioDeltaPitch(f) : 0.0f;
        if (!C8572y.m25061O(f, 1.0f)) {
            z = true;
        }
        qClip.setProperty(QClip.PROP_AUDIO_MODIFY_BY_ASP, Boolean.valueOf(z));
        qClip.setProperty(QClip.PROP_AUDIO_PITCH_DELTA, Float.valueOf(audioDeltaPitch));
    }

    /* renamed from: a */
    private void m18787a(QEffect qEffect, int i, int i2) {
        if (qEffect == null) {
            return;
        }
        if (i > -1) {
            QEffectPropertyData qEffectPropertyData = new QEffectPropertyData();
            qEffectPropertyData.mID = i;
            qEffectPropertyData.mValue = i2;
            qEffect.setProperty(QEffect.PROP_EFFECT_PROPDATA, qEffectPropertyData);
            return;
        }
        qEffect.setProperty(QEffect.PROP_EFFECT_BLEND_ALPHA, Float.valueOf(((float) i2) / 100.0f));
    }

    /* renamed from: a */
    private boolean m18788a(C6483a aVar) {
        C6482a aVar2 = (C6482a) getMvpView();
        int i = 2;
        if (aVar.cYU == 2) {
            i = 3;
        } else if (aVar.cYU == 0) {
            i = 1;
        } else if (aVar.cYU != 1) {
            i = 7;
        }
        aVar2.mo29677a(i, aVar.cYT);
        aVar2.aos();
        return true;
    }

    /* renamed from: a */
    private boolean m18789a(C6487d dVar) {
        C6482a aVar = (C6482a) getMvpView();
        aVar.mo29685b(dVar.cYY, C8540q.m24948d(aVar.getStoryboard(), 6, C8540q.m24958j(aVar.getStoryboard(), 6) - 1));
        aVar.aos();
        return true;
    }

    /* renamed from: a */
    private boolean m18790a(C6488e eVar) {
        if (eVar == null) {
            return false;
        }
        C6482a aVar = (C6482a) getMvpView();
        QClip clip = aVar.getClip(0);
        if (clip == null) {
            return false;
        }
        aVar.aoi();
        C8537n.m24799a(clip, eVar.aov());
        aVar.mo29676a(eVar.adZ(), null, true);
        return true;
    }

    /* renamed from: a */
    private boolean m18791a(C6490g gVar) {
        C6482a aVar = (C6482a) getMvpView();
        QClip clip = aVar.getClip(0);
        if (gVar.aoy() == null) {
            return false;
        }
        if (m18797d(clip)) {
            aVar.mo29685b(2, C8537n.m24797a(clip, 105, 0));
        }
        C8537n.m24792a(gVar.aoy(), C8537n.m24797a(clip, 105, 0));
        aVar.aos();
        return true;
    }

    /* renamed from: a */
    private boolean m18792a(C6493j jVar) {
        C6482a aVar = (C6482a) getMvpView();
        QClip clip = aVar.getClip(0);
        if (clip == null) {
            return false;
        }
        C8537n.m24804a(clip, Boolean.TRUE);
        VeMSize veMSize = null;
        if (C8537n.m24827h(clip, -10) == 0) {
            C8540q.m24918a(aVar.getVEEngine(), C8762d.aMt().mo35225bB(5404319552844595213L), 0, true, clip, -10, C8400d.edi);
            C8540q.m24935a(aVar.getStoryboard(), jVar.aoA() != null ? new VeMSize(jVar.aoA().width, jVar.aoA().height) : null);
        }
        int eventType = jVar.getEventType();
        if (eventType == 1) {
            if (jVar.aoA() != null) {
                veMSize = new VeMSize(jVar.aoA().width, jVar.aoA().height);
            }
            C8540q.m24935a(aVar.getStoryboard(), veMSize);
            if (jVar.aoB()) {
                aVar.aoe();
            }
            return true;
        } else if (eventType == 5) {
            aVar.aoe();
            return true;
        } else if (eventType == 2) {
            C8538o.m24846a(C8537n.m24816b(clip, -10, 0), jVar.getPath());
            return true;
        } else if (eventType == 3) {
            C8540q.m24918a(aVar.getVEEngine(), C8762d.aMt().mo35225bB(jVar.getEffectID()), 0, true, clip, -10, C8400d.edi);
            aVar.mo29685b(6, C8537n.m24816b(clip, -10, 0));
            return true;
        } else if (eventType != 4) {
            return false;
        } else {
            C8537n.m24792a(jVar.aoy(), C8537n.m24816b(clip, -10, 0));
            if (jVar.aoC()) {
                aVar.mo29685b(6, C8537n.m24816b(clip, -10, 0));
            }
            aVar.aos();
            return true;
        }
    }

    /* renamed from: a */
    private boolean m18793a(C6494k kVar) {
        C6482a aVar = (C6482a) getMvpView();
        QClip clip = aVar.getClip(kVar.getFocusIndex());
        if (clip == null) {
            return false;
        }
        if (kVar.getEventType() == 2 || kVar.getEventType() == 3) {
            float speed = kVar.getSpeed();
            if (kVar.getEventType() != 2 || C6386d.m18369a(C8537n.m24834m(clip), speed, clip)) {
                aVar.aoi();
                if (kVar.getEventType() == 2) {
                    C8537n.m24787a(clip, Float.valueOf(speed));
                } else if (kVar.getEventType() == 3) {
                    speed = C8537n.m24834m(clip);
                }
                m18786a(clip, speed, kVar.aoD());
                QRange qRange = (QRange) clip.getProperty(12292);
                if (qRange != null) {
                    int i = qRange.get(0);
                    aVar.setPlayRange(i, qRange.get(1), false, i);
                }
                aVar.mo29685b(10, null);
                QRange qRange2 = (QRange) clip.getProperty(12292);
                if (qRange2 != null) {
                    int i2 = qRange2.get(0);
                    aVar.setPlayRange(i2, qRange2.get(1), false, i2);
                    aVar.mo29698og(i2);
                }
                return true;
            }
            ToastUtils.show(aVar.getContext(), R.string.xiaoying_str_ve_msg_basic_speed_video_duration_too_short_tip, 0);
            return false;
        } else if (kVar.getEventType() != 1) {
            return false;
        } else {
            aVar.aoi();
            return true;
        }
    }

    /* renamed from: a */
    private boolean m18794a(C6495l lVar) {
        ((C6482a) getMvpView()).aoe();
        return true;
    }

    /* renamed from: a */
    private boolean m18795a(C6496m mVar) {
        QBubbleTextSource qBubbleTextSource;
        boolean z;
        Rect rect;
        C6496m mVar2 = mVar;
        C6482a aVar = (C6482a) getMvpView();
        VeMSize veMSize = 0;
        if (!mVar2.cZk) {
            QEffect b = C8540q.m24940b(aVar.getStoryboard(), mVar2.groupId, mVar2.index);
            if (b != null) {
                String e = C8538o.m24872e(b);
                MSize surfaceSize = aVar.getSurfaceSize();
                TextEffectParams a = C8530i.m24747a(e, mVar2.cZj, surfaceSize != null ? new VeMSize(surfaceSize.width, surfaceSize.height) : null);
                if (aVar.getSurfaceSize() != null) {
                    rect = C6408m.m18453a(a == null ? null : a.getmTextRect(), aVar.getSurfaceSize().width, aVar.getSurfaceSize().height);
                } else {
                    rect = null;
                }
                MSize streamSize = aVar.getStreamSize();
                if (streamSize != null) {
                    veMSize = new VeMSize(streamSize.width, streamSize.height);
                }
                if (C8538o.m24871d(b, a, rect, veMSize) == 0) {
                    aVar.mo29677a(2, b);
                    aVar.aos();
                }
            }
        } else {
            QBubbleTextSource title = mVar2.cZl.getTitle(mVar2.index);
            if (title != null && !TextUtils.equals(title.getText(), mVar2.cZm)) {
                int textColor = title.getTextColor();
                QTitleInfo titleDefaultInfo = mVar2.cZl.getTitleDefaultInfo(0, C8450a.m24471c(Constants.getLocale()));
                int i = titleDefaultInfo != null ? titleDefaultInfo.bubbleInfo.mTextAlignment : 16;
                int rotateAngle = (int) title.getRotateAngle();
                if (mVar2.cZj != null) {
                    ScaleRotateViewState scaleRotateViewState = mVar2.cZj;
                    String str = mVar2.cZm;
                    MSize surfaceSize2 = aVar.getSurfaceSize();
                    long j = title.bubbleTemplateID;
                    z = false;
                    qBubbleTextSource = m18781a(scaleRotateViewState, textColor, i, rotateAngle, str, surfaceSize2, j);
                } else {
                    z = false;
                    qBubbleTextSource = veMSize;
                }
                if (qBubbleTextSource == 0) {
                    return z;
                }
                mVar2.cZl.setTitle(mVar2.index, qBubbleTextSource);
                QEffect titleEffect = mVar2.cZl.getTitleEffect(mVar2.index);
                if (titleEffect != null) {
                    aVar.mo29677a(2, titleEffect);
                    aVar.aos();
                }
                return true;
            }
        }
        return true;
    }

    /* renamed from: a */
    private boolean m18796a(C6497n nVar) {
        C6482a aVar = (C6482a) getMvpView();
        int i = nVar.cDc;
        QClip clip = aVar.getClip(i);
        if (clip == null) {
            return false;
        }
        QStoryboard storyboard = aVar.getStoryboard();
        if (!C8537n.m24805a(clip, nVar.cYW, nVar.duration, nVar.cZn)) {
            return false;
        }
        aVar.mo29685b(8, null);
        int q = C8540q.m24968q(storyboard, i);
        VeRange S = C8540q.m24910S(storyboard);
        int i2 = 1000;
        int q2 = C8537n.m24838q(clip);
        if (q2 > 0) {
            i2 = q2 + 1;
        }
        if (!S.contains(q)) {
            q = S.getmPosition();
        }
        if (!S.contains(i2 + q)) {
            i2 = S.getmTimeLength();
        }
        aVar.aos();
        aVar.setPlayRange(q, i2, nVar.cZo, q);
        return true;
    }

    /* renamed from: d */
    private boolean m18797d(QClip qClip) {
        if (C8537n.m24829i(qClip, 105) != 0) {
            return false;
        }
        C8537n.m24788a(qClip, C8762d.aMt().mo35225bB(C6386d.dkB.longValue()), ((C6482a) getMvpView()).getVEEngine(), 105);
        return true;
    }

    /* renamed from: a */
    public void attachView(C6482a aVar) {
        super.attachView(aVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002a, code lost:
        if ((r4 instanceof com.introvd.template.editor.player.p267a.C6488e) == false) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0032, code lost:
        return m18790a((com.introvd.template.editor.player.p267a.C6488e) r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0040, code lost:
        if ((r4 instanceof com.introvd.template.editor.player.p267a.C6487d) == false) goto L_0x00a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0048, code lost:
        return m18789a((com.introvd.template.editor.player.p267a.C6487d) r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x00a3, code lost:
        return false;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <E extends com.introvd.template.editor.player.p267a.p268a.C6484a> boolean mo29748c(E r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 == 0) goto L_0x00a4
            com.introvd.template.common.controller.MvpView r1 = r3.getMvpView()
            if (r1 != 0) goto L_0x000b
            goto L_0x00a4
        L_0x000b:
            int r1 = r4.cZp
            r2 = 1
            switch(r1) {
                case 0: goto L_0x009e;
                case 1: goto L_0x0094;
                case 2: goto L_0x0089;
                case 3: goto L_0x007e;
                case 4: goto L_0x0073;
                case 5: goto L_0x0069;
                case 6: goto L_0x005f;
                case 7: goto L_0x0054;
                case 8: goto L_0x0011;
                case 9: goto L_0x0011;
                case 10: goto L_0x0049;
                case 11: goto L_0x0033;
                case 12: goto L_0x003e;
                case 13: goto L_0x001d;
                case 14: goto L_0x0013;
                case 15: goto L_0x0011;
                case 16: goto L_0x0028;
                default: goto L_0x0011;
            }
        L_0x0011:
            goto L_0x00a3
        L_0x0013:
            boolean r1 = r4 instanceof com.introvd.template.editor.player.p267a.C6491h
            if (r1 == 0) goto L_0x00a3
            com.introvd.template.editor.player.a.h r4 = (com.introvd.template.editor.player.p267a.C6491h) r4
            r3.m18785a(r4)
            return r2
        L_0x001d:
            boolean r1 = r4 instanceof com.introvd.template.editor.player.p267a.C6495l
            if (r1 == 0) goto L_0x0028
            com.introvd.template.editor.player.a.l r4 = (com.introvd.template.editor.player.p267a.C6495l) r4
            boolean r4 = r3.m18794a(r4)
            return r4
        L_0x0028:
            boolean r1 = r4 instanceof com.introvd.template.editor.player.p267a.C6488e
            if (r1 == 0) goto L_0x00a3
            com.introvd.template.editor.player.a.e r4 = (com.introvd.template.editor.player.p267a.C6488e) r4
            boolean r4 = r3.m18790a(r4)
            return r4
        L_0x0033:
            boolean r1 = r4 instanceof com.introvd.template.editor.player.p267a.C6483a
            if (r1 == 0) goto L_0x003e
            com.introvd.template.editor.player.a.a r4 = (com.introvd.template.editor.player.p267a.C6483a) r4
            boolean r4 = r3.m18788a(r4)
            return r4
        L_0x003e:
            boolean r1 = r4 instanceof com.introvd.template.editor.player.p267a.C6487d
            if (r1 == 0) goto L_0x00a3
            com.introvd.template.editor.player.a.d r4 = (com.introvd.template.editor.player.p267a.C6487d) r4
            boolean r4 = r3.m18789a(r4)
            return r4
        L_0x0049:
            boolean r1 = r4 instanceof com.introvd.template.editor.player.p267a.C6496m
            if (r1 == 0) goto L_0x00a3
            com.introvd.template.editor.player.a.m r4 = (com.introvd.template.editor.player.p267a.C6496m) r4
            boolean r4 = r3.m18795a(r4)
            return r4
        L_0x0054:
            boolean r1 = r4 instanceof com.introvd.template.editor.player.p267a.C6493j
            if (r1 == 0) goto L_0x00a3
            com.introvd.template.editor.player.a.j r4 = (com.introvd.template.editor.player.p267a.C6493j) r4
            boolean r4 = r3.m18792a(r4)
            return r4
        L_0x005f:
            boolean r1 = r4 instanceof com.introvd.template.editor.player.p267a.C6485b
            if (r1 == 0) goto L_0x00a3
            com.introvd.template.editor.player.a.b r4 = (com.introvd.template.editor.player.p267a.C6485b) r4
            r3.m18782a(r4)
            return r2
        L_0x0069:
            boolean r1 = r4 instanceof com.introvd.template.editor.player.p267a.C6489f
            if (r1 == 0) goto L_0x00a3
            com.introvd.template.editor.player.a.f r4 = (com.introvd.template.editor.player.p267a.C6489f) r4
            r3.m18784a(r4)
            return r2
        L_0x0073:
            boolean r1 = r4 instanceof com.introvd.template.editor.player.p267a.C6497n
            if (r1 == 0) goto L_0x00a3
            com.introvd.template.editor.player.a.n r4 = (com.introvd.template.editor.player.p267a.C6497n) r4
            boolean r4 = r3.m18796a(r4)
            return r4
        L_0x007e:
            boolean r1 = r4 instanceof com.introvd.template.editor.player.p267a.C6494k
            if (r1 == 0) goto L_0x00a3
            com.introvd.template.editor.player.a.k r4 = (com.introvd.template.editor.player.p267a.C6494k) r4
            boolean r4 = r3.m18793a(r4)
            return r4
        L_0x0089:
            boolean r1 = r4 instanceof com.introvd.template.editor.player.p267a.C6490g
            if (r1 == 0) goto L_0x00a3
            com.introvd.template.editor.player.a.g r4 = (com.introvd.template.editor.player.p267a.C6490g) r4
            boolean r4 = r3.m18791a(r4)
            return r4
        L_0x0094:
            boolean r1 = r4 instanceof com.introvd.template.editor.player.p267a.C6486c
            if (r1 == 0) goto L_0x00a3
            com.introvd.template.editor.player.a.c r4 = (com.introvd.template.editor.player.p267a.C6486c) r4
            r3.m18783a(r4)
            return r2
        L_0x009e:
            boolean r4 = r4 instanceof com.introvd.template.editor.player.p267a.C6492i
            if (r4 == 0) goto L_0x00a3
            return r2
        L_0x00a3:
            return r0
        L_0x00a4:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.editor.player.C6498b.mo29748c(com.introvd.template.editor.player.a.a.a):boolean");
    }

    public void detachView() {
        super.detachView();
    }
}
