package com.introvd.template.app.homepage;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.content.pm.FeatureInfo;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.google.gson.JsonObject;
import com.introvd.template.common.DeviceInfo;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.router.editor.EditorRouter;
import com.ironsource.environment.ConnectivityService;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;

/* renamed from: com.introvd.template.app.homepage.c */
public class C3942c {
    /* renamed from: ck */
    public static String m9715ck(Context context) {
        try {
            Locale locale = Locale.getDefault();
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            ConfigurationInfo deviceConfigurationInfo = ((ActivityManager) context.getSystemService("activity")).getDeviceConfigurationInfo();
            Configuration configuration = context.getResources().getConfiguration();
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            String[] systemSharedLibraryNames = context.getPackageManager().getSystemSharedLibraryNames();
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            WifiInfo connectionInfo = ((WifiManager) context.getSystemService(ConnectivityService.NETWORK_TYPE_WIFI)).getConnectionInfo();
            FeatureInfo[] systemAvailableFeatures = context.getPackageManager().getSystemAvailableFeatures();
            StringBuilder sb = new StringBuilder();
            for (FeatureInfo featureInfo : systemAvailableFeatures) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(featureInfo.name);
                sb2.append(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
                sb.append(sb2.toString());
            }
            String sb3 = sb.toString();
            boolean z = true;
            if (sb3.length() > 0) {
                sb3 = sb3.substring(0, sb3.length() - 1);
            }
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("UserReadableName", Build.MODEL);
            jsonObject.addProperty("Build.RADIO", Build.getRadioVersion());
            jsonObject.addProperty("TouchScreen", (Number) Integer.valueOf(deviceConfigurationInfo.reqTouchScreen));
            jsonObject.addProperty("Keyboard", (Number) Integer.valueOf(deviceConfigurationInfo.reqKeyboardType));
            jsonObject.addProperty("Navigation", (Number) Integer.valueOf(deviceConfigurationInfo.reqNavigation));
            jsonObject.addProperty("ScreenLayout", (Number) Integer.valueOf(configuration.screenLayout));
            jsonObject.addProperty("HasHardKeyboard", Boolean.valueOf(deviceConfigurationInfo.reqInputFeatures == 1));
            String str = "HasFiveWayNavigation";
            if (deviceConfigurationInfo.reqInputFeatures != 2) {
                z = false;
            }
            jsonObject.addProperty(str, Boolean.valueOf(z));
            jsonObject.addProperty("product.name", getProperty("ro.product.name", "unknown"));
            jsonObject.addProperty("product.device", getProperty("ro.product.device", "unknown"));
            jsonObject.addProperty("VERSION.RELEASE", getProperty("ro.build.version.release", "unknown"));
            jsonObject.addProperty(AppStateModel.COUNTRY_CODE_Indonesia, getProperty("ro.build.id", "unknown"));
            jsonObject.addProperty("VERSION.INCREMENTAL", getProperty("ro.build.version.incremental", "unknown"));
            jsonObject.addProperty("product.version", getProperty("ro.metricsd.product_version", "unknown"));
            jsonObject.addProperty("TAGS", getProperty("ro.build.tags", "unknown"));
            jsonObject.addProperty("TYPE", getProperty("ro.build.type", "unknown"));
            jsonObject.addProperty("Build.BOOTLOADER", Build.BOOTLOADER);
            jsonObject.addProperty("Build.HARDWARE", Build.HARDWARE);
            jsonObject.addProperty("Build.BRAND", Build.BRAND);
            jsonObject.addProperty("Build.DEVICE", Build.DEVICE);
            jsonObject.addProperty("Build.MODEL", Build.MODEL);
            jsonObject.addProperty("Build.MANUFACTURER", Build.MANUFACTURER);
            jsonObject.addProperty("Build.PRODUCT", Build.PRODUCT);
            jsonObject.addProperty("Build.TIME", (Number) Long.valueOf(Build.TIME));
            jsonObject.addProperty("Build.VERSION.SDK_INT", (Number) Integer.valueOf(VERSION.SDK_INT));
            jsonObject.addProperty("USER", Build.USER);
            jsonObject.addProperty("GVERSION.CODENAME", getProperty("ro.build.version.codename", "unknown"));
            jsonObject.addProperty("HOST", getProperty("ro.build.host", "unknown"));
            jsonObject.addProperty("LANG", locale.getLanguage());
            jsonObject.addProperty("COUNTRY", locale.getCountry());
            jsonObject.addProperty("Build.FINGERPRINT", Build.FINGERPRINT);
            jsonObject.addProperty("Screen.Density", (Number) Integer.valueOf(displayMetrics.densityDpi));
            jsonObject.addProperty("Screen.Width", (Number) Integer.valueOf(displayMetrics.widthPixels));
            jsonObject.addProperty("Screen.Height", (Number) Integer.valueOf(displayMetrics.heightPixels));
            jsonObject.addProperty("Platforms", getProperty("ro.board.platform", "unknown"));
            jsonObject.addProperty("SharedLibraries", m9716f(systemSharedLibraryNames));
            jsonObject.addProperty("Features", sb3);
            jsonObject.addProperty("Locales", locale.toString());
            jsonObject.addProperty("network.type", activeNetworkInfo.getTypeName());
            jsonObject.addProperty("network.subtype", activeNetworkInfo.getSubtypeName());
            jsonObject.addProperty("Roaming", Boolean.valueOf(activeNetworkInfo.isRoaming()));
            jsonObject.addProperty("macaddr", connectionInfo.getMacAddress());
            jsonObject.addProperty("BSSID", connectionInfo.getBSSID());
            jsonObject.addProperty("CPU_ABI", Build.CPU_ABI);
            jsonObject.addProperty("CPU_ABI2", Build.CPU_ABI2);
            jsonObject.addProperty("TimeZone", getProperty("persist.sys.timezone", "unknown"));
            jsonObject.addProperty("GL.Version", getProperty("ro.opengles.version", "unknown"));
            jsonObject.addProperty("DISPLAY", Build.DISPLAY);
            if (VERSION.SDK_INT >= 23) {
                jsonObject.addProperty("Build.VERSION.SECURITY_PATCH", VERSION.SECURITY_PATCH);
            }
            if (telephonyManager != null) {
                try {
                    jsonObject.addProperty("CellOperator", telephonyManager.getNetworkOperator());
                    jsonObject.addProperty("SimOperator", telephonyManager.getSimOperator());
                    jsonObject.addProperty("SimState", (Number) Integer.valueOf(telephonyManager.getSimState()));
                    jsonObject.addProperty("SimOperatorName", telephonyManager.getSimOperatorName());
                    jsonObject.addProperty("DeviceID", DeviceInfo.getPhoneIMEI(context));
                    jsonObject.addProperty("CellInformation", telephonyManager.getCellLocation().toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (VERSION.SDK_INT >= 21) {
                jsonObject.addProperty("SUPPORTED_ABIS", m9716f(Build.SUPPORTED_ABIS));
            }
            if (!Build.SERIAL.equals("unknown") || VERSION.SDK_INT <= 25) {
                jsonObject.addProperty("SERIAL", Build.SERIAL);
            } else {
                jsonObject.addProperty("SERIAL", Build.SERIAL);
            }
            return jsonObject.toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    /* renamed from: f */
    private static String m9716f(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        for (String append : strArr) {
            sb.append(append);
            sb.append(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
        }
        String sb2 = sb.toString();
        return sb2.substring(0, sb2.length() - 1);
    }

    private static String getProperty(String str, String str2) {
        try {
            Class cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{str});
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
        } catch (IllegalAccessException e3) {
            e3.printStackTrace();
        } catch (IllegalArgumentException e4) {
            e4.printStackTrace();
        } catch (InvocationTargetException e5) {
            e5.printStackTrace();
        }
        return str2;
    }
}
