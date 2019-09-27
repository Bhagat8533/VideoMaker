package com.introvd.template.datacenter;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.preference.PreferenceManager;
import com.introvd.template.router.editor.EditorRouter;
import java.util.LinkedHashMap;
import java.util.Map;

class TemplateDBHelper extends SqliteOpenHelperWithDaemon {
    private static final String APP_TEMPLATE_DB_NAME_EXTERNAL = "xy_template.db";
    private static volatile boolean CREATE_OVER = false;
    private static final String CREATE_OVER_KEY = "TEMPLATE_MOVE_OVER";
    private static final int TEMPLATE_DB_VERSION = 4;
    private static volatile int move_count;

    public TemplateDBHelper(Context context) {
        super(context, APP_TEMPLATE_DB_NAME_EXTERNAL, null, 4);
    }

    private String getMyAccountDatabaseBame(Context context) {
        String str;
        String str2;
        ContentResolver contentResolver = context.getContentResolver();
        Cursor query = contentResolver.query(SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_GENERAL_APP), new String[]{"value"}, "key = ?", new String[]{SocialServiceDef.XIAOYING_CURRENT_ACCOUNT}, null);
        if (query != null) {
            str = query.moveToFirst() ? query.getString(0) : null;
            query.close();
        } else {
            str = null;
        }
        if (str == null) {
            return null;
        }
        Cursor query2 = contentResolver.query(SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_SOCIAL_ACCOUNT), new String[]{"path"}, "uid = ?", new String[]{str}, null);
        if (query2 != null) {
            str2 = query2.moveToFirst() ? query2.getString(0) : null;
            query2.close();
        } else {
            str2 = null;
        }
        if (str2 == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append("_");
        sb.append(SocialConstDef.getUserDatabaseName(context));
        return sb.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003d, code lost:
        if (r2 != null) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004a, code lost:
        if (r2 != null) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004c, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004f, code lost:
        com.introvd.template.datacenter.TemplateDBRefactUtil.moveTemplate(r0, r7);
        com.introvd.template.datacenter.TemplateDBRefactUtil.moveTemplateRoll(r0, r7);
        com.introvd.template.datacenter.TemplateDBRefactUtil.moveTemplateRecommendRoll(r0, r7);
        com.introvd.template.datacenter.TemplateDBRefactUtil.moveTemplateRollMap(r0, r7);
        com.introvd.template.datacenter.TemplateDBRefactUtil.moveTemplateMonetization(r0, r7);
        com.introvd.template.datacenter.TemplateDBRefactUtil.moveTemplateFontInfo(r0, r7);
        com.introvd.template.datacenter.TemplateDBRefactUtil.moveTemplateScene(r0, r7);
        com.introvd.template.datacenter.TemplateDBRefactUtil.moveTemplatePackage(r0, r7);
        com.introvd.template.datacenter.TemplateDBRefactUtil.moveTemplateCard(r0, r7);
        com.introvd.template.datacenter.TemplateDBRefactUtil.moveTemplateInfo(r0, r7);
        com.introvd.template.datacenter.TemplateDBRefactUtil.moveTemplateInfoRecommend(r0, r7);
        com.introvd.template.datacenter.TemplateDBRefactUtil.moveTemplatePackageDetail(r0, r7);
        com.introvd.template.datacenter.TemplateDBRefactUtil.removeOldTemplate(r0);
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0079, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void moveDataFromOld(android.database.sqlite.SQLiteDatabase r7) {
        /*
            r6 = this;
            android.content.Context r0 = r6.mContext
            java.lang.String r0 = r6.getMyAccountDatabaseBame(r0)
            if (r0 != 0) goto L_0x0009
            return
        L_0x0009:
            java.lang.String r1 = com.introvd.template.datacenter.SocialConstDef.getDatabasePath()
            com.introvd.template.datacenter.SocialDBHelper r2 = new com.introvd.template.datacenter.SocialDBHelper
            android.content.Context r3 = r6.mContext
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r1)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            r2.<init>(r3, r0)
            android.database.sqlite.SQLiteDatabase r0 = r2.getWritableDatabase()
            r1 = 0
            java.lang.String r2 = "select name from sqlite_master where type='table'"
            android.database.Cursor r2 = r0.rawQuery(r2, r1)     // Catch:{ Exception -> 0x0043, all -> 0x0040 }
            if (r2 == 0) goto L_0x003d
        L_0x0030:
            boolean r1 = r2.moveToNext()     // Catch:{ Exception -> 0x003b }
            if (r1 == 0) goto L_0x003d
            r1 = 0
            r2.getString(r1)     // Catch:{ Exception -> 0x003b }
            goto L_0x0030
        L_0x003b:
            r1 = move-exception
            goto L_0x0047
        L_0x003d:
            if (r2 == 0) goto L_0x004f
            goto L_0x004c
        L_0x0040:
            r7 = move-exception
            r2 = r1
            goto L_0x007b
        L_0x0043:
            r2 = move-exception
            r5 = r2
            r2 = r1
            r1 = r5
        L_0x0047:
            r1.getStackTrace()     // Catch:{ all -> 0x007a }
            if (r2 == 0) goto L_0x004f
        L_0x004c:
            r2.close()
        L_0x004f:
            com.introvd.template.datacenter.TemplateDBRefactUtil.moveTemplate(r0, r7)
            com.introvd.template.datacenter.TemplateDBRefactUtil.moveTemplateRoll(r0, r7)
            com.introvd.template.datacenter.TemplateDBRefactUtil.moveTemplateRecommendRoll(r0, r7)
            com.introvd.template.datacenter.TemplateDBRefactUtil.moveTemplateRollMap(r0, r7)
            com.introvd.template.datacenter.TemplateDBRefactUtil.moveTemplateMonetization(r0, r7)
            com.introvd.template.datacenter.TemplateDBRefactUtil.moveTemplateFontInfo(r0, r7)
            com.introvd.template.datacenter.TemplateDBRefactUtil.moveTemplateScene(r0, r7)
            com.introvd.template.datacenter.TemplateDBRefactUtil.moveTemplatePackage(r0, r7)
            com.introvd.template.datacenter.TemplateDBRefactUtil.moveTemplateCard(r0, r7)
            com.introvd.template.datacenter.TemplateDBRefactUtil.moveTemplateInfo(r0, r7)
            com.introvd.template.datacenter.TemplateDBRefactUtil.moveTemplateInfoRecommend(r0, r7)
            com.introvd.template.datacenter.TemplateDBRefactUtil.moveTemplatePackageDetail(r0, r7)
            com.introvd.template.datacenter.TemplateDBRefactUtil.removeOldTemplate(r0)
            r0.close()
            return
        L_0x007a:
            r7 = move-exception
        L_0x007b:
            if (r2 == 0) goto L_0x0080
            r2.close()
        L_0x0080:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.introvd.template.datacenter.TemplateDBHelper.moveDataFromOld(android.database.sqlite.SQLiteDatabase):void");
    }

    private void onCreateRefTblOnTemplateCard(SQLiteDatabase sQLiteDatabase, String str, Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append(str);
        sb.append("( ");
        sb.append("_id");
        sb.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sb.append("ttid");
        sb.append(" TEXT not null, ");
        sb.append("updatetime");
        sb.append(" long, ");
        if (map != null && map.size() > 0) {
            for (String str2 : map.keySet()) {
                sb.append(str2);
                sb.append(" ");
                sb.append((String) map.get(str2));
                sb.append(" ");
            }
        }
        sb.append(" UNIQUE(");
        sb.append("ttid");
        if (map != null) {
            if (map.containsKey("groupcode")) {
                sb.append(", ");
                sb.append("groupcode");
            } else if (map.containsKey(SocialConstDef.TEMPLATE_INFO_SCENE_CODE)) {
                sb.append(", ");
                sb.append(SocialConstDef.TEMPLATE_INFO_SCENE_CODE);
            }
        }
        sb.append(")");
        sb.append(" );");
        ExecSQL(sQLiteDatabase, sb.toString());
    }

    private void onCreateTemplateCardTable(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append(SocialConstDef.TBL_NAME_TEMPLATE_CARD);
        sb.append("( ");
        sb.append("ttid");
        sb.append(" TEXT not null, ");
        sb.append("ver");
        sb.append(" TEXT, ");
        sb.append("tcid");
        sb.append(" TEXT, ");
        sb.append("title");
        sb.append(" TEXT, ");
        sb.append("intro");
        sb.append(" TEXT, ");
        sb.append("icon");
        sb.append(" TEXT, ");
        sb.append("previewurl");
        sb.append(" TEXT, ");
        sb.append("previewtype");
        sb.append(" TEXT, ");
        sb.append("lang");
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.TEMPLATE_CARD_MARK);
        sb.append(" INTEGER, ");
        sb.append("appminver");
        sb.append(" TEXT, ");
        sb.append("size");
        sb.append(" INTEGER, ");
        sb.append("scene");
        sb.append(" TEXT, ");
        sb.append("scene_code");
        sb.append(" TEXT default '0', ");
        sb.append(SocialConstDef.TEMPLATE_CARD_SCENE_ICON);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.TEMPLATE_CARD_AUTHORID);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.TEMPLATE_CARD_AUTHORNAME);
        sb.append(" TEXT, ");
        sb.append("publishtime");
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.TEMPLATE_CARD_LIKECOUNT);
        sb.append(" INTEGER, ");
        sb.append(SocialConstDef.TEMPLATE_CARD_DOWNCOUNT);
        sb.append(" INTEGER, ");
        sb.append("points");
        sb.append(" INTEGER, ");
        sb.append(SocialConstDef.TEMPLATE_CARD_AUDIOFLAG);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.TEMPLATE_CARD_SUBTCID);
        sb.append(" INTEGER, ");
        sb.append("url");
        sb.append(" TEXT, ");
        sb.append("mission");
        sb.append(" TEXT, ");
        sb.append("mresult");
        sb.append(" TEXT, ");
        sb.append("duration");
        sb.append(" TEXT, ");
        sb.append("updatetime");
        sb.append(" long, ");
        sb.append(SocialConstDef.TEMPLATE_CARD_ICONCOLOR);
        sb.append(" TEXT, ");
        sb.append("bigicon");
        sb.append(" TEXT, ");
        sb.append(" UNIQUE(");
        sb.append("ttid");
        sb.append(")");
        sb.append(" );");
        ExecSQL(sQLiteDatabase, sb.toString());
    }

    private void onCreateTemplateCardsNewAndRef(SQLiteDatabase sQLiteDatabase) {
        onCreateTemplateCardTable(sQLiteDatabase);
        Map prepareTemplateInfoAppendField = prepareTemplateInfoAppendField();
        onCreateRefTblOnTemplateCard(sQLiteDatabase, SocialConstDef.TBL_NAME_TEMPLATE_INFO, prepareTemplateInfoAppendField);
        onCreateViewOnTemplateCard(sQLiteDatabase, SocialConstDef.TBL_NAME_TEMPLATE_INFO, SocialConstDef.VIEW_NAME_TEMPLATE_INFO);
        prepareTemplateInfoAppendField.clear();
        prepareTemplateInfoAppendField.put("groupcode", " TEXT not null, ");
        prepareTemplateInfoAppendField.put("orderno", " INTEGER, ");
        prepareTemplateInfoAppendField.put("tcid", " TEXT not null, ");
        prepareTemplateInfoAppendField.put(SocialConstDef.TEMPLATE_PACKAGE_DETAIL_SCENE_CODE, " TEXT, ");
        prepareTemplateInfoAppendField.put(SocialConstDef.TEMPLATE_PACKAGE_DETAIL_SCENE_NAME, " TEXT, ");
        prepareTemplateInfoAppendField.put(SocialConstDef.TEMPLATE_PACKAGE_DETAIL_SCENE_ICON, " TEXT, ");
        onCreateRefTblOnTemplateCard(sQLiteDatabase, SocialConstDef.TBL_NAME_TEMPLATE_PACKAGE_DETAIL, prepareTemplateInfoAppendField);
        onCreateViewOnTemplateCard(sQLiteDatabase, SocialConstDef.TBL_NAME_TEMPLATE_PACKAGE_DETAIL, SocialConstDef.VIEW_NAME_TEMPLATE_PACKAGE_DETAIL);
    }

    private void onCreateTemplateInfoRecommendTable(SQLiteDatabase sQLiteDatabase) {
        onCreateRefTblOnTemplateCard(sQLiteDatabase, SocialConstDef.TBL_NAME_TEMPLATE_INFO_RECOMMEND, prepareTemplateInfoAppendField());
    }

    private void onCreateTemplateMonetization(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append(SocialConstDef.TBL_NAME_TEMPLATE_MONETIZATION);
        sb.append("( ");
        sb.append("ttid");
        sb.append(" TEXT PRIMARY KEY, ");
        sb.append("tcid");
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.TEMPLATEMONETIZATION_ITEM_TODOCODE);
        sb.append(" INTEGER, ");
        sb.append(SocialConstDef.TEMPLATEMONETIZATION_ITEM_TODOCONTENT);
        sb.append(" TEXT, ");
        sb.append("expiretime");
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.TEMPLATEMONETIZATION_ITEM_LOCKSTATE);
        sb.append(" INTEGER, ");
        sb.append("previewurl");
        sb.append(" TEXT, ");
        sb.append("previewtype");
        sb.append(" INTEGER, ");
        sb.append("title");
        sb.append(" TEXT, ");
        sb.append("intro");
        sb.append(" TEXT, ");
        sb.append("iconurl");
        sb.append(" TEXT ");
        sb.append(" );");
        ExecSQL(sQLiteDatabase, sb.toString());
    }

    private void onCreateTemplatePackageTable(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append(SocialConstDef.TBL_NAME_TEMPLATE_PACKAGE);
        sb.append("( ");
        sb.append("groupcode");
        sb.append(" TEXT PRIMARY KEY, ");
        sb.append("lang");
        sb.append(" TEXT, ");
        sb.append("appminver");
        sb.append(" TEXT, ");
        sb.append("size");
        sb.append(" INTEGER, ");
        sb.append("publishtime");
        sb.append(" TEXT, ");
        sb.append("expiredtime");
        sb.append(" TEXT, ");
        sb.append("orderno");
        sb.append(" INTEGER, ");
        sb.append("cover");
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.TEMPLATE_PACKAGE_BANNER);
        sb.append(" TEXT, ");
        sb.append("desc");
        sb.append(" TEXT, ");
        sb.append("title");
        sb.append(" TEXT, ");
        sb.append("modelcode");
        sb.append(" TEXT, ");
        sb.append("newcount");
        sb.append(" INTEGER ");
        sb.append(" );");
        ExecSQL(sQLiteDatabase, sb.toString());
    }

    private void onCreateTemplateRollMapTable(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append(SocialConstDef.TBL_NAME_TEMPLATE_ROLL_MAP);
        sb.append("( ");
        sb.append(SocialConstDef.TEMPLATEROLLMAP_ITEM_ROLLCODE);
        sb.append(" TEXT , ");
        sb.append("ttid");
        sb.append(" LONG ");
        sb.append(" );");
        ExecSQL(sQLiteDatabase, sb.toString());
    }

    private void onCreateTemplateRollTable(SQLiteDatabase sQLiteDatabase, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append(str);
        sb.append("( ");
        sb.append("code");
        sb.append(" TEXT PRIMARY KEY, ");
        sb.append("tcid");
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.TEMPLATE_ROLL_ENGINEVER);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.TEMPLATE_ROLL_DOWNURL);
        sb.append(" TEXT, ");
        sb.append("lang");
        sb.append(" TEXT, ");
        sb.append("price");
        sb.append(" TEXT, ");
        sb.append("newflag");
        sb.append(" INTEGER,");
        sb.append(SocialConstDef.TEMPLATE_ROLL_ISSHOW);
        sb.append(" INTEGER default 0,");
        sb.append(SocialConstDef.TEMPLATE_ROLL_WORDINFO);
        sb.append(" TEXT, ");
        sb.append("orderno");
        sb.append(" TEXT, ");
        sb.append("subtype");
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.TEMPLATE_ROLL_XYTINFO);
        sb.append(" TEXT ");
        sb.append(" );");
        ExecSQL(sQLiteDatabase, sb.toString());
    }

    private void onCreateTemplateSceneTable(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append(SocialConstDef.TBL_NAME_TEMPLATE_SCENE);
        sb.append("( ");
        sb.append("tcid");
        sb.append(" TEXT not null, ");
        sb.append("scene_code");
        sb.append(" TEXT default '0', ");
        sb.append("orderNo");
        sb.append(" INTEGER, ");
        sb.append("lang");
        sb.append(" TEXT, ");
        sb.append("name");
        sb.append(" TEXT, ");
        sb.append("desc");
        sb.append(" TEXT, ");
        sb.append("thumb");
        sb.append(" TEXT, ");
        sb.append("newcount");
        sb.append(" INTEGER, ");
        sb.append(SocialConstDef.TEMPLATE_SCENE_FROMTYPE);
        sb.append(" INTEGER, ");
        sb.append("color");
        sb.append(" TEXT, ");
        sb.append("bigicon");
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.TEMPLATE_SCENE_PREVIEW_VIDEO);
        sb.append(" TEXT, ");
        sb.append("imgurl");
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.TEMPLATE_SCENE_INSTAGRAM_IMG_LIST);
        sb.append(" TEXT, ");
        sb.append(" UNIQUE(");
        sb.append("tcid");
        sb.append(EditorRouter.KEY_TOOL_LIST_ORDER_SPLIT_OP);
        sb.append("scene_code");
        sb.append(")");
        sb.append(" );");
        ExecSQL(sQLiteDatabase, sb.toString());
    }

    private void onCreateTemplateTable(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append(SocialConstDef.TBL_NAME_TEMPLATE);
        sb.append("( ");
        sb.append(SocialConstDef.TEMPLATE_ID);
        sb.append(" LONG PRIMARY KEY, ");
        sb.append("title");
        sb.append(" TEXT, ");
        sb.append("points");
        sb.append(" REAL, ");
        sb.append("price");
        sb.append(" REAL, ");
        sb.append("logo");
        sb.append(" TEXT, ");
        sb.append("url");
        sb.append(" TEXT, ");
        sb.append("from_type");
        sb.append(" INTEGER, ");
        sb.append("orderno");
        sb.append(" INTEGER DEFAULT 2147483647, ");
        sb.append("ver");
        sb.append(" INTEGER, ");
        sb.append("updatetime");
        sb.append(" LONG, ");
        sb.append(SocialConstDef.TEMPLATE_FAVORITE);
        sb.append(" INTEGER, ");
        sb.append(SocialConstDef.TEMPLATE_SUB_ORDERNO);
        sb.append(" INTEGER, ");
        sb.append("layout");
        sb.append(" INTEGER, ");
        sb.append(SocialConstDef.TEMPLATE_EXT_INFO);
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.TEMPLATE_CONFIGURE_COUNT);
        sb.append(" INTEGER DEFAULT 0, ");
        sb.append("downFlag");
        sb.append(" INTEGER DEFAULT 0, ");
        sb.append("description");
        sb.append(" TEXT, ");
        sb.append("mission");
        sb.append(" TEXT, ");
        sb.append("mresult");
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.TEMPLATE_DELETE_FLAG);
        sb.append(" INTEGER DEFAULT 0, ");
        sb.append("scene_code");
        sb.append(" TEXT, ");
        sb.append(SocialConstDef.TEMPLATE_APP_FLAG);
        sb.append(" INTEGER DEFAULT 0 ");
        sb.append(")");
        ExecSQL(sQLiteDatabase, sb.toString());
    }

    private void onCreateViewOnTemplateCard(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append("create view IF NOT EXISTS ");
        sb.append(str2);
        sb.append(" as select ");
        sb.append(SocialConstDef.TBL_NAME_TEMPLATE_CARD);
        sb.append(".*, ");
        sb.append(str);
        sb.append(".* from ");
        sb.append(str);
        sb.append(" left join ");
        sb.append(SocialConstDef.TBL_NAME_TEMPLATE_CARD);
        sb.append(" where ");
        sb.append(SocialConstDef.TBL_NAME_TEMPLATE_CARD);
        sb.append(".ttid = ");
        sb.append(str);
        sb.append(".ttid");
        sb.append(" order by ");
        sb.append(str);
        sb.append(".");
        sb.append("_id");
        ExecSQL(sQLiteDatabase, sb.toString());
    }

    private Map<String, String> prepareTemplateInfoAppendField() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("orderno", " INTEGER, ");
        linkedHashMap.put("tcid", " TEXT not null, ");
        linkedHashMap.put(SocialConstDef.TEMPLATE_INFO_SCENE_CODE, " TEXT, ");
        linkedHashMap.put(SocialConstDef.TEMPLATE_INFO_SCENE_NAME, " TEXT, ");
        linkedHashMap.put(SocialConstDef.TEMPLATE_INFO_SCENE_ICON, " TEXT, ");
        linkedHashMap.put(SocialConstDef.TEMPLATE_CARD_AUDIOFLAG, " INTEGER, ");
        linkedHashMap.put(SocialConstDef.TEMPLATE_CARD_SUBTCID, " TEXT, ");
        return linkedHashMap;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        onCreateTemplateTable(sQLiteDatabase);
        onCreateTemplateRollTable(sQLiteDatabase, SocialConstDef.TBL_NAME_TEMPLATE_ROLL);
        onCreateTemplateRollTable(sQLiteDatabase, SocialConstDef.TBL_NAME_TEMPLATE_RECOMMEND_ROLL);
        onCreateTemplateRollMapTable(sQLiteDatabase);
        onCreateTemplateMonetization(sQLiteDatabase);
        onCreateTemplateFontInfoTable(sQLiteDatabase);
        onCreateTemplateSceneTable(sQLiteDatabase);
        onCreateTemplatePackageTable(sQLiteDatabase);
        onCreateTemplateCardsNewAndRef(sQLiteDatabase);
        onCreateTemplateInfoRecommendTable(sQLiteDatabase);
        if (!CREATE_OVER) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.mContext);
            CREATE_OVER = defaultSharedPreferences.getBoolean(CREATE_OVER_KEY, false);
            if (!CREATE_OVER) {
                synchronized (TemplateDBHelper.class) {
                    move_count++;
                    CREATE_OVER = true;
                    Editor edit = defaultSharedPreferences.edit();
                    edit.putBoolean(CREATE_OVER_KEY, true);
                    edit.apply();
                }
                if (move_count == 1) {
                    moveDataFromOld(sQLiteDatabase);
                }
            }
        }
    }

    public void onCreateTemplateFontInfoTable(SQLiteDatabase sQLiteDatabase) {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE IF NOT EXISTS ");
        sb.append(SocialConstDef.TBL_NAME_TEMPLATE_FONT_INFO);
        sb.append("( ");
        sb.append("ttid");
        sb.append(" LONG PRIMARY KEY, ");
        sb.append("tcid");
        sb.append(" TEXT,");
        sb.append("iconurl");
        sb.append(" TEXT,");
        sb.append(SocialConstDef.TEMPLATEFONTINFO_ITEM_NAME);
        sb.append(" TEXT,");
        sb.append(SocialConstDef.TEMPLATEFONTINFO_ITEM_ORDERNUM);
        sb.append(" INTEGER DEFAULT 0,");
        sb.append(SocialConstDef.TEMPLATEFONTINFO_ITEM_LOCALPATH);
        sb.append(" TEXT );");
        ExecSQL(sQLiteDatabase, sb.toString());
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (i < 2) {
            StringBuilder sb = new StringBuilder();
            sb.append("ALTER TABLE ");
            sb.append(SocialConstDef.TBL_NAME_TEMPLATE_CARD);
            sb.append(" ADD ");
            sb.append(SocialConstDef.TEMPLATE_CARD_SCENE_ICON);
            sb.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ALTER TABLE ");
            sb2.append(SocialConstDef.TBL_NAME_TEMPLATE_INFO_RECOMMEND);
            sb2.append(" ADD ");
            sb2.append(SocialConstDef.TEMPLATE_INFO_SCENE_ICON);
            sb2.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append("ALTER TABLE ");
            sb3.append(SocialConstDef.TBL_NAME_TEMPLATE_INFO);
            sb3.append(" ADD ");
            sb3.append(SocialConstDef.TEMPLATE_INFO_SCENE_ICON);
            sb3.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb3.toString());
            StringBuilder sb4 = new StringBuilder();
            sb4.append("ALTER TABLE ");
            sb4.append(SocialConstDef.TBL_NAME_TEMPLATE_PACKAGE_DETAIL);
            sb4.append(" ADD ");
            sb4.append(SocialConstDef.TEMPLATE_PACKAGE_DETAIL_SCENE_ICON);
            sb4.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb4.toString());
        }
        if (i < 3) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("ALTER TABLE ");
            sb5.append(SocialConstDef.TBL_NAME_TEMPLATE_CARD);
            sb5.append(" ADD ");
            sb5.append(SocialConstDef.TEMPLATE_CARD_AUDIOFLAG);
            sb5.append(" INTEGER;");
            ExecSQL(sQLiteDatabase, sb5.toString());
            StringBuilder sb6 = new StringBuilder();
            sb6.append("ALTER TABLE ");
            sb6.append(SocialConstDef.TBL_NAME_TEMPLATE_INFO);
            sb6.append(" ADD ");
            sb6.append(SocialConstDef.TEMPLATE_CARD_AUDIOFLAG);
            sb6.append(" INTEGER;");
            ExecSQL(sQLiteDatabase, sb6.toString());
            StringBuilder sb7 = new StringBuilder();
            sb7.append("ALTER TABLE ");
            sb7.append(SocialConstDef.TBL_NAME_TEMPLATE_INFO_RECOMMEND);
            sb7.append(" ADD ");
            sb7.append(SocialConstDef.TEMPLATE_CARD_AUDIOFLAG);
            sb7.append(" INTEGER;");
            ExecSQL(sQLiteDatabase, sb7.toString());
        }
        if (i < 4) {
            StringBuilder sb8 = new StringBuilder();
            sb8.append("ALTER TABLE ");
            sb8.append(SocialConstDef.TBL_NAME_TEMPLATE_CARD);
            sb8.append(" ADD ");
            sb8.append(SocialConstDef.TEMPLATE_CARD_SUBTCID);
            sb8.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb8.toString());
            StringBuilder sb9 = new StringBuilder();
            sb9.append("ALTER TABLE ");
            sb9.append(SocialConstDef.TBL_NAME_TEMPLATE_INFO);
            sb9.append(" ADD ");
            sb9.append(SocialConstDef.TEMPLATE_CARD_SUBTCID);
            sb9.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb9.toString());
            StringBuilder sb10 = new StringBuilder();
            sb10.append("ALTER TABLE ");
            sb10.append(SocialConstDef.TBL_NAME_TEMPLATE_INFO_RECOMMEND);
            sb10.append(" ADD ");
            sb10.append(SocialConstDef.TEMPLATE_CARD_SUBTCID);
            sb10.append(" TEXT;");
            ExecSQL(sQLiteDatabase, sb10.toString());
        }
    }
}
