package com.introvd.template.app.p177b;

import android.content.Context;
import android.text.TextUtils;
import com.introvd.template.AppMiscListener;
import com.introvd.template.C3569a;
import com.introvd.template.C4561b;
import com.introvd.template.C4681i;
import com.introvd.template.common.AppPreferencesSetting;
import com.introvd.template.common.LogUtilsV2;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.common.prefs.UtilsPrefs;
import com.introvd.template.crash.C5523b;
import com.introvd.template.datacenter.SocialService;
import com.introvd.template.router.AppRouter;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.introvd.template.app.b.b */
public class C3742b {
    private static C3742b blC;
    private C3743c blD = new C3743c();

    private C3742b() {
    }

    /* renamed from: II */
    public static C3742b m9111II() {
        if (blC == null) {
            blC = new C3742b();
        }
        return blC;
    }

    /* renamed from: a */
    private int m9112a(Context context, JSONObject jSONObject, String str, int i) {
        if (C4561b.m11530bm(context)) {
            try {
                String trim = UtilsPrefs.with(context, AppRouter.VIVA_APP_PREF_FILENAME, true).read(str, "").trim();
                if (!TextUtils.isEmpty(trim)) {
                    return Integer.decode(trim).intValue();
                }
            } catch (Exception unused) {
            }
        }
        return jSONObject.optInt(str, i);
    }

    /* renamed from: d */
    private void m9113d(JSONObject jSONObject) {
        try {
            this.blD.bmE = jSONObject.optInt("coverCompressQualityParam", 70);
            String optString = jSONObject.optString("bitrateRatio", "1.0f");
            this.blD.bmF = Float.valueOf(optString).floatValue();
            String optString2 = jSONObject.optString("hdBitrateRatio", "1.0f");
            this.blD.bmG = Float.valueOf(optString2).floatValue();
            String optString3 = jSONObject.optString("fullHdBitrateRatio", "1.0f");
            this.blD.bmH = Float.valueOf(optString3).floatValue();
        } catch (Exception e) {
            C5523b.logException(e);
        }
    }

    /* renamed from: IJ */
    public boolean mo23116IJ() {
        return this.blD.blE;
    }

    /* renamed from: IK */
    public int mo23117IK() {
        return C3569a.m8772FK() ? this.blD.blH : this.blD.blI;
    }

    /* renamed from: IL */
    public String mo23118IL() {
        return this.blD.bmd;
    }

    /* renamed from: IM */
    public String mo23119IM() {
        return this.blD.bme;
    }

    /* renamed from: IN */
    public int mo23120IN() {
        return this.blD.blR;
    }

    /* renamed from: IO */
    public boolean mo23121IO() {
        return this.blD.blZ;
    }

    /* renamed from: IP */
    public int mo23122IP() {
        return this.blD.bma;
    }

    /* renamed from: IQ */
    public boolean mo23123IQ() {
        int appSettingInt = AppPreferencesSetting.getInstance().getAppSettingInt("auto_play_with_4g", -1);
        boolean z = false;
        if (appSettingInt != -1) {
            if (appSettingInt == 1) {
                z = true;
            }
            return z;
        }
        if (this.blD.bmb == -1) {
            if (AppStateModel.getInstance().isInIndia()) {
                this.blD.bmb = 1;
            } else {
                this.blD.bmb = 0;
            }
        }
        if (this.blD.bmb == 1) {
            z = true;
        }
        return z;
    }

    /* renamed from: IR */
    public void mo23124IR() {
        AppPreferencesSetting.getInstance().setAppSettingInt("auto_play_with_4g", 1);
        this.blD.bmb = 1;
    }

    /* renamed from: IS */
    public boolean mo23125IS() {
        return this.blD.bmc == 1;
    }

    /* renamed from: IT */
    public int mo23126IT() {
        return this.blD.bmf;
    }

    /* renamed from: IU */
    public boolean mo23127IU() {
        return this.blD.bmi == 1;
    }

    /* renamed from: IV */
    public boolean mo23128IV() {
        return this.blD.bms;
    }

    /* renamed from: IW */
    public boolean mo23129IW() {
        return this.blD.bmt;
    }

    /* renamed from: IX */
    public int mo23130IX() {
        return this.blD.bmu;
    }

    /* renamed from: IY */
    public boolean mo23131IY() {
        return this.blD.bmv;
    }

    /* renamed from: IZ */
    public boolean mo23132IZ() {
        return this.blD.bmw;
    }

    /* renamed from: JA */
    public boolean mo23133JA() {
        return this.blD.bnb == 1;
    }

    /* renamed from: JB */
    public String mo23134JB() {
        return this.blD.bne;
    }

    /* renamed from: JC */
    public String mo23135JC() {
        return this.blD.bnf;
    }

    /* renamed from: JD */
    public boolean mo23136JD() {
        return this.blD.bng;
    }

    /* renamed from: JE */
    public boolean mo23137JE() {
        return this.blD.bni;
    }

    /* renamed from: JF */
    public boolean mo23138JF() {
        return this.blD.bnj;
    }

    /* renamed from: JG */
    public boolean mo23139JG() {
        return this.blD.bnm == 0;
    }

    /* renamed from: JH */
    public boolean mo23140JH() {
        return this.blD.bnp == 1;
    }

    /* renamed from: JI */
    public boolean mo23141JI() {
        return this.blD.bnq == 1;
    }

    /* renamed from: JJ */
    public boolean mo23142JJ() {
        return this.blD.bnt == 1;
    }

    /* renamed from: JK */
    public boolean mo23143JK() {
        return this.blD.bnu == 1;
    }

    /* renamed from: JL */
    public boolean mo23144JL() {
        return this.blD.bnv == 1;
    }

    /* renamed from: JM */
    public boolean mo23145JM() {
        return this.blD.bnH == 1;
    }

    /* renamed from: JN */
    public boolean mo23146JN() {
        return this.blD.bnC == 1;
    }

    /* renamed from: JO */
    public String mo23147JO() {
        return this.blD.bnI;
    }

    /* renamed from: JP */
    public boolean mo23148JP() {
        return this.blD.bnJ == 1;
    }

    /* renamed from: JQ */
    public int mo23149JQ() {
        AppMiscListener Gr = C4681i.m12184Gp().mo25016Gr();
        if (Gr == null || !Gr.getIsUseSchoolCreation()) {
            return this.blD.bnK;
        }
        return 1;
    }

    /* renamed from: JR */
    public boolean mo23150JR() {
        return this.blD.bnL == 1;
    }

    /* renamed from: JS */
    public boolean mo23151JS() {
        return this.blD.bnM == 1;
    }

    /* renamed from: JT */
    public boolean mo23152JT() {
        return this.blD.bnN == 1;
    }

    /* renamed from: JU */
    public boolean mo23153JU() {
        return this.blD.bnO == 0;
    }

    /* renamed from: Ja */
    public boolean mo23154Ja() {
        return this.blD.bmx;
    }

    /* renamed from: Jb */
    public int mo23155Jb() {
        return this.blD.bmk;
    }

    /* renamed from: Jc */
    public boolean mo23156Jc() {
        return this.blD.bmy;
    }

    /* renamed from: Jd */
    public String mo23157Jd() {
        return this.blD.feedbackOpenQQScheme;
    }

    /* renamed from: Je */
    public String mo23158Je() {
        return this.blD.feedbackQQNumber;
    }

    /* renamed from: Jf */
    public String mo23159Jf() {
        return this.blD.bmB;
    }

    /* renamed from: Jg */
    public long mo23160Jg() {
        return this.blD.bmC;
    }

    /* renamed from: Jh */
    public int mo23161Jh() {
        return this.blD.bmE;
    }

    /* renamed from: Ji */
    public float mo23162Ji() {
        return this.blD.bmF;
    }

    /* renamed from: Jj */
    public float mo23163Jj() {
        return this.blD.bmG;
    }

    /* renamed from: Jk */
    public float mo23164Jk() {
        return this.blD.bmH;
    }

    /* renamed from: Jl */
    public String mo23165Jl() {
        return this.blD.bmJ;
    }

    /* renamed from: Jm */
    public boolean mo23166Jm() {
        return this.blD.bmK;
    }

    /* renamed from: Jn */
    public boolean mo23167Jn() {
        return this.blD.bmL;
    }

    /* renamed from: Jo */
    public boolean mo23168Jo() {
        return this.blD.bmM;
    }

    /* renamed from: Jp */
    public boolean mo23169Jp() {
        return this.blD.bmO;
    }

    /* renamed from: Jq */
    public boolean mo23170Jq() {
        return this.blD.bmP;
    }

    /* renamed from: Jr */
    public boolean mo23171Jr() {
        return this.blD.bmQ;
    }

    /* renamed from: Js */
    public String mo23172Js() {
        return this.blD.bmR;
    }

    /* renamed from: Jt */
    public boolean mo23173Jt() {
        return this.blD.bmU;
    }

    /* renamed from: Ju */
    public int mo23174Ju() {
        return this.blD.bmV;
    }

    /* renamed from: Jv */
    public String mo23175Jv() {
        return this.blD.bmW;
    }

    /* renamed from: Jw */
    public boolean mo23176Jw() {
        return this.blD.bnh;
    }

    /* renamed from: Jx */
    public int mo23177Jx() {
        return this.blD.bmX;
    }

    /* renamed from: Jy */
    public boolean mo23178Jy() {
        return true;
    }

    /* renamed from: Jz */
    public boolean mo23179Jz() {
        return this.blD.bmZ == 1;
    }

    /* renamed from: K */
    public void mo23180K(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("handleConfig = ");
        sb.append(str);
        LogUtilsV2.m14227d(sb.toString());
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                boolean z = true;
                this.blD.blE = jSONObject.optInt("rateDialog", 1) == 1;
                jSONObject.optInt("liveshow", 0);
                this.blD.blG = jSONObject.optInt("DefaultCommunityTab", 0);
                this.blD.blH = jSONObject.optInt("DefaultCommunityTabForNewUser", 0);
                this.blD.blI = jSONObject.optInt("DefaultCommunityTabForOldUser", 0);
                this.blD.blJ = jSONObject.optInt("cashout", 0) == 1;
                this.blD.blK = jSONObject.optInt("httpslock", 0) == 1;
                this.blD.blL = jSONObject.optInt("onceHDsupport", 0) == 1;
                this.blD.blM = jSONObject.optInt("silentMode", 0) == 1;
                this.blD.blN = jSONObject.optInt("vivavideoCharge", 0) == 1;
                this.blD.blO = jSONObject.optInt("splashSkipShowTime", 1);
                this.blD.blP = jSONObject.optInt("gotoFeedOrDetail", 2);
                this.blD.blQ = jSONObject.optInt("enableHDUpload", 1) == 1;
                this.blD.blR = jSONObject.optInt("defaultChooseExportType", 2);
                this.blD.blS = jSONObject.optInt("enableAppInfoUpload", 1) == 1;
                this.blD.blT = jSONObject.optInt("videoDownloadSwitch", 0) == 1;
                this.blD.blV = jSONObject.optInt("VideoPublishVerify", 2);
                this.blD.blU = jSONObject.optInt("VideoCommentVerify", 2);
                this.blD.blW = jSONObject.optInt("RegisterVerify", 2);
                this.blD.blX = jSONObject.optInt("UserInfoVerify", 2);
                this.blD.blY = jSONObject.optInt("informationVerifyHint", 0) == 1;
                this.blD.blZ = jSONObject.optInt("allowUploadAndDownloadWithoutWifi", 0) == 1;
                this.blD.bmT = jSONObject.optInt("addMyStudioInUserPage", 0);
                this.blD.bma = jSONObject.optInt("AutoPlaySettingType", 1);
                this.blD.bnl = jSONObject.optInt("FollowPageLoginIcon", 0);
                this.blD.bns = jSONObject.optInt("minWatchVideoDuration", 20);
                this.blD.bmi = jSONObject.optInt("SWITCHER_DIGIT_WMARK");
                this.blD.bmd = jSONObject.optString("CamFbDatFileUrl", "");
                this.blD.bme = jSONObject.optString("arcsoftLicenceUrl", "");
                this.blD.bmf = jSONObject.optInt("preview_edit_default_focus", 1);
                this.blD.bmh = jSONObject.optInt("isPubllishTitleNecessary", 1);
                this.blD.bmg = jSONObject.optInt("isFeedorGridHot", 0);
                this.blD.bmj = jSONObject.optInt("huawei_payment", 2);
                this.blD.bmk = jSONObject.optInt("ExportAD_LoadCount", 3);
                this.blD.bml = jSONObject.optInt("defaultMyCoinEnable", -1);
                this.blD.bmq = jSONObject.optInt("enableAWSHttps", 0) == 1;
                this.blD.bmL = m9112a(context, jSONObject, "Xybat_ADs", 0) == 1;
                this.blD.bmK = m9112a(context, jSONObject, "hideCutFunction", 0) == 1;
                this.blD.bmM = m9112a(context, jSONObject, "Tool_Version_Export_Btn", 0) == 1;
                this.blD.bmO = m9112a(context, jSONObject, "Theme_Catagory_Show", 0) == 1;
                this.blD.bmP = m9112a(context, jSONObject, "Home_MV_Default_Position", 0) == 1;
                this.blD.bmQ = m9112a(context, jSONObject, "preview_tutorial_show", 1) == 1;
                this.blD.bmV = m9112a(context, jSONObject, "home_tool_tip_show", 2);
                this.blD.bmX = m9112a(context, jSONObject, "home_create_tab_icon_switch", 1);
                this.blD.bmR = jSONObject.optString("preview_toturial_refresh", "");
                this.blD.bmR = jSONObject.optString("preview_toturial_refresh", "");
                this.blD.bmW = jSONObject.optString("home_create_tip_text", "");
                this.blD.bnm = jSONObject.optInt("Cam_Done_Preview_Style", 0);
                this.blD.bnn = jSONObject.optInt("Edit_Watermark_gif", 0);
                this.blD.bnp = jSONObject.optInt("Theme_Auto_Download", 0);
                this.blD.bnu = jSONObject.optInt("MV_Pic_Duration", 0);
                this.blD.bnv = jSONObject.optInt("Home_Interstiitial", 0);
                SocialService.isAWSUseHttps = this.blD.bmq;
                this.blD.bmZ = m9112a(context, jSONObject, "Export_Encode_SW", 0);
                this.blD.bmm = jSONObject.optInt("isGetVideoDetailRcVideo", 0) == 1;
                this.blD.bmn = jSONObject.optInt("vipPageType", 1);
                this.blD.bmo = jSONObject.optInt("needsCheckMessageSensitive", 1);
                this.blD.bmp = jSONObject.optInt("publishUseNew", 0);
                this.blD.bmr = jSONObject.optInt("enableRepostFrom", 0) == 1;
                this.blD.bms = jSONObject.optInt("AutoShowSoftKeyboardEnable", 1) == 1;
                this.blD.bmt = jSONObject.optInt("eventApiAnalysisEnable", 1) == 1;
                this.blD.bmu = jSONObject.optInt("iapCacheDuration", 12);
                this.blD.bmv = jSONObject.optInt("shareVideoToWechatStyle", 0) == 1;
                this.blD.bmw = jSONObject.optInt("shareProfileToWechatStyle", 0) == 1;
                this.blD.bmx = jSONObject.optInt("shareActivityToWechatStyle", 0) == 1;
                this.blD.bmy = jSONObject.optInt("EnableCommunityPush", 0) == 0;
                this.blD.bmz = jSONObject.optInt("enableVideoCategoryList", 0) == 1;
                this.blD.bmA = jSONObject.optInt("shareVideoToWhatsApp", -1);
                this.blD.bmD = jSONObject.optInt("AllowDownloadWhatsappStatus", -1);
                this.blD.bmI = jSONObject.optInt("openRecommendUserForSearch", 0) == 0;
                this.blD.bmN = jSONObject.optInt("gridShowLikeOrDown", 0);
                this.blD.bmS = jSONObject.optInt("NewBtnUI", 0) == 1;
                this.blD.feedbackOpenQQScheme = jSONObject.optString("feedbackOpenQQScheme");
                this.blD.feedbackQQNumber = jSONObject.optString("feedbackQQNumber");
                this.blD.bmJ = jSONObject.optString("pushHtmlLoadSilent");
                this.blD.bmY = jSONObject.optInt("FeedRecyclerOrViewpage", 0);
                this.blD.bna = jSONObject.optInt("enableFollowRecommend", -1);
                this.blD.bnb = jSONObject.optInt("Preview_BGM_Wave_Show", 0);
                this.blD.bnc = jSONObject.optInt("minProgressForItemRecommend", 40);
                this.blD.bne = jSONObject.optString("Funny_video_ShowCase_Template_ID", "");
                this.blD.bnd = jSONObject.optInt("cardAutoPlay", 0);
                this.blD.bnf = jSONObject.optString("home_Tab_Create_name", "");
                this.blD.bng = jSONObject.optInt("jumpToCommunityHotTab", 1) == 1;
                this.blD.bmb = jSONObject.optInt("autoPlayWithoutWifi", -1);
                this.blD.bmc = jSONObject.optInt("showAutoPlayWithoutWifiSwitch", 0);
                this.blD.bnF = jSONObject.optInt("HotTitle", 0);
                this.blD.bnG = jSONObject.optInt("SecondaryTitle", 0);
                this.blD.bnK = jSONObject.optInt("DraftPositionType", 0);
                this.blD.bni = jSONObject.optInt("autoPlayNextEnable", 1) == 1;
                this.blD.bnj = jSONObject.optInt("PublishPlace", 0) == 1;
                this.blD.bnq = jSONObject.optInt("Theme_BGM_Percent", 0);
                this.blD.bnt = jSONObject.optInt("Create_page_Clear_Version", 0);
                this.blD.bny = jSONObject.optString("hotCategroyUITest", "");
                this.blD.bnk = jSONObject.optInt("enableItemRecommend", 0);
                this.blD.bno = jSONObject.optInt("secondTabFeedOrGrid", 0);
                this.blD.bnr = jSONObject.optInt("PlanetBackTop", 1);
                this.blD.bnw = jSONObject.optInt("hotAdvertise", 0);
                this.blD.bnx = jSONObject.optString("floatEntranceImage", "");
                this.blD.bnz = jSONObject.optInt("searchPosition", 0);
                this.blD.bnA = jSONObject.optInt("shareLinkJump", 0) == 1;
                this.blD.bnE = jSONObject.optString("starEffectImage", "");
                this.blD.bnh = m9112a(context, jSONObject, "Home_Create_Tip_Show", 0) == 0;
                this.blD.bnB = jSONObject.optInt("FollowPageLike", 0);
                this.blD.bnD = jSONObject.optInt("Community_Close_Notice", 0);
                this.blD.bnC = jSONObject.optInt("BGM_Search_UI", 0);
                this.blD.bnL = jSONObject.optInt("Mosaic", 1);
                this.blD.bnM = jSONObject.optInt("useYoungerMode", 0);
                this.blD.bnN = jSONObject.optInt("LoginStyle", 0);
                this.blD.bnO = jSONObject.optInt("Splash_Skip_btn_Position", 1);
                C3743c cVar = this.blD;
                if (m9112a(context, jSONObject, "animation_Text_Preview", 0) != 0) {
                    z = false;
                }
                cVar.bmU = z;
                m9113d(jSONObject);
                this.blD.bmB = jSONObject.optString("abTagList");
                this.blD.bmC = jSONObject.optLong("createVideolocalPushTime");
                this.blD.bnH = jSONObject.optInt("Home_Create_Page_New", 0);
                this.blD.bnI = jSONObject.optString("VivaSchoolWebUrl");
                this.blD.bnJ = jSONObject.optInt("Android_2k_4k", 0);
            } catch (JSONException unused) {
            }
        }
    }

    /* renamed from: bZ */
    public boolean mo23181bZ(Context context) {
        return this.blD.blL;
    }

    /* renamed from: ca */
    public boolean mo23182ca(Context context) {
        return this.blD.blM;
    }

    /* renamed from: cb */
    public int mo23183cb(Context context) {
        return this.blD.blO;
    }

    /* renamed from: cc */
    public boolean mo23184cc(Context context) {
        return (AppStateModel.getInstance().isInChina() || AppStateModel.getInstance().isMiddleEast()) && this.blD.blQ;
    }

    /* renamed from: cd */
    public boolean mo23185cd(Context context) {
        return this.blD.blS;
    }

    public boolean isCommunityCloseSoon() {
        return this.blD.bnD == 1;
    }
}
