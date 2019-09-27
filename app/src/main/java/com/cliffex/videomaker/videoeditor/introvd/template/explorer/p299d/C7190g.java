package com.introvd.template.explorer.p299d;

import android.content.Context;
import android.text.TextUtils;
import com.eiii.AccessToken;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.sns.MediaType;
import com.introvd.template.sns.SnsType;
import com.introvd.template.videoeditor.model.ExtMediaItem;
import com.introvd.template.videoeditor.model.MediaGroupItem;
import com.quvideo.auth.instagram.sns.C4743c;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.introvd.template.explorer.d.g */
public class C7190g {
    /* renamed from: a */
    public static List<MediaGroupItem> m21247a(JSONArray jSONArray, String str, List<MediaGroupItem> list, boolean z, boolean z2) throws JSONException {
        JSONArray jSONArray2 = jSONArray;
        ArrayList<ExtMediaItem> arrayList = null;
        MediaGroupItem mediaGroupItem = null;
        ArrayList<ExtMediaItem> arrayList2 = null;
        MediaGroupItem mediaGroupItem2 = null;
        for (MediaGroupItem mediaGroupItem3 : list) {
            if ("pictures".equals(mediaGroupItem3.strGroupDisplayName)) {
                arrayList = mediaGroupItem3.mediaItemList;
                mediaGroupItem = mediaGroupItem3;
            } else if ("videos".equals(mediaGroupItem3.strGroupDisplayName)) {
                arrayList2 = mediaGroupItem3.mediaItemList;
                mediaGroupItem2 = mediaGroupItem3;
            }
        }
        if (jSONArray2 != null && jSONArray.length() > 0) {
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray2.getJSONObject(i);
                String optString = jSONObject.optString("id");
                String optString2 = jSONObject.optString("type");
                String optString3 = jSONObject.optJSONObject("user").optString("username");
                String optString4 = jSONObject.optString("created_time");
                JSONObject optJSONObject = jSONObject.optJSONObject("images");
                JSONObject optJSONObject2 = jSONObject.optJSONObject("videos");
                ExtMediaItem extMediaItem = new ExtMediaItem();
                extMediaItem.title = optString;
                extMediaItem.artist = optString3;
                extMediaItem.date = Long.valueOf(optString4).longValue() * 1000;
                extMediaItem.album = str != null ? str : "0";
                extMediaItem.lFlag = 0;
                extMediaItem.snsType = SnsType.SNS_TYPE_INSTAGRAM;
                if (z2 && "image".equals(optString2) && optJSONObject != null) {
                    JSONObject optJSONObject3 = optJSONObject.optJSONObject("standard_resolution");
                    String optString5 = optJSONObject3.optString("url");
                    StringBuilder sb = new StringBuilder(optJSONObject3.optString("width"));
                    sb.append("*");
                    sb.append(optJSONObject3.optString("height"));
                    String sb2 = sb.toString();
                    String optString6 = optJSONObject.optJSONObject(SocialConstDef.PROJECT_THUMBNAIL).optString("url");
                    extMediaItem.path = optString5;
                    extMediaItem.resolution = sb2;
                    extMediaItem.thumbUrl = optString6;
                    extMediaItem.mediaType = MediaType.MEDIA_TYPE_IMAGE;
                    extMediaItem.snsType = SnsType.SNS_TYPE_INSTAGRAM;
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    }
                    arrayList.add(extMediaItem);
                } else if (z && "video".equals(optString2) && optJSONObject2 != null) {
                    JSONObject optJSONObject4 = optJSONObject2.optJSONObject("standard_resolution");
                    String optString7 = optJSONObject4.optString("url");
                    StringBuilder sb3 = new StringBuilder(optJSONObject4.optString("width"));
                    sb3.append("*");
                    sb3.append(optJSONObject4.optString("height"));
                    String sb4 = sb3.toString();
                    JSONObject optJSONObject5 = optJSONObject != null ? optJSONObject.optJSONObject(SocialConstDef.PROJECT_THUMBNAIL) : null;
                    String optString8 = optJSONObject5 != null ? optJSONObject5.optString("url") : null;
                    extMediaItem.path = optString7;
                    extMediaItem.resolution = sb4;
                    extMediaItem.thumbUrl = optString8;
                    extMediaItem.mediaType = MediaType.MEDIA_TYPE_VIDEO;
                    extMediaItem.snsType = SnsType.SNS_TYPE_INSTAGRAM;
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList<>();
                    }
                    arrayList2.add(extMediaItem);
                }
            }
        }
        if (arrayList != null && arrayList.size() > 0) {
            if (mediaGroupItem == null) {
                mediaGroupItem = new MediaGroupItem();
            }
            mediaGroupItem.strGroupDisplayName = "pictures";
            mediaGroupItem.strParentPath = "/net";
            mediaGroupItem.countForSns = arrayList.size();
            mediaGroupItem.mediaType = MediaType.MEDIA_TYPE_IMAGE;
            mediaGroupItem.mediaItemList = new ArrayList<>(arrayList);
        }
        if (arrayList2 != null && arrayList2.size() > 0) {
            if (mediaGroupItem2 == null) {
                mediaGroupItem2 = new MediaGroupItem();
            }
            mediaGroupItem2.strGroupDisplayName = "videos";
            mediaGroupItem2.strParentPath = "/net";
            mediaGroupItem2.countForSns = arrayList2.size();
            mediaGroupItem2.mediaType = MediaType.MEDIA_TYPE_VIDEO;
            mediaGroupItem2.mediaItemList = new ArrayList<>(arrayList2);
        }
        List<MediaGroupItem> arrayList3 = list == null ? new ArrayList<>() : list;
        if (mediaGroupItem2 != null && !arrayList3.contains(mediaGroupItem2)) {
            arrayList3.add(mediaGroupItem2);
        }
        if (mediaGroupItem != null && !arrayList3.contains(mediaGroupItem)) {
            arrayList3.add(mediaGroupItem);
        }
        return arrayList3;
    }

    /* renamed from: a */
    public static void m21248a(Context context, boolean z, int i, C7188e eVar, boolean z2) {
        if (z) {
            if (eVar == null || TextUtils.isEmpty(eVar.userName) || TextUtils.isEmpty(eVar.userId)) {
                eVar = m21250af(context, i);
            }
            eVar.dDA = z2;
            C7189f.m21245a(context, eVar, i);
        }
    }

    /* renamed from: ae */
    public static boolean m21249ae(Context context, int i) {
        C7188e af = m21250af(context, i);
        String str = af.userId;
        C7188e ad = C7189f.m21246ad(context, i);
        boolean z = !ad.userId.equals(str) || !ad.dDA || ((System.currentTimeMillis() - ad.lastUpdateTime) / 1000) / 60 >= 30;
        m21248a(context, z, i, af, ad.dDA);
        return z;
    }

    /* renamed from: af */
    private static C7188e m21250af(Context context, int i) {
        String str;
        String str2 = null;
        if (i == 28) {
            AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
            if (currentAccessToken != null) {
                str2 = currentAccessToken.getUserId();
                str = currentAccessToken.getUserId();
                return new C7188e(str, str2);
            }
        } else if (i == 31) {
            C4743c cVar = new C4743c(context);
            str2 = cVar.getId();
            str = cVar.getName();
            return new C7188e(str, str2);
        }
        str = null;
        return new C7188e(str, str2);
    }

    /* renamed from: b */
    public static String m21251b(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            return jSONObject.has(str) ? jSONObject.optString(str) : "";
        }
        return null;
    }

    /* renamed from: c */
    public static JSONObject m21252c(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            return jSONObject.has(str) ? jSONObject.optJSONObject(str) : new JSONObject();
        }
        return null;
    }
}
