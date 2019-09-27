package com.introvd.template.editor.p266h;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import com.aiii.android.arouter.facade.C1941a;
import com.google.gson.Gson;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.MSize;
import com.introvd.template.common.bitmapfun.util.Utils;
import com.introvd.template.common.gson.GsonUtils;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.editor.R;
import com.introvd.template.editor.base.C5686a;
import com.introvd.template.editor.common.model.ClipEditPanelStateModel;
import com.introvd.template.editor.common.p250d.C5853a;
import com.introvd.template.editor.p261g.C6312c;
import com.introvd.template.module.iap.C7717b;
import com.introvd.template.module.iap.C8071p;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.p173a.C3570a;
import com.introvd.template.p203b.C4586g;
import com.introvd.template.p374q.C8356h;
import com.introvd.template.p374q.C8356h.C8357a;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.VivaRouter;
import com.introvd.template.router.common.CommonParams;
import com.introvd.template.router.community.PublishParams.DomeSocialPublishParams;
import com.introvd.template.router.editor.EditorModes;
import com.introvd.template.router.editor.EditorRouter.ToolPublishParams;
import com.introvd.template.router.editor.export.IExportService;
import com.introvd.template.router.kiwi.LDPProtect;
import com.introvd.template.router.p377ad.AdServiceProxy;
import com.introvd.template.sdk.model.editor.DataItemProject;
import com.introvd.template.sdk.model.editor.EngineSubtitleInfoModel;
import com.introvd.template.sdk.model.editor.ScaleRotateViewState;
import com.introvd.template.sdk.model.editor.TextBubbleInfo.TextBubble;
import com.introvd.template.sdk.utils.C8572y;
import com.introvd.template.sdk.utils.VeMSize;
import com.introvd.template.sdk.utils.p394b.C8522g;
import com.introvd.template.sdk.utils.p394b.C8530i;
import com.introvd.template.sdk.utils.p394b.C8533l;
import com.introvd.template.sdk.utils.p394b.C8537n;
import com.introvd.template.sdk.utils.p394b.C8538o;
import com.introvd.template.sdk.utils.p394b.C8540q;
import com.introvd.template.template.p407e.C8739i;
import com.introvd.template.template.p409g.C8762d;
import xiaoying.engine.QEngine;
import xiaoying.engine.base.QRange;
import xiaoying.engine.base.QStyle.QEffectPropertyData;
import xiaoying.engine.base.QUtils;
import xiaoying.engine.clip.QClip;
import xiaoying.engine.clip.QEffect;
import xiaoying.engine.clip.QUserData;
import xiaoying.engine.storyboard.QStoryboard;

@LDPProtect
/* renamed from: com.introvd.template.editor.h.d */
public class C6386d {
    public static final MSize OUTPUT_SIZE_QVGA = new MSize(320, 240);
    public static final MSize OUTPUT_SIZE_VGA = new MSize((int) QUtils.VIDEO_RES_VGA_WIDTH, 480);
    public static final Long dkB = Long.valueOf(5404319552845119489L);

    /* renamed from: a */
    public static ClipEditPanelStateModel m18363a(QEngine qEngine, QClip qClip) {
        ClipEditPanelStateModel clipEditPanelStateModel = new ClipEditPanelStateModel();
        boolean z = false;
        boolean z2 = ((Integer) qClip.getProperty(12289)).intValue() == 2;
        clipEditPanelStateModel.setImageClip(z2);
        boolean z3 = !C8537n.m24837p(qClip);
        if (z2) {
            clipEditPanelStateModel.setbAudioEnable(false);
        } else {
            clipEditPanelStateModel.setbAudioEnable(z3);
        }
        if (C8537n.m24835n(qClip).booleanValue()) {
            clipEditPanelStateModel.setbPanZoomEnable(true);
        }
        if (C8537n.m24836o(qClip).booleanValue()) {
            clipEditPanelStateModel.setbReversed(true);
        }
        clipEditPanelStateModel.setGroupId(-10);
        QEffectPropertyData[] qEffectPropertyDataArr = null;
        int b = m18373b(qClip);
        long pz = m18379pz(b);
        if (b == 9) {
            qEffectPropertyDataArr = C8537n.m24811a(qEngine, qClip, -10, pz);
            if (qEffectPropertyDataArr != null && qEffectPropertyDataArr.length >= 13) {
                if (qEffectPropertyDataArr[12].mValue > 50) {
                    z = true;
                }
                clipEditPanelStateModel.setbAnimEnable(z);
            }
        } else if (b == 6 || b == 7 || b == 8) {
            qEffectPropertyDataArr = C8537n.m24811a(qEngine, qClip, -10, pz);
            if (qEffectPropertyDataArr != null && qEffectPropertyDataArr.length >= 8) {
                if (qEffectPropertyDataArr[7].mValue > 50) {
                    z = true;
                }
                clipEditPanelStateModel.setbAnimEnable(z);
            }
        } else if (b == -1) {
            qEffectPropertyDataArr = C8537n.m24817b(qEngine, qClip, -3, 5404319552844595203L);
            if (!(qEffectPropertyDataArr == null || qEffectPropertyDataArr.length < 8 || qEffectPropertyDataArr[7] == null)) {
                if (qEffectPropertyDataArr[7].mValue > 50) {
                    z = true;
                }
                clipEditPanelStateModel.setbAnimEnable(z);
            }
            clipEditPanelStateModel.setGroupId(-3);
        }
        clipEditPanelStateModel.setmClipParamDatas(qEffectPropertyDataArr);
        return clipEditPanelStateModel;
    }

    /* renamed from: a */
    static void m18364a(Activity activity, String str, boolean z) {
        if (C3570a.m8779RU()) {
            try {
                Intent intent = activity.getIntent();
                intent.putExtra("activityID", str).putExtra(CommonParams.COMMON_PARAM_LAUCHER_ACTIVITY_NAME, activity.getClass().getSimpleName());
                if (z) {
                    DataItemProject aHe = C8522g.aJA().aHe();
                    IExportService iExportService = (IExportService) BizServiceManager.getService(IExportService.class);
                    if (iExportService != null) {
                        aHe.strCoverURL = iExportService.lauchPickCoverActivity(activity, aHe.strPrjURL, aHe.strCoverURL, aHe.strExtra);
                    }
                    return;
                }
                C1941a aZ = VivaRouter.getRouterBuilder(asS()).mo10400g(intent.getExtras()).mo10394aZ(R.anim.activity_enter, R.anim.activity_exit);
                if (!TextUtils.isEmpty(str)) {
                    aZ.mo10391a(DomeSocialPublishParams.PARAMS_KEY_IS_FROM_SOCIAL, true);
                }
                aZ.mo10382H(activity);
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Can not find PublishActivity:");
                sb.append(e.toString());
                LogUtilsV2.m14228e(sb.toString());
            }
        }
    }

    /* renamed from: a */
    public static void m18365a(C5686a aVar, EngineSubtitleInfoModel engineSubtitleInfoModel) {
        ScaleRotateViewState scaleRotateViewState = engineSubtitleInfoModel.textState;
        if (scaleRotateViewState != null) {
            aVar.adL().mo34669jt(true);
            MSize surfaceSize = aVar.getSurfaceSize();
            if (surfaceSize != null) {
                C8530i.m24755a(scaleRotateViewState, engineSubtitleInfoModel.mTemplatePath, new VeMSize(surfaceSize.width, surfaceSize.height));
                if (scaleRotateViewState.mTextBubbleInfo != null) {
                    TextBubble dftTextBubble = scaleRotateViewState.mTextBubbleInfo.getDftTextBubble();
                    if (dftTextBubble != null) {
                        String str = dftTextBubble.mDftText;
                        String str2 = dftTextBubble.mText;
                        String str3 = "";
                        if (aVar.adK() != null) {
                            DataItemProject aHe = aVar.adK().aHe();
                            if (aHe != null) {
                                str3 = aHe.strPrjURL;
                            }
                        }
                        if (TextUtils.equals(str, str2)) {
                            C8572y.m25075aY(str3, "");
                        } else if (C8533l.m24772oL(str)) {
                            C8572y.m25075aY(str3, str2);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public static void m18366a(QStoryboard qStoryboard, int i, ClipEditPanelStateModel clipEditPanelStateModel, boolean z) {
        if (clipEditPanelStateModel != null && qStoryboard != null && i >= 0 && i < qStoryboard.getClipCount()) {
            QClip clip = qStoryboard.getClip(i);
            if (clip != null) {
                int b = m18373b(clip);
                int i2 = 100;
                if (b == 9) {
                    if (clipEditPanelStateModel.getmClipParamDatas() != null && clipEditPanelStateModel.getmClipParamDatas().length >= 13) {
                        QEffectPropertyData qEffectPropertyData = clipEditPanelStateModel.getmClipParamDatas()[12];
                        if (!z) {
                            i2 = 0;
                        }
                        qEffectPropertyData.mValue = i2;
                    }
                } else if (b == 6 || b == 7 || b == 8) {
                    if (clipEditPanelStateModel.getmClipParamDatas() != null && clipEditPanelStateModel.getmClipParamDatas().length >= 8) {
                        QEffectPropertyData qEffectPropertyData2 = clipEditPanelStateModel.getmClipParamDatas()[7];
                        if (!z) {
                            i2 = 0;
                        }
                        qEffectPropertyData2.mValue = i2;
                    }
                } else if (b == -1 && clipEditPanelStateModel.getmClipParamDatas() != null && clipEditPanelStateModel.getmClipParamDatas().length >= 8) {
                    QEffectPropertyData qEffectPropertyData3 = clipEditPanelStateModel.getmClipParamDatas()[7];
                    if (!z) {
                        i2 = 0;
                    }
                    qEffectPropertyData3.mValue = i2;
                }
                int groupId = clipEditPanelStateModel.getGroupId();
                QEffect qEffect = null;
                if (groupId == -10) {
                    qEffect = C8537n.m24816b(clip, groupId, 0);
                } else if (groupId == -3) {
                    qEffect = C8537n.m24797a(clip, groupId, 0);
                }
                C8537n.m24792a(clipEditPanelStateModel.getmClipParamDatas(), qEffect);
            }
        }
    }

    /* renamed from: a */
    public static void m18367a(QStoryboard qStoryboard, C5853a aVar) {
        if (qStoryboard != null && aVar != null) {
            String json = new Gson().toJson((Object) aVar);
            QUserData qUserData = new QUserData(1);
            qUserData.setUserData(json.getBytes());
            qStoryboard.getDataClip().setProperty(12296, qUserData);
        }
    }

    /* renamed from: a */
    public static void m18368a(boolean z, View view) {
        if (view != null) {
            view.setAlpha(z ? 1.0f : 0.1f);
        }
    }

    /* renamed from: a */
    public static boolean m18369a(float f, float f2, QClip qClip) {
        boolean z = false;
        if (qClip == null) {
            return false;
        }
        if (QUtils.convertPosition(QUtils.convertPosition(((Boolean) qClip.getProperty(QClip.PROP_CLIP_REVERSE_TRIM_MDOE)).booleanValue() ? ((Integer) qClip.getProperty(QClip.PROP_CLIP_MEDIA_DURATION)).intValue() : ((QRange) qClip.getProperty(12292)).get(1), f, true), f2, false) >= 500) {
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    public static boolean m18370a(Activity activity, boolean z, DataItemProject dataItemProject) {
        return m18371a(activity, z, dataItemProject, (String) null);
    }

    /* renamed from: a */
    public static boolean m18371a(final Activity activity, boolean z, final DataItemProject dataItemProject, final String str) {
        if (dataItemProject == null) {
            return false;
        }
        boolean z2 = dataItemProject.iIsModified != 0;
        C8357a oU = C8356h.aKg().mo33614oU(dataItemProject.strPrjURL);
        if (z2 || !(oU != null && oU.ejw == 100 && oU.ejx == 131072)) {
            m18364a(activity, str, dataItemProject.isMiniPrj());
            return true;
        }
        C4586g.m11706a(activity.getApplicationContext(), false, Integer.valueOf(-1), Integer.valueOf(R.string.xiaoying_str_studio_share_already_tip), Integer.valueOf(R.string.xiaoying_str_com_no), Integer.valueOf(R.string.xiaoying_str_com_yes), new OnClickListener() {
            public void onClick(View view) {
                if (1 == ((Integer) view.getTag()).intValue()) {
                    C6386d.m18364a(activity, str, dataItemProject.isMiniPrj());
                }
                C4586g.m11697Sn();
            }
        });
        return false;
    }

    /* renamed from: a */
    public static boolean m18372a(QStoryboard qStoryboard, EngineSubtitleInfoModel engineSubtitleInfoModel) {
        boolean z = true;
        boolean z2 = engineSubtitleInfoModel.mGroupType != 2;
        int i = engineSubtitleInfoModel.mClipIndex;
        if (!C8540q.m24893B(qStoryboard)) {
            return false;
        }
        if (C8540q.m24976w(qStoryboard) && i > 0 && z2) {
            z = false;
        }
        return z;
    }

    public static boolean asR() {
        boolean z = true;
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            return true;
        }
        if (Utils.getUsableSpace(Environment.getExternalStorageDirectory()) < 52428800) {
            z = false;
        }
        return z;
    }

    private static String asS() {
        return !AppStateModel.getInstance().isCommunitySupport() ? ToolPublishParams.URL : DomeSocialPublishParams.URL;
    }

    /* renamed from: b */
    public static int m18373b(QClip qClip) {
        if (C8537n.m24835n(qClip).booleanValue()) {
            return -1;
        }
        long templateID = C8762d.aMt().getTemplateID(C8538o.m24873f(C8537n.m24816b(qClip, -10, 0)));
        if (5404319552844595213L == templateID) {
            return 8;
        }
        if (5404319552844595212L == templateID) {
            return 9;
        }
        if (5404319552844595214L == templateID) {
            return 6;
        }
        return 5404319552844595215L == templateID ? 7 : -1;
    }

    /* renamed from: cJ */
    public static int m18374cJ(View view) {
        if (view == null) {
            return 0;
        }
        int top = view.getTop();
        while (true) {
            ViewParent parent = view.getParent();
            if (!(parent instanceof View)) {
                return top;
            }
            view = (View) parent;
            top += view.getTop();
        }
    }

    /* renamed from: d */
    public static C5853a m18375d(QStoryboard qStoryboard) {
        if (qStoryboard == null) {
            return null;
        }
        Object property = qStoryboard.getDataClip().getProperty(12296);
        if (property instanceof QUserData) {
            QUserData qUserData = (QUserData) property;
            if (qUserData.getUserDataLength() > 0 && qUserData.getUserData() != null) {
                return (C5853a) GsonUtils.fromJson(new String(qUserData.getUserData()), C5853a.class);
            }
        }
        return null;
    }

    /* renamed from: g */
    public static Dialog m18376g(Context context, int i, String str) {
        Dialog dialog = (Dialog) AdServiceProxy.execute(AdServiceProxy.getEncourageAdDialog, context, Integer.valueOf(i), C7825a.ALL_TEMPLATE.getId().equals(str) ? C7825a.ALL_TEMPLATE.getId() : C7717b.m22629ks(str));
        if (dialog != null) {
            dialog.show();
        }
        return dialog;
    }

    public static int getStatusBarHeight(Context context) {
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
    }

    /* renamed from: iL */
    public static boolean m18377iL(String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (C8739i.isNeedToPurchase(str)) {
            C8071p aBx = C8072q.aBx();
            StringBuilder sb = new StringBuilder();
            sb.append("iap.template.");
            sb.append(str);
            if (!aBx.mo33072ku(sb.toString().toLowerCase())) {
                z = true;
            }
        }
        return z;
    }

    /* renamed from: pA */
    public static C6312c m18378pA(int i) {
        switch (i) {
            case 2001:
                return C6312c.EFFECT_PIP;
            case 2002:
                return C6312c.EFFECT_SUBTITLE;
            case 2003:
                return C6312c.EFFECT_STICKER;
            case 2004:
                return C6312c.EFFECT_FX;
            case 2005:
                return C6312c.EFFECT_MUSIC;
            case 2006:
                return C6312c.EFFECT_DUBBING;
            case EditorModes.EFFECT_MOSAIC_MODE /*2007*/:
                return C6312c.EFFECT_MOSAIC;
            default:
                return C6312c.UNKNOWN;
        }
    }

    /* renamed from: pz */
    public static long m18379pz(int i) {
        if (i == 8) {
            return 5404319552844595213L;
        }
        if (i == 9) {
            return 5404319552844595212L;
        }
        if (i == 6) {
            return 5404319552844595214L;
        }
        return i == 7 ? 5404319552844595215L : 0;
    }
}
