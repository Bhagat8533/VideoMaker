package com.introvd.template.common.model;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.giii.aiii.biii.common.GoogleApiAvailability;
import com.introvd.template.VivaBaseApplication;
import com.introvd.template.consent.gdpr.C5521b;
import com.introvd.template.p203b.C4598j;
import com.introvd.template.router.editor.EditorRouter;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.p131c.p132a.C2561a;
import java.util.Locale;

public class AppStateModel {
    private static final String APP_PRODUCT_ID_VIVALITE = "13";
    private static final String APP_PRODUCT_ID_VIVAVIDEO = "2";
    public static final String COUNTRY_CODE_AMERICAN = "US";
    public static final String COUNTRY_CODE_Algeria = "DZ";
    public static final String COUNTRY_CODE_BRAZIL = "BR";
    public static final String COUNTRY_CODE_Bahrain = "BH";
    public static final String COUNTRY_CODE_Cambodia = "KH";
    public static final String COUNTRY_CODE_China = "CN";
    public static final String COUNTRY_CODE_Egypt = "EG";
    public static final String COUNTRY_CODE_HongKong = "HK";
    public static final String COUNTRY_CODE_INDIA = "IN";
    public static final String COUNTRY_CODE_Indonesia = "ID";
    public static final String COUNTRY_CODE_Iraq = "IQ";
    public static final String COUNTRY_CODE_Japan = "JP";
    public static final String COUNTRY_CODE_Jordan = "JO";
    public static final String COUNTRY_CODE_Korea = "KR";
    public static final String COUNTRY_CODE_Kuwait = "KW";
    public static final String COUNTRY_CODE_Laos = "LA";
    public static final String COUNTRY_CODE_Lebanon = "LB";
    public static final String COUNTRY_CODE_Libya = "LY";
    public static final String COUNTRY_CODE_Malaysia = "MY";
    public static final String COUNTRY_CODE_Morocco = "MA";
    public static final String COUNTRY_CODE_Myanmar = "MM";
    public static final String COUNTRY_CODE_Oman = "OM";
    public static final String COUNTRY_CODE_Palestine = "PS";
    public static final String COUNTRY_CODE_Philippines = "PH";
    public static final String COUNTRY_CODE_Qatar = "QA";
    public static final String COUNTRY_CODE_RUSSIA = "RU";
    public static final String COUNTRY_CODE_SaudiArabia = "SA";
    public static final String COUNTRY_CODE_Singapore = "SG";
    public static final String COUNTRY_CODE_Syria = "SY";
    public static final String COUNTRY_CODE_Taiwan = "TW";
    public static final String COUNTRY_CODE_Thailand = "TH";
    public static final String COUNTRY_CODE_Tunisia = "TN";
    public static final String COUNTRY_CODE_UnitedArabEmirates = "AE";
    public static final String COUNTRY_CODE_VietNam = "VN";
    public static final String COUNTRY_CODE_Yemen = "YE";
    public static final String[] SimCountryCodes = {COUNTRY_CODE_China, "CF", "CL", "GI", "TD", "JE", "ZM", COUNTRY_CODE_VietNam, COUNTRY_CODE_Jordan, "IO", "GB", COUNTRY_CODE_Indonesia, COUNTRY_CODE_INDIA, "IT", "IL", "IR", COUNTRY_CODE_Iraq, COUNTRY_CODE_Yemen, "AM", "JM", COUNTRY_CODE_Syria, "HU", "NZ", "NC", COUNTRY_CODE_Singapore, "GR", "ES", "UZ", "UY", "UA", "UG", "BN", "VE", "VG", "VI", "GT", "VU", "WF", "TK", "TM", "TR", "TV", COUNTRY_CODE_Tunisia, "TT", "TAA", "TC", "TO", "TZ", COUNTRY_CODE_Thailand, "TJ", "SO", "SB", "SR", "SD", "SZ", "SJ", "SI", "SK", "LK", "VC", "PM", "SM", "LC", "KN", "SH", "ST", "CX", COUNTRY_CODE_SaudiArabia, "SC", "CY", "SN", "SL", "CS", "WS", "SV", "CH", "SE", COUNTRY_CODE_Japan, "GE", "PT", "PN", "PW", "NF", "NO", "NU", "NG", "NE", "NI", "NP", "NR", "GS", "ZA", "NA", "MX", "MZ", "MC", "MA", "MD", COUNTRY_CODE_Myanmar, "FM", "PE", "BD", "MS", "MN", "UM", "AS", COUNTRY_CODE_AMERICAN, "MR", "MU", "IM", "YT", "MQ", "MH", "MK", "ML", COUNTRY_CODE_Malaysia, "MW", "MT", EditorRouter.ENTRANCE_MV, "MG", "RO", "RW", "LU", "RE", "LI", COUNTRY_CODE_Libya, "LR", "LT", COUNTRY_CODE_Lebanon, COUNTRY_CODE_Laos, "LS", "LV", "CK", "KE", "HR", COUNTRY_CODE_Kuwait, "CI", "KM", "CC", "KY", COUNTRY_CODE_Qatar, "CM", "ZW", "CZ", COUNTRY_CODE_Cambodia, "GA", "GH", "CA", "GW", "GN", "KG", "DJ", "KI", "HN", "HM", "AN", "NL", COUNTRY_CODE_Korea, "HT", "KZ", "GY", "GU", "GP", "CU", "GL", "GD", "GG", "CR", "CO", "CD", "CG", "GM", "FK", "CV", "FI", "FJ", COUNTRY_CODE_Philippines, "VA", "TF", "GF", "PF", "FO", "FR", "ER", "EC", COUNTRY_CODE_RUSSIA, "DO", "DM", "TG", "TL", "DE", "DK", "KP", "BV", "BI", "BF", "BT", "BW", "BZ", "BO", "BA", "PL", "PR", IronSourceConstants.INTERSTITIAL_EVENT_TYPE, "BE", "BJ", "MP", "BG", "BM", "BY", COUNTRY_CODE_BRAZIL, "PA", COUNTRY_CODE_Bahrain, COUNTRY_CODE_Palestine, "PY", "PK", "BS", "PG", "BB", "AU", "AX", "AT", "AG", "AI", "AO", "AD", "EE", "IE", "ET", COUNTRY_CODE_Egypt, "AC", "AZ", COUNTRY_CODE_Oman, "AW", COUNTRY_CODE_UnitedArabEmirates, "AR", "AF", COUNTRY_CODE_Algeria, "AL"};
    public static final String ZONE_BIG_CHINA = "hz";
    public static final String ZONE_EAST_AMERICAN = "us";
    public static final String ZONE_EAST_ASIA = "asia1";
    public static final String ZONE_MIDDLE_EAST = "meast";
    private static volatile AppStateModel instance;
    private final String ASIA1COUNTRYS = "SG,PH,MY,IN,JP,HK,TW";
    private final String MEASTCOUNTRYS = "SA,MA,DZ,EG,KW,JO,TN,OM,LB,QA,PS,LY,YE,AE,BH,IQ,SY";
    private final String XY_MEAST_COUNTRY_CODE_LIST_EUROPE_OTHER = "AL,AZ,BY,IS,BA,RU,MK,MD,NO,CH,UA,GB,GEO,MNE,SRB,YK";
    private final String XY_MEAST_COUNTRY_CODE_LIST_EUROPE_UNION = "IE,EE,AT,BG,BE,PL,DK,DE,FR,FI,NL,CZ,HR,LV,LT,LU,RO,MT,PT,SE,CY,SK,SI,ES,GR,HU,IT";
    private final String XY_UN_SUPPORT_GP_COUNTRY_COLLECTION = "CU,IR,SD";
    private String appProductId;
    private String groupId;
    private boolean isCommunityFeatureEnable = true;
    private boolean isExploreVideoEnable = true;
    private boolean isHotVideoEnable = true;
    private boolean isLBSVideoEnable = false;
    private boolean isMessageTabEnable = false;
    private boolean isMinComunityEnable = false;
    private boolean isVivaSchoolEnable = false;
    private String mCountryCode = COUNTRY_CODE_China;
    private String mZoneCode = ZONE_BIG_CHINA;
    private String simCountryCode = "";

    private AppStateModel() {
        initData();
    }

    private static String getCountryCodeFromSimInfo(Context context) {
        String str = "";
        if (context == null) {
            return str;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        return (telephonyManager == null || telephonyManager.getSimCountryIso() == null) ? str : telephonyManager.getSimCountryIso().toUpperCase();
    }

    public static AppStateModel getInstance() {
        if (instance == null) {
            synchronized (AppStateModel.class) {
                if (instance == null) {
                    instance = new AppStateModel();
                }
            }
        }
        return instance;
    }

    private void initData() {
        this.simCountryCode = getCountryCodeFromSimInfo(VivaBaseApplication.m8749FZ());
        if (COUNTRY_CODE_China.equals(this.simCountryCode) || C4598j.m11730SA()) {
            this.isCommunityFeatureEnable = true;
            this.isHotVideoEnable = true;
            this.isExploreVideoEnable = true;
            this.mZoneCode = ZONE_BIG_CHINA;
            this.mCountryCode = COUNTRY_CODE_China;
        } else {
            String str = this.simCountryCode;
            if (TextUtils.isEmpty(str)) {
                str = Locale.getDefault().getCountry().toUpperCase();
            }
            if ("SG,PH,MY,IN,JP,HK,TW".contains(str)) {
                this.isCommunityFeatureEnable = true;
                this.isHotVideoEnable = true;
                this.isExploreVideoEnable = true;
                this.mZoneCode = ZONE_EAST_ASIA;
            } else if ("SA,MA,DZ,EG,KW,JO,TN,OM,LB,QA,PS,LY,YE,AE,BH,IQ,SY".contains(str)) {
                this.isCommunityFeatureEnable = true;
                this.isHotVideoEnable = true;
                this.isExploreVideoEnable = true;
                this.mZoneCode = ZONE_MIDDLE_EAST;
            } else if (isEUnionCountry(str) || isEuropeNoUnionCountry(str)) {
                this.isCommunityFeatureEnable = false;
                this.isHotVideoEnable = false;
                this.isExploreVideoEnable = false;
                this.mZoneCode = ZONE_MIDDLE_EAST;
            } else {
                this.isCommunityFeatureEnable = false;
                this.isHotVideoEnable = false;
                this.isExploreVideoEnable = false;
                this.mZoneCode = ZONE_BIG_CHINA;
            }
            this.mCountryCode = str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("ApkInfoProvider.sVersionType = ");
        sb.append(C2561a.aOR());
        Log.d("APP-JAMIN", sb.toString());
        this.appProductId = "2";
        if (C2561a.aOR() == 2 || C2561a.aOR() == 3 || C2561a.aOS()) {
            this.isCommunityFeatureEnable = false;
            this.appProductId = APP_PRODUCT_ID_VIVALITE;
        } else if (C2561a.aOR() == 4) {
            this.isCommunityFeatureEnable = false;
        }
    }

    private boolean isEUnionCountry(String str) {
        if (TextUtils.isEmpty("IE,EE,AT,BG,BE,PL,DK,DE,FR,FI,NL,CZ,HR,LV,LT,LU,RO,MT,PT,SE,CY,SK,SI,ES,GR,HU,IT") || TextUtils.isEmpty(str)) {
            return false;
        }
        return "IE,EE,AT,BG,BE,PL,DK,DE,FR,FI,NL,CZ,HR,LV,LT,LU,RO,MT,PT,SE,CY,SK,SI,ES,GR,HU,IT".contains(str);
    }

    private boolean isEuropeNoUnionCountry(String str) {
        if (TextUtils.isEmpty("AL,AZ,BY,IS,BA,RU,MK,MD,NO,CH,UA,GB,GEO,MNE,SRB,YK") || TextUtils.isEmpty(str)) {
            return false;
        }
        return "AL,AZ,BY,IS,BA,RU,MK,MD,NO,CH,UA,GB,GEO,MNE,SRB,YK".contains(str);
    }

    public boolean canLoginGoogle(Context context) {
        return !isInChina() && GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context) == 0;
    }

    public String getAppProductId() {
        return this.appProductId;
    }

    public String getCountryCode() {
        return this.mCountryCode;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public String getSimCountryCode() {
        return this.simCountryCode;
    }

    public String getZoneCode() {
        return this.mZoneCode;
    }

    public boolean isCommunityCloseSoon() {
        return COUNTRY_CODE_Japan.equals(this.mCountryCode) || COUNTRY_CODE_Taiwan.equals(this.mCountryCode) || COUNTRY_CODE_HongKong.equals(this.mCountryCode) || COUNTRY_CODE_AMERICAN.equals(this.mCountryCode) || COUNTRY_CODE_Singapore.equals(this.mCountryCode) || COUNTRY_CODE_Malaysia.equals(this.mCountryCode) || COUNTRY_CODE_Philippines.equals(this.mCountryCode) || COUNTRY_CODE_BRAZIL.equals(this.mCountryCode);
    }

    public boolean isCommunitySupport() {
        if (C2561a.aOR() != 1) {
            return false;
        }
        return this.isCommunityFeatureEnable;
    }

    public boolean isExploreVideoEnable() {
        return this.isExploreVideoEnable;
    }

    public boolean isGDPRAgree() {
        return !isInEurope() || C5521b.aaL();
    }

    public boolean isHotVideoEnable() {
        return this.isHotVideoEnable;
    }

    public boolean isInChina() {
        return TextUtils.equals(this.mCountryCode, COUNTRY_CODE_China);
    }

    public boolean isInEurope() {
        return isEUnionCountry(this.mCountryCode);
    }

    public boolean isInIndia() {
        return TextUtils.equals(this.mCountryCode, COUNTRY_CODE_INDIA);
    }

    public boolean isLBSVideoEnable() {
        return this.isLBSVideoEnable;
    }

    public boolean isMessageTabSupport() {
        return this.isMessageTabEnable;
    }

    public boolean isMiddleEast() {
        return this.mZoneCode.equals(ZONE_MIDDLE_EAST);
    }

    public boolean isOpenCommunityEnabled() {
        return this.isCommunityFeatureEnable;
    }

    public boolean isSoutheastAsia() {
        return COUNTRY_CODE_Japan.equals(this.mCountryCode) || COUNTRY_CODE_Korea.equals(this.mCountryCode) || COUNTRY_CODE_Taiwan.equals(this.mCountryCode) || COUNTRY_CODE_Malaysia.equals(this.mCountryCode) || COUNTRY_CODE_Indonesia.equals(this.mCountryCode) || COUNTRY_CODE_Philippines.equals(this.mCountryCode) || COUNTRY_CODE_VietNam.equals(this.mCountryCode) || COUNTRY_CODE_Laos.equals(this.mCountryCode) || COUNTRY_CODE_Cambodia.equals(this.mCountryCode) || COUNTRY_CODE_Thailand.equals(this.mCountryCode) || COUNTRY_CODE_Singapore.equals(this.mCountryCode) || COUNTRY_CODE_Myanmar.equals(this.mCountryCode);
    }

    public boolean isUnSupportGPCountry() {
        if (TextUtils.isEmpty("CU,IR,SD") || TextUtils.isEmpty(this.mCountryCode)) {
            return false;
        }
        return "CU,IR,SD".contains(this.mCountryCode);
    }

    public boolean isVivaSchoolTabSupport() {
        return this.isVivaSchoolEnable;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("mCountryCode=");
        sb.append(this.mCountryCode);
        sb.append("\n\r");
        sb.append("mZoneCode=");
        sb.append(this.mZoneCode);
        sb.append("\n\r");
        sb.append("isCommunityFeatureEnable=");
        sb.append(this.isCommunityFeatureEnable);
        sb.append("\n\r");
        sb.append("isHotVideoEnable=");
        sb.append(this.isHotVideoEnable);
        sb.append("\n\r");
        sb.append("isLBSVideoEnable=");
        sb.append(this.isLBSVideoEnable);
        sb.append("\n\r");
        sb.append("isMessageTabEnable=");
        sb.append(this.isMessageTabEnable);
        sb.append("\n\r");
        sb.append("isMinComunityEnable=");
        sb.append(this.isMinComunityEnable);
        sb.append("\n\r");
        sb.append("appProductId=");
        sb.append(this.appProductId);
        return sb.toString();
    }

    public void updateCommRouteConfig(boolean z, boolean z2, boolean z3, boolean z4) {
        this.isLBSVideoEnable = z2;
        this.isMessageTabEnable = z;
        this.isMinComunityEnable = z3;
        this.isVivaSchoolEnable = z4;
    }

    public void updateCommunityState(boolean z, boolean z2, boolean z3) {
        this.isCommunityFeatureEnable = z;
        this.isHotVideoEnable = z2;
        this.isExploreVideoEnable = z3;
    }

    public void updateCountryCodeAndZone(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.mCountryCode = str;
            this.mZoneCode = str2;
        }
    }

    public void updateGroupId(String str) {
        this.groupId = str;
    }
}
