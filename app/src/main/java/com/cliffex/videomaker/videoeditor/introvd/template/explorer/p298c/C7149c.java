package com.introvd.template.explorer.p298c;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore.Audio;
import android.provider.MediaStore.Images;
import android.provider.MediaStore.Video.Media;
import android.text.TextUtils;
import com.google.android.exoplayer2.util.MimeTypes;
import com.introvd.template.C4681i;
import com.introvd.template.common.CommonConfigure;
import com.introvd.template.common.FileUtils;
import com.introvd.template.common.LogUtils;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.MediaFileUtils;
import com.introvd.template.common.StorageInfo;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.explorer.C7138b;
import com.introvd.template.explorer.model.ExplorerItem;
import com.introvd.template.explorer.model.GROUP_MEDIA_TYPE;
import com.introvd.template.explorer.model.GroupComparator;
import com.introvd.template.explorer.model.NotifyItem;
import com.introvd.template.explorer.p297b.C7139a;
import com.introvd.template.explorer.p300e.C7208b;
import com.introvd.template.explorer.p300e.C7211d;
import com.introvd.template.sdk.database.model.DBProject;
import com.introvd.template.sdk.p384d.C8404c;
import com.introvd.template.sdk.utils.C8572y;
import com.introvd.template.videoeditor.model.BROWSE_TYPE;
import com.introvd.template.videoeditor.model.ExtMediaItem;
import com.introvd.template.videoeditor.model.MEDIA_TYPE;
import com.introvd.template.videoeditor.model.MediaGroupItem;
import com.introvd.template.videoeditor.model.MediaItem;
import com.introvd.template.vivaexplorermodule.R;
import java.io.File;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;
import p037b.p050b.C1834l;
import p037b.p050b.C1838m;
import p037b.p050b.C1839n;
import p037b.p050b.C1842q;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.explorer.c.c */
public class C7149c {
    private static final String TAG = "c";
    private static Map<BROWSE_TYPE, C7153a> dzN = new HashMap();
    private static boolean dzO = true;
    /* access modifiers changed from: private */
    public static MediaGroupItem dzx;
    public static int dzy;
    public static int dzz;
    private boolean dzA = false;
    private int dzB = 0;
    /* access modifiers changed from: private */
    public C7139a dzC;
    private MEDIA_TYPE dzD = MEDIA_TYPE.MEDIA_TYPE_NONE;
    private BROWSE_TYPE dzE = BROWSE_TYPE.PHOTO_AND_VIDEO;
    private int dzF = 2;
    private Long[] dzG = null;
    private Map<String, ExtMediaItem> dzH = Collections.synchronizedMap(new LinkedHashMap());
    private String dzI = null;
    private String dzJ = null;
    private boolean dzK = false;
    private String dzL = null;
    private String dzM = null;
    private GROUP_MEDIA_TYPE mGroupType = GROUP_MEDIA_TYPE.GROUP_MEDIA_TYPE_FOLDER;
    public Map<Long, MediaGroupItem> mMediaGroupMap = Collections.synchronizedMap(new HashMap());

    /* renamed from: com.introvd.template.explorer.c.c$a */
    private static class C7153a {
        ContentObserver dzT = new ContentObserver(new Handler(Looper.getMainLooper())) {
            public void onChange(boolean z) {
                super.onChange(z);
                if (C7149c.dzx != null) {
                    BROWSE_TYPE browseType = C7149c.dzx.getBrowseType();
                    C7149c.dzx.mediaItemList = C7149c.m21138b(browseType);
                    if (C7153a.this.dzU != null) {
                        C7153a.this.dzU.awF();
                    }
                }
            }
        };
        C7155b dzU;
    }

    /* renamed from: com.introvd.template.explorer.c.c$b */
    public interface C7155b {
        void awF();
    }

    public C7149c() {
        try {
            String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
            if (!TextUtils.isEmpty(absolutePath)) {
                this.dzF = absolutePath.split("/").length + 2;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: K */
    private boolean m21121K(Map<Long, MediaGroupItem> map) {
        if (map.size() <= 1) {
            return true;
        }
        for (Entry value : map.entrySet()) {
            MediaGroupItem mediaGroupItem = (MediaGroupItem) value.getValue();
            if (!(mediaGroupItem == null || mediaGroupItem.mediaItemList == null || mediaGroupItem.mediaItemList.size() <= 1)) {
                Collections.sort(mediaGroupItem.mediaItemList, new C7141a(3));
            }
            if (this.dzC != null) {
                this.dzC.mo31596a(0, 0, 0, 0, null, null);
            }
        }
        if (this.dzC != null) {
            this.dzC.mo31596a(0, 0, 0, 1, null, null);
        }
        return true;
    }

    /* renamed from: a */
    public static int m21122a(MediaGroupItem mediaGroupItem) {
        int i = 0;
        if ("videos".equals(mediaGroupItem.strGroupDisplayName)) {
            return mediaGroupItem.countForSns;
        }
        if (mediaGroupItem.countForSns != 0) {
            return 0;
        }
        Iterator it = mediaGroupItem.mediaItemList.iterator();
        while (it.hasNext()) {
            if (!MediaFileUtils.IsImageFileType(MediaFileUtils.GetFileMediaType(((ExtMediaItem) it.next()).path))) {
                i++;
            }
        }
        return i;
    }

    /* renamed from: a */
    private Cursor m21123a(Context context, Uri uri, String str) {
        return m21124a(context, uri, str, this.dzI, this.dzJ);
    }

    /* renamed from: a */
    private static Cursor m21124a(Context context, Uri uri, String str, String str2, String str3) {
        String str4;
        String[] strArr;
        String[] strArr2;
        String str5;
        Cursor cursor;
        Uri uri2 = uri;
        String str6 = str;
        String str7 = str2;
        String str8 = str3;
        if (context == null || uri2 == null) {
            return null;
        }
        String str9 = "date_modified desc";
        if (uri.equals(Media.EXTERNAL_CONTENT_URI)) {
            strArr = new String[]{"_id", "title", SocialConstDef.MEDIA_ITEM_DATA, SocialConstDef.MEDIA_ITEM_DATE_MODIFIED, "duration"};
            str4 = m21128a(BROWSE_TYPE.VIDEO);
        } else if (uri.equals(Images.Media.EXTERNAL_CONTENT_URI)) {
            strArr = new String[]{"_id", "title", SocialConstDef.MEDIA_ITEM_DATA, SocialConstDef.MEDIA_ITEM_DATE_MODIFIED};
            str4 = m21128a(BROWSE_TYPE.PHOTO);
        } else if (uri.equals(Audio.Media.EXTERNAL_CONTENT_URI)) {
            strArr = new String[]{"_id", "title", SocialConstDef.MEDIA_ITEM_DATA, SocialConstDef.MEDIA_ITEM_DATE_MODIFIED, "duration", SocialConstDef.MEDIA_ITEM_ARTIST};
            str4 = m21128a(BROWSE_TYPE.AUDIO);
        } else {
            strArr = null;
            str4 = null;
        }
        if (!TextUtils.isEmpty(str4)) {
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            sb.append(str4);
            sb.append(")");
            str4 = sb.toString();
        }
        if (str6 == null) {
            str5 = str4;
            strArr2 = null;
        } else if (str7 == null || str8 == null || str2.equals(str3) || (!str7.equals(str6) && !str8.equals(str6))) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("(_data like ? ) AND ");
            sb2.append(str4);
            String sb3 = sb2.toString();
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str6);
            sb4.append("%");
            strArr2 = new String[]{sb4.toString()};
            str5 = sb3;
        } else {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("((_data like ? ) OR (_data like ? )) AND ");
            sb5.append(str4);
            String sb6 = sb5.toString();
            StringBuilder sb7 = new StringBuilder();
            sb7.append(str7);
            sb7.append("%");
            StringBuilder sb8 = new StringBuilder();
            sb8.append(str8);
            sb8.append("%");
            strArr2 = new String[]{sb7.toString(), sb8.toString()};
            str5 = sb6;
        }
        try {
            cursor = context.getContentResolver().query(uri, strArr, str5, strArr2, str9);
        } catch (Exception unused) {
            cursor = null;
        }
        return cursor;
    }

    /* renamed from: a */
    private Cursor m21125a(Context context, BROWSE_TYPE browse_type, String str) {
        String str2;
        String[] strArr;
        String str3;
        Cursor cursor;
        BROWSE_TYPE browse_type2 = browse_type;
        if (context == null) {
            return null;
        }
        String[] strArr2 = {"_id", "title", SocialConstDef.MEDIA_ITEM_DATA, SocialConstDef.MEDIA_ITEM_DATE_MODIFIED, "duration", SocialConstDef.MEDIA_ITEM_ARTIST, "flag", "from_type", "misc"};
        String str4 = "date_modified desc";
        String str5 = "";
        if (browse_type2 == BROWSE_TYPE.VIDEO || browse_type2 == BROWSE_TYPE.PHOTO_AND_VIDEO) {
            str5 = m21128a(BROWSE_TYPE.VIDEO);
        }
        if (browse_type2 == BROWSE_TYPE.PHOTO || browse_type2 == BROWSE_TYPE.PHOTO_AND_VIDEO) {
            if (!TextUtils.isEmpty(str5)) {
                StringBuilder sb = new StringBuilder();
                sb.append(str5);
                sb.append(" OR ");
                str5 = sb.toString();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str5);
            sb2.append(m21128a(BROWSE_TYPE.PHOTO));
            str5 = sb2.toString();
        }
        if (browse_type2 == BROWSE_TYPE.AUDIO) {
            if (!TextUtils.isEmpty(str5)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str5);
                sb3.append(" OR ");
                str5 = sb3.toString();
            }
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str5);
            sb4.append(m21128a(BROWSE_TYPE.AUDIO));
            str5 = sb4.toString();
            str2 = "artist COLLATE LOCALIZED";
        } else {
            str2 = str4;
        }
        if (TextUtils.isEmpty(str5)) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("(");
        sb5.append(str5);
        sb5.append(")");
        String sb6 = sb5.toString();
        if (!TextUtils.isEmpty(str)) {
            StringBuilder sb7 = new StringBuilder();
            sb7.append("(_data like ? ) AND ");
            sb7.append(sb6);
            String sb8 = sb7.toString();
            StringBuilder sb9 = new StringBuilder();
            sb9.append(str);
            sb9.append("%");
            str3 = sb8;
            strArr = new String[]{sb9.toString()};
        } else {
            str3 = sb6;
            strArr = null;
        }
        try {
            cursor = context.getContentResolver().query(SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_MEDIA_ITEM), strArr2, str3, strArr, str2);
        } catch (Exception e) {
            e.printStackTrace();
            cursor = null;
        }
        return cursor;
    }

    /* renamed from: a */
    private MediaGroupItem m21127a(Map<Long, MediaGroupItem> map, ExtMediaItem extMediaItem) {
        MediaGroupItem mediaGroupItem;
        MediaGroupItem mediaGroupItem2 = null;
        if (map == null || extMediaItem == null) {
            return null;
        }
        if (this.mGroupType == GROUP_MEDIA_TYPE.GROUP_MEDIA_TYPE_TITLE) {
            mediaGroupItem = (MediaGroupItem) map.get(Long.valueOf(1));
            if (mediaGroupItem == null) {
                mediaGroupItem = new MediaGroupItem();
                mediaGroupItem.lGroupTimestamp = 1;
                mediaGroupItem.mediaItemList = new ArrayList<>();
                mediaGroupItem.strGroupDisplayName = "";
                map.put(Long.valueOf(mediaGroupItem.lGroupTimestamp), mediaGroupItem);
            }
        } else if (this.mGroupType == GROUP_MEDIA_TYPE.GROUP_MEDIA_TYPE_DATE) {
            long rawOffset = (((extMediaItem.date + ((long) TimeZone.getDefault().getRawOffset())) / 86400000) * 86400000) + 1;
            mediaGroupItem = (MediaGroupItem) map.get(Long.valueOf(rawOffset));
            if (mediaGroupItem == null) {
                mediaGroupItem = new MediaGroupItem();
                mediaGroupItem.lGroupTimestamp = rawOffset;
                mediaGroupItem.mediaItemList = new ArrayList<>();
                mediaGroupItem.strGroupDisplayName = new Date(rawOffset).toString();
                map.put(Long.valueOf(mediaGroupItem.lGroupTimestamp), mediaGroupItem);
            }
        } else {
            String jb = m21150jb(extMediaItem.path);
            if ((this.dzI != null && jb.equals(this.dzI)) || (this.dzJ != null && jb.equals(this.dzJ))) {
                jb = this.dzI;
            }
            if (map.size() > 0) {
                Iterator it = map.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    MediaGroupItem mediaGroupItem3 = (MediaGroupItem) ((Entry) it.next()).getValue();
                    if (jb.compareToIgnoreCase(mediaGroupItem3.strParentPath) == 0) {
                        mediaGroupItem2 = mediaGroupItem3;
                        break;
                    }
                }
            }
            if (mediaGroupItem2 == null) {
                mediaGroupItem2 = new MediaGroupItem();
                mediaGroupItem2.mediaItemList = new ArrayList<>();
                mediaGroupItem2.strParentPath = jb;
                String jd = m21152jd(mediaGroupItem2.strParentPath);
                if (TextUtils.isEmpty(jd)) {
                    jd = m21151jc(mediaGroupItem2.strParentPath);
                }
                mediaGroupItem2.strGroupDisplayName = jd;
                mediaGroupItem2.lGroupTimestamp = (long) (map.size() + 1);
                map.put(Long.valueOf(mediaGroupItem2.lGroupTimestamp), mediaGroupItem2);
            }
            mediaGroupItem = mediaGroupItem2;
        }
        return mediaGroupItem;
    }

    /* renamed from: a */
    private static String m21128a(BROWSE_TYPE browse_type) {
        switch (browse_type) {
            case PHOTO:
                return m21147h(C7138b.avR());
            case VIDEO:
                return m21147h(C7138b.avS());
            case AUDIO:
                return m21147h(C7138b.avT());
            default:
                return null;
        }
    }

    /* renamed from: a */
    public static void m21129a(Context context, MediaItem mediaItem, String str) {
        if (context != null && mediaItem != null) {
            ContentResolver contentResolver = context.getContentResolver();
            ContentValues contentValues = new ContentValues();
            contentValues.put(SocialConstDef.MEDIA_ITEM_ARTIST, mediaItem.artist);
            contentValues.put(SocialConstDef.MEDIA_ITEM_DATE_MODIFIED, Long.valueOf(mediaItem.date));
            contentValues.put("title", mediaItem.title);
            contentValues.put("duration", Long.valueOf(mediaItem.duration));
            contentValues.put(SocialConstDef.MEDIA_ITEM_MIME_TYPE, str);
            if (contentResolver.update(SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_MEDIA_ITEM), contentValues, "_data = ?", new String[]{mediaItem.path}) <= 0) {
                contentValues.put(SocialConstDef.MEDIA_ITEM_DATA, mediaItem.path);
                contentValues.put(SocialConstDef.MEDIA_ITEM_DATE_ADDED, Long.valueOf(System.currentTimeMillis()));
                contentValues.put("flag", Integer.valueOf(1));
                if (mediaItem instanceof ExtMediaItem) {
                    ExtMediaItem extMediaItem = (ExtMediaItem) mediaItem;
                    contentValues.put("from_type", Integer.valueOf(extMediaItem.nFromtype));
                    contentValues.put("misc", extMediaItem.strMisc);
                }
                contentResolver.insert(SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_MEDIA_ITEM), contentValues);
            }
        }
    }

    /* renamed from: a */
    private void m21130a(final Context context, final Long l) {
        C1834l.m5254a((C1839n<T>) new C1839n<NotifyItem>() {
            /* renamed from: a */
            public void mo10177a(C1838m<NotifyItem> mVar) {
                if (C7149c.this.mMediaGroupMap != null && !C7149c.this.mMediaGroupMap.isEmpty()) {
                    try {
                        Long[] lArr = l == null ? (Long[]) C7149c.this.mMediaGroupMap.keySet().toArray(new Long[C7149c.this.mMediaGroupMap.size()]) : new Long[]{l};
                        if (lArr.length >= 1) {
                            ArrayList arrayList = new ArrayList();
                            for (Long l : lArr) {
                                MediaGroupItem mediaGroupItem = (MediaGroupItem) C7149c.this.mMediaGroupMap.get(l);
                                if (!(mediaGroupItem == null || mediaGroupItem.mediaItemList == null)) {
                                    if (!mediaGroupItem.mediaItemList.isEmpty()) {
                                        arrayList.clear();
                                        arrayList.addAll(mediaGroupItem.mediaItemList);
                                        Iterator it = arrayList.iterator();
                                        while (it.hasNext()) {
                                            ExtMediaItem extMediaItem = (ExtMediaItem) it.next();
                                            if (C7149c.m21134a(context, (MediaItem) extMediaItem, 4) && C7149c.this.dzC != null) {
                                                NotifyItem notifyItem = new NotifyItem(3, 0, 0, 1, extMediaItem.path, null);
                                                mVar.mo9791K(notifyItem);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } catch (Exception unused) {
                        mVar.onError(new Throwable());
                    }
                }
            }
        }).mo10157d(C1820a.aVi()).mo10152c(C1487a.aUa()).mo10149b((C1842q<? super T>) new C1842q<NotifyItem>() {
            /* renamed from: a */
            public void mo9877a(C1495b bVar) {
            }

            /* renamed from: a */
            public void mo9886K(NotifyItem notifyItem) {
                if (C7149c.this.dzC != null && notifyItem != null) {
                    C7149c.this.dzC.mo31596a(notifyItem.what, notifyItem.lParam, notifyItem.wParam, notifyItem.nStatus, notifyItem.obj, notifyItem.f3541cb);
                }
            }

            public void onComplete() {
            }

            public void onError(Throwable th) {
                LogUtilsV2.m14228e("doFillMeidaItem something error");
            }
        });
    }

    /* renamed from: a */
    public static void m21131a(C7155b bVar) {
        BROWSE_TYPE[] browse_typeArr;
        for (BROWSE_TYPE browse_type : new BROWSE_TYPE[]{BROWSE_TYPE.PHOTO, BROWSE_TYPE.VIDEO}) {
            Context applicationContext = C4681i.m12184Gp().mo25017Gs().getApplicationContext();
            Uri e = m21145e(browse_type);
            C7153a d = m21143d(browse_type);
            d.dzU = bVar;
            applicationContext.getContentResolver().registerContentObserver(e, false, d.dzT);
        }
    }

    /* renamed from: a */
    private boolean m21132a(Context context, Uri uri, String str, Map<Long, MediaGroupItem> map) {
        awz();
        Cursor a = m21123a(context, uri, str);
        CommonConfigure.getStoragePath();
        if (a != null) {
            while (a.moveToNext()) {
                ExtMediaItem j = m21149j(a);
                if (m21136a(j, this.dzE)) {
                    MediaGroupItem a2 = m21127a(map, j);
                    if (a2 != null) {
                        j.lGroupKey = a2.lGroupTimestamp;
                        a2.add(j);
                    }
                }
            }
            a.close();
        }
        return true;
    }

    /* renamed from: a */
    private boolean m21133a(Context context, BROWSE_TYPE browse_type, Map<Long, MediaGroupItem> map, String str) {
        Cursor a = m21125a(context, browse_type, str);
        if (a != null) {
            while (a.moveToNext()) {
                try {
                    ExtMediaItem j = m21149j(a);
                    if (j != null) {
                        if (!TextUtils.isEmpty(j.path)) {
                            if (!m21153je(j.path)) {
                                if (FileUtils.isFileExisted(j.path)) {
                                    MediaGroupItem a2 = m21127a(map, j);
                                    if (a2 != null) {
                                        j.lGroupKey = a2.lGroupTimestamp;
                                        a2.add(j);
                                    }
                                }
                            }
                        }
                    }
                } catch (Throwable unused) {
                    return false;
                } finally {
                    a.close();
                }
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static boolean m21134a(Context context, MediaItem mediaItem, int i) {
        boolean z = (i & 8) != 0;
        if ((i & 4) != 0 && mediaItem.duration == 0) {
            C7208b.m21287c(context, mediaItem, 4);
            z = true;
        }
        if ((i & 1) == 0 || mediaItem.date != 0) {
            return z;
        }
        C7208b.m21287c(context, mediaItem, 1);
        return true;
    }

    /* renamed from: a */
    private boolean m21135a(Context context, String str, Map<Long, MediaGroupItem> map, BROWSE_TYPE browse_type) {
        awz();
        dzx = new MediaGroupItem();
        dzx.setVirtualFile(true);
        dzx.strParentPath = "";
        if (browse_type != null) {
            switch (browse_type) {
                case PHOTO:
                    m21132a(context, Images.Media.EXTERNAL_CONTENT_URI, str, map);
                    m21133a(context, BROWSE_TYPE.PHOTO, map, str);
                    dzx.setBrowseType(BROWSE_TYPE.PHOTO);
                    dzx.strGroupDisplayName = context.getString(R.string.xiaoying_str_com_gallery_recent_image_folder);
                    dzx.mediaItemList = m21138b(BROWSE_TYPE.PHOTO);
                    break;
                case VIDEO:
                    m21132a(context, Media.EXTERNAL_CONTENT_URI, str, map);
                    m21133a(context, BROWSE_TYPE.VIDEO, map, str);
                    dzx.setBrowseType(BROWSE_TYPE.VIDEO);
                    dzx.strGroupDisplayName = context.getString(R.string.xiaoying_str_com_gallery_recent_video_folder);
                    dzx.mediaItemList = m21138b(BROWSE_TYPE.VIDEO);
                    break;
                case AUDIO:
                    m21132a(context, Audio.Media.EXTERNAL_CONTENT_URI, str, map);
                    m21133a(context, BROWSE_TYPE.AUDIO, map, str);
                    break;
                case PHOTO_AND_VIDEO:
                    m21132a(context, Images.Media.EXTERNAL_CONTENT_URI, str, map);
                    m21132a(context, Media.EXTERNAL_CONTENT_URI, str, map);
                    m21133a(context, BROWSE_TYPE.PHOTO_AND_VIDEO, map, str);
                    break;
            }
        }
        m21121K(map);
        return true;
    }

    /* renamed from: a */
    private static boolean m21136a(ExtMediaItem extMediaItem, BROWSE_TYPE browse_type) {
        return !(extMediaItem == null || TextUtils.isEmpty(extMediaItem.path) || m21153je(extMediaItem.path) || (browse_type != BROWSE_TYPE.AUDIO && extMediaItem.path.contains("/qqmusic/")) || !FileUtils.isFileExisted(extMediaItem.path) || extMediaItem.path.contains("/XiaoYing/ini/"));
    }

    private void awB() {
        if (this.dzG == null || this.dzG.length != this.mMediaGroupMap.size()) {
            Set keySet = this.mMediaGroupMap.keySet();
            List asList = Arrays.asList((Long[]) keySet.toArray(new Long[keySet.size()]));
            Collections.sort(asList, new GroupComparator(this.mMediaGroupMap, this.mGroupType, this.dzI));
            this.dzG = (Long[]) asList.toArray(new Long[asList.size()]);
        }
    }

    public static void awD() {
        Context applicationContext = C4681i.m12184Gp().mo25017Gs().getApplicationContext();
        for (BROWSE_TYPE d : new BROWSE_TYPE[]{BROWSE_TYPE.PHOTO, BROWSE_TYPE.VIDEO}) {
            C7153a d2 = m21143d(d);
            applicationContext.getContentResolver().unregisterContentObserver(d2.dzT);
            d2.dzU = null;
        }
    }

    private void awz() {
        if (!this.dzK) {
            String mainStorage = StorageInfo.getMainStorage();
            String extStorage = StorageInfo.getExtStorage();
            String str = CommonConfigure.CAMERA_VIDEO_RELATIVE_PATH;
            StringBuilder sb = new StringBuilder();
            sb.append(mainStorage);
            sb.append(File.separator);
            sb.append(str);
            this.dzI = new File(sb.toString()).getAbsolutePath();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(mainStorage);
            sb2.append(File.separator);
            sb2.append(CommonConfigure.APP_DATA_PATH_RELATIVE);
            this.dzL = new File(sb2.toString()).getAbsolutePath();
            if (!TextUtils.isEmpty(extStorage)) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(extStorage);
                sb3.append(File.separator);
                sb3.append(str);
                this.dzJ = new File(sb3.toString()).getAbsolutePath();
                StringBuilder sb4 = new StringBuilder();
                sb4.append(extStorage);
                sb4.append(File.separator);
                sb4.append(CommonConfigure.APP_DATA_PATH_RELATIVE);
                this.dzM = new File(sb4.toString()).getAbsolutePath();
            }
            this.dzK = true;
        }
    }

    /* renamed from: b */
    public static int m21137b(MediaGroupItem mediaGroupItem) {
        int i = 0;
        if (!"videos".equals(mediaGroupItem.strGroupDisplayName) && mediaGroupItem.countForSns > 0) {
            return mediaGroupItem.countForSns;
        }
        if ("videos".equals(mediaGroupItem.strGroupDisplayName)) {
            return 0;
        }
        Iterator it = mediaGroupItem.mediaItemList.iterator();
        while (it.hasNext()) {
            if (MediaFileUtils.IsImageFileType(MediaFileUtils.GetFileMediaType(((ExtMediaItem) it.next()).path))) {
                i++;
            }
        }
        return i;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0077  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.ArrayList<com.introvd.template.videoeditor.model.ExtMediaItem> m21138b(com.introvd.template.videoeditor.model.BROWSE_TYPE r8) {
        /*
            android.net.Uri r1 = m21145e(r8)
            r6 = 0
            if (r8 == 0) goto L_0x007e
            if (r1 != 0) goto L_0x000b
            goto L_0x007e
        L_0x000b:
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            com.introvd.template.i r0 = com.introvd.template.C4681i.m12184Gp()
            com.introvd.template.VivaBaseApplication r0 = r0.mo25017Gs()
            android.content.Context r0 = r0.getApplicationContext()
            if (r0 == 0) goto L_0x006c
            android.content.ContentResolver r0 = r0.getContentResolver()
            java.lang.String r3 = m21128a(r8)
            java.lang.String[] r2 = m21142c(r8)
            java.lang.String r5 = "date_modified desc"
            r4 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5)     // Catch:{ Exception -> 0x005c }
        L_0x0031:
            if (r0 == 0) goto L_0x0053
            boolean r1 = r0.moveToNext()     // Catch:{ Exception -> 0x0050, all -> 0x004e }
            if (r1 == 0) goto L_0x0053
            com.introvd.template.videoeditor.model.ExtMediaItem r1 = m21149j(r0)     // Catch:{ IllegalStateException -> 0x0047 }
            boolean r2 = m21136a(r1, r8)     // Catch:{ IllegalStateException -> 0x0047 }
            if (r2 == 0) goto L_0x0031
            r7.add(r1)     // Catch:{ IllegalStateException -> 0x0047 }
            goto L_0x0031
        L_0x0047:
            r1 = move-exception
            java.lang.String r2 = "cursor exception"
            com.introvd.template.common.LogUtilsV2.m14229e(r2, r1)     // Catch:{ Exception -> 0x0050, all -> 0x004e }
            goto L_0x0053
        L_0x004e:
            r8 = move-exception
            goto L_0x0066
        L_0x0050:
            r1 = move-exception
            r6 = r0
            goto L_0x005d
        L_0x0053:
            if (r0 == 0) goto L_0x006c
            r0.close()
            goto L_0x006c
        L_0x0059:
            r8 = move-exception
            r0 = r6
            goto L_0x0066
        L_0x005c:
            r1 = move-exception
        L_0x005d:
            com.introvd.template.crash.C5523b.logException(r1)     // Catch:{ all -> 0x0059 }
            if (r6 == 0) goto L_0x006c
            r6.close()
            goto L_0x006c
        L_0x0066:
            if (r0 == 0) goto L_0x006b
            r0.close()
        L_0x006b:
            throw r8
        L_0x006c:
            int r0 = r7.size()
            com.introvd.template.videoeditor.model.BROWSE_TYPE r1 = com.introvd.template.videoeditor.model.BROWSE_TYPE.PHOTO
            if (r1 != r8) goto L_0x0077
            dzy = r0
            goto L_0x007d
        L_0x0077:
            com.introvd.template.videoeditor.model.BROWSE_TYPE r1 = com.introvd.template.videoeditor.model.BROWSE_TYPE.VIDEO
            if (r1 != r8) goto L_0x007d
            dzz = r0
        L_0x007d:
            return r7
        L_0x007e:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.explorer.p298c.C7149c.m21138b(com.introvd.template.videoeditor.model.BROWSE_TYPE):java.util.ArrayList");
    }

    /* renamed from: bS */
    private boolean m21140bS(Context context, String str) {
        if (context == null) {
            return false;
        }
        List<DBProject> nE = C8404c.m24245nE(str);
        ExplorerItem explorerItem = new ExplorerItem();
        explorerItem.mInputType = 1;
        explorerItem.mSortOrder = 2;
        explorerItem.mMimeList = new ArrayList<>();
        explorerItem.mMimeList.add(MimeTypes.VIDEO_MP4);
        explorerItem.mMimeList.add(MimeTypes.VIDEO_H263);
        explorerItem.mMimeList.add("image/jpeg");
        explorerItem.mSearchType = 3;
        explorerItem.mPathList = new ArrayList<>();
        for (DBProject dBProject : nE) {
            String str2 = dBProject.url;
            int i = dBProject.is_deleted;
            if (!TextUtils.isEmpty(str2) && i != 2) {
                String ou = C8572y.m25097ou(str2);
                if (FileUtils.isDirectoryExisted(ou)) {
                    explorerItem.mPathList.clear();
                    explorerItem.mPathList.add(ou);
                    this.dzB += C7208b.m21284a(explorerItem).size();
                }
            }
        }
        return true;
    }

    /* renamed from: bT */
    public static ExtMediaItem m21141bT(Context context, String str) {
        ExtMediaItem extMediaItem;
        Cursor a = m21124a(context, Images.Media.EXTERNAL_CONTENT_URI, str, null, null);
        if (a != null) {
            extMediaItem = a.moveToNext() ? m21149j(a) : null;
            a.close();
        } else {
            extMediaItem = null;
        }
        if (extMediaItem == null) {
            Cursor a2 = m21124a(context, Media.EXTERNAL_CONTENT_URI, str, null, null);
            if (a2 != null) {
                if (a2.moveToNext()) {
                    extMediaItem = m21149j(a2);
                }
                a2.close();
            }
        }
        return extMediaItem;
    }

    /* renamed from: c */
    private static String[] m21142c(BROWSE_TYPE browse_type) {
        String[] strArr = null;
        if (browse_type == null) {
            return null;
        }
        switch (browse_type) {
            case PHOTO:
                strArr = new String[]{"_id", "title", SocialConstDef.MEDIA_ITEM_DATA, SocialConstDef.MEDIA_ITEM_DATE_MODIFIED};
                break;
            case VIDEO:
                strArr = new String[]{"_id", "title", SocialConstDef.MEDIA_ITEM_DATA, SocialConstDef.MEDIA_ITEM_DATE_MODIFIED, "duration"};
                break;
        }
        return strArr;
    }

    /* renamed from: d */
    private static C7153a m21143d(BROWSE_TYPE browse_type) {
        C7153a aVar = (C7153a) dzN.get(browse_type);
        if (aVar != null) {
            return aVar;
        }
        C7153a aVar2 = new C7153a();
        dzN.put(browse_type, aVar2);
        return aVar2;
    }

    /* renamed from: d */
    private boolean m21144d(Context context, String str, Map<Long, MediaGroupItem> map) {
        Timestamp timestamp;
        Context context2 = context;
        if (context2 == null) {
            return false;
        }
        List<DBProject> nE = C8404c.m24245nE(str);
        ExplorerItem explorerItem = new ExplorerItem();
        explorerItem.mInputType = 1;
        explorerItem.mSortOrder = 2;
        explorerItem.mMimeList = new ArrayList<>();
        explorerItem.mMimeList.add(MimeTypes.VIDEO_MP4);
        explorerItem.mMimeList.add(MimeTypes.VIDEO_H263);
        explorerItem.mMimeList.add("image/jpeg");
        explorerItem.mSearchType = 3;
        explorerItem.mPathList = new ArrayList<>();
        for (DBProject dBProject : nE) {
            String str2 = dBProject.url;
            int i = dBProject.is_deleted;
            if (TextUtils.isEmpty(str2)) {
                Map<Long, MediaGroupItem> map2 = map;
            } else if (i != 2) {
                String ou = C8572y.m25097ou(str2);
                if (FileUtils.isDirectoryExisted(ou)) {
                    explorerItem.mPathList.clear();
                    explorerItem.mPathList.add(ou);
                    ArrayList a = C7208b.m21284a(explorerItem);
                    int size = a.size();
                    if (size > 0) {
                        MediaGroupItem mediaGroupItem = new MediaGroupItem();
                        mediaGroupItem.lGroupExtInfo = dBProject._id.longValue();
                        if (dBProject._id.longValue() >= 0) {
                            mediaGroupItem.strGroupDisplayName = dBProject.title;
                        }
                        if (mediaGroupItem.strGroupDisplayName == null) {
                            mediaGroupItem.strGroupDisplayName = "";
                        }
                        try {
                            timestamp = Timestamp.valueOf(dBProject.create_time);
                        } catch (Exception unused) {
                            timestamp = new Timestamp(new File(str2).lastModified());
                        }
                        mediaGroupItem.mediaItemList = new ArrayList<>();
                        mediaGroupItem.lGroupTimestamp = timestamp.getTime();
                        for (int i2 = 0; i2 < size; i2++) {
                            ExtMediaItem extMediaItem = new ExtMediaItem();
                            extMediaItem.mediaId = i2;
                            extMediaItem.path = (String) a.get(i2);
                            C7208b.m21287c(context2, extMediaItem, 3);
                            extMediaItem.displayTitle = extMediaItem.title;
                            extMediaItem.lGroupKey = mediaGroupItem.lGroupTimestamp;
                            mediaGroupItem.add(extMediaItem);
                        }
                        if (mediaGroupItem.mediaItemList.size() > 1) {
                            Collections.sort(mediaGroupItem.mediaItemList, new C7141a(3));
                        }
                        map.put(Long.valueOf(mediaGroupItem.lGroupTimestamp), mediaGroupItem);
                        if (this.dzC != null) {
                            this.dzC.mo31596a(0, 0, 0, 0, null, null);
                        }
                    }
                }
            }
        }
        if (this.dzC != null) {
            this.dzC.mo31596a(0, 0, 0, 1, null, null);
        }
        m21130a(context2, (Long) null);
        return true;
    }

    /* renamed from: e */
    private static Uri m21145e(BROWSE_TYPE browse_type) {
        Uri uri = null;
        if (browse_type == null) {
            return null;
        }
        switch (browse_type) {
            case PHOTO:
                uri = Images.Media.EXTERNAL_CONTENT_URI;
                break;
            case VIDEO:
                uri = Media.EXTERNAL_CONTENT_URI;
                break;
        }
        return uri;
    }

    /* renamed from: h */
    private static String m21147h(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (String str : strArr) {
            if (sb.length() > 1) {
                sb.append(" OR ");
            }
            sb.append(SocialConstDef.MEDIA_ITEM_MIME_TYPE);
            sb.append(" = '");
            sb.append(str);
            sb.append("'");
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: hY */
    public static void m21148hY(boolean z) {
        dzO = z;
    }

    /* renamed from: j */
    private static ExtMediaItem m21149j(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        ExtMediaItem extMediaItem = new ExtMediaItem();
        extMediaItem.mediaId = cursor.getInt(0);
        String string = cursor.getString(1);
        extMediaItem.displayTitle = string;
        extMediaItem.title = string;
        extMediaItem.path = cursor.getString(2);
        extMediaItem.date = cursor.getLong(3);
        if (String.valueOf(extMediaItem.date).length() <= 10) {
            extMediaItem.date *= 1000;
        }
        int columnIndex = cursor.getColumnIndex("duration");
        if (columnIndex >= 0) {
            extMediaItem.duration = cursor.getLong(columnIndex);
        }
        int columnIndex2 = cursor.getColumnIndex(SocialConstDef.MEDIA_ITEM_ARTIST);
        if (columnIndex2 >= 0) {
            extMediaItem.artist = cursor.getString(columnIndex2);
        }
        int columnIndex3 = cursor.getColumnIndex("flag");
        if (columnIndex3 >= 0) {
            extMediaItem.lFlag = (long) cursor.getInt(columnIndex3);
        }
        int columnIndex4 = cursor.getColumnIndex("from_type");
        if (columnIndex4 >= 0) {
            extMediaItem.nFromtype = cursor.getInt(columnIndex4);
        }
        int columnIndex5 = cursor.getColumnIndex("misc");
        if (columnIndex5 >= 0) {
            extMediaItem.strMisc = cursor.getString(columnIndex5);
        }
        return extMediaItem;
    }

    /* renamed from: jb */
    private String m21150jb(String str) {
        int i;
        if (str == null) {
            return "";
        }
        boolean contains = str.contains("/Android/data/");
        ArrayList arrayList = new ArrayList();
        File file = new File(str);
        while (true) {
            if (file == null) {
                break;
            }
            arrayList.add(0, file.getName());
            file = file.getParentFile();
        }
        int min = Math.min(this.dzF + (contains ? 1 : 0), arrayList.size() - 1);
        StringBuilder sb = new StringBuilder();
        for (i = 0; i < min; i++) {
            sb.append((String) arrayList.get(i));
            sb.append("/");
        }
        return sb.toString();
    }

    /* renamed from: jc */
    private String m21151jc(String str) {
        if (str == null) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf("/");
        if (lastIndexOf == -1) {
            return "";
        }
        String substring = str.substring(0, lastIndexOf);
        int lastIndexOf2 = substring.lastIndexOf("/");
        return lastIndexOf2 == -1 ? substring : substring.substring(lastIndexOf2 + 1);
    }

    /* renamed from: jd */
    private String m21152jd(String str) {
        Map ayb = C7211d.ayb();
        Integer num = ayb != null ? (Integer) ayb.get(str) : null;
        if (num == null) {
            return null;
        }
        try {
            return C4681i.m12184Gp().mo25017Gs().getApplicationContext().getString(num.intValue());
        } catch (Exception unused) {
            LogUtils.m14222e("MediaManager", "find name resource error");
            return null;
        }
    }

    /* renamed from: je */
    private static boolean m21153je(String str) {
        return str.toLowerCase().contains(".gif") && !dzO;
    }

    /* renamed from: a */
    public void mo31609a(GROUP_MEDIA_TYPE group_media_type) {
        this.mGroupType = group_media_type;
    }

    /* renamed from: a */
    public synchronized boolean mo31610a(Context context, MEDIA_TYPE media_type, BROWSE_TYPE browse_type) {
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        this.dzD = media_type;
        this.dzE = browse_type;
        switch (media_type) {
            case MEDIA_TYPE_FROM_XIAOYING:
                if (!this.dzA) {
                    z = m21144d(context, null, this.mMediaGroupMap);
                    break;
                } else {
                    z = m21140bS(context, null);
                    break;
                }
            case MEDIA_TYPE_FROM_MEDIASTORE:
                if (this.dzC != null) {
                    this.dzC.mo31596a(0, 0, 0, 1, null, null);
                }
                if (browse_type == BROWSE_TYPE.AUDIO) {
                    mo31609a(GROUP_MEDIA_TYPE.GROUP_MEDIA_TYPE_TITLE);
                }
                z = m21135a(context, (String) null, this.mMediaGroupMap, browse_type);
                break;
            default:
                return false;
        }
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("Init, cost:");
        sb.append(System.currentTimeMillis() - currentTimeMillis);
        LogUtils.m14222e(str, sb.toString());
        return z;
    }

    /* renamed from: a */
    public synchronized boolean mo31611a(Context context, MediaGroupItem mediaGroupItem) {
        return mo31612a(context, mediaGroupItem, -1);
    }

    /* renamed from: a */
    public synchronized boolean mo31612a(Context context, MediaGroupItem mediaGroupItem, int i) {
        if (mediaGroupItem != null) {
            if (mediaGroupItem.mediaItemList != null) {
                Iterator it = new ArrayList(mediaGroupItem.mediaItemList).iterator();
                while (it.hasNext()) {
                    ExtMediaItem extMediaItem = (ExtMediaItem) it.next();
                    if (!TextUtils.isEmpty(extMediaItem.path)) {
                        if (!extMediaItem.path.contains("/qqmusic/")) {
                            MediaGroupItem a = m21127a(this.mMediaGroupMap, extMediaItem);
                            if (a != null) {
                                extMediaItem.lGroupKey = a.lGroupTimestamp;
                                if (i < 0) {
                                    a.add(extMediaItem);
                                } else {
                                    a.add(extMediaItem, i);
                                }
                            }
                        }
                    }
                }
                this.dzD = MEDIA_TYPE.MEDIA_TYPE_FROM_MEDIASTORE;
                m21121K(this.mMediaGroupMap);
                return true;
            }
        }
        return false;
    }

    public MEDIA_TYPE awA() {
        return this.dzD;
    }

    public synchronized List<MediaGroupItem> awC() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        if (this.mMediaGroupMap != null && this.mMediaGroupMap.size() > 0) {
            awB();
            arrayList.addAll(this.mMediaGroupMap.values());
        }
        return arrayList;
    }

    public MediaGroupItem awy() {
        return dzx;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0033, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0035, code lost:
        return null;
     */
    /* renamed from: de */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.introvd.template.videoeditor.model.ExtMediaItem mo31616de(int r3, int r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.util.Map<java.lang.Long, com.introvd.template.videoeditor.model.MediaGroupItem> r0 = r2.mMediaGroupMap     // Catch:{ all -> 0x0036 }
            r1 = 0
            if (r0 == 0) goto L_0x0034
            if (r3 < 0) goto L_0x0034
            java.util.Map<java.lang.Long, com.introvd.template.videoeditor.model.MediaGroupItem> r0 = r2.mMediaGroupMap     // Catch:{ all -> 0x0036 }
            int r0 = r0.size()     // Catch:{ all -> 0x0036 }
            if (r3 >= r0) goto L_0x0034
            if (r4 >= 0) goto L_0x0013
            goto L_0x0034
        L_0x0013:
            com.introvd.template.videoeditor.model.MediaGroupItem r3 = r2.mo31620qE(r3)     // Catch:{ all -> 0x0036 }
            if (r3 == 0) goto L_0x0032
            java.util.ArrayList<com.introvd.template.videoeditor.model.ExtMediaItem> r0 = r3.mediaItemList     // Catch:{ all -> 0x0036 }
            if (r0 != 0) goto L_0x001e
            goto L_0x0032
        L_0x001e:
            java.util.ArrayList<com.introvd.template.videoeditor.model.ExtMediaItem> r0 = r3.mediaItemList     // Catch:{ all -> 0x0036 }
            int r0 = r0.size()     // Catch:{ all -> 0x0036 }
            if (r4 < r0) goto L_0x0028
            monitor-exit(r2)
            return r1
        L_0x0028:
            java.util.ArrayList<com.introvd.template.videoeditor.model.ExtMediaItem> r3 = r3.mediaItemList     // Catch:{ all -> 0x0036 }
            java.lang.Object r3 = r3.get(r4)     // Catch:{ all -> 0x0036 }
            com.introvd.template.videoeditor.model.ExtMediaItem r3 = (com.introvd.template.videoeditor.model.ExtMediaItem) r3     // Catch:{ all -> 0x0036 }
            monitor-exit(r2)
            return r3
        L_0x0032:
            monitor-exit(r2)
            return r1
        L_0x0034:
            monitor-exit(r2)
            return r1
        L_0x0036:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.explorer.p298c.C7149c.mo31616de(int, int):com.introvd.template.videoeditor.model.ExtMediaItem");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0022, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x003b, code lost:
        return -1;
     */
    /* renamed from: df */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int mo31617df(int r4, int r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.Map<java.lang.Long, com.introvd.template.videoeditor.model.MediaGroupItem> r0 = r3.mMediaGroupMap     // Catch:{ all -> 0x003c }
            r1 = -1
            if (r0 == 0) goto L_0x003a
            java.util.Map<java.lang.Long, com.introvd.template.videoeditor.model.MediaGroupItem> r0 = r3.mMediaGroupMap     // Catch:{ all -> 0x003c }
            int r0 = r0.size()     // Catch:{ all -> 0x003c }
            if (r4 < r0) goto L_0x000f
            goto L_0x003a
        L_0x000f:
            com.introvd.template.videoeditor.model.MediaGroupItem r0 = r3.mo31620qE(r4)     // Catch:{ all -> 0x003c }
            if (r0 == 0) goto L_0x0023
            java.util.ArrayList<com.introvd.template.videoeditor.model.ExtMediaItem> r2 = r0.mediaItemList     // Catch:{ all -> 0x003c }
            if (r2 == 0) goto L_0x0021
            java.util.ArrayList<com.introvd.template.videoeditor.model.ExtMediaItem> r0 = r0.mediaItemList     // Catch:{ all -> 0x003c }
            int r0 = r0.size()     // Catch:{ all -> 0x003c }
            if (r5 < r0) goto L_0x0023
        L_0x0021:
            monitor-exit(r3)
            return r1
        L_0x0023:
            r0 = 0
            r1 = 0
        L_0x0025:
            if (r0 >= r4) goto L_0x0037
            com.introvd.template.videoeditor.model.MediaGroupItem r2 = r3.mo31620qE(r0)     // Catch:{ all -> 0x003c }
            if (r2 == 0) goto L_0x0034
            java.util.ArrayList<com.introvd.template.videoeditor.model.ExtMediaItem> r2 = r2.mediaItemList     // Catch:{ all -> 0x003c }
            int r2 = r2.size()     // Catch:{ all -> 0x003c }
            int r1 = r1 + r2
        L_0x0034:
            int r0 = r0 + 1
            goto L_0x0025
        L_0x0037:
            int r1 = r1 + r5
            monitor-exit(r3)
            return r1
        L_0x003a:
            monitor-exit(r3)
            return r1
        L_0x003c:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.explorer.p298c.C7149c.mo31617df(int, int):int");
    }

    public synchronized int getGroupCount() {
        return this.mMediaGroupMap == null ? 0 : this.mMediaGroupMap.size();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x001c, code lost:
        return r1;
     */
    /* renamed from: qD */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int mo31619qD(int r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            java.util.Map<java.lang.Long, com.introvd.template.videoeditor.model.MediaGroupItem> r0 = r2.mMediaGroupMap     // Catch:{ all -> 0x001d }
            r1 = 0
            if (r0 != 0) goto L_0x0008
            monitor-exit(r2)
            return r1
        L_0x0008:
            com.introvd.template.videoeditor.model.MediaGroupItem r3 = r2.mo31620qE(r3)     // Catch:{ all -> 0x001d }
            if (r3 != 0) goto L_0x0010
            monitor-exit(r2)
            return r1
        L_0x0010:
            java.util.ArrayList<com.introvd.template.videoeditor.model.ExtMediaItem> r0 = r3.mediaItemList     // Catch:{ all -> 0x001d }
            if (r0 != 0) goto L_0x0015
            goto L_0x001b
        L_0x0015:
            java.util.ArrayList<com.introvd.template.videoeditor.model.ExtMediaItem> r3 = r3.mediaItemList     // Catch:{ all -> 0x001d }
            int r1 = r3.size()     // Catch:{ all -> 0x001d }
        L_0x001b:
            monitor-exit(r2)
            return r1
        L_0x001d:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.explorer.p298c.C7149c.mo31619qD(int):int");
    }

    /* renamed from: qE */
    public synchronized MediaGroupItem mo31620qE(int i) {
        if (this.mMediaGroupMap != null && i >= 0) {
            if (i < this.mMediaGroupMap.size()) {
                awB();
                return (MediaGroupItem) this.mMediaGroupMap.get(this.dzG[i]);
            }
        }
        return null;
    }

    public synchronized void unInit() {
        if (this.mMediaGroupMap != null) {
            this.mMediaGroupMap.clear();
        }
        this.dzD = MEDIA_TYPE.MEDIA_TYPE_NONE;
    }
}
