package com.introvd.template.starvlogs.checking;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.introvd.template.common.model.AppStateModel;
import java.lang.reflect.InvocationTargetException;
import p503cz.msebera.android.httpclient.HttpStatus;

public class CountryCheck {
    public static String getDeviceCountryCode(Activity context) {
        String countryCode;
        String countryCode2;
        TelephonyManager tm = (TelephonyManager) context.getSystemService("phone");
        if (tm != null) {
            String countryCode3 = tm.getSimCountryIso();
            if (countryCode3 != null && countryCode3.length() == 2) {
                return countryCode3.toLowerCase();
            }
            if (tm.getPhoneType() == 2) {
                countryCode2 = getCDMACountryIso();
            } else {
                countryCode2 = tm.getNetworkCountryIso();
            }
            if (countryCode2 != null && countryCode2.length() == 2) {
                return countryCode2.toLowerCase();
            }
        }
        if (VERSION.SDK_INT >= 24) {
            countryCode = context.getResources().getConfiguration().getLocales().get(0).getCountry();
        } else {
            countryCode = context.getResources().getConfiguration().locale.getCountry();
        }
        if (countryCode == null || countryCode.length() != 2) {
            return AppStateModel.ZONE_EAST_AMERICAN;
        }
        return countryCode.toLowerCase();
    }

    public static boolean isCNTW(Activity activity) {
        String country = getDeviceCountryCode(activity);
        if (country.equals("tw") || country.equals("cn")) {
            return true;
        }
        return false;
    }

    @SuppressLint({"PrivateApi"})
    private static String getCDMACountryIso() {
        try {
            Class<?> systemProperties = Class.forName("android.os.SystemProperties");
            switch (Integer.parseInt(((String) systemProperties.getMethod("get", new Class[]{String.class}).invoke(systemProperties, new Object[]{"ro.cdma.home.operator.numeric"})).substring(0, 3))) {
                case HttpStatus.SC_NO_CONTENT /*204*/:
                    return "NL";
                case 232:
                    return "AT";
                case 247:
                    return "LV";
                case 255:
                    return "UA";
                case 262:
                    return "DE";
                case 283:
                    return "AM";
                case 310:
                    return AppStateModel.COUNTRY_CODE_AMERICAN;
                case 311:
                    return AppStateModel.COUNTRY_CODE_AMERICAN;
                case 312:
                    return AppStateModel.COUNTRY_CODE_AMERICAN;
                case 316:
                    return AppStateModel.COUNTRY_CODE_AMERICAN;
                case 330:
                    return "PR";
                case 414:
                    return AppStateModel.COUNTRY_CODE_Myanmar;
                case 434:
                    return "UZ";
                case 450:
                    return AppStateModel.COUNTRY_CODE_Korea;
                case 455:
                    return "MO";
                case 460:
                    return AppStateModel.COUNTRY_CODE_China;
                case 619:
                    return "SL";
                case 634:
                    return "SD";
            }
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | NullPointerException | InvocationTargetException e) {
        }
        return null;
    }
}
