package com.introvd.template.module.iap;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.introvd.template.apicore.C3635l;
import com.introvd.template.common.ResultListener;
import com.introvd.template.module.C7571a;
import com.introvd.template.module.C7685b;
import com.introvd.template.module.C7688c;
import com.introvd.template.module.C7691e;
import com.introvd.template.module.iap.business.C7833b;
import com.introvd.template.module.iap.business.p349a.p351b.C7830c;
import com.introvd.template.module.iap.business.p349a.p351b.C7831d;
import com.introvd.template.router.user.UserRouter.BroadCastConstant;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import p037b.p050b.C1848s;

/* renamed from: com.introvd.template.module.iap.e */
public class C8048e extends C7685b implements C8052g {
    private static C8048e dOs;
    private static C7691e dOt = new C7688c();

    public C8048e(C7571a aVar) {
        super(aVar);
    }

    /* renamed from: a */
    public static void m23272a(C7691e eVar) {
        dOt = eVar;
        dOs = new C8048e(eVar);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(BroadCastConstant.ACTION_LOGIN_CB_SUCCESS);
        intentFilter.addAction(BroadCastConstant.ACTION_LOGOUT_SUCCESS);
    }

    public static C8052g aBe() {
        if (dOs == null) {
            dOs = new C8048e(dOt);
        }
        return dOs;
    }

    /* renamed from: C */
    public Drawable mo23605C(Drawable drawable) {
        return dOt.mo23605C(drawable);
    }

    /* renamed from: IX */
    public int mo23606IX() {
        return dOt.mo23606IX();
    }

    /* renamed from: K */
    public void mo23608K(Activity activity) {
        dOt.mo23608K(activity);
    }

    /* renamed from: MA */
    public C1848s<JSONObject> mo23609MA() {
        return dOt.mo23609MA();
    }

    /* renamed from: MB */
    public boolean mo23610MB() {
        return dOt.mo23610MB();
    }

    /* renamed from: MC */
    public boolean mo23611MC() {
        return dOt.mo23611MC();
    }

    /* renamed from: MD */
    public boolean mo23612MD() {
        return dOt.mo23612MD();
    }

    /* renamed from: ME */
    public String mo23613ME() {
        return dOt.mo23613ME();
    }

    /* renamed from: MF */
    public void mo23614MF() {
        dOt.mo23614MF();
    }

    /* renamed from: MG */
    public boolean mo23615MG() {
        return dOt.mo23615MG();
    }

    /* renamed from: MH */
    public boolean mo23616MH() {
        return dOt.mo23616MH();
    }

    /* renamed from: Mi */
    public boolean mo23618Mi() {
        return dOt.mo23618Mi();
    }

    /* renamed from: Mm */
    public void mo23621Mm() {
        dOt.mo23621Mm();
    }

    /* renamed from: Mo */
    public void mo23623Mo() {
        dOt.mo23623Mo();
    }

    /* renamed from: Mp */
    public String mo23624Mp() {
        return C7833b.aBB();
    }

    /* renamed from: Mq */
    public String mo23625Mq() {
        return "iap_state_update_action";
    }

    /* renamed from: Mr */
    public boolean mo23626Mr() {
        return dOt.mo23626Mr();
    }

    /* renamed from: Ms */
    public boolean mo23627Ms() {
        return dOt.mo23627Ms();
    }

    /* renamed from: Mt */
    public boolean mo23628Mt() {
        return dOt.mo23628Mt();
    }

    /* renamed from: Mu */
    public boolean mo23629Mu() {
        return dOt.mo23629Mu();
    }

    /* renamed from: Mv */
    public boolean mo23630Mv() {
        return dOt.mo23630Mv();
    }

    /* renamed from: Mw */
    public boolean mo23631Mw() {
        return false;
    }

    /* renamed from: Mx */
    public boolean mo23632Mx() {
        return dOt.mo23632Mx();
    }

    /* renamed from: My */
    public void mo23633My() {
        dOt.mo23633My();
    }

    /* renamed from: Mz */
    public String mo23634Mz() {
        return dOt.mo23634Mz();
    }

    /* renamed from: a */
    public void mo23635a(Activity activity, int i, boolean z) {
        dOt.mo23635a(activity, i, z);
    }

    /* renamed from: a */
    public void mo23636a(Activity activity, OnClickListener onClickListener) {
        dOt.mo23636a(activity, onClickListener);
    }

    /* renamed from: a */
    public void mo23637a(Activity activity, String str, String str2) {
        dOt.mo23637a(activity, str, str2);
    }

    /* renamed from: a */
    public void mo23638a(Context context, ResultListener resultListener) {
        dOt.mo23638a(context, resultListener);
    }

    /* renamed from: a */
    public void mo23639a(C3635l<SparseArray<List<C7831d>>> lVar) {
        dOt.mo23639a(lVar);
    }

    /* renamed from: a */
    public void mo23640a(String str, double d, String str2) {
        dOt.mo23640a(str, d, str2);
    }

    /* renamed from: a */
    public void mo23641a(String str, String str2, BigDecimal bigDecimal, Currency currency) {
        dOt.mo23641a(str, str2, bigDecimal, currency);
    }

    /* renamed from: b */
    public void mo23642b(Activity activity, boolean z) {
        dOt.mo23642b(activity, true);
    }

    /* renamed from: b */
    public void mo23643b(C3635l<List<C7830c>> lVar) {
        dOt.mo23643b(lVar);
    }

    /* renamed from: d */
    public void mo23645d(Activity activity, int i) {
        dOt.mo23645d(activity, i);
    }

    /* renamed from: dD */
    public String mo23647dD(String str) {
        return dOt.mo23647dD(str);
    }

    /* renamed from: dE */
    public boolean mo23648dE(String str) {
        return dOt.mo23648dE(str);
    }

    /* renamed from: dF */
    public void mo23649dF(String str) {
        dOt.mo23649dF(str);
    }

    /* renamed from: dG */
    public boolean mo23650dG(String str) {
        return dOt.mo23650dG(str);
    }

    /* renamed from: e */
    public void mo23651e(Activity activity, int i) {
        dOt.mo23651e(activity, i);
    }

    public Application getApplication() {
        return dOt.getApplication();
    }

    public String getCountryCode() {
        return dOt.getCountryCode();
    }

    /* renamed from: h */
    public View mo23657h(ViewGroup viewGroup, int i) {
        return dOt.mo23657h(viewGroup, i);
    }

    /* renamed from: hc */
    public Map<String, String> mo23658hc(int i) {
        return dOt.mo23658hc(i);
    }

    public boolean isYoungerMode() {
        return dOt.isYoungerMode();
    }
}
