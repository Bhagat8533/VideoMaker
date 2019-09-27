package com.introvd.template.p414ui.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.introvd.template.p414ui.dialog.C8959f.C8961a;
import com.introvd.template.p414ui.dialog.C8966i.C8968a;
import xiaoying.quvideo.com.vivabase.C10122R;

/* renamed from: com.introvd.template.ui.dialog.g */
public class C8964g {
    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public static void m26324a(C8959f fVar) {
        C8961a aVar = fVar.ewN;
        aVar.ewW = C8966i.m26326a(aVar.context, C10122R.attr.md_positive_color, aVar.ewW);
        aVar.ewY = C8966i.m26326a(aVar.context, C10122R.attr.md_neutral_color, aVar.ewY);
        aVar.ewX = C8966i.m26326a(aVar.context, C10122R.attr.md_negative_color, aVar.ewX);
        aVar.amF = C8966i.m26326a(aVar.context, C10122R.attr.md_widget_color, aVar.amF);
        if (!aVar.anG) {
            aVar.amw = -570425344;
        }
        if (!aVar.anH) {
            aVar.amx = -1979711488;
        }
        fVar.alJ = (TextView) fVar.ewM.findViewById(C10122R.C10124id.title);
        fVar.amb = fVar.ewM.findViewById(C10122R.C10124id.titleFrame);
        fVar.alY = (TextView) fVar.ewM.findViewById(C10122R.C10124id.content);
        fVar.ewO = (MDButton) fVar.ewM.findViewById(C10122R.C10124id.buttonDefaultPositive);
        fVar.ewP = (MDButton) fVar.ewM.findViewById(C10122R.C10124id.buttonDefaultNeutral);
        fVar.ewQ = (MDButton) fVar.ewM.findViewById(C10122R.C10124id.buttonDefaultNegative);
        fVar.ewO.setVisibility(aVar.amz != null ? 0 : 8);
        fVar.ewP.setVisibility(aVar.amA != null ? 0 : 8);
        fVar.ewQ.setVisibility(aVar.amB != null ? 0 : 8);
        if (aVar.title == null) {
            fVar.amb.setVisibility(8);
        } else {
            fVar.alJ.setText(aVar.title);
            fVar.mo35610b(fVar.alJ, aVar.anc);
            fVar.alJ.setTextColor(aVar.amw);
            fVar.alJ.setGravity(aVar.ewU.mo35620qk());
            if (VERSION.SDK_INT >= 17) {
                fVar.alJ.setTextAlignment(aVar.ewU.getTextAlignment());
            }
        }
        if (fVar.alY != null && aVar.amy != null) {
            fVar.alY.setText(aVar.amy);
            fVar.alY.setMovementMethod(new LinkMovementMethod());
            fVar.mo35610b(fVar.alY, aVar.anb);
            fVar.alY.setLineSpacing(0.0f, aVar.amX);
            if (aVar.ewW == 0) {
                fVar.alY.setLinkTextColor(C8966i.m26334r(fVar.getContext(), 16842806));
            } else {
                fVar.alY.setLinkTextColor(aVar.ewW);
            }
            fVar.alY.setTextColor(aVar.amx);
            fVar.alY.setGravity(aVar.ewV.mo35620qk());
            if (VERSION.SDK_INT >= 17) {
                fVar.alY.setTextAlignment(aVar.ewV.getTextAlignment());
            }
        } else if (fVar.alY != null) {
            fVar.alY.setVisibility(8);
        }
        fVar.ewM.setButtonGravity(aVar.exb);
        fVar.ewM.setButtonStackedGravity(aVar.exa);
        fVar.ewM.setStackingBehavior(aVar.exd);
        boolean b = C8966i.m26331b(aVar.context, 16843660, true);
        if (b) {
            b = C8966i.m26331b(aVar.context, 16843660, true);
        }
        MDButton mDButton = fVar.ewO;
        fVar.mo35610b(mDButton, aVar.anc);
        mDButton.setAllCapsCompat(b);
        mDButton.setText(aVar.amz);
        mDButton.setTextColor(m26325x(aVar.context, aVar.ewW));
        fVar.ewO.setStackedSelector(fVar.mo35608a(C8968a.POSITIVE, true));
        fVar.ewO.setDefaultSelector(fVar.mo35608a(C8968a.POSITIVE, false));
        fVar.ewO.setTag(C8968a.POSITIVE);
        fVar.ewO.setOnClickListener(fVar);
        fVar.ewO.setVisibility(0);
        MDButton mDButton2 = fVar.ewQ;
        fVar.mo35610b(mDButton2, aVar.anc);
        mDButton2.setAllCapsCompat(b);
        mDButton2.setText(aVar.amB);
        mDButton2.setTextColor(m26325x(aVar.context, aVar.ewX));
        fVar.ewQ.setStackedSelector(fVar.mo35608a(C8968a.NEGATIVE, true));
        fVar.ewQ.setDefaultSelector(fVar.mo35608a(C8968a.NEGATIVE, false));
        fVar.ewQ.setTag(C8968a.NEGATIVE);
        fVar.ewQ.setOnClickListener(fVar);
        fVar.ewQ.setVisibility(0);
        MDButton mDButton3 = fVar.ewP;
        fVar.mo35610b(mDButton3, aVar.anc);
        mDButton3.setAllCapsCompat(b);
        mDButton3.setText(aVar.amA);
        mDButton3.setTextColor(m26325x(aVar.context, aVar.ewY));
        fVar.ewP.setStackedSelector(fVar.mo35608a(C8968a.NEUTRAL, true));
        fVar.ewP.setDefaultSelector(fVar.mo35608a(C8968a.NEUTRAL, false));
        fVar.ewP.setTag(C8968a.NEUTRAL);
        fVar.ewP.setOnClickListener(fVar);
        fVar.ewP.setVisibility(0);
        if (aVar.f3623zd != null) {
            FrameLayout frameLayout = (FrameLayout) fVar.ewM.findViewById(C10122R.C10124id.customViewFrame);
            View view = aVar.f3623zd;
            if (aVar.anl) {
                Resources resources = fVar.getContext().getResources();
                int dimensionPixelSize = resources.getDimensionPixelSize(C10122R.dimen.md_dialog_frame_margin);
                ScrollView scrollView = new ScrollView(fVar.getContext());
                int dimensionPixelSize2 = resources.getDimensionPixelSize(C10122R.dimen.md_content_padding_top);
                int dimensionPixelSize3 = resources.getDimensionPixelSize(C10122R.dimen.md_content_padding_bottom);
                scrollView.setClipToPadding(false);
                if (view instanceof EditText) {
                    scrollView.setPadding(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize3);
                } else {
                    scrollView.setPadding(0, dimensionPixelSize2, 0, dimensionPixelSize3);
                    view.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
                }
                scrollView.addView(view, new LayoutParams(-1, -2));
                view = scrollView;
            }
            frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -2));
        }
        fVar.mo35611qn();
    }

    /* renamed from: x */
    private static ColorStateList m26325x(Context context, int i) {
        int r = C8966i.m26334r(context, 16842806);
        if (i != 0) {
            r = i;
        }
        return new ColorStateList(new int[][]{new int[]{-16842910}, new int[0]}, new int[]{C8966i.m26333e(r, 0.4f), r});
    }
}
