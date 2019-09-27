package com.introvd.template.camera.p232e;

import android.text.TextUtils;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.router.explorer.MusicDataItem;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.introvd.template.camera.e.a */
public class C5029a {
    /* renamed from: a */
    public static String m13198a(String str, MusicDataItem musicDataItem) {
        String str2;
        if (!TextUtils.isEmpty(m13200fi(str).filePath)) {
            str = "";
        }
        String str3 = "";
        if (musicDataItem == null) {
            return str3;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("music_file_path", musicDataItem.filePath);
            jSONObject.put("music_title", musicDataItem.title);
            jSONObject.put("music_start_timestamp", musicDataItem.startTimeStamp);
            jSONObject.put("music_stop_timestamp", musicDataItem.stopTimeStamp);
            jSONObject.put("music_current_timestamp", musicDataItem.currentTimeStamp);
            JSONObject jSONObject2 = TextUtils.isEmpty(str) ? new JSONObject() : new JSONObject(str);
            jSONObject2.put("music", jSONObject);
            str2 = jSONObject2.toString();
        } catch (Exception unused) {
            str2 = str3;
        }
        return str2;
    }

    /* renamed from: fh */
    public static MusicDataItem m13199fh(String str) {
        MusicDataItem fi = m13200fi(str);
        if (!TextUtils.isEmpty(fi.filePath)) {
            return fi;
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("music");
            if (optJSONObject != null) {
                fi.filePath = optJSONObject.getString("music_file_path");
                fi.title = optJSONObject.getString("music_title");
                fi.startTimeStamp = optJSONObject.getInt("music_start_timestamp");
                fi.stopTimeStamp = optJSONObject.getInt("music_stop_timestamp");
                fi.currentTimeStamp = optJSONObject.getInt("music_current_timestamp");
                StringBuilder sb = new StringBuilder();
                sb.append("item.filePath ");
                sb.append(fi.filePath);
                LogUtilsV2.m14230i(sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("item.title ");
                sb2.append(fi.title);
                LogUtilsV2.m14230i(sb2.toString());
                StringBuilder sb3 = new StringBuilder();
                sb3.append("item.startTimeStamp ");
                sb3.append(fi.startTimeStamp);
                LogUtilsV2.m14230i(sb3.toString());
                StringBuilder sb4 = new StringBuilder();
                sb4.append("item.stopTimeStamp ");
                sb4.append(fi.stopTimeStamp);
                LogUtilsV2.m14230i(sb4.toString());
                StringBuilder sb5 = new StringBuilder();
                sb5.append("item.currentTimeStamp ");
                sb5.append(fi.currentTimeStamp);
                LogUtilsV2.m14230i(sb5.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fi;
    }

    /* renamed from: fi */
    private static MusicDataItem m13200fi(String str) {
        MusicDataItem musicDataItem = new MusicDataItem();
        try {
            JSONObject jSONObject = new JSONArray(str).getJSONObject(0);
            musicDataItem.filePath = jSONObject.getString("music_file_path");
            musicDataItem.title = jSONObject.getString("music_title");
            musicDataItem.startTimeStamp = jSONObject.getInt("music_start_timestamp");
            musicDataItem.stopTimeStamp = jSONObject.getInt("music_stop_timestamp");
            musicDataItem.currentTimeStamp = jSONObject.getInt("music_current_timestamp");
            StringBuilder sb = new StringBuilder();
            sb.append("item.filePath ");
            sb.append(musicDataItem.filePath);
            LogUtilsV2.m14230i(sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("item.title ");
            sb2.append(musicDataItem.title);
            LogUtilsV2.m14230i(sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("item.startTimeStamp ");
            sb3.append(musicDataItem.startTimeStamp);
            LogUtilsV2.m14230i(sb3.toString());
            StringBuilder sb4 = new StringBuilder();
            sb4.append("item.stopTimeStamp ");
            sb4.append(musicDataItem.stopTimeStamp);
            LogUtilsV2.m14230i(sb4.toString());
            StringBuilder sb5 = new StringBuilder();
            sb5.append("item.currentTimeStamp ");
            sb5.append(musicDataItem.currentTimeStamp);
            LogUtilsV2.m14230i(sb5.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return musicDataItem;
    }
}
