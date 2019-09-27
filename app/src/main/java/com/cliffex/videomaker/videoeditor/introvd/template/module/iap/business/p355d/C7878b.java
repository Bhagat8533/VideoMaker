package com.introvd.template.module.iap.business.p355d;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.aiii.android.arouter.p091c.C1919a;
import com.introvd.template.datacenter.SocialConstDef;
import com.introvd.template.module.iap.R;
import com.introvd.template.module.iap.business.p352b.C7835b;
import com.introvd.template.router.common.ICommonFuncRouter;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.p131c.p132a.C2570b;
import org.json.JSONObject;
import p464d.p466b.p467a.C9649c;

/* renamed from: com.introvd.template.module.iap.business.d.b */
public final class C7878b extends Dialog {
    /* access modifiers changed from: private */
    public final Context cUN;
    /* access modifiers changed from: private */
    public final int dST;
    /* access modifiers changed from: private */
    public final JSONObject jsonObject;

    /* renamed from: com.introvd.template.module.iap.business.d.b$a */
    static final class C7879a implements OnClickListener {
        final /* synthetic */ C7878b dSU;

        C7879a(C7878b bVar) {
            this.dSU = bVar;
        }

        public final void onClick(View view) {
            this.dSU.cancel();
        }
    }

    /* renamed from: com.introvd.template.module.iap.business.d.b$b */
    static final class C7880b implements OnClickListener {
        final /* synthetic */ C7878b dSU;
        final /* synthetic */ String dSV;

        C7880b(C7878b bVar, String str) {
            this.dSU = bVar;
            this.dSV = str;
        }

        public final void onClick(View view) {
            String str = "";
            int optInt = this.dSU.jsonObject.has(SocialConstDef.MESSAGE_LIST_NEW_EVENT_TYPE) ? this.dSU.jsonObject.optInt(SocialConstDef.MESSAGE_LIST_NEW_EVENT_TYPE) : -1;
            if (this.dSU.jsonObject.has(SocialConstDef.MESSAGE_LIST_NEW_EVENT_CONTENT)) {
                str = this.dSU.jsonObject.optString(SocialConstDef.MESSAGE_LIST_NEW_EVENT_CONTENT);
                C9649c.m27671i(str, "jsonObject.optString(\"eventContent\")");
            }
            ICommonFuncRouter iCommonFuncRouter = (ICommonFuncRouter) C1919a.m5529sc().mo10356i(ICommonFuncRouter.class);
            TODOParamModel tODOParamModel = new TODOParamModel();
            tODOParamModel.mTODOCode = optInt;
            tODOParamModel.mJsonParam = str;
            if (this.dSU.cUN instanceof Activity) {
                iCommonFuncRouter.executeTodo((Activity) this.dSU.cUN, tODOParamModel, null);
            }
            C7835b.m22867q(this.dSU.jsonObject.optString("id"), this.dSV, String.valueOf(this.dSU.dST));
            this.dSU.cancel();
        }
    }

    public C7878b(Context context, JSONObject jSONObject, int i) {
        C9649c.m27672j(context, "ctx");
        C9649c.m27672j(jSONObject, "jsonObject");
        super(context, R.style.vivavideo_iap_dialog_common_style);
        this.cUN = context;
        this.jsonObject = jSONObject;
        this.dST = i;
        setContentView(R.layout.iap_vip_dialog_vip_xit_operate);
        aod();
        setCancelable(false);
    }

    private final void aod() {
        findViewById(R.id.iv_close).setOnClickListener(new C7879a(this));
        C2570b.m7336hy(this.cUN).mo12195aO(this.jsonObject.optString("content")).mo12186g((ImageView) findViewById(R.id.iv_operate));
        String optString = this.jsonObject.optString("desc");
        View findViewById = findViewById(R.id.tv_content);
        C9649c.m27671i(findViewById, "findViewById<TextView>(R.id.tv_content)");
        ((TextView) findViewById).setText(optString);
        String optString2 = this.jsonObject.optString("title");
        View findViewById2 = findViewById(R.id.tv_title);
        C9649c.m27671i(findViewById2, "findViewById<TextView>(R.id.tv_title)");
        ((TextView) findViewById2).setText(optString2);
        findViewById(R.id.item_view).setOnClickListener(new C7880b(this, optString2));
    }

    public void show() {
        Window window = getWindow();
        if (window == null) {
            C9649c.aVp();
        }
        window.setGravity(17);
        LayoutParams attributes = window.getAttributes();
        Resources resources = this.cUN.getResources();
        C9649c.m27671i(resources, "ctx.resources");
        attributes.width = (int) (((double) resources.getDisplayMetrics().widthPixels) * 0.9d);
        attributes.height = -2;
        window.setAttributes(attributes);
        super.show();
        C7835b.m22866p(this.jsonObject.optString("id"), this.jsonObject.optString("title"), String.valueOf(this.dST));
    }
}
