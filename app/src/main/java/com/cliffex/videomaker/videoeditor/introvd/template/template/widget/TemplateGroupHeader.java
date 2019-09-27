package com.introvd.template.template.widget;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.sdk.model.template.TemplateInfo;
import com.introvd.template.template.R;
import com.introvd.template.template.model.TemplateGroupInfo;
import com.introvd.template.template.p407e.C8733e;
import com.introvd.template.template.p407e.C8739i;
import java.util.ArrayList;
import java.util.Iterator;

public class TemplateGroupHeader extends RelativeLayout {
    private RelativeLayout bSe;
    private TextView emD;
    private TextView erT;
    private TextView erU;
    private Context mContext;
    /* access modifiers changed from: private */
    public Handler mHandler;

    public TemplateGroupHeader(Context context) {
        super(context);
        this.mContext = context;
        initUI();
    }

    public TemplateGroupHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initUI();
    }

    public TemplateGroupHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        initUI();
    }

    private void initUI() {
        LayoutInflater.from(this.mContext).inflate(R.layout.template_group_header_layout, this, true);
        this.bSe = (RelativeLayout) findViewById(R.id.item_layout);
        this.emD = (TextView) findViewById(R.id.title);
        this.erU = (TextView) findViewById(R.id.titlecount);
        this.erT = (TextView) findViewById(R.id.btn_download);
    }

    public void setHandler(Handler handler) {
        this.mHandler = handler;
    }

    public void update(final int i) {
        TemplateGroupInfo vd = C8733e.aMa().mo35134vd(i);
        if (vd != null) {
            this.erU.setText(String.valueOf(vd.childList.size()));
            if (!TextUtils.isEmpty(vd.strGroupDisplayName)) {
                this.emD.setText(vd.strGroupDisplayName);
            }
        }
        this.erT.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                TemplateGroupInfo vd = C8733e.aMa().mo35134vd(i);
                if (vd != null && vd.childList != null) {
                    ArrayList arrayList = new ArrayList();
                    Iterator it = vd.childList.iterator();
                    while (it.hasNext()) {
                        TemplateInfo templateInfo = (TemplateInfo) it.next();
                        if (templateInfo.nState == 1 && !C8739i.m25527qr(templateInfo.ttid)) {
                            arrayList.add(templateInfo);
                        }
                    }
                    if (arrayList.size() > 0) {
                        TemplateGroupHeader.this.mHandler.sendMessage(TemplateGroupHeader.this.mHandler.obtainMessage(36871, arrayList));
                    }
                }
            }
        });
    }
}
