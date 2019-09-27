package com.introvd.template.app.manager;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.afollestad.materialdialogs.C1890f;
import com.afollestad.materialdialogs.C1890f.C1895a;
import com.introvd.template.R;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.CommonConfigure;
import com.introvd.template.common.Constants;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.MSize;
import com.introvd.template.common.imageloader.ImageLoader;
import com.introvd.template.datacenter.DownloadService;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.module.p325a.C7572a;
import com.introvd.template.p203b.C4583d;
import com.introvd.template.p203b.C4584e;
import com.introvd.template.router.editor.EditorRouter;
import com.p131c.p132a.p135c.C2575a;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;
import java.net.URI;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/* renamed from: com.introvd.template.app.manager.d */
public class C4059d {
    private static List<C4064b> buC = new ArrayList();
    public static List<C4064b> buD = new ArrayList();

    /* renamed from: com.introvd.template.app.manager.d$a */
    public interface C4063a {
        void onCancel();

        void onClick();

        void onClose();
    }

    /* renamed from: com.introvd.template.app.manager.d$b */
    public static class C4064b {
        public int buF = 0;
        public Date buG = null;
        public int buH = 0;
        public int buI = 0;
        public int buJ = 0;
        public String buK = "";
        public String buL = "";
        public String buM = "";
        public String buN = "";
        public MSize buO = null;
        public int displayCount = 1;
        public int displayState = 0;
        public String mDesc = "";
        public String mIconUrl = "";
        public int mOrderNum = 0;
        public String mTitle = "";
    }

    /* renamed from: Ne */
    private static String m10097Ne() {
        StringBuilder sb = new StringBuilder();
        sb.append(CommonConfigure.APP_DATA_PATH);
        sb.append(".popupwindow/");
        return sb.toString();
    }

    /* renamed from: Nf */
    public static C4064b m10098Nf() {
        return m10110hf(1);
    }

    /* renamed from: P */
    public static String m10099P(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        String replace = m10107dI(str2).replace("/", "_");
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(replace);
        return sb.toString();
    }

    /* renamed from: a */
    public static void m10100a(Context context, C4064b bVar) {
        ContentResolver contentResolver = context.getContentResolver();
        Uri tableUri = SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_POPUP_WINDOW_INFO);
        ContentValues contentValues = new ContentValues();
        StringBuilder sb = new StringBuilder();
        sb.append("windowid= ");
        sb.append(bVar.buF);
        String sb2 = sb.toString();
        contentValues.put(SocialConstDef.POPUPWINDOW_ITEM_POP_DAY_TIME, bVar.buN);
        contentResolver.update(tableUri, contentValues, sb2, null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static void m10101a(C4064b bVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(System.currentTimeMillis());
        sb.append("");
        bVar.buN = sb.toString();
    }

    /* renamed from: b */
    public static void m10102b(Activity activity, final C4064b bVar, final C4063a aVar) {
        String P = m10099P(m10097Ne(), bVar.mIconUrl);
        if (FileUtils.isFileExisted(P)) {
            int P2 = Constants.getScreenSize().width - C4583d.m11671P(60.0f);
            MSize dJ = m10108dJ(P);
            int i = (dJ == null || dJ.width <= 0 || dJ.height <= 0) ? 0 : (dJ.height * P2) / dJ.width;
            C1895a aVar2 = new C1895a(activity);
            View inflate = LayoutInflater.from(activity).inflate(R.layout.v5_xiaoying_popupwindow_dialog_layout, null);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.imgview_close_btn);
            DynamicLoadingImageView dynamicLoadingImageView = (DynamicLoadingImageView) inflate.findViewById(R.id.imgview_popup_img);
            aVar2.mo10275a((OnCancelListener) new OnCancelListener() {
                public void onCancel(DialogInterface dialogInterface) {
                    C4059d.m10103b(bVar);
                    if (aVar != null) {
                        aVar.onCancel();
                    }
                }
            });
            RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.layout_popwin);
            LayoutParams layoutParams = (LayoutParams) relativeLayout.getLayoutParams();
            layoutParams.height = i;
            relativeLayout.setLayoutParams(layoutParams);
            if (P.endsWith(".gif")) {
                ImageLoader.loadImage((Context) activity, P, (ImageView) dynamicLoadingImageView);
            } else {
                ImageLoader.loadImage(P, dynamicLoadingImageView);
            }
            C7572a.m22333a(dynamicLoadingImageView, bVar, bVar.buK);
            aVar2.mo10307g(inflate, false);
            final C1890f qu = aVar2.mo10313qu();
            qu.getWindow().setBackgroundDrawableResource(17170445);
            qu.show();
            imageView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    C4059d.m10103b(bVar);
                    qu.dismiss();
                    if (aVar != null) {
                        aVar.onClose();
                    }
                }
            });
            dynamicLoadingImageView.setOnClickListener(new OnClickListener() {
                public void onClick(View view) {
                    if (bVar.displayState == 1) {
                        C4059d.m10103b(bVar);
                    } else if (bVar.displayState == 0) {
                        C4059d.m10101a(bVar);
                        C4059d.m10100a(view.getContext(), bVar);
                    }
                    if (aVar != null) {
                        aVar.onClick();
                    }
                    qu.dismiss();
                }
            });
        }
    }

    /* renamed from: b */
    public static void m10103b(C4064b bVar) {
        if (bVar != null) {
            String appSettingStr = AppPreferencesSetting.getInstance().getAppSettingStr("pref_key_showed_dialog_ids", "");
            StringBuilder sb = new StringBuilder();
            sb.append(appSettingStr);
            sb.append(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
            sb.append(String.valueOf(bVar.buF));
            AppPreferencesSetting.getInstance().setAppSettingStr("pref_key_showed_dialog_ids", sb.toString());
        }
    }

    /* renamed from: cr */
    public static void m10105cr(Context context) {
        buD = m10106cs(context);
    }

    /* renamed from: cs */
    public static List<C4064b> m10106cs(Context context) {
        ArrayList arrayList = new ArrayList();
        Cursor query = context.getContentResolver().query(SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_POPUP_WINDOW_INFO), new String[]{SocialConstDef.POPUPWINDOW_ITEM_WINDOWID, SocialConstDef.POPUPWINDOW_ITEM_EVENTTYPE, SocialConstDef.POPUPWINDOW_ITEM_EVENTCNT, "expiretime", "iconurl", "modelcode", "type", "title", "description", SocialConstDef.POPUPWINDOW_ITEM_VIDEOURL, SocialConstDef.POPUPWINDOW_ITEM_EXTENDINFO, SocialConstDef.POPUPWINDOW_ITEM_DISPLAYSTATE, SocialConstDef.POPUPWINDOW_ITEM_POP_DAY_TIME, SocialConstDef.POPUPWINDOW_ITEM_DISPLAY_COUNT}, null, null, "orderno ASC");
        if (query != null) {
            if (query.getCount() > 0) {
                query.moveToFirst();
                do {
                    C4064b bVar = new C4064b();
                    bVar.buF = query.getInt(query.getColumnIndex(SocialConstDef.POPUPWINDOW_ITEM_WINDOWID));
                    bVar.buI = query.getInt(query.getColumnIndex("type"));
                    bVar.buJ = query.getInt(query.getColumnIndex(SocialConstDef.POPUPWINDOW_ITEM_EVENTTYPE));
                    bVar.buK = query.getString(query.getColumnIndex(SocialConstDef.POPUPWINDOW_ITEM_EVENTCNT));
                    bVar.buH = query.getInt(query.getColumnIndex("modelcode"));
                    bVar.mIconUrl = query.getString(query.getColumnIndex("iconurl"));
                    bVar.mTitle = query.getString(query.getColumnIndex("title"));
                    bVar.mDesc = query.getString(query.getColumnIndex("description"));
                    bVar.buL = query.getString(query.getColumnIndex(SocialConstDef.POPUPWINDOW_ITEM_VIDEOURL));
                    bVar.buM = query.getString(query.getColumnIndex(SocialConstDef.POPUPWINDOW_ITEM_EXTENDINFO));
                    bVar.displayState = query.getInt(query.getColumnIndex(SocialConstDef.POPUPWINDOW_ITEM_DISPLAYSTATE));
                    bVar.displayCount = query.getInt(query.getColumnIndex(SocialConstDef.POPUPWINDOW_ITEM_DISPLAY_COUNT));
                    bVar.buN = query.getString(query.getColumnIndex(SocialConstDef.POPUPWINDOW_ITEM_POP_DAY_TIME));
                    String string = query.getString(query.getColumnIndex("expiretime"));
                    if (!TextUtils.isEmpty(string)) {
                        bVar.buG = C4584e.m11684eH(string);
                    }
                    arrayList.add(bVar);
                } while (query.moveToNext());
            }
            query.close();
        }
        return arrayList;
    }

    /* renamed from: dI */
    private static String m10107dI(String str) {
        try {
            return new URI(str).getPath();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: dJ */
    private static MSize m10108dJ(String str) {
        if (!FileUtils.isFileExisted(str)) {
            return null;
        }
        MSize mSize = new MSize();
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        mSize.width = options.outWidth;
        mSize.height = options.outHeight;
        return mSize;
    }

    /* renamed from: h */
    public static boolean m10109h(Context context, boolean z) {
        boolean z2 = true;
        if (buD != null && buD.size() > 0) {
            Calendar instance = Calendar.getInstance();
            instance.add(6, -7);
            Date time = instance.getTime();
            for (C4064b bVar : buD) {
                if (bVar != null && !TextUtils.isEmpty(bVar.mIconUrl)) {
                    String P = m10099P(m10097Ne(), bVar.mIconUrl);
                    Date date = bVar.buG;
                    Date date2 = new Date();
                    if (date == null || C4584e.m11682d(date, date2)) {
                        if (!FileUtils.isFileExisted(P)) {
                            long enqueue = DownloadService.enqueue(context, bVar.mIconUrl, P, 0, 6);
                            if (enqueue > 0) {
                                DownloadService.startDownload(context, enqueue);
                            }
                            z2 = false;
                        }
                    } else if (z && C4584e.m11681c(date, time)) {
                        FileUtils.deleteFile(P);
                    }
                }
            }
        }
        return z2;
    }

    /* renamed from: hf */
    public static C4064b m10110hf(int i) {
        String appSettingStr = AppPreferencesSetting.getInstance().getAppSettingStr("pref_key_showed_dialog_ids", "");
        for (C4064b bVar : buD) {
            if (!appSettingStr.contains(String.valueOf(bVar.buF)) && bVar.buH == i) {
                if (bVar.buG == null) {
                    return bVar;
                }
                if (!C4584e.m11682d(new Date(), bVar.buG)) {
                    if (bVar.displayState != 0 || TextUtils.isEmpty(bVar.buN) || C4584e.m11681c(new Date(C2575a.parseLong(bVar.buN)), new Date())) {
                        return bVar;
                    }
                    return null;
                }
            }
        }
        return null;
    }

    /* renamed from: hg */
    public static C4064b m10111hg(int i) {
        if (buD == null || buD.size() <= 0) {
            return null;
        }
        for (C4064b bVar : buD) {
            if (bVar.buF == i) {
                return bVar;
            }
        }
        return null;
    }
}
