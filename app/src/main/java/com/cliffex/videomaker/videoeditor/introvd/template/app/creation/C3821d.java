package com.introvd.template.app.creation;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.aiii.android.arouter.p091c.C1919a;
import com.introvd.template.R;
import com.introvd.template.ads.AdParamMgr;
import com.introvd.template.app.creation.C3819c.C3820a;
import com.introvd.template.app.homepage.AppModelConfigInfo;
import com.introvd.template.app.homepage.C3935b;
import com.introvd.template.app.p177b.C3742b;
import com.introvd.template.app.p190j.C4023a;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.common.p236ui.modechooser.ModeItemInfo;
import com.introvd.template.common.p236ui.modechooser.ModeItemInfo.AdItemInfo;
import com.introvd.template.common.p236ui.modechooser.ModeItemInfo.VideoInfo;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.app.IAppService;
import com.introvd.template.router.community.ICommunityAPI;
import com.introvd.template.router.todoCode.TodoConstants;
import com.p131c.p132a.p135c.C2575a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.introvd.template.app.creation.d */
public class C3821d {
    private Map<Integer, C3819c> boC = new HashMap();
    private ArrayList<ModeItemInfo> boD = new ArrayList<>();

    public C3821d() {
        m9368Ky();
    }

    /* renamed from: Kx */
    private ModeItemInfo m9367Kx() {
        ModeItemInfo modeItemInfo = new ModeItemInfo();
        modeItemInfo.setModeType(101);
        return modeItemInfo;
    }

    /* renamed from: Ky */
    private void m9368Ky() {
        if (C3742b.m9111II().mo23170Jq()) {
            this.boC.put(Integer.valueOf(408), new C3820a().mo23307gv(R.string.xiaoying_str_com_home_edit_photo).mo23308gw(C4023a.m9973MK().mo23677MP() ? R.drawable.app_icon_creation_main_tool_mv : R.drawable.editor_icon_maintool_mv).mo23305Kk());
            this.boC.put(Integer.valueOf(TodoConstants.TODO_TYPE_CAMERA_MODE_HD6), new C3820a().mo23307gv(R.string.xiaoying_str_com_home_new_video).mo23308gw(R.drawable.editor_icon_subtool_camera).mo23305Kk());
        } else {
            this.boC.put(Integer.valueOf(TodoConstants.TODO_TYPE_CAMERA_MODE_HD6), new C3820a().mo23307gv(R.string.xiaoying_str_com_home_new_video).mo23308gw(R.drawable.vivavideo_create_captur).mo23305Kk());
            this.boC.put(Integer.valueOf(408), new C3820a().mo23307gv(R.string.xiaoying_str_com_home_edit_photo).mo23308gw(R.drawable.vivavideo_tool_mv).mo23305Kk());
        }
        this.boC.put(Integer.valueOf(401), new C3820a().mo23307gv(R.string.xiaoying_str_com_home_edit_video).mo23308gw(C4023a.m9973MK().mo23677MP() ? R.drawable.app_icon_creation_main_tool_edit : R.drawable.vivavideo_create_edit).mo23305Kk());
        this.boC.put(Integer.valueOf(409), new C3820a().mo23307gv(R.string.xiaoying_str_com_home_edit_pip).mo23308gw(R.drawable.vivavideo_tool_pip).mo23305Kk());
        this.boC.put(Integer.valueOf(TodoConstants.TODO_TYPE_CAMERA_MODE_FB6), new C3820a().mo23307gv(R.string.xiaoying_str_com_home_edit_fb_camera).mo23308gw(R.drawable.vivavideo_tool_beauty).mo23306dp(m9369Kz()).mo23305Kk());
        this.boC.put(Integer.valueOf(TodoConstants.TODO_TYPE_CAMERA_MODE_MV6), new C3820a().mo23307gv(R.string.xiaoying_str_cam_camera_mode_mv).mo23308gw(R.drawable.vivavideo_tool_music).mo23305Kk());
        this.boC.put(Integer.valueOf(605), new C3820a().mo23307gv(R.string.xiaoying_str_template_title).mo23308gw(R.drawable.vivavideo_tool_effect).mo23305Kk());
    }

    /* renamed from: Kz */
    private String m9369Kz() {
        return "{\"cameraSwap\":\"front\",\"cameraRatio\":\"full\",\"stikerGroupCode\":\"default\"}";
    }

    /* renamed from: O */
    private void m9370O(List<ModeItemInfo> list) {
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                m9375f(i, list);
            }
        }
    }

    /* renamed from: b */
    public static ModeItemInfo m9371b(AppModelConfigInfo appModelConfigInfo) {
        ModeItemInfo modeItemInfo = new ModeItemInfo();
        modeItemInfo.itemName = appModelConfigInfo.title;
        modeItemInfo.itemImgUrl = appModelConfigInfo.content;
        modeItemInfo.itemImgBackupRes = Integer.valueOf(-1);
        modeItemInfo.setModeType(1);
        modeItemInfo.todoCode = appModelConfigInfo.eventType;
        modeItemInfo.todoParameter = appModelConfigInfo.eventContent;
        if (appModelConfigInfo.extendInfo != null) {
            modeItemInfo.textColor = appModelConfigInfo.extendInfo.textColor;
            modeItemInfo.bgStartColor = appModelConfigInfo.extendInfo.bgStartColor;
            modeItemInfo.bgEndColor = appModelConfigInfo.extendInfo.bgEndColor;
        }
        return modeItemInfo;
    }

    /* renamed from: b */
    private boolean m9372b(List<ModeItemInfo> list, int i) {
        boolean z = false;
        if (list == null || list.size() <= i || i == 0 || list.size() - 1 == i) {
            return false;
        }
        ModeItemInfo modeItemInfo = (ModeItemInfo) list.get(i - 1);
        ModeItemInfo modeItemInfo2 = (ModeItemInfo) list.get(i + 1);
        if (modeItemInfo != null && modeItemInfo2 != null && modeItemInfo.isVideoItem() && modeItemInfo2.isVideoItem()) {
            z = true;
        }
        return z;
    }

    /* renamed from: dq */
    private int m9373dq(String str) {
        return C2575a.parseInt(str);
    }

    /* renamed from: dr */
    public static VideoInfo m9374dr(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            VideoInfo videoInfo = new VideoInfo();
            videoInfo.mCoverUrl = jSONObject.optString("coverurl");
            videoInfo.mFileUrl = jSONObject.optString("fileurl");
            videoInfo.mHeight = jSONObject.optInt("height");
            videoInfo.mWidth = jSONObject.optInt("width");
            videoInfo.mStrPubTime = jSONObject.optString("");
            videoInfo.puid = jSONObject.optString("puid");
            videoInfo.mVer = jSONObject.optInt("ver");
            videoInfo.mVideoPlayUrl = jSONObject.optString("playpageurl");
            return videoInfo;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: f */
    private void m9375f(int i, List<ModeItemInfo> list) {
        if (list != null && list.size() > i) {
            ModeItemInfo modeItemInfo = (ModeItemInfo) list.get(i);
            if (modeItemInfo != null && modeItemInfo.isVideoItem()) {
                boolean z = true;
                if (i == 0) {
                    modeItemInfo.isVideoListStart = true;
                    int i2 = i + 1;
                    if (list.size() > i2) {
                        z = true ^ ((ModeItemInfo) list.get(i2)).isVideoItem();
                    }
                    modeItemInfo.isVideoListEnd = z;
                } else if (i == list.size() - 1) {
                    modeItemInfo.isVideoListEnd = true;
                    modeItemInfo.isVideoListStart = !((ModeItemInfo) list.get(i - 1)).isVideoItem();
                } else {
                    int i3 = i - 1;
                    ModeItemInfo modeItemInfo2 = (ModeItemInfo) list.get(i + 1);
                    modeItemInfo.isVideoListStart = !((ModeItemInfo) list.get(i3)).isVideoItem();
                    modeItemInfo.isVideoListEnd = !modeItemInfo2.isVideoItem();
                }
            }
        }
    }

    /* renamed from: gx */
    private ModeItemInfo m9376gx(int i) {
        ModeItemInfo modeItemInfo = new ModeItemInfo();
        if (i == 910) {
            modeItemInfo.itemId = 0;
            modeItemInfo.setModeType(1);
            modeItemInfo.todoCode = TodoConstants.TODO_TYPE_SHOW_SHUFFLE_ADS;
            modeItemInfo.itemNameBackupRes = R.string.xiaoying_str_com_ads_shuffle;
            modeItemInfo.itemImgBackupRes = Integer.valueOf(R.drawable.vivavideo_tool_shuffle);
            modeItemInfo.isNew = false;
        } else {
            if (i == 401) {
                modeItemInfo.rawId = 0;
            }
            if (i == 216) {
                modeItemInfo.rawId = 1;
            }
            if (i == 408) {
                modeItemInfo.rawId = 2;
            }
            modeItemInfo.setModeType(1);
            modeItemInfo.todoCode = i;
            C3819c cVar = (C3819c) this.boC.get(Integer.valueOf(i));
            if (cVar != null) {
                modeItemInfo.itemImgBackupRes = Integer.valueOf(cVar.mo23303Ki());
                modeItemInfo.itemNameBackupRes = cVar.mo23302Kh();
                if (i == 215) {
                    modeItemInfo.todoParameter = cVar.mo23304Kj();
                }
            }
        }
        return modeItemInfo;
    }

    /* renamed from: i */
    private ModeItemInfo m9377i(Cursor cursor) {
        ModeItemInfo modeItemInfo = new ModeItemInfo();
        modeItemInfo.rawId = cursor.getInt(cursor.getColumnIndex(SocialConstDef.DYNAMIC_FEATURE_RAW_ID));
        modeItemInfo.itemId = cursor.getInt(cursor.getColumnIndex("orderno"));
        modeItemInfo.setModeType(cursor.getInt(cursor.getColumnIndex("type")));
        modeItemInfo.title = cursor.getString(cursor.getColumnIndex("title"));
        int i = cursor.getInt(cursor.getColumnIndex("modelcode"));
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(i);
        modeItemInfo.mParentModelCode = sb.toString();
        modeItemInfo.mViewType = cursor.getInt(cursor.getColumnIndex(SocialConstDef.DYNAMIC_FEATURE_VIEWTYPE));
        try {
            JSONObject jSONObject = new JSONObject(cursor.getString(cursor.getColumnIndex(SocialConstDef.DYNAMIC_FEATURE_OBJ)));
            if (modeItemInfo.getModeType() != 3) {
                if (modeItemInfo.getModeType() != 1) {
                    if (modeItemInfo.getModeType() == 4 || modeItemInfo.getModeType() == 21 || modeItemInfo.getModeType() == 22 || modeItemInfo.getModeType() == 23) {
                        modeItemInfo.adCount = jSONObject.optInt("total", -1);
                        if (modeItemInfo.adCount <= 0) {
                            return null;
                        }
                        JSONArray jSONArray = jSONObject.getJSONArray(SocialServiceDef.API_RESPONSE_DYNAMIC_FEATURE_LIST_OBJ_DOT_ADS_ADS_DOT);
                        modeItemInfo.adItemInfoList = new ArrayList<>();
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            JSONObject jSONObject2 = (JSONObject) jSONArray.get(i2);
                            AdItemInfo adItemInfo = new AdItemInfo();
                            adItemInfo.adImgUrl = jSONObject2.optString("image");
                            adItemInfo.adName = jSONObject2.optString("name");
                            adItemInfo.duration = jSONObject2.optInt("duration", 0);
                            adItemInfo.startTime = jSONObject2.optString("starttime");
                            adItemInfo.expireTime = jSONObject2.optString("expiretime");
                            adItemInfo.modelCode = jSONObject2.optString("modelcode");
                            adItemInfo.modelContent = jSONObject2.optString("modelcontent");
                            adItemInfo.description = jSONObject2.optString("discription");
                            if (jSONObject2.has("event")) {
                                JSONObject jSONObject3 = new JSONObject(jSONObject2.optString("event"));
                                adItemInfo.adTodoCode = jSONObject3.optInt("code", -1);
                                if (jSONObject3.has("parameter")) {
                                    adItemInfo.adTodoParameter = jSONObject3.optString("parameter");
                                    if (adItemInfo.adTodoCode == 901) {
                                        adItemInfo.mVideoInfo = m9374dr(adItemInfo.adTodoParameter);
                                    }
                                }
                            }
                            if (adItemInfo.mVideoInfo != null) {
                                adItemInfo.mVideoInfo.mStrPubTime = jSONObject2.optString("starttime");
                                adItemInfo.mVideoInfo.mViewCount = adItemInfo.mVideoInfo.getViewCount();
                                adItemInfo.mVideoInfo.mLikeCount = adItemInfo.mVideoInfo.getLikeCount();
                                adItemInfo.mVideoInfo.mDesc = adItemInfo.description;
                                adItemInfo.mVideoInfo.mTitle = adItemInfo.adName;
                            }
                            if (TextUtils.isEmpty(adItemInfo.adImgUrl) && adItemInfo.mVideoInfo != null) {
                                adItemInfo.adImgUrl = adItemInfo.mVideoInfo.mCoverUrl;
                            }
                            modeItemInfo.adItemInfoList.add(adItemInfo);
                        }
                        if (modeItemInfo.getModeType() == 3) {
                            modeItemInfo.expirationMillis = 7200000;
                        }
                    }
                    return modeItemInfo;
                }
            }
            String optString = jSONObject.optString("event");
            modeItemInfo.modelContent = jSONObject.optString("modelcontent");
            modeItemInfo.description = jSONObject.optString("discription");
            C3819c cVar = (C3819c) this.boC.get(Integer.valueOf(modeItemInfo.todoCode));
            if (cVar != null) {
                modeItemInfo.itemImgBackupRes = Integer.valueOf(cVar.mo23303Ki());
            }
            modeItemInfo.modelCode = jSONObject.optString("modelcode");
            if (!TextUtils.isEmpty(optString)) {
                JSONObject jSONObject4 = new JSONObject(optString);
                modeItemInfo.todoCode = jSONObject4.optInt("code", -1);
                if (jSONObject4.has("parameter")) {
                    modeItemInfo.todoParameter = jSONObject4.optString("parameter");
                    if (modeItemInfo.todoCode == 901) {
                        modeItemInfo.mVideoInfo = m9374dr(modeItemInfo.todoParameter);
                        String optString2 = jSONObject4.optString("event");
                        if (!TextUtils.isEmpty(optString2)) {
                            JSONObject jSONObject5 = new JSONObject(optString2);
                            modeItemInfo.todoCode = jSONObject5.optInt("code", -1);
                            modeItemInfo.todoParameter = jSONObject5.optString("parameter", "");
                        }
                    }
                }
            }
            if (modeItemInfo.mVideoInfo != null) {
                modeItemInfo.mVideoInfo.mStrPubTime = jSONObject.optString("starttime");
                modeItemInfo.mVideoInfo.mViewCount = modeItemInfo.mVideoInfo.getViewCount();
                modeItemInfo.mVideoInfo.mLikeCount = modeItemInfo.mVideoInfo.getLikeCount();
                modeItemInfo.mVideoInfo.mDesc = modeItemInfo.description;
                modeItemInfo.mVideoInfo.mTitle = modeItemInfo.title;
            }
            modeItemInfo.itemImgUrl = jSONObject.optString("image");
            if (TextUtils.isEmpty(modeItemInfo.itemImgUrl) && modeItemInfo.mVideoInfo != null) {
                modeItemInfo.itemImgUrl = modeItemInfo.mVideoInfo.mCoverUrl;
            }
            modeItemInfo.itemName = jSONObject.optString("name");
            if (TextUtils.isEmpty(modeItemInfo.itemName) && TextUtils.isEmpty(modeItemInfo.itemImgUrl)) {
                return null;
            }
            if (jSONObject.optInt("newflag", -1) == 1) {
                AppPreferencesSetting instance = AppPreferencesSetting.getInstance();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("prefrence_key_feature_newflag_");
                sb2.append(modeItemInfo.todoCode);
                modeItemInfo.isNew = instance.getAppSettingBoolean(sb2.toString(), true);
            } else {
                modeItemInfo.isNew = false;
            }
            return modeItemInfo;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: H */
    public List<ModeItemInfo> mo23309H(Context context, int i) {
        ArrayList arrayList = new ArrayList();
        if (this.boD != null && this.boD.size() > 0) {
            ArrayList arrayList2 = new ArrayList(this.boD);
            for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                ModeItemInfo modeItemInfo = (ModeItemInfo) arrayList2.get(i2);
                if (i == (modeItemInfo != null ? m9373dq(modeItemInfo.mParentModelCode) : 0)) {
                    if (21 != modeItemInfo.getModeType() && 22 != modeItemInfo.getModeType() && 23 != modeItemInfo.getModeType() && 4 != modeItemInfo.getModeType()) {
                        arrayList.add(modeItemInfo);
                        m9375f(i2, arrayList2);
                    } else if (modeItemInfo.adItemInfoList != null && modeItemInfo.adItemInfoList.size() > 0) {
                        arrayList.add(modeItemInfo);
                        m9375f(i2, arrayList2);
                    }
                }
            }
        }
        m9370O(arrayList);
        int i3 = 13;
        if (i == 70) {
            i3 = 12;
        }
        mo23315a(context, arrayList, i3);
        return arrayList;
    }

    /* renamed from: Kt */
    public List<ModeItemInfo> mo23310Kt() {
        ArrayList arrayList = new ArrayList();
        List<AppModelConfigInfo> Lc = C3935b.m9679Lb().mo23473Lc();
        if (Lc != null && Lc.size() > 0) {
            for (AppModelConfigInfo b : Lc) {
                arrayList.add(m9371b(b));
            }
        }
        return arrayList.size() < 2 ? mo23311Ku() : arrayList;
    }

    /* renamed from: Ku */
    public List<ModeItemInfo> mo23311Ku() {
        ArrayList arrayList = new ArrayList();
        arrayList.clear();
        arrayList.add(m9376gx(401));
        if (C3742b.m9111II().mo23170Jq()) {
            arrayList.add(m9376gx(408));
        } else {
            arrayList.add(m9376gx(TodoConstants.TODO_TYPE_CAMERA_MODE_HD6));
        }
        return arrayList;
    }

    /* renamed from: Kv */
    public List<ModeItemInfo> mo23312Kv() {
        ArrayList arrayList = new ArrayList();
        IAppService iAppService = (IAppService) C1919a.m5529sc().mo10356i(IAppService.class);
        boolean isYoungerMode = iAppService != null ? iAppService.isYoungerMode() : false;
        List<AppModelConfigInfo> Ld = C3935b.m9679Lb().mo23474Ld();
        if (Ld != null && Ld.size() > 0) {
            for (AppModelConfigInfo appModelConfigInfo : Ld) {
                if (!isYoungerMode || !(appModelConfigInfo.eventType == 915 || appModelConfigInfo.eventType == 907)) {
                    arrayList.add(m9371b(appModelConfigInfo));
                }
            }
        }
        return arrayList.isEmpty() ? mo23313Kw() : arrayList;
    }

    /* renamed from: Kw */
    public List<ModeItemInfo> mo23313Kw() {
        ArrayList arrayList = new ArrayList();
        if (C3742b.m9111II().mo23170Jq()) {
            arrayList.add(m9376gx(TodoConstants.TODO_TYPE_CAMERA_MODE_HD6));
        } else {
            arrayList.add(m9376gx(408));
        }
        if (AppStateModel.getInstance().isInChina()) {
            arrayList.add(m9376gx(TodoConstants.TODO_TYPE_CAMERA_MODE_FB6));
            arrayList.add(m9376gx(409));
            arrayList.add(m9376gx(605));
        } else if (AppStateModel.getInstance().isSoutheastAsia()) {
            arrayList.add(m9376gx(TodoConstants.TODO_TYPE_CAMERA_MODE_FB6));
            arrayList.add(m9376gx(TodoConstants.TODO_TYPE_CAMERA_MODE_MV6));
            arrayList.add(m9376gx(409));
            arrayList.add(m9376gx(605));
        } else {
            arrayList.add(m9376gx(TodoConstants.TODO_TYPE_CAMERA_MODE_FB6));
            arrayList.add(m9376gx(TodoConstants.TODO_TYPE_CAMERA_MODE_MV6));
            arrayList.add(m9376gx(409));
            arrayList.add(m9376gx(605));
        }
        return arrayList;
    }

    /* renamed from: a */
    public void mo23314a(Context context, ModeItemInfo modeItemInfo) {
        ICommunityAPI iCommunityAPI = (ICommunityAPI) BizServiceManager.getService(ICommunityAPI.class);
        if (iCommunityAPI != null) {
            String hotVideoData = iCommunityAPI.getHotVideoData(context);
            if (!TextUtils.isEmpty(hotVideoData)) {
                try {
                    JSONObject jSONObject = new JSONObject(hotVideoData);
                    modeItemInfo.mVideoInfo = new VideoInfo();
                    modeItemInfo.mVideoInfo.puid = jSONObject.optString("strPuid");
                    modeItemInfo.mVideoInfo.mVer = C2575a.parseInt(jSONObject.optString("strPver"));
                    modeItemInfo.mVideoInfo.mCoverUrl = jSONObject.optString("strCoverURL");
                    modeItemInfo.mVideoInfo.mFileUrl = jSONObject.optString("strMp4URL");
                    modeItemInfo.mVideoInfo.mWidth = jSONObject.optInt("nWidth");
                    modeItemInfo.mVideoInfo.mHeight = jSONObject.optInt("nHeight");
                    modeItemInfo.mVideoInfo.mTitle = jSONObject.optString("strTitle");
                    modeItemInfo.mVideoInfo.mDesc = jSONObject.optString("strDesc");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: a */
    public void mo23315a(Context context, List<ModeItemInfo> list, int i) {
        int positionInGroup = AdParamMgr.getPositionInGroup(i);
        if (AdParamMgr.isAdConfigValid(i)) {
            ModeItemInfo Kx = m9367Kx();
            if (positionInGroup < list.size()) {
                list.add(positionInGroup, Kx);
            } else {
                positionInGroup = list.size() / 2;
                list.add(positionInGroup, Kx);
            }
            Kx.isInVideoList = m9372b(list, positionInGroup);
            Kx.isVideoListEnd = false;
            return;
        }
        ModeItemInfo Kx2 = m9367Kx();
        int size = list.size() / 2;
        list.add(size, Kx2);
        Kx2.isInVideoList = m9372b(list, size);
        Kx2.isVideoListEnd = false;
    }

    /* renamed from: ce */
    public List<ModeItemInfo> mo23316ce(Context context) {
        ArrayList arrayList = new ArrayList();
        if (this.boD != null && this.boD.size() > 0) {
            for (ModeItemInfo modeItemInfo : new ArrayList(this.boD)) {
                if (105 == m9373dq(modeItemInfo.mParentModelCode)) {
                    if (4 == modeItemInfo.getModeType()) {
                        if (modeItemInfo.adItemInfoList != null && modeItemInfo.adItemInfoList.size() > 0) {
                            Iterator it = modeItemInfo.adItemInfoList.iterator();
                            while (it.hasNext()) {
                                AdItemInfo adItemInfo = (AdItemInfo) it.next();
                                if (adItemInfo.mVideoInfo != null) {
                                    ModeItemInfo modeItemInfo2 = new ModeItemInfo();
                                    modeItemInfo2.mVideoInfo = new VideoInfo(adItemInfo.mVideoInfo);
                                    arrayList.add(modeItemInfo2);
                                }
                            }
                        }
                    } else if (modeItemInfo.mVideoInfo != null) {
                        ModeItemInfo modeItemInfo3 = new ModeItemInfo();
                        modeItemInfo3.mVideoInfo = new VideoInfo(modeItemInfo.mVideoInfo);
                        arrayList.add(modeItemInfo3);
                    }
                }
            }
        }
        if (!AppStateModel.getInstance().isInChina()) {
            mo23315a(context, arrayList, 15);
        }
        return arrayList;
    }

    /* renamed from: cf */
    public List<ModeItemInfo> mo23317cf(Context context) {
        return mo23309H(context, 105);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:40|41|(0)|54|55) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:54:0x0077 */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x006d A[SYNTHETIC, Splitter:B:46:0x006d] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0074 A[SYNTHETIC, Splitter:B:52:0x0074] */
    /* renamed from: cg */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo23318cg(android.content.Context r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            boolean r0 = com.p131c.p132a.C2561a.aON()     // Catch:{ all -> 0x0078 }
            if (r0 == 0) goto L_0x000e
            java.util.ArrayList<com.introvd.template.common.ui.modechooser.ModeItemInfo> r8 = r7.boD     // Catch:{ all -> 0x0078 }
            r8.clear()     // Catch:{ all -> 0x0078 }
            monitor-exit(r7)
            return
        L_0x000e:
            android.content.ContentResolver r0 = r8.getContentResolver()     // Catch:{ all -> 0x0078 }
            java.lang.String r1 = "DynamicFeature"
            android.net.Uri r1 = com.introvd.template.datacenter.SocialConstDef.getTableUri(r1)     // Catch:{ all -> 0x0078 }
            r6 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            java.lang.String r5 = "orderno asc"
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5)     // Catch:{ Throwable -> 0x0067 }
            if (r0 != 0) goto L_0x002b
            if (r0 == 0) goto L_0x0029
            r0.close()     // Catch:{ Exception -> 0x0029 }
        L_0x0029:
            monitor-exit(r7)
            return
        L_0x002b:
            java.util.ArrayList<com.introvd.template.common.ui.modechooser.ModeItemInfo> r1 = r7.boD     // Catch:{ Throwable -> 0x0061, all -> 0x005f }
            r1.clear()     // Catch:{ Throwable -> 0x0061, all -> 0x005f }
        L_0x0030:
            boolean r1 = r0.moveToNext()     // Catch:{ Throwable -> 0x0061, all -> 0x005f }
            if (r1 == 0) goto L_0x0059
            com.introvd.template.common.ui.modechooser.ModeItemInfo r1 = r7.m9377i(r0)     // Catch:{ Throwable -> 0x0061, all -> 0x005f }
            if (r1 != 0) goto L_0x003d
            goto L_0x0030
        L_0x003d:
            int r2 = r1.getModeType()     // Catch:{ Throwable -> 0x0061, all -> 0x005f }
            r3 = 6
            if (r2 != r3) goto L_0x0047
            r7.mo23314a(r8, r1)     // Catch:{ Throwable -> 0x0061, all -> 0x005f }
        L_0x0047:
            boolean r2 = r1.isImageItem()     // Catch:{ Throwable -> 0x0061, all -> 0x005f }
            if (r2 != 0) goto L_0x0053
            boolean r2 = r1.isVideoItem()     // Catch:{ Throwable -> 0x0061, all -> 0x005f }
            if (r2 == 0) goto L_0x0030
        L_0x0053:
            java.util.ArrayList<com.introvd.template.common.ui.modechooser.ModeItemInfo> r2 = r7.boD     // Catch:{ Throwable -> 0x0061, all -> 0x005f }
            r2.add(r1)     // Catch:{ Throwable -> 0x0061, all -> 0x005f }
            goto L_0x0030
        L_0x0059:
            if (r0 == 0) goto L_0x0070
            r0.close()     // Catch:{ Exception -> 0x0070 }
            goto L_0x0070
        L_0x005f:
            r8 = move-exception
            goto L_0x0072
        L_0x0061:
            r8 = move-exception
            r6 = r0
            goto L_0x0068
        L_0x0064:
            r8 = move-exception
            r0 = r6
            goto L_0x0072
        L_0x0067:
            r8 = move-exception
        L_0x0068:
            r8.printStackTrace()     // Catch:{ all -> 0x0064 }
            if (r6 == 0) goto L_0x0070
            r6.close()     // Catch:{ Exception -> 0x0070 }
        L_0x0070:
            monitor-exit(r7)
            return
        L_0x0072:
            if (r0 == 0) goto L_0x0077
            r0.close()     // Catch:{ Exception -> 0x0077 }
        L_0x0077:
            throw r8     // Catch:{ all -> 0x0078 }
        L_0x0078:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.app.creation.C3821d.mo23318cg(android.content.Context):void");
    }
}
