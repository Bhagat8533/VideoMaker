package com.introvd.template.introduce.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.support.p021v4.view.ViewPager;
import android.support.p021v4.view.ViewPager.OnPageChangeListener;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.exoplayer2.extractor.p151ts.TsExtractor;
import com.introvd.template.R;
import com.introvd.template.introduce.C7517a;
import com.introvd.template.xyui.RoundedTextView;
import com.introvd.template.xyui.p421b.C9162a;
import com.introvd.template.xyui.viewpager.ViewPagerAdapter;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.introvd.template.introduce.dialog.a */
public class C7524a extends Dialog {
    private static int PAGE_SIZE;
    /* access modifiers changed from: private */
    public RoundedTextView cqq;
    private LinearLayout dLm;
    private TextView dLn;
    /* access modifiers changed from: private */
    public List<C7529b> dLo;
    /* access modifiers changed from: private */
    public C7517a dLp;
    /* access modifiers changed from: private */
    public int dLq;
    private OnPageChangeListener dLr;
    /* access modifiers changed from: private */

    /* renamed from: yH */
    public ViewPager f3554yH;

    /* renamed from: com.introvd.template.introduce.dialog.a$a */
    public static class C7528a {
        private OnDismissListener anh;
        private Context context;
        private List<C7529b> dLo;
        private C7517a dLp;

        /* renamed from: to */
        private boolean f3555to = false;

        public C7528a(Context context2, List<C7529b> list) {
            this.context = context2;
            this.dLo = list;
        }

        public C7524a azJ() {
            C7524a aVar = new C7524a(this.context);
            aVar.setCancelable(this.f3555to);
            aVar.setCanceledOnTouchOutside(this.f3555to);
            aVar.mo32311a(this.dLp);
            aVar.m22246aF(this.dLo);
            aVar.setOnDismissListener(this.anh);
            return aVar;
        }

        /* renamed from: b */
        public C7528a mo32315b(C7517a aVar) {
            this.dLp = aVar;
            return this;
        }

        /* renamed from: is */
        public C7528a mo32316is(boolean z) {
            this.f3555to = z;
            return this;
        }
    }

    public C7524a(Context context) {
        this(context, R.style.custom_dialog_zoom_theme);
    }

    public C7524a(Context context, int i) {
        super(context, i);
        this.dLq = -1;
        this.dLr = new OnPageChangeListener() {
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f, int i2) {
            }

            public void onPageSelected(int i) {
                if (C7524a.this.dLq != i) {
                    if (C7524a.this.dLo != null && i < C7524a.this.dLo.size()) {
                        if (((C7529b) C7524a.this.dLo.get(i)).getTodoCode() > 0) {
                            C7524a.this.cqq.setVisibility(0);
                        } else {
                            C7524a.this.cqq.setVisibility(4);
                        }
                    }
                    C7524a.this.m22252rJ(i);
                }
            }
        };
        setContentView(R.layout.xyui_dialog_introduce);
        m22242KR();
    }

    /* renamed from: KR */
    private void m22242KR() {
        Window window = getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        LayoutParams attributes = window.getAttributes();
        attributes.gravity = 80;
        attributes.width = -1;
        attributes.height = -1;
        window.setBackgroundDrawable(new ColorDrawable());
        onWindowAttributesChanged(attributes);
        this.dLm = (LinearLayout) findViewById(R.id.dot_container);
        this.f3554yH = (ViewPager) findViewById(R.id.viewPager);
        this.cqq = (RoundedTextView) findViewById(R.id.btnNext);
        this.dLn = (TextView) findViewById(R.id.btn_skip);
        this.dLn.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                C7524a.this.dismiss();
            }
        });
        this.cqq.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                int currentItem = C7524a.this.f3554yH.getCurrentItem();
                if (C7524a.this.dLo != null && currentItem < C7524a.this.dLo.size()) {
                    C7529b bVar = (C7529b) C7524a.this.dLo.get(currentItem);
                    if (C7524a.this.dLp != null && bVar.getTodoCode() > 0) {
                        C7524a.this.dLp.mo23600gW(bVar.getTodoCode());
                    }
                }
                C7524a.this.dismiss();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: aF */
    public void m22246aF(List<C7529b> list) {
        if (list != null && list.size() != 0) {
            this.dLo = list;
            PAGE_SIZE = list.size();
            azI();
            initViewPager();
            m22252rJ(0);
        }
    }

    private void azI() {
        if (PAGE_SIZE > 1) {
            this.dLm.removeAllViews();
            for (int i = 0; i < PAGE_SIZE; i++) {
                ImageView imageView = new ImageView(getContext());
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.width = C9162a.m26662O(getContext(), 8);
                layoutParams.height = C9162a.m26662O(getContext(), 8);
                if (i > 0) {
                    if (VERSION.SDK_INT >= 17) {
                        layoutParams.setMarginStart(C9162a.m26662O(getContext(), 10));
                    } else {
                        layoutParams.leftMargin = C9162a.m26662O(getContext(), 10);
                    }
                }
                imageView.setImageResource(R.drawable.introduce_pager_dot);
                this.dLm.addView(imageView, layoutParams);
            }
        }
    }

    /* renamed from: d */
    private int m22249d(TextView textView, String str) {
        if (TextUtils.isEmpty(str)) {
            return C9162a.m26662O(getContext(), 20);
        }
        TextPaint paint = textView.getPaint();
        return ((int) (paint.getFontMetrics().descent - paint.getFontMetrics().ascent)) * ((int) ((paint.measureText(str) / ((float) (C9162a.dQd - C9162a.m26662O(getContext(), 115)))) + 1.0f));
    }

    private void initViewPager() {
        ArrayList arrayList = new ArrayList();
        int O = C9162a.m26662O(getContext(), 36);
        for (int i = 0; i < PAGE_SIZE; i++) {
            C7529b bVar = (C7529b) this.dLo.get(i);
            IntroduceDialogView introduceDialogView = new IntroduceDialogView(getContext());
            introduceDialogView.mo32309a(bVar);
            arrayList.add(introduceDialogView);
            O = Math.max(O, m22249d(introduceDialogView.getTitleView(), bVar.getTitle()) + C9162a.m26662O(getContext(), 36));
        }
        int O2 = (((C9162a.eDQ - ((int) (((float) (C9162a.dQd - C9162a.m26662O(getContext(), 75))) * 1.1f))) - O) - C9162a.m26662O(getContext(), TsExtractor.TS_STREAM_TYPE_E_AC3)) / 2;
        ((RelativeLayout.LayoutParams) this.cqq.getLayoutParams()).bottomMargin = O2;
        ((RelativeLayout.LayoutParams) this.dLn.getLayoutParams()).bottomMargin = O2 - C9162a.m26662O(getContext(), 35);
        for (int i2 = 0; i2 < PAGE_SIZE; i2++) {
            ((RelativeLayout.LayoutParams) ((View) arrayList.get(i2)).findViewById(R.id.layoutContent).getLayoutParams()).topMargin = O2;
        }
        this.f3554yH.setAdapter(new ViewPagerAdapter(arrayList));
        this.f3554yH.addOnPageChangeListener(this.dLr);
    }

    /* access modifiers changed from: private */
    /* renamed from: rJ */
    public void m22252rJ(int i) {
        if (i >= 0 && i < PAGE_SIZE) {
            if (this.dLq >= 0 && this.dLq < PAGE_SIZE) {
                View childAt = this.dLm.getChildAt(this.dLq);
                if (childAt instanceof ImageView) {
                    ((ImageView) childAt).setImageResource(R.drawable.introduce_pager_dot);
                }
            }
            View childAt2 = this.dLm.getChildAt(i);
            if (childAt2 instanceof ImageView) {
                ((ImageView) childAt2).setImageResource(R.drawable.introduce_pager_dot_focus);
            }
            this.dLq = i;
        }
    }

    /* renamed from: a */
    public void mo32311a(C7517a aVar) {
        this.dLp = aVar;
    }
}
