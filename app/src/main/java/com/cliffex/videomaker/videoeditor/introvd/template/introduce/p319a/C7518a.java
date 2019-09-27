package com.introvd.template.introduce.p319a;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager.BadTokenException;
import com.introvd.template.R;
import com.introvd.template.router.todoCode.BizAppTodoActionManager;
import com.introvd.template.router.todoCode.TODOParamModel;
import com.quvideo.mobile.component.imageview.DynamicLoadingImageView;

/* renamed from: com.introvd.template.introduce.a.a */
public class C7518a {

    /* renamed from: com.introvd.template.introduce.a.a$a */
    public static class C7520a {
        String dLK;
        String imgUrl;
        int todoCode;

        public C7520a(String str, int i, String str2) {
            this.imgUrl = str;
            this.todoCode = i;
            this.dLK = str2;
        }
    }

    /* renamed from: com.introvd.template.introduce.a.a$b */
    private static class C7521b extends Dialog {
        private final Activity bdz;
        private final C7520a dLL;

        private C7521b(Activity activity, C7520a aVar) {
            super(activity, R.style.xiaoying_style_com_dialog);
            this.dLL = aVar;
            this.bdz = activity;
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public /* synthetic */ void m22239a(TODOParamModel tODOParamModel, View view) {
            BizAppTodoActionManager.getInstance().executeTodo(this.bdz, tODOParamModel);
            dismiss();
        }

        /* access modifiers changed from: private */
        /* renamed from: cX */
        public /* synthetic */ void m22240cX(View view) {
            if (isShowing()) {
                dismiss();
            }
        }

        /* access modifiers changed from: protected */
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setContentView(R.layout.dialog_introduce_domestic);
            DynamicLoadingImageView dynamicLoadingImageView = (DynamicLoadingImageView) findViewById(R.id.dg_big_img);
            dynamicLoadingImageView.setImageURI(this.dLL.imgUrl);
            TODOParamModel tODOParamModel = new TODOParamModel();
            tODOParamModel.mTODOCode = this.dLL.todoCode;
            tODOParamModel.mJsonParam = this.dLL.dLK;
            dynamicLoadingImageView.setOnClickListener(new C7522b(this, tODOParamModel));
            findViewById(R.id.dg_close).setOnClickListener(new C7523c(this));
        }
    }

    /* renamed from: a */
    public static boolean m22236a(Activity activity, C7520a aVar, OnDismissListener onDismissListener) {
        if (activity == null || activity.isFinishing() || aVar == null || TextUtils.isEmpty(aVar.imgUrl)) {
            return false;
        }
        C7521b bVar = new C7521b(activity, aVar);
        bVar.setOnDismissListener(onDismissListener);
        boolean z = true;
        try {
            bVar.show();
        } catch (BadTokenException unused) {
            z = false;
        }
        return z;
    }
}
