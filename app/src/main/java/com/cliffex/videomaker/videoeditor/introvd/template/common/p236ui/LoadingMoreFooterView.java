package com.introvd.template.common.p236ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import xiaoying.quvideo.com.vivabase.C10122R;

/* renamed from: com.introvd.template.common.ui.LoadingMoreFooterView */
public class LoadingMoreFooterView extends LinearLayout {
    private TextView cfC;
    private TextView cfD;
    private Button cfE;
    private LinearLayout cfF;
    private View cfG;
    private int cfH;
    /* access modifiers changed from: private */
    public OnClickListener cfI;
    private Context mContext;
    private ProgressBar progressBar;
    private TextView textView;

    public LoadingMoreFooterView(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public LoadingMoreFooterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
    }

    private void init() {
        LayoutInflater.from(this.mContext).inflate(C10122R.C10126layout.xiaoying_com_loading_more_footer_view, this, true);
        this.cfF = (LinearLayout) findViewById(C10122R.C10124id.foot_view_layout);
        this.progressBar = (ProgressBar) findViewById(C10122R.C10124id.footer_loading);
        this.textView = (TextView) findViewById(C10122R.C10124id.footview_text);
        this.cfC = (TextView) findViewById(C10122R.C10124id.footview_text2);
        this.cfD = (TextView) findViewById(C10122R.C10124id.footview_text3);
        this.cfG = findViewById(C10122R.C10124id.viewGap);
        this.cfE = (Button) findViewById(C10122R.C10124id.footview_button);
        this.cfE.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                if (LoadingMoreFooterView.this.cfI != null) {
                    LoadingMoreFooterView.this.cfI.onClick(view);
                }
            }
        });
        setStatus(1);
    }

    public int getStatus() {
        return this.cfH;
    }

    public void setGapViewHeight(int i) {
        LayoutParams layoutParams = (LayoutParams) this.cfF.getLayoutParams();
        layoutParams.height = i;
        this.cfF.setLayoutParams(layoutParams);
        invalidate();
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.cfI = onClickListener;
        super.setOnClickListener(this.cfI);
    }

    public void setStatus(int i) {
        this.cfH = i;
        this.cfC.setVisibility(8);
        switch (i) {
            case 0:
                this.cfF.setVisibility(8);
                return;
            case 1:
                this.progressBar.setVisibility(8);
                this.cfE.setVisibility(8);
                this.textView.setVisibility(0);
                this.textView.setText(C10122R.string.xiaoying_str_template_msg_load_more_template);
                this.cfF.setVisibility(0);
                this.cfD.setVisibility(8);
                return;
            case 2:
                this.progressBar.setVisibility(0);
                this.cfE.setVisibility(8);
                this.textView.setVisibility(0);
                this.textView.setText(C10122R.string.xiaoying_str_com_pull_to_refresh_footer_refreshing_label);
                this.cfF.setVisibility(0);
                this.cfD.setVisibility(8);
                return;
            case 3:
                this.progressBar.setVisibility(8);
                this.cfE.setVisibility(8);
                this.textView.setVisibility(0);
                this.textView.setText(C10122R.string.xiaoying_str_com_msg_network_ioexception);
                this.cfF.setVisibility(0);
                this.cfD.setVisibility(8);
                return;
            case 4:
                this.progressBar.setVisibility(8);
                this.cfE.setVisibility(8);
                this.textView.setVisibility(8);
                this.cfC.setVisibility(0);
                this.cfD.setVisibility(8);
                this.cfC.setText(C10122R.string.xiaoying_str_community_load_finish_tip);
                this.cfF.setVisibility(0);
                return;
            case 5:
                this.progressBar.setVisibility(8);
                this.cfE.setVisibility(8);
                this.textView.setVisibility(8);
                this.cfC.setVisibility(8);
                this.cfD.setVisibility(8);
                this.cfF.setVisibility(0);
                return;
            case 6:
                this.progressBar.setVisibility(8);
                this.cfE.setVisibility(8);
                this.textView.setVisibility(8);
                this.cfC.setVisibility(8);
                this.cfD.setVisibility(0);
                this.cfD.setText(C10122R.string.xiaoying_str_community_load_finish_nomore_tip);
                this.cfF.setVisibility(0);
                return;
            default:
                return;
        }
    }
}
