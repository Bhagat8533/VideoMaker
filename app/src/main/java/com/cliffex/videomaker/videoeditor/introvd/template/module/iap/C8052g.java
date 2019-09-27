package com.introvd.template.module.iap;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.introvd.template.apicore.C3635l;
import com.introvd.template.common.ResultListener;
import com.introvd.template.module.C7571a;
import com.introvd.template.module.iap.business.p349a.p351b.C7830c;
import com.introvd.template.module.iap.business.p349a.p351b.C7831d;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import p037b.p050b.C1848s;

/* renamed from: com.introvd.template.module.iap.g */
public interface C8052g extends C7571a {
    /* renamed from: C */
    Drawable mo23605C(Drawable drawable);

    /* renamed from: IX */
    int mo23606IX();

    /* renamed from: K */
    void mo23608K(Activity activity);

    /* renamed from: MA */
    C1848s<JSONObject> mo23609MA();

    /* renamed from: MB */
    boolean mo23610MB();

    /* renamed from: MC */
    boolean mo23611MC();

    /* renamed from: MD */
    boolean mo23612MD();

    /* renamed from: ME */
    String mo23613ME();

    /* renamed from: MF */
    void mo23614MF();

    /* renamed from: MG */
    boolean mo23615MG();

    /* renamed from: MH */
    boolean mo23616MH();

    /* renamed from: Mi */
    boolean mo23618Mi();

    /* renamed from: Mm */
    void mo23621Mm();

    /* renamed from: Mo */
    void mo23623Mo();

    /* renamed from: Mp */
    String mo23624Mp();

    /* renamed from: Mq */
    String mo23625Mq();

    /* renamed from: Mr */
    boolean mo23626Mr();

    /* renamed from: Ms */
    boolean mo23627Ms();

    /* renamed from: Mt */
    boolean mo23628Mt();

    /* renamed from: Mu */
    boolean mo23629Mu();

    /* renamed from: Mv */
    boolean mo23630Mv();

    /* renamed from: Mw */
    boolean mo23631Mw();

    /* renamed from: Mx */
    boolean mo23632Mx();

    /* renamed from: My */
    void mo23633My();

    /* renamed from: Mz */
    String mo23634Mz();

    /* renamed from: a */
    void mo23635a(Activity activity, int i, boolean z);

    /* renamed from: a */
    void mo23636a(Activity activity, OnClickListener onClickListener);

    /* renamed from: a */
    void mo23637a(Activity activity, String str, String str2);

    /* renamed from: a */
    void mo23638a(Context context, ResultListener resultListener);

    /* renamed from: a */
    void mo23639a(C3635l<SparseArray<List<C7831d>>> lVar);

    /* renamed from: a */
    void mo23640a(String str, double d, String str2);

    /* renamed from: a */
    void mo23641a(String str, String str2, BigDecimal bigDecimal, Currency currency);

    /* renamed from: b */
    void mo23642b(Activity activity, boolean z);

    /* renamed from: b */
    void mo23643b(C3635l<List<C7830c>> lVar);

    /* renamed from: d */
    void mo23645d(Activity activity, int i);

    /* renamed from: dD */
    String mo23647dD(String str);

    /* renamed from: dE */
    boolean mo23648dE(String str);

    /* renamed from: dF */
    void mo23649dF(String str);

    /* renamed from: dG */
    boolean mo23650dG(String str);

    /* renamed from: e */
    void mo23651e(Activity activity, int i);

    Application getApplication();

    String getCountryCode();

    /* renamed from: h */
    View mo23657h(ViewGroup viewGroup, int i);

    /* renamed from: hc */
    Map<String, String> mo23658hc(int i);

    boolean isYoungerMode();
}
