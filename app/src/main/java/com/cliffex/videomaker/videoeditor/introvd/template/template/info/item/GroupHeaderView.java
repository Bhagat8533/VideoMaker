package com.introvd.template.template.info.item;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.template.R;
import com.introvd.template.template.model.TemplateGroupInfo;
import com.introvd.template.template.p407e.C8733e;
import com.introvd.template.template.p407e.C8739i;
import com.p131c.p132a.p133a.C2564c;
import com.p131c.p132a.p135c.p136a.C2579b;
import com.p131c.p132a.p135c.p136a.C2579b.C2582a;
import java.util.ArrayList;
import java.util.Iterator;

public class GroupHeaderView extends RelativeLayout {
    private TextView emD;
    private TextView erT;
    private TextView erU;
    private Context mContext;

    public GroupHeaderView(Context context) {
        this(context, null);
    }

    public GroupHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GroupHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        init();
    }

    private void init() {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.template_group_header_layout, this, true);
        this.emD = (TextView) inflate.findViewById(R.id.title);
        this.erU = (TextView) inflate.findViewById(R.id.titlecount);
        this.erT = (TextView) inflate.findViewById(R.id.btn_download);
    }

    /* renamed from: a */
    public void mo35421a(final int i, final C8908i iVar) {
        TemplateGroupInfo vd = C8733e.aMa().mo35134vd(i);
        if (vd != null) {
            this.erU.setText(String.valueOf(vd.childList.size()));
            if (!TextUtils.isEmpty(vd.strGroupDisplayName)) {
                this.emD.setText(vd.strGroupDisplayName);
            }
        }
        C2579b.m7399a(new C2582a<View>() {
            public void onClick(View view) {
                C2564c.m7327dA(view);
                TemplateGroupInfo vd = C8733e.aMa().mo35134vd(i);
                if (vd != null && vd.childList != null) {
                    ArrayList arrayList = new ArrayList();
                    Iterator it = vd.childList.iterator();
                    while (it.hasNext()) {
                        TemplateInfo templateInfo = (TemplateInfo) it.next();
                        if (templateInfo.nState == 1 && !C8739i.m25527qr(templateInfo.ttid)) {
                            arrayList.add(templateInfo.ttid);
                        }
                    }
                    if (arrayList.size() > 0 && iVar != null) {
                        iVar.mo35389cX(arrayList);
                    }
                }
            }
        }, this.erT);
    }
}
