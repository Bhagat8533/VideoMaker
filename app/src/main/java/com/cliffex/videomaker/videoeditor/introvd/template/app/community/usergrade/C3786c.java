package com.introvd.template.app.community.usergrade;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.introvd.template.app.utils.C4395c;
import com.introvd.template.common.model.AppStateModel;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.datacenter.SocialServiceDef;
import com.introvd.template.p203b.C4580b;
import com.introvd.template.router.user.UserServiceProxy;
import com.introvd.template.router.user.model.PrivilegeGoods;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p037b.p050b.C1848s;
import p037b.p050b.C1850u;
import p037b.p050b.p054b.C1495b;
import p037b.p050b.p057e.C1518f;
import p037b.p050b.p076j.C1820a;

/* renamed from: com.introvd.template.app.community.usergrade.c */
public class C3786c {
    /* access modifiers changed from: private */
    public HashMap<String, List<C3785b>> bkF;
    /* access modifiers changed from: private */
    public boolean bkG;

    /* renamed from: com.introvd.template.app.community.usergrade.c$a */
    public interface C3789a {
        /* renamed from: L */
        void mo23272L(List<C3785b> list);
    }

    /* renamed from: com.introvd.template.app.community.usergrade.c$b */
    private static class C3790b {
        /* access modifiers changed from: private */
        public static final C3786c bkK = new C3786c();
    }

    private C3786c() {
        this.bkF = new HashMap<>();
    }

    /* renamed from: Iv */
    public static C3786c m9273Iv() {
        return C3790b.bkK;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m9278b(Context context, String str, List<PrivilegeGoods> list) {
        ContentResolver contentResolver = context.getContentResolver();
        Uri tableUri = SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_XY_GOODS_ITEM_INFO);
        if (TextUtils.isEmpty(str)) {
            contentResolver.delete(tableUri, "type LIKE ?", new String[]{"Privilege_%"});
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(SocialServiceDef.GOODS_ITEM_INFO_TYPE_PRIVILEGE_BASE);
            sb.append(str);
            contentResolver.delete(tableUri, "type =?", new String[]{sb.toString()});
            ContentResolver contentResolver2 = contentResolver;
            Uri uri = tableUri;
            Cursor query = contentResolver2.query(uri, new String[]{SocialConstDef.XY_GOODS_ITEM_INFO_ID, SocialConstDef.XY_GOODS_ITEM_INFO_EXTRAINFO}, "type =?", new String[]{SocialServiceDef.GOODS_ITEM_INFO_TYPE_PRIVILEGE_PACKAGE}, null);
            if (query != null) {
                while (query.moveToNext()) {
                    String string = query.getString(0);
                    try {
                        String optString = new JSONObject(query.getString(0)).optString("gift");
                        if (!TextUtils.isEmpty(optString) && optString.contains(str)) {
                            contentResolver.delete(tableUri, "goodsid =?", new String[]{string});
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                query.close();
            }
        }
        try {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                PrivilegeGoods privilegeGoods = (PrivilegeGoods) list.get(i);
                ContentValues contentValues = new ContentValues();
                String valueOf = String.valueOf(privilegeGoods.f3588id);
                contentValues.put(SocialConstDef.XY_GOODS_ITEM_INFO_ID, valueOf);
                int i2 = privilegeGoods.flag;
                JSONArray jSONArray = new JSONArray(privilegeGoods.gift);
                if (i2 == 1) {
                    contentValues.put("type", SocialServiceDef.GOODS_ITEM_INFO_TYPE_PRIVILEGE_PACKAGE);
                } else if (i2 == 0) {
                    String string2 = jSONArray.getString(0);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(SocialServiceDef.GOODS_ITEM_INFO_TYPE_PRIVILEGE_BASE);
                    sb2.append(string2);
                    contentValues.put("type", sb2.toString());
                }
                int i3 = privilegeGoods.nowPrice;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("XY$");
                sb3.append(i3);
                contentValues.put("price", sb3.toString());
                contentValues.put("title", privilegeGoods.title);
                contentValues.put("desc", privilegeGoods.content);
                contentValues.put(SocialConstDef.XY_GOODS_ITEM_INFO_EXTRAINFO, new Gson().toJson((Object) privilegeGoods));
                if (contentResolver.update(tableUri, contentValues, "goodsid =?", new String[]{valueOf}) <= 0) {
                    contentResolver.insert(tableUri, contentValues);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: bY */
    public void m9279bY(Context context) {
        Cursor query = context.getContentResolver().query(SocialConstDef.getTableUri(SocialConstDef.TBL_NAME_XY_GOODS_ITEM_INFO), null, "type like ?", new String[]{"Privilege_%"}, null);
        if (query != null) {
            this.bkF.clear();
            while (query.moveToNext()) {
                C3785b h = m9280h(query);
                if (h != null) {
                    try {
                        JSONArray jSONArray = new JSONArray(h.bkD);
                        for (int i = 0; i < jSONArray.length(); i++) {
                            String string = jSONArray.getString(i);
                            if (this.bkF.containsKey(string)) {
                                List list = (List) this.bkF.get(string);
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= list.size()) {
                                        break;
                                    }
                                    if (h.bkE < ((C3785b) list.get(i2)).bkE) {
                                        list.add(i2, h);
                                        break;
                                    }
                                    i2++;
                                }
                                list.add(h);
                            } else {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(h);
                                this.bkF.put(string, arrayList);
                            }
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
            query.close();
        }
    }

    /* renamed from: h */
    private C3785b m9280h(Cursor cursor) {
        C3785b bVar = new C3785b();
        bVar.f3376id = cursor.getString(cursor.getColumnIndex(SocialConstDef.XY_GOODS_ITEM_INFO_ID));
        String string = cursor.getString(cursor.getColumnIndex(SocialConstDef.XY_GOODS_ITEM_INFO_EXTRAINFO));
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            bVar.title = jSONObject.optString("title");
            bVar.desc = jSONObject.optString("content");
            bVar.flag = jSONObject.optInt("flag");
            bVar.bkD = jSONObject.optString("gift");
            bVar.price = jSONObject.optInt("price");
            bVar.bkE = jSONObject.optInt("nowPrice");
            bVar.startTime = C4395c.m11101ei(jSONObject.optString(SocialConstDef.ACTIVITY_LIST_STARTTIME));
            bVar.endTime = C4395c.m11101ei(jSONObject.optString(SocialConstDef.ACTIVITY_LIST_ENDTIME));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return bVar;
    }

    /* renamed from: a */
    public void mo23269a(final Context context, final String str, final C3789a aVar) {
        if (!this.bkG) {
            this.bkG = true;
            C1848s privilegeGoodsInfo = UserServiceProxy.getPrivilegeGoodsInfo(null, AppStateModel.getInstance().getCountryCode(), C4580b.m11635Si());
            if (privilegeGoodsInfo != null) {
                privilegeGoodsInfo.mo10196g(C1820a.aVi()).mo10194f(C1820a.aVi()).mo10199i(new C1518f<List<PrivilegeGoods>, Boolean>() {
                    /* renamed from: K */
                    public Boolean apply(List<PrivilegeGoods> list) {
                        C3786c.this.m9278b(context, null, list);
                        return Boolean.valueOf(true);
                    }
                }).mo10188a((C1850u<? super T>) new C1850u<Boolean>() {
                    /* renamed from: a */
                    public void mo9883a(C1495b bVar) {
                    }

                    /* renamed from: e */
                    public void onSuccess(Boolean bool) {
                        C3786c.this.m9279bY(context);
                        if (aVar != null) {
                            aVar.mo23272L((List) C3786c.this.bkF.get(str));
                        }
                        C3786c.this.bkG = false;
                    }

                    public void onError(Throwable th) {
                        if (aVar != null) {
                            aVar.mo23272L((List) C3786c.this.bkF.get(str));
                        }
                        C3786c.this.bkG = false;
                    }
                });
            }
        }
    }
}
