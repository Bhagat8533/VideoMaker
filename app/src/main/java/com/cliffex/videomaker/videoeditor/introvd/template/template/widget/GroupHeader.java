package com.introvd.template.template.widget;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.introvd.template.template.R;
import com.introvd.template.template.p407e.C8736g;
import com.introvd.template.template.p407e.C8736g.C8737a;

public class GroupHeader extends RelativeLayout {
    private RelativeLayout bSe;
    private TextView emD;
    private TextView erT;
    private TextView erU;
    private Context mContext;
    private Handler mHandler;

    public GroupHeader(Context context) {
        super(context);
        this.mContext = context;
        initUI();
    }

    public GroupHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initUI();
    }

    public GroupHeader(Context context, AttributeSet attributeSet, int i) {
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
        this.erT.setVisibility(4);
    }

    public void setHandler(Handler handler) {
        this.mHandler = handler;
    }

    public void update(int i) {
        C8737a vg = C8736g.aMg().mo35163vg(i);
        if (vg != null) {
            this.erU.setText(String.valueOf(vg.childList.size()));
            if (!TextUtils.isEmpty(vg.strGroupDisplayName)) {
                this.emD.setText(vg.strGroupDisplayName);
            }
        }
    }
}
