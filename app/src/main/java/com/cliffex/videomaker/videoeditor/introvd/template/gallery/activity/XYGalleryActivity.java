package com.introvd.template.gallery.activity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.C0427f;
import android.support.p021v4.app.ActivityCompat;
import android.support.p021v4.app.ActivityOptionsCompat;
import android.support.p021v4.content.LocalBroadcastManager;
import android.support.p021v4.view.ViewPager.OnPageChangeListener;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.afollestad.materialdialogs.C1885b;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1904j;
import com.aiii.android.arouter.facade.p094a.C1942a;
import com.bumptech.glide.C2176e;
import com.bumptech.glide.p111e.p112a.C2183f;
import com.bumptech.glide.p111e.p113b.C2195d;
import com.facebook.ads.AdError;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.introvd.template.EventActivity;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.Constants;
import com.introvd.template.common.ExAsyncTask;
import com.introvd.template.common.ExAsyncTask.Status;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.MSize;
import com.introvd.template.common.MediaFileUtils;
import com.introvd.template.common.ToastUtils;
import com.introvd.template.common.UserBehaviorLog;
import com.introvd.template.common.behavior.UserBehaviorUtils;
import com.introvd.template.common.bitmapfun.util.ImageFetcherWithListener;
import com.introvd.template.common.bitmapfun.util.ImageWorkerFactory;
import com.introvd.template.common.bitmapfun.util.Utils;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.common.p236ui.XYViewPager;
import com.introvd.template.explorer.p298c.C7149c;
import com.introvd.template.explorer.p299d.C7157a;
import com.introvd.template.explorer.p299d.C7157a.C7162c;
import com.introvd.template.explorer.p299d.C7187d;
import com.introvd.template.gallery.AbstractGalleryFragment;
import com.introvd.template.gallery.C7389a;
import com.introvd.template.gallery.C7431b;
import com.introvd.template.gallery.C7444c;
import com.introvd.template.gallery.adapter.GalleryPagerAdapter;
import com.introvd.template.gallery.fragment.GalleryFacebookFragment;
import com.introvd.template.gallery.fragment.GalleryInstagramFragment;
import com.introvd.template.gallery.fragment.GalleryOthersFragment;
import com.introvd.template.gallery.fragment.GallerySystemFragment;
import com.introvd.template.gallery.model.ImgPreviewDataItem;
import com.introvd.template.gallery.p311a.C7391b;
import com.introvd.template.gallery.p312b.C7432a;
import com.introvd.template.gallery.p312b.C7433b;
import com.introvd.template.gallery.p312b.C7434c;
import com.introvd.template.gallery.p313c.C7445a;
import com.introvd.template.gallery.p313c.C7445a.C7446a;
import com.introvd.template.gallery.p313c.C7466c;
import com.introvd.template.gallery.p313c.C7469d;
import com.introvd.template.gallery.p314d.C7474b;
import com.introvd.template.gallery.storyboard.C7487b;
import com.introvd.template.gallery.storyboard.StoryBoardView;
import com.introvd.template.gallery.storyboard.StoryBoardView.C7484b;
import com.introvd.template.gallery.view.p316b.C7511a;
import com.introvd.template.module.iap.C8072q;
import com.introvd.template.module.iap.business.p349a.C7825a;
import com.introvd.template.module.p326ad.C7680l;
import com.introvd.template.module.p326ad.p328b.C7591a;
import com.introvd.template.p173a.p174a.C3574d;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.p203b.C4586g;
import com.introvd.template.p203b.C4600l;
import com.introvd.template.p203b.p204a.C4577f;
import com.introvd.template.p363o.C8086a;
import com.introvd.template.p363o.C8099d;
import com.introvd.template.p414ui.dialog.C8978m;
import com.introvd.template.router.FuncExportRouter;
import com.introvd.template.router.PassThoughUrlGenerator;
import com.introvd.template.router.StudioRouter;
import com.introvd.template.router.camera.CameraRouter;
import com.introvd.template.router.common.CommonParams;
import com.introvd.template.router.editor.EditorRouter;
import com.introvd.template.router.editor.gallery.GalleryIntentInfo;
import com.introvd.template.router.editor.gallery.GalleryRouter;
import com.introvd.template.router.editor.gallery.MediaGalleryRouter;
import com.introvd.template.router.setting.VivaSettingRouter.SettingLocalLocaleParams;
import com.introvd.template.router.slide.SlideshowRouter;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.introvd.template.router.todoCode.TodoConstants;
import com.introvd.template.router.user.SnsAuthServiceProxy;
import com.introvd.template.sdk.editor.cache.TrimedClipItemDataModel;
import com.introvd.template.sdk.model.VeRange;
import com.introvd.template.sdk.model.editor.DataItemProject;
import com.introvd.template.sdk.model.editor.StoryBoardItemInfo;
import com.introvd.template.sdk.p390f.C8446b;
import com.introvd.template.sdk.utils.C8545d;
import com.introvd.template.sdk.utils.C8549f;
import com.introvd.template.sdk.utils.C8555k;
import com.introvd.template.sdk.utils.C8564s;
import com.introvd.template.sdk.utils.C8572y;
import com.introvd.template.sdk.utils.p394b.C8501a;
import com.introvd.template.sdk.utils.p394b.C8522g;
import com.introvd.template.sdk.utils.p394b.C8537n;
import com.introvd.template.sdk.utils.p397d.C8547b;
import com.introvd.template.sns.MediaType;
import com.introvd.template.sns.SnsType;
import com.introvd.template.template.p409g.C8762d;
import com.introvd.template.videoeditor.model.MediaGroupItem;
import com.introvd.template.videoeditor.model.MediaItem;
import com.introvd.template.xygallery.R;
import com.introvd.template.xyui.C9136a;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import p503cz.msebera.android.httpclient.HttpHost;
import xiaoying.engine.QEngine;
import xiaoying.engine.base.QUtils;
import xiaoying.engine.clip.QEffect;

@C1942a(mo10417rZ = "/MediaGallery/entry")
public class XYGalleryActivity extends EventActivity implements OnClickListener, C7433b {
    private TextView bCG;
    /* access modifiers changed from: private */
    public int bIM = -1;
    /* access modifiers changed from: private */
    public C9136a bML;
    /* access modifiers changed from: private */
    public C8522g bMM = null;
    /* access modifiers changed from: private */
    public boolean bMn = false;
    private String bMy;
    /* access modifiers changed from: private */
    public C8501a bOK;
    private RelativeLayout bua;
    private ImageView cQz;
    private GalleryIntentInfo cSA;
    private int cSj = 0;
    private int cSk;
    private int cSp = -1;
    /* access modifiers changed from: private */
    public ImageButton cWj;
    private volatile boolean csC = C8549f.aJd();
    /* access modifiers changed from: private */
    public TODOParamModel cyQ;
    private TabLayout dAr;
    private C7418a dGA = new C7418a() {
        /* renamed from: dh */
        public void mo32042dh(int i, int i2) {
            if (i < XYGalleryActivity.this.dGh.size() && i2 < XYGalleryActivity.this.dGh.size() && XYGalleryActivity.this.dGh.get(i) != null && XYGalleryActivity.this.dGh.get(i2) != null) {
                TrimedClipItemDataModel trimedClipItemDataModel = (TrimedClipItemDataModel) XYGalleryActivity.this.dGh.get(i);
                XYGalleryActivity.this.dGh.remove(i);
                XYGalleryActivity.this.dGh.add(i2, trimedClipItemDataModel);
                XYGalleryActivity.this.bOK.mo34669jt(true);
            }
        }

        /* renamed from: rh */
        public void mo32043rh(int i) {
            if (i >= 0 && i < XYGalleryActivity.this.dGh.size()) {
                TrimedClipItemDataModel trimedClipItemDataModel = (TrimedClipItemDataModel) XYGalleryActivity.this.dGh.remove(i);
                if (trimedClipItemDataModel != null && trimedClipItemDataModel.isExported.booleanValue() && !trimedClipItemDataModel.isImage.booleanValue() && !trimedClipItemDataModel.bCropFeatureEnable.booleanValue()) {
                    XYGalleryActivity.this.bMM.mo34771oD(trimedClipItemDataModel.mExportPath);
                }
            }
            if (XYGalleryActivity.this.dGb != null) {
                XYGalleryActivity.this.dGb.setNextBtnEnable(XYGalleryActivity.this.dGb.getItemCount() >= XYGalleryActivity.this.dGu);
            }
            XYGalleryActivity.this.bOK.mo34669jt(true);
        }
    };
    /* access modifiers changed from: private */
    public StoryBoardView dGb;
    private C7445a dGc;
    private GalleryPagerAdapter dGd;
    /* access modifiers changed from: private */
    public AbstractGalleryFragment dGe;
    private Integer[] dGf = {Integer.valueOf(R.string.xiaoying_str_studio_filter_all), Integer.valueOf(R.string.xiaoying_str_edit_gallery_tab_others_singleline), Integer.valueOf(R.string.xiaoying_str_com_intl_share_facebook), Integer.valueOf(R.string.xiaoying_str_com_intl_share_instagram)};
    private int dGg;
    protected ArrayList<TrimedClipItemDataModel> dGh = new ArrayList<>();
    private boolean dGi = false;
    private final ArrayList<C7414b> dGj = new ArrayList<>();
    /* access modifiers changed from: private */
    public volatile int dGk = 0;
    /* access modifiers changed from: private */
    public ArrayList<String> dGl;
    /* access modifiers changed from: private */
    public C7444c dGm = C7444c.GALLERY_TAB_SYSTEM;
    /* access modifiers changed from: private */
    public int dGn;
    private long dGo;
    /* access modifiers changed from: private */
    public C7434c dGp;
    private boolean dGq;
    /* access modifiers changed from: private */
    public boolean dGr;
    /* access modifiers changed from: private */
    public boolean dGs;
    /* access modifiers changed from: private */
    public boolean dGt = false;
    /* access modifiers changed from: private */
    public int dGu = 0;
    /* access modifiers changed from: private */
    public int dGv = 1073741823;
    private int dGw;
    private boolean dGx = false;
    private C7484b dGy = new C7484b() {
        public void ayU() {
            if (!XYGalleryActivity.this.isFinishing()) {
                if (XYGalleryActivity.this.cyQ != null && XYGalleryActivity.this.cyQ.getActivityFlag() > 0) {
                    if (XYGalleryActivity.this.cyQ.getActivityFlag() == 2) {
                        boolean z = !C8072q.aBx().mo33072ku(C7825a.DURATION_LIMIT.getId());
                        boolean z2 = XYGalleryActivity.this.getDuration() > 300000;
                        if (z && z2) {
                            ToastUtils.show(XYGalleryActivity.this.getApplicationContext(), XYGalleryActivity.this.getString(R.string.xiaoying_str_com_user_other_channel_export_tip, new Object[]{"5"}), 1);
                            return;
                        }
                    }
                }
                XYGalleryActivity.this.ayE();
                if (XYGalleryActivity.this.dGr || XYGalleryActivity.this.dGs) {
                    XYGalleryActivity.this.ayD();
                } else if (!XYGalleryActivity.this.bMn || !XYGalleryActivity.this.ayC()) {
                    XYGalleryActivity.this.save();
                }
            }
        }

        public void ayV() {
        }
    };
    private C7446a dGz = new C7446a() {
        /* renamed from: rn */
        public void mo32046rn(int i) {
            if (XYGalleryActivity.this.mFragments != null && XYGalleryActivity.this.mFragments.size() > 0) {
                for (AbstractGalleryFragment ai : XYGalleryActivity.this.mFragments) {
                    ai.mo32017ai(i, false);
                }
            }
            XYGalleryActivity.this.dGn = i;
            C7431b.aym().mo32087rc(i);
        }
    };
    private ImageFetcherWithListener dgb;
    private HashMap<String, String> dqL = new HashMap<>();
    /* access modifiers changed from: private */
    public List<AbstractGalleryFragment> mFragments = new ArrayList();
    /* access modifiers changed from: private */
    public Handler mHandler = new C7415c(this);
    /* access modifiers changed from: private */
    public XYViewPager mViewPager;

    /* renamed from: com.introvd.template.gallery.activity.XYGalleryActivity$2 */
    static /* synthetic */ class C74042 {
        static final /* synthetic */ int[] dGC = new int[C7444c.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                com.introvd.template.gallery.c[] r0 = com.introvd.template.gallery.C7444c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                dGC = r0
                int[] r0 = dGC     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.introvd.template.gallery.c r1 = com.introvd.template.gallery.C7444c.GALLERY_TAB_SYSTEM     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = dGC     // Catch:{ NoSuchFieldError -> 0x001f }
                com.introvd.template.gallery.c r1 = com.introvd.template.gallery.C7444c.GALLERY_TAB_OTHERS     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = dGC     // Catch:{ NoSuchFieldError -> 0x002a }
                com.introvd.template.gallery.c r1 = com.introvd.template.gallery.C7444c.GALLERY_TAB_FACEBOOK     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = dGC     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.introvd.template.gallery.c r1 = com.introvd.template.gallery.C7444c.GALLERY_TAB_INSTAGRAM     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.gallery.activity.XYGalleryActivity.C74042.<clinit>():void");
        }
    }

    /* renamed from: com.introvd.template.gallery.activity.XYGalleryActivity$a */
    private class C7413a {
        String dGF;
        Bitmap mBitmap;
        float rotation;

        private C7413a() {
            this.dGF = "";
            this.rotation = 0.0f;
        }
    }

    /* renamed from: com.introvd.template.gallery.activity.XYGalleryActivity$b */
    private class C7414b extends ExAsyncTask<Object, Void, Integer> {
        private C7414b() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public Integer doInBackground(Object... objArr) {
            String str;
            LogUtils.m14222e(XYGalleryActivity.TAG, "InsertFileTask doInBackground 1!!");
            if (XYGalleryActivity.this.dGl == null) {
                XYGalleryActivity.this.dGl = new ArrayList();
            }
            Integer valueOf = Integer.valueOf(0);
            String str2 = objArr[0].mExportPath;
            try {
                Process.setThreadPriority(0);
                LogUtils.m14222e(XYGalleryActivity.TAG, "InsertFileTask doInBackground 2!!");
                if (!XYGalleryActivity.this.m21880jF(str2) && !XYGalleryActivity.this.dGl.contains(str2)) {
                    XYGalleryActivity.this.dGl.add(str2);
                    LogUtils.m14222e(XYGalleryActivity.TAG, "creating!!");
                    if (str2.endsWith(".gif")) {
                        str = str2;
                    } else {
                        str = C8545d.m24986e(str2, XYGalleryActivity.this.bMM.aJH(), true);
                        C8522g.m24676iP(str);
                    }
                    XYGalleryActivity.this.m21853as(str2, str);
                    if (TextUtils.isEmpty(str)) {
                        valueOf = Integer.valueOf(-1);
                    }
                    XYGalleryActivity.this.dGl.remove(str2);
                }
            } catch (Exception e) {
                e.printStackTrace();
                LogUtils.m14222e(XYGalleryActivity.TAG, "InsertFileTask doInBackground ERROR!!");
            } catch (Throwable th) {
                XYGalleryActivity.this.m21899rm(-1);
                throw th;
            }
            XYGalleryActivity.this.m21899rm(-1);
            if (valueOf.intValue() == 0 && XYGalleryActivity.this.bOK != null) {
                XYGalleryActivity.this.bOK.mo34669jt(true);
            }
            return valueOf;
        }

        /* access modifiers changed from: protected */
        /* renamed from: l */
        public void onPostExecute(Integer num) {
            super.onPostExecute(num);
            LogUtils.m14222e(XYGalleryActivity.TAG, "InsertFileTask doInBackground 3!!");
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            LogUtils.m14222e(XYGalleryActivity.TAG, "InsertFileTask doInBackground 0!!");
            super.onPreExecute();
        }
    }

    /* renamed from: com.introvd.template.gallery.activity.XYGalleryActivity$c */
    private static class C7415c extends Handler {
        private WeakReference<XYGalleryActivity> dGG;

        public C7415c(XYGalleryActivity xYGalleryActivity) {
            this.dGG = new WeakReference<>(xYGalleryActivity);
        }

        public void handleMessage(Message message) {
            final XYGalleryActivity xYGalleryActivity = (XYGalleryActivity) this.dGG.get();
            if (xYGalleryActivity != null) {
                int i = message.what;
                if (i != 4104) {
                    if (i == 4117) {
                        MediaItem mediaItem = null;
                        if (message.obj instanceof MediaItem) {
                            mediaItem = (MediaItem) message.obj;
                        }
                        if (mediaItem != null) {
                            int size = xYGalleryActivity.dGh.size();
                            if (xYGalleryActivity.amm()) {
                                if (xYGalleryActivity.dGt && size > 0) {
                                    xYGalleryActivity.m21868f(xYGalleryActivity, 1);
                                    return;
                                }
                            } else if (size >= xYGalleryActivity.dGv) {
                                xYGalleryActivity.m21868f(xYGalleryActivity, xYGalleryActivity.dGv);
                                return;
                            }
                            xYGalleryActivity.m21849a(mediaItem);
                        }
                    } else if (i == 4625) {
                        ArrayList arrayList = (ArrayList) message.obj;
                        if (arrayList.size() > 0) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                TrimedClipItemDataModel trimedClipItemDataModel = (TrimedClipItemDataModel) it.next();
                                xYGalleryActivity.m21831A(trimedClipItemDataModel.mRawFilePath, trimedClipItemDataModel.mRotate.intValue());
                            }
                        }
                        C4586g.m11695Sl();
                    } else if (i != 4865) {
                        switch (i) {
                            case QEffect.PROP_AUDIO_FRAME_REPEAT_MODE /*4113*/:
                                xYGalleryActivity.bIM = ((Integer) message.obj).intValue();
                                break;
                            case QEffect.PROP_AUDIO_FRAME_MIXPERCENT /*4114*/:
                                xYGalleryActivity.m21872ih(((Boolean) message.obj).booleanValue());
                                break;
                            case QEffect.PROP_AUDIO_FRAME_ADJUST_DB /*4115*/:
                                xYGalleryActivity.m21851a(false, (MediaGroupItem) message.obj);
                                break;
                            default:
                                switch (i) {
                                    case QEffect.PROP_ORIGINAL_RANGE /*4119*/:
                                        xYGalleryActivity.mViewPager.setCanScroll(false);
                                        if (xYGalleryActivity.cWj.isShown()) {
                                            xYGalleryActivity.cWj.setVisibility(8);
                                            break;
                                        }
                                        break;
                                    case QEffect.PROP_VIDEO_IE_CONFIGURE /*4120*/:
                                        removeMessages(QEffect.PROP_VIDEO_IE_CONFIGURE);
                                        if (!(message.obj instanceof MediaItem)) {
                                            if (message.obj instanceof List) {
                                                xYGalleryActivity.m21888l((List) message.obj, message.arg1);
                                                break;
                                            }
                                        } else {
                                            xYGalleryActivity.m21859b((MediaItem) message.obj);
                                            break;
                                        }
                                        break;
                                    default:
                                        switch (i) {
                                            case 5377:
                                                final String str = (String) message.obj;
                                                C4586g.m11705a((Context) xYGalleryActivity, "0%", (OnCancelListener) new OnCancelListener() {
                                                    public void onCancel(DialogInterface dialogInterface) {
                                                        C7157a.m21184fY(xYGalleryActivity).mo31634jm(str);
                                                    }
                                                }, true);
                                                break;
                                            case 5378:
                                                StringBuilder sb = new StringBuilder();
                                                sb.append(message.arg1);
                                                sb.append("%");
                                                C4586g.m11713eJ(sb.toString());
                                                break;
                                            case 5379:
                                                if (!xYGalleryActivity.isFinishing()) {
                                                    C4586g.m11713eJ("100%");
                                                    C4586g.m11696Sm();
                                                }
                                                String str2 = (String) message.obj;
                                                if (!TextUtils.isEmpty(str2)) {
                                                    if (xYGalleryActivity.amm()) {
                                                        if (!C8572y.m25091e(str2, xYGalleryActivity.bOK.aJv())) {
                                                            C4577f.m11626a((Context) xYGalleryActivity, 0, xYGalleryActivity.ayH(), R.string.xiaoying_str_ve_clip_add_msg_invalid_file);
                                                            break;
                                                        } else {
                                                            xYGalleryActivity.m21875jA(str2);
                                                            break;
                                                        }
                                                    } else {
                                                        xYGalleryActivity.m21876jB(str2);
                                                        break;
                                                    }
                                                }
                                                break;
                                            case 5380:
                                                if (!xYGalleryActivity.isFinishing()) {
                                                    C4586g.m11696Sm();
                                                    xYGalleryActivity.ayL();
                                                    break;
                                                }
                                                break;
                                            case 5381:
                                                if (xYGalleryActivity.dGh.size() > 0) {
                                                    int b = xYGalleryActivity.m21873ii(false);
                                                    int b2 = xYGalleryActivity.m21873ii(true);
                                                    if (b > 0 || b2 > 10) {
                                                        ImageView imageView = xYGalleryActivity.dGb.dJs;
                                                        if (imageView != null) {
                                                            String string = xYGalleryActivity.getString(R.string.xiaoying_str_click_to_preview);
                                                            xYGalleryActivity.bML.mo36079a(AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_help_gallery_next", true), 5, string, imageView, C4580b.m11666qi(), -80, 0, 200, 5000);
                                                            AppPreferencesSetting.getInstance().setAppSettingBoolean("pref_help_gallery_next", false);
                                                            break;
                                                        }
                                                    }
                                                }
                                                break;
                                        }
                                }
                        }
                    } else {
                        removeMessages(4865);
                        if (xYGalleryActivity.dGe != null && !xYGalleryActivity.dGe.ayk()) {
                            xYGalleryActivity.dGe.mo32017ai(xYGalleryActivity.dGn, true);
                            sendEmptyMessageDelayed(4865, AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
                        }
                    }
                } else if (xYGalleryActivity.dGk > 0) {
                    sendEmptyMessageDelayed(4104, 100);
                } else {
                    xYGalleryActivity.dGp.mo32093a((List<TrimedClipItemDataModel>) xYGalleryActivity.dGh, (C7432a) new C7432a() {
                        /* renamed from: fW */
                        public void mo32047fW(boolean z) {
                            xYGalleryActivity.mo32036fW(z);
                        }
                    });
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: A */
    public void m21831A(String str, int i) {
        if (C8572y.m25084d(str, this.bOK.aJv()) != 0) {
            C4577f.m11626a((Context) this, 0, ayH(), R.string.xiaoying_str_ve_clip_add_msg_invalid_file);
            return;
        }
        if (!((ayF() ? ayM() : 0) < 30 || this.bMM == null || this.bMM.aHe() == null)) {
            String str2 = this.bMM.aHe().strPrjURL;
            if (!TextUtils.isEmpty(str2) && !m21883jI(str2)) {
                m21884jJ(str2);
                C7511a aVar = new C7511a(this);
                aVar.setContent(getString(R.string.xiaoying_str_gallery_img_count_over_limit_cause_export_slow_tip, new Object[]{Integer.valueOf(30)}));
                aVar.setTitle(getString(R.string.xiaoying_str_com_warm_tip_title));
                aVar.mo32296jN(getString(R.string.xiaoying_str_com_got_it));
                aVar.show();
                UserBehaviorLog.onKVEvent(getApplicationContext(), "Gallery_Pic_Count_Limit", new HashMap());
                return;
            }
        }
        if (!amm() && !this.dGs && this.mHandler != null) {
            this.mHandler.sendEmptyMessageDelayed(5381, 100);
        }
        Bitmap jE = m21879jE(str);
        C7413a aVar2 = new C7413a();
        aVar2.dGF = str;
        aVar2.mBitmap = jE;
        aVar2.rotation = (float) i;
        TrimedClipItemDataModel trimedClipItemDataModel = new TrimedClipItemDataModel();
        trimedClipItemDataModel.mRawFilePath = str;
        trimedClipItemDataModel.mExportPath = str;
        trimedClipItemDataModel.isExported = Boolean.valueOf(true);
        trimedClipItemDataModel.isImage = Boolean.valueOf(true);
        trimedClipItemDataModel.mRotate = Integer.valueOf(i);
        this.dGh.add(trimedClipItemDataModel);
        m21838a(aVar2);
        m21892n(trimedClipItemDataModel);
        C2176e.m6137am(getApplicationContext()).mo12205tP().mo12179aO(str).mo12180b(new C2183f<Bitmap>() {
            /* renamed from: a */
            public void mo11939a(Bitmap bitmap, C2195d<? super Bitmap> dVar) {
                C7389a.m21786c(XYGalleryActivity.this.getApplicationContext(), new MSize(bitmap.getWidth(), bitmap.getHeight()));
            }
        });
    }

    /* renamed from: a */
    private void m21838a(C7413a aVar) {
        if (aVar != null) {
            Bitmap bitmap = aVar.mBitmap;
            StoryBoardItemInfo storyBoardItemInfo = new StoryBoardItemInfo();
            storyBoardItemInfo.bmpThumbnail = bitmap;
            storyBoardItemInfo.isVideo = false;
            storyBoardItemInfo.isGif = C7474b.m22085jM(aVar.dGF);
            storyBoardItemInfo.mRotation = aVar.rotation;
            storyBoardItemInfo.mSourcePath = aVar.dGF;
            m21848a(storyBoardItemInfo);
            if (1 == this.dGb.getItemCount() % 4) {
                this.dGb.scrollToPosition(this.dGb.getItemCount());
            }
        }
    }

    /* renamed from: a */
    private void m21839a(C7414b bVar) {
        for (int size = this.dGj.size() - 1; size >= 0; size--) {
            C7414b bVar2 = (C7414b) this.dGj.get(size);
            if (bVar2 != null && bVar2.getStatus() == Status.FINISHED) {
                this.dGj.remove(size);
            }
        }
        this.dGj.add(bVar);
    }

    /* renamed from: a */
    private void m21848a(StoryBoardItemInfo storyBoardItemInfo) {
        if (this.dGb != null) {
            this.dGb.mo32167b(storyBoardItemInfo);
            this.dGb.mo32169fp();
            this.dGb.setNextBtnEnable(this.dGb.getItemCount() >= this.dGu);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m21849a(MediaItem mediaItem) {
        if (this.bML != null) {
            this.bML.aNX();
        }
        if (amm()) {
            if (!this.dGe.ayj() && this.bOK != null) {
                String str = mediaItem.path;
                if (str != null && str.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    m21850a(mediaItem, str);
                } else if (C8572y.m25091e(str, this.bOK.aJv())) {
                    m21875jA(mediaItem.path);
                } else {
                    ToastUtils.show(getApplicationContext(), R.string.xiaoying_str_ve_clip_add_msg_invalid_file, 0);
                }
            }
        } else if (!this.dGe.ayj()) {
            String str2 = mediaItem.path;
            if (str2 == null || !str2.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                m21876jB(str2);
            } else {
                m21850a(mediaItem, str2);
            }
        }
    }

    /* renamed from: a */
    private void m21850a(final MediaItem mediaItem, String str) {
        int i = 1;
        boolean k = C4600l.m11739k(this, true);
        C7157a fY = C7157a.m21184fY(this);
        if (mediaItem.mediaType == MediaType.MEDIA_TYPE_IMAGE) {
            i = 0;
        }
        int i2 = -1;
        if (mediaItem.snsType == SnsType.SNS_TYPE_FACEBOOK) {
            i2 = 28;
        } else if (mediaItem.snsType == SnsType.SNS_TYPE_INSTAGRAM) {
            i2 = 31;
        }
        if (k) {
            fY.mo31633a(this.mHandler);
            String a = fY.mo31632a(str, i, i2, new C7162c() {
                /* renamed from: aI */
                public void mo31639aI(long j) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(j);
                    sb.append("");
                    LogUtils.m14223i("download start", sb.toString());
                    if (XYGalleryActivity.this.mHandler != null) {
                        XYGalleryActivity.this.mHandler.sendMessage(XYGalleryActivity.this.mHandler.obtainMessage(5377, mediaItem.path));
                    }
                }

                public void axQ() {
                    if (XYGalleryActivity.this.mHandler != null) {
                        XYGalleryActivity.this.mHandler.sendEmptyMessage(5380);
                    }
                }

                /* renamed from: i */
                public void mo31641i(long j, int i) {
                    if (XYGalleryActivity.this.mHandler != null) {
                        XYGalleryActivity.this.mHandler.sendMessage(XYGalleryActivity.this.mHandler.obtainMessage(5378, i, 0));
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(j);
                    sb.append("/");
                    sb.append(i);
                    LogUtils.m14223i("downloading", sb.toString());
                }

                /* renamed from: i */
                public synchronized void mo31642i(long j, String str) {
                    mediaItem.path = str;
                    if (XYGalleryActivity.this.mHandler != null) {
                        XYGalleryActivity.this.mHandler.sendMessage(XYGalleryActivity.this.mHandler.obtainMessage(5379, str));
                    }
                }
            });
            if (TextUtils.isEmpty(a)) {
                return;
            }
            if (!this.dGt) {
                m21876jB(a);
            } else if (C8572y.m25091e(a, this.bOK.aJv())) {
                m21875jA(a);
            } else {
                ToastUtils.show(getApplicationContext(), R.string.xiaoying_str_ve_clip_add_msg_invalid_file, 0);
            }
        } else {
            String a2 = fY.mo31632a(str, i, i2, null);
            if (TextUtils.isEmpty(a2)) {
                ayL();
            } else if (!this.dGt) {
                m21876jB(a2);
            } else if (C8572y.m25091e(a2, this.bOK.aJv())) {
                m21875jA(mediaItem.path);
            } else {
                C4577f.m11626a((Context) this, 0, ayH(), R.string.xiaoying_str_ve_clip_add_msg_invalid_file);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21851a(boolean z, MediaGroupItem mediaGroupItem) {
        if (z) {
            this.cQz.setImageResource(R.drawable.v4_xiaoying_cam_btn_cam_cancel_selector);
            if (amm()) {
                this.bCG.setVisibility(0);
                this.dGc.mo32112rs(8);
                this.bCG.setText(R.string.xiaoying_str_ve_choose_videos_title);
                return;
            }
            this.bCG.setVisibility(8);
            this.dGc.mo32112rs(0);
            this.dGc.mo32111rr(this.dGc.aze());
            return;
        }
        this.cQz.setImageResource(R.drawable.v5_xiaoying_com_btn_back_selector);
        StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).toString());
        sb.append(File.separator);
        sb.append("Camera");
        String sb2 = sb.toString();
        if (mediaGroupItem.strParentPath == null || !mediaGroupItem.strParentPath.equals(sb2)) {
            this.dGc.mo32112rs(8);
            this.bCG.setText(mediaGroupItem.strGroupDisplayName);
        } else {
            this.bCG.setText(R.string.xiaoying_str_com_camera_title);
        }
        this.bCG.setVisibility(0);
    }

    /* renamed from: a */
    private boolean m21852a(String str, QEngine qEngine) {
        boolean z = false;
        if (TextUtils.isEmpty(str) || qEngine == null || (!MediaFileUtils.IsVideoFileType(MediaFileUtils.GetFileMediaType(str))) || C8572y.m25084d(str, qEngine) != 0) {
            return false;
        }
        if (C8537n.m24824f(str, qEngine) != null) {
            z = true;
        }
        return z;
    }

    private int amR() {
        Iterator it = this.dGh.iterator();
        int i = 0;
        while (it.hasNext()) {
            TrimedClipItemDataModel trimedClipItemDataModel = (TrimedClipItemDataModel) it.next();
            if (trimedClipItemDataModel.isImage.booleanValue()) {
                i += 3000;
            } else {
                VeRange veRange = trimedClipItemDataModel.mVeRangeInRawVideo;
                if (veRange != null && veRange.getmTimeLength() > 0) {
                    i += veRange.getmTimeLength();
                }
            }
        }
        return i;
    }

    /* access modifiers changed from: private */
    public boolean amm() {
        return this.dGt || this.dGq;
    }

    private void amr() {
        this.bua = (RelativeLayout) findViewById(R.id.gallery_title_layout);
        this.bCG = (TextView) findViewById(R.id.title);
        this.cQz = (ImageView) findViewById(R.id.xiaoying_com_btn_left);
        this.cWj = (ImageButton) findViewById(R.id.gallery_btn_captrue);
        this.cWj.setOnClickListener(this);
        this.cQz.setOnClickListener(this);
        this.cWj.setVisibility(this.dGr ? 0 : 8);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.gallery_chooser_layout);
        ViewGroup viewGroup2 = (ViewGroup) findViewById(R.id.gallery_chooser_B_layout);
        if (C7391b.dHw) {
            viewGroup.setVisibility(8);
            viewGroup2.setVisibility(0);
            this.dGc = new C7469d(viewGroup2);
        } else {
            viewGroup.setVisibility(0);
            viewGroup2.setVisibility(8);
            this.dGc = new C7466c(viewGroup);
        }
        this.dGc.mo32106a(this.dGz);
        if (!amm()) {
            this.dGc.mo32110rq(this.dGg);
            if (this.cSA.isFocusPhotoTab()) {
                this.dGc.setFocusTab(1);
            }
        }
        if (amm()) {
            this.bCG.setText(R.string.xiaoying_str_ve_choose_videos_title);
        } else {
            this.bCG.setText(getString(R.string.xiaoying_str_ve_basic_multi_clip_op_title));
        }
        m21851a(true, (MediaGroupItem) null);
        if (this.cyQ != null && this.cyQ.getActivityFlag() == 1) {
            this.dGc.mo32110rq(1);
        }
        if (this.dGc != null) {
            this.dGc.azd();
        }
    }

    private void anI() {
        if (this.dGt || this.dGs || this.dGr) {
            setResult(0);
            finish();
        } else if (this.dGq) {
            this.dGp.ahV();
            finish();
            overridePendingTransition(R.anim.xiaoying_activity_enter, R.anim.xiaoying_activity_exit);
        } else if (this.bMn) {
            if (this.dGh.size() <= 0) {
                this.dGp.ahV();
                finish();
                overridePendingTransition(R.anim.xiaoying_activity_enter, R.anim.xiaoying_activity_exit);
                return;
            }
            ayJ();
        } else if (this.bOK.isProjectModified()) {
            ayJ();
        } else {
            StudioRouter.launchStudioActivity(this);
            finish();
        }
    }

    private void arc() {
        if (this.dgb == null) {
            int dpFloatToPixel = C4583d.dpFloatToPixel(this, 100.0f);
            int dpFloatToPixel2 = C4583d.dpFloatToPixel(this, 100.0f);
            this.dgb = ImageWorkerFactory.CreateImageWorker(this, dpFloatToPixel, dpFloatToPixel2, "gallery_thumbnails", Utils.calculateBitmapCacheSize(20, dpFloatToPixel, dpFloatToPixel2), 100);
            this.dgb.setGlobalImageWorker(null);
            this.dgb.setImageFadeIn(2);
            this.dgb.setErrorImage(R.drawable.xiaoying_com_gallery_failed_icon);
            this.dgb.setLoadMode(65538);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: as */
    public synchronized void m21853as(String str, String str2) {
        if (!this.dqL.containsKey(str)) {
            this.dqL.put(str, str2);
        }
    }

    private void ayA() {
        this.dGb.setMinHeight(C4583d.m11671P(117.0f));
        this.dGb.setMaxHeight(Constants.getScreenSize().height - C4583d.m11671P(139.0f));
    }

    private void ayB() {
        this.dGb = (StoryBoardView) findViewById(R.id.gallery_storyoard_view);
        this.dGb.setVisibility(0);
        this.dGb.setAdapter(new C7487b(this));
        this.dGb.setDragListener(this.dGA);
        this.dGb.setStoryBoardListener(this.dGy);
        if (this.dGg == 2) {
            this.dGb.setCountInfoTextId(R.string.xiaoying_str_ve_storyboard_title_img_add_count, -1);
        } else {
            this.dGb.setCountInfoTextId(R.string.xiaoying_str_ve_storyboard_title_item_count, R.string.xiaoying_str_ve_storyboard_title_single_item_count);
        }
        if (this.cSj == 10) {
            this.dGb.setNextBtnEnable(false);
        }
        if (this.dGh.size() > 0) {
            for (int i = 0; i < this.dGh.size(); i++) {
                m21890m((TrimedClipItemDataModel) this.dGh.get(i));
            }
        }
        this.dGb.azv();
        ayA();
        this.dGb.mo32169fp();
    }

    /* access modifiers changed from: private */
    public boolean ayC() {
        if (this.dGg == 2) {
            int i = C7391b.dHu;
            if (i > 0 && this.dGh.size() < i) {
                if (C7391b.dHt == 2) {
                    if (!this.dGx) {
                        C7389a.m21782a(getApplicationContext(), false, this.dGh.size());
                        this.dGx = true;
                        C4577f.m11628a((Context) this, ayH(), (CharSequence) getResources().getString(R.string.xiaoying_str_gallery_mv_count_advance_tip, new Object[]{String.valueOf(i)}), 0, (long) DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
                        return true;
                    }
                } else if (C7391b.dHt == 1) {
                    C7389a.m21782a(getApplicationContext(), true, this.dGh.size());
                    C4577f.m11628a((Context) this, ayH(), (CharSequence) getResources().getString(R.string.xiaoying_str_gallery_mv_count_force_tip, new Object[]{String.valueOf(i)}), 0, (long) DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
                    return true;
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void ayD() {
        if (this.cSj != 10) {
            if (this.dGb.getItemCount() <= 0) {
                C4577f.m11626a((Context) this, 0, ayH(), this.dGg == 2 ? R.string.xiaoying_str_ve_msg_add_photos_tip : R.string.xiaoying_str_ve_msg_add_videos_or_photo_tip);
            } else {
                Iterator it = this.dGh.iterator();
                while (it.hasNext()) {
                    TrimedClipItemDataModel trimedClipItemDataModel = (TrimedClipItemDataModel) it.next();
                    if (trimedClipItemDataModel.isImage.booleanValue()) {
                        trimedClipItemDataModel.mExportPath = m21881jG(trimedClipItemDataModel.mExportPath);
                    }
                }
                m21885jz("Next");
                ArrayList arrayList = new ArrayList(this.dGh);
                Intent intent = new Intent();
                intent.putParcelableArrayListExtra(MediaGalleryRouter.INTENT_BACK_RANGE_LIST_KEY, arrayList);
                setResult(-1, intent);
                finish();
            }
        } else if (this.dGb.getItemCount() < this.dGu) {
            ToastUtils.shortShow(getApplicationContext(), R.string.xiaoying_str_gallery_pick_min_limit_tip);
        } else {
            m21885jz("Next");
            SlideshowRouter.launchSlideAfterFilePrepared(this, getIntent().getParcelableExtra(CommonParams.INTENT_KEY_TODOPARAM_MODEL), this.dGh);
            finish();
        }
    }

    /* access modifiers changed from: private */
    public void ayE() {
        int ii = m21873ii(false);
        int ii2 = m21873ii(true);
        int amR = amR();
        int i = amR / 1000;
        C7389a.m21781a(getApplicationContext(), this.dGh.size(), ii, ii2, i, false);
        if (this.bMn) {
            C7389a.m21783b(getApplicationContext(), this.dGh.size(), ii, ii2, i, false);
        } else {
            C7389a.m21785c(getApplicationContext(), this.dGh.size(), ii, ii2, i, false);
        }
        if (this.bMn && !ayF()) {
            int ii3 = m21873ii(false);
            HashMap hashMap = new HashMap();
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(ii3);
            hashMap.put("video_clip_count", sb.toString());
            UserBehaviorLog.onKVEvent(getApplicationContext(), "Gallery_Video_Next", hashMap);
        }
    }

    private boolean ayF() {
        return (this.bMM == null || this.bMM.aHe() == null || !this.bMM.aHe().isMVPrj()) ? false : true;
    }

    private boolean ayG() {
        boolean z = false;
        if (this.cyQ == null) {
            return false;
        }
        int activityFlag = this.cyQ.getActivityFlag();
        if (!(activityFlag <= 0 || activityFlag == 2 || activityFlag == 4)) {
            z = true;
        }
        return z;
    }

    private void ayI() {
        m21872ih(true);
        m21851a(true, (MediaGroupItem) null);
        this.dGe.ayi();
        this.mViewPager.setCanScroll(true);
        this.cWj.setVisibility(this.dGr ? 0 : 8);
    }

    private void ayJ() {
        if (!isFinishing()) {
            C8978m.m26349hs(this).mo10296do(R.string.xiaoying_str_com_msg_save_draft_ask).mo10303dv(R.string.xiaoying_str_com_save_title).mo10299dr(R.string.xiaoying_str_com_discard_title).mo10291b(new C1904j() {
                public void onClick(C1890f fVar, C1885b bVar) {
                    C4586g.m11704a((Context) XYGalleryActivity.this, R.string.xiaoying_str_com_loading, (OnCancelListener) null, false);
                    XYGalleryActivity.this.dGp.mo32093a((List<TrimedClipItemDataModel>) XYGalleryActivity.this.dGh, (C7432a) new C7432a() {
                        /* renamed from: fW */
                        public void mo32047fW(boolean z) {
                            C4586g.m11696Sm();
                            UserBehaviorUtils.recordPrjSave(XYGalleryActivity.this, "gallery");
                            XYGalleryActivity.this.m21885jz("Save");
                            StudioRouter.launchStudioActivity(XYGalleryActivity.this);
                            XYGalleryActivity.this.finish();
                            C4577f.m11626a(XYGalleryActivity.this.getApplicationContext(), 0, XYGalleryActivity.this.ayH(), R.string.xiaoying_str_com_saved_into_draft_box_tip);
                            XYGalleryActivity.this.overridePendingTransition(R.anim.xiaoying_activity_enter, R.anim.xiaoying_activity_exit);
                        }
                    });
                }
            }).mo10281a((C1904j) new C1904j() {
                public void onClick(C1890f fVar, C1885b bVar) {
                    if (XYGalleryActivity.this.bMn) {
                        XYGalleryActivity.this.dGp.ahV();
                    } else {
                        StudioRouter.launchStudioActivity(XYGalleryActivity.this);
                    }
                    XYGalleryActivity.this.m21885jz("Discard");
                    XYGalleryActivity.this.finish();
                    XYGalleryActivity.this.overridePendingTransition(R.anim.xiaoying_activity_enter, R.anim.xiaoying_activity_exit);
                }
            }).mo10313qu().show();
        }
    }

    private void ayK() {
        if (this.bMM != null) {
            if (this.cyQ == null || this.cyQ.mTODOCode <= 0) {
                EditorRouter.launchEditorActivity((Activity) this, PassThoughUrlGenerator.getPassThroughUrlFromIntent(getIntent()));
            } else if (this.cyQ.getActivityFlag() > 0) {
                Long k = C8555k.m25011k(this.cyQ.getJsonObj());
                if (k.longValue() > 0) {
                    String bB = C8762d.aMt().mo35225bB(k.longValue());
                    if (!TextUtils.isEmpty(bB)) {
                        if (this.dGp != null) {
                            this.dGp.applyTheme(getApplicationContext(), this.bMM.aHe().strPrjURL, bB);
                        }
                        return;
                    }
                }
                if (this.cyQ.isEnterPreview()) {
                    EditorRouter.launchEditorActivity((Activity) this, PassThoughUrlGenerator.getPassThroughUrlFromIntent(getIntent()));
                } else if (!(this.bMM == null || this.bMM.aHe() == null)) {
                    FuncExportRouter.launchFuncExportActivity(this, this.cyQ);
                }
            } else {
                EditorRouter.launchEditorActivity((Activity) this, PassThoughUrlGenerator.getPassThroughUrlFromIntent(getIntent()));
            }
        }
        try {
            LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent("com.introvd.template.finishactivity"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        C4586g.m11696Sm();
        finish();
    }

    /* access modifiers changed from: private */
    public void ayL() {
        C4577f.m11626a((Context) this, 0, ayH(), R.string.xiaoying_str_com_msg_network_inactive);
    }

    private int ayM() {
        if (this.dGh.size() >= 29) {
            return m21873ii(true);
        }
        return 0;
    }

    private void ayN() {
        TrimedClipItemDataModel trimedClipItemDataModel = (TrimedClipItemDataModel) this.dGh.get(0);
        Intent intent = new Intent();
        intent.putExtra(GalleryRouter.INTENT_DATA_BACK_KEY, trimedClipItemDataModel);
        setResult(-1, intent);
    }

    private void ayz() {
        this.dAr = (TabLayout) findViewById(R.id.gallery_tablayout);
        this.mViewPager = (XYViewPager) findViewById(R.id.gallery_viewpager);
        AbstractGalleryFragment d = GallerySystemFragment.m22098d(this.dGg, this.csC, this.cSj);
        AbstractGalleryFragment d2 = GalleryOthersFragment.m22094d(this.dGg, this.csC, this.cSj);
        this.mFragments.add(d);
        this.mFragments.add(d2);
        List asList = Arrays.asList(this.dGf);
        if (AppStateModel.getInstance().isInChina()) {
            asList = asList.subList(0, 2);
        } else {
            AbstractGalleryFragment d3 = GalleryFacebookFragment.m22086d(this.dGg, this.csC, this.cSj);
            AbstractGalleryFragment d4 = GalleryInstagramFragment.m22090d(this.dGg, this.csC, this.cSj);
            this.mFragments.add(d3);
            this.mFragments.add(d4);
        }
        for (AbstractGalleryFragment abstractGalleryFragment : this.mFragments) {
            abstractGalleryFragment.setCallbackHandler(this.mHandler);
            abstractGalleryFragment.mo32022cR(ayH());
        }
        this.dGd = new GalleryPagerAdapter(this, asList, getSupportFragmentManager(), this.mFragments);
        this.mViewPager.setAdapter(this.dGd);
        this.dGe = (AbstractGalleryFragment) this.mFragments.get(0);
        this.dGm = C7444c.GALLERY_TAB_SYSTEM;
        this.mViewPager.addOnPageChangeListener(new OnPageChangeListener() {
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f, int i2) {
            }

            public void onPageSelected(int i) {
                XYGalleryActivity.this.dGe = (AbstractGalleryFragment) XYGalleryActivity.this.mFragments.get(i);
                XYGalleryActivity.this.dGm = C7444c.m21989re(i);
                HashMap hashMap = new HashMap();
                switch (C74042.dGC[XYGalleryActivity.this.dGm.ordinal()]) {
                    case 1:
                        hashMap.put("which", SettingLocalLocaleParams.LOCALE_DEFAULT_VALUE);
                        break;
                    case 2:
                        hashMap.put("which", "other gallery");
                        break;
                    case 3:
                        hashMap.put("which", "facebook");
                        break;
                    case 4:
                        hashMap.put("which", "instagram");
                        break;
                }
                UserBehaviorLog.onKVEvent(XYGalleryActivity.this, "Gallery_Tab_Switch", hashMap);
            }
        });
        this.dAr.setupWithViewPager(this.mViewPager);
        this.mViewPager.validateDatasetObserver();
        for (int i = 0; i < this.dAr.getTabCount(); i++) {
            C0427f aI = this.dAr.mo2008aI(i);
            if (aI != null) {
                aI.mo2088E(this.dGd.mo32059ox(i));
                View customView = aI.getCustomView();
                if (customView != null) {
                    LayoutParams layoutParams = customView.getLayoutParams();
                    layoutParams.width = Constants.getScreenSize().width / 3;
                    customView.setLayoutParams(layoutParams);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m21859b(MediaItem mediaItem) {
        if (C8572y.m25084d(mediaItem.path, this.bOK.aJv()) != 0) {
            C4577f.m11626a((Context) this, 0, ayH(), R.string.xiaoying_str_ve_clip_add_msg_invalid_file);
            return;
        }
        m21877jC(mediaItem.path);
        int[] iArr = new int[1];
        C7389a.m21780P(getApplicationContext(), QUtils.IsNeedTranscode(this.bOK.aJv(), C8572y.m25068a(mediaItem.path, false, false, AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_encode", false)), iArr));
    }

    /* renamed from: bX */
    private void m21860bX(List<TrimedClipItemDataModel> list) {
        if (list != null) {
            for (TrimedClipItemDataModel trimedClipItemDataModel : list) {
                if (trimedClipItemDataModel != null) {
                    this.dGh.add(trimedClipItemDataModel);
                    StoryBoardItemInfo storyBoardItemInfo = new StoryBoardItemInfo();
                    storyBoardItemInfo.bmpThumbnail = C8564s.aJi().mo34802Y(trimedClipItemDataModel.mThumbKey);
                    storyBoardItemInfo.isVideo = true;
                    storyBoardItemInfo.lDuration = (long) trimedClipItemDataModel.mVeRangeInRawVideo.getmTimeLength();
                    m21848a(storyBoardItemInfo);
                    this.bOK.mo34669jt(true);
                    if (1 == this.dGb.getItemCount() % 4) {
                        this.dGb.scrollToPosition(this.dGb.getItemCount());
                    }
                    if (trimedClipItemDataModel.mStreamSizeVe != null) {
                        C7389a.m21784b(getApplicationContext(), new MSize(trimedClipItemDataModel.mStreamSizeVe.width, trimedClipItemDataModel.mStreamSizeVe.height));
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m21868f(Activity activity, int i) {
        ToastUtils.shortShow((Context) activity, activity.getString(R.string.xiaoying_str_ve_pip_choose_tip, new Object[]{Integer.valueOf(i)}));
    }

    /* access modifiers changed from: private */
    public int getDuration() {
        int i = 0;
        if (this.dGh.size() > 0) {
            Iterator it = this.dGh.iterator();
            while (it.hasNext()) {
                TrimedClipItemDataModel trimedClipItemDataModel = (TrimedClipItemDataModel) it.next();
                if (trimedClipItemDataModel.isImage.booleanValue()) {
                    i += 3000;
                } else {
                    VeRange veRange = trimedClipItemDataModel.mVeRangeInRawVideo;
                    if (veRange != null && veRange.getmTimeLength() > 0) {
                        i += veRange.getmTimeLength();
                    }
                }
            }
        }
        return i;
    }

    /* access modifiers changed from: private */
    /* renamed from: ih */
    public void m21872ih(boolean z) {
        AppBarLayout.LayoutParams layoutParams = (AppBarLayout.LayoutParams) this.dAr.getLayoutParams();
        int i = 0;
        layoutParams.mo1594Y(z ? 5 : 0);
        this.dAr.setLayoutParams(layoutParams);
        TabLayout tabLayout = this.dAr;
        if (!z) {
            i = 8;
        }
        tabLayout.setVisibility(i);
    }

    /* access modifiers changed from: private */
    /* renamed from: ii */
    public int m21873ii(boolean z) {
        int i = 0;
        if (this.dGh.size() > 0) {
            Iterator it = this.dGh.iterator();
            while (it.hasNext()) {
                TrimedClipItemDataModel trimedClipItemDataModel = (TrimedClipItemDataModel) it.next();
                if (trimedClipItemDataModel != null) {
                    if (z) {
                        if (trimedClipItemDataModel.isImage.booleanValue()) {
                            i++;
                        }
                    } else if (!trimedClipItemDataModel.isImage.booleanValue()) {
                        i++;
                    }
                }
            }
        }
        return i;
    }

    /* access modifiers changed from: private */
    /* renamed from: jA */
    public void m21875jA(String str) {
        Intent intent = new Intent();
        if (this.dGt) {
            intent.putExtra(MediaGalleryRouter.INTENT_IN_VEPICKMODE, "com.introvd.template.intent.action.FILEPICKER");
            intent.putExtra(MediaGalleryRouter.INTENT_PIP_PICK_FILE, 1);
        } else {
            intent.putExtra(MediaGalleryRouter.INTENT_IN_VEPICKMODE, "com.introvd.template.intent.action.EDITORFILEPICKER");
        }
        if (this.dGq) {
            intent.putExtra(TodoConstants.KEY_TODOCODE_PARAM_MODEL, this.cyQ);
            intent.putExtra(MediaGalleryRouter.INTENT_PICK_VIDEO_FOR_GIFMAKER, true);
            intent.putExtra(GalleryRouter.EXTRA_INTENT_MODE_KEY, 2004);
        }
        intent.putExtra(GalleryRouter.INTENT_PATH_KEY, str);
        int i = 0;
        if (this.dGt) {
            i = getIntent().getIntExtra(MediaGalleryRouter.INTENT_VIDEO_DURATION_LIMIT, 0);
        } else if (this.dGq) {
            i = 5000;
        }
        intent.putExtra(MediaGalleryRouter.INTENT_VIDEO_DURATION_LIMIT, i);
        intent.putExtra(CommonParams.INTENT_MAGIC_CODE, this.dGo);
        intent.putExtra(MediaGalleryRouter.INTENT_KEY_VIDEO_COUNT_LIMIT, this.dGv);
        intent.setPackage(getPackageName());
        int i2 = -1;
        if (this.dGt) {
            i2 = AdError.MEDIAVIEW_MISSING_ERROR_CODE;
        }
        EditorRouter.launchVideoTrimActivity(this, intent.getExtras(), i2);
    }

    /* access modifiers changed from: private */
    /* renamed from: jB */
    public void m21876jB(String str) {
        if (MediaFileUtils.IsImageFileType(MediaFileUtils.GetFileMediaType(str))) {
            m21831A(str, 0);
        } else if (C8572y.m25084d(str, this.bOK.aJv()) != 0) {
            C4577f.m11626a((Context) this, 0, ayH(), R.string.xiaoying_str_ve_clip_add_msg_invalid_file);
        } else if (!m21878jD(str)) {
            m21877jC(str);
        }
    }

    /* renamed from: jC */
    private void m21877jC(String str) {
        Intent intent = new Intent();
        intent.putExtra(MediaGalleryRouter.INTENT_IN_VEPICKMODE, "com.introvd.template.intent.action.EDITORFILEPICKER");
        intent.putExtra(GalleryRouter.INTENT_PATH_KEY, str);
        intent.putExtra(GalleryRouter.INTENT_POSITION_KEY, -1);
        intent.putExtra(GalleryRouter.EXTRA_INTENT_MODE_KEY, 0);
        if (this.cyQ != null && this.cyQ.getActivityFlag() > 0) {
            intent.putExtra(MediaGalleryRouter.INTENT_VIDEO_DURATION_LIMIT, this.cyQ.getLimitDuration());
            intent.putExtra(TodoConstants.KEY_TODOCODE_PARAM_MODEL, this.cyQ);
        }
        if (this.dGs) {
            if (MediaFileUtils.getAudioMediaDuration(str) <= ((long) this.dGw)) {
                float f = ((float) this.dGw) / 1000.0f;
                ToastUtils.show(getApplicationContext(), getResources().getString(R.string.xiaoying_str_ve_pip_trim_duration_tip2, new Object[]{String.format(Locale.US, "%1$02.1f", new Object[]{Float.valueOf(f % 60.0f)})}), 0);
                return;
            }
            intent.putExtra(MediaGalleryRouter.INTENT_VIDEO_DURATION_LIMIT, this.dGw);
            intent.putExtra(MediaGalleryRouter.INTENT_KEY_IS_SLIDESHOW_PICK, true);
        }
        intent.putExtra(CommonParams.INTENT_MAGIC_CODE, this.dGo);
        intent.putExtra("new_prj", this.bMn ? 1 : 0);
        intent.putExtra(MediaGalleryRouter.INTENT_KEY_VIDEO_COUNT_LIMIT, this.dGv);
        intent.setPackage(getPackageName());
        if (m21852a(str, this.bOK.aJv())) {
            EditorRouter.launchVideoTrimActivity(this, intent.getExtras(), 8193);
        } else {
            C7389a.m21790jy(str);
            C4577f.m11626a((Context) this, 0, ayH(), R.string.xiaoying_str_ve_clip_add_msg_invalid_file);
        }
    }

    /* renamed from: jD */
    private boolean m21878jD(String str) {
        if (C7431b.aym().ayn() && (this.cSj == 0 || this.cSj == 2 || this.cSj == 3) && !this.dGq) {
            TrimedClipItemDataModel c = C8547b.m24992c(this.bOK.aJv(), str, this.dGt, AppPreferencesSetting.getInstance().getAppSettingBoolean("pref_encode", false));
            if (c != null && !c.bNeedTranscode) {
                m21894o(c);
                return true;
            }
        }
        return false;
    }

    /* renamed from: jE */
    private Bitmap m21879jE(String str) {
        Bitmap bitmap;
        if (this.dgb == null) {
            return null;
        }
        Bitmap syncLoadImage = this.dgb.syncLoadImage(str, null);
        if (syncLoadImage == null) {
            return null;
        }
        try {
            bitmap = syncLoadImage.copy(syncLoadImage.getConfig(), false);
        } catch (Throwable th) {
            th.printStackTrace();
            bitmap = null;
        }
        return bitmap;
    }

    /* access modifiers changed from: private */
    /* renamed from: jF */
    public synchronized boolean m21880jF(String str) {
        return this.dqL != null && this.dqL.containsKey(str);
    }

    /* renamed from: jG */
    private String m21881jG(String str) {
        return this.dqL.containsKey(str) ? (String) this.dqL.get(str) : str;
    }

    /* renamed from: jH */
    private static String m21882jH(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("flag_prj_imgcount_overlimit_tip_show_");
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: jI */
    private static boolean m21883jI(String str) {
        return AppPreferencesSetting.getInstance().getAppSettingBoolean(m21882jH(str), false);
    }

    /* renamed from: jJ */
    private static void m21884jJ(String str) {
        AppPreferencesSetting.getInstance().setAppSettingBoolean(m21882jH(str), true);
    }

    /* access modifiers changed from: private */
    /* renamed from: jz */
    public void m21885jz(String str) {
        String str2 = this.dGg == 2 ? "mv" : "video";
        String str3 = "create_project";
        if (this.dGs) {
            str3 = "add_for_slide";
        } else if (this.dGt) {
            str3 = "Pip";
        } else if (this.dGr) {
            str3 = "add_more_clips";
        }
        C7389a.m21791k(getApplicationContext(), str, str3, str2);
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public void m21888l(List<ImgPreviewDataItem> list, int i) {
        C7431b.aym().mo32083bW(list);
        Intent intent = new Intent(this, GalleryPreviewActivity.class);
        intent.putExtra(MediaGalleryRouter.INTENT_BUNDLE_FOCUS_INDEX, i);
        if (this.cSj == 6) {
            intent.putExtra(MediaGalleryRouter.INTENT_BUNDLE_IMAGE_PICKER, true);
        } else if (this.cSj == 5 || this.cSj == 10) {
            intent.putExtra(MediaGalleryRouter.INTENT_KEY_IS_SLIDESHOW_PICK, true);
        }
        try {
            if (this.bua != null) {
                ActivityCompat.startActivityForResult(this, intent, 4097, ActivityOptionsCompat.makeScaleUpAnimation(this.bua, this.bua.getWidth() / 2, this.bua.getHeight(), 0, 0).toBundle());
            } else {
                startActivityForResult(intent, 4097);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: m */
    private void m21890m(TrimedClipItemDataModel trimedClipItemDataModel) {
        if (trimedClipItemDataModel != null) {
            StoryBoardItemInfo storyBoardItemInfo = new StoryBoardItemInfo();
            Bitmap Y = !trimedClipItemDataModel.isImage.booleanValue() ? C8564s.aJi().mo34802Y(trimedClipItemDataModel.mThumbKey) : null;
            if (Y == null) {
                String str = trimedClipItemDataModel.mRawFilePath;
                if (!TextUtils.isEmpty(trimedClipItemDataModel.mExportPath)) {
                    str = trimedClipItemDataModel.mExportPath;
                }
                Y = this.dgb.syncLoadImage(str, null);
            }
            if (Y != null) {
                storyBoardItemInfo.bmpThumbnail = Y;
            }
            boolean jM = C7474b.m22085jM(trimedClipItemDataModel.mRawFilePath);
            int i = 0;
            storyBoardItemInfo.isVideo = !trimedClipItemDataModel.isImage.booleanValue() && !jM;
            storyBoardItemInfo.isGif = jM;
            if (trimedClipItemDataModel.mVeRangeInRawVideo != null) {
                i = trimedClipItemDataModel.mVeRangeInRawVideo.getmTimeLength();
            }
            if (trimedClipItemDataModel.mTrimVeRange != null && trimedClipItemDataModel.mTrimVeRange.getmTimeLength() > 0) {
                i = trimedClipItemDataModel.mTrimVeRange.getmTimeLength();
            }
            storyBoardItemInfo.lDuration = (long) i;
            m21848a(storyBoardItemInfo);
            if (this.dGg == 2) {
                m21853as(trimedClipItemDataModel.mExportPath, trimedClipItemDataModel.mExportPath);
            }
        }
    }

    /* renamed from: n */
    private void m21892n(TrimedClipItemDataModel trimedClipItemDataModel) {
        C7414b bVar = new C7414b();
        try {
            bVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, trimedClipItemDataModel);
            m21839a(bVar);
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable th) {
            m21899rm(1);
            throw th;
        }
        m21899rm(1);
    }

    /* renamed from: o */
    private void m21894o(TrimedClipItemDataModel trimedClipItemDataModel) {
        if (trimedClipItemDataModel != null) {
            Bitmap jE = m21879jE(trimedClipItemDataModel.mRawFilePath);
            this.dGh.add(trimedClipItemDataModel);
            StoryBoardItemInfo storyBoardItemInfo = new StoryBoardItemInfo();
            storyBoardItemInfo.bmpThumbnail = jE;
            storyBoardItemInfo.isVideo = true;
            storyBoardItemInfo.lDuration = (long) trimedClipItemDataModel.mVeRangeInRawVideo.getmTimeLength();
            m21848a(storyBoardItemInfo);
            this.bOK.mo34669jt(true);
            if (1 == this.dGb.getItemCount() % 4) {
                this.dGb.scrollToPosition(this.dGb.getItemCount());
            }
            C7389a.m21784b(getApplicationContext(), new MSize(trimedClipItemDataModel.mStreamSizeVe.width, trimedClipItemDataModel.mStreamSizeVe.height));
        }
    }

    /* renamed from: p */
    private void m21896p(TrimedClipItemDataModel trimedClipItemDataModel) {
        StoryBoardItemInfo storyBoardItemInfo = new StoryBoardItemInfo();
        Bitmap bitmap = trimedClipItemDataModel.mThumbnail;
        if (bitmap == null) {
            bitmap = this.dgb.syncLoadImage(trimedClipItemDataModel.mRawFilePath, null);
        }
        storyBoardItemInfo.bmpThumbnail = bitmap;
        storyBoardItemInfo.isVideo = true;
        VeRange veRange = trimedClipItemDataModel.mVeRangeInRawVideo;
        if (veRange != null) {
            storyBoardItemInfo.lDuration = (long) veRange.getmTimeLength();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: rm */
    public synchronized void m21899rm(int i) {
        this.dGk += i;
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("updateRunningTaskNums mInsertFileTaskRunningNums: ");
        sb.append(this.dGk);
        LogUtils.m14223i(str, sb.toString());
    }

    /* access modifiers changed from: private */
    public void save() {
        if (this.dGb.getItemCount() <= 0) {
            C4577f.m11626a((Context) this, 0, ayH(), this.dGg == 2 ? R.string.xiaoying_str_ve_msg_add_photos_tip : R.string.xiaoying_str_ve_msg_add_videos_or_photo_tip);
            return;
        }
        if (this.mHandler != null) {
            this.dGi = true;
            C4586g.m11704a((Context) this, R.string.xiaoying_str_com_loading, (OnCancelListener) null, false);
            this.mHandler.sendEmptyMessage(4104);
        }
        m21885jz("Next");
    }

    /* renamed from: u */
    private void m21902u(Intent intent) {
        TrimedClipItemDataModel trimedClipItemDataModel = (TrimedClipItemDataModel) intent.getExtras().get(GalleryRouter.INTENT_DATA_BACK_KEY);
        if (trimedClipItemDataModel != null) {
            Bitmap Y = C8564s.aJi().mo34802Y(trimedClipItemDataModel.mThumbKey);
            if (Y == null) {
                Y = this.dgb.getBitmapFromCache(trimedClipItemDataModel.mExportPath);
            }
            trimedClipItemDataModel.mThumbnail = Y;
            this.dGh.add(trimedClipItemDataModel);
            if (this.dGt) {
                ayN();
                finish();
            } else {
                m21896p(trimedClipItemDataModel);
            }
        }
    }

    /* renamed from: v */
    private void m21904v(Intent intent) {
        Bundle extras = intent.getExtras();
        boolean z = extras.getBoolean("needInsert");
        StringBuilder sb = new StringBuilder();
        sb.append("isInsert:");
        sb.append(z);
        LogUtilsV2.m14230i(sb.toString());
        if (z) {
            m21860bX(extras.getParcelableArrayList(MediaGalleryRouter.INTENT_TRIM_RANGE_LIST_KEY));
            extras.clear();
            if (ayG()) {
                save();
            } else if (this.mHandler != null) {
                this.mHandler.sendEmptyMessageDelayed(5381, 100);
            }
        } else {
            C4577f.m11627a((Context) this, ayH(), R.string.xiaoying_str_ve_msg_external_file_import_suc, 1500);
        }
    }

    public void abA() {
        finish();
    }

    public int amA() {
        return this.cSk;
    }

    public int amL() {
        return this.cSj;
    }

    public View ayH() {
        return this.bua;
    }

    public String ayy() {
        return this.bMy;
    }

    /* renamed from: fW */
    public void mo32036fW(boolean z) {
        if (!isFinishing()) {
            C4586g.m11696Sm();
        }
        if (this.dGi) {
            ayK();
            return;
        }
        StudioRouter.launchStudioActivity(this);
        finish();
        C4577f.m11626a((Context) this, 0, ayH(), R.string.xiaoying_str_com_saved_into_draft_box_tip);
        overridePendingTransition(R.anim.xiaoying_activity_enter, R.anim.xiaoying_activity_exit);
    }

    public Activity getHostActivity() {
        return this;
    }

    public int getLimitRangeCount() {
        return this.dGv;
    }

    public int getMinRangeCount() {
        return this.dGu;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 != -1) {
            if (i == 8193 && intent != null) {
                C4577f.m11626a((Context) this, 0, ayH(), R.string.xiaoying_str_ve_clip_add_msg_invalid_file);
            }
        } else if (4097 == i) {
            if (intent != null) {
                if (this.dGh.size() >= this.dGv) {
                    m21868f(this, this.dGv);
                    return;
                }
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    ArrayList parcelableArrayList = extras.getParcelableArrayList(MediaGalleryRouter.INTENT_IMAGE_LIST_KEY);
                    C4586g.m11704a((Context) this, R.string.xiaoying_str_com_wait_tip, (OnCancelListener) null, false);
                    Message obtainMessage = this.mHandler.obtainMessage(4625);
                    obtainMessage.obj = parcelableArrayList;
                    this.mHandler.sendMessageDelayed(obtainMessage, 500);
                    extras.clear();
                }
            }
        } else if (i == 8193) {
            m21904v(intent);
        } else if (i == 6001) {
            m21902u(intent);
        } else if (i == 36866) {
            C7389a.m21789gb(getApplicationContext());
            DataItemProject aHe = C8522g.aJA().aHe();
            if (aHe != null) {
                C8446b.aIZ().mo34325j(getApplicationContext(), aHe._id);
            }
            Bundle extras2 = intent.getExtras();
            if (extras2 != null) {
                m21860bX(extras2.getParcelableArrayList(MediaGalleryRouter.INTENT_BACK_RANG_LIST_FROM_CAMERA));
            }
        } else if (this.bIM != -1) {
            SnsAuthServiceProxy.authorizeCallBack(this, this.bIM, i, i2, intent);
        }
    }

    public void onClick(View view) {
        if (!C4580b.m11632Sf()) {
            if (view.equals(this.cQz)) {
                if ((this.dGe.ayj() || this.dGm == C7444c.GALLERY_TAB_SYSTEM || (this.dGm == C7444c.GALLERY_TAB_FACEBOOK && this.dGc.aze() == 0) || this.dGm == C7444c.GALLERY_TAB_INSTAGRAM) ? false : true) {
                    ayI();
                } else {
                    m21885jz("back_icon");
                    anI();
                }
            } else if (view.equals(this.cWj)) {
                final HashMap hashMap = new HashMap();
                hashMap.put(CameraRouter.KEY_CAMERA_INTENT, Integer.valueOf(4098));
                C8086a.m23466a((Activity) this, (C8099d) new C8099d() {
                    /* renamed from: PP */
                    public void mo24403PP() {
                        C7389a.m21788ga(XYGalleryActivity.this.getApplicationContext());
                        CameraRouter.launchCameraForResult((Activity) XYGalleryActivity.this, true, hashMap, 36866);
                    }

                    /* renamed from: PQ */
                    public void mo24404PQ() {
                    }
                });
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Can't wrap try/catch for region: R(32:0|(4:2|(1:4)|5|(1:7))(1:8)|9|(1:14)(1:13)|15|(1:17)(1:18)|19|(1:21)(1:22)|23|(1:28)(1:27)|29|(1:31)|32|(1:34)(2:35|(1:37)(1:38))|39|(1:43)|44|(1:46)|47|48|49|50|51|(3:53|(1:55)|56)|57|(1:59)(1:60)|61|(1:63)|64|(1:66)(1:67)|68|69) */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01e7, code lost:
        finish();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x01ea, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x0164 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r8) {
        /*
            r7 = this;
            super.onCreate(r8)
            com.introvd.template.starvlogs.logfirebase.ActionFirebaseStarVlogs.actionGalleryActivity(r7)
            r7.mo22815FX()
            android.content.Context r8 = r7.getApplicationContext()
            com.introvd.template.sdk.C8410e.m24270gK(r8)
            com.introvd.template.router.VivaRouter.inject(r7)
            com.introvd.template.sdk.utils.b.a r8 = com.introvd.template.sdk.utils.p394b.C8501a.aJs()
            r7.bOK = r8
            com.introvd.template.sdk.utils.b.g r8 = com.introvd.template.sdk.utils.p394b.C8522g.aJA()
            r7.bMM = r8
            android.content.Intent r8 = r7.getIntent()
            java.lang.Class<com.introvd.template.router.editor.gallery.GalleryIntentInfo> r0 = com.introvd.template.router.editor.gallery.GalleryIntentInfo.class
            java.lang.Object r8 = com.introvd.template.router.PassThoughUrlGenerator.getInfoFromIntent(r8, r0)
            com.introvd.template.router.editor.gallery.GalleryIntentInfo r8 = (com.introvd.template.router.editor.gallery.GalleryIntentInfo) r8
            r7.cSA = r8
            android.content.Intent r8 = r7.getIntent()
            java.lang.Class<com.introvd.template.router.todoCode.TODOParamModel> r0 = com.introvd.template.router.todoCode.TODOParamModel.class
            java.lang.Object r8 = com.introvd.template.router.PassThoughUrlGenerator.getInfoFromIntent(r8, r0)
            com.introvd.template.router.todoCode.TODOParamModel r8 = (com.introvd.template.router.todoCode.TODOParamModel) r8
            r7.cyQ = r8
            com.introvd.template.router.editor.gallery.GalleryIntentInfo r8 = r7.cSA
            r0 = 0
            if (r8 == 0) goto L_0x0099
            com.introvd.template.router.editor.gallery.GalleryIntentInfo r8 = r7.cSA
            int r8 = r8.getImageDuration()
            r7.cSk = r8
            com.introvd.template.router.editor.gallery.GalleryIntentInfo r8 = r7.cSA
            boolean r8 = r8.isNewPrj()
            r7.bMn = r8
            com.introvd.template.router.editor.gallery.GalleryIntentInfo r8 = r7.cSA
            int r8 = r8.getSourceMode()
            r7.dGg = r8
            com.introvd.template.router.editor.gallery.GalleryIntentInfo r8 = r7.cSA
            int r8 = r8.getExtraIntentMode()
            r7.cSp = r8
            com.introvd.template.router.editor.gallery.GalleryIntentInfo r8 = r7.cSA
            java.lang.String r8 = r8.getActivityId()
            r7.bMy = r8
            com.introvd.template.router.editor.gallery.GalleryIntentInfo r8 = r7.cSA
            int r8 = r8.getAction()
            r7.cSj = r8
            com.introvd.template.router.editor.gallery.GalleryIntentInfo r8 = r7.cSA
            long r1 = r8.getMagicCode()
            r7.dGo = r1
            com.introvd.template.router.editor.gallery.GalleryIntentInfo r8 = r7.cSA
            int r8 = r8.getLimitRangeCount()
            if (r8 <= 0) goto L_0x0088
            com.introvd.template.router.editor.gallery.GalleryIntentInfo r8 = r7.cSA
            int r8 = r8.getLimitRangeCount()
            r7.dGv = r8
        L_0x0088:
            com.introvd.template.router.editor.gallery.GalleryIntentInfo r8 = r7.cSA
            int r8 = r8.getMinRangeCount()
            if (r8 <= 0) goto L_0x00a8
            com.introvd.template.router.editor.gallery.GalleryIntentInfo r8 = r7.cSA
            int r8 = r8.getMinRangeCount()
            r7.dGu = r8
            goto L_0x00a8
        L_0x0099:
            com.introvd.template.router.editor.gallery.GalleryIntentInfo$Builder r8 = new com.introvd.template.router.editor.gallery.GalleryIntentInfo$Builder
            r8.<init>()
            com.introvd.template.router.editor.gallery.GalleryIntentInfo$Builder r8 = r8.setSourceMode(r0)
            com.introvd.template.router.editor.gallery.GalleryIntentInfo r8 = r8.build()
            r7.cSA = r8
        L_0x00a8:
            com.introvd.template.gallery.b r8 = com.introvd.template.gallery.C7431b.aym()
            int r1 = r7.cSj
            r8.mo32086nB(r1)
            com.introvd.template.gallery.b r8 = com.introvd.template.gallery.C7431b.aym()
            int r1 = r7.cSp
            r8.setExtraIntentMode(r1)
            int r8 = r7.cSj
            r1 = 1
            if (r8 == r1) goto L_0x00c7
            int r8 = r7.cSj
            r2 = 4
            if (r8 != r2) goto L_0x00c5
            goto L_0x00c7
        L_0x00c5:
            r8 = 0
            goto L_0x00c8
        L_0x00c7:
            r8 = 1
        L_0x00c8:
            r7.dGt = r8
            int r8 = r7.cSp
            r2 = 2004(0x7d4, float:2.808E-42)
            if (r8 != r2) goto L_0x00d2
            r8 = 1
            goto L_0x00d3
        L_0x00d2:
            r8 = 0
        L_0x00d3:
            r7.dGq = r8
            int r8 = r7.cSj
            r2 = 2
            if (r8 != r2) goto L_0x00dc
            r8 = 1
            goto L_0x00dd
        L_0x00dc:
            r8 = 0
        L_0x00dd:
            r7.dGr = r8
            int r8 = r7.cSj
            r3 = 5
            if (r8 == r3) goto L_0x00ed
            int r8 = r7.cSj
            r3 = 10
            if (r8 != r3) goto L_0x00eb
            goto L_0x00ed
        L_0x00eb:
            r8 = 0
            goto L_0x00ee
        L_0x00ed:
            r8 = 1
        L_0x00ee:
            r7.dGs = r8
            com.introvd.template.gallery.b.c r8 = new com.introvd.template.gallery.b.c
            r8.<init>()
            r7.dGp = r8
            com.introvd.template.gallery.b.c r8 = r7.dGp
            r8.attachView(r7)
            com.introvd.template.gallery.b.c r8 = r7.dGp
            android.content.Context r3 = r7.getApplicationContext()
            int r4 = r7.dGg
            boolean r5 = r7.bMn
            com.introvd.template.router.todoCode.TODOParamModel r6 = r7.cyQ
            r8.mo32091a(r3, r4, r5, r6)
            boolean r8 = com.introvd.template.common.ApiHelper.HONEYCOMB_HIGHER
            if (r8 == 0) goto L_0x0118
            android.view.Window r8 = r7.getWindow()
            r3 = 16777216(0x1000000, float:2.3509887E-38)
            r8.setFlags(r3, r3)
        L_0x0118:
            int r8 = r7.dGg
            if (r8 != r2) goto L_0x011f
            r7.dGn = r1
            goto L_0x012c
        L_0x011f:
            com.introvd.template.router.editor.gallery.GalleryIntentInfo r8 = r7.cSA
            boolean r8 = r8.isFocusPhotoTab()
            if (r8 == 0) goto L_0x012a
            r7.dGn = r1
            goto L_0x012c
        L_0x012a:
            r7.dGn = r0
        L_0x012c:
            com.introvd.template.gallery.b r8 = com.introvd.template.gallery.C7431b.aym()
            int r3 = r7.dGn
            r8.mo32087rc(r3)
            com.introvd.template.gallery.b r8 = com.introvd.template.gallery.C7431b.aym()
            int r3 = r7.dGg
            r8.mo32088rd(r3)
            boolean r8 = com.introvd.template.sdk.utils.C8549f.aJd()
            if (r8 == 0) goto L_0x0151
            com.introvd.template.common.AppPreferencesSetting r8 = com.introvd.template.common.AppPreferencesSetting.getInstance()
            java.lang.String r3 = "pref_encode"
            boolean r8 = r8.getAppSettingBoolean(r3, r0)
            if (r8 == 0) goto L_0x0151
            goto L_0x0152
        L_0x0151:
            r1 = 0
        L_0x0152:
            r7.csC = r1
            boolean r8 = r7.dGq
            if (r8 == 0) goto L_0x015b
            r7.mo22812FU()
        L_0x015b:
            int r8 = com.introvd.template.xygallery.R.layout.gallery_act_new     // Catch:{ Exception -> 0x0164 }
            r7.setContentView(r8)     // Catch:{ Exception -> 0x0164 }
            com.introvd.base.utlisads.BannerAdmob.setupDataBannerAdmob(r7)     // Catch:{ Exception -> 0x0164 }
            goto L_0x016c
        L_0x0164:
            int r8 = com.introvd.template.xygallery.R.layout.gallery_act_new     // Catch:{ Exception -> 0x01e7 }
            r7.setContentView(r8)     // Catch:{ Exception -> 0x01e7 }
            com.introvd.base.utlisads.BannerAdmob.setupDataBannerAdmob(r7)     // Catch:{ Exception -> 0x01e7 }
        L_0x016c:
            com.introvd.template.explorer.p298c.C7149c.m21148hY(r0)
            int r8 = com.introvd.template.xygallery.R.id.gallery_ad
            android.view.View r8 = r7.findViewById(r8)
            android.view.ViewGroup r8 = (android.view.ViewGroup) r8
            com.introvd.template.gallery.b.c r0 = r7.dGp
            r0.mo32096r(r8)
            r7.arc()
            r7.amr()
            r7.ayz()
            boolean r8 = r7.amm()
            if (r8 != 0) goto L_0x01b3
            android.content.Intent r8 = r7.getIntent()
            java.lang.String r0 = "intent_key_video_duration_limit"
            r1 = 5000(0x1388, float:7.006E-42)
            int r8 = r8.getIntExtra(r0, r1)
            r7.dGw = r8
            android.content.Intent r8 = r7.getIntent()
            java.lang.String r0 = "trim_ranges_list_key"
            java.util.ArrayList r8 = r8.getParcelableArrayListExtra(r0)
            r7.dGh = r8
            java.util.ArrayList<com.introvd.template.sdk.editor.cache.TrimedClipItemDataModel> r8 = r7.dGh
            if (r8 != 0) goto L_0x01b0
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            r7.dGh = r8
        L_0x01b0:
            r7.ayB()
        L_0x01b3:
            com.introvd.template.xyui.a r8 = new com.introvd.template.xyui.a
            r8.<init>(r7)
            r7.bML = r8
            int r8 = r7.dGg
            if (r8 != r2) goto L_0x01c1
            java.lang.String r8 = "mv"
            goto L_0x01c3
        L_0x01c1:
            java.lang.String r8 = "video"
        L_0x01c3:
            boolean r0 = r7.dGt
            if (r0 == 0) goto L_0x01c9
            java.lang.String r8 = "PIP"
        L_0x01c9:
            android.content.Context r0 = r7.getApplicationContext()
            boolean r1 = r7.dGr
            if (r1 == 0) goto L_0x01d4
            java.lang.String r1 = "add_more_clips"
            goto L_0x01d6
        L_0x01d4:
            java.lang.String r1 = "create_project"
        L_0x01d6:
            com.introvd.template.gallery.C7389a.m21779E(r0, r1, r8)
            com.introvd.template.i r8 = com.introvd.template.C4681i.m12184Gp()
            com.introvd.template.AppMiscListener r8 = r8.mo25016Gr()
            java.lang.String r0 = "Gallery_Enter"
            r8.recordEvtOnAppflyer(r7, r0)
            return
        L_0x01e7:
            r7.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.gallery.activity.XYGalleryActivity.onCreate(android.os.Bundle):void");
    }

    public void onDestroy() {
        C3574d.m8800ey("Gallery");
        if (this.dgb != null) {
            this.dgb.clearMemoryCache(true);
            ImageWorkerFactory.DestroyImageWorker(this.dgb);
            this.dgb = null;
        }
        this.dGA = null;
        if (this.dGb != null) {
            this.dGb.destroy();
            this.dGb = null;
        }
        C7680l.aAe().releasePosition(21);
        super.onDestroy();
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        if ((this.dGe.ayj() || this.dGm == C7444c.GALLERY_TAB_SYSTEM || (this.dGm == C7444c.GALLERY_TAB_FACEBOOK && this.dGc.aze() == 0) || this.dGm == C7444c.GALLERY_TAB_INSTAGRAM) ? false : true) {
            ayI();
            return true;
        }
        m21885jz("physical_back");
        anI();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        C7680l.aAf().mo32495iu(false);
        if (isFinishing()) {
            if (this.mHandler != null) {
                this.mHandler.removeCallbacksAndMessages(null);
                this.mHandler = null;
            }
            if (this.bML != null) {
                this.bML.aNX();
                this.bML.unInit();
                this.bML = null;
            }
            if (this.dGp != null) {
                this.dGp.release();
            }
            C7149c.m21148hY(true);
            C7431b.aym().release();
            C7187d axT = C7187d.axT();
            axT.mo31669qY(28);
            axT.mo31669qY(31);
        } else {
            C4586g.m11696Sm();
        }
        super.onPause();
        UserBehaviorLog.onPause(this);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        C7680l.aAf().mo32495iu(true);
        super.onResume();
        UserBehaviorLog.onResume(this);
        if (this.dGe.ayj()) {
            this.dGe.mo32017ai(this.dGc.aze(), false);
        }
        C7591a.m22377kg("相册页");
        C3574d.m8799e("Gallery", this.bfB);
        this.bfB = 0;
    }
}
