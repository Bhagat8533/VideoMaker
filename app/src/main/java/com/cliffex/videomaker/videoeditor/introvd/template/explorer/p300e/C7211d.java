package com.introvd.template.explorer.p300e;

import android.os.Environment;
import com.introvd.template.common.CommonConfigure;
import com.introvd.template.common.StorageInfo;
import com.introvd.template.vivaexplorermodule.R;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.introvd.template.explorer.e.d */
public class C7211d {
    private static Map<String, Integer> dEw;

    public static Map<String, Integer> ayb() {
        if (dEw == null) {
            ayc();
        }
        return dEw;
    }

    private static void ayc() {
        String[] strArr;
        dEw = new HashMap();
        StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).toString());
        sb.append(File.separator);
        sb.append("Camera/");
        dEw.put(sb.toString(), Integer.valueOf(R.string.xiaoying_str_com_camera_title));
        for (String str : new String[]{StorageInfo.getMainStorage(), StorageInfo.getExtStorage()}) {
            if (str != null) {
                String str2 = CommonConfigure.CAMERA_VIDEO_RELATIVE_PATH;
                Map<String, Integer> map = dEw;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(File.separator);
                sb2.append(str2);
                map.put(sb2.toString(), Integer.valueOf(R.string.xiaoying_str_cam_xiaoying_camera_record_path_name));
                Map<String, Integer> map2 = dEw;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append("/Vlook/camera/");
                map2.put(sb3.toString(), Integer.valueOf(R.string.xiaoying_str_com_vlook_video_path_name_notrans));
                Map<String, Integer> map3 = dEw;
                StringBuilder sb4 = new StringBuilder();
                sb4.append(str);
                sb4.append("/Android/data/com.yixia.videoeditor/");
                map3.put(sb4.toString(), Integer.valueOf(R.string.xiaoying_str_com_miaopai_video_path_name_notrans));
                Map<String, Integer> map4 = dEw;
                StringBuilder sb5 = new StringBuilder();
                sb5.append(str);
                sb5.append("/Android/data/com.tencent.weishi/");
                map4.put(sb5.toString(), Integer.valueOf(R.string.xiaoying_str_com_weishi_video_path_name_notrans));
                Map<String, Integer> map5 = dEw;
                StringBuilder sb6 = new StringBuilder();
                sb6.append(str);
                sb6.append("/Android/data/com.tudou.android/");
                map5.put(sb6.toString(), Integer.valueOf(R.string.xiaoying_str_com_tudou_video_path_name_notrans));
                Map<String, Integer> map6 = dEw;
                StringBuilder sb7 = new StringBuilder();
                sb7.append(str);
                sb7.append("/tencent/MicroMsg/");
                map6.put(sb7.toString(), Integer.valueOf(R.string.xiaoying_str_com_wechat_video_path_name_notrans));
                Map<String, Integer> map7 = dEw;
                StringBuilder sb8 = new StringBuilder();
                sb8.append(str);
                sb8.append("/DCIM/XiaoYing/");
                map7.put(sb8.toString(), Integer.valueOf(R.string.xiaoying_str_com_myxiaoying_path_name));
                Map<String, Integer> map8 = dEw;
                StringBuilder sb9 = new StringBuilder();
                sb9.append(str);
                sb9.append("/DCIM/StarVideo/");
                map8.put(sb9.toString(), Integer.valueOf(R.string.xiaoying_str_com_myxiaoying_path_name));
                Map<String, Integer> map9 = dEw;
                StringBuilder sb10 = new StringBuilder();
                sb10.append(str);
                sb10.append("/gifshow/.cache/");
                map9.put(sb10.toString(), Integer.valueOf(R.string.xiaoying_str_com_gifshow_video_path_name_notrans));
                Map<String, Integer> map10 = dEw;
                StringBuilder sb11 = new StringBuilder();
                sb11.append(str);
                sb11.append("/gifshow/");
                map10.put(sb11.toString(), Integer.valueOf(R.string.xiaoying_str_com_gifshow_video_path_name_notrans));
                Map<String, Integer> map11 = dEw;
                StringBuilder sb12 = new StringBuilder();
                sb12.append(str);
                sb12.append("/weishi/videos/");
                map11.put(sb12.toString(), Integer.valueOf(R.string.xiaoying_str_com_weishi_video_path_name_notrans));
                Map<String, Integer> map12 = dEw;
                StringBuilder sb13 = new StringBuilder();
                sb13.append(str);
                sb13.append("/youku/paike/");
                map12.put(sb13.toString(), Integer.valueOf(R.string.xiaoying_str_com_youkupaike_video_path_name_notrans));
                Map<String, Integer> map13 = dEw;
                StringBuilder sb14 = new StringBuilder();
                sb14.append(str);
                sb14.append("/tudou/Video/");
                map13.put(sb14.toString(), Integer.valueOf(R.string.xiaoying_str_com_tudou_video_path_name_notrans));
                Map<String, Integer> map14 = dEw;
                StringBuilder sb15 = new StringBuilder();
                sb15.append(str);
                sb15.append("/QIYIVideo/");
                map14.put(sb15.toString(), Integer.valueOf(R.string.xiaoying_str_com_iqiyi_video_path_name_notrans));
                Map<String, Integer> map15 = dEw;
                StringBuilder sb16 = new StringBuilder();
                sb16.append(str);
                sb16.append("/MTXX/");
                map15.put(sb16.toString(), Integer.valueOf(R.string.xiaoying_str_com_meituxx_camera_path_name_notrans));
                Map<String, Integer> map16 = dEw;
                StringBuilder sb17 = new StringBuilder();
                sb17.append(str);
                sb17.append("/photowonder/");
                map16.put(sb17.toString(), Integer.valueOf(R.string.xiaoying_str_com_photowonder_camera_path_name_notrans));
                Map<String, Integer> map17 = dEw;
                StringBuilder sb18 = new StringBuilder();
                sb18.append(str);
                sb18.append("/MomanCamera/MomentCam_Drawing/");
                map17.put(sb18.toString(), Integer.valueOf(R.string.xiaoying_str_com_momentcam_camera_path_name_notrans));
            }
        }
    }
}
