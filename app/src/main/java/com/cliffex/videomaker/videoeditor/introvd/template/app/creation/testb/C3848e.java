package com.introvd.template.app.creation.testb;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.introvd.template.R;
import com.introvd.template.common.Constants;
import com.introvd.template.common.utils.UtilsDevice;
import com.introvd.template.p203b.C4583d;
import com.p131c.p132a.p133a.C2564c;
import com.p131c.p132a.p135c.p136a.C2579b;
import com.p131c.p132a.p135c.p136a.C2579b.C2582a;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.introvd.template.app.creation.testb.e */
public class C3848e extends Dialog {
    private static int bpA;
    private static int bpy;
    private static int bpz;
    /* access modifiers changed from: private */
    public C3853b bpB;
    private List<C3843b> bpC;
    private Bitmap bpD;
    private ImageView bpE;
    private ImageView bpF;
    /* access modifiers changed from: private */
    public ImageButton bpG;
    private LinearLayout bpH;
    private LinearLayout bpI;
    private Map<Integer, Integer> bpJ;
    private C3847d bpg;
    private Context mContext;

    /* renamed from: com.introvd.template.app.creation.testb.e$a */
    public static class C3852a {
        private OnDismissListener anh;
        private Bitmap bpD;
        private C3853b bpL;
        private List<C3843b> bpM;
        private Context context;

        /* renamed from: to */
        private boolean f3377to = true;

        public C3852a(Context context2) {
            this.context = context2;
        }

        /* renamed from: KS */
        public C3848e mo23382KS() {
            C3848e eVar = new C3848e(this.context);
            eVar.setCancelable(this.f3377to);
            eVar.setCanceledOnTouchOutside(this.f3377to);
            eVar.m9480a(this.bpL);
            eVar.m9478T(this.bpM);
            eVar.m9487o(this.bpD);
            eVar.setOnDismissListener(this.anh);
            eVar.show();
            return eVar;
        }

        /* renamed from: U */
        public C3852a mo23383U(List<C3843b> list) {
            this.bpM = list;
            return this;
        }

        /* renamed from: b */
        public C3852a mo23384b(OnDismissListener onDismissListener) {
            this.anh = onDismissListener;
            return this;
        }

        /* renamed from: b */
        public C3852a mo23385b(C3853b bVar) {
            this.bpL = bVar;
            return this;
        }

        /* renamed from: p */
        public C3852a mo23386p(Bitmap bitmap) {
            this.bpD = bitmap;
            return this;
        }
    }

    /* renamed from: com.introvd.template.app.creation.testb.e$b */
    public interface C3853b {
        /* renamed from: c */
        void mo23357c(C3843b bVar);
    }

    public C3848e(Context context) {
        this(context, R.style.custom_dialog_zoom_theme);
    }

    public C3848e(Context context, int i) {
        super(context, i);
        this.bpJ = new LinkedHashMap();
        this.bpg = new C3847d() {
            /* renamed from: c */
            public void mo23358c(C3843b bVar) {
                if (C3848e.this.bpB != null) {
                    C3848e.this.bpB.mo23357c(bVar);
                }
            }
        };
        setContentView(R.layout.creation_tool_dialog_layout);
        this.mContext = context;
        bpy = (int) context.getResources().getDimension(R.dimen.creation_subtool_normal_size);
        bpz = (int) context.getResources().getDimension(R.dimen.creation_subtool_small_size);
        bpA = (int) context.getResources().getDimension(R.dimen.creation_subtool_tiny_size);
        this.bpJ.put(Integer.valueOf(bpy), Integer.valueOf(context.getResources().getDimensionPixelSize(R.dimen.creation_subtool_normal_title_size)));
        this.bpJ.put(Integer.valueOf(bpz), Integer.valueOf(context.getResources().getDimensionPixelSize(R.dimen.creation_subtool_small_title_size)));
        this.bpJ.put(Integer.valueOf(bpA), Integer.valueOf(context.getResources().getDimensionPixelSize(R.dimen.creation_subtool_normal_tiny_size)));
        m9477KR();
    }

    /* renamed from: KR */
    private void m9477KR() {
        getWindow().getDecorView().setPadding(0, 0, 0, 0);
        LayoutParams attributes = getWindow().getAttributes();
        attributes.gravity = 17;
        attributes.width = -1;
        attributes.height = -1;
        getWindow().setBackgroundDrawable(new ColorDrawable());
        onWindowAttributesChanged(attributes);
        this.bpH = (LinearLayout) findViewById(R.id.container_column_1);
        this.bpI = (LinearLayout) findViewById(R.id.container_column_2);
        this.bpG = (ImageButton) findViewById(R.id.close_btn);
        this.bpE = (ImageView) findViewById(R.id.blur_bg);
        this.bpF = (ImageView) findViewById(R.id.alpha_bg);
        this.bpG.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C2564c.m7330dy(C3848e.this.bpG);
                C3848e.this.dismiss();
            }
        });
        C2579b.m7399a(new C2582a<View>() {
            public void onClick(View view) {
                C3848e.this.dismiss();
            }
        }, this.bpF);
    }

    /* access modifiers changed from: private */
    /* renamed from: T */
    public void m9478T(List<C3843b> list) {
        this.bpC = list;
        if (this.bpH != null && this.bpH.getChildCount() > 0) {
            this.bpH.removeAllViews();
        }
        if (this.bpI != null && this.bpI.getChildCount() > 0) {
            this.bpI.removeAllViews();
        }
        if (this.bpC.size() != 0) {
            int ii = C4583d.m11673ii(32);
            int P = C4583d.m11671P(40.0f);
            int gC = m9486gC(list.size());
            if (gC == bpy) {
                ii = C4583d.m11673ii(32);
                P = C4583d.m11671P(40.0f);
            } else if (gC == bpz) {
                ii = C4583d.m11673ii(26);
                P = C4583d.m11671P(36.0f);
            } else if (gC == bpA) {
                ii = C4583d.m11673ii(20);
                P = C4583d.m11671P(30.0f);
            }
            for (int i = 0; i < this.bpC.size(); i++) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.topMargin = i / 2 > 0 ? ii : 0;
                SubToolView subToolView = new SubToolView(this.mContext);
                subToolView.mo23319a((C3843b) this.bpC.get(i), this.bpg);
                if (i % 2 == 0) {
                    this.bpH.addView(subToolView, layoutParams);
                } else {
                    this.bpI.addView(subToolView, layoutParams);
                }
            }
            m9485bE(gC, ((Integer) this.bpJ.get(Integer.valueOf(gC))).intValue());
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.bpG.getLayoutParams();
            layoutParams2.addRule(12);
            layoutParams2.addRule(14);
            layoutParams2.bottomMargin = P;
            this.bpG.setLayoutParams(layoutParams2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m9480a(C3853b bVar) {
        this.bpB = bVar;
    }

    /* renamed from: bE */
    private void m9485bE(int i, int i2) {
        if (this.bpH.getChildCount() > 0) {
            for (int i3 = 0; i3 < this.bpH.getChildCount(); i3++) {
                ((SubToolView) this.bpH.getChildAt(i3)).mo23340bF(i, i2);
            }
        }
        if (this.bpI.getChildCount() > 0) {
            for (int i4 = 0; i4 < this.bpI.getChildCount(); i4++) {
                ((SubToolView) this.bpI.getChildAt(i4)).mo23340bF(i, i2);
            }
        }
    }

    /* renamed from: gC */
    private int m9486gC(int i) {
        int i2 = i / 2;
        if (i % 2 > 0) {
            i2++;
        }
        int i3 = 0;
        if (i2 > 1) {
            i3 = (i2 - 1) * C4583d.m11673ii(32);
        }
        int statusBarHeight = ((((Constants.getScreenSize().height - UtilsDevice.getStatusBarHeight(getContext())) - (C4583d.m11671P(120.0f) * 2)) - i3) / i2) - C4583d.m11671P(20.0f);
        return statusBarHeight >= bpy ? bpy : statusBarHeight > bpz ? bpz : bpA;
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public void m9487o(Bitmap bitmap) {
        this.bpD = bitmap;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void show() {
        super.show();
        if (this.bpD != null) {
            this.bpE.setVisibility(0);
            this.bpE.setImageBitmap(this.bpD);
            this.bpF.setBackgroundColor(getContext().getResources().getColor(R.color.white_p75));
            return;
        }
        this.bpE.setVisibility(8);
        this.bpF.setBackgroundColor(getContext().getResources().getColor(R.color.white_p95));
    }
}
