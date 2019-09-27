package com.introvd.template.editor.slideshow.story.p286b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.support.p021v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import com.afollestad.materialdialogs.C1885b;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1904j;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.controller.BaseController;
import com.introvd.template.common.utils.UtilsBitmap;
import com.introvd.template.editor.R;
import com.introvd.template.editor.slideshow.p281d.C6781a;
import com.introvd.template.p203b.C4586g;
import com.introvd.template.p414ui.dialog.C8978m;
import com.introvd.template.sdk.editor.cache.TrimedClipItemDataModel;
import com.introvd.template.sdk.p391g.C8451b;
import com.introvd.template.sdk.slide.C8468c;
import com.introvd.template.sdk.utils.C8553i;
import com.introvd.template.sdk.utils.C8558m;
import com.introvd.template.sdk.utils.C8572y;
import com.introvd.template.sdk.utils.p394b.C8501a;
import com.introvd.template.sdk.utils.p394b.C8537n;
import com.introvd.template.template.p409g.C8762d;
import java.util.ArrayList;
import java.util.Iterator;
import xiaoying.engine.base.QStyle;
import xiaoying.engine.base.QStyle.QSlideShowSceCfgInfo;
import xiaoying.engine.clip.QClip;
import xiaoying.utils.QSize;

/* renamed from: com.introvd.template.editor.slideshow.story.b.c */
public class C6852c extends BaseController<C6850a> {
    private Context context;
    private C8468c dfV;
    /* access modifiers changed from: private */
    public BroadcastReceiver dfX;
    /* access modifiers changed from: private */
    public C1890f dhk;
    private long dhr = 0;
    /* access modifiers changed from: private */
    public C1890f din;
    /* access modifiers changed from: private */
    public C1890f dio;

    private void ard() {
        if (this.dfX != null) {
            LocalBroadcastManager.getInstance(this.context).unregisterReceiver(this.dfX);
            this.dfX = null;
        }
        this.dfX = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                try {
                    if ("slideshow.intent.action.prj.save.finish".equals(intent.getAction())) {
                        C4586g.m11696Sm();
                        if (intent.getBooleanExtra("result_key", false)) {
                            ((C6850a) C6852c.this.getMvpView()).ash();
                        } else {
                            ((C6850a) C6852c.this.getMvpView()).asi();
                        }
                        if (C6852c.this.dfX != null) {
                            LocalBroadcastManager.getInstance(context).unregisterReceiver(C6852c.this.dfX);
                            C6852c.this.dfX = null;
                        }
                    } else if ("slideshow.intent.action.prj.save.progress".equals(intent.getAction()) && C4586g.m11694Sk()) {
                        int intExtra = intent.getIntExtra("intent_task_progress_key", 0);
                        int intExtra2 = intent.getIntExtra("intent_task_total", 0);
                        StringBuilder sb = new StringBuilder();
                        sb.append(context.getString(R.string.xiaoying_str_com_loading));
                        sb.append(intExtra);
                        sb.append("/");
                        sb.append(intExtra2);
                        C4586g.m11713eJ(sb.toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("slideshow.intent.action.prj.save.finish");
        intentFilter.addAction("slideshow.intent.action.prj.save.progress");
        LocalBroadcastManager.getInstance(this.context).registerReceiver(this.dfX, intentFilter);
    }

    /* renamed from: k */
    private TrimedClipItemDataModel m20001k(TrimedClipItemDataModel trimedClipItemDataModel) {
        TrimedClipItemDataModel trimedClipItemDataModel2 = new TrimedClipItemDataModel();
        String str = FileUtils.isFileExisted(trimedClipItemDataModel.mExportPath) ? trimedClipItemDataModel.mExportPath : FileUtils.isFileExisted(trimedClipItemDataModel.mRawFilePath) ? trimedClipItemDataModel.mRawFilePath : null;
        if (str != null) {
            QClip f = C8537n.m24824f(str, C8501a.aJs().aJv());
            int dI = C8572y.m25087dI(this.context.getResources().getDimensionPixelSize(R.dimen.time_line_item_width_height), 4);
            Bitmap bitmap = (Bitmap) C8572y.m25066a(f, trimedClipItemDataModel.mVeRangeInRawVideo != null ? trimedClipItemDataModel.mVeRangeInRawVideo.getmPosition() : 0, dI, dI, true, false, 65538, true, false);
            String freeFileName = FileUtils.getFreeFileName(C6781a.asc().asd(), "xyslide_", ".jpg", 0);
            UtilsBitmap.saveBitmap(freeFileName, bitmap);
            trimedClipItemDataModel2.isImage = Boolean.valueOf(true);
            trimedClipItemDataModel2.mRawFilePath = freeFileName;
        }
        return trimedClipItemDataModel2;
    }

    /* renamed from: n */
    private ArrayList<TrimedClipItemDataModel> m20002n(ArrayList<TrimedClipItemDataModel> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            TrimedClipItemDataModel trimedClipItemDataModel = (TrimedClipItemDataModel) it.next();
            if (trimedClipItemDataModel.isImage.booleanValue()) {
                arrayList2.add(trimedClipItemDataModel);
            } else {
                TrimedClipItemDataModel k = m20001k(trimedClipItemDataModel);
                if (k != null) {
                    arrayList2.add(k);
                }
            }
        }
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    /* renamed from: a */
    public void attachView(C6850a aVar) {
        super.attachView(aVar);
    }

    public void detachView() {
        super.detachView();
    }

    /* renamed from: f */
    public void mo30476f(Context context2, final int i, final int i2) {
        if (this.dio == null) {
            this.dio = C8978m.m26348af(context2, context2.getString(R.string.xiaoying_str_com_cancel), context2.getString(R.string.xiaoying_str_com_delete_title)).mo10296do(R.string.xiaoying_str_slide_delete_material_tip).mo10291b(new C1904j() {
                public void onClick(C1890f fVar, C1885b bVar) {
                    if (C6852c.this.dio != null && C6852c.this.dio.isShowing()) {
                        C6852c.this.dio.dismiss();
                    }
                }
            }).mo10281a((C1904j) new C1904j() {
                public void onClick(C1890f fVar, C1885b bVar) {
                    if (C6852c.this.dio != null && C6852c.this.dio.isShowing()) {
                        C6852c.this.dio.dismiss();
                    }
                    ((C6850a) C6852c.this.getMvpView()).mo30465cT(i, i2);
                }
            }).mo10313qu();
        }
        if (!this.dio.isShowing()) {
            this.dio.show();
        }
    }

    /* renamed from: fw */
    public void mo30477fw(Context context2) {
        if (this.din == null) {
            this.din = C8978m.m26348af(context2, null, context2.getString(R.string.xiaoying_str_com_got_it)).mo10274a(R.string.xiaoying_str_slide_prj_clip_count_tip, Integer.valueOf(((C6850a) getMvpView()).asl())).mo10281a((C1904j) new C1904j() {
                public void onClick(C1890f fVar, C1885b bVar) {
                    if (C6852c.this.din != null && C6852c.this.din.isShowing()) {
                        C6852c.this.din.dismiss();
                    }
                }
            }).mo10313qu();
        }
        if (!this.din.isShowing()) {
            this.din.show();
        }
    }

    /* renamed from: fx */
    public void mo30478fx(final Context context2) {
        if (this.dhk == null) {
            this.dhk = C8978m.m26348af(context2, context2.getString(R.string.xiaoying_str_ve_simpleedit_dialog_cancel), context2.getString(R.string.xiaoying_str_slide_prj_continue)).mo10296do(R.string.xiaoying_str_slide_prj_exit_tip).mo10291b(new C1904j() {
                public void onClick(C1890f fVar, C1885b bVar) {
                    C6781a.asc().mo30315fv(context2.getApplicationContext());
                    ((C6850a) C6852c.this.getMvpView()).asi();
                }
            }).mo10281a((C1904j) new C1904j() {
                public void onClick(C1890f fVar, C1885b bVar) {
                    if (C6852c.this.dhk != null && C6852c.this.dhk.isShowing()) {
                        C6852c.this.dhk.dismiss();
                    }
                }
            }).mo10313qu();
        }
        if (!this.dhk.isShowing()) {
            this.dhk.show();
        }
    }

    /* renamed from: h */
    public void mo30479h(Context context2, long j) {
        this.context = context2;
        this.dhr = j;
        C8553i.setContext(context2.getApplicationContext());
        C8553i.m25005ut(23);
        this.dfV = C8468c.aIQ();
        this.dfV.init();
        C6781a.asc().mo30313a(C8451b.STORY_THEME, j, C8558m.m25021d(C8558m.m25017aU("", ((C6850a) getMvpView()).aqP()), ((C6850a) getMvpView()).asg()));
    }

    /* renamed from: m */
    public void mo30480m(ArrayList<TrimedClipItemDataModel> arrayList) {
        boolean z = false;
        C4586g.m11705a(this.context, "", (OnCancelListener) null, false);
        ard();
        QSize qSize = new QSize();
        String bB = C8762d.aMt().mo35225bB(this.dhr);
        if (!TextUtils.isEmpty(bB)) {
            QStyle qStyle = new QStyle();
            if (qStyle.create(bB, null, 1) == 0) {
                qStyle.getThemeExportSize(qSize);
                QSlideShowSceCfgInfo slideShowSceCfgInfo = qStyle.getSlideShowSceCfgInfo();
                if (!(slideShowSceCfgInfo == null || slideShowSceCfgInfo.mBackCoverItem == null)) {
                    arrayList = m20002n(arrayList);
                }
            }
            qStyle.destroy();
        }
        C6781a asc = C6781a.asc();
        Context applicationContext = this.context.getApplicationContext();
        if (qSize.mWidth < qSize.mHeight) {
            z = true;
        }
        asc.mo30312a(applicationContext, z, arrayList);
    }

    public void release() {
        if (this.din != null && this.din.isShowing()) {
            this.din.dismiss();
        }
        if (this.dhk != null && this.dhk.isShowing()) {
            this.dhk.dismiss();
        }
        if (this.dio != null && this.dio.isShowing()) {
            this.dio.dismiss();
        }
        if (this.dfX != null) {
            LocalBroadcastManager.getInstance(this.context).unregisterReceiver(this.dfX);
            this.dfX = null;
        }
    }
}
