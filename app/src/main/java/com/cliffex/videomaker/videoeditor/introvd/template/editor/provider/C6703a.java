package com.introvd.template.editor.provider;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.support.p021v4.content.LocalBroadcastManager;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.editor.service.StoryboardOpService;
import com.introvd.template.explorer.p298c.C7149c;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.editor.EditorIntentInfo;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.router.editor.IEditorService;
import com.introvd.template.sdk.editor.cache.TrimedClipItemDataModel;
import com.introvd.template.sdk.model.TemplateConditionModel;
import com.introvd.template.sdk.model.editor.EffectInfoModel;
import com.introvd.template.sdk.utils.C8545d;
import com.introvd.template.sdk.utils.p394b.C8501a;
import com.introvd.template.sdk.utils.p394b.C8522g;
import com.introvd.template.template.p409g.C8759b;
import com.introvd.template.videoeditor.model.BROWSE_TYPE;
import com.introvd.template.videoeditor.model.ExtMediaItem;
import com.introvd.template.videoeditor.model.MEDIA_TYPE;
import com.introvd.template.videoeditor.model.MediaGroupItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import p037b.p050b.C1834l;
import p037b.p050b.C1838m;
import p037b.p050b.C1839n;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p057e.C1517e;
import p037b.p050b.p076j.C1820a;
import xiaoying.engine.base.QUtils;

/* renamed from: com.introvd.template.editor.provider.a */
public class C6703a {
    /* renamed from: as */
    public static void m19483as(final Activity activity) {
        C1834l.m5254a((C1839n<T>) new C1839n<Boolean>() {
            /* renamed from: a */
            public void mo10177a(final C1838m<Boolean> mVar) throws Exception {
                BROWSE_TYPE browse_type = BROWSE_TYPE.PHOTO;
                C7149c cVar = new C7149c();
                cVar.mo31610a((Context) activity.getApplication(), MEDIA_TYPE.MEDIA_TYPE_FROM_MEDIASTORE, browse_type);
                MediaGroupItem awy = cVar.awy();
                ArrayList arrayList = new ArrayList();
                boolean z = false;
                if (awy == null || awy.mediaItemList == null || awy.mediaItemList.size() <= 0) {
                    mVar.mo9791K(Boolean.valueOf(false));
                    return;
                }
                int i = 0;
                while (i < awy.mediaItemList.size() && i < 5) {
                    arrayList.add(C6703a.m19484iq(((ExtMediaItem) awy.mediaItemList.get(i)).path));
                    i++;
                }
                C8522g aJA = C8522g.aJA();
                IEditorService iEditorService = (IEditorService) BizServiceManager.getService(IEditorService.class);
                String[] strArr = {"", ""};
                if (iEditorService != null) {
                    strArr = iEditorService.getCommonBehaviorParam();
                }
                aJA.ebQ = -1;
                aJA.mo34756b(activity.getApplicationContext(), null, false, strArr[0], strArr[1]);
                Iterator it = arrayList.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    TrimedClipItemDataModel trimedClipItemDataModel = (TrimedClipItemDataModel) it.next();
                    String e = C8545d.m24986e(trimedClipItemDataModel.mExportPath, aJA.aJH(), true);
                    if (e != null) {
                        aJA.mo34725a(e, C8501a.aJs(), i2, -1, -1, trimedClipItemDataModel.mRotate.intValue(), false);
                        i2++;
                    }
                }
                C8759b bVar = new C8759b(1);
                TemplateConditionModel templateConditionModel = new TemplateConditionModel();
                if (aJA.aHe() == null) {
                    mVar.mo9791K(Boolean.valueOf(false));
                    return;
                }
                templateConditionModel.mLayoutMode = QUtils.getLayoutMode(aJA.aHe().streamWidth, aJA.aHe().streamHeight);
                templateConditionModel.isPhoto = true;
                boolean isInChina = AppStateModel.getInstance().isInChina();
                bVar.mo35198a((Context) activity.getApplication(), -1, templateConditionModel, isInChina);
                int count = bVar.getCount();
                C67061 r5 = new BroadcastReceiver() {
                    public void onReceive(Context context, Intent intent) {
                        C8522g.aJA().mo34730a(true, C8501a.aJs(), (Handler) null, false, C8522g.aJA().mo34778uz(C8522g.aJA().ebQ));
                        LocalBroadcastManager.getInstance(context).unregisterReceiver(this);
                        mVar.mo9791K(Boolean.valueOf(true));
                    }
                };
                if (count > 1) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i3 = 1; i3 < count; i3++) {
                        if (!bVar.mo35214vh(i3).isbNeedDownload()) {
                            arrayList2.add(bVar.mo35214vh(i3));
                        }
                    }
                    if (arrayList2.size() > 0) {
                        if (aJA.aHe() == null) {
                            mVar.mo9791K(Boolean.valueOf(false));
                            return;
                        }
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction(IEditorService.RESULT_ACTION_THEME_APPLY_SUC);
                        intentFilter.addAction(IEditorService.RESULT_ACTION_THEME_APPLY_FAIL);
                        LocalBroadcastManager.getInstance(activity.getApplicationContext()).registerReceiver(r5, intentFilter);
                        StoryboardOpService.applyTheme(activity.getApplication(), aJA.aHe().strPrjURL, ((EffectInfoModel) arrayList2.get(new Random().nextInt(arrayList2.size()))).mPath);
                        z = true;
                    }
                }
                if (!z) {
                    C8522g.aJA().mo34730a(true, C8501a.aJs(), (Handler) null, false, C8522g.aJA().mo34778uz(C8522g.aJA().ebQ));
                    mVar.mo9791K(Boolean.valueOf(true));
                }
            }
        }).mo10157d(C1820a.aVi()).mo10152c(C1487a.aUa()).mo10168g((C1517e<? super T>) new C1517e<Boolean>() {
            /* renamed from: d */
            public void accept(Boolean bool) throws Exception {
                if (bool.booleanValue()) {
                    EditorIntentInfo editorIntentInfo = new EditorIntentInfo();
                    editorIntentInfo.from = EditorRouter.ENTRANCE_LOCAL_NOTIFICATION_NEW_MV;
                    editorIntentInfo.autoPlay = true;
                    EditorRouter.launchEditorActivity(activity, editorIntentInfo);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: iq */
    public static TrimedClipItemDataModel m19484iq(String str) {
        TrimedClipItemDataModel trimedClipItemDataModel = new TrimedClipItemDataModel();
        trimedClipItemDataModel.mExportPath = str;
        trimedClipItemDataModel.isExported = Boolean.valueOf(true);
        trimedClipItemDataModel.isImage = Boolean.valueOf(true);
        return trimedClipItemDataModel;
    }
}
