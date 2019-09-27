package com.cliffex.videomaker.videoeditor.introvd.base.fulrryconfig;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import  com.introvd.base.fulrryconfig.MoreApp;
import com.introvd.base.fulrryconfig.ToolsAll;
public class DialogMoreAppsForRemote extends Dialog implements OnClickListener {
    private Button btn_ad_call_to_action;
    private ImageView btn_close_ads;
    private ImageView icon_ads;
    private ImageView imv_cover;
    /* access modifiers changed from: private */
    public Activity mContext;
    com.introvd.base.fulrryconfig.MoreApp moreApp;
    private TextView txt_shortdes_app;
    private TextView txt_title_app;

    public DialogMoreAppsForRemote(Activity context, MoreApp moreApp2) {
        super(context);
        this.mContext = context;
        this.moreApp = moreApp2;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        setContentView(com.introvd.base.fulrryconfig.ToolsAll.getIdLayout(this.mContext, "dialog_popup_more_apps_remote"));
        getWindow().setLayout(-1, -2);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        this.txt_title_app = (TextView) findViewById(ToolsAll.findViewId(this.mContext, "txt_title_app"));
        this.txt_shortdes_app = (TextView) findViewById(ToolsAll.findViewId(this.mContext, "txt_shortdes_app"));
        this.btn_ad_call_to_action = (Button) findViewById(ToolsAll.findViewId(this.mContext, "btn_ad_call_to_action"));
        this.icon_ads = (ImageView) findViewById(ToolsAll.findViewId(this.mContext, "icon_ads"));
        this.imv_cover = (ImageView) findViewById(ToolsAll.findViewId(this.mContext, "imv_cover"));
        this.btn_close_ads = (ImageView) findViewById(ToolsAll.findViewId(this.mContext, "btn_close_ads"));
        ToolsAll.setFontForTextView(this.mContext, this.txt_title_app);
        ToolsAll.setFontForTextView(this.mContext, this.txt_shortdes_app);
        ToolsAll.setFontForButon(this.mContext, this.btn_ad_call_to_action);
        setupMoreApps1(this.moreApp);
    }

    public void setupMoreApps1(final MoreApp myVideos) {
        this.txt_title_app.setText(myVideos.getName());
        this.txt_shortdes_app.setText(myVideos.getDes());
        Picasso.get().load(myVideos.getLinkBanner()).centerInside().resize(512, 512).into(this.imv_cover);
        Picasso.get().load(myVideos.getLinkIcon()).centerInside().resize(512, 512).into(this.icon_ads);
        this.btn_ad_call_to_action.setText("Install Now");
        this.imv_cover.setVisibility(0);
        this.btn_ad_call_to_action.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                ToolsAll.launchToMaketAppPro(DialogMoreAppsForRemote.this.mContext, myVideos.getPkm());
                DialogMoreAppsForRemote.this.dismiss();
            }
        });
        this.btn_close_ads.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                DialogMoreAppsForRemote.this.dismiss();
            }
        });
    }

    public void onClick(View v) {
    }
}
