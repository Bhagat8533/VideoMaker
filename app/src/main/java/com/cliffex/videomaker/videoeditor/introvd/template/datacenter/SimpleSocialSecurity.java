package com.introvd.template.datacenter;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.introvd.template.router.BizServiceManager;
import com.introvd.template.router.editor.IEditorService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import xiaoying.utils.QKeyGenerator;
import xiaoying.utils.QSecurityUtil;

public class SimpleSocialSecurity implements SocialSecurity {
    private static final String DES_KEY_SEED = "k3";
    private static SimpleSocialSecurity INSTANCE = null;
    private static final String RSA_KEY_PREFIX = "SESetting";
    private static final int RSA_KEY_SIZE = 256;
    private static final String SECURITY_VERSION_V1 = "XYSEPV1";
    private HashMap<String, List<String>> mSecurityFieldMap = new HashMap<>();
    private HashMap<String, Object> mSecurityKeyMap = new HashMap<>();

    public static synchronized SimpleSocialSecurity getInstance(Context context) {
        SimpleSocialSecurity simpleSocialSecurity;
        synchronized (SimpleSocialSecurity.class) {
            if (INSTANCE != null) {
                SimpleSocialSecurity simpleSocialSecurity2 = INSTANCE;
                return simpleSocialSecurity2;
            }
            simpleSocialSecurity = new SimpleSocialSecurity();
            try {
                initSecurity(context, simpleSocialSecurity);
            } catch (NoClassDefFoundError unused) {
            }
        }
        return simpleSocialSecurity;
    }

    private static String getProviderSecretKey(String str) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(SECURITY_VERSION_V1);
            sb.append(str);
            return QSecurityUtil.makeSecretKey(sb.toString());
        } catch (Throwable unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(SECURITY_VERSION_V1);
            sb2.append(str);
            return sb2.toString();
        }
    }

    private static Map<String, String> getRSAKeyPair(Context context) throws IllegalStateException {
        HashMap hashMap = new HashMap();
        Uri tableUri = SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_GENERAL_APP);
        ContentResolver contentResolver = context.getContentResolver();
        ContentResolver contentResolver2 = contentResolver;
        Uri uri = tableUri;
        Cursor query = contentResolver2.query(uri, null, "key like ?", new String[]{"SESetting%"}, null);
        if (query != null) {
            while (query.moveToNext()) {
                String string = query.getString(query.getColumnIndex("key"));
                String string2 = query.getString(query.getColumnIndex("value"));
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                    if (string.equals("SESettingk2")) {
                        hashMap.put(QKeyGenerator.PRIVATE_KEY, string2);
                    } else if (string.equals("SESettingk1")) {
                        hashMap.put(QKeyGenerator.PUBLIC_KEY, string2);
                    } else if (string.equals("SESettingk3")) {
                        hashMap.put(DES_KEY_SEED, string2);
                    }
                }
            }
            query.close();
            String str = (String) hashMap.get(DES_KEY_SEED);
            if (!TextUtils.isEmpty(str)) {
                String providerSecretKey = getProviderSecretKey(str);
                String str2 = (String) hashMap.remove(QKeyGenerator.PRIVATE_KEY);
                if (!TextUtils.isEmpty(str2)) {
                    hashMap.put(QKeyGenerator.PRIVATE_KEY, QSecurityUtil.decrypt("DES", providerSecretKey, str2));
                }
                String str3 = (String) hashMap.remove(QKeyGenerator.PUBLIC_KEY);
                if (!TextUtils.isEmpty(str3)) {
                    hashMap.put(QKeyGenerator.PUBLIC_KEY, QSecurityUtil.decrypt("DES", providerSecretKey, str3));
                }
            }
        }
        if (hashMap.get(QKeyGenerator.PUBLIC_KEY) == null || hashMap.get(QKeyGenerator.PRIVATE_KEY) == null || hashMap.get(DES_KEY_SEED) == null) {
            int nextInt = new Random(System.currentTimeMillis()).nextInt() + 123456;
            if (nextInt < 0) {
                nextInt = -nextInt;
            }
            char c = (char) (((nextInt / 52) % 52) + 65);
            char c2 = (char) ((nextInt % 52) + 65);
            StringBuilder sb = new StringBuilder();
            sb.append(c);
            sb.append(String.valueOf(nextInt));
            sb.append(c2);
            String sb2 = sb.toString();
            hashMap.put(DES_KEY_SEED, sb2);
            Map make = QKeyGenerator.make(256);
            if (!make.isEmpty()) {
                hashMap.putAll(make);
                ContentValues contentValues = new ContentValues();
                contentValues.put("key", "SESettingk3");
                contentValues.put("value", sb2);
                contentResolver.insert(tableUri, contentValues);
                String providerSecretKey2 = getProviderSecretKey(sb2);
                contentValues.clear();
                String encrypt = QSecurityUtil.encrypt("DES", providerSecretKey2, (String) hashMap.get(QKeyGenerator.PRIVATE_KEY));
                contentValues.put("key", "SESettingk2");
                contentValues.put("value", encrypt);
                contentResolver.insert(tableUri, contentValues);
                contentValues.clear();
                String encrypt2 = QSecurityUtil.encrypt("DES", providerSecretKey2, (String) hashMap.get(QKeyGenerator.PUBLIC_KEY));
                contentValues.put("key", "SESettingk1");
                contentValues.put("value", encrypt2);
                contentResolver.insert(tableUri, contentValues);
            }
        }
        return hashMap;
    }

    private static synchronized void initSecurity(Context context, SimpleSocialSecurity simpleSocialSecurity) {
        Object obj;
        synchronized (SimpleSocialSecurity.class) {
            IEditorService iEditorService = (IEditorService) BizServiceManager.getService(IEditorService.class);
            boolean z = false;
            if (iEditorService != null) {
                iEditorService.libraryMgrSetContext(context);
                z = iEditorService.loadLibraryBaseMode();
            }
            if (z) {
                try {
                    obj = getRSAKeyPair(context);
                } catch (Exception unused) {
                    obj = null;
                }
                if (obj != null) {
                    simpleSocialSecurity.setSecurityKey(SocialConstDef.TBL_NAME_TEMPLATE, obj);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add("mission");
                    arrayList.add("mresult");
                    simpleSocialSecurity.setSecurityFields(SocialConstDef.TBL_NAME_TEMPLATE, arrayList);
                }
            }
        }
    }

    private void setSecurityFields(String str, List<String> list) {
        this.mSecurityFieldMap.put(str, list);
    }

    private void setSecurityKey(String str, Object obj) {
        this.mSecurityKeyMap.put(str, obj);
    }

    public String createMD5Encrypt(String str, String str2) {
        try {
            return QSecurityUtil.encrypt("MD5", str, str2);
        } catch (NoClassDefFoundError unused) {
            return str;
        }
    }

    public String makeAppSecretKey(String str, String str2, String str3) {
        try {
            return QSecurityUtil.makeAppSecretKey(str, str2, str3);
        } catch (NoClassDefFoundError unused) {
            return str;
        }
    }

    public String makeSecretKey(String str) {
        try {
            return QSecurityUtil.makeSecretKey(str);
        } catch (NoClassDefFoundError unused) {
            return str;
        }
    }

    public String onDecrypt(String str, String str2, String str3) {
        try {
            if (TextUtils.isEmpty(str3)) {
                return str3;
            }
            Object obj = this.mSecurityKeyMap.get(str);
            if (obj != null) {
                if (obj instanceof Map) {
                    List list = (List) this.mSecurityFieldMap.get(str);
                    if (list != null) {
                        if (list.contains(str2)) {
                            String str4 = (String) ((Map) obj).get(QKeyGenerator.PUBLIC_KEY);
                            if (str4 == null) {
                                return null;
                            }
                            String decrypt = QSecurityUtil.decrypt("DES", str4, str3);
                            if (TextUtils.isEmpty(decrypt)) {
                                decrypt = str3;
                            }
                            return decrypt;
                        }
                    }
                    return str3;
                }
            }
            return str3;
        } catch (NoClassDefFoundError unused) {
            return str3;
        }
    }

    public String onEncrypt(String str, String str2, String str3) {
        try {
            if (TextUtils.isEmpty(str3)) {
                return str3;
            }
            Object obj = this.mSecurityKeyMap.get(str);
            if (obj != null) {
                if (obj instanceof Map) {
                    List list = (List) this.mSecurityFieldMap.get(str);
                    if (list != null) {
                        if (list.contains(str2)) {
                            String str4 = (String) ((Map) obj).get(QKeyGenerator.PUBLIC_KEY);
                            if (str4 == null) {
                                return null;
                            }
                            String encrypt = QSecurityUtil.encrypt("DES", str4, str3);
                            if (TextUtils.isEmpty(encrypt)) {
                                encrypt = "";
                            }
                            return encrypt;
                        }
                    }
                    return str3;
                }
            }
            return str3;
        } catch (NoClassDefFoundError unused) {
            return str3;
        }
    }
}
