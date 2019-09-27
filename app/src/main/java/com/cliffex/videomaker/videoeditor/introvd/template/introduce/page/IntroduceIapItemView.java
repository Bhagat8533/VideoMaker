package com.introvd.template.introduce.page;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.introvd.template.R;
import com.introvd.template.module.iap.C8049f;
import com.introvd.template.module.iap.C8058h;
import com.introvd.template.module.iap.p341b.C7738c;
import com.introvd.template.vivaiap.payment.C9054a;
import com.introvd.template.vivaiap.payment.PayResult;
import com.p131c.p132a.p135c.p136a.C2579b;
import com.p131c.p132a.p135c.p136a.C2579b.C2582a;
import p037b.p050b.C1850u;
import p037b.p050b.p051a.p053b.C1487a;
import p037b.p050b.p054b.C1495b;
import p464d.C9646b;
import p464d.p466b.p467a.C9649c;

public final class IntroduceIapItemView extends IntroduceItemView {
    /* access modifiers changed from: private */
    public String dLx;
    /* access modifiers changed from: private */
    public C1495b dLy;

    /* renamed from: com.introvd.template.introduce.page.IntroduceIapItemView$a */
    public static final class C7533a implements C9054a {
        final /* synthetic */ IntroduceIapItemView dLz;

        C7533a(IntroduceIapItemView introduceIapItemView) {
            this.dLz = introduceIapItemView;
        }

        /* renamed from: a */
        public void mo32328a(PayResult payResult) {
            if (payResult != null && payResult.isSuccess()) {
                Context context = this.dLz.getContext();
                if (!(context instanceof Activity)) {
                    context = null;
                }
                Activity activity = (Activity) context;
                if (activity != null) {
                    activity.finish();
                }
            }
        }
    }

    /* renamed from: com.introvd.template.introduce.page.IntroduceIapItemView$b */
    public static final class C7534b implements C1850u<String> {
        final /* synthetic */ IntroduceIapItemView dLz;

        C7534b(IntroduceIapItemView introduceIapItemView) {
            this.dLz = introduceIapItemView;
        }

        /* renamed from: a */
        public void mo9883a(C1495b bVar) {
            C9649c.m27672j(bVar, "d");
            this.dLz.dLy = bVar;
        }

        /* renamed from: dV */
        public void onSuccess(String str) {
            C9649c.m27672j(str, "goodsId");
            this.dLz.dLx = str;
            TextView textView = (TextView) this.dLz.findViewById(R.id.apply_btn);
            if (textView != null && (textView.getTag(R.id.glide_tag_id) instanceof Boolean)) {
                Object tag = textView.getTag(R.id.glide_tag_id);
                if (tag == null) {
                    throw new C9646b("null cannot be cast to non-null type kotlin.Boolean");
                } else if (((Boolean) tag).booleanValue()) {
                    this.dLz.azM();
                }
            }
        }

        public void onError(Throwable th) {
            C9649c.m27672j(th, "e");
        }
    }

    /* renamed from: com.introvd.template.introduce.page.IntroduceIapItemView$c */
    static final class C7535c<V> implements C2582a<View> {
        final /* synthetic */ TextView dLA;
        final /* synthetic */ IntroduceIapItemView dLz;

        C7535c(IntroduceIapItemView introduceIapItemView, TextView textView) {
            this.dLz = introduceIapItemView;
            this.dLA = textView;
        }

        public final void onClick(View view) {
            this.dLA.setTag(R.id.glide_tag_id, Boolean.valueOf(true));
            this.dLz.azM();
        }
    }

    public IntroduceIapItemView(Context context) {
        C9649c.m27672j(context, "context");
        super(context);
        getGoodsId();
    }

    /* access modifiers changed from: private */
    public final void azM() {
        if (this.dLx != null) {
            C7738c.aEv().mo32612a(getContext(), this.dLx, null, new C7533a(this));
        }
    }

    private final void getGoodsId() {
        if (this.dLy == null) {
            C8058h aBf = C8049f.aBf();
            C9649c.m27671i(aBf, "ModuleIapOutputHelper.getInstance()");
            aBf.aBq().mo10194f(C1487a.aUa()).mo10188a((C1850u<? super T>) new C7534b<Object>(this));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: Oj */
    public void mo32326Oj() {
        super.mo32326Oj();
        TextView textView = (TextView) findViewById(R.id.apply_btn);
        textView.setText(R.string.xiaoying_str_introduce_subscribe_and_use);
        C2579b.m7399a(new C7535c(this, textView), textView);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C1495b bVar = this.dLy;
        if (bVar != null) {
            bVar.dispose();
        }
    }
}
