package com.introvd.template.explorer.p300e;

import com.introvd.template.common.CommonConfigure;
import com.introvd.template.common.StorageInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.introvd.template.explorer.e.c */
public class C7210c {
    public static List<String> axY() {
        String[] strArr;
        ArrayList arrayList = new ArrayList();
        for (String str : new String[]{StorageInfo.getMainStorage(), StorageInfo.getExtStorage()}) {
            if (str != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("/netease/cloudmusic/Music");
                arrayList.add(sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append("/kgmusic/download");
                arrayList.add(sb2.toString());
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append("/qqmusic/song");
                arrayList.add(sb3.toString());
                StringBuilder sb4 = new StringBuilder();
                sb4.append(str);
                sb4.append("/ttpod/song");
                arrayList.add(sb4.toString());
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str);
                sb5.append("/KuwoMusic/music");
                arrayList.add(sb5.toString());
                StringBuilder sb6 = new StringBuilder();
                sb6.append(str);
                sb6.append("/Baidu_music/download");
                arrayList.add(sb6.toString());
                StringBuilder sb7 = new StringBuilder();
                sb7.append(str);
                sb7.append("/doreso/music");
                arrayList.add(sb7.toString());
            }
        }
        return arrayList;
    }

    public static List<String> axZ() {
        String[] strArr;
        ArrayList arrayList = new ArrayList();
        for (String str : new String[]{StorageInfo.getMainStorage(), StorageInfo.getExtStorage()}) {
            if (str != null) {
                String str2 = CommonConfigure.CAMERA_VIDEO_RELATIVE_PATH;
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(File.separator);
                sb.append(str2);
                arrayList.add(sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append("/Vlook/camera/");
                arrayList.add(sb2.toString());
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append("/Android/data/com.yixia.videoeditor/");
                arrayList.add(sb3.toString());
                StringBuilder sb4 = new StringBuilder();
                sb4.append(str);
                sb4.append("/Android/data/com.tencent.weishi/");
                arrayList.add(sb4.toString());
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str);
                sb5.append("/Android/data/com.tudou.android/");
                arrayList.add(sb5.toString());
                StringBuilder sb6 = new StringBuilder();
                sb6.append(str);
                sb6.append("/tencent/MicroMsg/");
                arrayList.add(sb6.toString());
                StringBuilder sb7 = new StringBuilder();
                sb7.append(str);
                sb7.append("/DCIM/");
                arrayList.add(sb7.toString());
                StringBuilder sb8 = new StringBuilder();
                sb8.append(str);
                sb8.append("/gifshow/.cache/");
                arrayList.add(sb8.toString());
                StringBuilder sb9 = new StringBuilder();
                sb9.append(str);
                sb9.append("/gifshow/");
                arrayList.add(sb9.toString());
                StringBuilder sb10 = new StringBuilder();
                sb10.append(str);
                sb10.append("/weishi/videos/");
                arrayList.add(sb10.toString());
                StringBuilder sb11 = new StringBuilder();
                sb11.append(str);
                sb11.append("/youku/paike/");
                arrayList.add(sb11.toString());
                StringBuilder sb12 = new StringBuilder();
                sb12.append(str);
                sb12.append("/tudou/Video/");
                arrayList.add(sb12.toString());
                StringBuilder sb13 = new StringBuilder();
                sb13.append(str);
                sb13.append("/QIYIVideo/");
                arrayList.add(sb13.toString());
            }
        }
        return arrayList;
    }

    public static List<String> aya() {
        String[] strArr;
        ArrayList arrayList = new ArrayList();
        for (String str : new String[]{StorageInfo.getMainStorage(), StorageInfo.getExtStorage()}) {
            if (str != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("/DCIM/");
                arrayList.add(sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append("/MTXX/");
                arrayList.add(sb2.toString());
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append("/photowonder/");
                arrayList.add(sb3.toString());
                StringBuilder sb4 = new StringBuilder();
                sb4.append(str);
                sb4.append("/MomanCamera/MomentCam_Drawing/");
                arrayList.add(sb4.toString());
            }
        }
        return arrayList;
    }

    /* renamed from: bV */
    public static List<String> m21293bV(List<String> list) {
        String[] strArr;
        ArrayList arrayList = new ArrayList();
        for (String str : new String[]{StorageInfo.getMainStorage(), StorageInfo.getExtStorage()}) {
            if (str != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("/DCIM/");
                if (!list.contains(sb.toString())) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str);
                    sb2.append("/DCIM/");
                    arrayList.add(sb2.toString());
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append("/MTXX/");
                if (!list.contains(sb3.toString())) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append(str);
                    sb4.append("/MTXX/");
                    arrayList.add(sb4.toString());
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str);
                sb5.append("/photowonder/");
                if (!list.contains(sb5.toString())) {
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(str);
                    sb6.append("/photowonder/");
                    arrayList.add(sb6.toString());
                }
                StringBuilder sb7 = new StringBuilder();
                sb7.append(str);
                sb7.append("/MomanCamera/MomentCam_Drawing/");
                if (!list.contains(sb7.toString())) {
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append(str);
                    sb8.append("/MomanCamera/MomentCam_Drawing/");
                    arrayList.add(sb8.toString());
                }
            }
        }
        return arrayList;
    }
}
